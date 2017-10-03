package ua.rd.repository;

import org.springframework.stereotype.Repository;
import ua.rd.domain.User;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository("userRepository")
public class InMemUserRepository implements UserRepository {
    private Map<Long, User> users;
    private AtomicLong counter = new AtomicLong(1L);

    @Override
    @PostConstruct
    public void init() {
        this.users = new HashMap<Long, User>(){{
            put(counter.get(), new User(counter.getAndIncrement(), "User1"));
            put(counter.get(), new User(counter.getAndIncrement(), "User2"));
        }};
    }

    public InMemUserRepository() {
        this.users = new HashMap<>();
    }

    public InMemUserRepository(Map<Long, User> users) {
        this.users = users;
    }

    @Override
    public Collection<User> getAllUsers() {
        return users.values();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return Optional.ofNullable(users.get(id));
    }

    @Override
    public Optional<User> getUserByName(String name) {
        return users.values().stream()
                .filter(user -> user.getName().equals(name))
                .findFirst();
    }

    @Override
    public void save(User user) {
        if (user.getId() == null) {
            user.setId(counter.getAndIncrement());
        }
        users.put(user.getId(), user);
    }

    @Override
    public void update(User user) {
        save(user);
    }

    @Override
    public void delete(User user) {
        if (users.containsValue(user)){
            users.remove(user.getId());
        }
    }

    @Override
    public User createUser(String name) {
        User user = new User(counter.get(), name);
        users.put(counter.getAndIncrement(), user);
        return user;
    }
}
