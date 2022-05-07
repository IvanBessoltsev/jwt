package ru.IvanBessoltsev.learnUp.spring.JWTauth.authservice.entity;


import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int bookID;

    @Column(name = "title")
    private String title;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    private Authors authorID;

    @Column(name = "age")
    private int yearOfRelease;

    @Column(name = "count_page")
    private int countPage;

    @Column(name = "price")
    private double price;

    @Column(name = "stock_balance")
    private double stockBalance;



    public Book() {
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookID=" + bookID +
                ", title='" + title + '\'' +
                ", authorID=" + authorID +
                ", yearOfRelease=" + yearOfRelease +
                ", countPage=" + countPage +
                ", price=" + price +
                ", stockBalance=" + stockBalance +
                '}';
    }

    public Book(String title, int yearOfRelease, int countPage, double price, double stockBalance) {
        this.title = title;
        this.yearOfRelease = yearOfRelease;
        this.countPage = countPage;
        this.price = price;
        this.stockBalance = stockBalance;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Authors getAuthorID() {
        return authorID;
    }

    public void setAuthorID(Authors authorID) {
        this.authorID = authorID;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public int getCountPage() {
        return countPage;
    }

    public void setCountPage(int countPage) {
        this.countPage = countPage;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getBookID() {
        return bookID;
    }

    public double getStockBalance() {
        return stockBalance;
    }

    public void setStockBalance(double stockBalance) {
        this.stockBalance = stockBalance;
    }
}

