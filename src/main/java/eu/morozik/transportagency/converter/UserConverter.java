package eu.morozik.transportagency.converter;

import eu.morozik.transportagency.dto.UserDto;
import eu.morozik.transportagency.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserConverter extends Converter<User, UserDto> {
    public UserConverter(ModelMapper modelMapper) {
        super(modelMapper);
    }
}
