package com.example.TP2_test_unitaire;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.example.TP2_test_unitaire.Person;

import org.junit.jupiter.api.Test;


public class PersonTest {

    @Test
    void TriPersonsAvecLastNameAndFirstName() {
        List<Person> people = new ArrayList<>();

        people.add(new Person("Kozoud","Mohamed"));
        people.add(new Person("ait ali","ahemad"));


        Collections.sort(people);
        assertThat(people).isNotNull();
        //assertJ
        assertThat(people)
                .extracting(Person::toString)
                .containsExactly(
                        "Kozoud, Mohamed",
                                 "ait ali, ahemad"

                );
    }
}
