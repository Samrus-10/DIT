package sam.rus.optionl.model;

import java.util.Objects;

public class Person {
    private String  firstName;
    private String secondName;

    private Person() {
    }

    private Person(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return this.firstName.equals(person.firstName) && this.secondName.equals(person.secondName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName);
    }

    @Override
    public String toString() {
        return String.format("%s %s ", this.secondName, this.firstName);
    }

    public static Builder newBuilder() {
        return new Person().new Builder();
    }

    public class Builder{
        private String fName;
        private String sName;

        public Builder() {
        }

        public Builder setFirstName(String firstName ){
            this.fName = firstName;
            return  this;
        }

        public Builder setSecondName(String secondName) {
            this.sName = secondName;
            return this;
        }

        public Person build(){
            return  new Person(fName, sName);
        }
    }
}
