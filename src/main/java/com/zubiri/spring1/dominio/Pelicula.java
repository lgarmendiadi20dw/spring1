package com.zubiri.spring1.dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.List;

import org.hibernate.mapping.Set;

@Data
@NoArgsConstructor
@ToString
@Entity
@Table(name="Pelicula")
public class Pelicula {

    @Id
    @GeneratedValue
    private int id;

    @Column(name="titulo")
    private String name;

    @Column(name="anyo")
    private int anyo;

    @ManyToOne
    @JoinColumn(name = "director_id")
    private Director director;
    @ManyToMany(mappedBy = "peliculas")
    
    private List<Actor> actores;
    
    public Pelicula (String name, int anyo, Director director, List<Actor> actores){
        this.name=name;
        this.anyo=anyo;
        this.director=director;
        this.actores=actores;
    }
}
