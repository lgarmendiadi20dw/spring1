package com.zubiri.spring1.dominio;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Evento {
    @Id
    private String nombre_Evernto;
    private String lugar;
    private String pais;
}
