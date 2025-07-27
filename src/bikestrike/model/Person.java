package bikestrike.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;

public abstract class Person implements Serializable {


    private final UUID id = UUID.randomUUID();

    public String firstName;
    public String lastName;
    private LocalDate birthDate;
    private Address address;
    private String   phoneNumber;

    protected Person() { }

    protected Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName  = lastName;
    }


    public int getAge() {
        return birthDate == null
                ? -1
                : Period.between(birthDate, LocalDate.now()).getYears();
    }


    public UUID getId(){ return id; }

    public String getFirstName(){ return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName(){ return lastName; }
    public void setLastName(String lastName){ this.lastName = lastName; }

    public LocalDate getBirthDate(){ return birthDate; }
    public void setBirthDate(LocalDate birthDate){ this.birthDate = birthDate; }

    public Address getAddress(){ return address; }
    public void setAddress(Address address){ this.address = address; }

    public String getPhoneNumber(){ return phoneNumber; }
    public void setPhoneNumber(String phoneNumber){ this.phoneNumber = phoneNumber; }


    @Override public String toString() {
        return firstName + " " + lastName;
    }
}
