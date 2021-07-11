package web.service;

import web.models.User;

import javax.transaction.Transactional;
import java.util.List;

public interface UserService extends DaoService<User>  {
    @Override
    List<User> listUsers();

    @Override
    User findById(long id);
    @Override
    void save(User user);
    @Override
    void delete(User user);
    @Override
    void update(User user, Long id);

}
