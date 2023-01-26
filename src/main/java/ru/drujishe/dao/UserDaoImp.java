package ru.drujishe.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.drujishe.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
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
        manager.merge(updatedUser);
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
        return manager.createQuery("from User user where user.id = " + id, User.class).getSingleResult();
    }
}
