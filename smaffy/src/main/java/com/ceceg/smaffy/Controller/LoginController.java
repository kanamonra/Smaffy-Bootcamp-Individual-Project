package com.ceceg.smaffy.Controller;

import com.ceceg.smaffy.Model.UsersData;
import com.ceceg.smaffy.Service.LoginService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;

    @GetMapping("/login")
    public String loginPage() {
        return "index";
    }

    @PostMapping("/loginauthenticate")
    public String afterlogindashboard(@RequestParam String username, @RequestParam String password, HttpSession session, Model model) {
        UsersData user = loginService.authenticate(username, password);
        if (user != null) {
            // Successful login, store user data in the session
            session.setAttribute("user", user);
            return "redirect:/dashboard"; // Redirect to the dashboard after successful login
        } else {
            // Failed login, show error message on the login page
            model.addAttribute("error", "Invalid username or password");
            return "index";
        }
    }

    @GetMapping("/logindashboard")
    public String dashboardPage(HttpSession session, Model model) {
        UsersData user = (UsersData) session.getAttribute("user");
        if (user != null) {
            model.addAttribute("user", user);
            return "dashboard";
        } else {
            return "redirect:/login"; // Redirect to the login page if not logged in
        }
    }
}
