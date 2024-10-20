package gui;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class SignUp
{
    public SignUp()
    {
        JFrame frame = new JFrame("Sign Up");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setSize(1000, 1000);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

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

        // FirstName Label
        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel firstNameLabel = new JLabel("First Name: *");
        frame.add(firstNameLabel, gbc);

        // FirstName Field
        gbc.gridx = 1;
        gbc.gridy = 1;
        JTextField firstNameField = new JTextField(15);
        frame.add(firstNameField, gbc);

        // LastName Label
        gbc.gridx = 0;
        gbc.gridy = 2;
        JLabel lastNameLabel = new JLabel("Last Name: *");
        frame.add(lastNameLabel, gbc);

        // LastName Field
        gbc.gridx = 1;
        gbc.gridy = 2;
        JTextField lastNameField = new JTextField(15);
        frame.add(lastNameField, gbc);

        // Date of Birth Label
        gbc.gridx = 0;
        gbc.gridy = 3;
        JLabel dateOfBirthLabel = new JLabel("Date of Birth: *");
        frame.add(dateOfBirthLabel, gbc);

        // Date of Brith Field
        gbc.gridx = 1;
        gbc.gridy = 3;
        JTextField dateOfBirthField = new JTextField("YYYY-MM-DD", 15 );
        frame.add(dateOfBirthField, gbc);

        // Gender Label
        gbc.gridx = 0;
        gbc.gridy = 4;
        JLabel genderLabel = new JLabel("Gender: *");
        frame.add(genderLabel, gbc);

        // Gender Field
        gbc.gridx = 1;
        gbc.gridy = 4;
        JTextField genderField = new JTextField(15);
        frame.add(genderField, gbc);

        // Email Label
        gbc.gridx = 0;
        gbc.gridy = 5;
        JLabel emailLabel = new JLabel("Email: *");
        frame.add(emailLabel, gbc);

        // Email Field
        gbc.gridx = 1;
        gbc.gridy = 5;
        JTextField emailField = new JTextField(15);
        frame.add(emailField, gbc);

        // Phone Label
        gbc.gridx = 0;
        gbc.gridy = 6;
        JLabel phoneLabel = new JLabel("Phone Number: *");
        frame.add(phoneLabel, gbc);

        // Phone Field
        gbc.gridx = 1;
        gbc.gridy = 6;
        JTextField phoneField = new JTextField(15);
        frame.add(phoneField, gbc);

        // Username Label
        gbc.gridx = 0;
        gbc.gridy = 7;
        JLabel usernameLabel = new JLabel("Username: *");
        frame.add(usernameLabel, gbc);

        // Username Field
        gbc.gridx = 1;
        gbc.gridy = 7;
        JTextField usernameField = new JTextField(15);
        frame.add(usernameField, gbc);

        // Password Label
        gbc.gridx = 0;
        gbc.gridy = 8;
        JLabel passwordLabel = new JLabel("Password: *");
        frame.add(passwordLabel, gbc);

        // Password Field
        gbc.gridx = 1;
        gbc.gridy = 8;
        JPasswordField passwordField = new JPasswordField(15);
        frame.add(passwordField, gbc);

        // Confirm Password Label
        gbc.gridx = 0;
        gbc.gridy = 9;
        JLabel confirmPasswordLabel = new JLabel("Confirm Password: *");
        frame.add(confirmPasswordLabel, gbc);

        // Confirm Password Field
        gbc.gridx = 1;
        gbc.gridy = 9;
        JPasswordField confirmPasswordField = new JPasswordField(15);
        frame.add(confirmPasswordField, gbc);

        gbc.gridwidth = 2; // span 2 columns

        // Login Button
        gbc.gridx = 0;
        gbc.gridy = 10;
        JButton loginButton = new JButton("Sign Up");
        frame.add(loginButton, gbc);

        // Back Button
        gbc.gridx = 0;
        gbc.gridy = 11;
        JButton backButton = new JButton("Back");
        frame.add(backButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 12;
        JLabel status = new JLabel("");
        frame.add(status, gbc);

        loginButton.addActionListener(e ->
        {
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            String dateOfBirth = dateOfBirthField.getText();
            String gender = genderField.getText();
            String email = emailField.getText();
            String phone = phoneField.getText();
            String username = usernameField.getText();
            String password = passwordField.getText();
            String confirmPassword = confirmPasswordField.getText();

            String error = addUser(firstName, lastName, dateOfBirth, gender, email, phone, username, password, confirmPassword);
            if (error.equals(""))
            {
                status.setForeground(Color.GREEN);
                status.setText("User added successfully");
            }
            else
            {
                status.setForeground(Color.RED);
                status.setText(error);
            }
        });

        frame.setVisible(true);
    }

    public String addUser(String firstName, String lastName, String dateOfBirth, String gender, String email, String phone, String username, String password, String confirmPassword)
    {
        String db_url = "jdbc:sqlserver://196.216.43.75:1433;databaseName=ChurchMinistryDB;encrypt=true;trustServerCertificate=true;";
        String db_user = "Eben";
        String db_password = "EbenP@ss0";
        String query = "EXECUTE sp_AddMember @FirstName = ?, @LastName = ?, @DateOfBirth = ?, @Gender = ?, @Email = ?, @PhoneNumber = ?, @Username = ?, @Password = ?, @ConfirmPassword = ?";

        try
        {
            Connection connection = DriverManager.getConnection(db_url, db_user, db_password);
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.setString(3, dateOfBirth);
            stmt.setString(4, gender);
            stmt.setString(5, email);
            stmt.setString(6, phone);
            stmt.setString(7, username);
            stmt.setString(8, password);
            stmt.setString(9, confirmPassword);
            stmt.executeUpdate();
        }
        catch (SQLException error)
        {
            error.printStackTrace();
            return error.getMessage();
        }
        return "";
    }
}
