package ac.za.cput.adp3.xyzcongolmerate.repository.misc.impl;

import ac.za.cput.adp3.xyzcongolmerate.domain.misc.Role;
import ac.za.cput.adp3.xyzcongolmerate.factory.misc.RoleFactory;
import ac.za.cput.adp3.xyzcongolmerate.util.IdGenerator;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RoleRepositoryImplTest {
private RoleRepositoryImpl roleRepository=RoleRepositoryImpl.getRoleRepository();
private Role role= RoleFactory.buildRole("CEO");
    @Test
    public void a_create() {
        Role result=roleRepository.create(role);
        Assert.assertNotNull(result);
    }

    @Test
    public void b_read() {
        Role roleResult=roleRepository.create(role);
        Assert.assertNotNull(roleRepository.read(roleResult.getRoleId()));

    }

    @Test
    public void c_update() {
        Role roleResult=roleRepository.create(role);
        Role role=new Role.Builder().roleId(roleResult.getRoleId()).roleName("Admin").build();
        Assert.assertNotEquals(roleResult,role);
    }

    @Test
    public void e_delete() {
        Role roleResult=roleRepository.create(role);
        roleRepository.delete(roleResult.getRoleId());
        Assert.assertNull(roleRepository.read(roleResult.getRoleId()));
    }

    @Test
    public void d_getAll() {
        for(int i=0;i<3;i++){
            roleRepository.create(role);
        }
        for(int i=0;i<3;i++){
            Assert.assertNotNull(roleRepository.getAll());
        }
    }
}