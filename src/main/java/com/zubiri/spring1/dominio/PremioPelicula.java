package com.zubiri.spring1.dominio;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class PremioPelicula extends Premio{

    @ManyToOne
    @JoinColumn(name = "pelicula")
    @JsonBackReference
    private Pelicula pelicula;

    public PremioPelicula(PremioId premioid, Evento evento, Pelicula pelicula){
        super(premioid, evento);
        this.pelicula=pelicula;
    }
}
