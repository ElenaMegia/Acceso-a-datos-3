package com.example.accesoadatos3.base;


import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;


@Entity
@Table(name = "trofeo", catalog = "db_trofeos")
public class Trofeo implements java.io.Serializable {

    private Integer id;
    private Entrenador entrenador;
    private String titulo;
    private Date fechaGanado;
    private Set<Tenista> tenistas = new HashSet<Tenista>(0);

    public Trofeo() {
    }

    public Trofeo(String titulo) {
        this.titulo = titulo;
    }

    public Trofeo(Entrenador entrenador, String titulo, Date fechaGanado,
                    Set<Tenista> tenistas) {
        this.entrenador = entrenador;
        this.titulo = titulo;
        this.fechaGanado = fechaGanado;
        this.tenistas = tenistas;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_entrenador")
    public Entrenador getEntrenador() {
        return this.entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    @Column(name = "titulo", nullable = false, length = 300)
    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_ganado", length = 10)
    public Date getFechaGanado() {
        return this.fechaGanado;
    }

    public void setFechaGanado(Date fechaEstreno) {
        this.fechaGanado = fechaEstreno;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tenistas_trofeos", catalog = "db_trofeos", joinColumns = { @JoinColumn(name = "id_trofeo", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "id_tenista", nullable = false, updatable = false) })
    public Set<Tenista> getTenistas() {
        return this.tenistas;
    }

    public void setTenistas(Set<Tenista> actors) {
        this.tenistas = tenistas;
    }

}
