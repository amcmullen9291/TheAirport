package AirportProject;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class PurchasedTicket {
    static PurchasedTicket PurchasedTicket;
    static JFrame ticket;
    static PassengerDataCollection passenger;
    public static HashMap<String, String> customerInformation;

    public static void purchasedTicket(){
        ticket = new JFrame("Purchase Ticket");
        Border border = new LineBorder(Color.decode("#DD0A0A"), 13);
        JButton results = new JButton("view results");
        results.setBorder(border);
        ticket.setSize(800, 400);
        ticket.setLocationRelativeTo(null);
        ticket.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ticket.getContentPane().setBackground(Color.decode("#1D16B0"));
        ticket.getContentPane().setForeground(Color.decode("#1D16B0"));
        JPanel pane = new JPanel();
        pane.setLayout(new BoxLayout(pane, BoxLayout.LINE_AXIS));
        pane.setBackground(Color.GRAY);

        JButton resetButton = new JButton("Cancel");
        JButton printTicket = new JButton("Process"); // goes to the BufferedWriter()
        resetButton.addActionListener( new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String[] reset = {};
                ticket.setVisible(false);
                PassengerInformation.main(reset);
            }
        });

        pane.add(resetButton);
        pane.add(Box.createHorizontalGlue());
        pane.add(printTicket);

        ticket.add(pane, BorderLayout.SOUTH);
        ticket.setResizable(false);
        ticket.setVisible(false);
    }

    public static void showData(){
        //declaring values for .setText
        String ticketDate = PassengerDataCollection.purchasedTicket.get("PurchaseDate");
        String ticketPrice = PassengerDataCollection.purchasedTicket.get("Price");
        String ticketNumber = PassengerDataCollection.purchasedTicket.get("ticketNumber");

        String fullName = PassengerDataCollection.purchasedTicket.get("Name");
        String phoneNumber = PassengerDataCollection.purchasedTicket.get("Phone");
        String customerEmail = PassengerDataCollection.purchasedTicket.get("Email");
        String origin = PassengerDataCollection.purchasedTicket.get("Origin");
        String destination = PassengerDataCollection.purchasedTicket.get("Destination");
        String timeOfDeparture = PassengerDataCollection.purchasedTicket.get("DepartureTime");
        String eta = PassengerDataCollection.purchasedTicket.get("Arrival Time");


        JPanel collectedInformation = new JPanel();
        collectedInformation.setLayout(new GridLayout(12, 1));
        JLabel name = new JLabel("Name:");
        JTextField nameArea = new JTextField(20);
        nameArea.setText(fullName);

        JLabel dateOfTicket = new JLabel(ticketDate);
        JLabel ticketLabel = new JLabel("Boarding pass number: " + ticketNumber);
        JLabel priceOf = new JLabel("Ticket price: " + "$"+ticketPrice +"0");


        JLabel email = new JLabel("Email Address:");
        JTextField emailArea = new JTextField(30);
        emailArea.setText(customerEmail);

        JLabel phone = new JLabel("Phone number:");
        JTextField phoneArea = new JTextField(20);
        phoneArea.setText(phoneNumber);

        collectedInformation.add(dateOfTicket);
        collectedInformation.add(ticketLabel);
        collectedInformation.add(priceOf);
        collectedInformation.add(name);
        collectedInformation.add(nameArea);
        collectedInformation.add(email);
        collectedInformation.add(emailArea);
        collectedInformation.add(phone);
        collectedInformation.add(phoneArea);

        ticket.add(collectedInformation);
        ticket.setVisible(true);
    }

    public void setVisible(boolean b) {
        ticket.setVisible(b);
        ticket.getContentPane().setBackground(Color.decode("#1D16B0"));
        ticket.getContentPane().setForeground(Color.decode("#1D16B0"));

    }
    private static void fetchCustomerData() {
        customerInformation = passenger.getCustomerInfo();
    }
}
