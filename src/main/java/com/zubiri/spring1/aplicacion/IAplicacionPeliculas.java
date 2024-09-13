package com.zubiri.spring1.aplicacion;

import com.zubiri.spring1.dominio.Pelicula;
import java.util.List;

public interface IAplicacionPeliculas {

    
    public abstract Pelicula getPelicula(String id);

    public abstract List<Pelicula> getPeliculas();

    public abstract void insetPelicula(Pelicula pelicula);
}
