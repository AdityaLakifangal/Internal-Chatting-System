import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

public class ChatClientGUI_2 {
    private JFrame frame;
    private JTextArea chatArea;
    private JTextField inputField;
    private JButton sendButton;
    private Socket clientSocket;
    private DataInputStream inputStream;
    private DataOutputStream outputStream;

    public ChatClientGUI_2() {
        frame = new JFrame("Aditya Lakifangal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setBounds(900, 150, 400, 500);

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setBackground(Color.cyan);
        JScrollPane scrollPane = new JScrollPane(chatArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        inputField = new JTextField();
        sendButton = new JButton("Send");
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        JPanel inputPanel = new JPanel();
        inputPanel.setBackground(new Color(7, 94, 84));
        inputPanel.setLayout(new BorderLayout());
        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);

        frame.add(inputPanel, BorderLayout.SOUTH);

        try {
            clientSocket = new Socket("127.0.0.1", 2211); // Connect to the server
            inputStream = new DataInputStream(clientSocket.getInputStream());
            outputStream = new DataOutputStream(clientSocket.getOutputStream());

            // Start a thread to listen for incoming messages
            Thread receiveThread = new Thread(() -> {
                try {
                    while (true) {
                        String message = inputStream.readUTF();
                        chatArea.append("Rafan: " + message + "\n");
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });
            receiveThread.start();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        frame.setVisible(true);
    }

    private void sendMessage() {
        String message = inputField.getText();
        if (!message.isEmpty()) {
            try {
                outputStream.writeUTF(message);
                outputStream.flush();
                chatArea.append("You: " + message + "\n");
                inputField.setText("");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                LoginPage_2 loginpage = new LoginPage_2();
                loginpage.initialize();
            }
        });
    }
}
