package com.springboot.assignment.springapplication.entity;

import lombok.Data;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "item")
public @Data class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private int id;

    @NotNull(message = "is Required")
    @Size(min = 2,message = "must not be null")
    @Column(name = "name")
    private String name;

    @NotNull(message = "is Required")
    @Min(value = 1,message = "should be greater than 1")
    @Column(name = "price")
    private int price;

    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(
            name = "items_customer",
            joinColumns = @JoinColumn(name = "item_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id"))
    private List<Customer> customers = new ArrayList<>();

    public Item(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public Item() {
    }
}
