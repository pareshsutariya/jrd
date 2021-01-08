package net.xitiz.jrd.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Alteration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ApiModelProperty(notes = "Name should be atleast 2 characters long")
    @Size(min = 2, max = 25, message = "Name should be atleast 2 characters long, and max 25 characters")
    private String name;
    private Boolean isDeleted = false;

    public Alteration() {
    }

    public Alteration(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return "Alteration [id=" + id + ", isDeleted=" + isDeleted + ", name=" + name + "]";
    }
}
