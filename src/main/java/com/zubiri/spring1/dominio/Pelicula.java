package com.zubiri.spring1.dominio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Pelicula {

    private String id;
    private String titulo;
    private int anyo;
    private String director;
}
