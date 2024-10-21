package gui;

import javax.swing.*;
import java.awt.*;

public class UI
{
    public UI(int memberID)
    {
        JFrame ui = new JFrame("Family 360 - Control Panel");
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

        JButton ministriesButton = new JButton("Ministries");
        ministriesButton.addActionListener(e -> new Ministries(memberID));
        buttonPanel.add(ministriesButton);

        ui.setVisible(true);
    }
}
