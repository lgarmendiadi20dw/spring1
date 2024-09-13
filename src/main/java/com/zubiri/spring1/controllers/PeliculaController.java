package com.zubiri.spring1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zubiri.spring1.aplicacion.IAplicacionPeliculas;
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
        
        Pelicula peli=new Pelicula("1","Barbie1",2002,"yo");
        Pelicula peli1=new Pelicula("2","Barbie2",2002,"yo");
        Pelicula peli2=new Pelicula("3","Barbie3",2002,"yo");

        aplicacionPeliculas.insetPelicula(peli);
        aplicacionPeliculas.insetPelicula(peli1);
        aplicacionPeliculas.insetPelicula(peli2);
        return "Datos insertados con exito";
    }

    @GetMapping("/{id}")
    public Pelicula mostrarPelicula(@PathVariable String id){
        return aplicacionPeliculas.getPelicula(id);
    }

    @GetMapping("/getPelicula")
    public List<Pelicula> peliculas(){
        return aplicacionPeliculas.getPeliculas();
    }

    @GetMapping("/saludar")
    public String saludar(){
        return "Hola, soy el servidor";
    }
    

}
