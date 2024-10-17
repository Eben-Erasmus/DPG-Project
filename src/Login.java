import javax.swing.*;
import java.awt.*;

public class Login
{
    public Login()
    {
        JFrame frame = new JFrame("Sign In");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints(); //NOTE TO SELF - gridlayout and boxlayout does not work with a login window, use gridbaglayout instead, FlowLayout it always stays at the top

        gbc.insets = new Insets(10, 10, 10, 10); // Padding
        gbc.fill = GridBagConstraints.HORIZONTAL; // Make that the Login button fill horizontally

        // Username Label
        gbc.gridx = 0; // column 0
        gbc.gridy = 0; // row 0
        JLabel usernameLabel = new JLabel("Username:");
        frame.add(usernameLabel, gbc);

        // Username Field
        gbc.gridx = 1; // column 1
        gbc.gridy = 0; // row 0
        JTextField usernameField = new JTextField(15);
        frame.add(usernameField, gbc);

        // Password Label
        gbc.gridx = 0; // column 0
        gbc.gridy = 1; // row 1
        JLabel passwordLabel = new JLabel("Password:");
        frame.add(passwordLabel, gbc);

        // Password Field
        gbc.gridx = 1; // column 1
        gbc.gridy = 1; // row 1
        JPasswordField passwordField = new JPasswordField(15);
        frame.add(passwordField, gbc);

        // Login Button
        gbc.gridx = 0; // column 0
        gbc.gridy = 2; // row 2
        gbc.gridwidth = 2; // span 2 columns
        JButton loginButton = new JButton("Login");
        frame.add(loginButton, gbc);

        // Register Button
        gbc.gridx = 0; // column 0
        gbc.gridy = 3; // row 3
        gbc.gridwidth = 2; // span 2 columns
        JButton registerButton = new JButton("Register");
        frame.add(registerButton, gbc);

        frame.setVisible(true);
    }
}
