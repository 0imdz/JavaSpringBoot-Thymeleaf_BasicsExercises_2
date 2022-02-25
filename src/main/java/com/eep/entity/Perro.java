package com.eep.entity;

import javax.persistence.*;

@Entity
@Table(name="perro")
public class Perro {

    @Id
    @GeneratedValue
    @Column(name="id")
    private int id;

    private String nombre;

    private String enfermedades;

    public Perro() {
    }

    public Perro(int id, String nombre, String enfermedades) {
        this.id = id;
        this.nombre = nombre;
        this.enfermedades = enfermedades;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEnfermedades() {
        return enfermedades;
    }

    public void setEnfermedades(String enfermedades) {
        this.enfermedades = enfermedades;
    }
}
