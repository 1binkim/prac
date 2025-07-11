package vo;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class User {
	private Long userId;
	private String username;
	private String password;
	private String email;
	private String phone;
	private String role;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
}