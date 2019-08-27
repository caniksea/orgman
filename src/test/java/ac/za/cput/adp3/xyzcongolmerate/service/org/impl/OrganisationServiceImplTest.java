package ac.za.cput.adp3.xyzcongolmerate.service.org.impl;

import ac.za.cput.adp3.xyzcongolmerate.domain.org.Organisation;
import ac.za.cput.adp3.xyzcongolmerate.factory.org.OrganisationFactory;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrganisationServiceImplTest {
    Organisation organisation= OrganisationFactory.buildOrganisation("CPUT");
    OrganisationServiceImpl organisationService=OrganisationServiceImpl.getOrganisationService();

    @Test
    public void a_create() {
        Assert.assertNotNull(organisationService.create(organisation));
    }

    @Test
    public void b_read() {
        Organisation resultR=organisationService.create(organisation);
       Assert.assertNotNull(organisationService.read(resultR.getOrgCode()));
    }

    @Test
    public void c_update() {
        Organisation resultU=organisationService.create(organisation);
        Organisation reult=new Organisation.Builder().orgCode(resultU.getOrgCode()).orgName("KUJALI").build();
        Organisation UpResult=organisationService.update(reult);
        Assert.assertNotEquals(resultU,UpResult);
    }

    @Test
    public void e_delete() {
        Organisation resultU=organisationService.create(organisation);
        organisationService.delete(resultU.getOrgCode());
        Assert.assertNull(organisationService.read(resultU.getOrgCode()));
    }

    @Test
    public void d_getAll() {
        Organisation resultU=organisationService.create(organisation);
        Assert.assertNotNull(organisationService.getAll());

    }
}