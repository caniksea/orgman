package ac.za.cput.adp3.xyzcongolmerate.service.demography.impl;

import ac.za.cput.adp3.xyzcongolmerate.domain.demography.Race;
import ac.za.cput.adp3.xyzcongolmerate.factory.demography.RaceFactory;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RaceServiceImplTest {
    Race race = RaceFactory.buildRace("BLACK");
    RaceServiceImpl raceService=RaceServiceImpl.getRaceService();
    @Test
    public void a_create() {
        Assert.assertNotNull(raceService.create(race));
    }

    @Test
    public void b_read() {
        Race resultR=raceService.create(race);
        Assert.assertNotNull(resultR);
    }
    @Test
    public void c_update() {
        Race resultU=raceService.create(race);
        Race Resutl=new Race.Builder().raceDescription("RED").raceId(resultU.getRaceId()).build();
        Race UpRese=raceService.update(Resutl);
        Assert.assertNotEquals(resultU,UpRese);
    }

    @Test
    public void e_delete() {
        Race resultD=raceService.create(race);
        raceService.delete(resultD.getRaceId());
        Assert.assertNull(resultD);
    }

    @Test
    public void d_getAll() {
        Race resultD=raceService.create(race);
        Assert.assertNotNull(raceService.getAll());
    }
}