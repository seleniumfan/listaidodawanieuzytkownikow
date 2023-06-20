package org.seleniumfan.listidodawanieuzytkownikow;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {
    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @GetMapping("/users")
    public String getUsers(Model model) {
        List<User> users = userRepository.getUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @RequestMapping("/add")
    public String addUser(@RequestParam(name="imie") String name,
                          @RequestParam(name="nazwisko") String surname,
                          @RequestParam(name="wiek", required = false) Integer year) {
        if (name.isEmpty()) {
            return "redirect:/err.html";
        }
        userRepository.addUser(new User(name, surname, year));
        return "redirect:/success.html";
    }

    @GetMapping("/")
    public String redirect() {
        return "index";
    }
}
