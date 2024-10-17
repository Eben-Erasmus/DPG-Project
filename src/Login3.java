import javax.swing.*;
import java.awt.*;

public class Login3 {
    public Login3() {
        JFrame frame = new JFrame("Sign In 3");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLayout(new FlowLayout());


        // Create a JPanel without a layout manager
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(400, 800));
        panel.setLayout(null); // Disable layout manager

        // Create components with fixed positions
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(10, 20, 80, 25); // x, y, width, height
        panel.add(usernameLabel);

        JTextField usernameField = new JTextField();
        usernameField.setBounds(100, 20, 165, 25);
        panel.add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(100, 50, 165, 25);
        panel.add(passwordField);

        JButton signInButton = new JButton("Sign In");
        signInButton.setBounds(10, 80, 255, 25);
        panel.add(signInButton);

        // Add the panel to the frame
        frame.add(panel);
        frame.setVisible(true);
    }
}

