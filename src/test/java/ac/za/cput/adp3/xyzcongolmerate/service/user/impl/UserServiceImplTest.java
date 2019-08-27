package ac.za.cput.adp3.xyzcongolmerate.service.user.impl;

import ac.za.cput.adp3.xyzcongolmerate.domain.user.User;
import ac.za.cput.adp3.xyzcongolmerate.factory.user.UserFactory;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserServiceImplTest {
    User user= UserFactory.buildUser("espoie@gmail.com","espoir","ditekemena");
    UserServiceImpl userService= UserServiceImpl.getUserService();
    @Test
    public void a_create() {

        Assert.assertNotNull(userService.create(user));
    }

    @Test
    public void b_read() {
        User result=userService.create(user);
        Assert.assertNotNull(userService.read(result.getUserEmail()));
    }

    @Test
    public void c_update() {
        User result=userService.create(user);
        User urseObject=UserFactory.buildUser("espoie@gmail.com","KALAYI","vrigule");
        User UpdateResult=userService.update(urseObject);
        Assert.assertNotEquals(result,UpdateResult);
    }

    @Test
    public void e_delete() {
        User result=userService.create(user);
        userService.delete(result.getUserEmail());
        Assert.assertNotNull(userService.read(result.getUserEmail()));
    }

    @Test
    public void d_getAll() {
        User result=userService.create(user);
        Assert.assertNotNull(userService.getAll());
    }
}