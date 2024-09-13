package com.zubiri.spring1.aplicacion;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zubiri.spring1.dominio.Pelicula;


@Configuration
public class ConfiguracionAplicacion {

    @Bean
   public IAplicacionPeliculas getAplicacionPeliculas(){
    List<Pelicula> peliculas=new ArrayList<Pelicula>();
    IAplicacionPeliculas to_return= new AplicacionPeliculas(peliculas);
    

    return to_return;}
}
