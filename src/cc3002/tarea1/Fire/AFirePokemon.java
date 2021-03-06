package cc3002.tarea1.Fire;

import cc3002.tarea1.APokemon;
import cc3002.tarea1.Attack;
import cc3002.tarea1.IAbility;
import cc3002.tarea1.IPokemon;

import java.util.ArrayList;


/** Abstract class which extends the notion of Pokemon to a Pokemon of type fire
 * @author Adèle Bourgeix
 */
public abstract class AFirePokemon extends APokemon implements IFirePokemon{

    /**Constructor of a fire type pokemon
     * @param someName name given to the Pokemon
     * @param somePokedexID index of the Pokedex use to refer to it
     * @param someHP HP which shows if the pokemon can remain on the battlefield to fight
     * @param someAbilities attacks pokemon can perform
     */
    public AFirePokemon(String someName, int somePokedexID, int someHP, ArrayList<IAbility> someAbilities) {
        super(someName, somePokedexID, someHP, someAbilities);
    }

    @Override
    public void hurt(IPokemon pokemon, Attack anattack){
        pokemon.receiveFireAttack(anattack);
    }

    @Override
    public String type(){
        return "Fire";
    }

    @Override
    public void receiveWaterAttack(Attack anAttack){
        this.receiveWeaknessAttack(anAttack);
    }

    @Override
    public void receiveAbility(IAbility ability){
        ability.enableFirePokemon(this);
    }

}
