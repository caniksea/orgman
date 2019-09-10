package ac.za.cput.adp3.xyzcongolmerate.util;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class HelperTest {

    @Test
    public void generateRandomGivenSuffix() {
        String random = Helper.generateRandomGivenSuffix("HT");
        System.out.println("Random: " + random);
        Assert.assertNotNull(random);
    }

    @Test
    public void getClassName() {
        String className = Helper.getClassName(HelperTest.class);
        System.out.println("Class Name: "+ className);
        Assert.assertEquals(className, "HelperTest");
    }

    @Test
    public void getSuffixFromClassName() {
        String suffix = Helper.getSuffixFromClassName(HelperTest.class);
        System.out.println("Suffix: " + suffix);
        Assert.assertEquals(suffix, "HT");
    }
}