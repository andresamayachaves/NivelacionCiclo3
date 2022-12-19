package org.reto3.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "client")
public class Client implements Serializable {
    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idClient;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;

    //Relationships
//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
//    @JsonIgnoreProperties(value = {"client"})
    @OneToMany(fetch=FetchType.EAGER)
    private Set<Message> messages = new HashSet<>();

//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "client", cascade = CascadeType.ALL,  orphanRemoval = true)
//    @JsonIgnoreProperties(value = {"client"})
    @OneToMany(fetch=FetchType.EAGER)
    private Set<Reservation> reservations = new HashSet<>();


    //Constructor No-args
    public Client() {
    }

    //Constructor

    public Client(Integer idClient, String email, String password, String name, Integer age, Set<Message> messages, Set<Reservation> reservations) {
        this.idClient = idClient;
        this.email = email;
        this.password = password;
        this.name = name;
        this.age = age;
        this.messages = messages;
        this.reservations = reservations;
    }


    //Getters and Setters

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Set<Message> getMessages() {
        return messages;
    }

    public void setMessages(Set<Message> messages) {
        this.messages = messages;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservation>reservations) {
        this.reservations = reservations;
    }
}
