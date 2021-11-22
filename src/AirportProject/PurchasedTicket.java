package AirportProject;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PurchasedTicket {
    static PurchasedTicket PurchasedTicket;
    static JFrame ticket;
    static PassengerDataCollection passenger;
    public static HashMap<String, String> customerInformation;
    static JButton printTicket;
    static Scanner scanner;

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
        printTicket = new JButton("Process");

        printTicket.addActionListener( new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("Ticket purchase saved.");
                try {
                    saveTicket();
                    String[] reset = {};
                    ticket.setVisible(false);
                    PassengerInformation.main(reset);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
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

        ticket.setLayout(new GridLayout(1, 2));
        JPanel collectedInformation = new JPanel();
        collectedInformation.setLayout(new GridLayout(12, 2));
        JLabel spaceHolder = new JLabel(" ");
        JLabel name = new JLabel("Name: " + fullName);

        JLabel dateOfTicket = new JLabel(ticketDate);
        JLabel ticketLabel = new JLabel("Boarding pass number: " + ticketNumber);
        JLabel priceOf = new JLabel("Ticket price: " + "$"+ticketPrice +"0");
        JLabel tripDetails = new JLabel("Leaving from: " + origin);
        JLabel tripDetails2 = new JLabel("Departing at: " + timeOfDeparture);
        JLabel tripDetails3 = new JLabel("Going to: " + destination);
        JLabel tripDetails4 = new JLabel("Arriving at: " + eta);

        JLabel email = new JLabel("Email Address: " + customerEmail);
        JLabel phone = new JLabel("Phone number: " + phoneNumber);
        JLabel bottomSpacer = new JLabel("---------------------");

        collectedInformation.add(dateOfTicket);
        collectedInformation.add(ticketLabel);
        collectedInformation.add(priceOf);
        collectedInformation.add(name);
        collectedInformation.add(email);
        collectedInformation.add(phone);
        collectedInformation.add(spaceHolder);
        collectedInformation.add(tripDetails);
        collectedInformation.add(tripDetails2);
        collectedInformation.add(tripDetails3);
        collectedInformation.add(tripDetails4);
        collectedInformation.add(bottomSpacer);

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
    private static void saveTicket() throws IOException {
        String newString = "";
        String line = " ";
        File file = new File("src/AirportProject/purchased_tickets.txt");

        BufferedWriter writer = null;

        try {
            writer = new BufferedWriter(new FileWriter(file, true));
            for (Map.Entry<String, String> entry :
                    PassengerDataCollection.purchasedTicket.entrySet()) {
                writer.write(entry.getKey() + ":"
                        + entry.getValue());

                writer.newLine();
            }
            writer.write("--------------------");
            newString = newString+line+"\n";
            writer.write(newString);
            writer.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {

            try {

                writer.close();
            }
            catch (Exception e) {
            }
        }
        saveTicketReadable();
    }

    private static void saveTicketReadable() throws IOException {
        String customerEmail = "Email="+ PassengerDataCollection.purchasedTicket.get("Email");
        removeDuplicateEmails(customerEmail, "Done");
    String newString = "";
        String line = " ";
        File file = new File("src/AirportProject/return _purchase_tickets.txt");

        BufferedWriter writer = null;

        try {
            writer = new BufferedWriter(new FileWriter(file, true));
            writer.write(String.valueOf(PassengerDataCollection.purchasedTicket));
            // new line
            writer.newLine();
            newString = newString+line+"\n";
            writer.write(newString);
            writer.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {

            try {

                writer.close();
            }
            catch (Exception e) {
            }
        }
    }

    public static void showSearchResults(){
        PassengerInformation.customerRegistration.setVisible(false);
        printTicket.setEnabled(false);

        String ticketDate = HashMapConversion.ticketHash.get("PurchaseDate");
        String ticketPrice = HashMapConversion.ticketHash.get("Price");
        String ticketNumber = HashMapConversion.ticketHash.get("ticketNumber");

        String fullName = HashMapConversion.ticketHash.get("Name");
        String phoneNumber = HashMapConversion.ticketHash.get("Phone");
        String customerEmail = HashMapConversion.ticketHash.get("Email");
        String origin = HashMapConversion.ticketHash.get("Origin");
        String destination = HashMapConversion.ticketHash.get("Destination");
        String timeOfDeparture = HashMapConversion.ticketHash.get("DepartureTime");
        String eta = HashMapConversion.ticketHash.get("Arrival Time");

        ticket.setLayout(new GridLayout(1, 2));
        JPanel collectedInformation = new JPanel();
        collectedInformation.setLayout(new GridLayout(12, 2));
        JLabel spaceHolder = new JLabel(" ");
        JLabel name = new JLabel("Name: " + fullName);

        JLabel dateOfTicket = new JLabel(ticketDate);
        JLabel ticketLabel = new JLabel("Boarding pass number: " + ticketNumber);
        JLabel priceOf = new JLabel("Ticket price: " + "$"+ticketPrice +"0");
        JLabel tripDetails = new JLabel("Leaving from: " + origin);
        JLabel tripDetails2 = new JLabel("Departing at: " + timeOfDeparture);
        JLabel tripDetails3 = new JLabel("Going to: " + destination);
        JLabel tripDetails4 = new JLabel("Arriving at: " + eta);

        JLabel email = new JLabel("Email Address: " + customerEmail);
        JLabel phone = new JLabel("Phone number: " + phoneNumber);
        JLabel bottomSpacer = new JLabel("---------------------");

        collectedInformation.add(dateOfTicket);
        collectedInformation.add(ticketLabel);
        collectedInformation.add(priceOf);
        collectedInformation.add(name);
        collectedInformation.add(email);
        collectedInformation.add(phone);
        collectedInformation.add(spaceHolder);
        collectedInformation.add(tripDetails);
        collectedInformation.add(tripDetails2);
        collectedInformation.add(tripDetails3);
        collectedInformation.add(tripDetails4);
        collectedInformation.add(bottomSpacer);

        ticket.add(collectedInformation);
        ticket.setVisible(true);
    }

    public static void removeDuplicateEmails(String oldString, String newString)
    {
        File fileToBeModified = new File("src/AirportProject/return _purchase_tickets.txt");

        String oldContent =oldString;

        BufferedReader reader2 = null;

        FileWriter writer2 = null;

        try
        {
            reader2 = new BufferedReader(new FileReader(fileToBeModified));


            String line = reader2.readLine();

            while (line != null)
            {
                oldContent = oldContent + line + System.lineSeparator();

                line = reader2.readLine();
            }


            String newContent = oldContent.replaceAll(oldString, "done");


            writer2 = new FileWriter(fileToBeModified);

            writer2.write(newContent);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                reader2.close();

                writer2.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}