package ac.za.cput.adp3.xyzcongolmerate.repository.misc.impl;

import ac.za.cput.adp3.xyzcongolmerate.domain.demography.Race;
import ac.za.cput.adp3.xyzcongolmerate.domain.misc.Role;
import ac.za.cput.adp3.xyzcongolmerate.repository.misc.RoleRepository;

import java.util.HashSet;
import java.util.Set;

public class RoleRepositoryImpl implements RoleRepository {

    private Set<Role> roleDB;
    private static RoleRepositoryImpl roleRepository = null;

    private RoleRepositoryImpl() {
        this.roleDB = new HashSet<>();
    }

    public static RoleRepositoryImpl getRoleRepository() {
        if (roleRepository == null) roleRepository = new RoleRepositoryImpl();
        return roleRepository;
    }

    //TODO: Implement body
    @Override
    public Role create(Role role) {
        Role role1 =findGender(role.getRoleId());
        if(role1==null){
            roleDB.add(role);
            return role;
        }
        return null;

    }

    //TODO: Implement body
    @Override
    public Role read(String roleId) {
        Role role1 =findGender(roleId);
        if(role1!=null){
            return role1;
        }
        return null;
    }

    //TODO: Implement body
    @Override
    public Role update(Role role) {
        Role role1 =findGender(role.getRoleId());
        if(role1!=null){
            roleDB.remove(role1);
            create(role);
            return role;
        }return null;
    }

    //TODO: Implement body
    @Override
    public void delete(String roleId) {
        Role role1 =findGender(roleId);
        if(role1!=null){
            roleDB.remove(role1);
        }
    }

    //TODO: Implement body
    @Override
    public Set<Role> getAll() {
        return roleDB;
    }
    public Role findGender(String id){
        return roleDB.stream()
                .filter(gen -> gen.getRoleId().equals(id))
                .findAny()
                .orElse(null);
    }
}
