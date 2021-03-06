package cc3002.tarea1.Electric;
import cc3002.tarea1.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ElectricPokemonTest {
    private TrainingCenter trainingCenter;
    private IPokemon pichu;
    private IPokemon pikachu;
    private IPokemon raichu;
    private Attack aquajet;
    private Attack thundershock;
    private Attack karatechop;
    private Attack flamethrower;
    private Attack tackle;
    private Attack shadowbowl;
    private Attack discharge;
    private Player Blue;
    private IEnergy electric;


    @Before
    public void setUp(){
        shadowbowl=new BasicAttack("Shadow Bowl",40,"Attack of pokemon type: psychic");
        tackle=new BasicAttack("Tackle",30,"Attack of pokemon type: plant");
        flamethrower=new BasicAttack("Flame Thrower",30,"Attack of pokemon type: fire");
        thundershock=new BasicAttack("Thundershock",35,"Attack of pokemon type: electric");
        discharge=new BasicAttack("Discharge",50,"Attack of pokemon type: electric");
        karatechop=new BasicAttack("Karate Chop",30,"Attack of pokemon type: fighting");
        aquajet=new BasicAttack("Aqua Jet",30,"Attack of pokemon type: water");
        pichu=new BasicElectricPokemon("Pichu", 24, 40, new ArrayList<>());
        pikachu=new Phase1ElectricPokemon("Pikachu",25,90,new ArrayList<>());
        raichu=new Phase2ElectricPokemon("Raichu", 26, 110, new ArrayList<>(Arrays.asList(discharge)));
        Blue=new Player("Blue");
        trainingCenter= new TrainingCenter("Training Center", "Each Pokemon Phase 1 or 2 receives +x HP", 20);
        electric= new ElectricEnergy();

    }

    @Test
    public void SimplePokemonTest(){

        assertEquals("Pikachu", pikachu.getName());
        assertEquals(25, pikachu.getPokedexID());
        assertEquals(90,pikachu.getHP());
        assertEquals("Electric", pikachu.type());
    }
    @Test
    public void selectAttackTest(){

        assertEquals("Discharge", raichu.getAbilitiesList().get(0).getName());
        raichu.setAbility(thundershock);
        pikachu.setAbility(thundershock);
        assertEquals("Thundershock", raichu.getAbilitiesList().get(1).getName());
        assertEquals("Thundershock", pikachu.getAbilitiesList().get(0).getName());
        assertEquals(2, raichu.getAbilitiesList().size());
        assertEquals(1, pikachu.getAbilitiesList().size());

    }

    @Test
    public void ReceiveWaterAttackPokemonTest(){
        assertEquals(90, pikachu.getHP());
        pikachu.receiveWaterAttack(aquajet);
        assertEquals(60, pikachu.getHP());
    }
    @Test
    public void ReceiveFireAttackPokemonTest(){
        assertEquals(90, pikachu.getHP());
        pikachu.receiveFireAttack(flamethrower);
        assertEquals(60, pikachu.getHP());
    }
    @Test
    public void ReceiveElectricAttackPokemonTest(){
        assertEquals(90, pikachu.getHP());
        pikachu.receiveElectricAttack(thundershock);
        assertEquals(55, pikachu.getHP());
    }
    @Test
    public void ReceiveFightingAttackPokemonTest(){
        assertEquals(90, pikachu.getHP());
        pikachu.receiveFightingAttack(karatechop);
        assertEquals(30, pikachu.getHP());
    }
    @Test
    public void ReceivePlantAttackPokemonTest(){
        assertEquals(90, pikachu.getHP());
        pikachu.receivePlantAttack(tackle);
        assertEquals(60, pikachu.getHP());
    }
    @Test
    public void ReceivePsychicAttackPokemonTest(){
        assertEquals(90, pikachu.getHP());
        pikachu.receivePsychicAttack(shadowbowl);
        assertEquals(50, pikachu.getHP());
    }


    @Test
    public void hurtAnotherPokemon(){
        raichu.hurt(pikachu, discharge);
        assertEquals(40, pikachu.getHP());
    }

    @Test
    public void firstEvolutionTestSucceded(){
        Blue.takeCard(pichu);
        Blue.takeCard(pikachu);
        pichu.receiveEnergy(electric);
        assertEquals(1, pichu.getQuantityofAnEnergy(electric));
        assertEquals(0, pikachu.getQuantityofAnEnergy(electric));
        pichu.beingPlayedBy(Blue);
        assertEquals(1, Blue.getBank().size());
        assertEquals(pichu, Blue.getSelectedPokemon());
        pikachu.beingPlayedBy(Blue);

        //energies are being transfered
        assertEquals(1, pikachu.getQuantityofAnEnergy(electric));
        assertEquals(0, pichu.getQuantityofAnEnergy(electric));
        assertEquals(1, Blue.getBank().size());
        assertEquals(pikachu, Blue.getSelectedPokemon());
        assertEquals(1, Blue.getLostCards().size());


    }


    @Test
    public void firstEvolutionTestFailed(){
        Blue.takeCard(pichu);
        Blue.takeCard(pikachu);
        pikachu.beingPlayedBy(Blue);
        assertEquals(0, Blue.getBank().size());
        assertEquals(0, Blue.getLostCards().size());



    }

    @Test
    public void secondEvolutionTestSucceeded(){
        Blue.takeCard(pichu);
        Blue.takeCard(pikachu);
        Blue.takeCard(raichu);
        pichu.beingPlayedBy(Blue);
        pichu.receiveEnergy(electric);
        assertEquals(1, Blue.getBank().size());
        assertEquals(pichu, Blue.getSelectedPokemon());
        pikachu.beingPlayedBy(Blue);
        assertEquals(1, Blue.getBank().size());
        assertEquals(pikachu, Blue.getSelectedPokemon());
        assertEquals(1, Blue.getLostCards().size());


        raichu.beingPlayedBy(Blue);
        assertEquals(1, Blue.getBank().size());
        assertEquals(raichu, Blue.getSelectedPokemon());
        assertEquals(2, Blue.getLostCards().size());
    }


    @Test
    public void secondEvolutionTestFailed(){
        Blue.takeCard(pichu);
        Blue.takeCard(pikachu);
        Blue.takeCard(raichu);
        pichu.beingPlayedBy(Blue);
        assertEquals(1, Blue.getBank().size());
        assertEquals(pichu, Blue.getSelectedPokemon());
        raichu.beingPlayedBy(Blue);
        assertEquals(1, Blue.getBank().size());
        assertEquals(pichu, Blue.getSelectedPokemon());
        assertEquals(0, Blue.getLostCards().size());
    }

    @Test
    public void InspectionTest(){
        pichu.isBeingInspected(trainingCenter);
        pikachu.isBeingInspected(trainingCenter);
        raichu.isBeingInspected(trainingCenter);
        assertEquals(40, pichu.getHP());
        // Training Center adds x HP to Pokemons of Phase1 and 2
        assertEquals(110,pikachu.getHP());
        assertEquals(130,raichu.getHP());
    }
}