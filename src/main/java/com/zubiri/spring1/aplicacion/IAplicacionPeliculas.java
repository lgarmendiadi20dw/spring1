package com.zubiri.spring1.aplicacion;

import com.zubiri.spring1.dominio.Pelicula;
import java.util.List;

public interface IAplicacionPeliculas {

    
    public abstract Pelicula getPelicula(int id);

    public abstract List<Pelicula> getPeliculas();

    public abstract     String insetPelicula(Pelicula pelicula);
    public abstract List<Pelicula> mostrarPeliculasAnyo(int anyo);
}
