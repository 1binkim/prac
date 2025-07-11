package repository;

import vo.User;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAO {

    private final DataSource dataSource;

    public UserDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<User> getAllUsers() throws SQLException {
        String sql = "SELECT * FROM users ORDER BY user_id";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            List<User> list = new ArrayList<>();
            while (rs.next()) {
                User u = new User();
                u.setUserId(rs.getLong("user_id"));
                u.setUsername(rs.getString("username"));
                u.setEmail(rs.getString("email"));
                u.setPhone(rs.getString("phone"));
                u.setRole(rs.getString("role"));
                u.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
                u.setUpdatedAt(rs.getTimestamp("updated_at").toLocalDateTime());
                list.add(u);
            }
            return list;
        }
    }

    public User getUserById(Long id) throws SQLException {
        String sql = "SELECT * FROM users WHERE user_id = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    User u = new User();
                    u.setUserId(rs.getLong("user_id"));
                    u.setUsername(rs.getString("username"));
                    u.setEmail(rs.getString("email"));
                    u.setPhone(rs.getString("phone"));
                    u.setRole(rs.getString("role"));
                    u.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
                    u.setUpdatedAt(rs.getTimestamp("updated_at").toLocalDateTime());
                    return u;
                }
                return null;
            }
        }
    }

    public int registerUser(User user) throws SQLException {
        String sql = "INSERT INTO users (username, password, email, phone, role) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPhone());
            ps.setString(5, user.getRole());
            return ps.executeUpdate();
        }
    }

    public int updateUser(User user) throws SQLException {
        String sql = "UPDATE users SET email = ?, phone = ?, role = ? WHERE user_id = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPhone());
            ps.setString(3, user.getRole());
            ps.setLong(4, user.getUserId());
            return ps.executeUpdate();
        }
    }

    public int deleteUser(Long userId) throws SQLException {
        String sql = "DELETE FROM users WHERE user_id = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, userId);
            return ps.executeUpdate();
        }
    }
}
