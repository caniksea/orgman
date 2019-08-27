package ac.za.cput.adp3.xyzcongolmerate.repository.user.impl;

import ac.za.cput.adp3.xyzcongolmerate.domain.user.User;
import ac.za.cput.adp3.xyzcongolmerate.domain.user.UserRole;
import ac.za.cput.adp3.xyzcongolmerate.repository.user.UserRoleRepository;

import java.util.HashSet;
import java.util.Set;

public class UserRoleRepositoryImpl implements UserRoleRepository {

    private Set<UserRole> userRoleDB;
    private static UserRoleRepositoryImpl userRoleRepository = null;

    private UserRoleRepositoryImpl() {
        this.userRoleDB = new HashSet<>();
    }

    public static UserRoleRepositoryImpl getUserRoleRepository() {
        if (userRoleRepository == null) userRoleRepository = new UserRoleRepositoryImpl();
        return userRoleRepository;
    }


    @Override
    public UserRole create(UserRole userRole) {
        userRoleDB.add(userRole);
        return userRole;
    }


    @Override
    public UserRole read(UserRole userRole) {
       UserRole result=findGender(userRole.getRoleId());
       if(result!=null){
           return result;
       }return null;
    }


    @Override
    public UserRole update(UserRole userRole) {
        UserRole result=findGender(userRole.getRoleId());
        if(result!=null){
            userRoleDB.remove(result);
            create(userRole);
            return userRole;
        }return null;
    }


    @Override
    public void delete(UserRole userRole) {
        UserRole result=findGender(userRole.getRoleId());
        if(result!=null){
            userRoleDB.remove(result);}
    }


    @Override
    public Set<UserRole> getAll() {
       return userRoleDB;
    }
    public UserRole findGender(final String userEmail){
        return userRoleDB.stream()
                .filter(gen -> gen.getRoleId().equals(userEmail))
                .findAny()
                .orElse(null);
    }
}
