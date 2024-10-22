package no.henrikste1.backend.controller;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import no.henrikste1.backend.dto.LoginRequest;
import no.henrikste1.backend.model.User;
import no.henrikste1.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import no.henrikste1.backend.service.FirebaseUserService;

import java.util.Optional;

@Controller
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FirebaseUserService firebaseUserService;

    @PostMapping(path = "/add")
    public @ResponseBody String addNewUser (
            @RequestParam String email,
            @RequestParam String password) throws FirebaseAuthException {

        UserRecord firebaseUser = firebaseUserService.createUser(email, password);

        User u = new User();
        u.setEmail(email);
        u.setPassword(password);
        u.setFirebaseId(firebaseUser.getUid());
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

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            // Attempt to retrieve the user by email
            UserRecord userRecord = FirebaseAuth.getInstance().getUserByEmail(loginRequest.getEmail());

            // After successful retrieval, generate a custom token for the user
            String customToken = FirebaseAuth.getInstance().createCustomToken(userRecord.getUid());

            // Return the custom token to be used by the client for Firebase Auth
            return ResponseEntity.ok().body(customToken);
        } catch (FirebaseAuthException e) {
            // Handle exceptions such as user not found or token generation failure
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed: " + e.getMessage());
        }
    }
}


