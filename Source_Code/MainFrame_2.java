
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame_2 extends JFrame {

    public void initialize(User user) {
        JFrame frame = new JFrame("Chat Application");

        JLabel label = new JLabel("Welcome to the chat application");
        label.setHorizontalAlignment(JLabel.CENTER);

        JButton okbutton = new JButton("OK");

        okbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                frame.dispose();
            }
        });

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(label, BorderLayout.CENTER);
        panel.add(okbutton, BorderLayout.SOUTH);
        panel.setBackground(new Color(102, 255, 102));

        frame.add(panel);
        // frame.add(label);
        // frame.setSize(400, 200);

        frame.setBounds(900, 325, 400, 200);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }
}
