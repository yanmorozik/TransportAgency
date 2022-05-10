package eu.morozik.transportagency.api.service;

import eu.morozik.transportagency.dto.TypeTransportDto;
import eu.morozik.transportagency.dto.UserDto;
import eu.morozik.transportagency.dto.UserWithRelationIdsDto;

import java.util.List;

public interface UserService {

    UserDto findById(Long id) throws Exception;

    List<UserDto> findAll();

    UserDto update(UserWithRelationIdsDto userWithRelationIdsDto);

    void deleteById(Long id);

    UserDto findByFirstName(String firstname);

    UserDto register(UserDto userDto);

    List<UserDto> findByAnyOneFieldWithSpecification(String key, String operation, String value);
}
