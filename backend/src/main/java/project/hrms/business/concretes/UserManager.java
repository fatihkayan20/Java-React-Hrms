package project.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hrms.business.abstracts.UserService;
import project.hrms.dataAccess.abstracts.UserDao;
import project.hrms.entities.concretes.User;

import java.util.List;


@Service
public class UserManager implements UserService {

    private UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public List<User> getAll() {
        return userDao.findAll();
    }

    @Override
    public User get(int id) {
        return userDao.findById(id).get();
    }

    @Override
    public User getByEmail(String email) {
        return this.userDao.getByEmail(email);
    }


}
