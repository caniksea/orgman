package ac.za.cput.adp3.xyzcongolmerate.repository.demography.impl;

import ac.za.cput.adp3.xyzcongolmerate.domain.demography.Gender;
import ac.za.cput.adp3.xyzcongolmerate.repository.demography.GenderRepository;

import java.util.HashSet;
import java.util.Set;

public class GenderRepositoryImpl implements GenderRepository {

    private static GenderRepositoryImpl genderRepository = null;
    private Set<Gender> genderDB;

    private GenderRepositoryImpl() {
        this.genderDB = new HashSet<>();
    }

    public static GenderRepositoryImpl genderRepository() {
        if (genderRepository == null) genderRepository = new GenderRepositoryImpl();
        return genderRepository;
    }

    //TODO: Implement body
    @Override
    public Gender create(Gender gender) {
        Gender mygender=findGender(gender.getGenderId());
        if(mygender==null){genderDB.add(gender); return gender;}
        return null;

    }

    //TODO: Implement body
    @Override
    public Gender read(String genderId) {
        return findGender(genderId);
    }

    //TODO: Implement body
    @Override
    public Gender update(Gender gender) {
        Gender mygender=findGender(gender.getGenderId());
        if(mygender!=null){ genderDB.remove(mygender);
        create(gender); return gender;}
        return null;
    }

    //TODO: Implement body
    @Override
    public void delete(String genderId) {
        Gender mygender=findGender(genderId);
        if(mygender!=null){
        genderDB.remove(mygender);}
    }

    //TODO: Implement body
    @Override
    public Set<Gender> getAll() {
        return genderDB;
    }
    public Gender findGender(String id){
        return genderDB.stream()
                .filter(gen -> gen.getGenderId().equals(id))
                .findAny()
                .orElse(null);
    }
}
