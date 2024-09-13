package com.zubiri.spring1.aplicacion;

import java.util.List;

import com.zubiri.spring1.dominio.Pelicula;

import lombok.AllArgsConstructor;


@AllArgsConstructor
public class AplicacionPeliculas implements IAplicacionPeliculas{

    private List<Pelicula> peliculas;

    @Override
    public Pelicula getPelicula(String id) {
    for (int i = 0; i < peliculas.size(); i++) {
        if(id.equals(peliculas.get(i).getId())){
            return peliculas.get(i);
        }
    }
    return null;
    }

    @Override
    public List<Pelicula> getPeliculas() {
        return peliculas;
    }

    @Override
    public void insetPelicula(Pelicula pelicula) {
        peliculas.add(pelicula);
    }
    

}
