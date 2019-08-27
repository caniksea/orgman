package ac.za.cput.adp3.xyzcongolmerate.factory.demography;

import ac.za.cput.adp3.xyzcongolmerate.domain.demography.Gender;
import ac.za.cput.adp3.xyzcongolmerate.util.IdGenerator;

public class GenderFactory {

    //TODO: Implement body
    public static Gender buildGender(String genderDescription) {
        return new Gender.Builder().genderId(IdGenerator.getId()).genderDescription(genderDescription).build();
    }
}
