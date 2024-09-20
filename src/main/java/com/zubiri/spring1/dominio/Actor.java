package com.zubiri.spring1.dominio;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Actor extends Personal {

    private int sueldo_por_pelicula;
    private int numero_premios;

    // Relación Many-to-Many con Pelicula sin cascada
   

    public Actor(String name, int sueldo_por_pelicula, int numero_premios) {
        super(name);
        this.sueldo_por_pelicula = sueldo_por_pelicula;
        this.numero_premios = numero_premios;
    }
}
