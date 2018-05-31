package designpattern.builder;

import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.Assert.*;

public class PersonTest {

    @Test
    public final void testBuilder() {
        final String name = "name";
        final int id = 123;
        final int age = 97;

        final Person person = new Person.Builder(name).id(id).age(age).build();

        assertEquals(name, ReflectionTestUtils.getField(person, "name"));
        assertEquals(id, ReflectionTestUtils.getField(person, "id"));
        assertEquals(age, ReflectionTestUtils.getField(person, "age"));
    }
}