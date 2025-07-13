package vo;

import lombok.Data;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

    //createdAt 포맷된 문자열 getter
    public String getCreatedAtStr() {
        return createdAt != null 
            ? createdAt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))
            : "";
    }

    //updatedAt 포맷된 문자열 getter
    public String getUpdatedAtStr() {
        return updatedAt != null 
            ? updatedAt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))
            : "";
    }
}

