package com.zubiri.spring1.persistencia;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Bean;

import com.zubiri.spring1.dominio.Actor;
import com.zubiri.spring1.dominio.Director;
import com.zubiri.spring1.dominio.Evento;
import com.zubiri.spring1.dominio.Pelicula;
import com.zubiri.spring1.dominio.Personal;
import com.zubiri.spring1.dominio.Premio;
import com.zubiri.spring1.dominio.PremioPelicula;

@org.springframework.context.annotation.Configuration
public class SpringPersistenciaConfig {

    @Bean
    public IPersistenciaPremios getPersistencaPremios(){
        return new PersistenciaPremios(getSession());
    }


    @Bean
    public IPersistenciaPelicula getPersistenciaPelicula(){
        return new PersistenciaPelicula(getSession());
    }
    @Bean
    public Session getSession(){
        Configuration conf= new Configuration();
        SessionFactory factory =conf.configure().addAnnotatedClass(Evento.class)
        .addAnnotatedClass(Premio.class)
        .addAnnotatedClass(PremioPelicula.class)

                                                .addAnnotatedClass(Personal.class)
                                                .addAnnotatedClass(Director.class)
                                                .addAnnotatedClass(Actor.class)
                                                .addAnnotatedClass(Pelicula.class)
                                                .buildSessionFactory();
        Session session=factory.openSession();
        return session;
    }
}