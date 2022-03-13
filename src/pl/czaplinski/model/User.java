package pl.czaplinski.model;

import javax.annotation.processing.Generated;
import java.util.UUID;

public class User {

    private String firstName;
    private String lastName;
    private String email;
    private String ShipAddsress;

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
}
