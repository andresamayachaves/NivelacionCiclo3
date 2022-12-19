package org.reto3.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "category")
public class Category implements Serializable {

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Integer id;

    @Column(name = "name")
    private  String name;

//    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch=FetchType.EAGER) //(mappedBy = "category", cascade = CascadeType.ALL)  //, fetch=FetchType.EAGER)
//    @JsonIgnoreProperties(value={"farms","category"})
    @OneToMany(fetch=FetchType.EAGER)
    @JsonIgnoreProperties("category")
    private Set<Farm> farms = new HashSet<>();

    @Column(name = "description")
    private String description;

    //Constructor No-args
    public Category() {
    }

    //Constructor with Id
    public Category(Integer id) {
        this.id = id;
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

    public Set<Farm> getFarms() {
        return farms;
    }

    public void setFarms(Set<Farm> farms) {
        this.farms = farms;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

