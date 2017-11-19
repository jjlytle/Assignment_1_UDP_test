import java.io.*; 
import java.net.*; 


class UDPServer {    
    public static void main(String args[]) throws Exception       
    {   
        int port = 1234;
        try
        {
            DatagramSocket socket = new DatagramSocket(port);
            byte[] receiveData = new byte[1024];             
            byte[] sendData = new byte[1024];
            System.out.println("Waiting for UDP packet on port: " + port);
            while(true)
            {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);
                String sentence = new String(receivePacket.getData());
                System.out.println("RECEIVED " + sentence);
                String stringData = "hello client!";
                sendData = stringData.getBytes();
                InetAddress clientIpAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientIpAddress, clientPort);
                socket.send(sendPacket);
                
            }
        }       
        catch(Exception e)
        {
           System.out.println(e.toString());     
        }
                
    } 
} 