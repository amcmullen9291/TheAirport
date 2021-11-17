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

    private String FullName;
    private String email;
    private String phone;
    private String gender;
    private int age;
    private Date date;
    private String origin;
    private String destination;
    private String departureTime;
    private double ticketPrice;
    /**
     * Number of the boarding pass ticket (start with 10000000)
     */
    private static long ticketNumber = 10000000;
    private long passNumber;
    private final double basePrice = 1000;
    private String ticketFilename;

    private Scanner sc = new Scanner(System.in);

    public BoardingPassTicket() {
        System.out.println(">>>>>>>> Boarding Pass Ticket Generator <<<<<<<<<");
        readInputs();
        ticketNumber++;
    }

     // Method to read data of the passenger required to generate boarding pass ticket.
    private void readInputs() {
        setPassNumber(ticketNumber);

        // Ask user to enter name
        System.out.print("Enter FullName: ");
        setName(sc.nextLine());

        // Ask user to enter email
        System.out.print("Enter Email: ");
        setEmail(sc.nextLine());

        // Ask user to enter phone
        System.out.print("Enter Phone Number: ");
        setPhone(sc.nextLine());

        // Ask user to enter gender
        System.out.print("Enter Gender: ");
        setGender(sc.nextLine());

        // Ask user to enter age
        System.out.print("Enter Age: ");
        setAge(Integer.parseInt(sc.nextLine()));

        // Ask user to enter date
        System.out.print("Enter Date (DD/MM/YYY): ");
        try {
            setDate(new SimpleDateFormat("dd/MM/yyyy").parse(sc.nextLine()));
        } catch (ParseException e) {
            System.out.println("Invalid Date format !!!");
        }

        // Ask user to enter origin
        System.out.print("Enter Origin: ");
        setOrigin(sc.nextLine());

        // Ask user to enter destination
        System.out.print("Enter Destination: ");
        setDestination(sc.nextLine());

        // Ask user to enter departure time
        System.out.print("Enter Departure Time (HH:MM): ");
        setDepartureTime(sc.nextLine());

        setTicketPrice(calculatePrice());

        ticketFilename = String.format("%s_%s.txt", passNumber, FullName.toUpperCase());

        System.out.println();
    }

    public long getPassNumber() {
        return passNumber;
    }

    public void setPassNumber(long passNumber) {
        this.passNumber = passNumber;
    }
    public double getBasePrice() {
        return basePrice;
    }

    public String getName() {
        return FullName;
    }

    public void setName(String name) {
        this.FullName = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getOrigin() {
        return origin;
    }
    public void setOrigin(String origin) {
        this.origin = origin;
    }
    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
    public String getDepartureTime() {
        return departureTime;
    }
    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }
    public double getTicketPrice() {
        return ticketPrice;
    }
    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
    public static long getTicketNumber() {
        return ticketNumber;
    }

    public static void setTicketNumber(long ticketNumber) {
        BoardingPassTicket.ticketNumber = ticketNumber;
    }

    public String getETA() {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        int y = calendar.get(Calendar.YEAR);
        int m = calendar.get(Calendar.MONTH) + 1;
        int d = calendar.get(Calendar.DAY_OF_MONTH);
        int h = Integer.parseInt(departureTime.split(":")[0]);
        int min = Integer.parseInt(departureTime.split(":")[1]);

        return LocalDateTime.of(y, m, d, h, min).minusMinutes(5)
                .format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
    }
    public String getDepartureTimeString() {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        int y = calendar.get(Calendar.YEAR);
        int m = calendar.get(Calendar.MONTH) + 1;
        int d = calendar.get(Calendar.DAY_OF_MONTH);
        int h = Integer.parseInt(departureTime.split(":")[0]);
        int min = Integer.parseInt(departureTime.split(":")[1]);

        return LocalDateTime.of(y, m, d, h, min).format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
    }
    public double calculatePrice() {
        double price = basePrice;

        if (age <= 12) {
            price -= 0.5 * price;
        } else if (age >= 60) {
            price -= 0.6 * price;
        } else if (gender.equalsIgnoreCase("female")) {
            price -= 0.25 * price;
        }

        return price;
    }
    public void generateTicket() throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter(ticketFilename));

        writer.println("=============================================================");
        writer.printf("%20s%3s %s\n", "Bording Pass Number", ":", getPassNumber());
        writer.printf("%20s%3s %s\n", "Date", ":", new SimpleDateFormat("dd/MM/yyyy").format(getDate()));
        writer.printf("%20s%3s %s\n", "Origin", ":", getOrigin());
        writer.printf("%20s%3s %s\n", "Destination", ":", getDestination());
        writer.printf("%20s%3s %s\n", "ETA", ":", getETA());
        writer.printf("%20s%3s %s\n", "Departure Time", ":", getDepartureTimeString());
        writer.printf("%20s%3s %s\n", "Passenger Name", ":", getName());
        writer.printf("%20s%3s %s\n", "Email", ":", getEmail());
        writer.printf("%20s%3s %s\n", "Phone Number", ":", getPhone());
        writer.printf("%20s%3s %s\n", "Gender", ":", getGender());
        writer.printf("%20s%3s %s\n", "Age", ":", getAge());
        writer.printf("%20s%3s %s\n", "Total Ticket Price", ":", "$" + getTicketPrice());
        writer.println("=============================================================");

        writer.close();
    }

    public void displayTicket() throws FileNotFoundException {
        Scanner file = new Scanner(new File(ticketFilename));

        while (file.hasNext()) {
            System.out.println(file.nextLine());
        }

        file.close();
    }

    public static void main(String[] args) throws IOException {
        BoardingPassTicket ticket = new BoardingPassTicket();
        ticket.generateTicket();
        System.out.println();
        ticket.displayTicket();
    }
}
