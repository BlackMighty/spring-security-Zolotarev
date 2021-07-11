package web.dao;


import web.models.User;

import java.util.List;

public interface UserDao {
    List<User> listUsers();
    User findById(long id);
    void save(User user);
    void update(User user, Long id);
    void delete(User user);
    User getItemByEmail(String email);


}
