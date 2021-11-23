package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.PenjagaModel;
import apap.tutorial.cineplux.model.UserModel;
import org.springframework.security.core.userdetails.User;

import java.util.List;

public interface UserService {
    UserModel addUser(UserModel user);
    UserModel findUserByUsername(String username);
    List<UserModel> getListUser();
    String encrypt(String password);
    void deleteUser(UserModel user);
    boolean checkIfValidOldPassword(UserModel user, String password);
    UserModel changeUserPassword(UserModel user, String password);
}
