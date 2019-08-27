package ac.za.cput.adp3.xyzcongolmerate.service.user.impl;

import ac.za.cput.adp3.xyzcongolmerate.domain.user.UserRole;
import ac.za.cput.adp3.xyzcongolmerate.factory.user.UserRoleFactory;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserRoleServiceImplTest {
    UserRole userRole= UserRoleFactory.buildUserRole("003","espoi@fjg","voleur");
    UserRoleServiceImpl userRoleService=UserRoleServiceImpl.getUserRoleService();
    @Test
    public void a_create() {
        Assert.assertNotNull(userRoleService.create(userRole));
    }

    @Test
    public void b_read() {
        UserRole result=userRoleService.create(userRole);
        Assert.assertNotNull(userRoleService.read(result));
    }

    @Test
    public void c_update() {
        UserRole result=userRoleService.create(userRole);
        UserRole userRole=new UserRole("003","espoi@fjg","TEACHER");
        UserRole updatedResult=userRoleService.update(userRole);
        Assert.assertNotEquals(result,updatedResult);
    }

    @Test
    public void e_delete() {
        UserRole result=userRoleService.create(userRole);
        userRoleService.delete(result);
        Assert.assertNull(userRoleService.read(result));
    }

    @Test
    public void d_getAll() {
        UserRole result=userRoleService.create(userRole);
        Assert.assertNotNull(userRoleService.getAll());
    }
}