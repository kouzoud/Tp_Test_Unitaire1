package com.example.TP2_test_unitaire;

import com.example.TP2_test_unitaire.Person;
import com.example.TP2_test_unitaire.Person3;
import com.example.TP2_test_unitaire.PersonService;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class PersonServiceTest {

    @Test
    public void testFilterByAddress() {
        List<Person3> peopleLivingIn123RueA = PersonService.filterByAddress("123 Rue A");

        List<Person3> expectedPersonsLivingIn123RueA = Arrays.asList(
                new Person3("Alice", "Alice45", LocalDate.of(1990, 5, 12), "123 Rue A"),
                new Person3("Alice3", "Alice4", LocalDate.of(1985, 3, 9), "123 Rue A")
        );

        assertThat(peopleLivingIn123RueA).hasSize(2);
        assertThat(peopleLivingIn123RueA).containsExactlyInAnyOrderElementsOf(expectedPersonsLivingIn123RueA);
    }

    @Test
    public void testFilterAdults() {
        List<Person3> adults = PersonService.filterAdults();


        List<Person3> expectedAdultPersons = Arrays.asList(
                new Person3("hicham1", "hicham3", LocalDate.of(1990, 5, 12), "123 Rue A"),
                new Person3("hicham", "hicham5", LocalDate.of(1985, 3, 9), "789 Rue C")

        );

        assertThat(adults).containsExactlyInAnyOrderElementsOf(expectedAdultPersons);
    }
}
