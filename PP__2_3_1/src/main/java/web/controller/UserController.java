package web.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import web.model.UserModel;
import web.service.UserService;
import web.service.UserServiceImpl;

import java.util.List;

@Controller
@RequestMapping(("/"))
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String allUsers(Model model) {
        model.addAttribute("users", userService.allUsers());
        return "users";
    }

    @GetMapping("/new")
    public String addUser(ModelMap model) {
        model.addAttribute("user", new UserModel());
        return "addUser";
    }

    @PostMapping()
    public String addUser(@ModelAttribute("user") UserModel user) {
        userService.add(user);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String updateUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getById(id));
        return "editUser";
    }

    @PatchMapping("/edit/{id}")
    public String updateUser(@ModelAttribute("user") UserModel user, @PathVariable("id") int id) {
        userService.edit(id, user);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/";
    }

}
