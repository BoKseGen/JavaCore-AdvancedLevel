package anotherAttempt;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

    private static final String SERVER_ADDR = "localhost";
    private static final int SERVER_PORT = 8200;
    private static final String stopWord = "stop";

    private static Scanner consoleReader = new Scanner(System.in);
    private static Socket clientSocket;
    private static BufferedReader in;
    private static PrintWriter out;

    public static void main(String[] args){
        startClient();
    }

    private static void startClient(){

        try {
            clientSocket = new Socket(SERVER_ADDR, SERVER_PORT);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintWriter(clientSocket.getOutputStream());

            sendMessageToServer(out, consoleReader); //поток для отправки сообщений
            readMessageFromServer(in);

        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally { // в любом случае необходимо закрыть сокет и потоки
            try {
                in.close();
                out.close();
                clientSocket.close();
//                consoleReader.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            System.out.println("You've been disconnected from server");
        }
    }

    private static void sendMessageToServer(PrintWriter out, Scanner consoleReader){
        Thread writeToServer = new Thread(() -> {
            String messageToServer;
            while(true){
                messageToServer = consoleReader.nextLine();
                out.println(messageToServer);
                out.flush();
            }
        });
        writeToServer.setDaemon(true);
        writeToServer.start();
    }

    private static void readMessageFromServer(BufferedReader in){
        String serverMessage = "";
        try {
            while ((serverMessage = in.readLine()) != null) {
                if (serverMessage.equalsIgnoreCase(stopWord)){
                    break;
                }
                System.out.println("Message from server : " + serverMessage);
            }
        } catch (IOException ioException){
            ioException.printStackTrace();
        }
    }
}
