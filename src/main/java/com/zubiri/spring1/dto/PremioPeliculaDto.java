package com.zubiri.spring1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PremioPeliculaDto {
    private String titulo;
    private int anyo;
    private EventoDTO eventoDto;
    private String pelicula;
}
