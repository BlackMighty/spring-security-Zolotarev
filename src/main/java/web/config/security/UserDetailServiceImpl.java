package web.config.security;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import web.dao.UserDao;


@Service ("userDetailServiceImpl")
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserDao userDao;

    @Autowired
    public UserDetailServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userDao.getItemByEmail(email);
    }
}
