package gui;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class Login
{
    public Login()
    {
        JFrame frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setSize(1000, 1000);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints(); //NOTE TO SELF - gridlayout and boxlayout does not work with a login window, use gridbaglayout instead, FlowLayout it always stays at the top

        // Get and resize the logo
        ImageIcon image = new ImageIcon(getClass().getClassLoader().getResource("resources/Logo.jpg"));
        image = new ImageIcon(image.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));

        gbc.insets = new Insets(10, 10, 10, 10); // Padding
        gbc.fill = GridBagConstraints.HORIZONTAL; // Make that the GUI.Login button fill horizontally

        gbc.gridwidth = 2; // span 2 columns

        // Logo Label
        gbc.gridx = 0; // column 0
        gbc.gridy = 0; // row 0
        JLabel pictureLabel = new JLabel(image);
        frame.add(pictureLabel, gbc);

        gbc.gridwidth = 1; // span 1 column

        // Username Label
        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel usernameLabel = new JLabel("Username:");
        frame.add(usernameLabel, gbc);

        // Username Field
        gbc.gridx = 1;
        gbc.gridy = 1;
        JTextField usernameField = new JTextField(15);
        frame.add(usernameField, gbc);

        // Password Label
        gbc.gridx = 0;
        gbc.gridy = 2;
        JLabel passwordLabel = new JLabel("Password:");
        frame.add(passwordLabel, gbc);

        // Password Field
        gbc.gridx = 1;
        gbc.gridy = 2;
        JPasswordField passwordField = new JPasswordField(15);
        frame.add(passwordField, gbc);

        gbc.gridwidth = 2; // span 2 columns

        // GUI.Login Button
        gbc.gridx = 0;
        gbc.gridy = 3;
        JButton loginButton = new JButton("Login");
        frame.add(loginButton, gbc);

        // Register Button
        gbc.gridx = 0;
        gbc.gridy = 4;
        JButton registerButton = new JButton("Register");
        registerButton.addActionListener(e ->
        {
            new SignUp();
            frame.dispose();
        });
        frame.add(registerButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        JLabel status = new JLabel("");
        frame.add(status, gbc);

        loginButton.addActionListener(e ->
        {
            String username = usernameField.getText();
            String password = passwordField.getText();

            LoginResult result = login(username, password);
            String access = result.getAccess();
            int memberID = result.getMemberID();

            if (access.equals("Leader"))
            {
                status.setForeground(Color.GREEN);
                status.setText("Login successful as " + username + " registered as a Leader");
                new AdminUI();
                frame.dispose();
            }
            else if (access.equals("Member"))
            {
                status.setForeground(Color.GREEN);
                status.setText("Login successful as " + username + " registered as a Member");
                new UI(memberID);
                frame.dispose();
            }
            else
            {
                status.setForeground(Color.RED);
                status.setText(access);
            }
        });

        frame.setVisible(true);
    }

    public LoginResult login(String username, String password)
    {
        String db_url = "jdbc:sqlserver://196.216.43.75:1433;databaseName=ChurchMinistryDB;encrypt=true;trustServerCertificate=true;";
        String db_user = "Eben";
        String db_password = "EbenP@ss0";
        String query = "EXECUTE sp_Login @Username = ?, @Password = ?";
        String access = "";
        int memberID = 0;

        try
        {
            Connection connection = DriverManager.getConnection(db_url, db_user, db_password);
            PreparedStatement stmt = connection.prepareStatement(query);

            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            if (rs.next())
            {
                access = rs.getString("Role");
                memberID = rs.getInt("MemberID");
            }
        }
        catch (SQLException error)
        {
            error.printStackTrace();
            return new LoginResult(error.getMessage(), 0);
        }
        return new LoginResult(access, memberID);
    }
}
