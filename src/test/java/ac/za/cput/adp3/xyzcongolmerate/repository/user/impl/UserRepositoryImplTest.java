package ac.za.cput.adp3.xyzcongolmerate.repository.user.impl;

import ac.za.cput.adp3.xyzcongolmerate.domain.user.User;
import ac.za.cput.adp3.xyzcongolmerate.factory.user.UserFactory;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserRepositoryImplTest {
UserRepositoryImpl userRepository=UserRepositoryImpl.getUserRepository();
    User user= UserFactory.buildUser("espoie@gmail.com","espoir","ditekemena");
    @Test
    public void a_create() {
        Assert.assertNotNull(userRepository.create(user));
    }

    @Test
    public void b_read() {
        User user1 =userRepository.create(user);
        Assert.assertNotNull(userRepository.read(user1.getUserEmail()));
    }

    @Test
    public void c_update() {
        User user1 = userRepository.create(user);
        User result=UserFactory.buildUser(user1.getUserEmail(),"respo","ditel");
        Assert.assertEquals(user1.getUserEmail(),result.getUserEmail());
    }

    @Test
    public void e_delete() {
        User user1 = userRepository.create(user);
        userRepository.delete(user1.getUserEmail());
        Assert.assertNull(userRepository.read(user1.getUserEmail()));
    }

    @Test
    public void d_getAll() {
        for(int i=0;i<3;i++){
            userRepository.create(user);}
        for(int i=0;i<3;i++){
            Assert.assertNotNull(userRepository.getAll());
        }
    }
}