package org.reto3.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "reservation")
public class Reservation implements Serializable {
    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Integer idReservation;

    @Column(name = "startDate")
    private  Date startDate;

    @Column(name = "devolutionDate")
    private  Date devolutionDate;

//    @Column(name = "status")
//    private  String status;
//
//    @Column(name = "score")
//    private String score;

    //RelationShips
//    @ManyToOne(optional = false, fetch = FetchType.LAZY)
//    @JsonIgnoreProperties(value = {"reservations"})
//    @JoinColumn(name = "farm_id")
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "farm_id")
    private Farm farm;

//    @ManyToOne(optional = false, fetch = FetchType.LAZY)
//    @JsonIgnoreProperties(value = {"messages", "reservations"})
//    @JoinColumn(name = "client_id")
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "client_id_client")
    private Client client;

    //Constructor No-args
    public Reservation() {
    }

    //Constructor

    public Reservation(Integer idReservation, Date startDate, Date devolutionDate, String status, Farm farm, Client client) {
        this.idReservation = idReservation;
        this.startDate = startDate;
        this.devolutionDate = devolutionDate;
//        this.status = status;
        this.farm = farm;
        this.client = client;
    }


    //Getters and Setters

    public Integer getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }

//    public String getScore() {
//        return score;
//    }
//
//    public void setScore(String score) {
//        this.score = score;
//    }

    public Farm getFarm() {
        return farm;
    }

    public void setFarm(Farm farm) {
        this.farm = farm;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
