package designpattern.adapter;

import org.junit.Test;

import static org.junit.Assert.*;

public class FrenchSedanTest {

    @Test
    public void testObtenirLeModele() {
        final FrenchCar car = new FrenchSedan(new Sedan());

        assertEquals("Sedan", car.obtenirLeModele());
    }
}