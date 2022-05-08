package eu.morozik.transportagency.service;

import eu.morozik.transportagency.api.dao.UserDao;
import eu.morozik.transportagency.api.service.UserService;
import eu.morozik.transportagency.converter.UserConverter;
import eu.morozik.transportagency.dto.UserDto;
import eu.morozik.transportagency.model.User;
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

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserConverter userConverter;
    private final UserDao userDao;

    private final PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public UserDto save(UserDto userDto) {
        return null;
    }

    @Transactional
    @Override
    public UserDto findById(Long id) throws Exception {
        return null;
    }

    @Transactional
    @Override
    public List<UserDto> findAll() {
        return null;
    }

    @Transactional
    @Override
    public void deleteById(Long id) {

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
}
