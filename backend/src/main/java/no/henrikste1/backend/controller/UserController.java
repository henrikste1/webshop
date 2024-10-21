package no.henrikste1.backend.controller;

import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import no.henrikste1.backend.model.User;
import no.henrikste1.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import no.henrikste1.backend.service.FirebaseUserService;

import java.util.Optional;

@Controller
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    private FirebaseUserService firebaseUserService;

    @PostMapping(path = "/add")
    public @ResponseBody String addNewUser (
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam String firebaseId,
            @RequestParam Integer permissionLevel ) throws FirebaseAuthException {

        UserRecord firebaseUser = firebaseUserService.createUser(email, password);

        User u = new User();
        u.setEmail(email);
        u.setPassword(password);
        u.setFirebaseId(firebaseUser.getUid());
        u.setPermissionLevel(permissionLevel);
        userRepository.save(u);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody Optional<User> getUserById(@PathVariable Long id) {
        return userRepository.findById(id);
    }

    @PutMapping(path = "/update/{id}")
    public @ResponseBody String updateUser(
            @PathVariable Long id,
            @RequestParam Integer permissionLevel) {

        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User u = optionalUser.get();
            u.setPermissionLevel(permissionLevel);
            userRepository.save(u);
            return "User updated with ID: " + id;
        } else {
            return "User not found with ID: " + id;
        }
    }

    @DeleteMapping(path = "/delete/{id}")
    public @ResponseBody String deleteUser(@PathVariable Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return "User deleted with ID: " + id;
        } else {
            return "User not found with ID: " + id;
        }
    }
}


