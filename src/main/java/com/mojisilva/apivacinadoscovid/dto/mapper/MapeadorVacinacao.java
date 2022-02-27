package com.mojisilva.apivacinadoscovid.dto.mapper;

import com.mojisilva.apivacinadoscovid.dto.request.PacienteDTO;
import com.mojisilva.apivacinadoscovid.entity.Paciente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MapeadorVacinacao {

    @Mapping(target = "aniversario", source = "aniversario", dateFormat = "dd-MM-yyyy")
    Paciente toModel(PacienteDTO dto);
    PacienteDTO toDTO(Paciente dto);

}
