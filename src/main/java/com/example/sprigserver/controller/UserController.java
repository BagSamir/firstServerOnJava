package com.example.sprigserver.controller;

import com.example.sprigserver.models.User;
import com.example.sprigserver.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller

public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());

        return "user-list";
    }

    @GetMapping("users/new")
    public String createNewUserForm(@ModelAttribute("user") User user) {
        return "create-user";
    }

    @GetMapping("users/edit")
    public String editUser(@RequestParam("id") Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));

        return "edit-user";
    }

    @PostMapping("/users")
    public String createNewUser(@ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "create-user";
        }
        userService.saveUser(user);
        return "redirect:/users";
    }

    @PostMapping("users/delete")
    public String deleteUser(@RequestParam("id") Long id) {
        userService.deleteUserById(id);

        return "redirect:/users";
    }

    @PostMapping("users/edit")
    public String updateUser(@ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edit-user";
        }
        userService.updateUser(user);
        return "redirect:/users";
    }
}
