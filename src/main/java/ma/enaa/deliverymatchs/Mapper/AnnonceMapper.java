package ma.enaa.deliverymatchs.Mapper;

import ma.enaa.deliverymatchs.Dto.AnnonceDto;
import ma.enaa.deliverymatchs.Model.Annonce;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AnnonceMapper {

 //   @Mapping(source = "conducteur.id", target = "conducteurId")
    AnnonceDto toDto(Annonce annonce);

  //  @Mapping(source = "conducteurId", target = "conducteur.id")
    Annonce toEntity(AnnonceDto annonceDto);
}
