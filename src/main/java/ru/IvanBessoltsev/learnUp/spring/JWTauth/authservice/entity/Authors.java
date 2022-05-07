package ru.IvanBessoltsev.learnUp.spring.JWTauth.authservice.entity;


import javax.persistence.*;

@Entity
@Table(name = "author")
public class Authors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private int authorID;

    @Column(name = "initials_author")
    private String initialsAuthor;

    public Authors() {
    }



    public Authors(String initialsAuthor) {
        this.initialsAuthor = initialsAuthor;
    }

    public String getInitialsAuthor() {
        return initialsAuthor;
    }

    public void setInitialsAuthor(String initialsAuthor) {
        this.initialsAuthor = initialsAuthor;
    }

    @Override
    public String toString() {
        return "Authors{" +
                "authorID=" + authorID +
                ", initialsAuthor='" + initialsAuthor + '\'' +
                '}';
    }
}