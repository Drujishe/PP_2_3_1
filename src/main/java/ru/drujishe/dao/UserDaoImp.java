package ru.drujishe.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.drujishe.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Component
@Transactional
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager manager;


    @Override
    public void add(User user) {
        manager.persist(user);
    }

    @Override
    public void update(int id, User updatedUser) {
        User user = getUserById(id);
        user.setAge(updatedUser.getAge());
        user.setName(updatedUser.getName());
        user.setSurname(updatedUser.getSurname());
    }

    @Override
    public void delete(int id) {
        manager.remove(getUserById(id));
    }

    @Override
    public List<User> getAll() {
        return manager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public User getUserById(int id) {
        return manager.createQuery("from User where User.id = " + id, User.class).getSingleResult();
    }
}
