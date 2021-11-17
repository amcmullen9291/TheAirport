package AirportProject;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.EventListener;

//import java.time.LocalTime;


public class PassengerInformation  extends JFrame implements EventListener {
    static PassengerInformation register;
    static JFrame customerRegistration;
    static PurchasedTicketSearch searchBox;
    static PurchasedTicket purchase;

    //don't mind the colors or spacing, just setting things up
    public static void passengerInformation(){
        customerRegistration = new JFrame("Our Airport");
        searchBox = new PurchasedTicketSearch(); //new
        Border border = new LineBorder(Color.decode("#DD0A0A"), 13); // red boarder
        JButton results = new JButton("view results");
        results.setBorder(border);
        customerRegistration.setSize(800, 400);
        customerRegistration.setLocationRelativeTo(null);
        customerRegistration.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        customerRegistration.getContentPane().setBackground(Color.decode("#1D16B0"));
        customerRegistration.getContentPane().setForeground(Color.decode("#1D16B0"));
        customerRegistration.setResizable(false);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 3)); // changed here
        JPanel panelFields1 = new JPanel();
        panelFields1.setLayout(new GridLayout(15,1));
        panelFields1.setSize(175,350);
        JPanel panelFields2 = new JPanel();
        panelFields2.setLayout(new GridLayout(3,1));
//        panelFields2.setSize(175,350);
        JPanel panelField3 = new JPanel();
        panelFields2.setLayout(new GridLayout(12,1)); //new
        panelField3.setLayout(new GridLayout(2,1));
//setLocation was here
        panel.setSize(550,350);
        panel.setBorder(border);
        JPanel customerInfo1 = new JPanel();
        customerInfo1.setBackground(Color.decode("#A5A5AB"));
        JLabel name = new JLabel("Last Name");
        JTextField nameArea = new JTextField(15);
        JLabel name2 = new JLabel("First Name");
        JTextField nameArea2 = new JTextField(12);
        JTextField spacer = new JTextField(12);
        JLabel email = new JLabel("Email");
        JTextField emailArea = new JTextField(15);// add validations
        JLabel phone = new JLabel("phone");
        JTextField phoneNumberArea = new JTextField(14); // add validations
        JLabel age = new JLabel("Birth year");
        JLabel askGender = new JLabel("Gender:");
        JTextField ageArea = new JTextField(3);
        JTextField spacer2 = new JTextField(12);
        spacer.setVisible(false);
        String[] choices = {"Male", "Female"};
        final JComboBox<String> gender = new JComboBox<String>(choices);

        gender.setMaximumSize(gender.getPreferredSize());
        gender.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelFields1.add(name);
        panelFields1.add(nameArea);
        panelFields1.add(name2);
        panelFields1.add(nameArea2);
        panelFields1.add(email);
        panelFields1.add(emailArea);
        panelFields1.add(phone);
        panelFields1.add(phoneNumberArea);
        panelFields1.add(spacer);
        panelFields1.add(askGender);
        panelFields1.add(gender);
        panelFields1.add(spacer);
        panelFields1.add(spacer2);
        panelFields1.add(age);
        panelFields1.add(ageArea);
        customerInfo1.add(panelFields1);
        panel.add(customerInfo1);

        // start panel 2 here?
        JLabel dateLabel = new JLabel("Today's Date:");
        JPanel customerInfo2 = new JPanel(new GridBagLayout());
        customerInfo2.setBackground(Color.decode("#100B7A"));
        Calendar today = Calendar.getInstance();
        today.set(Calendar.HOUR_OF_DAY, 0);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd"+", "+ "HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String theTime = dtf.format(now);

        dateLabel.setHorizontalAlignment(JTextField.CENTER);
        JTextField date = new JTextField(String.valueOf(theTime));
        date.setHorizontalAlignment(JTextField.CENTER);
        ZoneId zonedId = ZoneId.of( "America/Montreal" );
        LocalDate today2 = LocalDate.now( zonedId );
        JLabel date2 = new JLabel("<html><c>"+String.valueOf(today2)+"</c></html>");
        date2.setHorizontalAlignment(JTextField.CENTER);
        panelFields2.add(date2);
        panelFields2.add(dateLabel);
        panelFields2.add(date);
        //Calendar
        JLabel chooseMonth = new JLabel("Choose A Month:");
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        final JComboBox<String> monthList = new JComboBox<String>(months);
        JLabel departure = new JLabel("Departure");
        monthList.setMaximumSize(gender.getPreferredSize());
        monthList.setAlignmentX(Component.CENTER_ALIGNMENT);

        String[] flightTime = {"6:00am", "11:00am", "6:30pm", "Other"};
        final JComboBox<String> flights = new JComboBox<String>(flightTime);
        flights.setMaximumSize(gender.getPreferredSize());
        flights.setAlignmentX(Component.CENTER_ALIGNMENT);

        //airlines
        JLabel airlinesLabel = new JLabel("Airline", SwingConstants.CENTER);
        String[] airlines = {"AirExpress", "Kalamazoo Airlines", "Private Charter"};
        final JComboBox<String> airlinesList = new JComboBox<String>(airlines);
        airlinesList.setMaximumSize(gender.getPreferredSize());
        airlinesList.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelFields2.add(airlinesLabel);
        panelFields2.add(airlinesList);
        panelFields2.add(spacer);

        panelFields2.add(spacer);
        panelFields2.add(chooseMonth);
        panelFields2.add(monthList);
//        panelFields2.add(spacer);
        JLabel dateField = new JLabel("Manually enter numerical date");
        JTextField enteredDate = new JTextField(3);

        panelFields2.add(dateField);
        panelFields2.add(enteredDate);

        panelFields2.add(departure);
        panelFields2.add(flights);
        panelFields2.setBackground(Color.GRAY);
        customerInfo2.add(panelFields2);


        //panel 3 below here
        JButton continueButton = new JButton("Continue");
        JButton searchTrips = new JButton("Search");
        searchTrips.setForeground(Color.BLUE);
        searchTrips.setFont(new Font("Arial", Font.PLAIN, 24));
        continueButton.setForeground(Color.GREEN);
        continueButton.setFont(new Font("Arial", Font.PLAIN, 36));
        continueButton.addActionListener( new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
//                purchase.ticket.setVisible(true);
                customerRegistration.setVisible(false);
                BoardingPassTicket pass = new BoardingPassTicket();
                    pass.BoardingPassTicket();
            }
        });
        searchTrips.addActionListener( new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                searchBox.setVisible(true);
            }
        });
        panel.add(customerInfo2);
        panelField3.add(searchTrips);
        panelField3.add(continueButton);
        panel.add(panelField3);
        customerRegistration.setUndecorated(true); // disables close with 'X' option
        customerRegistration.add(panel);
        customerRegistration.setVisible(true);


    }

    public static void main(String[] args) {
        System.out.println("Welcome to our Airport!");
        passengerInformation();
        searchBox.purchasedTicketSearch();
        purchase.purchasedTicket();

    }


}