package com.zubiri.spring1.persistencia;

import java.util.List;

import com.zubiri.spring1.dominio.Evento;
import com.zubiri.spring1.dominio.Premio;
import com.zubiri.spring1.dominio.PremioId;

public interface IPersistenciaPremios {
    
    public abstract Premio getPremio(PremioId premioId);
    
    public abstract boolean addPremio(Premio premio);

    public abstract Evento getEvento( String nombreEvento);

    public abstract boolean addEvento(Evento evento);

    public abstract List<Premio> getPremios();
}
