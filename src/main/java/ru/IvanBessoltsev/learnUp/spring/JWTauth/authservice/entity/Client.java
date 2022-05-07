package ru.IvanBessoltsev.learnUp.spring.JWTauth.authservice.entity;

import javax.persistence.*;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private int clientID;

    @Column(name = "initials_client")
    private String initialsClient;

    @Column(name = "email")
    private String email;

    public Client() {
    }

    public Client(String initialsClient, String birthDate) {
        this.initialsClient = initialsClient;
        this.email = email;
    }

    public String getInitialsClient() {
        return initialsClient;
    }

    public void setInitialsClient(String initialsClient) {
        this.initialsClient = initialsClient;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getClientID() {
        return clientID;
    }
}