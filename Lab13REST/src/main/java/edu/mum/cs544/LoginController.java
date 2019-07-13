package edu.mum.cs544;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/login_failure")
    public String index() {
        return "loginFailure";
    }

    @GetMapping("/logout_success")
    public String logoutDone() {
        return "logoutSuccess";
    }

}
