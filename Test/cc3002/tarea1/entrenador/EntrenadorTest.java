package cc3002.tarea1.entrenador;

import cc3002.tarea1.Entrenador;
import cc3002.tarea1.Fighting.FigthingEnergy;
import cc3002.tarea1.Fire.FireEnergy;
import cc3002.tarea1.Fire.FirePokemon;
import cc3002.tarea1.IEnergy;
import cc3002.tarea1.IPokemon;
import cc3002.tarea1.Plant.PlantEnergy;
import cc3002.tarea1.Psychic.PsychicPokemon;
import cc3002.tarea1.Water.WaterEnergy;
import cc3002.tarea1.Water.WaterPokemon;
import cc3002.tarea1.Plant.PlantPokemon;
import cc3002.tarea1.Fighting.FightingPokemon;
import cc3002.tarea1.Electric.ElectricPokemon;
import cc3002.tarea1.ICard;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EntrenadorTest {

    private Entrenador Red;
    private Entrenador Blue;
    private IPokemon charmander;
    private IPokemon squirtle;
    private IPokemon abra;
    private IPokemon bulbasaur;
    private IPokemon mankey;
    private IPokemon pikachu;
    private IEnergy plant;
    private IEnergy water;
    private IEnergy fire;
    private IEnergy fighting;


    @Before
    public void setUp() throws Exception {
    Red= new Entrenador("Red");
    Blue= new Entrenador("Blue");
    charmander=new FirePokemon("Charmander",4,50);
    squirtle= new WaterPokemon("Squirtle", 7, 50);
    abra= new PsychicPokemon("Abra", 7, 50);
    bulbasaur=new PlantPokemon("Bulbasaur",1,50);
    mankey=new FightingPokemon("Mankey",56,60);
    pikachu=new ElectricPokemon("Pikachu",25,70);
    plant= new PlantEnergy();
    fire=new FireEnergy();
    water=new WaterEnergy();
    fighting=new FigthingEnergy();





    }

    @Test
    public void SimpleEntrenadorTest(){
        String expectedNameRed="Red";
        String expectedNameBlue="Blue";
        assertEquals(expectedNameRed, Red.getName());
        assertEquals(expectedNameBlue, Blue.getName());

    }

    @Test
    public void addPokemontoBankTest(){
        Red.drawCard(charmander);
        Red.drawCard(squirtle);

        Red.addPokemontoBank(charmander);
        Red.addPokemontoBank(squirtle);


        assertEquals(0,Red.getBank().indexOf(charmander));
        assertEquals("Squirtle",Red.getBank().get(1).getName());
        assertEquals("Charmander",Red.getBank().get(0).getName());
        assertEquals("Charmander", Red.getSelectedPokemon().getName());

    }

    @Test
    public void selectPokemonTest(){
        Red.drawCard(charmander);
        Red.drawCard(squirtle);

        Red.selectPokemon(squirtle);


        assertEquals("Squirtle",Red.getBank().get(0).getName());
        assertEquals("Squirtle", Red.getSelectedPokemon().getName());

        Red.addPokemontoBank(charmander);
        Red.selectPokemon(charmander);

        assertEquals("Charmander",Red.getSelectedPokemon().getName());
        assertEquals("Squirtle",Red.getBank().get(1).getName() );

    }
    @Test
    public void playCardTest(){
        Red.drawCard(charmander);
        Red.drawCard(abra);
        Red.playCard(charmander, Blue);

        assertEquals("Charmander",Red.getSelectedPokemon().getName());

        Red.playCard(abra, Blue);
        assertEquals("Charmander",Red.getSelectedPokemon().getName());
        assertEquals("Charmander",Red.getBank().get(0).getName());
        assertEquals("Abra",Red.getBank().get(1).getName());

    }

    @Test
    public void playEnergyTest(){

        Red.drawCard(charmander);
        Red.drawCard(water);
        Red.drawCard(fire);
        Red.drawCard(plant);
        Red.playCard(charmander, Blue);
        Red.playCard(water,Blue);
        Red.playCard(fire,Blue);


        assertEquals(1, Red.getSelectedPokemon().getQuantityofAnEnergy(water));
        assertEquals(1, Red.getSelectedPokemon().getQuantityofAnEnergy(fire));
        assertEquals(0, Red.getSelectedPokemon().getQuantityofAnEnergy(plant));
    }


}