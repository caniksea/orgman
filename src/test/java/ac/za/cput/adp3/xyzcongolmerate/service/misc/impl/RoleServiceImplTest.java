package ac.za.cput.adp3.xyzcongolmerate.service.misc.impl;

import ac.za.cput.adp3.xyzcongolmerate.domain.misc.Role;
import ac.za.cput.adp3.xyzcongolmerate.factory.misc.RoleFactory;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RoleServiceImplTest {
    RoleServiceImpl roleService=RoleServiceImpl.getRoleService();
    Role role= RoleFactory.buildRole("admin");

    @Test
    public void a_create() {
        Assert.assertNotNull(roleService.create(role));
    }

    @Test
    public void b_read() {
        Role result=roleService.create(role);
        Assert.assertNotNull(roleService.read(result.getRoleId()));
    }

    @Test
    public void c_update() {
        Role resultU=roleService.create(role);
        Role result2=new Role.Builder().roleId(resultU.getRoleId()).roleName("CEO").build();
        Assert.assertNotEquals(result2,resultU);

    }

    @Test
    public void e_delete() {
        Role resultD=roleService.create(role);
        roleService.delete(resultD.getRoleId());
        Assert.assertNull(roleService.read(resultD.getRoleId()));
    }

    @Test
    public void d_getAll() {
        Role resultA=roleService.create(role);
        Assert.assertNotNull(roleService.getAll());
    }
}