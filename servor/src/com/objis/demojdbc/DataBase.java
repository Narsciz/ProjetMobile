package com.objis.demojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

import CommonClasses.*;

public class DataBase {
	private static final String url = "jdbc:mysql://localhost/coursenligne";
	private static final String login = "root";
	private static final String pwd = "";
	
	public void Database(){}	
	
	//Permet la connection avec la base de donn�e et la r�ception des donn�es voulues
	public int executeUpdate(String sql)
	{
		Connection cn = null;
		Statement st = null;
		int returnKey = -1;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			cn = DriverManager.getConnection(url, login, pwd);
					
			st = cn.createStatement();
			
			System.out.println("Execution de la requete : " + sql);
			
			returnKey = st.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
		}catch(SQLException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{
				cn.close();
				st.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return returnKey;
	}
	public Vector<String> executeQueryOnIntituleTable(String sql) throws SQLException
	{
		ResultSet rs = null;
		Connection cn = null;
		Statement st = null;
		Vector<String> res = new Vector<String>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			cn = DriverManager.getConnection(url, login, pwd);
					
			st = cn.createStatement();
			
			System.out.println("Execution de la requete : " + sql);
			
			rs = st.executeQuery(sql);
		}catch(SQLException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{
				
				while(rs.next())
				{
					res.add(rs.getString("Nom"));
				}
				cn.close();
				st.close();
				rs.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return res;
	}
	public Vector<Utilisateur> executeQueryOnUtilisateurTable(String sql) throws SQLException
	{
		ResultSet rs = null;
		Connection cn = null;
		Statement st = null;
		Vector<Utilisateur> res = new Vector<Utilisateur>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			cn = DriverManager.getConnection(url, login, pwd);
					
			st = cn.createStatement();
			
			System.out.println("Execution de la requete : " + sql);
			
			rs = st.executeQuery(sql);
		}catch(SQLException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{
				
				while(rs.next())
				{
					res.add(new Utilisateur(rs.getString("_idmail"), rs.getString("Nom"), rs.getString("Prenom"), rs.getBoolean("Etudiant"), rs.getString("MotDePasse"), Annee.valueOf(rs.getString("Annee"))));
				}
				cn.close();
				st.close();
				rs.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return res;
	}
	public Vector<Cours> executeQueryOnCoursTable(String sql)throws SQLException
	{
		ResultSet rs = null;
		Connection cn = null;
		Statement st = null;
		Vector<Cours> res = new Vector<Cours>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			cn = DriverManager.getConnection(url, login, pwd);
					
			st = cn.createStatement();
			
			System.out.println("Execution de la requete : " + sql);
			
			rs = st.executeQuery(sql);
		}catch(SQLException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{
				
				while(rs.next())
				{
					res.add(new Cours(rs.getInt("_id"), rs.getString("Intitule_id"), Matiere.valueOf(rs.getString("Matiere")), rs.getString("Nom"), Format.valueOf(rs.getString("Format")), rs.getString("Path"), null));
					res.lastElement().setAnneeAuthorisee(getAnneeAuthoriseeByCours(res.lastElement().getId()));
				}
				cn.close();
				st.close();
				rs.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return res;
	}
	public Vector<Integer> getCoursByAnneeAuthorisee(Annee annee)
	{
		String sql = "Select * From AnneeAuthorisee Where Annee = '" + annee.name() + "';";
		Vector<Integer> res = new Vector<Integer>();
		
		ResultSet rs = null;
		Connection cn = null;
		Statement st = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			cn = DriverManager.getConnection(url, login, pwd);
					
			st = cn.createStatement();
			
			System.out.println("Execution de la requete : " + sql);
			
			rs = st.executeQuery(sql);
		}catch(SQLException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{
				
				while(rs.next())
				{
					res.add(rs.getInt("Cours_id"));
				}
				cn.close();
				st.close();
				rs.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return res;
	}
	public Vector<Annee> getAnneeAuthoriseeByCours(int id)
	{
		String sql = "Select * From AnneeAuthorisee Where Annee = " + id + ";";
		Vector<Annee> res = new Vector<Annee>();
		
		ResultSet rs = null;
		Connection cn = null;
		Statement st = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			cn = DriverManager.getConnection(url, login, pwd);
					
			st = cn.createStatement();
			
			System.out.println("Execution de la requete : " + sql);
			
			rs = st.executeQuery(sql);
		}catch(SQLException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{
				
				while(rs.next())
				{
					res.add(Annee.valueOf(rs.getString("Annee")));
				}
				cn.close();
				st.close();
				rs.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return res;
	}
	
	//M�thode concernant la Table Intitule
	public void insertIntitule(String intitule, Matiere matiere)
	{
		String sql = "INSERT INTO Intitule(Matiere, Nom) Values ("
				+"'" + matiere.name() + "', "
				+"'" + intitule + "');";
		this.executeUpdate(sql);
	}
	public void deleteIntitule(String intitule)
	{
		String sql = "DELETE FROM Intitule WHERE Nom = '" + intitule + "';";
		this.executeUpdate(sql);
	}
	public Vector<String> getAllIntitule() throws SQLException
	{
		String sql = "Select Nom from Intitule;";
		return executeQueryOnIntituleTable(sql);
	}
	public Vector<String> getIntituleFromMatiere(Matiere matiere) throws SQLException
	{
		String sql = "Select Nom from Intitule where Matiere = '" + matiere.name() + "';";
		return executeQueryOnIntituleTable(sql);
	}
	
	//M�thode concernant la table Utilisaeur
	public void insertUtilisateur(Utilisateur utilisateur)
	{
		String sql = "INSERT INTO Utilisateur(_idmail, Nom, Prenom, Etudiant, MotDePasse, Annee) Values ("
				+"'" + utilisateur.getIdMail() +"', "
				+"'" + utilisateur.getNom() + "', "
				+"'" + utilisateur.getPrenom() + "', "
				+utilisateur.getEtudiant() + ", "
				+"'" + utilisateur.getMdp() + "', "
				+"'" + utilisateur.getAnnee().name() + "');";
		this.executeUpdate(sql);
	}
	public void deleteUtilisateur(Utilisateur utilisateur)
	{
		String sql = "DELETE FROM Utilisateur WHERE _idmail = '" + utilisateur.getIdMail() + "';";
		this.executeUpdate(sql);
	}
	public Vector<Utilisateur> getUtilisateursByAttributes(Vector<String> attribute, Vector<String> attributeValue) throws SQLException
	{
		String sql = "Select * from Utilisateur";
		
		for(int i = 0; i<attribute.size(); i++)
		{
			if(i>0)
			{sql += " and ";}
			
			switch(attribute.get(i))
			{
			case "" : break;
			case "_idmail" : sql += " where _idmail = '" + attributeValue + "'";
				 			 break;
			case "Nom" : sql += " where Nom = '" + attributeValue + "'";
			 			 break;
			case "Prenom" : sql += " where Prenom = '" + attributeValue + "'";
							break;
			case "Etudiant" : sql += " where Etudiant = " + attributeValue;
				 			break;
			case "MotDePasse" : sql += " where MotDePasse = '" + attributeValue + "'";
				 			    break;
			case "Annee" : sql += " where Annee = '" + attributeValue + "'";
			  	           break;
			}
		}
		
		sql += ";";
		return executeQueryOnUtilisateurTable(sql);
	}
	
	public void insertCours(Cours cours) throws SQLException
	{
		String sql = "INSERT INTO Cours(Intitule_id, Matiere, Nom, Format, Path) Values ("
				+"'" + cours.getIntitule() + "', "
				+"'" + cours.getMatiere().name() + "', "
				+"'" + cours.getNom() + "', "
				+"'" + cours.getFormat().name() + "', "
				+"'" + cours.getPath() + "');";
		int idCours = this.executeUpdate(sql);
		
		for(int i = 0; i<cours.getAnneeAuthorisee().size(); i++)
		{
			insertAnneeAuthorisee(idCours, cours.getAnneeAuthorisee().get(i));
		}
		
	}
	public void deleteCours(Cours cours)
	{
		String sql = "DELETE FROM Cours WHERE _id = '" + cours.getId() + "';";
		this.executeUpdate(sql);
	}
	public Vector<Cours> getCoursByAttributes(Vector<String> attribute, Vector<String> attributeValue) throws SQLException
	{
		String sql = "Select * from Cours";
		
		for(int i = 0; i<attribute.size(); i++)
		{
			if(i>0)
			{sql += " and ";}
			
			switch(attribute.get(i))
			{
			case "" : break;
			case "_id" : sql += " where _id = " + attributeValue;
				 			 break;
			case "Intitule" : sql += " where Intitule_id = '" + attributeValue + "'";
			 			 break;
			case "Matiere" : sql += " where Matiere = '" + attributeValue + "'";
							break;
			case "Nom" : sql += " where Nom = " + attributeValue;
				 			break;
			case "Format" : sql += " where Format = '" + attributeValue + "'";
				 			    break;
			case "Path" : sql += " where Path = '" + attributeValue + "'";
			  	           break;
			}
		}
		
		return executeQueryOnCoursTable(sql);
	}
	public Vector<Cours> getAllowedCours(Vector<Annee> annee) throws SQLException
	{
		Vector<Integer> coursId = new Vector<Integer>();
		
		for(int i = 0; i<annee.size(); i++)
		{
			coursId.addAll(this.getCoursByAnneeAuthorisee(annee.get(i)));
		}
		
		Vector<Cours> cours = new Vector<Cours>();
				
		for(int i = 0; i<coursId.size(); i++)
		{
			Vector<String> attribute = new Vector<String>();
			attribute.add("_id");
			Vector<String> attributeValue = new Vector<String>();
			attributeValue.add(coursId.get(i).toString());
			cours.addAll(getCoursByAttributes(attribute, attributeValue));
		}
		return cours;
	}
	
	public void insertAnneeAuthorisee(int idCours, Annee annee)
	{
		String sql = "INSERT INTO AnneeAuthorisee(Cours_id, Annee) Values ("
				+ idCours + ", "
				+"'" + annee.name() + "');"; 
		this.executeUpdate(sql);
	}
	public void deleteAnneeAuthorisee(int idCours)
	{
		String sql = "DELETE FROM AnneeAuthorisee WHERE Cours_id = '" + idCours + "';";
		this.executeUpdate(sql);
	}

	public void insertQCM(QCM qcm)
	{
		String sql = "INSERT INTO QCM(Matiere_id, Intitule_id, Utilisateur_id, Nom) Values ("
				+ "'" + qcm.getMatiere().name() + "', "
				+ "'" + qcm.getIntitule() + "', "
				+ "'" + qcm.getCreateur().getIdMail() + "', "
				+ "'" + qcm.getNom() + ");";
		int qcm_id = this.executeUpdate(sql);
		
		for(int i = 0; i<qcm.getQuestions().size(); i++)
		{
			insertQuestion(qcm.getQuestions().get(i), qcm_id);
		}
		for(int i = 0; i<qcm.getDestinataires().size(); i++)
		{
			insertQCMCandidat(qcm_id, qcm.getDestinataires().get(i).getIdMail());
		}
	}
	public void deleteQCM(QCM qcm)
	{
		String sql = "Delete From QCM where _id = " + qcm.getId() + ";";
		executeUpdate(sql);
		for(int i = 0; i < qcm.getQuestions().size(); i++)
		{
			deleteQuestion(qcm.getQuestions().get(i), qcm.getId());
		}
	}
	
	public void insertQuestion(Question question, int QCM_id)
	{
		String sql = "INSERT INTO Question(QCM_id, Texte) Values ("
				+ QCM_id + ", "
				+ "'" + question.getQuestion() + "', "
				+ ");"; 
		int question_id = this.executeUpdate(sql);
		
		Set<String> cles = question.getReponses().keySet();
		Iterator it = cles.iterator();
		while(it.hasNext())
		{
			insertReponse(QCM_id, question_id, it.next().toString(),  question.getReponses().get(it.next()));
		}
	}
	public void deleteQuestion(Question question, int QCM_id)
	{
		String sql = "Delete From Question Where _id = " + question.getId() + ";";
		executeUpdate(sql);
		deleteReponse(question.getId());
	}
	
	public void insertReponse(int QCM_id, int question_id, String texte, boolean vrai)
	{
		String sql = "INSERT INTO Reponse(QCM_id, Question_id, Texte, Vrai) Values ("
				+ QCM_id + ", "
				+ question_id + ", "
				+ "'" + texte + "', "
				+ vrai
				+ ");"; 
		this.executeUpdate(sql);
	}
	public void deleteReponse(int question_id)
	{
		String sql = "DELETE FROM Reponse WHERE Question_id = " + question_id + ";";
		this.executeUpdate(sql);
	}

	public void insertQCMCandidat(int qcm_id, String utilisateur_id)
	{
		String sql = "INSERT INTO QCMCandidat(QCM_id, Utilisateur_id) Values ("
				+ qcm_id + "' "
				+"'" + utilisateur_id + "');";
		this.executeUpdate(sql);
	}
	public void deleteQCMCandidat(int qcm_id, String utilisateur_id)
	{
		String sql = "DELETE FROM QCMCandidat WHERE QCM_id = " + qcm_id + "AND Utilisateur_id = '"+ utilisateur_id +"';";
		this.executeUpdate(sql);
	}
}