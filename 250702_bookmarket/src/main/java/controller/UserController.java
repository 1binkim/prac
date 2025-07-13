package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import service.UserService;
import vo.User;

import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/admin/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /** 전체 사용자 목록 */
    @GetMapping
    public String listUsers(Model model) throws SQLException {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "admin/userList";
    }

    /** 등록 폼 보여주기 */
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("user", new User()); // 비어있는 객체
        return "admin/userForm";
    }

    /** 등록 처리 */
    @PostMapping("/add")
    public String addUser(
            @RequestParam("newUsername") String username,
            @RequestParam("password") String password,
            @RequestParam("email") String email,
            @RequestParam(value = "phone", required = false) String phone,
            @RequestParam("role") String role
    ) throws SQLException {

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhone(phone);
        user.setRole(role);

        userService.registerUser(user);
        return "redirect:/admin/users";
    }

    /** 수정 폼 보여주기 */
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long userId, Model model) throws SQLException {
        User user = userService.getUserById(userId);
        model.addAttribute("user", user);
        return "admin/userForm";
    }

    /** 수정 처리 */
    @PostMapping("/edit")
    public String updateUser(@ModelAttribute User user, BindingResult binding) throws SQLException {
        if (binding.hasErrors()) {
            return "admin/userForm";
        }
        userService.updateUser(user);
        return "redirect:/admin/users";
    }

    /** 삭제 처리 */
    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long userId) throws SQLException {
        userService.deleteUser(userId);
        return "redirect:/admin/users";
    }
}
