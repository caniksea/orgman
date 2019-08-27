package ac.za.cput.adp3.xyzcongolmerate.service.user.impl;

import ac.za.cput.adp3.xyzcongolmerate.domain.user.UserDemography;
import ac.za.cput.adp3.xyzcongolmerate.factory.user.UserDemographyFactory;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Date;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserDemographyServiceImplTest {
    UserDemographyServiceImpl userService=UserDemographyServiceImpl.getUserDemographyService();
    Date bod= new Date();
    UserDemography userDemography= UserDemographyFactory.buildUserDemography("@emksd","CEO","MAle","Black",bod);
    @Test
    public void a_create() {
        Assert.assertNotNull(userService.create(userDemography));    }

    @Test
    public void b_read() {
        UserDemography result=userService.create(userDemography);
        Assert.assertNotNull(userService.read(result.getUserEmail()));
    }

    @Test
    public void c_update() {
        UserDemography result=userService.create(userDemography);
        UserDemography result2=new UserDemography("@emksd","DRIVER","MAle","Black",bod);
        UserDemography UpdatedResult=userService.update(result2);
        Assert.assertNotEquals(result,UpdatedResult);
    }

    @Test
    public void e_delete() {
        UserDemography result=userService.create(userDemography);
        userService.delete(result.getUserEmail());
        Assert.assertNull(userService.read(result.getUserEmail()));

    }

    @Test
    public void d_getAll() {
        UserDemography result=userService.create(userDemography);
        Assert.assertNotNull(userService.getAll());

    }
}