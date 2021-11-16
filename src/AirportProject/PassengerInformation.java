package AirportProject;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;

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
        GridBagConstraints c = new GridBagConstraints();
        panel.setSize(550,350);
        panel.setBorder(border);
        JPanel customerInfo1 = new JPanel();
        customerInfo1.setBackground(Color.ORANGE);
        panel.add(customerInfo1);
        JPanel customerInfo2 = new JPanel();
        customerInfo2.setBackground(Color.GREEN);
        JButton continueButton = new JButton("continue");
        customerRegistration.setUndecorated(true); // disables close with 'X' option
//        panel.add(customerInfo1);
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
