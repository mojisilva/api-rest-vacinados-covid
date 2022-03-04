package com.apivacinadoscovid.dto.mapper;

import com.apivacinadoscovid.entity.Vacinado;
import com.apivacinadoscovid.dto.request.VacinadoDTO;
import com.apivacinadoscovid.dto.request.VacinaDTO;
import com.apivacinadoscovid.entity.Vacina;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MapeadorVacinacao {

    @Mapping(target = "aniversario", source = "aniversario", dateFormat = "dd-MM-yyyy")
    Vacinado toModel(VacinadoDTO dto);
    VacinadoDTO toDTO(Vacinado dto);

    @Mapping(target = "dataVacinacao", source = "dataVacinacao", dateFormat = "dd-MM-yyyy")
    Vacina toModel(VacinaDTO dto);
    VacinaDTO toDTO(Vacina dto);
}