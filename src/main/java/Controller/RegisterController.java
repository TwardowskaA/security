package Controller;

import User.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {

    private UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/rejestracja")
    public String rejestracja(){
        return "login";
    }

    @PostMapping("/rejestracja")
    public String zarejestruj(@RequestParam String login,
                              @RequestParam String password,
                              @RequestParam String firstName,
                              @RequestParam String lastName){
        userService.addUser(login,password,firstName,lastName);
        return "redirect:/login";
    }


}
