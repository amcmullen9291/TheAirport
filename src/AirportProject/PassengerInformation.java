package AirportProject;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class PassengerInformation  extends JFrame {
    static PassengerInformation register;
    static JFrame customerRegistration;

//don't mind the colors or spacing, just setting things up
    public static void passengerInformation(){
        customerRegistration = new JFrame("Our Airport");
        Border border = new LineBorder(Color.RED, 13);
        JButton results = new JButton("view results");
        results.setBorder(border);
        customerRegistration.setSize(800, 400);
        customerRegistration.setLocationRelativeTo(null);
        customerRegistration.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        customerRegistration.getContentPane().setBackground(Color.decode("#1D16B0"));
        customerRegistration.getContentPane().setForeground(Color.decode("#1D16B0"));
        customerRegistration.setResizable(false);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 3));
        JPanel panelFields1 = new JPanel();
        panelFields1.setLayout(new GridLayout(15,1));
        panelFields1.setSize(175,350);
        JPanel panelFields2 = new JPanel();
        panelFields2.setLayout(new GridLayout(3,1));
//        panelFields2.setSize(175,350);
//setLocation was here
        panel.setSize(550,350);
        panel.setBorder(border);
        JPanel customerInfo1 = new JPanel();
        customerInfo1.setBackground(Color.ORANGE);
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
        JPanel customerInfo2 = new JPanel();
        customerInfo2.setBackground(Color.GREEN);
        Calendar today = Calendar.getInstance();
        today.set(Calendar.HOUR_OF_DAY, 0);
        LocalTime theDate = LocalTime.now();
        dateLabel.setHorizontalAlignment(JTextField.CENTER);
        JTextField date = new JTextField(String.valueOf(theDate));
        date.setHorizontalAlignment(JTextField.CENTER);
        ZoneId zonedId = ZoneId.of( "America/Montreal" );
        LocalDate today2 = LocalDate.now( zonedId );
        JLabel date2 = new JLabel("<html><c>"+String.valueOf(today2)+"</c></html>");
        date2.setHorizontalAlignment(JTextField.CENTER);
        panelFields2.add(date2);
        panelFields2.add(dateLabel);
        panelFields2.add(date);
//        panelFields2.add(date2);
        customerInfo2.add(panelFields2);

        //panel 3 below here
        JButton continueButton = new JButton("continue");
        customerRegistration.setUndecorated(true); // disables close with 'X' option
        panel.add(customerInfo2);
        panel.add(continueButton);
        customerRegistration.add(panel);
        customerRegistration.setVisible(true);


    }

    public static void main(String[] args) {
        System.out.println("Welcome to our Airport!");
        passengerInformation();
    }

}
