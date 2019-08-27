package ac.za.cput.adp3.xyzcongolmerate.repository.org.impl;

import ac.za.cput.adp3.xyzcongolmerate.domain.misc.Role;
import ac.za.cput.adp3.xyzcongolmerate.domain.org.Organisation;
import ac.za.cput.adp3.xyzcongolmerate.repository.org.OrganisationRepository;

import java.util.HashSet;
import java.util.Set;

public class OrganisationRepositoryImpl implements OrganisationRepository {

    private Set<Organisation> organisationDB;
    private static OrganisationRepositoryImpl organisationRepository = null;

    private OrganisationRepositoryImpl() {
        this.organisationDB = new HashSet<>();
    }

    public static OrganisationRepositoryImpl getOrganisationRepository() {
        if (organisationRepository == null) organisationRepository = new OrganisationRepositoryImpl();
        return organisationRepository;
    }

    @Override
    public Organisation create(Organisation organisation) {
        Organisation org=findGender(organisation.getOrgCode());
        if(org==null){
            organisationDB.add(organisation);
            return organisation;
        }return null;

    }


    @Override
    public Organisation read(String orgCode) {
         return findGender(orgCode);
    }


    @Override
    public Organisation update(Organisation organisation) {
        Organisation org=findGender(organisation.getOrgCode());
        if(org!=null){
            organisationDB.remove(org);
            create(organisation);
            return organisation;
        }
        return null;
    }

    //TODO: Implement body
    @Override
    public void delete(String orgCode) {
        Organisation org=findGender(orgCode);
        if(org!=null){
            organisationDB.remove(org);
        }

    }

    //TODO: Implement body
    @Override
    public Set<Organisation> getAll() {
        return organisationDB;
    }

    public Organisation findGender(String id){
        return organisationDB.stream()
                .filter(gen -> gen.getOrgCode().equals(id))
                .findAny()
                .orElse(null);
    }
}
