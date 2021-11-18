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
//    static double discount = 0.00;
//    static double ticketPrice;
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
        //@setup JFrame with .setText from static purchasedTicket HashMap values
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
