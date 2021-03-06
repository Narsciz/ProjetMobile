package com.objis.demojdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;

import CommonClasses.Annee;
import CommonClasses.Cours;
import CommonClasses.Format;
import CommonClasses.Matiere;
import CommonClasses.QCM;
import CommonClasses.Utilisateur;

public class MultiThreadedSocketServer {

	ServerSocket myServerSocket;
	boolean ServerOn = true;
	DataBase db;

	public static void main(String[] args) {
		new MultiThreadedSocketServer();
	}

	public String ProcessRequest(String request) {
		String resultat = "";
		String[] value = request.split(";");

		String switchValue = value[0].toLowerCase();

		switch (switchValue) {

		case "inscription":
			boolean reussi = true;
			try {
				db.insertUtilisateur(new Utilisateur(value[1], value[4],
						value[3], Boolean.valueOf(value[5]), value[2], Annee
								.valueOf(value[6])));
			} catch (Exception e) {
				System.out.println("Exception :" + e.getMessage());
				reussi = false;
			}
			resultat = "inscription;" + reussi;
			break;

		case "authentification":
			boolean connecte = true;
			resultat = "authentification";
			try {
				Vector<String> attribute = new Vector<String>();
				attribute.add("_idmail");
				attribute.add("MotDePasse");
				Vector<String> attributeValue = new Vector<String>();
				attributeValue.add(value[1]);
				attributeValue.add(value[2]);
				Vector<Utilisateur> utilisateurs = db
						.getUtilisateursByAttributes(attribute, attributeValue);
				if (utilisateurs.size() > 0) {
					Utilisateur utilisateur = utilisateurs.get(0);
					resultat += ";" + utilisateur.getPrenom() + ";"
							+ utilisateur.getNom() + ";"
							+ utilisateur.getEtudiant() + ";"
							+ utilisateur.getAnnee().name();
				} else {

					connecte = false;
				}
			} catch (Exception e) {
				System.out.println("Exception :" + e.getMessage());
				connecte = false;
			}
			if (!connecte)
				resultat += ";" + false;
			break;

		case "matiere":
			Vector<String> intitules = new Vector<String>();
			try {
				intitules = db.getIntituleFromMatiere(
						Matiere.valueOf(value[1]), Annee.valueOf(value[2]));
			} catch (Exception e) {
				System.out.println("Exception :" + e.getMessage());
			}
			resultat = "matiere";
			for (int i = 0; i < intitules.size(); i++) {
				resultat += ";" + intitules.get(i);
			}
			break;

		case "intitulecours":
			try {
				Vector<Cours> cours = new Vector<Cours>();
				Vector<String> attribute = new Vector<String>();
				attribute.add("Intitule_id");
				Vector<String> attributeValue = new Vector<String>();
				attributeValue.add(value[1]);
				cours = db.getCoursByAttributes(attribute, attributeValue);
				resultat = "intitulecours";
				for (int i = 0; i < cours.size(); i++) {
					resultat += ";" + cours.get(i).getNom() + "|"
							+ cours.get(i).getFormat().name() + "|"
							+ cours.get(i).getPath();
				}
			} catch (Exception e) {
				System.out.println("Exception :" + e.getMessage());
			}
			break;

		case "intituleqcm":
			Vector<QCM> qcm = new Vector<QCM>();
			try {
				Vector<String> attribute = new Vector<String>();
				attribute.add("Intitule_id");
				Vector<String> attributeValue = new Vector<String>();
				attributeValue.add(value[1]);
				qcm = db.getQCMByAttributes(attribute, attributeValue);
				resultat = "intituleqcm";
				for (int i = 0; i < qcm.size(); i++) {
					resultat += ";" + qcm.get(i).getNom() + "|"
							+ qcm.get(i).getId();
				}
			} catch (Exception e) {
				System.out.println("Exception :" + e.getMessage());
			}
			break;

		case "qcm":
			Vector<QCM> qcmget = new Vector<QCM>();
			try {
				Vector<String> attribute = new Vector<String>();
				attribute.add("_id");
				Vector<String> attributeValue = new Vector<String>();
				attributeValue.add(value[1]);
				qcmget = db.getQCMByAttributes(attribute, attributeValue);
				resultat = "qcm;" + qcmget.get(0).getCode();
			} catch (Exception e) {
				System.out.println("Exception :" + e.getMessage());
			}
			break;

		case "validerqcm":
			boolean validation = true;
			try {
				db.deleteQCMCandidat(Integer.parseInt(value[1]), value[2]);
			} catch (Exception e) {
				System.out.println("Exception :" + e.getMessage());
				validation = false;
			}
			resultat = "validerqcm;" + validation;
			break;

		case "qcmafaire":
			String sql = "Select QCM._id, Nom, Intitule_id, Code from QCM, QCMCandidat where QCM._id = QCM_id and Utilisateur_id = '"
					+ value[1] + "';";
			try {
				Vector<QCM> qcms = db.executeQueryOnQCMTable(sql);
				resultat = "qcmafaire";
				for (int i = 0; i < qcms.size(); i++) {
					resultat += ";" + qcms.get(i).getNom() + "|"
							+ qcms.get(i).getId();
				}
			} catch (Exception e) {
				System.out.println("Exception :" + e.getMessage());
			}
			break;

		case "creationqcm":
			QCM qcmInsert = new QCM(-1, value[1], value[2], value[3]);

			if (value.length > 4) {
				String[] qcmCandidat = value[4].split("\\|");

				Vector<String> usersCandidat = new Vector<String>();
				for (int i = 0; i < qcmCandidat.length; i++) {
					usersCandidat.add(qcmCandidat[i]);
				}
				qcmInsert.setDestinataires(usersCandidat);
			}
			boolean insertQCM = true;
			try {
				db.insertQCM(qcmInsert);
			} catch (Exception e) {
				System.out.println("Exception :" + e.getMessage());
				insertQCM = false;
			}
			resultat = "creationqcm;" + insertQCM;
			break;

		case "creationcours":
			Cours coursinsert = new Cours(-1, value[2], value[1],
					Format.valueOf(value[3]), value[4]);
			boolean insertCours = true;
			try {
				db.insertCours(coursinsert);
			} catch (Exception e) {
				System.out.println("Exception :" + e.getMessage());
				insertCours = false;
			}
			resultat = "creationcours;" + insertCours;
			break;

		case "getusers":
			String sqlUser = "Select _idMail, Nom, Prenom, Etudiant, MotDePasse, Utilisateur.Annee from Utilisateur, AnneeAuthorisee where (Utilisateur.Annee = AnneeAuthorisee.Annee or AnneeAuthorisee.Annee = 'None') and Intitule_id = '"
					+ value[1] + "';";
			try {
				Vector<Utilisateur> users = db
						.executeQueryOnUtilisateurTable(sqlUser);
				resultat = "getusers";
				for (int i = 0; i < users.size(); i++) {
					resultat += ";" + users.get(i).getIdMail() + "|"
							+ users.get(i).getNom() + "|"
							+ users.get(i).getPrenom();
				}
			} catch (Exception e) {
				System.out.println("Exception :" + e.getMessage());

			}
			break;

		case "echo":
			resultat = "echo;Serveur a bien recu " + request;
			break;
		default:
			resultat = "Type de requete inconnu";
			break;
		}

		return resultat;
	}

	public MultiThreadedSocketServer() {
		db = new DataBase();

		try {
			myServerSocket = new ServerSocket(1111);
		} catch (IOException ioe) {
			System.out
					.println("Could not create server socket on port 1111. Quitting.");
			System.exit(-1);
		}

		Calendar now = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat(
				"E yyyy.MM.dd 'at' hh:mm:ss a zzz");
		System.out.println("It is now : " + formatter.format(now.getTime()));

		try {
			System.out.println("Adresse ip du serveur : "
					+ InetAddress.getLocalHost().getHostAddress());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Successfully created Server Socket. Now wait for connections.
		while (ServerOn) {
			try {
				// Accept incoming connections.
				Socket clientSocket = myServerSocket.accept();

				// accept() will block until a client connects to the server.
				// If execution reaches this point, then it means that a client
				// socket has been accepted.

				// For each client, we will start a service thread to
				// service the client requests. This is to demonstrate a
				// Multi-Threaded server. Starting a thread also lets our
				// MultiThreadedSocketServer accept multiple connections
				// simultaneously.

				// Start a Service thread

				ClientServiceThread cliThread = new ClientServiceThread(
						clientSocket);
				cliThread.start();

			} catch (IOException ioe) {
				System.out
						.println("Exception encountered on accept. Ignoring. Stack Trace :");
				ioe.printStackTrace();
			}

		}

		try {
			myServerSocket.close();
			System.out.println("Server Stopped");
		} catch (Exception ioe) {
			System.out.println("Problem stopping server socket : "
					+ ioe.getMessage());
			System.exit(-1);
		}

	}

	class ClientServiceThread extends Thread {
		Socket myClientSocket;
		boolean m_bRunThread = true;

		public ClientServiceThread() {
			super();
		}

		ClientServiceThread(Socket s) {
			myClientSocket = s;

		}

		@Override
		public void run() {
			// Obtain the input stream and the output stream for the socket
			// A good practice is to encapsulate them with a BufferedReader
			// and a PrintWriter as shown below.
			BufferedReader in = null;
			PrintWriter out = null;

			try {
				in = new BufferedReader(new InputStreamReader(
						myClientSocket.getInputStream()));
				out = new PrintWriter(new OutputStreamWriter(
						myClientSocket.getOutputStream()));

				// Run in a loop until m_bRunThread is set to false
				// while (m_bRunThread) {
				// read incoming stream
				String clientCommand = in.readLine();
				System.out.println("Client Says :" + clientCommand);

				String response = ProcessRequest(clientCommand);
				System.out.println("Server response : " + response);
				out.println(response);
				out.flush();
				// m_bRunThread = false;
				// System.out.print("Stopping client thread for client : ");

				// }
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				// Clean up
				try {
					in.close();
					out.close();
					myClientSocket.close();
					// System.out.println("...Stopped");
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
			}
		}

	}
}