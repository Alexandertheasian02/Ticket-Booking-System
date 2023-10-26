import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
public class Theatre {
    /*Creating 3 arrays with not giving the initial values. Using 'final' key-word to remove the ability to override
    * existing values. */
   static final int[] row1 = new int[12];
   static final int[] row2 = new int[16];
   static final int[] row3 = new int[20];
   static final ArrayList<Ticket> ticketList = new ArrayList<>();
   static ArrayList<Ticket> sortList = new ArrayList<>();
   public static void main(String [] args) {
       System.out.println("Welcome to the New Theatre");   //Welcome message.
       Scanner input = new Scanner(System.in);
       String option;
       while (true) {
           try {          //To avoid crashing the program.
               System.out.println("-----------------------------------------------------------------------------------------");
               System.out.println("Please select an option:");
               System.out.println("1) Buy a ticket");
               System.out.println("2) Print seating area");
               System.out.println("3) Cancel ticket");
               System.out.println("4) List available tickets");
               System.out.println("5) Save to file");
               System.out.println("6) Load from file");
               System.out.println("7) Print ticket information and total price");
               System.out.println("8) Sort tickets by price");
               System.out.println("     0) Quit");
               System.out.println("-----------------------------------------------------------------------------------------");
               System.out.print("Enter option: ");
               option = input.next();
               switch (option) {                  //To get the menu options from the user.
                   case "0":
                       System.out.println("Exiting program...");
                       System.exit(0);
                       break;
                   case "1":
                       buy_ticket();
                       break;
                   case "2":
                       print_seating_area();
                       break;
                   case "3":
                       cancel_ticket();
                       break;
                   case "4":
                       show_available();
                       break;
                   case "5":
                       save();
                       break;
                   case "6":
                       load();
                       break;
                   case "7":
                       show_tickets_info();
                       break;
                   case "8":
                       sort_tickets();
                       break;
                   default:
                       System.out.println("Enter a valid option!");
                       break;
               }
           } catch (Exception e) {
               System.out.println("An error occurred:" + e);
           }
       }
   }

   /* When the user inputs "1" as an option.
   *  To buy a ticket with all the validations. */
    private static void buy_ticket(){
        Scanner input = new Scanner(System.in);
        System.out.println("----Ticket Prices----");
        System.out.println("1st Row seats are £ 30");
        System.out.println("2nd Row seats are £ 20");
        System.out.println("3rd Row seats are £ 10");
        System.out.println();
        System.out.print("Enter your First Name: ");     //Getting user inputs for the reservation.
        String name = input.nextLine();
        System.out.print("Enter your Surname: ");
        String surname = input.nextLine();
        System.out.print("Enter your Email: ");
        String email = input.next();
        System.out.print("Enter row number (1-3): ");
        int row = input.nextInt();
        System.out.print("Enter seat number: ");
        int seat = input.nextInt();
        switch (row) {
            case 1:   //Validation for row 1.
                int price = 30;
                if (seat > 0 && seat <= row1.length && row1[seat - 1] == 0) {
                    Person person = new Person(name, surname, email);  //Assigning details as a new object
                    Ticket ticket = new Ticket(row, seat, price, person);   //Assigning details as a new object

                    // Add the ticket to the ticketList
                    ticketList.add(ticket);
                    sortList.add(ticket);
                    row1[seat - 1] = 1;
                    System.out.println("Ticket purchased successfully!");
                } else {
                    System.out.println("Seat not available or invalid seat number.");
                }
                break;
            case 2:      //Validation for row 2.
                price = 20;
                if (seat > 0 && seat <= row2.length && row2[seat - 1] == 0) {
                    Person person = new Person(name, surname, email);
                    Ticket ticket = new Ticket(row, seat, price, person);

                    // Add the ticket to the ticketList
                    ticketList.add(ticket);
                    sortList.add(ticket);
                    row2[seat - 1] = 1;
                    System.out.println("Ticket purchased successfully!");
                } else {
                    System.out.println("Seat not available or invalid seat number.");
                }
                break;
            case 3:     //Validation for row 3.
                price = 10;
                if (seat > 0 && seat <= row3.length && row3[seat - 1] == 0) {
                    Person person = new Person(name, surname, email);
                    Ticket ticket = new Ticket(row, seat, price, person);

                    // Add the ticket to the ticketList
                    ticketList.add(ticket);
                    sortList.add(ticket);
                    row3[seat - 1] = 1;
                    System.out.println("Ticket purchased successfully!");
                } else {
                    System.out.println("Seat not available or invalid seat number.");
                }

                break;
            default:   //Validation for row numbers.
                System.out.println("Invalid row number. Please select 1-3.");
                break;
        }
    }
    /* When the user inputs "2" as an option.
     * To print the seating area. */
    private static void print_seating_area() {
        System.out.print("\n     ***********\n     *  STAGE  *\n     ***********\n");
        System.out.println();
        System.out.print("    ");
        for (int i = 0; i < row1.length; i++) {
            if (row1[i] == 0) {
                System.out.print("O");
            } else {
                System.out.print("X");
            }
            if(i == 5){          //To get the space in the middle of the theatre.
                System.out.print(" ");
            }
        }
        System.out.println();   //To print the line gap
        System.out.print("  ");
        for (int j = 0; j < row2.length; j++) {
                if (row2[j] == 0) {
                    System.out.print("O");
                } else {
                    System.out.print("X");
                }
                if(j == 7){        //To get the space in the middle of the theatre.
                System.out.print(" ");
                }
        }
        System.out.println();     //To print the line gap
        for (int k = 0; k < row3.length; k++) {
                if (row3[k] == 0) {
                    System.out.print("O");
                } else {
                    System.out.print("X");
                }
                if(k == 9){         //To get the space in the middle of the theatre.
                System.out.print(" ");
                }
        }
        System.out.println();     //To print the line gap
    }
    /* When the user inputs "3" as an option.
     * To cancel a ticket with all the validations. */
    private static void cancel_ticket(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the row of your seat(1-3): ");   //Getting user inputs for the reservation.
        int row = input.nextInt();
        System.out.print("Enter seat number: ");
        int cancel = input.nextInt();   //seat number
        for (int i = 0; i < ticketList.size(); i++) {
            Ticket ticket = ticketList.get(i);      //To access all the tickets in the "ticketList" array list
            if (ticket.getRow() == row && ticket.getSeat() == cancel) {
                ticketList.remove(i);
                sortList.remove(i);
            } /*If the row and the seat(cancel) entered in "Option 3" is equal to the row and the seat in ticket object,
               the ticket will get removed from the array list */
        }
        switch (row) {
            case 1:     //Validation for row 1.
                if (cancel > 0 && cancel <= row1.length && row1[cancel - 1] == 1) {
                    row1[cancel - 1] = 0;
                    System.out.println("Ticket cancellation successful!");
                } else {
                    System.out.println("Seat is already available or invalid seat number.");
                }
                break;
            case 2:    //Validation for row 2.
                if (cancel > 0 && cancel <= row2.length && row2[cancel - 1] == 1) {
                    row2[cancel - 1] = 0;
                    System.out.println("Ticket cancellation successful!");
                } else {
                    System.out.println("Seat is already available or invalid seat number.");
                }
                break;
            case 3:     //Validation for row 3.
                if (cancel > 0 && cancel <= row3.length && row3[cancel - 1] == 1) {
                    row3[cancel - 1] = 0;
                    System.out.println("Ticket cancellation successful!");
                } else {
                    System.out.println("Seat is already available or invalid seat number.");
                }
                break;
            default:    //Validation for row numbers.
                System.out.println("Invalid row number. Please select 1-3.");
                break;
        }
    }
    /* When the user inputs "4" as an option.
     * To show all the seats available in row 1 , row 2 and row 3. */
    private static void show_available(){
        int num_find = 0;          //Available seats are marked as "0", to print all the available seats.
        System.out.print("Seats available in row 1: ");   //Available seats in row 1.
        int i = 0;
        while (i < row1.length){
            if (row1[i] == num_find){
                System.out.print(i + 1 + "  ");
            }
            i++;
            }
        System.out.println();
        System.out.print("Seats available in row 2: ");   //Available seats in row 2.
        int j = 0;
        while (j < row2.length){
            if (row2[j] == num_find){
                System.out.print(j + 1 + "  ");
            }
            j++;
        }
        System.out.println();
        System.out.print("Seats available in row 3: ");   //Available seats in row 3.
        int k = 0;
        while (k < row3.length){
            if (row3[k] == num_find){
                System.out.print(k + 1 + "  ");
            }
            k++;
        }
        System.out.println();
    }
    /* When the user inputs "5" as an option.
     * To save the row's information in a file with all the validations. */
    private static void save() {
        try {
            File file = new File("save.txt");
            boolean file_created = file.createNewFile();  //Creating a new file.
            if (file_created) {
                System.out.println("File created successfully:" + file.getName());
            } else if (file.exists()){
                System.out.println("File is already created.");
            } else {
                System.out.println("Error creating the file.");
            }
            PrintWriter fileWrite = new PrintWriter("save.txt");
            fileWrite.println("Row 1:");
            for(int seat:row1)     //Assigning a new variable for 'row 1' elements
                fileWrite.println(seat);

            fileWrite.println("Row 2:");
            for(int seat:row2)    //Assigning a new variable for 'row 2' elements
                fileWrite.println(seat);

            fileWrite.println("Row 3:");
            for(int seat:row3)    //Assigning a new variable for 'row 3' elements
                fileWrite.println(seat);

            fileWrite.close();   //close the connection between the source code and the external file.
            System.out.println("Successfully wrote to the file.");
        } catch (IOException ex) {
            System.out.println("\"An error occurred.\"" + ex);
        }
    }
    /* When the user inputs "6" as an option.
     * To load the file saved in option "5". */
    private static void load () {
        try{
            File inputfile = new File("save.txt");     //Linking the file that's already been created.
            Scanner read = new Scanner (inputfile);  //Scan an input file.
            int lineCount = 1;
            int lines_ignore_Row1 = 2;    //lines to be ignored in the file before assigning values(row 1)
            int lines_ignore_Row2 = 15;   //lines to be ignored in the file before assigning values(row 2)
            int lines_ignore_Row3 = 32;   //lines to be ignored in the file before assigning values(row 3)
            while(read.hasNext()) {
                String rule = read.nextLine();
                if (lineCount <= 13) {
                    if (!rule.startsWith("Row")) {
                        /*if the rule doesn't start with "Row",
                        * then it'll check "0"s and "1" s in the lines. */
                        if (rule.equals("0")) {
                            row1[lineCount - lines_ignore_Row1] = 0;
                        } else {
                            row1[lineCount - lines_ignore_Row1] = 1;
                        }
                    }
                    lineCount++;
                }
                else if (lineCount <= 30) {
                    if (!rule.startsWith("Row")) {
                        if (rule.equals("0")) {
                            row2[lineCount - lines_ignore_Row2] = 0;
                        } else {
                            row2[lineCount - lines_ignore_Row2] = 1;
                        }
                    }
                    lineCount++;
                }
                else if (lineCount <= 51) {
                    if (!rule.startsWith("Row")) {
                        if (rule.equals("0")) {
                            row3[lineCount - lines_ignore_Row3] = 0;
                        } else {
                            row3[lineCount - lines_ignore_Row3] = 1;
                        }
                    }
                    lineCount++;
                }
            }
            read.close();      //close the connection between the source code and the external file.
            System.out.println("Successfully loaded from the file!");
        } catch (IOException ex){
            System.out.println("\"An error occurred.\" " + ex);
        }

    }
    /* When the user inputs "7" as an option.
     * To print all the ticket info and the total. */
    private static void show_tickets_info(){
        int totalValue = 0;    //Setting an integer
        for (Ticket ticket: ticketList){
                ticket.print();    //User defined function in Ticket class
                System.out.println();
                totalValue += ticket.getPrice();          //add ticket prices
        }
        System.out.println("Total ticket price: £ " + totalValue);
    }

    /* When the user inputs "8" as an option.
     * To print the sorted ticket price. */
    private static void sort_tickets(){
        int finalIndex = sortList.size() - 2; //This is the index of the second-to-last element in the sortList array.
        Ticket temp;     //Declares a ticket variable called temp
        boolean exchanged = true;
        /*"Exchange" will be used to track whether any exchanges
            have been made during a pass through the array.*/
        while (exchanged) {
            exchanged = false;
            for (int i = 0; i <= finalIndex; i++) {
                int price_1 = sortList.get(i).getPrice();
                int price_2 = sortList.get(i + 1).getPrice();
                //These variables will be used to determine whether the two tickets should be swapped.
                if (price_1 > price_2) {
                    temp = sortList.get(i);
                    sortList.set(i, sortList.get(i + 1));
                    sortList.set(i + 1, temp);
                    exchanged = true;
                }
            } finalIndex--;
        }
        for (Ticket ticket: sortList){ //To print the sorted ticket info.
            ticket.print();
        }
    }
}