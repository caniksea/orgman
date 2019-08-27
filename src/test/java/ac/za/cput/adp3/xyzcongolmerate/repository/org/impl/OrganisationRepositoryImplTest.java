package ac.za.cput.adp3.xyzcongolmerate.repository.org.impl;

import ac.za.cput.adp3.xyzcongolmerate.domain.demography.Race;
import ac.za.cput.adp3.xyzcongolmerate.domain.org.Organisation;
import ac.za.cput.adp3.xyzcongolmerate.factory.demography.RaceFactory;
import ac.za.cput.adp3.xyzcongolmerate.factory.org.OrganisationFactory;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrganisationRepositoryImplTest {
    OrganisationRepositoryImpl organisationRep=OrganisationRepositoryImpl.getOrganisationRepository();
    Organisation organisation= OrganisationFactory.buildOrganisation("CPUT");
    @Test
    public void a_create() {
        Assert.assertNotNull(organisationRep.create(organisation));
    }

    @Test
    public void b_read() {
        Organisation result=organisationRep.create(organisation);
        Assert.assertNotNull(organisationRep.read(result.getOrgCode()));
    }

    @Test
    public void c_update() {
        Organisation result=organisationRep.create(organisation);
        Organisation reult2=new Organisation.Builder().orgCode(result.getOrgCode()).orgName("KUJALI").build();
        Assert.assertNotEquals(result,reult2);
    }

    @Test
    public void e_delete() {
        Organisation result=organisationRep.create(organisation);
        organisationRep.delete(result.getOrgCode());
        Assert.assertNull(organisationRep.read(result.getOrgCode()));
    }

    @Test
    public void d_getAll() {
        for(int i=0;i<3;i++){
            organisationRep.create(organisation);}
        for(int i=0;i<3;i++){
            Assert.assertNotNull(organisationRep.getAll());
        }
    }
}