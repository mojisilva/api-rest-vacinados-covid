package com.apivacinadoscovid.repository;

import com.apivacinadoscovid.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioVacinacao extends JpaRepository<Paciente, Long> {

}
