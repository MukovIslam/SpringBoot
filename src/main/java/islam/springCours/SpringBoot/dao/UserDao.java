package islam.springCours.SpringBoot.dao;

import islam.springCours.SpringBoot.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;


@Transactional
@Repository
public class UserDao implements IUserDao {

    private EntityManager em;

    public UserDao(EntityManager em) {
        this.em = em;
    }
    @Override
    public List<User> getAllUsers(){
        return em.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Override
    public void addUser(User user) {
        em.persist(user);
    }

    @Override
    public void deleteUser (int id){
        User user = em.find(User.class, id);
        if (user != null) {
            em.remove(user);
        }
    }

    @Override
    public void updateUser(User user){
        em.merge(user);
    }

    @Override
    public void deleteAllUsers() {
        em.createQuery("DELETE FROM User").executeUpdate();
        em.createNativeQuery("ALTER TABLE test.users_mvc AUTO_INCREMENT = 1").executeUpdate();

    }
}
