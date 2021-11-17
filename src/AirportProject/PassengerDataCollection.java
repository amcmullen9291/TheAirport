package AirportProject;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

public class PassengerDataCollection implements Serializable {
    public static String fullName;
    public static String email;
    public static  String phone;
    public static String gender;
    public static int age;
    public static Date date;
    public static String destination;
    public static String departureTime;
    public static double ticketPrice;
    public static String ticketNumber;
    static HashMap<String, String> purchasedTicket = new HashMap<>();
    public static PassengerDataCollection guestInformation;
    public static String origin;
    static PurchasedTicket ticketSold;

    public PassengerDataCollection(String fullName, String email, String phone, String gender, int age, Date date, String origin, String destination, String departureTime,double ticketPrice){
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.age = age;
        this.date = date;
        this.destination = destination;
        this.departureTime = departureTime;
        this.ticketPrice = ticketPrice;
        this.origin = origin;
        registerTicket();
    }

    public static void registerTicket(){
        purchasedTicket.put("Name", fullName);
        purchasedTicket.put("Email", email);
        purchasedTicket.put("Phone", phone);
        purchasedTicket.put("Gender", gender);
        purchasedTicket.put("Age", String.valueOf(age)); //change to year born
        purchasedTicket.put("Flight Date", String.valueOf(date));
        purchasedTicket.put("Destination", destination);
        purchasedTicket.put("Departure Time", departureTime);
        purchasedTicket.put("Price", String.valueOf(ticketPrice));
        getTicketString();
        System.out.println("Ticket Information: " + purchasedTicket);
        ticketSold = new PurchasedTicket();
        ticketSold.setVisible(true);
    }
        // need to write data to file

    public static void getTicketString() { // just a suggestion for randomly generated boardingPass Number
        String ticketNumber = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 9) { // length of the random string.
            int index = (int) (rnd.nextFloat() * ticketNumber.length());
            salt.append(ticketNumber.charAt(index));
        }
        guestInformation.ticketNumber = salt.toString();
        purchasedTicket.put("Ticket Number: ", guestInformation.ticketNumber);

    }
}