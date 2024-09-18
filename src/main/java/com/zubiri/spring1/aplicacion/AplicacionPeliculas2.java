package com.zubiri.spring1.aplicacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.zubiri.spring1.dominio.Pelicula;
import com.zubiri.spring1.persistencia.IPersistenciaPelicula;

public class AplicacionPeliculas2 implements IAplicacionPeliculas{
    
    @Autowired
    IPersistenciaPelicula persistenciaPelicula;

    @Override
    public Pelicula getPelicula(int id) {
        return persistenciaPelicula.getPelicula(id);
        
    }

    @Override
    public List<Pelicula> getPeliculas() {
        return null;
    }

    @Override
    public String insetPelicula(Pelicula pelicula) {
       if(persistenciaPelicula.addPelicula(pelicula)){
            return "Pelicula insertada";
       }
       return "Error al insertar";
    }

    @Override
    public List<Pelicula> mostrarPeliculasAnyo(int anyo) {
        return persistenciaPelicula.getPeliculasPorAnyo(anyo);
    }
    
}
