package repository;

import vo.User;
import java.sql.SQLException;
import java.util.List;

public interface UserDaoInter {
    /** 신규 사용자 등록 */
    int insertUser(User user) throws SQLException;

    /** ID로 사용자 조회 */
    User findById(Long userId) throws SQLException;

    /** 전체 사용자 조회 */
    List<User> findAll() throws SQLException;

    /** 사용자 정보 수정 */
    int updateUser(User user) throws SQLException;

    /** 사용자 삭제 */
    int deleteUser(Long userId) throws SQLException;
}