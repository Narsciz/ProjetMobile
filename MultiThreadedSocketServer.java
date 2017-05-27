package Server;
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


public class MultiThreadedSocketServer {

    ServerSocket myServerSocket;
    boolean ServerOn = true;


    public static void main (String[] args) 
    { 
        new MultiThreadedSocketServer();        
    } 


	private String ProcessRequest(String request) {
		String resultat="";
		switch(request){
		default:
			resultat="le serveur n'a pas pu traiter votre requete";
		}
		return resultat;
	} 
	
    public MultiThreadedSocketServer() 
    { 
        try 
        { 
            myServerSocket = new ServerSocket(11111); 
        } 
        catch(IOException ioe) 
        { 
            System.out.println("Could not create server socket on port 11111. Quitting."); 
            System.exit(-1); 
        } 




        Calendar now = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
        System.out.println("It is now : " + formatter.format(now.getTime()));

        try {
			System.out.println("Adresse ip du serveur : "+InetAddress.getLocalHost().getHostAddress());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



        // Successfully created Server Socket. Now wait for connections. 
        while(ServerOn) 
        {                        
            try 
            { 
                // Accept incoming connections. 
                Socket clientSocket = myServerSocket.accept(); 

                // accept() will block until a client connects to the server. 
                // If execution reaches this point, then it means that a client 
                // socket has been accepted. 

                // For each client, we will start a service thread to 
                // service the client requests. This is to demonstrate a 
                // Multi-Threaded server. Starting a thread also lets our 
                // MultiThreadedSocketServer accept multiple connections simultaneously. 

                // Start a Service thread 

                ClientServiceThread cliThread = new ClientServiceThread(clientSocket);
                cliThread.start(); 

            } 
            catch(IOException ioe) 
            { 
                System.out.println("Exception encountered on accept. Ignoring. Stack Trace :"); 
                ioe.printStackTrace(); 
            } 

        }

        try 
        { 
            myServerSocket.close(); 
            System.out.println("Server Stopped"); 
        } 
        catch(Exception ioe) 
        { 
            System.out.println("Problem stopping server socket"); 
            System.exit(-1); 
        } 



    } 


    class ClientServiceThread extends Thread 
    { 
        Socket myClientSocket;
        boolean m_bRunThread = true; 

        public ClientServiceThread() 
        { 
            super(); 
        } 

        ClientServiceThread(Socket s) 
        { 
            myClientSocket = s; 

        } 

        public void run() 
        {            
            // Obtain the input stream and the output stream for the socket 
            // A good practice is to encapsulate them with a BufferedReader 
            // and a PrintWriter as shown below. 
            BufferedReader in = null; 
            PrintWriter out = null; 

            // Print out details of this connection 
            System.out.println("Accepted Client Address - " + myClientSocket.getInetAddress().getHostName()); 

            try 
            {                                
                in = new BufferedReader(new InputStreamReader(myClientSocket.getInputStream())); 
                out = new PrintWriter(new OutputStreamWriter(myClientSocket.getOutputStream())); 

                // At this point, we can read for input and reply with appropriate output. 

                // Run in a loop until m_bRunThread is set to false 
                while(m_bRunThread) 
                {                    
                    // read incoming stream 
                    String clientCommand = in.readLine(); 
                    System.out.println("Client Says :" + clientCommand);

                    
                    if(!ServerOn) 
                    { 
                        // Special command. Quit this thread 
                        System.out.print("Server has already stopped"); 
                        out.println("Server has already stopped"); 
                        out.flush(); 
                        m_bRunThread = false;   

                    } 
                    String response=ProcessRequest(clientCommand);
                    out.println(response); 
                    out.flush();
                    m_bRunThread = false;   
                    System.out.print("Stopping client thread for client : "); 

                } 
            } 
            catch(Exception e) 
            { 
                e.printStackTrace(); 
            } 
            finally 
            { 
                // Clean up 
                try 
                {                    
                    in.close(); 
                    out.close(); 
                    myClientSocket.close(); 
                    System.out.println("...Stopped"); 
                } 
                catch(IOException ioe) 
                { 
                    ioe.printStackTrace(); 
                } 
            } 
        }



    } 
}