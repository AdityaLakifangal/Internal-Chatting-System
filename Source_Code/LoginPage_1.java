import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class LoginPage_1 extends JFrame {
    final private Font mainFont = new Font("Segoe print", Font.BOLD, 18);
    JTextField tfuserid;
    JPasswordField pfPassword;

    public void initialize() {
        /*************** page Panel ***************/
        JLabel lbLoginpage = new JLabel("Login page", SwingConstants.CENTER);
        lbLoginpage.setFont(mainFont);

        JLabel lbEmail = new JLabel("User ID");
        lbEmail.setFont(mainFont);

        tfuserid = new JTextField();
        tfuserid.setFont(mainFont);

        JLabel lbPassword = new JLabel("Password");
        lbPassword.setFont(mainFont);

        pfPassword = new JPasswordField();
        pfPassword.setFont(mainFont);

        JPanel pagePanel = new JPanel();
        pagePanel.setLayout(new GridLayout(0, 1, 10, 10));
        pagePanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        pagePanel.add(lbLoginpage);
        pagePanel.add(lbEmail);
        pagePanel.add(tfuserid);
        pagePanel.add(lbPassword);
        pagePanel.add(pfPassword);
        pagePanel.setBackground(new Color(0, 150, 255));
        

        /*************** Buttons Panel ***************/
        JButton btnLogin = new JButton("Login");
        btnLogin.setFont(mainFont);
        btnLogin.setBackground(new Color(0, 255, 255));
        btnLogin.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // Auto-generated method stub
                String UserID = tfuserid.getText();
                String Password = String.valueOf(pfPassword.getPassword());

                User user = getAuthenticatedUser(UserID, Password);

                if (user != null) {
                    new ChatClientGUI_1();
                    MainFrame_1 mainFrame = new MainFrame_1();
                    mainFrame.initialize(user);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(LoginPage_1.this,
                            "Email or Password Invalid",
                            "Try again",
                            JOptionPane.ERROR_MESSAGE);
                }
            }

        });

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setFont(mainFont);
        btnCancel.setBackground(new Color(0,255,255));
        btnCancel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // Auto-generated method stub
                dispose();
            }

        });


        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1, 2, 10, 0));
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        buttonsPanel.add(btnLogin);
        buttonsPanel.add(btnCancel);
        buttonsPanel.setBackground(new Color(65, 105, 255));   
        /*************** Initialise the frame ***************/
        add(pagePanel, BorderLayout.NORTH);
        add(buttonsPanel, BorderLayout.SOUTH);

        setTitle("Login page");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(400, 500);
        setMinimumSize(new Dimension(350, 450));
        // setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private User getAuthenticatedUser(String UserID, String Password) {
        User user = null;

        final String DB_URL = "jdbc:mysql://localhost:3306/chatting_application";
        final String USERNAME = "root";
        final String PASSWORD = "root";

        try {
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            // Connected to database successfully...

            String sql = "SELECT * FROM login_info WHERE UserID=? AND Password=?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, UserID);
            preparedStatement.setString(2, Password);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                user = new User();
                user.UserID = resultSet.getString("UserID");
                user.Password = resultSet.getString("Password");
            }

            preparedStatement.close();
            conn.close();

        } catch (Exception e) {
            System.out.println("Database connexion failed!");
        }

        return user;
    }

    public static void main(String[] args) {

    }
}
