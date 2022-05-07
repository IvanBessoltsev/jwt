package ru.IvanBessoltsev.learnUp.spring.JWTauth.authservice.entity;

import javax.persistence.*;

@Entity
@Table(name = "order_details")
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private Order order;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id")
    private Book bookID;

    @Column(name = "order_count")
    private int count;

    @Column(name = "price_order")
    private double price;

    public OrderDetails() {
    }

    public OrderDetails(int count, double price) {
        this.count = count;
        this.price = price;
    }


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Book getBookID() {
        return bookID;
    }

    public void setBookID(Book bookID) {
        this.bookID = bookID;
    }

}