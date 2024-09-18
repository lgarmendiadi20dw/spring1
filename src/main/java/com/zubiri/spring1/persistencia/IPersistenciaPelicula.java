package com.zubiri.spring1.persistencia;

import com.zubiri.spring1.dominio.Pelicula;
import java.util.List;

public interface IPersistenciaPelicula {
    public Pelicula getPelicula(int id);
    public boolean addPelicula(Pelicula pelicula);
    public List<Pelicula> getPeliculas();
    public boolean removePelicula(String id);
    public List<Pelicula> getPeliculasPorAnyo(int anyo);
    
}
