package com.example.TP2_test_unitaire;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TriPerson {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Hamid", "Jamila"));
        people.add(new Person("Martin", "Bob"));
        people.add(new Person("Hamid", "Charles"));
        people.add(new Person("Bernard", "Jamila"));

        // Tri de la liste
        Collections.sort(people);

        // Affichage
        System.out.println("Liste triée de personnes : ");
        for (Person person : people) {
            System.out.println(person);
        }}
}
