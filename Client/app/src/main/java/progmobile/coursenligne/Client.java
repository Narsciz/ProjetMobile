package progmobile.coursenligne;

/**
 * Created by Millenium on 26/05/2017.
 */
import java.net.*;
import java.io.*;

public class Client implements Runnable
{

    String serverIP="192.168.1.15";
    String request;
    String response="trop tot";

    String getResponse(){
        return response;
    }
    Client(String r){
        request=r;
    }

    @Override
    public void run() {
        Socket s = null;

        // Create the socket connection to the MultiThreadedSocketServer port 11111
        try
        {
            s = new Socket(serverIP, 11111);
        }
        catch(UnknownHostException uhe)
        {
            // Server Host unreachable
            System.out.println("Unknown Host :" + serverIP);
            s = null;
        }
        catch(IOException ioe)
        {
            // Cannot connect to port on given server host
            System.out.println("Cant connect to server at 11111. Make sure it is running.");
            s = null;
        }

        if(s == null)
            System.exit(-1);

        BufferedReader in = null;
        PrintWriter out = null;

        try
        {
            // Create the streams to send and receive information
            in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            out = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));

            // Since this is the client, we will initiate the talking.
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
        catch(IOException ioe)
        {
            System.out.println("Exception during communication. Server probably closed connection.");
        }
        finally
        {
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
    }
}