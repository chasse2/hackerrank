package designpattern.builder;

/**
 * The Builder pattern avoids multiple constructors when there are many optional parameters
 *     <ul>
 *         <li>Inner class is {@code static} to allow access without instantiating the outer class</li>
 *         <li>Any required parameters are passed to the {@code Builder}'s constructor</li>
 *         <li>Any optional parameters are passed to the {@code Builder}'s setters</li>
 *         <li>If any invariants are violated, the {@code build} method should throw an {@code IllegalStateException}</li>
 *         <li>The exception's detail message should indicate which invariant is violated</li>
 *     </ul>
 * <p>
 * Example usage:  {@code Person person = new Person.Builder("George").id(123).age(97).build(); }
 */

public class Person {

    private final String name;
    private final int id;
    private final int age;

    private Person(final Person.Builder builder) {
        this.name = builder.name;
        this.id = builder.id;
        this.age = builder.age;
    }

    public static class Builder {

        private final String name;
        private int id = 0;
        private int age = 0;

        public Builder(final String name) {
            this.name = name;
        }

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }
}
