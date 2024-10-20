package gui;

import javax.swing.*;
import java.awt.*;

public class AdminUI
{
    public AdminUI()
    {
        JFrame ui = new JFrame("Family 360 - Admin Control Panel");
        ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ui.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ui.setSize(1000, 1000);
        ui.setLayout(new BorderLayout()); //Use BorderLayout to position components on main ui (Die een maak dat button mooi bo bly met die BorderLayout.NORTH)

        JPanel buttonPanel = new JPanel();
        ui.add(buttonPanel, BorderLayout.NORTH);

        JButton accountButton = new JButton("Settings");
        buttonPanel.add(accountButton);

        JButton settingsButton = new JButton("Notifications");
        buttonPanel.add(settingsButton);

        JButton cartButton = new JButton("Ministries");
        buttonPanel.add(cartButton);

        JButton membersButton = new JButton("Members");
        buttonPanel.add(membersButton);

        ui.setVisible(true);
    }
}
