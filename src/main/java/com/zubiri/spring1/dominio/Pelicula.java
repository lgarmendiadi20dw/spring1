package com.zubiri.spring1.dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Data
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Pelicula")
public class Pelicula {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "titulo")
    private String name;

    @Column(name = "anyo")
    private int anyo;

    @ManyToOne
    @JoinColumn(name = "director_id")
    private Director director;

    // Relación Many-to-Many con Actor sin cascada
    @ManyToMany
    @JoinTable(
            name = "actor_pelicula",
            joinColumns = {@JoinColumn(name = "pelicula_id")},
            inverseJoinColumns = {@JoinColumn(name = "actor_id")}
    )
    private List<Actor> actores;

    @OneToMany(mappedBy="pelicula", orphanRemoval = true, cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<PremioPelicula> premios;

    public Pelicula(String name, int anyo, Director director, List<Actor> actores) {
        this.name = name;
        this.anyo = anyo;
        this.director = director;
        this.actores = actores;
        this.premios=new ArrayList<>();
    }
}
