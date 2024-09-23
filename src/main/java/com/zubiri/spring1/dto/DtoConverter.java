package com.zubiri.spring1.dto;

import com.zubiri.spring1.dominio.Evento;
import com.zubiri.spring1.dominio.PremioPelicula;

public class DtoConverter {

    public static Evento toEvento(EventoDTO dto) {

        Evento respuesta = new Evento(dto.getNombre_Evernto(), dto.getLugar(), dto.getPais());

        return respuesta;
    }

    public static EventoDTO fromEvento(Evento evento) {

        EventoDTO respuesta = new EventoDTO(evento.getNombre_Evernto(), evento.getLugar(), evento.getPais());

        return respuesta;
    }

    public static PremioPeliculaDto fromPremio(PremioPelicula premio) {
        EventoDTO evento = fromEvento(premio.getEvento());
        PremioPeliculaDto respuesta = new PremioPeliculaDto(premio.getPremioId().getTitulo(),
                premio.getPremioId().getAnyo(), evento, premio.getPelicula().getName());
        return respuesta;
    }
}
