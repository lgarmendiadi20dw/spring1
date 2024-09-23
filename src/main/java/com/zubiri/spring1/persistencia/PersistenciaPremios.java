package com.zubiri.spring1.persistencia;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.zubiri.spring1.dominio.Evento;
import com.zubiri.spring1.dominio.Pelicula;
import com.zubiri.spring1.dominio.Premio;
import com.zubiri.spring1.dominio.PremioId;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PersistenciaPremios implements IPersistenciaPremios{
    private Session session;

    @Override
    public Premio getPremio(PremioId premioId) {
        Premio to_return=null;
        session.beginTransaction();
        to_return=(Premio) session.get(Premio.class, premioId);
        session.getTransaction().commit();

        return to_return;
        }


    @Override
    public boolean addPremio(Premio premio) {
        try {
            session.beginTransaction();
            session.persist(premio);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            return false;
        }
    }

    @Override
    public Evento getEvento(String nombreEvento) {
        Evento to_return=null;
        session.beginTransaction();
        to_return=(Evento) session.get(Evento.class, nombreEvento);
        session.getTransaction().commit();

        return to_return;
    }

    @Override
    public boolean addEvento(Evento evento) {
        try {
            session.beginTransaction();
            session.persist(evento);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            return false;
        }
    }

    @Override
    public List<Premio> getPremios() {
        List<Premio> to_return= new ArrayList<>();
        try {
            session.beginTransaction();
            to_return=session.createQuery("from Premio", Premio.class).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }

        return to_return;
    }


}
