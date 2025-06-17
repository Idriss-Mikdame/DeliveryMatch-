package ma.enaa.deliverymatchs.Mapper;

import ma.enaa.deliverymatchs.Dto.DemandeDto;
import ma.enaa.deliverymatchs.Model.Demande;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DeamndeMapper {
    DemandeDto toDto(Demande demande);
    Demande toEntity(DemandeDto demandeDto);
}
