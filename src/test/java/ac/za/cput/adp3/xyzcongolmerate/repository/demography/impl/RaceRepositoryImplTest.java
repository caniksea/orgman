package ac.za.cput.adp3.xyzcongolmerate.repository.demography.impl;

import ac.za.cput.adp3.xyzcongolmerate.domain.demography.Race;
import ac.za.cput.adp3.xyzcongolmerate.factory.demography.RaceFactory;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RaceRepositoryImplTest {
    Race race= RaceFactory.buildRace("Black");
    RaceRepositoryImpl raceRepository=RaceRepositoryImpl.getRaceRepository();
    @Test
    public void a_create() {
        Race result=raceRepository.create(race);
       // Assert.assertNotNull(raceRepository.create(result));
        Assert.assertEquals(result.getRaceDescription(),"Black");
    }

    @Test
    public void b_read() {
        Race result=raceRepository.create(race);
        Race result2=raceRepository.read(result.getRaceId());
        Assert.assertEquals(result,result2);
    }
    @Test
    public void c_update() {
        Race race= RaceFactory.buildRace("Black");
        Race result=raceRepository.create(race);
        Race result2=new Race.Builder().raceId(race.getRaceId()).raceDescription("white").build();

        Assert.assertNotEquals(result,result2);


    }

    @Test
    public void e_delete() {
        Race race= RaceFactory.buildRace("Black");
        raceRepository.delete(race.getRaceId());
        Assert.assertNull(raceRepository.read(race.getRaceId()));
    }

    @Test
    public void d_getAll() {
        for(int i=0;i<3;i++){
        Race race= RaceFactory.buildRace("Black");}
        for(int i=0;i<raceRepository.getAll().size();i++){
        Assert.assertNotNull(raceRepository.getAll());
        }

    }
}