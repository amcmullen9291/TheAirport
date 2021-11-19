package AirportProject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class HashMapConversion {
    static HashMap<String, String> fullResultList = new HashMap<>();

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
                String[] parts = line.split("=", 2);
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
                System.out.println(key + ":" + map.get(key));
                fullResultList.put(key, map.get(key));
            }
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
