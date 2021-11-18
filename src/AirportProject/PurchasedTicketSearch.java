package AirportProject;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.EventListener;
import java.util.HashMap;

public class PurchasedTicketSearch implements EventListener {

    static JFrame searchBox;

    public static void purchasedTicketSearch() {
        Border border = new LineBorder(Color.GRAY, 8);
        searchBox = new JFrame();
        searchBox.setLocation(0, 0);
        searchBox.setSize(275, 200);
        JButton searchButton = new JButton("Search Purchased Tickets");
        searchButton.addActionListener( new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                searchBox.setVisible(false);
                String emailSearch = "";
                String lastNameSearch = "";
                try {
                    searchTickets(emailSearch,lastNameSearch);
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });
        searchButton.setVisible(true);
        searchButton.setLocation(0, 175);
        searchButton.setBorder(border);
        searchBox.setForeground(Color.RED);
        searchBox.setUndecorated(true);
        searchBox.add(searchButton);
        searchBox.setVisible(false);

    }

    public void setVisible(boolean b) {
        searchBox.setVisible(b);
    }

    public static void searchTickets(String passengerEmail, String lastName) throws FileNotFoundException {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/AirportProject/purchased_tickets.txt"))) {
            String line = reader.readLine();
            while (line != null) {
                if ((line.contains(passengerEmail))|| (line.contains(lastName))) {
                    System.out.println(line);
                    //convert to PassengerDataCollection.purchasedTicket HashMap or new HashMap
                } else {
                    System.out.println("Reservation not found");
                }
                // read next line
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
