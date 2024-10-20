package gui;

import javax.swing.*;
import java.awt.*;

public class Ministries
{
    public Ministries()
    {
        JFrame frame = new JFrame("Ministries");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 600);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel);

        // Title
        JLabel title = new JLabel("Sign up for Ministries");
        title.setBounds(20, 10, 200, 25);
        panel.add(title);

        // Ministry of Outreach Button
        JButton ministryOfOutreach = new JButton("Ministry of Outreach");
        ministryOfOutreach.setFocusable(false);
        ministryOfOutreach.setBounds(20, 50, 400, 40);
        ministryOfOutreach.setFont(new Font("Arial", Font.PLAIN, 16));
        ministryOfOutreach.setMargin(new Insets(10, 10, 10, 10));
        ministryOfOutreach.addActionListener(e -> {
            //new MinistryOfOutreach();
        });
        panel.add(ministryOfOutreach);

        // Ministry of Worship Button
        JButton ministryOfWorship = new JButton("Ministry of Worship");
        ministryOfWorship.setFocusable(false);
        ministryOfWorship.setBounds(20, 140, 400, 40);
        ministryOfWorship.setFont(new Font("Arial", Font.PLAIN, 16));
        ministryOfWorship.setMargin(new Insets(10, 10, 10, 10));
        ministryOfWorship.addActionListener(e -> {
            //new MinistryOfWorship();
        });
        panel.add(ministryOfWorship);

        // Ministry of Service Button
        JButton ministryOfService = new JButton("Ministry of Prayer");
        ministryOfService.setFocusable(false);
        ministryOfService.setBounds(20, 230, 400, 40);
        ministryOfService.setFont(new Font("Arial", Font.PLAIN, 16));
        ministryOfService.setMargin(new Insets(10, 10, 10, 10));
        ministryOfService.addActionListener(e -> {
            //new ministryOfService();
        });
        panel.add(ministryOfService);

        // Ministry of Youth Button
        JButton ministryOfYouth = new JButton("Ministry of Youth");
        ministryOfYouth.setFocusable(false);
        ministryOfYouth.setBounds(20, 320, 400, 40);
        ministryOfYouth.setFont(new Font("Arial", Font.PLAIN, 16));
        ministryOfYouth.setMargin(new Insets(10, 10, 10, 10));
        ministryOfYouth.addActionListener(e -> {
            //new MinistryOfYouth();
        });
        panel.add(ministryOfYouth);

        frame.setVisible(true);
    }
}
