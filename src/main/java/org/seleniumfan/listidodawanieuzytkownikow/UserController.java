package org.seleniumfan.listidodawanieuzytkownikow;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/add")
    public String addUser(@RequestParam String imie,
                          @RequestParam String nazwisko,
                          @RequestParam Integer wiek) {
        if (imie.isEmpty()) {
            return "err";
        }
        userRepository.addUser(new User(imie, nazwisko, wiek));
        return "success";
    }

    @PostMapping("/")
    public String addUserByPostMethod(@RequestParam String imie,
                                      @RequestParam String nazwisko,
                                      @RequestParam Integer wiek) {
        if (imie.isEmpty()) {
            return "redirect:/err.html";
        }
        userRepository.addUser(new User(imie, nazwisko, wiek));
        return "redirect:/success.html";
    }

    @GetMapping("/")
    public String redirect() {
        return "index";
    }
}
