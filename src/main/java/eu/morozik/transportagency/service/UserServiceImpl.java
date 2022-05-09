package eu.morozik.transportagency.service;

import eu.morozik.transportagency.api.dao.UserDao;
import eu.morozik.transportagency.api.service.UserService;
import eu.morozik.transportagency.controller.UserConverterWithRelationIdsDto;
import eu.morozik.transportagency.converter.UserConverter;
import eu.morozik.transportagency.dto.UserDto;
import eu.morozik.transportagency.dto.UserWithRelationIdsDto;
import eu.morozik.transportagency.dto.transport.TransportWithRelationIdsDto;
import eu.morozik.transportagency.exception.NotFoundException;
import eu.morozik.transportagency.model.*;
import eu.morozik.transportagency.model.enums.PurposeTransport;
import eu.morozik.transportagency.model.enums.Role;
import eu.morozik.transportagency.model.enums.Status;
import liquibase.pro.packaged.A;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserConverter userConverter;
    private final UserDao userDao;
    private final UserConverterWithRelationIdsDto userConverterWithRelationIdsDto;

    private final PasswordEncoder passwordEncoder;


    @Transactional
    @Override
    public UserDto findById(Long id) throws Exception {
        User response = userDao.findById(id).orElseThrow(Exception::new);
        return userConverter.convert(response);
    }

    @Transactional
    @Override
    public List<UserDto> findAll() {
        List<User> users = userDao.findAll();
        return userConverter.convert(users);
    }

    @Override
    public UserDto update(UserWithRelationIdsDto userWithRelationIdsDto) {
        User response = userDao.save(reassignment(userWithRelationIdsDto));
        return userConverter.convert(response);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        userDao.deleteById(id);
    }

    @Transactional
    @Override
    public UserDto findByFirstName(String firstname) {
        return null;
    }

    @Transactional
    @Override
    public UserDto register(UserDto userDto) {
        Role role = Role.USER;
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));

        final User user = userConverter.convert(userDto);
        user.setRole(role);
        user.setStatus(Status.ACTIVE);
        userDao.save(user);

        return userConverter.convert(user);
    }

    public User reassignment(UserWithRelationIdsDto userWithRelationIdsDto) {
        final User user = userConverterWithRelationIdsDto.convert(userWithRelationIdsDto);

        user.setRole(Role.getRole(userWithRelationIdsDto.getRoleId()));

       user.setStatus(Status.getStatus(userWithRelationIdsDto.getStatusId()));

        return user;
    }
}
