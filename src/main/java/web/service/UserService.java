package web.service;

import web.models.User;

import javax.transaction.Transactional;
import java.util.List;

public interface UserService   {

    List<User> listUsers();


    User findById(long id);

    void save(User user);

    void delete(User user);

    void update(User user, Long id);

}
