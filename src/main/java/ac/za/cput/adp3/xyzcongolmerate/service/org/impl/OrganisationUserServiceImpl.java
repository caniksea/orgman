package ac.za.cput.adp3.xyzcongolmerate.service.org.impl;

import ac.za.cput.adp3.xyzcongolmerate.domain.org.Organisation;
import ac.za.cput.adp3.xyzcongolmerate.domain.org.OrganisationUser;
import ac.za.cput.adp3.xyzcongolmerate.domain.user.User;
import ac.za.cput.adp3.xyzcongolmerate.factory.org.OrganisationUserFactory;
import ac.za.cput.adp3.xyzcongolmerate.repository.org.OrganisationUserRepository;
import ac.za.cput.adp3.xyzcongolmerate.repository.org.impl.OrganisationRepositoryImpl;
import ac.za.cput.adp3.xyzcongolmerate.repository.org.impl.OrganisationUserRepositoryImpl;
import ac.za.cput.adp3.xyzcongolmerate.repository.user.UserRepository;
import ac.za.cput.adp3.xyzcongolmerate.repository.user.impl.UserRepositoryImpl;
import ac.za.cput.adp3.xyzcongolmerate.service.org.OrganisationUserService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class OrganisationUserServiceImpl implements OrganisationUserService {

    private OrganisationUserRepositoryImpl organisationUserRepository;
    private static OrganisationUserServiceImpl organisationUserService = null;

    private OrganisationUserServiceImpl() {
        this.organisationUserRepository = OrganisationUserRepositoryImpl.getOrganisationUserRepository();
    }

    public static OrganisationUserServiceImpl getOrganisationUserService() {
        if (organisationUserService == null) organisationUserService = new OrganisationUserServiceImpl();
        return organisationUserService;
    }

    @Override
    public OrganisationUser create(OrganisationUser organisationUser) {
        return this.organisationUserRepository.create(organisationUser);
    }

    @Override
    public OrganisationUser read(String orgCode, String userEmail) {
        return this.organisationUserRepository.read(orgCode, userEmail);
    }

    @Override
    public OrganisationUser update(OrganisationUser organisationUser) {
        return this.organisationUserRepository.update(organisationUser);
    }

    @Override
    public void delete(String orgCode, String userEmail) {
        this.organisationUserRepository.delete(orgCode, userEmail);
    }

    @Override
    public Set<OrganisationUser> getAll() {
        return this.organisationUserRepository.getAll();
    }


    @Override
    public Set<String> getUserFullNamesInOrganisation(String orgCode) {
        ArrayList<String> myEmail=new ArrayList<>();
        HashSet<String> userName=new HashSet<>();

        myEmail.addAll(organisationUserRepository.getEmail(orgCode));


        for(int i=0;i<myEmail.size();i++){

            userName.add(getUsers(myEmail.get(i)));
        }
        return userName;
    }

    @Override
    public Set<String> getUserOrganisations(String userEmail) {
        ArrayList<String> myOrgCode=new ArrayList<>();
        HashSet<String> myOrganizationName=new HashSet<>();
        myOrgCode.addAll(organisationUserRepository.organisation(userEmail));

        for(int i=0;i<myOrgCode.size();i++){
            myOrganizationName.add(getOrgName(myOrgCode.get(i)));

        }
        return myOrganizationName;
    }
    public String getUsers(String email){
        UserRepositoryImpl user= UserRepositoryImpl.getUserRepository();
        User userdetails=user.read(email);
        return userdetails.getFirstName()+" "+userdetails.getLastName();
    }
    public String getOrgName(String orgCode){
        OrganisationRepositoryImpl org= OrganisationRepositoryImpl.getOrganisationRepository();
        Organisation orgName=org.read(orgCode);

        return orgName.getOrgName();
    }
}
