package cc3002.tarea1;

import cc3002.tarea1.Electric.ElectricEnergy;
import cc3002.tarea1.Fighting.FightingEnergy;
import cc3002.tarea1.Fire.FireEnergy;
import cc3002.tarea1.Plant.PlantEnergy;
import cc3002.tarea1.Psychic.PsychicEnergy;
import cc3002.tarea1.Water.WaterEnergy;

import java.util.HashMap;
import java.util.List;

/**
 * Interface which represents the Pokemon behavior.
 * @author Adèle Bourgeix
 */
public interface IPokemon extends ICard{
    /**
     * Getter to a Pokemon's name
     * @return Pokemon's name
     */
     String getName();

    /**
     * Getter to a Pokemon's hp
     * @return integer which represents Pokemon's HP
     */
    int getHP();

    /**
     * Getter to a Pokemon's pokedex ID
     * @return int which is POkemon's ID
     */
    int getPokedexID();

    /**
     * Getter to the Pokemon's abilities
     * @return a list of abilities of the Pokemon
     */
    public List<IAbility> getAbilitiesList();


    /**
     * Getter to the Object Card which can be associated to the Pokemon
     * @return a card of type object
     */
    IObjectCard getObjectCardAssociated();

    /**
     * Allows associating an object card to the Pokemon
     * @param card which is going to be associated
     */
    void associateObjectCard(IObjectCard card);

    /**
     * Getter to a Pokemon's type: fire, water, plant, psychic, fighting, electric
     * @return a String which is Pokemon's name
     */
    String type();

    /**
     * Getter to the energies that've been associated to a pokemon
     * @return A Hashmap with Pokemon's energies and its quantities
     */
    HashMap<String, Integer> getEnergiesAssociated();

    /**Getter of the quantity of one specific energy that's been associated to a pokemon
     * @param energy the energy looked for
     * @return Quantity of one energy
     */
    int getQuantityofAnEnergy(IEnergy energy);

    /**Method which allows us to know if a pokemon was lost on the battlefield. Returns false if the pokemon's hp is egual or inferior to 0.
     * @return true if is alive, false otherwise
     */
    boolean isAlive();

    /**
     * Method to assign hp to a Pokemon
     * @param hp integer to be assigned
     */
    void setHP(int hp);

    /**
     * An ability/attack is being assigned to a Pokemon
     * @param ability which is being assigned
     */
    void setAbility(IAbility ability);


    /** A Pokemon, once asked by the player, we'll be able to perform an attack over another pokemon, more precisely the one selected by its player's opponent
     * @param pokemon pokemon which receives the attack
     * @param anAttack attack performed by the pokemon
     */
    void hurt(IPokemon pokemon, Attack anAttack);


    /** Method which shows the damages received by a pokemon after receiving a fire attack
     * @param anAttack attack of type fire received by the pokemon
     */
    void receiveFireAttack(Attack anAttack);

    /** Method which shows the damages received by a pokemon after receiving a water attack
     * @param anAttack attack of type water received by the pokemon
     */
    void receiveWaterAttack(Attack anAttack);

    /**Method which shows the damages received by a pokemon after receiving a plant attack
     * @param anAttack attack of type plant received by the pokemon
     */
    void receivePlantAttack(Attack anAttack);

    /** Method which shows the damages received by a pokemon after receiving an electric attack
     * @param anAttack attack of type electric received by the pokemon
     */
    void receiveElectricAttack(Attack anAttack);

    /** Method which shows the damages received by a pokemon after receiving a fighting attack
     * @param anAttack attack of type fighting received by the pokemon
     */
    void receiveFightingAttack(Attack anAttack);

    /** Method which shows the damages received by a pokemon after receiving a psychic attack
     * @param anAttack attack of type psychic received by the pokemon
     */
    void receivePsychicAttack(Attack anAttack);


    /**Method which affects a pokemon's hp after an attack given he's not resistant to his opponent's pokemon
     * @param attack attack the other player's pokemon performs on it
     */
    void receiveWeaknessAttack(Attack attack);

    /**Method which affects a pokemon's hp after an attack given he's resistant to his opponent's pokemon
     * @param attack attack the other player's pokemon performs on it
     */
    void receiveResistantAttack(Attack attack);

    /**Method which affects a pokemon's hp after an attack given he's nor resistant nor weak to his opponent's pokemon
     * @param attack attack the other player's pokemon performs on it
     */
    void receiveNormalAttack(Attack attack);


    /** What happens when the pokemon card is played
     * @param inAction Player who plays the pokemon card
     */
    void beingPlayedBy(Player inAction);

    /** Electric energy is being added to a Pokemon
     *
     * @param en Electric Energy which will receive the Pokemon
     */
    void addElectricEnergy(ElectricEnergy en);

    /** Fighting energy is being added to a Pokemon
     *
     * @param en Fighting Energy which will receive the Pokemon
     */
    void addFightingEnergy(FightingEnergy en);

    /** Fire energy is being added to a Pokemon
     *
     * @param en Fire Energy which will receive the Pokemon
     */
    void addFireEnergy(FireEnergy en);

    /** Psychic energy is being added to a Pokemon
     *
     * @param en PsychicEnergy which will receive the Pokemon
     */
    void addPsychicEnergy(PsychicEnergy en);

    /** Plant energy is being added to a Pokemon
     *
     * @param en Plant Energy which will receive the Pokemon
     */
    void addPlantEnergy(PlantEnergy en);

    /** Water energy is being added to a Pokemon
     *
     * @param en Water Energy which will receive the Pokemon
     */
    void addWaterEnergy(WaterEnergy en);

    /** Pokemon receives energy: method prevents code duplication
     *
     * @param en Energy being received
     */
    void receiveEnergy(IEnergy en);

    /**
     * Allows to check if subevolution already is on the field and if the pokemon can be played, avoids code duplication
     * @param player Player whose Pokemons we're gonna check
     * @return a boolean which is true if the player posesses the subevolution
     */
    boolean checkEvolution(Player player);

    /**
     * What happens to a Pokemon when a trainers Card is being played. Because this card (may it be object, state, support) can have an affect over the Pokemon)
     * @param card state card/visitor which will inspect the Pokemon
     */
    void isBeingInspected(ITrainerCard card);

    /**
     * When an attack is being performed. The Pokemon suffer a loss of HP.
     * @param attack which the Pokemon is receiving.
     */
    void isBeingAffectedBy(IAttack attack);

    /**
     * When one of the Pokemon's abilities is being activated by the player
     * @param ability which is being activated
     */
    void receiveAbility(IAbility ability);






}
