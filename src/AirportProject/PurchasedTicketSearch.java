package AirportProject;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.EventListener;
import java.util.HashMap;
import java.util.Map;

public class PurchasedTicketSearch implements EventListener {

    static JFrame searchBox;
    public static String emailSearch;
    static int i = 1;
    static String line = "";
    static String lastDate = "";

    public static void purchasedTicketSearch() {
        Border border = new LineBorder(Color.GRAY, 8);
        searchBox = new JFrame();
        searchBox.setLocation(0, 0);
        searchBox.setSize(275, 200);
        JButton searchButton = new JButton("Search Purchased Tickets");
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchBox.setVisible(false);
                //check if required fields are empty
                if(!PassengerInformation.emailArea.getText().equals("")) {
                    emailSearch = PassengerInformation.emailArea.getText();
                    try {
                        searchTickets(emailSearch);
                        HashMapConversion.getTicketInfo(emailSearch);
                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    }
                }else{
                    System.out.println("A valid Email is required for search");
                }
            }
        });

        searchButton.setVisible(true);
        searchButton.setLocation(0, 175);
        searchButton.setBorder(border);
        searchBox.setForeground(Color.RED);
        searchBox.setUndecorated(true);
        searchBox.add(searchButton);
        searchBox.setVisible(false);

    }

    public void setVisible(boolean b) {
        searchBox.setVisible(b);
    }

    public static void searchTickets(String passengerEmail) throws FileNotFoundException {
        Map<String, String> mapFileContents = new HashMap<String, String>();
        BufferedReader br = null;
        System.out.println("searching for " + passengerEmail );
        System.out.println(" ");
        try{

            //create file object
            File file = new File("src/AirportProject/purchased_tickets.txt");

            //create BufferedReader object from the File
            br = new BufferedReader( new FileReader(file) );

            line = br.readLine();

            //read file line by line
            while ( (line = br.readLine()) != null ){
                //put name, age in HashMap if they are not empty
                if(line.contains(passengerEmail)){
                    for(int x=1; x<4; x++) {
                        lastDate = br.readLine();
                    }
                    System.out.println(emailSearch + " found " + i + " times");
                    System.out.println("Ticket found: " + lastDate);
//                        mapFileContents.put(emailSearch, " found");
                    i++;
                }
            }

        }catch(Exception e){
            e.printStackTrace();
        }finally{

            if(br != null){
                try {
                    br.close();
                }catch(Exception e){};
            }
        }
//        System.out.println(mapFileContents);
//        return mapFileContents;
    }
}