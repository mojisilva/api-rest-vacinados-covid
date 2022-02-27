package com.mojisilva.apivacinadoscovid.dto.mapper;

import com.mojisilva.apivacinadoscovid.dto.request.PacienteDTO;
import com.mojisilva.apivacinadoscovid.dto.request.VacinaDTO;
import com.mojisilva.apivacinadoscovid.entity.Paciente;
import com.mojisilva.apivacinadoscovid.entity.Vacina;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MapeadorVacinacao {

    @Mapping(target = "aniversario", source = "aniversario", dateFormat = "dd-MM-yyyy")
    Paciente toModel(PacienteDTO dto);

    PacienteDTO toDTO(Paciente dto);

    @Mapping(target = "dataVacinacao", source = "dataVacinacao", dateFormat = "dd-MM-yyyy")
    Vacina toModel(VacinaDTO dto);

    VacinaDTO toDTO(VacinaDTO dto);
}
