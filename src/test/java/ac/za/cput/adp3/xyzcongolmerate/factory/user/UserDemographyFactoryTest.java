package ac.za.cput.adp3.xyzcongolmerate.factory.user;

import ac.za.cput.adp3.xyzcongolmerate.domain.user.UserDemography;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class UserDemographyFactoryTest {

    @Test
    public void buildUserDemography() {
        String userEmail = "test@test.com";
        String userTitle = "Mr";
        String genderId = "1";
        String raceId = "1";
        Date dateOfBirth = new Date();
        UserDemography userDemography = UserDemographyFactory.buildUserDemography(userEmail, userTitle, genderId, raceId, dateOfBirth);
        System.out.println(userDemography);
        Assert.assertNotNull(userDemography);
    }
}