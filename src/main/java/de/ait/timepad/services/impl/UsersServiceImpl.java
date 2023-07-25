package de.ait.timepad.services.impl;

import de.ait.timepad.dto.NewUserDto;
import de.ait.timepad.dto.UserDto;
import de.ait.timepad.models.User;
import de.ait.timepad.repositories.UsersRepository;
import de.ait.timepad.services.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static de.ait.timepad.dto.UserDto.from;

@RequiredArgsConstructor
@Service
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;
    @Override
    public UserDto addUser(NewUserDto newUser) {
        User user = User.builder()
                        .email(newUser.getEmail())
                        .password(newUser.getPassword())
                        .role(User.Role.USER)
                        .state(User.State.NOT_CONFIRMED).build();

        usersRepository.save(user);
        return from(user);
    }
}
