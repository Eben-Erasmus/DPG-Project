package gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.sql.*;

public class Ministries
{
    public Ministries(int memberID)
    {
        JFrame frame = new JFrame("Ministries");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setSize(1000, 1000);
        frame.setLayout(new BorderLayout());

        JPanel buttonsPanel = new JPanel();
        frame.add(buttonsPanel, BorderLayout.NORTH);

        JPanel ministryInfoPanel = new JPanel();
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        ministryInfoPanel.setBorder(border);
        ministryInfoPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;
        frame.add(ministryInfoPanel, BorderLayout.CENTER);

        JPanel roleButtonsPanel = new JPanel();
        roleButtonsPanel.setLayout(new GridLayout());
        ministryInfoPanel.add(roleButtonsPanel, gbc);

        // Ministry of Outreach Button
        JButton ministryOfOutreach = new JButton("Ministry of Outreach");
        ministryOfOutreach.addActionListener(e -> {
            addMinistryOutreach(ministryInfoPanel, roleButtonsPanel, gbc, memberID);
        });
        buttonsPanel.add(ministryOfOutreach);

        // Ministry of Worship Button
        JButton ministryOfWorship = new JButton("Ministry of Worship");
        ministryOfWorship.addActionListener(e -> {
            addMinistryWorship(ministryInfoPanel, roleButtonsPanel, gbc, memberID);
        });
        buttonsPanel.add(ministryOfWorship);

        // Ministry of Service Button
        JButton ministryOfService = new JButton("Ministry of Prayer");
        ministryOfService.addActionListener(e -> {
            addMinistryService(ministryInfoPanel, roleButtonsPanel, gbc, memberID);
        });
        buttonsPanel.add(ministryOfService);

        // Ministry of Youth Button
        JButton ministryOfYouth = new JButton("Ministry of Youth");
        ministryOfYouth.addActionListener(e -> {
            addMinistryYouth(ministryInfoPanel, roleButtonsPanel, gbc, memberID);
        });
        buttonsPanel.add(ministryOfYouth);

        frame.setVisible(true);
    }

    public void addMinistryOutreach(JPanel ministryInfoPanel, JPanel roleButtonsPanel, GridBagConstraints gbc, int memberID)
    {
        ministryInfoPanel.removeAll();

        MinistryInfoResult result = getMinistryInfo(1);
        String firstName = result.getFirstName();
        String lastName = result.getLastName();
        String email = result.getEmail();
        String phone = result.getPhone();

        gbc.ipadx = 0;
        gbc.ipady = 0;

        JLabel ministryName = new JLabel("Ministry of Outreach");
        ministryName.setFont(new Font("Arial", Font.BOLD, 25));
        ministryInfoPanel.add(ministryName, gbc);

        JLabel ministryDescription = new JLabel("The Ministry of Outreach is a ministry that reaches out to the community.");
        ministryDescription.setFont(new Font("Arial", Font.PLAIN, 25));
        ministryInfoPanel.add(ministryDescription, gbc);

        JLabel ministryLeader = new JLabel("Leader: " + firstName + " " + lastName);
        ministryLeader.setFont(new Font("Arial", Font.PLAIN, 25));
        ministryInfoPanel.add(ministryLeader, gbc);

        JLabel ministryContact = new JLabel("Contact: " + phone);
        ministryContact.setFont(new Font("Arial", Font.PLAIN, 25));
        ministryInfoPanel.add(ministryContact, gbc);

        JLabel ministryEmail = new JLabel("Email: " + email);
        ministryEmail.setFont(new Font("Arial", Font.PLAIN, 25));
        ministryInfoPanel.add(ministryEmail, gbc);

        JButton ministrySignUpButton = new JButton("Sign up Ministry");
        ministrySignUpButton.setFont(new Font("Arial", Font.PLAIN, 25));
        gbc.ipadx = 100;
        gbc.ipady = 50;
        ministrySignUpButton.addActionListener(e1 ->
        {
            roleButtonsOutreach(roleButtonsPanel, memberID);
        });
        ministryInfoPanel.add(ministrySignUpButton, gbc);

        GridBagConstraints gbcRoles = new GridBagConstraints();
        gbcRoles.gridx = 0;
        gbcRoles.gridy = GridBagConstraints.RELATIVE;
        gbcRoles.insets = new Insets(10, 10, 10, 10);
        gbcRoles.anchor = GridBagConstraints.CENTER;
        gbcRoles.fill = GridBagConstraints.HORIZONTAL;

        ministryInfoPanel.add(roleButtonsPanel, gbcRoles);

        ministryInfoPanel.revalidate();
        ministryInfoPanel.repaint();
    }

    public void addMinistryWorship(JPanel ministryInfoPanel, JPanel roleButtonsPanel, GridBagConstraints gbc, int memberID)
    {
        ministryInfoPanel.removeAll();

        MinistryInfoResult result = getMinistryInfo(2);
        String firstName = result.getFirstName();
        String lastName = result.getLastName();
        String email = result.getEmail();
        String phone = result.getPhone();

        gbc.ipadx = 0;
        gbc.ipady = 0;

        JLabel ministryName = new JLabel("Ministry of Worship");
        ministryName.setFont(new Font("Arial", Font.BOLD, 25));
        ministryInfoPanel.add(ministryName, gbc);

        JLabel ministryDescription = new JLabel("The Ministry of Worship is a ministry that leads the church in worship.");
        ministryDescription.setFont(new Font("Arial", Font.PLAIN, 25));
        ministryInfoPanel.add(ministryDescription, gbc);

        JLabel ministryLeader = new JLabel("Leader: " + firstName + " " + lastName);
        ministryLeader.setFont(new Font("Arial", Font.PLAIN, 25));
        ministryInfoPanel.add(ministryLeader, gbc);

        JLabel ministryContact = new JLabel("Contact: " + phone);
        ministryContact.setFont(new Font("Arial", Font.PLAIN, 25));
        ministryInfoPanel.add(ministryContact, gbc);

        JLabel ministryEmail = new JLabel("Email: " + email);
        ministryEmail.setFont(new Font("Arial", Font.PLAIN, 25));
        ministryInfoPanel.add(ministryEmail, gbc);

        JButton ministrySignUpButton = new JButton("Sign up Ministry");
        ministrySignUpButton.setFont(new Font("Arial", Font.PLAIN, 25));
        gbc.ipadx = 100;
        gbc.ipady = 50;
        ministrySignUpButton.addActionListener(e1 ->
        {
            roleButtonsWorship(roleButtonsPanel, memberID);
        });
        ministryInfoPanel.add(ministrySignUpButton, gbc);

        GridBagConstraints gbcRoles = new GridBagConstraints();
        gbcRoles.gridx = 0;
        gbcRoles.gridy = GridBagConstraints.RELATIVE;
        gbcRoles.insets = new Insets(10, 10, 10, 10);
        gbcRoles.anchor = GridBagConstraints.CENTER;
        gbcRoles.fill = GridBagConstraints.HORIZONTAL;

        ministryInfoPanel.add(roleButtonsPanel, gbcRoles);

        ministryInfoPanel.revalidate();
        ministryInfoPanel.repaint();
    }

    public void addMinistryService(JPanel ministryInfoPanel, JPanel roleButtonsPanel, GridBagConstraints gbc, int memberID)
    {
        ministryInfoPanel.removeAll();

        MinistryInfoResult result = getMinistryInfo(3);
        String firstName = result.getFirstName();
        String lastName = result.getLastName();
        String email = result.getEmail();
        String phone = result.getPhone();

        gbc.ipadx = 0;
        gbc.ipady = 0;

        JLabel ministryName = new JLabel("Ministry of Service");
        ministryName.setFont(new Font("Arial", Font.BOLD, 25));
        ministryInfoPanel.add(ministryName, gbc);

        JLabel ministryDescription = new JLabel("The Ministry of Service is a ministry that serves the church and very involved in Sunday service.");
        ministryDescription.setFont(new Font("Arial", Font.PLAIN, 25));
        ministryInfoPanel.add(ministryDescription, gbc);

        JLabel ministryLeader = new JLabel("Leader: " + firstName + " " + lastName);
        ministryLeader.setFont(new Font("Arial", Font.PLAIN, 25));
        ministryInfoPanel.add(ministryLeader, gbc);

        JLabel ministryContact = new JLabel("Contact: " + phone);
        ministryContact.setFont(new Font("Arial", Font.PLAIN, 25));
        ministryInfoPanel.add(ministryContact, gbc);

        JLabel ministryEmail = new JLabel("Email: " + email);
        ministryEmail.setFont(new Font("Arial", Font.PLAIN, 25));
        ministryInfoPanel.add(ministryEmail, gbc);

        JButton ministrySignUpButton = new JButton("Sign up Ministry");
        ministrySignUpButton.setFont(new Font("Arial", Font.PLAIN, 25));
        gbc.ipadx = 100;
        gbc.ipady = 50;
        ministrySignUpButton.addActionListener(e1 ->
        {
            roleButtonsService(roleButtonsPanel, memberID);
        });
        ministryInfoPanel.add(ministrySignUpButton, gbc);

        GridBagConstraints gbcRoles = new GridBagConstraints();
        gbcRoles.gridx = 0;
        gbcRoles.gridy = GridBagConstraints.RELATIVE;
        gbcRoles.insets = new Insets(10, 10, 10, 10);
        gbcRoles.anchor = GridBagConstraints.CENTER;
        gbcRoles.fill = GridBagConstraints.HORIZONTAL;

        ministryInfoPanel.add(roleButtonsPanel, gbcRoles);

        ministryInfoPanel.revalidate();
        ministryInfoPanel.repaint();
    }

    public void addMinistryYouth(JPanel ministryInfoPanel, JPanel roleButtonsPanel, GridBagConstraints gbc, int memberID)
    {
        ministryInfoPanel.removeAll();

        MinistryInfoResult result = getMinistryInfo(4);
        String firstName = result.getFirstName();
        String lastName = result.getLastName();
        String email = result.getEmail();
        String phone = result.getPhone();

        gbc.ipadx = 0;
        gbc.ipady = 0;

        JLabel ministryName = new JLabel("Ministry of Youth");
        ministryName.setFont(new Font("Arial", Font.BOLD, 25));
        ministryInfoPanel.add(ministryName, gbc);

        JLabel ministryDescription = new JLabel("The Ministry of Youth is a ministry that works with the youth and does Sunday School.");
        ministryDescription.setFont(new Font("Arial", Font.PLAIN, 25));
        ministryInfoPanel.add(ministryDescription, gbc);

        JLabel ministryLeader = new JLabel("Leader: " + firstName + " " + lastName);
        ministryLeader.setFont(new Font("Arial", Font.PLAIN, 25));
        ministryInfoPanel.add(ministryLeader, gbc);

        JLabel ministryContact = new JLabel("Contact: " + phone);
        ministryContact.setFont(new Font("Arial", Font.PLAIN, 25));
        ministryInfoPanel.add(ministryContact, gbc);

        JLabel ministryEmail = new JLabel("Email: " + email);
        ministryEmail.setFont(new Font("Arial", Font.PLAIN, 25));
        ministryInfoPanel.add(ministryEmail, gbc);

        JButton ministrySignUpButton = new JButton("Sign up Ministry");
        ministrySignUpButton.setFont(new Font("Arial", Font.PLAIN, 25));
        gbc.ipadx = 100;
        gbc.ipady = 50;
        ministrySignUpButton.addActionListener(e1 ->
        {
            roleButtonsYouth(roleButtonsPanel, memberID);
        });
        ministryInfoPanel.add(ministrySignUpButton, gbc);

        GridBagConstraints gbcRoles = new GridBagConstraints();
        gbcRoles.gridx = 0;
        gbcRoles.gridy = GridBagConstraints.RELATIVE;
        gbcRoles.insets = new Insets(10, 10, 10, 10);
        gbcRoles.anchor = GridBagConstraints.CENTER;
        gbcRoles.fill = GridBagConstraints.HORIZONTAL;

        ministryInfoPanel.add(roleButtonsPanel, gbcRoles);

        ministryInfoPanel.revalidate();
        ministryInfoPanel.repaint();
    }

    public void roleButtonsOutreach(JPanel roleButtonsPanel, int memberID)
    {
        roleButtonsPanel.removeAll();

        JLabel roleLabel = new JLabel("Roles:");
        roleLabel.setFont(new Font("Arial", Font.BOLD, 25));
        roleButtonsPanel.add(roleLabel);

        JLabel status = new JLabel("");
        roleButtonsPanel.add(status);

        JButton financeButton = new JButton("Finance");
        financeButton.addActionListener(e -> {
            String result = joinMinistry(memberID, 1, 1);
            if (result.equals("Success") || result.equals("Operation completed without a result set."))
            {
                status.setForeground(Color.GREEN);
                status.setText("You have successfully joined the Ministry of Outreach.");
            }
            else
            {
                status.setForeground(Color.RED);
                status.setText("Error: " + result);
            }
        });
        roleButtonsPanel.add(financeButton);

        JButton planningButton = new JButton("Planning");
        planningButton.addActionListener(e -> {
            String result = joinMinistry(memberID, 1, 2);
            if (result.equals("Success") || result.equals("Operation completed without a result set."))
            {
                status.setForeground(Color.GREEN);
                status.setText("You have successfully joined the Ministry of Outreach.");
            }
            else
            {
                status.setForeground(Color.RED);
                status.setText("Error: " + result);
            }
        });
        roleButtonsPanel.add(planningButton);

        JButton eventHelpButton = new JButton("Event Help");
        roleButtonsPanel.add(eventHelpButton);

        eventHelpButton.addActionListener(e -> {
            String result = joinMinistry(memberID, 1, 3);
            if (result.equals("Success") || result.equals("Operation completed without a result set."))
            {
                status.setForeground(Color.GREEN);
                status.setText("You have successfully joined the Ministry of Outreach.");
            }
            else
            {
                status.setForeground(Color.RED);
                status.setText("Error: " + result);
            }
        });

        roleButtonsPanel.revalidate();
        roleButtonsPanel.repaint();
    }

    public void roleButtonsWorship(JPanel roleButtonsPanel, int memberID)
    {
        roleButtonsPanel.removeAll();

        JLabel roleLabel = new JLabel("Roles:");
        roleLabel.setFont(new Font("Arial", Font.BOLD, 25));
        roleButtonsPanel.add(roleLabel);

        JLabel status = new JLabel("");
        roleButtonsPanel.add(status);

        JButton financeButton = new JButton("Finance");
        financeButton.addActionListener(e -> {
            String result = joinMinistry(memberID, 2, 1);
            if (result.equals("Success") || result.equals("Operation completed without a result set."))
            {
                status.setForeground(Color.GREEN);
                status.setText("You have successfully joined the Ministry of Worship.");
            }
            else
            {
                status.setForeground(Color.RED);
                status.setText("Error: " + result);
            }
        });
        roleButtonsPanel.add(financeButton);

        JButton planningButton = new JButton("Planning");
        planningButton.addActionListener(e -> {
            String result = joinMinistry(memberID, 2, 2);
            if (result.equals("Success") || result.equals("Operation completed without a result set."))
            {
                status.setForeground(Color.GREEN);
                status.setText("You have successfully joined the Ministry of Worship.");
            }
            else
            {
                status.setForeground(Color.RED);
                status.setText("Error: " + result);
            }
        });
        roleButtonsPanel.add(planningButton);

        JButton eventHelpButton = new JButton("Event Help");
        roleButtonsPanel.add(eventHelpButton);

        eventHelpButton.addActionListener(e -> {
            String result = joinMinistry(memberID, 2, 3);
            if (result.equals("Success") || result.equals("Operation completed without a result set."))
            {
                status.setForeground(Color.GREEN);
                status.setText("You have successfully joined the Ministry of Worship.");
            }
            else
            {
                status.setForeground(Color.RED);
                status.setText("Error: " + result);
            }
        });

        roleButtonsPanel.revalidate();
        roleButtonsPanel.repaint();
    }

    public void roleButtonsService(JPanel roleButtonsPanel, int memberID)
    {
        roleButtonsPanel.removeAll();

        JLabel roleLabel = new JLabel("Roles:");
        roleLabel.setFont(new Font("Arial", Font.BOLD, 25));
        roleButtonsPanel.add(roleLabel);

        JLabel status = new JLabel("");
        roleButtonsPanel.add(status);

        JButton financeButton = new JButton("Finance");
        financeButton.addActionListener(e -> {
            String result = joinMinistry(memberID, 3, 1);
            if (result.equals("Success") || result.equals("Operation completed without a result set."))
            {
                status.setForeground(Color.GREEN);
                status.setText("You have successfully joined the Ministry of Service.");
            }
            else
            {
                status.setForeground(Color.RED);
                status.setText("Error: " + result);
            }
        });
        roleButtonsPanel.add(financeButton);

        JButton planningButton = new JButton("Planning");
        planningButton.addActionListener(e -> {
            String result = joinMinistry(memberID, 3, 2);
            if (result.equals("Success") || result.equals("Operation completed without a result set."))
            {
                status.setForeground(Color.GREEN);
                status.setText("You have successfully joined the Ministry of Service.");
            }
            else
            {
                status.setForeground(Color.RED);
                status.setText("Error: " + result);
            }
        });
        roleButtonsPanel.add(planningButton);

        JButton eventHelpButton = new JButton("Event Help");
        roleButtonsPanel.add(eventHelpButton);

        eventHelpButton.addActionListener(e -> {
            String result = joinMinistry(memberID, 3, 3);
            if (result.equals("Success") || result.equals("Operation completed without a result set."))
            {
                status.setForeground(Color.GREEN);
                status.setText("You have successfully joined the Ministry of Service.");
            }
            else
            {
                status.setForeground(Color.RED);
                status.setText("Error: " + result);
            }
        });

        roleButtonsPanel.revalidate();
        roleButtonsPanel.repaint();
    }

    public void roleButtonsYouth(JPanel roleButtonsPanel, int memberID)
    {
        roleButtonsPanel.removeAll();

        JLabel roleLabel = new JLabel("Roles:");
        roleLabel.setFont(new Font("Arial", Font.BOLD, 25));
        roleButtonsPanel.add(roleLabel);

        JLabel status = new JLabel("");
        roleButtonsPanel.add(status);

        JButton financeButton = new JButton("Finance");
        financeButton.addActionListener(e -> {
            String result = joinMinistry(memberID, 4, 1);
            if (result.equals("Success") || result.equals("Operation completed without a result set."))
            {
                status.setForeground(Color.GREEN);
                status.setText("You have successfully joined the Ministry of Youth.");
            }
            else
            {
                status.setForeground(Color.RED);
                status.setText("Error: " + result);
            }
        });
        roleButtonsPanel.add(financeButton);

        JButton planningButton = new JButton("Planning");
        planningButton.addActionListener(e -> {
            String result = joinMinistry(memberID, 4, 2);
            if (result.equals("Success") || result.equals("Operation completed without a result set."))
            {
                status.setForeground(Color.GREEN);
                status.setText("You have successfully joined the Ministry of Youth.");
            }
            else
            {
                status.setForeground(Color.RED);
                status.setText("Error: " + result);
            }
        });
        roleButtonsPanel.add(planningButton);

        JButton eventHelpButton = new JButton("Event Help");
        roleButtonsPanel.add(eventHelpButton);

        eventHelpButton.addActionListener(e -> {
            String result = joinMinistry(memberID, 4, 3);
            if (result.equals("Success") || result.equals("Operation completed without a result set."))
            {
                status.setForeground(Color.GREEN);
                status.setText("You have successfully joined the Ministry of Youth.");
            }
            else
            {
                status.setForeground(Color.RED);
                status.setText("Error: " + result);
            }
        });

        roleButtonsPanel.revalidate();
        roleButtonsPanel.repaint();
    }

    public MinistryInfoResult getMinistryInfo(int MinistryID)
    {
        String db_url = "jdbc:sqlserver://196.216.43.75:1433;databaseName=ChurchMinistryDB;encrypt=true;trustServerCertificate=true;";
        String db_user = "Eben";
        String db_password = "EbenP@ss0";
        String query = "EXECUTE sp_GetMinistryInfo @MinistryID = ?";
        String firstName = "";
        String lastName = "";
        String email = "";
        String phone = "";

        try
        {
            Connection connection = DriverManager.getConnection(db_url, db_user, db_password);
            PreparedStatement stmt = connection.prepareStatement(query);

            stmt.setInt(1, MinistryID);
            ResultSet rs = stmt.executeQuery();

            if (rs.next())
            {
                firstName = rs.getString("FirstName");
                lastName = rs.getString("LastName");
                email = rs.getString("Email");
                phone = rs.getString("PhoneNumber");
            }
        }
        catch (SQLException error)
        {
            error.printStackTrace();
            return new MinistryInfoResult(error.getMessage(), "", "", "");
        }
        return new MinistryInfoResult(firstName, lastName, email, phone);
    }

    public String joinMinistry(int memberID, int ministryID, int roleID)
    {
        String db_url = "jdbc:sqlserver://196.216.43.75:1433;databaseName=ChurchMinistryDB;encrypt=true;trustServerCertificate=true;";
        String db_user = "Eben";
        String db_password = "EbenP@ss0";
        String query = "EXECUTE sp_joinMinistry @memberID = ?, @ministryID = ?, @roleID = ?";
        String result = "";

        try {
            Connection connection = DriverManager.getConnection(db_url, db_user, db_password);
            PreparedStatement stmt = connection.prepareStatement(query);

            stmt.setInt(1, memberID);
            stmt.setInt(2, ministryID);
            stmt.setInt(3, roleID);
            boolean hasResultSet = stmt.execute();

            if (hasResultSet) {
                ResultSet rs = stmt.getResultSet();
                if (rs.next()) {
                    result = rs.getString("Result");
                }
            } else {
                int rowCount = stmt.getUpdateCount();
                if (rowCount == 0) {
                    result = "No rows affected.";
                } else {
                    result = "Operation completed without a result set.";
                }
            }
        }
        catch (SQLException error)
        {
            error.printStackTrace();
            result = error.getMessage();
        }
        return result;
    }
}
