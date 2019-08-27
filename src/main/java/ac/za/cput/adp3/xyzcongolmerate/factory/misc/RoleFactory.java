package ac.za.cput.adp3.xyzcongolmerate.factory.misc;

import ac.za.cput.adp3.xyzcongolmerate.domain.misc.Role;
import ac.za.cput.adp3.xyzcongolmerate.util.IdGenerator;

public class RoleFactory {

    //TODO: Implement body
    public static Role buildRole(String roleName) {
        return new Role.Builder().roleId(IdGenerator.getId()).roleName(roleName).build();

    }
}
