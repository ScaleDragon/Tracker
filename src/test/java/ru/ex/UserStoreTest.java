package ru.ex;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;

class UserStoreTest {

    @Test
    void whenFindUserSuccessfullyException() {
        User[] users = new User[]{new User("Ivan Ivanov", true),
                new User("Sergey Sergeev", false)};
        UserNotFoundException exception = assertThrows(UserNotFoundException.class, () -> {
            UserStore.findUser(users, "Ivan Sergeev");
        });
        assertThat(exception.getMessage()).isEqualTo("User \"" + "Ivan Sergeev" + "\" not Found");
    }

    @Test
    void whenFindUserSuccessfully() throws UserNotFoundException {
        User[] users = new User[]{new User("Ivan Ivanov", true),
                new User("Sergey Sergeev", false)};
        User expected = UserStore.findUser(users, "Ivan Ivanov");
        assertThat(expected.getUsername()).isEqualTo("Ivan Ivanov");
    }

    @Test
    void whenValidateSuccessfullyException() {
        User user = new User("Ivan Ivanov", false);
        UserInvalidException exception = assertThrows(UserInvalidException.class, () -> {
            UserStore.validate(user);
        });
        assertThat(exception.getMessage()).isEqualTo("User \"" + user.getUsername() + "\" Invalid");
    }

    @Test
    void whenValidateNameSuccessfullyException() {
        User user = new User("Iv", true);
        UserInvalidException exception = assertThrows(UserInvalidException.class, () -> {
            UserStore.validate(user);
        });
        assertThat(exception.getMessage()).isEqualTo("User \"" + user.getUsername() + "\" Invalid");
    }

    @Test
    void whenValidateNameSuccessfully() throws UserInvalidException {
        User user = new User("Ivanov", true);
        boolean expected = UserStore.validate(user);
        assertThat(expected).isTrue();
    }
}