package ac.za.cput.adp3.xyzcongolmerate.factory.org;

import ac.za.cput.adp3.xyzcongolmerate.domain.org.Organisation;
import ac.za.cput.adp3.xyzcongolmerate.util.IdGenerator;

public class OrganisationFactory {


    public static Organisation buildOrganisation(String organisationName) {
       return new Organisation.Builder().orgCode(IdGenerator.getId()).orgName(organisationName).build();
    }
}
