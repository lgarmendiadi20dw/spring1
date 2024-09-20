package com.zubiri.spring1.dominio;

import org.hibernate.annotations.ManyToAny;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(uniqueConstraints=@UniqueConstraint(columnNames = {"anyo","premio_id"}))
@NoArgsConstructor
@Data
public class PremiosGanados {

    @Id
    private int id;

    private int anyo;

    @ManyToOne
    @JoinColumn(name = "premio_id")
    private Premio premio;
    @ManyToOne
    @JoinColumn(name = "premiado_id")

    private Personal personal;
}
