package AirportProject;

import java.io.*;
import java.util.*;

public class HashMapConversion {
    static String fullResultList = new String();
    static HashMap<String, String> ticketHash;
    static int i = 0;
    static String lineFromFile = "";
    static Scanner scanner = null;

    static void checkIfEmailExists(String email) throws FileNotFoundException {
        File file  = new File("src/AirportProject/return _purchase_tickets.txt");
        scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            lineFromFile = scanner.nextLine();
            if(lineFromFile.contains(email)) {
                // a match!
                System.out.println(email + " found!");
                getTicketInfo(email);
                break;
            }
        }
    }

    public static void getTicketInfo(String email) {
        {
            String filePath = "src/AirportProject/return _purchase_tickets.txt";
            HashMap<String, String> map = new HashMap<String, String>();

            String line = "";
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new FileReader(filePath));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            while (true) {
                try {
                    if (!((line = reader.readLine()) != null)) break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String[] parts = line.split(":", 2);
                if (line.contains(email)) {
                    if (parts.length >= 2) {
                        String key = parts[0];
                        String value = parts[1];
                        map.put(key, value);
                    } else {
                        System.out.println("searching... " + line);
                    }
                }
            }
            for (String key : map.keySet()) {
//                System.out.println(key + ":" + map.get(key));
                fullResultList = key + " " + map.get(key);
            }
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        regexToHash(fullResultList);
    }

    public static void regexToHash(String informationHash){
        ticketHash = new HashMap<String, String>();
        String newInformationHash = informationHash.substring(1, informationHash.length() - 1);
        List<String> firstDivision = Arrays.asList(newInformationHash.split(":"));
        String listString = "";
        for (String s : firstDivision) {
            listString += s + "\t";
        }
        listString = listString.replace('=', ':');
        ticketHash = finalConversion(listString);
        PurchasedTicket.showSearchResults();
    }

    public static HashMap<String, String> finalConversion(String originalString){
        HashMap<String, String> usableTicketData = new HashMap<String, String>();

        String parts[] = originalString.split(",");

        for (String part : parts) {

            String stringPortions[] = part.split(":");

            String keyName = stringPortions[0].trim();
            String keyValue = stringPortions[1].trim();

            usableTicketData.put(keyName, keyValue);
        }
        return  usableTicketData;
    }
}