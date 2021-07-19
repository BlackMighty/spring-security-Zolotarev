package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.models.User;


import javax.transaction.Transactional;
import java.util.List;
@Service
public class UserServiceImpl  {


    private final UserDao userDao;

    @Autowired
    public User getUserName (String name){
        this.name = name;
    }

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }


    public List<User> listUsers() {
        return userDao.listUsers();
    }


    @Transactional

    public User findById(Long id) {
        return userDao.findById(id);
    }


    @Transactional
    public void save(User user) {
        userDao.save(user);
    }

    @Transactional

    public void update(User user, Long id) {
        userDao.update(user, id);
    }


    public User getItemByEmail(String email) {
        return userDao.getItemByEmail(email);
    }


    @Transactional
    public void delete(User user) {
        userDao.delete(user);
    }

}
