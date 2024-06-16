package islam.springCours.SpringBoot.service;

import islam.springCours.SpringBoot.dao.IUserDao;
import islam.springCours.SpringBoot.model.User;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    private IUserDao userDao;

    public UserService(IUserDao userDao) {
        this.userDao = userDao;
    }

    @PostConstruct
    public void init() {
        deleteAllUsers();
        User user1 = new User("Иван","Петров","email1@mail.ru");
        addUser(user1);
        User user2 = new User("Коля","Сидоров","email2@mail.ru");
        addUser(user2);
        User user3 = new User("Петя","Иванов","email3@mail.ru");
        addUser(user3);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void deleteAllUsers() {
        userDao.deleteAllUsers();
    }
}
