package com.kodilla.stream.world;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class WorldTestSuite {
    @Test
    public void testGetPeopleQuantity(){
        //Given
        //Create Countries
        Country poland = new Country("Poland", 38000000);
        Country germany = new Country ("Germany", 83000000);
        Country france = new Country("France", 67000000);
        Country italy = new Country ("Italy", 60000000);
        Country unitedKingdom = new Country("United Kingdom", 65000000);

        Country usa = new Country ("United States of America", 326000000);
        Country canada = new Country("Canada",36000000);

        Country china = new Country ("China", 1379000000);
        Country india = new Country("India", 1324000000);

        Country algeria = new Country("Algeria", 34000000);
        Country nigeria = new Country("Nigeria", 146000000);
        Country egypt = new Country("Egypt", 82000000);

        Country brasil = new Country ("Brasil", 203000000);
        Country columbia = new Country("Columbia", 45000000);
        Country argentina = new Country("Argentina", 42000000);

        //Create continents
        Continent europe = new Continent("Europe");
        europe.addCountry(poland);
        europe.addCountry(germany);
        europe.addCountry(france);
        europe.addCountry(italy);
        europe.addCountry(unitedKingdom);

        Continent asia = new Continent("Asia");
        asia.addCountry(china);
        asia.addCountry(india);

        Continent northAmerica = new Continent("North America");
        northAmerica.addCountry(usa);
        northAmerica.addCountry(canada);

        Continent africa = new Continent("Africa");
        africa.addCountry(algeria);
        africa.addCountry(nigeria);
        africa.addCountry(egypt);

        Continent southAmerica = new Continent("South America");
        southAmerica.addCountry(brasil);
        southAmerica.addCountry(columbia);
        southAmerica.addCountry(argentina);

        World world = new World();
        world.addContinent(europe);
        world.addContinent(asia);
        world.addContinent(africa);
        world.addContinent(northAmerica);
        world.addContinent(southAmerica);

        //When
        World theWorld = new World();
        theWorld.addContinent(europe);
        theWorld.addContinent(asia);
        theWorld.addContinent(africa);
        theWorld.addContinent(northAmerica);
        theWorld.addContinent(southAmerica);

        //Then
        BigDecimal expectedPeopleQty = new BigDecimal("3930000000");
        Assert.assertEquals(expectedPeopleQty, theWorld.getPeopleQuantity());

    }
}
