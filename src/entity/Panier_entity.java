/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author PC
 */
public class Panier_entity {
    private int id;
    private String nom;
    private int quantite;
    
    private int iduser;

    public Panier_entity() {
    }

    public Panier_entity(int id) {
        this.id = id;
    }

    public Panier_entity(int id, String nom, int quantite) {
        this.id = id;
        this.nom = nom;
        this.quantite = quantite;

    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public Panier_entity(String nom, int quantite,int iduser) {
        this.nom = nom;
        this.quantite = quantite;
this.iduser=iduser;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        return "Panier_entity{" + "id=" + id + ", nom=" + nom + ", quantite=" + quantite + '}';
    }

   
    
    
}
