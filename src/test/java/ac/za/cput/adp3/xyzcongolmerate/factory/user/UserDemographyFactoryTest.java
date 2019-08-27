package ac.za.cput.adp3.xyzcongolmerate.factory.user;

import ac.za.cput.adp3.xyzcongolmerate.domain.user.UserDemography;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class UserDemographyFactoryTest {

    @Test
    public void buildUserDemography() {
        Date bod= new Date();
        UserDemography userDemography=UserDemographyFactory.buildUserDemography("@emksd","CEO","MAle","Black",bod);
        Assert.assertNotNull(userDemography);
        System.out.println(userDemography.toString());
    }
}