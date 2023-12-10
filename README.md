
Title: New Theatre Ticket Management System in Java

Description:

Welcome to the New Theatre Ticket Management System, a Java program designed and implemented to efficiently manage and control seat reservations for the New Theatre's sessions. This project consists of a main program, Theatre.java, along with two additional classes, Person.java and Ticket.java, creating a robust object-oriented solution.

Key Features:

1. Main Program (Theatre.java):

Displays a welcome message at the start of the program.
Maintains three arrays to record the status of seats (0 for free, 1 for occupied) for three rows with different seat capacities (12, 16, and 20).
Implements a user-friendly menu with eight options:
Buy a ticket
Print seating area
Cancel ticket
List available seats
Save to file
Load from file
Print ticket information and total price
Sort tickets by price
Quit

2. Classes and Objects:

Person.java:

Represents a person with attributes: name, surname, and email.
Constructor initializes the person with the given attributes.
Ticket.java:

Represents a ticket with attributes: row, seat, price, and a Person object.
Constructor creates a ticket with the provided attributes.
Includes a print method to display ticket information.

3. Ticket Management:

Utilizes an ArrayList to store and manage Ticket objects.
Enables ticket purchase and cancellation, updating seat availability accordingly.
Provides methods to display available seats, save and load data to/from a file, and print ticket information.

4. Additional Functionality:

Calculates and displays the total price of all tickets.
Implements ticket sorting based on price, displaying the sorted information.

How to Use:

Clone the repository and run the Theatre.java file.
Follow the menu prompts to interact with the New Theatre Ticket Management System.


This project serves as a comprehensive solution for managing and controlling seat reservations, providing a seamless experience for both the theatre staff and patrons. Explore the code and enhance your understanding of Java programming with this practical application.
