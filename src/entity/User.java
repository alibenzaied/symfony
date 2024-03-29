/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;
import java.sql.Date;

/**
 *
 * @author TECHNOPC
 */
public class User {
     private int id;
   private String name;
   private String lastname;
   private String email;
   private String password;
   private String gender;
   private String role;
   private int phone;
   private Date birthday;

    public User(String name, String lastname, String email, String gender, int phone, Date birthday) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.gender = gender;
        this.phone = phone;
        this.birthday = birthday;
    }
    public User(String name, String lastname, String email, String gender, int phone ) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.gender = gender;
        this.phone = phone; 
    }

    public User() {
    }

    public User(int id, String name, String lastname, String email, String password, String gender, String role, int phone, Date birthday) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.role = role;
        this.phone = phone;
        this.birthday = birthday;
    }

    public User(String name, String lastname, String email, String password, String gender, String role, int phone, Date birthday) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.role = role;
        this.phone = phone;
        this.birthday = birthday;
    }
     public User(String name, String lastname, String email, String password, String gender, String role, int phone) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.role = role;
        this.phone = phone;
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getrole() {
        return role;
    }

    public void setrole(String role) {
        this.role = role;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", lastname=" + lastname + ", email=" + email + ", password=" + password + ", gender=" + gender + ", role=" + role + ", phone=" + phone + ", birthday=" + birthday + '}';
    }
}
