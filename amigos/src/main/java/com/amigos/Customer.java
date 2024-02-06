package com.amigos;

import java.util.Objects;

public class Customer {

    private String name;
    private String email;
    private int age;
    private double savings;

    public Customer(String name, String email, int age, double savings) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.savings = savings;
    }

    public String getEmail() {
        return email;
    }

    public double getSavings() {
        return savings;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSavings(double savings) {
        this.savings = savings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return age == customer.age && Double.compare(customer.savings, savings) == 0 && Objects.equals(name, customer.name) && Objects.equals(email, customer.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, age, savings);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", savings=" + savings +
                '}';
    }
}
