package com.amigos;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Customer {

    @Id
    @SequenceGenerator (
            name = "customer_id_generator",
            sequenceName = "customer_id_generator",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_id_generator"
    )

    private int id;
    private String name;
    private String email;
    private int age;
    private double savings;


    public Customer(int id, String name, String email, int age, double savings) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.savings = savings;
    }

    public Customer() {}

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
