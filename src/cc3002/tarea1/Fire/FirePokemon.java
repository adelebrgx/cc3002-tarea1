package cc3002.tarea1.Fire;

import cc3002.tarea1.APokemon;
import cc3002.tarea1.Attack;

public class FirePokemon extends APokemon {
    public FirePokemon(String someName, int somePokedexID, int someHP) {
        super(someName, somePokedexID, someHP);
    }

    @Override
    public String type(){
        return "Fire";
    }

    @Override
    public void receiveFireAttack(Attack anAttack){
        this.receiveNormalAttack(anAttack);
    }
    @Override
    public void receiveWaterAttack(Attack anAttack){
        this.receiveWeaknessAttack(anAttack);
    }
    @Override
    public void receivePlantAttack(Attack anAttack){
        this.receiveNormalAttack(anAttack);
    }
    @Override
    public void receiveElectricAttack(Attack anAttack){
        this.receiveNormalAttack(anAttack);
    }
    @Override
    public void receiveFightingAttack(Attack anAttack){
        this.receiveNormalAttack(anAttack);
    }
    @Override
    public void receivePsychicAttack(Attack anAttack){
        this.receiveNormalAttack(anAttack);
    }
}
