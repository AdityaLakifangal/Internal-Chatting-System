import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// MainFrame_1 class extends JFrame to create a graphical user interface for a chat application.
public class MainFrame_1 extends JFrame {

    // Method to initialize the chat application GUI, takes a User object as a parameter.
    public void initialize(User user) {
        // Creating a new JFrame for the chat application.
        JFrame frame = new JFrame("Chat Application");

        // Creating a JLabel to display a welcome message.
        JLabel label = new JLabel("Welcome to the chat application");
        // Setting the horizontal alignment of the label to center.
        label.setHorizontalAlignment(JLabel.CENTER);

        // Creating an "OK" button using JButton.
        JButton okbutton = new JButton("OK");

        // Adding an ActionListener to the "OK" button to handle button click events.
        okbutton.addActionListener(new ActionListener() {
            // actionPerformed method to be executed when the button is clicked.
            public void actionPerformed(ActionEvent ae) {
                // Disposing the frame when the button is clicked.
                frame.dispose();
            }
        });

        // Creating a JPanel with BorderLayout to organize components.
        JPanel panel = new JPanel(new BorderLayout());
        // Adding the label to the center of the panel.
        panel.add(label, BorderLayout.CENTER);
        // Adding the "OK" button to the bottom of the panel.
        panel.add(okbutton, BorderLayout.SOUTH);
        // Setting the background color of the panel.
        panel.setBackground(new Color(102, 255, 102));

        // Adding the panel to the frame.
        frame.add(panel);
        // Setting the position and size of the frame.
        frame.setBounds(200, 325, 400, 200);
        // Setting the default close operation for the frame.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Making the frame visible.
        frame.setVisible(true);
    }
}