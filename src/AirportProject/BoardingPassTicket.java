package AirportProject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BoardingPassTicket {

    static Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

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
    private static int basePrice = 1000; //change price to based on destination
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
        System.out.print("Enter full name: ");
        String nameEntered = sc.nextLine();
        while(!isValidName(nameEntered)) {
            System.out.println("Enter full name. ");
            nameEntered = sc.nextLine();
        }
        passenger.fullName = sc.nextLine();

        // Ask user to enter email
        System.out.print("Enter Email: ");
        String usersEnteredEmail = sc.nextLine();
        Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(usersEnteredEmail);
//        boolean matches = matcher.matches();
        while(!isValid(usersEnteredEmail)) {
                System.out.println("Please enter a valid Email address");
                usersEnteredEmail = sc.nextLine();
            }
        passenger.email = usersEnteredEmail;

        // Ask user to enter phone
        System.out.print("Enter Phone Number: ");
        String enteredPhoneNumber = sc.nextLine();
        while(!isValidPhone(enteredPhoneNumber)) {
            System.out.println("enter a valid format");
            enteredPhoneNumber = sc.nextLine();
        }
        passenger.phone = enteredPhoneNumber;

        // Ask user to enter gender
        System.out.println("Enter Passenger Gender: "); //give choices, male or female
        System.out.println("1.) Male");
        System.out.println("2.) Female");
        String passengerGender = sc.nextLine();
        switch(passengerGender){
            case "Male":
                passenger.gender = "Male";
                break;
            case "Female":
                passenger.gender = "Female";
                break;
            default:
                passenger.gender = "Unanswered";
        }
//        passenger.gender = sc.nextLine();

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
        passenger.origin = "OurAirport";

        // Ask user to enter destination
        System.out.println("Enter Destination: "); // give the 2 options (plus other)
        System.out.println("Enter 1 for ORD - Chicago O'Hare airport");
        System.out.println("Enter 2 for MSP - Minneapolis St. Paul");
        System.out.println("Enter 3 for other locations");
        String destination = sc.nextLine();
        switch(destination){
            case "1":
                passenger.destination = "ORD, Chicago O'Hare";
                break;
            case "2":
                passenger.destination = "MSP Minneapolis St Paul";
                break;
            case "3":
                passenger.destination = "Other";
                break;

            default:
                passenger.destination = "Other location";
        }

        // Ask user to enter departure time
        System.out.println("Enter Departure Time (HH:MM): ");
        System.out.println("1.) 6am departure ");
        System.out.println("2.) 11am departure");
        System.out.println("3.) 6:30pm departure");
        System.out.println("4.) Other");
        String departureTime = sc.nextLine();
        switch(departureTime){
            case "1":
                passenger.departureTime = "6:00am";
                passenger.arrivalTime = "7:15am";
                break;
            case "2":
                passenger.departureTime = "11:00am";
                passenger.arrivalTime = "1:15pm";
                break;
            case "3":
                passenger.departureTime = "6:30pm";
                passenger.arrivalTime = "7:20pm";
                break;
            case "4":
                passenger.departureTime = "Other";
                passenger.arrivalTime = "unlisted";
                break;

            default:
                passenger.departureTime = "00:00";
                passenger.arrivalTime = "00:00";
        }

        passenger.ticketPrice = calculatePrice(passenger.gender, passenger.age, passenger.destination);

        guest = new PassengerDataCollection(passenger.fullName, passenger.email, passenger.phone, passenger.gender, passenger.age, passenger.date, passenger.origin,passenger.destination, passenger.departureTime, passenger.ticketPrice, passenger.arrivalTime );
    } // sends collected data to constructor

    public static double calculatePrice(String gender, int age, String destination ) {
        float price = 1000F;
        if(destination.equals("ORD, Chicago O'Hare")){price = 800F;}
        if(destination.equals("MSP Minneapolis St Paul")){price = 600F;}
        //define passenger.ticketPrice again here
        if (gender.equalsIgnoreCase("female")) {
            passenger.ticketPrice = price - (0.25 * price);
        }
        if (age <= 12) {
            passenger.ticketPrice = price - (0.5 * price);
        }
        if (age >= 60) {
            passenger.ticketPrice  = price - (0.6 * price);
        }

        return passenger.ticketPrice;
    }
    private static boolean isValid(String usersEnteredEmail) {
        Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(usersEnteredEmail);
        boolean matches = matcher.matches();
        if (!matches) {
            return false;
        } else {
            return true;
        }
    }
    private static boolean isValidPhone(String usersEnteredPhone) {
        String validPhoneNumber = "^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]\\d{3}[\\s.-]\\d{4}$";
        Pattern pattern = Pattern.compile(validPhoneNumber);
        Matcher matcher = pattern.matcher(usersEnteredPhone);
        boolean matches = matcher.matches();
        if (!matches) {
            return false;
        } else {
            return true;
        }
    }
    private static boolean isValidName(String usersEnteredName) {
        String validName = "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$";
        Pattern pattern = Pattern.compile(validName);
        Matcher matcher = pattern.matcher(usersEnteredName);
        boolean matches = matcher.matches();
        if (!matches) { // allows for a return keystroke between first and last name
            return false;
        } else {
            return true;
        }
    }

}