public class Ticket {
    private int row;   // private = restricted access
    private int seat;
    private int price;
    private Person person;

    //Parameterized constructor
    public Ticket(int row, int seat, int price, Person person) {
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.person = person;
    }

    //Getter methods for row,seat and price
    public int getRow() {
        return row;
    }

    public int getSeat() {
        return seat;
    }

    public int getPrice() {
        return price;
    }

    public Person getPerson() {
        return person;
    }

    public void print(){
        System.out.println();
        System.out.println("Ticket Information:-");
        System.out.println("Name: " + getPerson().getName());
        System.out.println("Surname: " + getPerson().getSurname());
        System.out.println("Email: " + getPerson().getEmail());
        System.out.println("Row: " + getRow());
        System.out.println("Seat: " + getSeat());
        System.out.println("Price: £ " + getPrice());
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "row=" + row +
                ", seat=" + seat +
                ", price=" + price +
                ", person=" + person +
                '}';
    }
}
