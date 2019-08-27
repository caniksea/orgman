package ac.za.cput.adp3.xyzcongolmerate.repository.user.impl;

import ac.za.cput.adp3.xyzcongolmerate.domain.user.User;
import ac.za.cput.adp3.xyzcongolmerate.domain.user.UserDemography;
import ac.za.cput.adp3.xyzcongolmerate.repository.user.UserRepository;

import java.util.HashSet;
import java.util.Set;

public class UserRepositoryImpl implements UserRepository {

    private Set<User> userDB;
    private static UserRepositoryImpl userRepository = null;

    private UserRepositoryImpl() {
        this.userDB = new HashSet<>();
    }

    public static UserRepositoryImpl getUserRepository() {
        if (userRepository == null) userRepository = new UserRepositoryImpl();
        return userRepository;
    }

    //TODO: Implement body
    @Override
    public User create(User user) {
        User user1=findGender(user.getUserEmail());
        if(user1==null){
            userDB.add(user);
            return user;
        }return user1;
    }


    @Override
    public User read(String email) {
       return findGender(email);
    }


    @Override
    public User update(User user) {
        User user1=findGender(user.getUserEmail());
        if(user1!=null){
            userDB.remove(user1);
            create(user);
            return user;
        }return null;
    }

    //TODO: Implement body
    @Override
    public void delete(String email) {
        User user1=findGender(email);
        if(user1!=null){
        userDB.remove(user1);
        }
    }

    //TODO: Implement body
    @Override
    public Set<User> getAll() {
        return userDB;
    }
    public User findGender(final String userEmail){
        return userDB.stream()
                .filter(gen -> gen.getUserEmail().equals(userEmail))
                .findAny()
                .orElse(null);
    }
}
