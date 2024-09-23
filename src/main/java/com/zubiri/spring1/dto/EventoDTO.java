package com.zubiri.spring1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventoDTO {
    private String nombre_Evernto;
    private String lugar;
    private String pais;
}
