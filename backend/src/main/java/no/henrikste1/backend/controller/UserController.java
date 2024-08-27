package no.henrikste1.backend.controller;

import no.henrikste1.backend.model.Category;
import no.henrikste1.backend.model.Product;
import no.henrikste1.backend.model.User;
import no.henrikste1.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping(path = "/add")
    public @ResponseBody String addNewUser (
            @RequestParam String username,
            @RequestParam Integer permissionLevel,
            @RequestParam List<Product> products,
            @RequestParam List<Category> categories ) {

        User u = new User();
        u.setUsername(username);
        u.setPermissionLevel(permissionLevel);
        u.setProducts(products);
        u.setCategories(categories);
        userRepository.save(u);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
}
