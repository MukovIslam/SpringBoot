package islam.springCours.SpringBoot.dao;



import islam.springCours.SpringBoot.model.User;

import java.util.List;

public interface IUserDao {

    List<User> getAllUsers();
    void addUser(User user);
    void deleteUser (int id);
    void updateUser(User user);
    void deleteAllUsers();

}
