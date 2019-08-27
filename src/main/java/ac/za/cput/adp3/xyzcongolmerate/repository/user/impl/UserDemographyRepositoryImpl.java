package ac.za.cput.adp3.xyzcongolmerate.repository.user.impl;

import ac.za.cput.adp3.xyzcongolmerate.domain.org.OrganisationUser;
import ac.za.cput.adp3.xyzcongolmerate.domain.user.UserDemography;
import ac.za.cput.adp3.xyzcongolmerate.repository.user.UserDemographyRepository;

import java.util.HashSet;
import java.util.Set;

public class UserDemographyRepositoryImpl implements UserDemographyRepository {

    private Set<UserDemography> userDemographyDB;
    private static UserDemographyRepositoryImpl userDemographyRepository = null;

    private UserDemographyRepositoryImpl() {
        this.userDemographyDB = new HashSet<>();
    }

    public static UserDemographyRepositoryImpl getUserDemographyRepository() {
        if (userDemographyRepository == null) userDemographyRepository = new UserDemographyRepositoryImpl();
        return userDemographyRepository;
    }

    //TODO: Implement body
    @Override
    public UserDemography create(UserDemography userDemography) {
        UserDemography ud =findGender(userDemography.getUserEmail());
        if(ud==null){
            userDemographyDB.add(userDemography);
            return userDemography;
        }return null;
    }


    @Override
    public UserDemography read(String userEmail) {
        return findGender(userEmail);
    }


    @Override
    public UserDemography update(UserDemography userDemography) {
        UserDemography ud =findGender(userDemography.getUserEmail());
        if(ud!=null){
            userDemographyDB.remove(userDemography);
            create(userDemography);
            return userDemography;
        }return null;
    }

    //TODO: Implement body
    @Override
    public void delete(String userEmail) {
        UserDemography ud =findGender(userEmail);
        if(ud!=null){
            userDemographyDB.remove(ud);
        }
    }

    //TODO: Implement body
    @Override
    public Set<UserDemography> getAll() {
       return userDemographyDB;
    }

    public UserDemography findGender(final String userEmail){
        return userDemographyDB.stream()
                .filter(gen -> gen.getUserEmail().equals(userEmail))
                .findAny()
                .orElse(null);
    }
}
