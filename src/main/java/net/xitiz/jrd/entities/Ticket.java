package net.xitiz.jrd.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String salesman;

    @Column(name = "Ticket_Number")
    private int ticketNumber;

    private String client;
    
    private String item;

    private String alterations;

    private float charge;
    
    @Column(name = "Due_Date")
    private Date dueDate;

    @Column(name = "Is_Deleted")
    private boolean isDeleted;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSalesman() {
        return salesman;
    }

    public void setSalesman(String salesman) {
        this.salesman = salesman;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getAlterations() {
        return alterations;
    }

    public void setAlterations(String alterations) {
        this.alterations = alterations;
    }

    public float getCharge() {
        return charge;
    }

    public void setCharge(float charge) {
        this.charge = charge;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return "Ticket [alterations=" + alterations + ", charge=" + charge + ", client=" + client + ", dueDate="
                + dueDate + ", id=" + id + ", isDeleted=" + isDeleted + ", item=" + item + ", salesman=" + salesman
                + ", ticketNumber=" + ticketNumber + "]";
    }
}
