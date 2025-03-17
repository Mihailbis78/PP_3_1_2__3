package ru.kata.spring.boot_security.pp_3_1_2__3.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kata.spring.boot_security.pp_3_1_2__3.entity.User;

@Controller
//@RequestMapping("/user")
public class UserController {

    @GetMapping("/user")
    public String userHome(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", user);
        return "users";
    }
}



//    private final UserService userService;
//    private final RoleService roleService;
//
//    @Autowired
//    public UserController(UserService userService, RoleService roleService) {
//        this.userService = userService;
//        this.roleService = roleService;
//    }
//
//    @GetMapping("/admin")
//    public String listUsers(Model model) {
//        model.addAttribute("users", userService.getAllUsers());
//        return "admin";
//    }
//
//    @GetMapping("/add")
//    public String showUserForm(Model model) {
//        model.addAttribute("user", new User());
//        return "admin_form";
//    }
//
//    @PostMapping("/add")
//    public String addUser(@RequestParam("name") String name,
//                          @RequestParam("surname") String surname,
//                          @RequestParam("email") String email,
//                          @RequestParam("role") String roleName) {
//        User user = new User(name, surname, email);
//        Role role = roleService.getRoleByName(roleName);
//        user.addRole(role);
//        userService.saveUser(user);
//        return "redirect:/";
//    }
//
//    @GetMapping("/edit")
//    public String showEditForm(@RequestParam("id") Integer id, Model model) {
//        User user = userService.getUserById(id);
//        model.addAttribute("user", user);
//        return "admin_form";
//    }
//
//    @PostMapping("/edit")
//    public String editUser(@RequestParam("id") Integer id,
//                           @RequestParam("name") String name,
//                           @RequestParam("surname") String surname,
//                           @RequestParam("email") String email) {
//        User user = userService.getUserById(id);
//        if (name != null) {
//            user.setName(name);
//            user.setSurname(surname);
//            user.setEmail(email);
//            userService.updateUser(user);
//        }
//        return "redirect:/";
//    }
//
//    @PostMapping("/delete")
//    public String deleteUser(@RequestParam("id") Integer id) {
//        userService.deleteUser(id);
//        return "redirect:/";
//    }
//}

