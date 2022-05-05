package eu.morozik.transportagency.api.service;

import eu.morozik.transportagency.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto save(UserDto userDto);

    UserDto findById(Long id) throws Exception;

    List<UserDto> findAll();

    void deleteById(Long id);

    UserDto findByFirstName(String firstname);

    UserDto register(UserDto userDto);
}
