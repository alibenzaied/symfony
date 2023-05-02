/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author PC
 */
public class Commande_entity {
    
    private int id;
    private String nom;
    private String description;
    private int quantite;
    private String date_creation;
    private Date date_c;
    private int idPanier;
    
    
    public Commande_entity(){
        
    }
    
    public Commande_entity(int id){
        this.id=id;
    }
    
    public Commande_entity(int id,String nom,String description,int quantite,String date_creation,Date date_c,int idPanier){
   
    this.id=id;
    this.nom=nom;
    this.description=description;
    this.quantite=quantite;
    this.date_creation=date_creation;
    this.date_c=date_c;
    this.idPanier=idPanier;
    
}
    public Commande_entity(String nom,String description,int quantite,String date_creation,Date date_c,int idPanier){
    this.nom=nom;
    this.description=description;
    this.quantite=quantite;
    this.date_creation=date_creation;
    this.date_c=date_c;
    this.idPanier=idPanier;
    
}

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public int getQuantite() {
        return quantite;
    }

    public String getDate_creation() {
        return date_creation;
    }

    public Date getDate_c() {
        return date_c;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setDate_creation(String date_creation) {
        this.date_creation = date_creation;
    }

    public void setDate_c(Date date_c) {
        this.date_c = date_c;
    }

    public void setIdPanier(int idPanier) {
        this.idPanier = idPanier;
    }

    public int getIdPanier() {
        return idPanier;
    }

     @Override
    public String toString() {
        return "Commande_entity{" + "id=" + id + ", nom=" + nom + ", description=" + description + ", quantite=" + quantite + ", date_creation=" + date_creation + ", date_c=" + date_c + ", idPanier=" + idPanier + '}';
    }
    
}
