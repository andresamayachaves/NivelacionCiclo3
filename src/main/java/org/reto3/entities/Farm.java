package org.reto3.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "farm")
public class Farm implements Serializable {
    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Integer id;

    @Column(name = "name")
    private  String name;

    @Column(name = "address")
    private String address;

    @Column(name = "extension")
    private Integer extension;

    @Column(name = "description")
    private String description;

    //Relationships
//    @ManyToOne (optional = false, fetch = FetchType.LAZY)
//    @JsonIgnoreProperties(value = {"categories"})
//    @JoinColumn(name = "category_id")
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties(value = {"farms"})
    @JoinColumn(name = "category_id")
    private Category category;

//    @OneToMany(mappedBy = "farm", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JsonIgnoreProperties(value = {"client", "farm"})
    @OneToMany(fetch=FetchType.EAGER)
    @JsonIgnoreProperties(value = {"client", "farm"})
    private Set<Message> messages = new HashSet<>();

//    @OneToMany(mappedBy = "farm", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @OneToMany(fetch=FetchType.EAGER)
    private Set<Reservation> reservations = new HashSet<>();


    //Constructor No-args
    public Farm() {
    }

    //Constructor
    public Farm(Integer id, String name, String address, Integer extension, String description, Category category) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.extension = extension;
        this.description = description;
        this.category = category;
    }

    //Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getExtension() {
        return extension;
    }

    public void setExtension(Integer extension) {
        this.extension = extension;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
