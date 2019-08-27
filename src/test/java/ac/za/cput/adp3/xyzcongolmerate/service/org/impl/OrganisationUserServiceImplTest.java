package ac.za.cput.adp3.xyzcongolmerate.service.org.impl;

import ac.za.cput.adp3.xyzcongolmerate.domain.org.Organisation;
import ac.za.cput.adp3.xyzcongolmerate.domain.org.OrganisationUser;
import ac.za.cput.adp3.xyzcongolmerate.domain.user.User;
import ac.za.cput.adp3.xyzcongolmerate.domain.user.UserDemography;
import ac.za.cput.adp3.xyzcongolmerate.factory.org.OrganisationFactory;
import ac.za.cput.adp3.xyzcongolmerate.factory.org.OrganisationUserFactory;
import ac.za.cput.adp3.xyzcongolmerate.factory.user.UserDemographyFactory;
import ac.za.cput.adp3.xyzcongolmerate.factory.user.UserFactory;
import ac.za.cput.adp3.xyzcongolmerate.service.org.OrganisationService;
import ac.za.cput.adp3.xyzcongolmerate.service.user.UserService;
import ac.za.cput.adp3.xyzcongolmerate.service.user.impl.UserDemographyServiceImpl;
import ac.za.cput.adp3.xyzcongolmerate.service.user.impl.UserServiceImpl;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Date;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrganisationUserServiceImplTest {
    OrganisationUser org= OrganisationUserFactory.buildOrganisationUser("234","espeo@");
    OrganisationUserServiceImpl organisationUserService=OrganisationUserServiceImpl.getOrganisationUserService();

    @Test
    public void a_create() {
        Assert.assertNotNull(organisationUserService.create(org));
    }

    @Test
    public void b_read() {
        OrganisationUser resultR=organisationUserService.create(org);
        Assert.assertNotNull(organisationUserService.read(resultR.getOrgCode(),resultR.getUserEmail()));
    }

    @Test
    public void c_update() {
        OrganisationUser resultR=organisationUserService.create(org);
        OrganisationUser organisationUser=new OrganisationUser(resultR.getOrgCode(),"espoir@cput");
        OrganisationUser UpResult=organisationUserService.update(organisationUser);
        Assert.assertNotEquals(UpResult,resultR);
    }

    @Test
    public void g_delete() {
        OrganisationUser resultR=organisationUserService.create(org);
        organisationUserService.delete(resultR.getOrgCode(),resultR.getUserEmail());
        Assert.assertNull(organisationUserService.read(resultR.getOrgCode(),resultR.getUserEmail()));
    }

    @Test
    public void d_getAll() {
        OrganisationUser resultR=organisationUserService.create(org);
        Assert.assertNotNull(organisationUserService.getAll());
    }

    @Test
    public void e_getUserFullNamesInOrganisation() {
        UserServiceImpl userService=UserServiceImpl.getUserService();

        OrganisationUser resultR=organisationUserService.create(org);
        Organisation organisation= OrganisationFactory.buildOrganisation("CPUT");
        OrganisationUser org= OrganisationUserFactory.buildOrganisationUser(organisation.getOrgCode(),"espeo@");

        User user= UserFactory.buildUser("espeo@","Espoir","Ditel");


        Date bod= new Date();
        UserDemography userDemography= UserDemographyFactory.buildUserDemography("espeo@","CEO","MAle","Black",bod);
        userService.create(user);

        System.out.println(organisationUserService.getUserFullNamesInOrganisation(resultR.getOrgCode())+"<<<<<<vooila>>>>>>>");
        Assert.assertNotNull(organisationUserService.getUserFullNamesInOrganisation(resultR.getOrgCode()));
    }

    @Test
    public void f_getUserOrganisations() {
        UserServiceImpl userService=UserServiceImpl.getUserService();
        OrganisationServiceImpl organisationService=OrganisationServiceImpl.getOrganisationService();
        UserDemographyServiceImpl userDemographyService=UserDemographyServiceImpl.getUserDemographyService();



        Organisation organisation= OrganisationFactory.buildOrganisation("CPUT");
        organisationService.create(organisation);

        OrganisationUser org1= OrganisationUserFactory.buildOrganisationUser(organisation.getOrgCode(),"espeo@");
        OrganisationUser resultR=organisationUserService.create(org1);


        User user= UserFactory.buildUser("espeo@","Espoir","Ditel");
        userService.create(user);

        Date bod= new Date();
        UserDemography userDemography= UserDemographyFactory.buildUserDemography("espeo@","CEO","MAle","Black",bod);
        userDemographyService.create(userDemography);


        Assert.assertNotNull(organisationUserService.getUserOrganisations("espeo@"));
    }
}