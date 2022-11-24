package com.example.accesoadatos3.base;


import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;


@Entity
@Table(name = "tenista", catalog = "db_trofeos")
public class Tenista implements java.io.Serializable {

    private Integer id;
    private String nombre;
    private Date fechaNacimiento;
    private Set<Tenista> trofeos = new HashSet<Tenista>(0);

    public Tenista() {
    }

    public Tenista(String nombre) {
        this.nombre = nombre;
    }

    public Tenista(String nombre, Date fechaNacimiento, Set<Tenista> trofeos) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.trofeos = trofeos;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "nombre", nullable = false, length = 200)
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {

        this.nombre = nombre;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_nacimiento", length = 10)
    public Date getFechaNacimiento() {
        return this.fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tenista_trofeos", catalog = "db_trofeos", joinColumns = { @JoinColumn(name = "id_tenista", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "id_trofeo", nullable = false, updatable = false) })
    public Set<Tenista> getTrofeos() {
        return this.trofeos;
    }

    public void setTrofeos(Set<Tenista> trofeos) {
        this.trofeos = trofeos;
    }

    public void setPeliculas(Set<Tenista> peliculas) {
        this.trofeos = trofeos;
    }

}
