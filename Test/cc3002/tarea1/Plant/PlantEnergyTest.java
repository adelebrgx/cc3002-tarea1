package cc3002.tarea1.Plant;


import cc3002.tarea1.Player;
import cc3002.tarea1.IEnergy;
import cc3002.tarea1.IPokemon;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class PlantEnergyTest {
    private IEnergy plant;
    private Player Blue;
    private IPokemon bulbasaur;

    @Before
    public void setUp() {
        plant= new PlantEnergy();
        Blue= new Player("Blue");
        bulbasaur=new BasicPlantPokemon("Bulbasaur",1,50,new ArrayList<>());

    }

    @Test
    public void SimplePokemonTest(){
        assertEquals("Plant", plant.type());

    }

}