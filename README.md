# TheAirport

Notes:
I changed the structure of our app. My initial JFrame can be used for searches. The user will just have to click the continue button to bring entering user information in the terminal from your Class methods.

I commented out your "setAttribute" methods because I put the attributes in a HashMap.
WE may not NEED the use the PassengerDataCollection instance but, it makes it easier to read.

the second JFrame for displaying ticket info after purchase will stay about the same because now all the information belongs to an object and, it will be easy to .setText for the JTextFields.

***We still need CSV file for storing passenger info after a ticket is sold. but i think i can do the write method.

Also, could you change you discountTicketPrice method to take a parameter of "year born" instead of age? It just sounds nicer.
(you can do 2021- age. that should work). You will also have to change the question asked from the CLI.
We should also change ticket price based on the destination. Please only use the 3 destinations currently listed

we need a Method for Randomly generated boarding number ** I changed this method to randomly create an alphanumeric string.


extra:
add form validations. we can both look up validation in the morning
