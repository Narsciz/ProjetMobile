package com.objis.demojdbc;

import java.io.*;
import java.net.*;

public class Client {

static String serverIP="169.52.230.1";

static public String ask(String request) {
Socket s = null;
String response="";

// Create the socket connection to the MultiThreadedSocketServer port 11111
try {
s = new Socket(serverIP, 1111);
}
catch(UnknownHostException uhe) {
// Server Host unreachable
System.out.println("Unknown Host :" + serverIP);
s = null;
return "Unknown Host :" + serverIP;

}
catch(IOException ioe) {
// Cannot connect to port on given server host

System.out.println(ioe.getMessage());
s = null;
return "Cant connect to server at "+1111+". Make sure it is running.";

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

public static void main (String[] Args){
System.out.println(ask("blabla"));
}
}