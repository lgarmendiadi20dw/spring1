package com.zubiri.spring1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zubiri.spring1.aplicacion.IAplicacionPeliculas;
import com.zubiri.spring1.dominio.Actor;
import com.zubiri.spring1.dominio.Director;
import com.zubiri.spring1.dominio.Pelicula;
import java.util.List;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/peliculas")
@AllArgsConstructor
public class PeliculaController {

    private IAplicacionPeliculas aplicacionPeliculas;


    @GetMapping("/insertData")
    public String getData(){
        Director director= new Director("Leire",10);
        List<Actor> actores=null;

        Pelicula peli=new Pelicula("Barbie1",2002,director, actores);
        Pelicula peli1=new Pelicula("Barbie2",2002,director, actores);
        Pelicula peli2=new Pelicula("Barbie3",2002,director, actores);
        Pelicula peli3=new Pelicula("Barbie4",2003,director, actores);

        aplicacionPeliculas.insetPelicula(peli);
        aplicacionPeliculas.insetPelicula(peli1);
        aplicacionPeliculas.insetPelicula(peli2);
        aplicacionPeliculas.insetPelicula(peli3);
        return "Datos insertados con exito";
    }

    @GetMapping("/{id}")
    public Pelicula mostrarPelicula(@PathVariable int id){
        return aplicacionPeliculas.getPelicula(id);
    }

    @GetMapping("/anyo/{anyo}")
    public List<Pelicula> mostrarPeliculasAnyo(@PathVariable int anyo){
        return aplicacionPeliculas.mostrarPeliculasAnyo(anyo);
    }

    @GetMapping("/getPeliculas")
    public List<Pelicula> peliculas(){
        return aplicacionPeliculas.getPeliculas();
    }

    @GetMapping("/saludar")
    public String saludar(){
        return "Hola, soy el servidor";
    }
    

}
