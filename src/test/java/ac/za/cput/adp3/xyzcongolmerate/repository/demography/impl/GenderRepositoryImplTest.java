package ac.za.cput.adp3.xyzcongolmerate.repository.demography.impl;

import ac.za.cput.adp3.xyzcongolmerate.domain.demography.Gender;
import ac.za.cput.adp3.xyzcongolmerate.domain.demography.Race;
import ac.za.cput.adp3.xyzcongolmerate.factory.demography.GenderFactory;
import ac.za.cput.adp3.xyzcongolmerate.factory.demography.RaceFactory;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GenderRepositoryImplTest {
    Gender gender= GenderFactory.buildGender("MALE");
    GenderRepositoryImpl genderRepository=GenderRepositoryImpl.genderRepository();

    @Test
    public void a_create() {
        System.out.println(genderRepository.create(gender).toString());
        Assert.assertNotNull(genderRepository);
    }

    @Test
    public void b_read() {
        Gender gender1= genderRepository.create(this.gender);
        Gender gender= genderRepository.read(this.gender.getGenderId());
        Assert.assertEquals(gender,gender1);
    }

    @Test
    public void c_update() {
        Gender gender1= genderRepository.create(this.gender);
        Gender gender= GenderFactory.buildGender("Female");
        Gender result= genderRepository.update(gender);
        Assert.assertNotEquals(result,gender1);
    }

    @Test
    public void e_delete() {
 Gender myGender=genderRepository.create(gender);
        genderRepository.delete(myGender.getGenderId());
        Assert.assertNull(genderRepository.read(myGender.getGenderId()));
    }

    @Test
    public void d_getAll() {
        for(int i=0;i<3;i++){
            genderRepository.create(gender);
        }
        for(int i=0;i<3;i++){
            Assert.assertNotNull(genderRepository.getAll());
        }
    }
}