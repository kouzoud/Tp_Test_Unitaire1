package com.example.TP2_test_unitaire;

import com.example.TP2_test_unitaire.Person;
import com.example.TP2_test_unitaire.Person3;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PersonService {

    public static List<Person3> filterByAddress(String address) {
        List<Person3> mockPersonsDatabase = Arrays.asList(
                new Person3("Alice", "Doe", LocalDate.of(1990, 5, 12), "123 Rue A"),
                new Person3("Bob", "Smith", LocalDate.of(2005, 10, 15), "456 Rue B"),
                new Person3("Charlie", "Brown", LocalDate.of(1985, 3, 9), "123 Rue A")
        );

        Predicate<Person3> hasAddress = person -> person.getAddress().equals(address);

        return mockPersonsDatabase.stream()
                .filter(hasAddress)
                .collect(Collectors.toList());
    }

    public static List<Person3> filterAdults() {
        List<Person3> mockPersonsDatabase = Arrays.asList(
                new Person3("Alice", "Doe", LocalDate.of(1990, 5, 12), "123 Rue A"),
                new Person3("Bob", "Smith", LocalDate.of(2020, 10, 15), "456 Rue B"),
                new Person3("hicham", "aymane", LocalDate.of(1985, 3, 9), "789 Rue C")
        );

        Predicate<Person3> isAdult = person -> person.calculateAge() >= 18;

        return mockPersonsDatabase.stream()
                .filter(isAdult)
                .collect(Collectors.toList());
    }
}
