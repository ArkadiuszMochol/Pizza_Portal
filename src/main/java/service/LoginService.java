package service;

import javafx.scene.control.PasswordField;
import jdk.jfr.Label;
import model.User;
import utility.InMemoryDb;

import java.awt.*;
import java.io.IOException;
import java.util.Optional;

public class LoginService {

    // metoda do logowania użytkownika
    public Optional<User> loginUser(String login, String password) {
        return InMemoryDb.users.stream()
                .filter(user -> user.getLogin().equals(login) && user.getPassword().equals(password))
                .findAny();
    }

    // metoda do blokowania statusu użytkownika
    public void decrementProbes(String login) {
        Optional<User> userOpt = InMemoryDb.users.stream().
                filter(user -> user.getLogin().equals(login)).findAny();
        if (userOpt.isPresent()) {
            userOpt.get().setProbes(userOpt.get().getProbes() - 1);
        }
        if (userOpt.isPresent()) {
            if (userOpt.get().getProbes() == 0) {
                System.out.println("ZABLOKOWANO  KONTO");
                userOpt.get().setStatus(false);
            }

        }
    }

    //metoda rejestrująca ilość prób logowania
    public void clearLoginProbes(User user) {
        user.setProbes(3);
    }

    // metoda zwracająca pozostałą ilość prób logowania lub nic w przypadku braku loginu w users
    public String getLoginProbes(String login) {
        Optional<User> userOpt = InMemoryDb.users.stream()
                .filter(user -> user.getLogin().equals(login)).findAny();
        if (userOpt.isPresent()) {
            if (userOpt.get().getProbes() > 0) {
                return "pozostało: " + userOpt.get().getProbes() + " prób logowania";
            } else {
                return "Twoje konto jest zablokowane";
            }
        }
        return " błędny login ";
    }

    public static User loggedUser;

    public void login(TextField tfLogin, PasswordField pfPassword, Label lblInfo) {
        Optional<User> userOpt = loginUser(tfLogin.getText(), pfPassword.getText());
        if (userOpt.isPresent()) {
            if (userOpt.get().isStatus()) {
                try {
                    loggedUser = userOpt.get();
                    lblInfo.setText("zalogowano");
                    //WindowService windowService = new WindowService();


                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                lblInfo.setText("Twoje konto jest zablokowane");
            }

        } else {
            //dekrementacja liczby prób logowania ...

        }
    }


}
