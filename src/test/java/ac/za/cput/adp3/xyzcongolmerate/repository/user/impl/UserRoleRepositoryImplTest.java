package ac.za.cput.adp3.xyzcongolmerate.repository.user.impl;

import ac.za.cput.adp3.xyzcongolmerate.domain.user.User;
import ac.za.cput.adp3.xyzcongolmerate.domain.user.UserRole;
import ac.za.cput.adp3.xyzcongolmerate.factory.user.UserFactory;
import ac.za.cput.adp3.xyzcongolmerate.factory.user.UserRoleFactory;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserRoleRepositoryImplTest {
    UserRoleRepositoryImpl userRepository=UserRoleRepositoryImpl.getUserRoleRepository();
    UserRole userRole= UserRoleFactory.buildUserRole("003","espoi@fjg","voleur");

    @Test
    public void a_create() {
        Assert.assertNotNull(userRepository.create(userRole));
    }

    @Test
    public void b_read() {
        UserRole result=userRepository.create(userRole);
        Assert.assertNotNull(userRepository.read(result));
    }

    @Test
    public void c_update() {
        UserRole result=userRepository.create(userRole);
        UserRole result2=new UserRole(result.getOrgCode(),"espoi@fjg","Seller");
        userRepository.update(result2);
        Assert.assertNotEquals(result,result2);
    }

    @Test
    public void e_delete() {
        UserRole result=userRepository.create(userRole);
        userRepository.delete(result);
        Assert.assertNull(userRepository.read(result));
    }

    @Test
    public void d_getAll() {
        for(int i=0;i<3;i++){
            userRepository.create(userRole);}
        for(int i=0;i<3;i++){
            Assert.assertNotNull(userRepository.getAll());
        }
    }
}