package progmobile.coursenligne;

/**
 * Created by Millenium on 26/05/2017.
 */
import android.util.Log;

import java.net.*;
import java.io.*;
import java.security.spec.ECField;

import static android.content.ContentValues.TAG;

public class AskServer
{

    String serverIP="192.168.1.15";
    //String serverIP="169.254.238.178";
    int port=1111;


    AskServer(){

    }


    public String ask(String request) {


        Socket s = null;
        String response="";

        // Create the socket connection to the MultiThreadedSocketServer port 11111
        try {
            s = new Socket(serverIP, port);

        }
        catch(UnknownHostException uhe) {
            // Server Host unreachable
            s = null;

            return "Unknown Host :" + serverIP;

        }
        catch(IOException ioe) {
            // Cannot connect to port on given server host

            s = null;
            return ioe.getMessage();

        }
        catch(Exception e){
            return e.getMessage();
        }


        if(s == null)
            System.exit(-1);

        BufferedReader in = null;
        PrintWriter out = null;

        try {
            // Create the streams to send and receive information
            in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            out = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));

            // Since this is the askServer, we will initiate the talking.
            // Send a string data and flush
            out.println(request);
            out.flush();
            // Receive the reply.
            //System.out.println(in.readLine());
            response=in.readLine();

            // Send the special string to tell server to quit.
            out.println("Quit");
            out.flush();
        }
        catch(IOException ioe) {
            System.out.println("Exception during communication. Server probably closed connection.");
            return "Exception during communication. Server probably closed connection.";
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
                e.printStackTrace();
            }
        }
        return response;
    }
}

