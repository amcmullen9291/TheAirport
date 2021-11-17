package AirportProject;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.HashMap;

public class PurchasedTicket {
    static PurchasedTicket PurchasedTicket;
    static double discount = 0.00;
    static double ticketPrice;
    static JFrame ticket;
    static PassengerDataCollection passenger;
    public static HashMap<String, String> customerInformation;

    public static void purchasedTicket(){
        ticket = new JFrame("Purchased Ticket");
        Border border = new LineBorder(Color.decode("#DD0A0A"), 13);
        JButton results = new JButton("view results");
        results.setBorder(border);
        ticket.setSize(800, 400);
        ticket.setLocationRelativeTo(null);
        ticket.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ticket.getContentPane().setBackground(Color.decode("#1D16B0"));
        ticket.getContentPane().setForeground(Color.decode("#1D16B0"));
        ticket.setResizable(false);
        ticket.setVisible(false);
            //@setup JFRAME with .setText from static Passenger instance?
        //test
        fetchCustomerData();
    }

//moved to Data Collection Class
//    public void getTicketString() { // just a suggestion for randomly generated boardingPass Number
//        String ticketNumber = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
//        StringBuilder salt = new StringBuilder();
//        Random rnd = new Random();
//        while (salt.length() < 9) { // length of the random string.
//            int index = (int) (rnd.nextFloat() * ticketNumber.length());
//            salt.append(ticketNumber.charAt(index));
//        }
//        ticketNumberString = salt.toString();
//    }

    public static void showData(){
        String destination = PassengerDataCollection.purchasedTicket.get("Destination");
        System.out.println("customer's destination: " + destination);
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
