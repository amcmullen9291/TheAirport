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
                if((PassengerInformation.emailArea.getText().equals(""))|| (PassengerInformation.emailArea.getText().equals(""))) {
                    String emailSearch = PassengerInformation.emailArea.getText();
                    String lastNameSearch = PassengerInformation.nameArea2.getText();
                    ;
                    try {
                        searchTickets(emailSearch, lastNameSearch);
                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    }
                }else{
                    System.out.println("Last name and email are required for search");
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

    public static Map searchTickets(String passengerEmail, String lastName) throws FileNotFoundException {
        Map<String, String> mapFileContents = new HashMap<String, String>();
        BufferedReader br = null;

        try{

            //create file object
            File file = new File("src/AirportProject/purchased_tickets.txt");

            //create BufferedReader object from the File
            br = new BufferedReader( new FileReader(file) );

            String line = null;

            //read file line by line
            while ( (line = br.readLine()) != null ){

                //split the line by :
                String[] parts = line.split(":");

                //first part is name, second is age
                String search = parts[1].trim();
                Integer age = Integer.parseInt( parts[1].trim() );

                //put name, age in HashMap if they are not empty
                if( (search.equals(passengerEmail)) || (search.equals(lastName)) )
                    mapFileContents.put("found", "Entry found");
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
        return mapFileContents;
    }
}
