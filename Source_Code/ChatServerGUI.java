import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChatServerGUI {
    private JFrame frame;
    private JTextArea chatArea;
    private ServerSocket serverSocket;
    private ArrayList<ClientHandler> clients = new ArrayList<>();

    public ChatServerGUI() {
        frame = new JFrame("Chat Application - Server");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setBounds(900, 150, 400, 500);

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        try {
            serverSocket = new ServerSocket(2211);
            chatArea.append("Server started. Waiting for clients...\n");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                chatArea.append("Client connected: " + clientSocket.getInetAddress() + "\n");

                ClientHandler clientHandler = new ClientHandler(clientSocket);
                clients.add(clientHandler);
                Thread clientThread = new Thread(clientHandler);
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ChatServerGUI();
            }
        });
    }

    class ClientHandler implements Runnable {
        private Socket clientSocket;
        private DataInputStream dis;

        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
            try {
                dis = new DataInputStream(clientSocket.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            try {
                while (true) {
                    String message = dis.readUTF();
                    chatArea.append("Client: " + message + "\n");

                    // Broadcast the message to all connected clients
                    for (ClientHandler client : clients) {
                        if (client != this) {
                            try {
                                DataOutputStream dos = new DataOutputStream(client.clientSocket.getOutputStream());
                                dos.writeUTF(message);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
