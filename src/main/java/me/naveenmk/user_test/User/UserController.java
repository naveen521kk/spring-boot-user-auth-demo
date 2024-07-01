package me.naveenmk.user_test.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Controller
public class UserController implements WebMvcConfigurer {
    private final UserRepository repository;

    UserController(UserRepository repository) {
        this.repository = repository;
    }

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/login").setViewName("login");
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
            Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @GetMapping("/register")
    public String register(User user) {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute User user, BindingResult bindingResult, Model model) {
        
        System.out.println(bindingResult);
        if (bindingResult.hasErrors()) {
            return "register";
        }
        
        if (repository.getUserByUsername(user.getUsername()) != null) {
            model.addAttribute("error", "User already exists");
            return "register";
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(user.getPassword());

        user.setPassword(encodedPassword);

        repository.save(user);

        return "redirect:/login";
    }

    @GetMapping("/about")
    public String about(@AuthenticationPrincipal MyUserDetails user, Model model) {
        model.addAttribute("user", user.getUser());
        return "about";
    }
    
    @GetMapping("/search")
    public String search(@AuthenticationPrincipal MyUserDetails user, 
            @RequestParam(value = "q", required = false) String q,
            Model model) {
        model.addAttribute("user", user.getUser());
        model.addAttribute("q", q);

        // search for name matching the query
        Iterable<User> byNameContaining = repository.findByNameContaining(q);
        System.out.println(byNameContaining);
        model.addAttribute("results", byNameContaining);

        return "search";
    }

    

}