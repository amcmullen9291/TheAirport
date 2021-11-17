package AirportProject;

import java.util.Random;

public class PurchasedTicket {

    static String ticketNumberString ="";
    static double discount = 0.00;

    public static void purchasedTicket(){

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
}
