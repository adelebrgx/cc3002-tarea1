package cc3002.tarea1.Fighting;
import cc3002.tarea1.Attack;
import cc3002.tarea1.Player;
import cc3002.tarea1.IPokemon;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class FightingPokemonTest {
    private IPokemon mankey;
    private IPokemon primeape;
    private Attack aquajet;
    private Attack thundershock;
    private Attack karatechop;
    private Attack flamethrower;
    private Attack tackle;
    private Attack shadowbowl;
    private Attack lowkick;
    private Player Blue;
    @Before
    public void setUp() throws Exception {
        shadowbowl=new Attack("Shadow Bowl",40,"Attack of pokemon type: psychic");
        tackle=new Attack("Tackle",30,"Attack of pokemon type: plant");
        flamethrower=new Attack("Flame Thrower",30,"Attack of pokemon type: fire");
        thundershock=new Attack("Thundershock",35,"Attack of pokemon type: electric");
        karatechop=new Attack("Karate Chop",30,"Attack of pokemon type: fighting");
        aquajet=new Attack("Aqua Jet",30,"Attack of pokemon type: water");
        lowkick=new Attack("Low Kick",40,"Attack of pokemon type: fighting");
        mankey=new FightingPokemon("Mankey",56,60,new ArrayList<>());
        primeape=new FightingPokemon("Primeape", 57, 100,new ArrayList<>(Arrays.asList(karatechop)));
        Blue=new Player("Blue");
    }

    @Test
    public void SimplePokemonTest(){

        assertEquals("Mankey", mankey.getName());
        assertEquals(56, mankey.getPokedexID());
        assertEquals(60,mankey.getHP());
        assertEquals("Fighting", mankey.type());
    }

    @Test
    public void selectAttackTest(){

        assertEquals("Karate Chop", primeape.getAttacksList().get(0).getName());
        primeape.setAttack(lowkick);
        mankey.setAttack(lowkick);
        assertEquals("Low Kick", primeape.getAttacksList().get(1).getName());
        assertEquals("Low Kick", mankey.getAttacksList().get(0).getName());
        assertEquals(2, primeape.getAttacksList().size());
        assertEquals(1, mankey.getAttacksList().size());

    }

    @Test
    public void ReceiveWaterAttackPokemonTest(){
        assertEquals(60, mankey.getHP());
        mankey.receiveWaterAttack(aquajet);
        assertEquals(30, mankey.getHP());
    }
    @Test
    public void ReceiveFireAttackPokemonTest(){
        assertEquals(60, mankey.getHP());
        mankey.receiveFireAttack(flamethrower);
        assertEquals(30, mankey.getHP());
    }
    @Test
    public void ReceiveElectricAttackPokemonTest(){
        assertEquals(60, mankey.getHP());
        mankey.receiveElectricAttack(thundershock);
        assertEquals(25, mankey.getHP());
    }
    @Test
    public void ReceiveFightingAttackPokemonTest(){
        assertEquals(60, mankey.getHP());
        mankey.receiveFightingAttack(karatechop);
        assertEquals(30, mankey.getHP());
    }
    @Test
    public void ReceivePlantAttackPokemonTest(){
        assertEquals(60, mankey.getHP());
        mankey.receivePlantAttack(tackle);
        assertEquals(0, mankey.getHP());
    }
    @Test
    public void ReceivePsychicAttackPokemonTest(){
        assertEquals(60, mankey.getHP());
        mankey.receivePsychicAttack(shadowbowl);
        assertEquals(0, mankey.getHP());
    }

    @Test
    public void PokemonPlayedTest(){
        Blue.drawCard(mankey);
        Blue.drawCard(mankey);
        mankey.beingPlayedBy(Blue);
        mankey.beingPlayedBy(Blue);
        assertEquals("Mankey", Blue.getSelectedPokemon().getName());
        assertEquals(2, Blue.getBank().size());

    }
}