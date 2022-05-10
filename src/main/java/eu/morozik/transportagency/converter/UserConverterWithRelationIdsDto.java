package eu.morozik.transportagency.converter;

import eu.morozik.transportagency.dto.UserWithRelationIdsDto;
import eu.morozik.transportagency.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserConverterWithRelationIdsDto extends Converter<User, UserWithRelationIdsDto> {
    public UserConverterWithRelationIdsDto(ModelMapper modelMapper) {
        super(modelMapper);
    }
}
