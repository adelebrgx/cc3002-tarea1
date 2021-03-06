package cc3002.tarea1.Fire;

import cc3002.tarea1.*;

import java.util.ArrayList;


/**
 * Class which represents phase2 fire pokemons. When it's being inspected, it notifies the Pokemon's phase2.
 * @author Adèle Bourgeix
 */


public class Phase2FirePokemon extends AFirePokemon implements IPhase2Pokemon {


    /**
     * Constructor for Phase2 Fire Pokemons
     * @param someName a name
     * @param somePokedexID an ID
     * @param someHP an HP
     * @param someAbilities abilities
     */
    public Phase2FirePokemon(String someName, int somePokedexID, int someHP, ArrayList<IAbility> someAbilities) {
        super(someName, somePokedexID, someHP, someAbilities);
    }

    @Override
    public void beingPlayedBy(Player player){
        boolean result= this.checkEvolution(player);
        if (result==false){
            System.out.println("there is no phase1 to be replaced by the following Pokemon");
        }
    }

    @Override
    public void isBeingInspected(ITrainerCard card){
        card.inspectPhase2Pokemon(this);
    }
}
