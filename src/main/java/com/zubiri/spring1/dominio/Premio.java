package com.zubiri.spring1.dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
@Table(name = "Premio", uniqueConstraints= @UniqueConstraint(columnNames = {"titulo", "lugar_event"}))
public class Premio {
    @Id
    @GeneratedValue
    private int id;

    private String titulo;

    private Evento evento;

    public Premio(String titulo, Evento evento){
        this.titulo=titulo;
        this.evento=evento;
    }
}
