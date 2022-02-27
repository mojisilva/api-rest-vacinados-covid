package com.mojisilva.apivacinadoscovid.repository;

import com.mojisilva.apivacinadoscovid.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioVacinacao extends JpaRepository<Paciente, Long> {

}
