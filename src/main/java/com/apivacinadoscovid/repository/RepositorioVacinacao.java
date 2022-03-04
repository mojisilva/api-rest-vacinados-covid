package com.apivacinadoscovid.repository;

import com.apivacinadoscovid.entity.Vacinado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioVacinacao extends JpaRepository<Vacinado, Long> {

}