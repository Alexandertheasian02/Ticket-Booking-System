public class Person {
    private String name;    // private = restricted access
    private String surname;
    private String email;

    //Parameterized constructor
    public Person(String name, String surname, String email){
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    //Getter methods for name,surname and email
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }
}

