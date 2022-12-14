package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.dao.UserDaoImpl;
import web.model.UserModel;

import javax.transaction.Transactional;
import java.util.List;

@Service

public class UserServiceImpl implements UserService{

    private UserDao userDao;


    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public List<UserModel> allUsers() {
        return userDao.allUsers();
    }
    @Transactional
    @Override
    public void add(UserModel user) {
        userDao.add(user);
    }
    @Transactional
    @Override
    public void delete(int id) {
        userDao.delete(id);
    }

    @Transactional
    @Override
    public void edit(int id, UserModel user) {
        userDao.edit(id, user);
    }

    @Transactional
    @Override
    public UserModel getById(int id) {
        return userDao.getById(id);
    }
}
