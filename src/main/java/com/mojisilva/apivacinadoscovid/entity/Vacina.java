package com.mojisilva.apivacinadoscovid.entity;

import com.mojisilva.apivacinadoscovid.enums.NomeVacina;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Vacina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private NomeVacina nome;

    @Column(nullable = false)
    private String lote;

    @Column(nullable = false)
    private int dose;

    private LocalDate dataVacinacao;
}
