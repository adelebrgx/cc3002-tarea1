package cc3002.tarea1.Fire;

import cc3002.tarea1.*;

import java.util.ArrayList;

/**
 * Class which represents basic fire pokemons. When it's being inspected, it notifies the Pokemon's basic.
 * @author Adèle Bourgeix
 */
public class BasicFirePokemon extends AFirePokemon implements IBasicPokemon {

    /**
     * Constructor for Basic Fire Pokemons
     * @param someName a name
     * @param somePokedexID an ID
     * @param someHP an HP
     * @param someAbilities abilities
     */
    public BasicFirePokemon(String someName, int somePokedexID, int someHP, ArrayList<IAbility> someAbilities) {
        super(someName, somePokedexID, someHP, someAbilities);
    }

    @Override
    public void isBeingInspected(ITrainerCard card){
        card.inspectBasicPokemon(this);
    }
}
