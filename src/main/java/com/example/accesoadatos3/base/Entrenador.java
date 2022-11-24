package com.example.accesoadatos3.base;
// Generated 22-ene-2014 16:31:59 by Hibernate Tools 4.0.0

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "entrenador", catalog = "db_trofeos")
public class Entrenador implements java.io.Serializable {

    private Integer id;
    private String nombre;
    private Date fechaNacimiento;
    private Set<Trofeo> trofeos = new HashSet<Trofeo>(0);

    public Entrenador() {
    }

    public Entrenador(String nombre) {
        this.nombre = nombre;
    }

    public Entrenador(String nombre, Date fechaNacimiento, Set<Trofeo> trofeos) {
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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "director")
    public Set<Trofeo> getTrofeos() {
        return this.trofeos;
    }

    public void setTrofeos(Set<Trofeo> peliculas) {
        this.trofeos = trofeos;
    }

}
