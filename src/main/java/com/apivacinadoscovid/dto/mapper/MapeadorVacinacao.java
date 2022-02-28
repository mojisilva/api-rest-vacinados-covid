package com.apivacinadoscovid.dto.mapper;

import com.apivacinadoscovid.entity.Paciente;
import com.apivacinadoscovid.dto.request.PacienteDTO;
import com.apivacinadoscovid.dto.request.VacinaDTO;
import com.apivacinadoscovid.entity.Vacina;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MapeadorVacinacao {

    @Mapping(target = "aniversario", source = "aniversario", dateFormat = "dd-MM-yyyy")
    Paciente toModel(PacienteDTO dto);
    PacienteDTO toDTO(Paciente dto);

    @Mapping(target = "dataVacinacao", source = "dataVacinacao", dateFormat = "dd-MM-yyyy")
    Vacina toModel(VacinaDTO dto);
    VacinaDTO toDTO(Vacina dto);

}
