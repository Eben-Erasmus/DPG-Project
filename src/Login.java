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
        GridBagConstraints gbc = new GridBagConstraints(); //NOTE TO SELF - gridlayout and boxlayout does not work with a sign up window, use gridbaglayout instead

        // Username Label
        gbc.gridx = 0; // column 0
        gbc.gridy = 0; // row 0
        gbc.insets = new Insets(10, 10, 5, 10); // padding
        frame.add(new JLabel("Username:"), gbc);

        // Username Field
        gbc.gridx = 1; // column 1
        gbc.gridy = 0; // row 0
        gbc.fill = GridBagConstraints.HORIZONTAL;
        frame.add(new JTextField(15), gbc);

        // Password Label
        gbc.gridx = 0; // column 0
        gbc.gridy = 1; // row 1
        frame.add(new JLabel("Password:"), gbc);

        // Password Field
        gbc.gridx = 1; // column 1
        gbc.gridy = 1; // row 1
        frame.add(new JPasswordField(15), gbc);

        // Sign In Button
        gbc.gridx = 0; // column 0
        gbc.gridy = 2; // row 2
        gbc.gridwidth = 2; // span 2 columns
        gbc.insets = new Insets(10, 10, 10, 10);
        JButton signInButton = new JButton("Sign In");
        frame.add(signInButton, gbc);

        // Set frame visible
        frame.setVisible(true);
    }
}
