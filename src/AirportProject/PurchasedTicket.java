package AirportProject;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.Random;

public class PurchasedTicket {

    static PurchasedTicket PurchasedTicket;
    static String ticketNumberString ="";
    static double discount = 0.00;
    static double ticketPrice;
    static JFrame ticket;

    public static void purchasedTicket(){
        ticket = new JFrame("Purchased Ticket");
        Border border = new LineBorder(Color.decode("#DD0A0A"), 13); // red boarder
        JButton results = new JButton("view results");
        results.setBorder(border);
        ticket.setSize(800, 400);
        ticket.setLocationRelativeTo(null);
        ticket.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ticket.getContentPane().setBackground(Color.decode("#1D16B0"));
        ticket.getContentPane().setForeground(Color.decode("#1D16B0"));
        ticket.setResizable(false);
        ticket.setVisible(false);

    }


    public void getTicketString() { // just a suggestion for randomly generated boardingPass Number
        String ticketNumber = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 9) { // length of the random string.
            int index = (int) (rnd.nextFloat() * ticketNumber.length());
            salt.append(ticketNumber.charAt(index));
        }
        ticketNumberString = salt.toString();
    }

    public double discountedTicketPrice(int birthYear){
        // if birthYear is less than ________ or larger than_________
        return discount;
    }


    public void setVisible(boolean b) {
        ticket.setVisible(b);
    }
}
