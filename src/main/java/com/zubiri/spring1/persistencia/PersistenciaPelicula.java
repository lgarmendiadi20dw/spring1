package com.zubiri.spring1.persistencia;

import java.util.ArrayList;
import java.util.List;

import com.zubiri.spring1.dominio.Actor;
import com.zubiri.spring1.dominio.Director;
import com.zubiri.spring1.dominio.Evento;
import com.zubiri.spring1.dominio.Pelicula;
import com.zubiri.spring1.dominio.Premio;

import lombok.AllArgsConstructor;

import org.hibernate.Session;

@AllArgsConstructor
public class PersistenciaPelicula implements IPersistenciaPelicula {

    private Session session;

    @Override
    public Pelicula getPelicula(int id) {
        Pelicula to_rPelicula=null;
        session.beginTransaction();
        to_rPelicula=(Pelicula) session.get(Pelicula.class,id);
        session.getTransaction().commit();
        return to_rPelicula;
    }
    @Override
    public boolean addPelicula(Pelicula pelicula) {
        // Evento evento=new Evento("Oscars", "USA");
        // Premio premio1=new Premio("Mejor actor", evento);
        // Premio premio2=new Premio("Mejor director", evento);
        try {

            // session.beginTransaction();
            // session.persist(premio1);
            // session.persist(premio2);
            // session.getTransaction().commit();

            for (Actor a :pelicula.getActores()) {
                session.beginTransaction();
                session.persist(a);
                session.getTransaction().commit();
            }


            if(!guardarDirector(pelicula.getDirector())){
                pelicula.setDirector(getDirectorByNombre(pelicula.getDirector().getName()));
            }
            session.beginTransaction();
            
            Pelicula bPeli= session.createQuery("from Pelicula where name = :titulo", Pelicula.class).setParameter("titulo", pelicula.getName()).uniqueResult();
            if(bPeli!=null){
                session.getTransaction().rollback();
                return false;
            }
            session.persist(pelicula);
        // session.save(pelicula);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return false;
    }

    @Override
    public List<Pelicula> getPeliculas() {
        return null;
    }

    @Override
    public boolean removePelicula(String id) {
        return false;
    }

    @Override
    public List<Pelicula> getPeliculasPorAnyo(int anyo) {
        List<Pelicula> peliculas_anyo= new ArrayList<>();
        try{
        session.beginTransaction();
        peliculas_anyo=session.createQuery("from Pelicula where anyo = :anyo", Pelicula.class).setParameter("anyo", anyo).list();
        session.getTransaction().commit();
        }catch (Exception e) {
            session.getTransaction().rollback();
        }
        return peliculas_anyo;
    }

    private boolean guardarDirector(Director director){
        try {
            session.beginTransaction();
            session.persist(director);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
        return false;
    }
    
    private Director getDirectorByNombre(String nombre) {
        Director director = null;
        try {
            // Filtramos por el tipo 'Director' usando el DTYPE y el nombre
            director = session.createQuery("from Director where name = :name", Director.class)
                              .setParameter("name", nombre) // Asignar el parámetro nombre
                              .uniqueResult(); // Obtener el resultado único
        } catch (Exception e) {
            e.printStackTrace(); // Imprimir el error si ocurre alguno
        }
        return director; // Retornar el director encontrado o null si no existe
    }
    
}
