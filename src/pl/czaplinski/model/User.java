package pl.czaplinski.model;

public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String ShipAddsress;

    public User(String firstName, String lastName, String email, String shipAddsress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        ShipAddsress = shipAddsress;
    }
    public User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getShipAddsress() {
        return ShipAddsress;
    }
}
