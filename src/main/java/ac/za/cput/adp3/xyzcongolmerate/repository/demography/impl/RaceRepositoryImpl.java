package ac.za.cput.adp3.xyzcongolmerate.repository.demography.impl;

import ac.za.cput.adp3.xyzcongolmerate.domain.demography.Gender;
import ac.za.cput.adp3.xyzcongolmerate.domain.demography.Race;
import ac.za.cput.adp3.xyzcongolmerate.repository.demography.RaceRepository;

import java.util.HashSet;
import java.util.Set;

public class RaceRepositoryImpl implements RaceRepository {

    private Set<Race> raceDB;
    private static RaceRepositoryImpl raceRepository = null;

    private RaceRepositoryImpl() {
        this.raceDB = new HashSet<>();
    }

    public static RaceRepositoryImpl getRaceRepository() {
        if (raceRepository == null) raceRepository = new RaceRepositoryImpl();
        return raceRepository;
    }

    //TODO: Implement body
    @Override
    public Race create(Race race) {
        Race myrace =findGender(race.getRaceId());
        if(myrace==null){raceDB.add(race); return race;}
        return null;
    }

    //TODO: Implement body
    @Override
    public Race read(String raceId) {
       return findGender(raceId);
    }

    //TODO: Implement body
    @Override
    public Race update(Race race) {
        Race myrace =findGender(race.getRaceId());
        if(myrace!=null){
            raceDB.remove(race);
            create(race);
            return race;
        }
        return null;
    }

    //TODO: Implement body
    @Override
    public void delete(String raceId) {
        Race myrace =findGender(raceId);
        if(myrace!=null){
            raceDB.remove(myrace);
        }
    }

    //TODO: Implement body
    @Override
    public Set<Race> getAll() {
        return raceDB;
    }
    public Race findGender(String id){
        return raceDB.stream()
                .filter(gen -> gen.getRaceId().equals(id))
                .findAny()
                .orElse(null);
    }
}
