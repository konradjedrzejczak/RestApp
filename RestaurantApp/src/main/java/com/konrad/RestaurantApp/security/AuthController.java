package com.konrad.RestaurantApp.security;

import com.konrad.RestaurantApp.dto.UserDTO;
import com.konrad.RestaurantApp.exception.ServiceException;
import com.konrad.RestaurantApp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("userDTO", new UserDTO());
        return "register"; // Zwracamy nazwę widoku rejestracji
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("userDTO") UserDTO userDTO, BindingResult bindingResult) throws ServiceException {
        if (bindingResult.hasErrors()) {
            return "register"; // Ponownie wyświetlamy formularz rejestracji w przypadku błędów walidacji
        }
        // Jeśli dane są poprawne, tworzymy nowego użytkownika
        userService.createUser(userDTO);
        return "redirect:/"; // Po udanej rejestracji przekierowujemy na stronę logowania
    }
}
