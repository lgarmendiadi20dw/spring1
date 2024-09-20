package com.zubiri.spring1.dominio;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Evento {
    @Column(name="nombre_evento")
    private String name;
    @Column(name="lugar_evento")
    private String lugar_evento;
}
