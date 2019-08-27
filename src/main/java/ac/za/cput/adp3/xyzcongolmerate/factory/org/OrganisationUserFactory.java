package ac.za.cput.adp3.xyzcongolmerate.factory.org;

import ac.za.cput.adp3.xyzcongolmerate.domain.org.OrganisationUser;

public class OrganisationUserFactory {

    //TODO: Implement body
    public static OrganisationUser buildOrganisationUser(String orgCode, String userEmail) {
        return new OrganisationUser(orgCode,userEmail);
    }
}
