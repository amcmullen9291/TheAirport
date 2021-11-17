package AirportProject;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
//import java.awt.event.ActionListener;
import java.util.EventListener;

public class PurchasedTicketSearch implements EventListener {
    static JFrame searchBox;

    public static void purchasedTicketSearch(){
        Border border = new LineBorder(Color.GRAY, 8);
        searchBox = new JFrame();
        searchBox.setLocation(0,0);
        searchBox.setSize(275, 200);
        JButton searchButton = new JButton("Search Purchased Tickets");
        searchButton.setVisible(true);
        searchButton.setLocation(0,175);
        searchButton.setBorder(border);
        searchBox.setForeground(Color.RED);
        searchBox.setUndecorated(true);
        searchBox.add(searchButton);
        searchBox.setVisible(false);

    }

    public void setVisible(boolean b) {
        searchBox.setVisible(b);
    }
}
