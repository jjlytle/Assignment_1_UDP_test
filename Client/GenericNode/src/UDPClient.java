import java.io.*; 
import java.net.*; 

public class UDPClient 
{    
    public static void main(String args[])    
    {
        String serverIP = "localhost"; //127.0.0.1
        int port = 1234;
        try
        {
            DatagramSocket clientSocket = new DatagramSocket(0);
            //DatagramSocket clientSocket = new DatagramSocket();
            byte[] sendData = new byte[1024];   //store outgoing data.    
            byte[] receiveData = new byte[1024];  //store incoming data    
            //Amount of data = 65535 - 20 (IP Header) - 8 (UDP Header) = 65508 
            
            InetAddress serverAddress = InetAddress.getByName(serverIP);
            
            String stringSendData = "Hello Server!";
            sendData = stringSendData.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, port);
            clientSocket.send(sendPacket);
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(receivePacket);
            receiveData = receivePacket.getData();
            String stringReceiveData = new String(receiveData);
            System.out.println("FROM SERVER: " + stringReceiveData);
            clientSocket.close();
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
        
    } 
} 