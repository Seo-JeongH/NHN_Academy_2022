package org.example.jordan.tdd.person;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void testIsEqualTo() {
        //... 테스트 코드
        Person sherlock = new Person("Sherlock", 1.80);
        sherlock.home.ownedSince = new Date(123);
        sherlock.home.address.street = "Baker Street";
        sherlock.home.address.number = 221;

        Person sherlock2 = new Person("Sherlock", 1.80);
        sherlock2.home.ownedSince = new Date(123);
        sherlock2.home.address.street = "Baker Street";
        sherlock2.home.address.number = 221;

        // success or fail?
        assertThat(sherlock).usingRecursiveComparison()
                            .isEqualTo(sherlock2);

        // success or fail?
        assertThat(sherlock).isEqualTo(sherlock2);
    }
}