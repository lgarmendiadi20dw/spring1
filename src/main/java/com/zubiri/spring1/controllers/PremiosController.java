package com.zubiri.spring1.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zubiri.spring1.aplicacion.IAplicacionPeliculas;
import com.zubiri.spring1.dominio.Evento;
import com.zubiri.spring1.dominio.Pelicula;
import com.zubiri.spring1.dominio.Premio;
import com.zubiri.spring1.dominio.PremioId;
import com.zubiri.spring1.dominio.PremioPelicula;
import com.zubiri.spring1.dto.DtoConverter;
import com.zubiri.spring1.dto.PremioPeliculaDto;
import com.zubiri.spring1.persistencia.IPersistenciaPremios;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@AllArgsConstructor
@RestController
@RequestMapping("/premio")
public class PremiosController {

    private IPersistenciaPremios persistenciaPremios;

    private IAplicacionPeliculas aplicacionPeliculas;

    @GetMapping("/insertData")
    public String insertData() {
        String respuesta="fallo";

        Evento evento=new Evento("Oscars", "Hollywood", "EEUU");
        persistenciaPremios.addEvento(evento);

        Pelicula barbie= aplicacionPeliculas.getPelicula(1);

        PremioId premioId1=new PremioId("Mejor peli", 2002),
                premioId2=new PremioId("Mejor Drama", 2002);

        PremioPelicula peli1 =new PremioPelicula(premioId1, evento, barbie),
                        peli2 =new PremioPelicula(premioId2, evento, barbie);

        boolean ok= persistenciaPremios.addPremio(peli1);
        persistenciaPremios.addPremio(peli2);

        if(ok){
            respuesta="TODO OK";
        }
        return respuesta;
    }
    @GetMapping("/{titulo}/{anyo}")
        public PremioPeliculaDto getPremioAnyo(@PathVariable String titulo, @PathVariable int anyo) {
            PremioPeliculaDto ppd= null;
            PremioId premioId = new PremioId(titulo, anyo);
            Premio premio = persistenciaPremios.getPremio(premioId);
            try {
                PremioPelicula pp= (PremioPelicula) premio;
                ppd= DtoConverter.fromPremio(pp);
            } catch (Exception e) {
                // TODO: handle exception
            }
            return ppd;
        }

    
}
