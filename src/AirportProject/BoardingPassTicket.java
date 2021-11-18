package AirportProject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class BoardingPassTicket {

    static PassengerDataCollection passenger;
//    public static String FullName;
//    public static String email;
//    public static String phone;
    public static String gender = passenger.gender;
    public static int age = passenger.age;
//    public static Date date;
//    public static String origin;
//    public static String destination;
//    public static String departureTime;
//    public static double ticketPrice;
//    public static BoardingPassTicket boardingPass;
    /**
     * Number of the boarding pass ticket (start with 10000000)
     */
    private static long ticketNumber = 10000000; // change to randomGeneratedNumber
    private long passNumber = 10000000;
    private static double basePrice = 1000.00; //change price to based on destination
//    private String ticketFilename;
    static PassengerDataCollection guest;

    static Scanner sc = new Scanner(System.in);

    public  static void BoardingPassTicket() {
        System.out.println(">>>>>>>> Boarding Pass Ticket Generator <<<<<<<<<");
        System.out.println("Enter Passenger Information.");
        readInputs();
        ticketNumber++;
    }

     // Method to read data of the passenger required to generate boarding pass ticket.
    public static void readInputs() {

        // Ask user to enter name
        System.out.print("Enter FullName: ");
        passenger.fullName = sc.nextLine();

        // Ask user to enter email
        System.out.print("Enter Email: ");
        passenger.email =sc.nextLine();

        // Ask user to enter phone
        System.out.print("Enter Phone Number: ");
        passenger.phone = sc.nextLine();

        // Ask user to enter gender
        System.out.print("Enter Gender: "); //give choices, male or female
        passenger.gender = sc.nextLine();

        // Ask user to enter age
        System.out.print("Enter Age: "); //change to birth year
        passenger.age = sc.nextByte();

        // adding user's purchase date
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        passenger.date =  now.format(formatter);
        System.out.println("Current Time: " + passenger.date);
        System.out.println("-----------------");
        String placeHolder = sc.nextLine();

        // Ask user to enter origin
//        System.out.print("Enter Origin: "); // only option is "ourAirport"
        passenger.origin = "OurAirport";

        // Ask user to enter destination
        System.out.print("Enter Destination: "); // give the 2 options (plus other)
        passenger.destination = sc.nextLine();

        // Ask user to enter departure time
        System.out.print("Enter Departure Time (HH:MM): "); //give 3 time options+plus other(4other give time)
        passenger.departureTime= sc.nextLine();

        passenger.ticketPrice = calculatePrice(passenger.gender, passenger.age);

        guest = new PassengerDataCollection(passenger.fullName, passenger.email, passenger.phone, passenger.gender, passenger.age, passenger.date, passenger.origin,passenger.destination, passenger.departureTime, passenger.ticketPrice );
    } // sends collected data to constructor

    public static double calculatePrice(String gender, int age ) {
        double price = basePrice;
        //define passenger.ticketPrice again here
        if (age <= 12) {
            passenger.ticketPrice = (basePrice - (0.5 * basePrice));
        } else if (age >= 60) {
            passenger.ticketPrice  = (basePrice- (0.6 * basePrice));
        } else if (gender.equalsIgnoreCase("female")) {
            passenger.ticketPrice = (basePrice - (0.25 * basePrice));
        } //should be a second if; a person COULD be over 60 and a female

        return (int)passenger.ticketPrice;
    }
}
