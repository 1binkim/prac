package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.UserDaoInter;
import vo.User;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserService {

    private final UserDaoInter userDao;

    @Autowired
    public UserService(UserDaoInter userDao) {
        this.userDao = userDao;
    }

    @Transactional
    public int registerUser(User user) throws SQLException {
        return userDao.insertUser(user);
    }

    public User getUserById(Long userId) throws SQLException {
        return userDao.findById(userId);
    }

    public List<User> getAllUsers() throws SQLException {
        return userDao.findAll();
    }

    @Transactional
    public int updateUser(User user) throws SQLException {
        return userDao.updateUser(user);
    }

    @Transactional
    public int deleteUser(Long userId) throws SQLException {
        return userDao.deleteUser(userId);
    }
}