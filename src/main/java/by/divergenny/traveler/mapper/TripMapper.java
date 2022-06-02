package by.divergenny.traveler.mapper;

import by.divergenny.traveler.domain.Trip;
import by.divergenny.traveler.dto.TripDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TripMapper {
    TripDto toDto(Trip entity);

    Trip toEntity(TripDto dto);
}
