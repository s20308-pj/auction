package pl.czaplinski.model;

public class User {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    public User(String firstName, String lastName, String email) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public User() {
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
}
