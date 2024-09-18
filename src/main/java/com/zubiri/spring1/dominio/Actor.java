package com.zubiri.spring1.dominio;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Actor extends Personal{
    private int sueldo_por_pelicula;
    private int numero_premios;
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "actor_pelicula",
            joinColumns = {@JoinColumn(name = "actor_id")},
            inverseJoinColumns = {@JoinColumn(name = "pelicula_id")}
    )
    private List<Pelicula> peliculas;

    public Actor(int sueldo_por_pelicula, int numero_premios){
        this.sueldo_por_pelicula=sueldo_por_pelicula;
        this.numero_premios=numero_premios;
    }
    
}
