package com.ethertons.domain;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class PersonBuilderTest {

    @Test
    public void personIsBuiltWithCorrectAttributes() throws Exception {

        Surname surname = new Surname();
        surname.setName("Etherton");

        Person builtPerson = new Person.Builder(1).firstName("Martin").surname(surname).build();
        assertThat(builtPerson.getId(), is(1));
        assertThat(builtPerson.getFirstName(), is("Martin"));
        assertThat(builtPerson.getSurname().getName(), is("Etherton"));
    }
}
