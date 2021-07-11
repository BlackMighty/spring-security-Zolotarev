package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.models.User;


import javax.transaction.Transactional;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {


    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }


    @Transactional
    @Override
    public User findById(long id) {
        return userDao.findById(id);
    }

    @Override
    @Transactional
    public void save(User user) {
        userDao.save(user);
    }

    @Transactional
    @Override
    public void update(User user, Long id) {
        userDao.update(user, id);
    }

    @Override
    public User getItemByEmail(String email) {
        return userDao.getItemByEmail(email);
    }

    @Override
    @Transactional
    public void delete(User user) {
        userDao.delete(user);
    }

}
