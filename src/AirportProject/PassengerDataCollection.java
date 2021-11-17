package AirportProject;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;

public class PassengerDataCollection implements Serializable {
    private static String fullName;
    private static String email;
    private static  String phone;
    private static String gender;
    private static int age;
    private static Date date;
    private static String destination;
    private static String departureTime;
    private static double ticketPrice;
    static HashMap<String, String> purchasedTicket = new HashMap<>();
    public static PassengerDataCollection guestInformation;

    public PassengerDataCollection(String fullName, String email, String phone, String gender, int age, Date date, String destination, String departureTime,double ticketPrice){
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.age = age;
        this.date = date;
        this.destination = destination;
        this.departureTime = departureTime;
        this.ticketPrice = ticketPrice;
        registerTicket();
    }

    public static void registerTicket(){
        purchasedTicket.put("Name:", fullName);
        purchasedTicket.put("Email:", email);
        purchasedTicket.put("Phone:", phone);
        purchasedTicket.put("Gender:", gender);
        purchasedTicket.put("Year Born:", String.valueOf(age));
        purchasedTicket.put("Flight Date:", String.valueOf(date));
        purchasedTicket.put("Destination:", destination);
        purchasedTicket.put("Departure Time:", departureTime);
        purchasedTicket.put("Price:", String.valueOf(ticketPrice));
        System.out.println("Ticket Information: " + purchasedTicket);
    }
        // need to write data to file
}