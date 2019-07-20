package com.iomis.HibernatePractice;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
            (name = "name")
    private String name;


   private int age;
    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Auto> autos;

    public User(){

    }


    public User(String name, int age , String email){
        this.age = age;
        this.email = email;
        this.name = name;
        autos = new ArrayList<Auto>();
    }


    public void addAuto(Auto auto){
        auto.setUser(this);
        autos.add(auto);
    }

    public void removeAuto(Auto auto){
        autos.remove(auto);
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Auto> getAutos() {
        return autos;
    }

    public void setAutos(List<Auto> autos) {
        this.autos = autos;
    }


    @Override
    public String toString()
    {
return "models.User{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", age=" + age +
        ", email=" + email +'}';
    }
}