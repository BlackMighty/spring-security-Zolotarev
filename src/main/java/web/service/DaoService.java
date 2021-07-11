package web.service;

import java.util.List;

 public interface DaoService<T> {

        public T findById(long id);

        public List<T> listUsers();

        public void save(T user);

        public void delete(T user);

        public void update(T user, Long id);

        public T getItemByEmail(String email);
    }


