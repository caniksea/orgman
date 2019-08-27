package ac.za.cput.adp3.xyzcongolmerate.repository.org.impl;

import ac.za.cput.adp3.xyzcongolmerate.domain.org.OrganisationUser;
import ac.za.cput.adp3.xyzcongolmerate.factory.org.OrganisationFactory;
import ac.za.cput.adp3.xyzcongolmerate.factory.org.OrganisationUserFactory;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrganisationUserRepositoryImplTest {
 OrganisationUserRepositoryImpl organisationUserRepository=OrganisationUserRepositoryImpl.getOrganisationUserRepository();
    OrganisationUser org= OrganisationUserFactory.buildOrganisationUser("234","espeo@");
    @Test
    public void a_create() {
        Assert.assertNotNull(organisationUserRepository.create(org));
    }

    @Test
    public void b_read() {
        OrganisationUser result=organisationUserRepository.create(org);
        Assert.assertNotNull(result);
    }

    @Test
    public void c_update() {
        OrganisationUser result=organisationUserRepository.create(org);
        OrganisationUser result2= new OrganisationUser(result.getOrgCode(),"voila@!");
        Assert.assertNotEquals(result,result2);
    }

    @Test
    public void e_delete() {
        OrganisationUser result=organisationUserRepository.create(org);
        organisationUserRepository.delete(result.getOrgCode(),result.getUserEmail());
        Assert.assertNull(organisationUserRepository.read(result.getOrgCode(),result.getUserEmail()));
    }

    @Test
    public void d_getAll() {
        for(int i=0;i<3;i++){
            organisationUserRepository.create(org);}
        for(int i=0;i<3;i++){
            Assert.assertNotNull(organisationUserRepository.getAll());
        }
    }
}