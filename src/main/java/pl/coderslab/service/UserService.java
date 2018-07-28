package pl.coderslab.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.coderslab.entity.User;
import pl.coderslab.repository.UserRepository;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Component
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void addUser(User user){
        String hashedPassword = BCrypt.hashpw( user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashedPassword);
        userRepository.save(user);
    }

    public boolean checkLogin(String username, String password){
        User user = userRepository.findByUsername(username);
        if(user != null){
            return BCrypt.checkpw(password, user.getPassword());
        }
        return false;
    }

    public User getLogedUser(HttpServletRequest request){
        return (User)request.getSession().getAttribute("UserLogged");
    }

    public boolean changePasswordIfCorrect(User user, HttpServletRequest request){
        User userInBase = userRepository.findFirstByEmail(user.getEmail());
        if(userInBase != null){
            if( userInBase.getUsername().equals(user.getUsername())){
                HttpSession sess = request.getSession();
                sess.invalidate();
                userInBase.setPassword(BCrypt.hashpw(request.getParameter("newPassword"), BCrypt.gensalt()) );
                userRepository.save(userInBase);
                return true;
            }
        }
        return false;
    }


}
