package project.hrms.business.abstracts;

import project.hrms.entities.concretes.User;

import java.util.List;

public interface UserService {

    List<User> getAll();
    User get(int id);
    User getByEmail(String email);

}
