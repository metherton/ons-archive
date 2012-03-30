package com.ethertons.domain;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class PersonBuilderTest {

    @Test
    public void personIsBuiltWithCorrectAttributes() throws Exception {

        Surname surname = new Surname();
        surname.setName("Etherton");

        Person father = new Person();
        father.setId(42);
        
        Person mother = new Person();
        mother.setId(43);
        
        Person builtPerson = new Person.Builder(1).firstName("Martin").surname(surname).father(father).mother(mother).fullname("Martin Etherton").build();
        assertThat(builtPerson.getId(), is(1));
        assertThat(builtPerson.getFirstName(), is("Martin"));
        assertThat(builtPerson.getSurname().getName(), is("Etherton"));
        assertThat(builtPerson.getFather().getId(), is(42));
        assertThat(builtPerson.getMother().getId(), is(43));
        assertThat(builtPerson.getFullname(), is("Martin Etherton"));
    }
}
