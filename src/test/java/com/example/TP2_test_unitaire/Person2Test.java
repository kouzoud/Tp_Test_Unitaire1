package com.example.TP2_test_unitaire;

import com.example.TP2_test_unitaire.Person;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class Person2Test {

    @Test
    void testTwoPersonAreEquals() {

        Set<Person2> people = new HashSet<>();
        Person2 person1 = new Person2(1, "simo");
        Person2 person2 = new Person2(2, "simo2");
        Person2 person3 = new Person2(1, "simo3");


        people.add(person1);
        people.add(person2);
        people.add(person3);

        assertThat(people).hasSize(2);
        assertThat(people).contains(person1, person2);
    }

    @Test
    void testException() {

        Set<Person2> people = new HashSet<>();
        people.add(new Person2(1, "mohamed"));
        people.add(new Person2(2, "salma"));


        assertThatThrownBy(() -> {
            for (Person2 p : people) {
                if (p.getId() == 1) {
                    people.remove(p);
                }
            }
        }).isInstanceOf(java.util.ConcurrentModificationException.class);
    }

    @Test
    void testRemoveWithIterator() {

        Set<Person2> people = new HashSet<>();
        Person2 person1 = new Person2(1, "simo1");
        Person2 person2 = new Person2(2, "simo5");
        people.add(person1);
        people.add(person2);

        Iterator<Person2> iterator = people.iterator();
        while (iterator.hasNext()) {
            Person2 p = iterator.next();
            if (p.getId() == 2) {
                iterator.remove();
            }
        }

        // Assert
        assertThat(people).hasSize(1);
        assertThat(people).contains(person1);
        assertThat(people).doesNotContain(person2);
    }
}
