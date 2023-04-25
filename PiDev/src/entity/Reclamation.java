/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;

/**
 *
 * @author Administrateur
 */
public class Reclamation {
    
    
    private int id;
    private Date date;
    private String type;
    private String etat;
    private String description;

    public Reclamation() {
    }

    public Reclamation(int id) {
        this.id = id;
    }

    public Reclamation(int id, Date date, String type, String etat, String description) {
        this.id = id;
        this.date = date;
        this.type = type;
        this.etat = etat;
        this.description = description;
    }

    public Reclamation(Date date, String type, String etat, String description) {
        this.date = date;
        this.type = type;
        this.etat = etat;
        this.description = description;
    }

    public Reclamation(String type, String etat, String description) {
        this.type = type;
        this.etat = etat;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    
    
    
    
    
    
}
