package ac.za.cput.adp3.xyzcongolmerate.service.demography.impl;

import ac.za.cput.adp3.xyzcongolmerate.domain.demography.Gender;
import ac.za.cput.adp3.xyzcongolmerate.factory.demography.GenderFactory;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GenderServiceImplTest {
private GenderServiceImpl genderService=GenderServiceImpl.getGenderService();
    Gender gender= GenderFactory.buildGender("MALE");

    @Test
    public void a_create() {
        Assert.assertNotNull(genderService.create(gender));
    }

    @Test
    public void b_read() {
        genderService.create(gender);
        Assert.assertNotNull(genderService.read(gender.getGenderId()));
    }

    @Test
    public void c_update() {
        Gender result2=genderService.create(gender);
        Gender resu=new Gender.Builder().genderDescription("other").genderId(result2.getGenderId()).build();
        Gender result=genderService.update(resu);
        Assert.assertNotEquals(result2,result);
    }

    @Test
    public void e_delete() {
        genderService.create(gender);
        genderService.delete(gender.getGenderId());
       Assert.assertNull(genderService.read(gender.getGenderId()));
    }

    @Test
    public void d_getAll() {
        genderService.create(gender);
        Assert.assertNotNull(genderService.getAll());    }
}