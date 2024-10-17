import javax.swing.*;
import java.awt.*;

public class UI
{
    public UI()
    {
        JFrame ui = new JFrame("My GUI");
        ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ui.setSize(760, 690);
        ui.setLayout(new BorderLayout()); //Use BorderLayout to position components on main ui (Die een maak dat button mooi bo bly met die BorderLayout.NORTH)

        JPanel buttonPanel = new JPanel();
        ui.add(buttonPanel, BorderLayout.NORTH);

        JButton accountButton = new JButton("Account");
        buttonPanel.add(accountButton);

        JButton settingsButton = new JButton("Settings");
        buttonPanel.add(settingsButton);

        JButton cartButton = new JButton("Cart");
        buttonPanel.add(cartButton);

        ui.setVisible(true);
    }
}
