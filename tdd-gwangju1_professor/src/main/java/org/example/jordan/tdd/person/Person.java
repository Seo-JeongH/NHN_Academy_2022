package org.example.jordan.tdd.person;

import java.util.Date;
import java.util.Objects;

public class Person {
    String name;
    double height;
    Home home = new Home();

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Person person = (Person) o;
        return Double.compare(person.height, height) == 0 &&
               Objects.equals(name, person.name) &&
               Objects.equals(home, person.home);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, height, home);
    }

    public Person(String name, double height) {
        this.name = name;
        this.height = height;
    }
}

class Home {
    Address address = new Address();
    Date ownedSince;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Home home = (Home) o;
        return Objects.equals(address, home.address) && Objects.equals(ownedSince, home.ownedSince);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, ownedSince);
    }
}

class Address {
    int number;
    String street;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Address address = (Address) o;
        return number == address.number && Objects.equals(street, address.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, street);
    }
}
