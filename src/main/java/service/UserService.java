package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.UserDAO;
import vo.User;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserService {

    private final UserDAO dao;

    @Autowired
    public UserService(UserDAO dao) {
        this.dao = dao;
    }

    public List<User> getAllUsers() throws SQLException {
        return dao.getAllUsers();
    }

    public User getUserById(Long id) throws SQLException {
        return dao.getUserById(id);
    }

    @Transactional
    public int registerUser(User user) throws SQLException {
        return dao.registerUser(user);
    }

    @Transactional
    public int updateUser(User user) throws SQLException {
        return dao.updateUser(user);
    }

    @Transactional
    public int deleteUser(Long userId) throws SQLException {
        return dao.deleteUser(userId);
    }
}
