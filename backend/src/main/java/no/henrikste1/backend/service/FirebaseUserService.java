package no.henrikste1.backend.service;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import org.springframework.stereotype.Service;


// Firebase user management
@Service
public class FirebaseUserService {

    public UserRecord createUser(String email, String password) throws FirebaseAuthException {
        UserRecord.CreateRequest request = new UserRecord.CreateRequest()
                .setEmail(email)
                .setPassword(password);

        return FirebaseAuth.getInstance().createUser(request);
    }

    public void updateUser(String uid, String email, String password) throws FirebaseAuthException {
        UserRecord.UpdateRequest request = new UserRecord.UpdateRequest(uid)
                .setEmail(email)
                .setPassword(password);

        FirebaseAuth.getInstance().updateUser(request);
    }
}
