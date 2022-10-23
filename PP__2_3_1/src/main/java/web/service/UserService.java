package web.service;

import web.model.UserModel;

import java.util.List;

public interface UserService {
    List<UserModel> allUsers();
    void add(UserModel user);
    void delete(int id);
    void edit(int id, UserModel user);
    UserModel getById(int user);
}
