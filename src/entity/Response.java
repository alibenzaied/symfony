/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Administrateur
 */
public class Response {
    private int id;
    private int reclamation_id;
    
    private String desciption;

    public Response() {
    }

    public Response(int id) {
        this.id = id;
    }

    public Response(int id, int reclamation_id, String desciption) {
        this.id = id;
        this.reclamation_id = reclamation_id;
        this.desciption = desciption;
    }

    public Response(int reclamation_id, String desciption) {
        this.reclamation_id = reclamation_id;
        this.desciption = desciption;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getReclamation_id() {
        return reclamation_id;
    }

    public void setReclamation_id(int reclamation_id) {
        this.reclamation_id = reclamation_id;
    }

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }


    
    
    
    
    
}
