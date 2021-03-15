package anotherAttempt;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    private static final int SERVER_PORT = 8200;
    private static final String stopWord = "stop";

    private static Socket client;
    private static BufferedReader in;
    private static PrintWriter out;
    private static Scanner consoleReader = new Scanner(System.in);;

    public static void main(String[] args){
        startServer();
    }

    private static void startServer() {
        try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {
            System.out.println("Server is listening");
            //пытаемся подключить клиента
            try {
                client = serverSocket.accept();
                in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                out = new PrintWriter(client.getOutputStream());

                //если мы оказались в этом блоке, значит клиент к серверу подключился
                System.out.println("Client is connected");
                //отправляем первое сообщение клиенту
                out.println("Hello, client");
                out.flush();

                sendMessageToClient(out, consoleReader); //поток для отправки сообщений
                readMessageFromClient(in);

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            try {
//                consoleReader.close();
                in.close();
                out.close();
                client.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            System.out.println("Client was disconnected from server");
        }
    }

        private static void sendMessageToClient(PrintWriter out, Scanner scanner){
        Thread writeClientThread = new Thread(() -> {
            String messageToClient;
            while(true){
                messageToClient = scanner.nextLine();
                out.println(messageToClient);
                out.flush();
            }
        });
        writeClientThread.setDaemon(true); //чтоб поток завершился одновременно с основным
        writeClientThread.start();
    }

    private static void readMessageFromClient(BufferedReader in){
        String clientMessage = "";
        try {
            while ((clientMessage = in.readLine()) != null) {
                if (clientMessage.equalsIgnoreCase(stopWord)){
                    break;
                }
                System.out.println("Message from client : " + clientMessage);
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            System.out.println("Client decided to disconnect");
        }
    }

}
