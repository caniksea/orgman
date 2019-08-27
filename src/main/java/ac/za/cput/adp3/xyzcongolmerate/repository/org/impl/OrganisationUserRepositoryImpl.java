package ac.za.cput.adp3.xyzcongolmerate.repository.org.impl;

import ac.za.cput.adp3.xyzcongolmerate.domain.org.OrganisationUser;
import ac.za.cput.adp3.xyzcongolmerate.repository.org.OrganisationUserRepository;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class OrganisationUserRepositoryImpl implements OrganisationUserRepository {

    private Set<OrganisationUser> organisationUserDB;
    private static OrganisationUserRepositoryImpl organisationUserRepository = null;

    private OrganisationUserRepositoryImpl() {
        this.organisationUserDB = new HashSet<>();
    }

    public static OrganisationUserRepositoryImpl getOrganisationUserRepository() {
        if (organisationUserRepository == null) organisationUserRepository = new OrganisationUserRepositoryImpl();
        return organisationUserRepository;
    }


    @Override
    public OrganisationUser create(OrganisationUser organisationUser) {
        OrganisationUser org =findGender(organisationUser.getOrgCode(),organisationUser.getUserEmail());
        if(org==null){
            organisationUserDB.add(organisationUser);
            return organisationUser;
        }return null;
    }


    @Override
    public OrganisationUser read(String orgCode, String userEmail) {
       return findGender(orgCode,userEmail);
    }


    @Override
    public OrganisationUser update(OrganisationUser organisationUser) {
        OrganisationUser org =findGender(organisationUser.getOrgCode(),organisationUser.getUserEmail());
        if(org!=null){
            organisationUserDB.remove(org);
            create(organisationUser);
            return organisationUser;
        }return null;
    }


    @Override
    public void delete(String orgCode, String userEmail) {
        OrganisationUser org =findGender(orgCode,userEmail);
        if(org!=null){
            organisationUserDB.remove(org);
        }

    }
    public Set<String> getEmail(String orgCode){
         Set<String> myEmail=new HashSet<>();
        myEmail= Collections.singleton(organisationUserDB.stream()
                .filter(gen -> gen.getOrgCode().equals(orgCode))
                .findAny()
                .orElse(null).getUserEmail());

        return myEmail;

    }
    public Set<String> organisation(String email){
        Set<String> myOrgCode=new HashSet<>();
        myOrgCode= Collections.singleton(organisationUserDB.stream()
                .filter(gen -> gen.getUserEmail().equals(email))
                .findAny()
                .orElse(null).getOrgCode());

        return myOrgCode;
    }


    @Override
    public Set<OrganisationUser> getAll() {
        return organisationUserDB;
    }

    public OrganisationUser findGender(String orgCode, final String userEmail){
        return organisationUserDB.stream()
                .filter(gen -> gen.getOrgCode().equals(orgCode))
                .filter(org ->org.getUserEmail().equals(userEmail))
                .findAny()
                .orElse(null);
    }

}
