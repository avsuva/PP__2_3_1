package web.dao;

import org.springframework.stereotype.Repository;
import web.model.UserModel;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<UserModel> allUsers() {

        return manager.createQuery("select u from UserModel u", UserModel.class).getResultList();
    }

    @Override
    public void add(UserModel user) {
        manager.persist(user);
    }

    @Override
    public void delete(int id) {
        manager.remove(getById(id));
    }

    @Override
    public void edit(int id, UserModel user) {
        manager.merge(user);
    }

    @Override
    public UserModel getById(int id) {
        return manager.find(UserModel.class, id);
    }
}
