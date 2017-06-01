package progmobile.coursenligne;

/**
 *  AskServer est le client, son seul role est de se connecter avec le serveur et de récupérer
 *  sa réponse
 */
import android.util.Log;

import java.net.*;
import java.io.*;
import java.security.spec.ECField;

import static android.content.ContentValues.TAG;

public class AskServer
{

    static String serverIP="192.168.1.15";
    //static String serverIP="169.254.238.178";
    static int port=1111;
    static boolean serveurMarchePas=false; // true = lancement sans le serveur


    AskServer(){

    }

    static void setServerIP(String ip){
        serverIP=ip;
    }

    public String ask(String request) {

        if (serveurMarchePas)
            return navigateWithoutServer(request);
        Socket s = null;
        String response="";

        try {
            s = new Socket(serverIP, port);
        }
        catch(UnknownHostException uhe) {
            return "Unknown Host :" + serverIP;
        }
        catch(IOException ioe) {
            return "IOException :"+ioe.getMessage();
        }
        catch(Exception e){
            return "Exception+"+e.getMessage();
        }

        BufferedReader in = null;
        PrintWriter out = null;

        try {
            // Create the streams to send and receive information
            in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            out = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));

            //Envoi de la requete au serveur
            out.println(request);
            out.flush();
            // Reception de la reponse
            response=in.readLine();
        }
        catch(IOException ioe) {
            return "Exception :"+ioe.getMessage();
        }
        finally {
            try
            {
                // Close the input and output streams
                out.close();
                in.close();
                // Close the socket before quitting
                s.close();
            }
            catch(Exception e)
            {
                return "Exception :"+e.getMessage();
            }
        }
        return response;
    }

    static void setServeurMarchePas(boolean b){
        serveurMarchePas=b;
    }
    private String navigateWithoutServer(String request) {
        String resultat = "";
        String[] r = request.split(";");

        String switchValue=r[0].toLowerCase();
        switch (switchValue) {
            case "authentification":
                resultat = "authentification;sacha;weill;false;none";
                break;
            case "inscription":
                resultat = "inscription;true";
                break;
            case "matiere":
                resultat = "matiere;HMIN207;HMMA504;HLIN222";
                break;
            case "intitulecours":
                resultat = "intitulecours;coursVideo|video|vt1Pwfnh5pc;coursPdf|pdf|http://www.buyya.com/java/Chapter13.pdf";
                break;
            case "intituleqcm":
                resultat = "intituleqcm;Qcm1|1;Qcm2|2";
                break;
            case "qcm":
                resultat = "qcm;2+2|5@false&4@true$couleur du cheval blanc de Henry IV|Blanc@false&Noir@true&Rose@false";
                break;
            case "qcmafaire":
                resultat = "qcmafaire;Qcm à faire 1|123;Qcm à faire 2|157";
                break;
            case "getusers":
                resultat = "getusers;54|nom1|prenom1;78|nom2|prenom2";
                break;
            case "validerqcm":
            case "creationqcm":
            case "creationcours":
                resultat="validerqcm;true";
                break;

            case "echo":
                resultat="Le serveur est désactivé";
                break;
            default:
                resultat = "requete inconnue";
        }
        return resultat;
    }
}

