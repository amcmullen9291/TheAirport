package AirportProject;

//<<<<<<< Updated upstream
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
//=======
//<<<<<<< Updated upstream
//=======
import javax.swing.*;
import java.awt.*;
//>>>>>>> Stashed changes
//>>>>>>> Stashed changes
import java.util.Random;

public class PurchasedTicket {

//<<<<<<< Updated upstream
    static PurchasedTicket PurchasedTicket;
//=======
//<<<<<<< Updated upstream
//>>>>>>> Stashed changes
    static String ticketNumberString ="";
    static double discount = 0.00;
    static double ticketPrice;
    static JFrame ticket;
    static PassengerInformation passenger;

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
//        passenger.customerRegistration.setVisible(false);
    }
}
////=======
//    //•	Name, Email, Phone Number, Gender, Age
//
//
//    private String firstName;
//    private String emailInfo;
//    private String phoneInfo;
//    private String ageInfo;
//    private int seatNumber;
//    private String departureTime;
//    private String departureGate;
//
//    public PurchasedTicket(String lastName, String firstName, String emailInfo, String phoneInfo, String ageInfo, int seatNumber, String departureTime, String departureGate) {
//        this.lastName = lastName;
//        this.firstName = firstName;
//        this.emailInfo = emailInfo;
//        this.phoneInfo = phoneInfo;
//        this.ageInfo = ageInfo;
//        this.seatNumber = seatNumber;
//        this.departureTime = departureTime;
//        this.departureGate = departureGate;
//    }
//    private String lastName;
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getEmailInfo() {
//        return emailInfo;
//    }
//
//    public void setEmailInfo(String emailInfo) {
//        this.emailInfo = emailInfo;
//    }
//
//    public String getPhoneInfo() {
//        return phoneInfo;
//    }
//
//    public void setPhoneInfo(String phoneInfo) {
//        this.phoneInfo = phoneInfo;
//    }
//
//    public String getAgeInfo() {
//        return ageInfo;
//    }
//
//    public void setAgeInfo(String ageInfo) {
//        this.ageInfo = ageInfo;
//    }
//
//    public int getSeatNumber() {
//        return seatNumber;
//    }
//
//    public void setSeatNumber(int seatNumber) {
//        this.seatNumber = seatNumber;
//    }
//
//    public String getDepartureTime() {
//        return departureTime;
//    }
//
//    public void setDepartureTime(String departureTime) {
//        this.departureTime = departureTime;
//    }
//
//    public String getDepartureGate() {
//        return departureGate;
//    }
//
//    public void setDepartureGate(String departureGate) {
//        this.departureGate = departureGate;
//    }
//
////================================================================
//
//}//end class
