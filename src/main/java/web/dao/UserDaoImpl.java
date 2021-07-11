package web.dao;

import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


@Transactional
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;


    public List<User> listUsers() {

        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    public User findById(long id) {
        return entityManager.find(User.class, id);
    }

    public void save(User user) {
        entityManager.persist(user);
    }

    public void update(User user, Long id) {
        User updatedUser = findById(id);
        updatedUser.setName(user.getName());
        updatedUser.setAge(user.getAge());
        updatedUser.setEmail(user.getEmail());
        entityManager.merge(updatedUser);
    }

    public void delete(User user) {
        User userDel = entityManager.find(User.class, user.getId());
        entityManager.remove(userDel);
    }

    @Override
    public User getItemByEmail(String email) {
        return (User) entityManager
                .createQuery("FROM User u WHERE u.email =:parEmail")
                .setParameter("parEmail", email)
                .getSingleResult();
    }
}