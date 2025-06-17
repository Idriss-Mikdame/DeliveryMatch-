package ma.enaa.deliverymatchs.Mapper;

import ma.enaa.deliverymatchs.Dto.AnnonceDto;
import ma.enaa.deliverymatchs.Model.Annonce;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AnnonnceMapper {
    AnnonceDto toDto(Annonce annonce);
    Annonce toEntity(AnnonceDto annonceDto);
}
