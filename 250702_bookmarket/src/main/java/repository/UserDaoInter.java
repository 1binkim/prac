package repository;

import vo.User;
import java.sql.SQLException;
import java.util.List;

public interface UserDaoInter {
    int insertUser(User user) throws SQLException;
    User findById(Long userId) throws SQLException;
    List<User> findAll() throws SQLException;
    int updateUser(User user) throws SQLException;
    int deleteUser(Long userId) throws SQLException;
}
