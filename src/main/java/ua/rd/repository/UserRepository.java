package ua.rd.repository;

import ua.rd.domain.User;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.Optional;

public interface UserRepository {
    void init();

    Collection<User> getAllUsers();

        User getUserById(Long id);

        User getUserByName(String name);

        void save(User user);

        void update(User user);

        void delete(User user);

        User createUser(String name);
}
