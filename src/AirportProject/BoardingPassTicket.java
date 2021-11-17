package AirportProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class BoardingPassTicket {

    static PassengerDataCollection passenger;
    public static String FullName;
    public static String email;
    public static String phone;
    public static String gender = passenger.gender;
    public static int age = passenger.age;
    public static Date date;
    public static String origin;
    public static String destination;
    public static String departureTime;
    public static double ticketPrice;
    public static BoardingPassTicket boardingPass;
    /**
     * Number of the boarding pass ticket (start with 10000000)
     */
    private static long ticketNumber = 10000000; // change to randomGeneratedNumber
    private long passNumber = 10000000;
    private static double basePrice = 1000;
    private String ticketFilename;
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
//        setPassNumber(ticketNumber);

        // Ask user to enter name
        System.out.print("Enter FullName: ");
        passenger.fullName = sc.nextLine();
//        setName(sc.nextLine());

        // Ask user to enter email
        System.out.print("Enter Email: ");
        passenger.email =sc.nextLine();
//        setEmail(sc.nextLine());

        // Ask user to enter phone
        System.out.print("Enter Phone Number: ");
        passenger.phone = sc.nextLine();
//        setPhone(sc.nextLine());

        // Ask user to enter gender
        System.out.print("Enter Gender: ");
        passenger.gender = sc.nextLine();
//        setGender(sc.nextLine());

        // Ask user to enter age
        System.out.print("Enter Age: ");
        passenger.age = sc.nextByte();
//        setAge(Integer.parseInt(sc.nextLine()));

        // Ask user to enter date
        System.out.print("Enter Date (DD/MM/YYY): ");
        try {
            passenger.date = new SimpleDateFormat("dd/MM/yyyy").parse(sc.nextLine());
        } catch (ParseException e) {
            System.out.println("Invalid Date format !!!");
        }

        // Ask user to enter origin
        System.out.print("Enter Origin: ");
        passenger.origin = sc.nextLine();
//        setOrigin(sc.nextLine());

        // Ask user to enter destination
        System.out.print("Enter Destination: ");
        passenger.destination = sc.nextLine();
//        setDestination(sc.nextLine());

        // Ask user to enter departure time
        System.out.print("Enter Departure Time (HH:MM): ");
        passenger.departureTime= sc.nextLine();
//        setDepartureTime(sc.nextLine());

        passenger.ticketPrice = calculatePrice(passenger.gender, passenger.age);

//        ticketFilename = String.format("%s_%s.txt", passNumber, FullName.toUpperCase());

//        System.out.println();
        guest = new PassengerDataCollection(passenger.fullName, passenger.email, passenger.phone, passenger.gender, passenger.age, passenger.date, passenger.origin,passenger.destination, passenger.departureTime, passenger.ticketPrice );
    } // sends collected data to constructor

//    public static long getPassNumber() {
//        return passNumber;
//    }
//
//    public static void setPassNumber(long passNumber) {
//        this.passNumber = passNumber;
//    }
////    public static double getBasePrice() {
////        return basePrice;
////    }
//
//    public static String getName() {
//        return FullName;
//    }
//
//    public static void setName(String name) {
//        this.FullName = name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public static void setEmail(String email) {
//        this.email = email;
//    }
//
//    public static String getPhone() {
//        return phone;
//    }
//    public static void setPhone(String phone) {
//        this.phone = phone;
//    }
//    public static String getGender() {
//        return gender;
//    }
//
//    public static void setGender(String gender) {
//        this.gender = gender;
//    }
//    public static int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public Date getDate() {
//        return date;
//    }
//
//    public void setDate(Date date) {
//        this.date = date;
//    }
//
//    public String getOrigin() {
//        return origin;
//    }
//    public void setOrigin(String origin) {
//        this.origin = origin;
//    }
//    public String getDestination() {
//        return destination;
//    }
//
//    public void setDestination(String destination) {
//        this.destination = destination;
//    }
//    public String getDepartureTime() {
//        return departureTime;
//    }
//    public void setDepartureTime(String departureTime) {
//        this.departureTime = departureTime;
//    }
//    public double getTicketPrice() {
//        return ticketPrice;
//    }
//    public void setTicketPrice(double ticketPrice) {
//        this.ticketPrice = ticketPrice;
//    }
//    public static long getTicketNumber() {
//        return ticketNumber;
//    }
//
//    public static void setTicketNumber(long ticketNumber) {
//        BoardingPassTicket.ticketNumber = ticketNumber;
//    }
//
//    public String getETA() {
//        Calendar calendar = new GregorianCalendar();
//        calendar.setTime(date);
//        int y = calendar.get(Calendar.YEAR);
//        int m = calendar.get(Calendar.MONTH) + 1;
//        int d = calendar.get(Calendar.DAY_OF_MONTH);
//        int h = Integer.parseInt(departureTime.split(":")[0]);
//        int min = Integer.parseInt(departureTime.split(":")[1]);
//
//        return LocalDateTime.of(y, m, d, h, min).minusMinutes(5)
//                .format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
//    }
//    public String getDepartureTimeString() {
//        Calendar calendar = new GregorianCalendar();
//        calendar.setTime(date);
//        int y = calendar.get(Calendar.YEAR);
//        int m = calendar.get(Calendar.MONTH) + 1;
//        int d = calendar.get(Calendar.DAY_OF_MONTH);
//        int h = Integer.parseInt(departureTime.split(":")[0]);
//        int min = Integer.parseInt(departureTime.split(":")[1]);
//
//        return LocalDateTime.of(y, m, d, h, min).format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
//    }
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
//    public void generateTicket() throws IOException {
//        PrintWriter writer = new PrintWriter(new FileWriter(ticketFilename));
//
//        writer.println("=============================================================");
//        writer.printf("%20s%3s %s\n", "Bording Pass Number", ":", getPassNumber());
//        writer.printf("%20s%3s %s\n", "Date", ":", new SimpleDateFormat("dd/MM/yyyy").format(getDate()));
//        writer.printf("%20s%3s %s\n", "Origin", ":", getOrigin());
//        writer.printf("%20s%3s %s\n", "Destination", ":", getDestination());
//        writer.printf("%20s%3s %s\n", "ETA", ":", getETA());
//        writer.printf("%20s%3s %s\n", "Departure Time", ":", getDepartureTimeString());
//        writer.printf("%20s%3s %s\n", "Passenger Name", ":", getName());
//        writer.printf("%20s%3s %s\n", "Email", ":", getEmail());
//        writer.printf("%20s%3s %s\n", "Phone Number", ":", getPhone());
//        writer.printf("%20s%3s %s\n", "Gender", ":", getGender());
//        writer.printf("%20s%3s %s\n", "Age", ":", getAge());
//        writer.printf("%20s%3s %s\n", "Total Ticket Price", ":", "$" + getTicketPrice());
//        writer.println("=============================================================");
//
//        writer.close();
//    }
//
//    public void displayTicket() throws FileNotFoundException {
//        Scanner file = new Scanner(new File(ticketFilename));
//
//        while (file.hasNext()) {
//            System.out.println(file.nextLine());
//        }
//
//        file.close();
//    }
//
//    public static void createTicket() throws IOException {
//        BoardingPassTicket ticket = new BoardingPassTicket();
//        ticket.generateTicket();
//        System.out.println();
//        ticket.displayTicket();
//    }
}
