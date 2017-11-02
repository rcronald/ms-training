package com.demo;

/**
 * Created by rcronald on 11/1/17.
 */
public class Person {

    public enum Sex {
        Male("Male"),
        Female("Female");

        private String type;

        Sex(String type){
            this.type = type;
        }

        @Override
        public String toString() {
            return "Sex{" +
                    "type='" + type + '\'' +
                    '}';
        }
    }

    private String name;
    private String lastName;
    private int age;
    private Address address;
    private String gender;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Person(String name, String lastName, int age, Address address, String gender) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.address = address;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
