package cc3002.tarea1;
import java.util.ArrayList;
import java.util.List;

import cc3002.tarea1.Electric.ElectricPokemon;
import cc3002.tarea1.Fighting.FightingPokemon;
import cc3002.tarea1.IPokemon;
import cc3002.tarea1.APokemon;
import cc3002.tarea1.Fire.FirePokemon;
import cc3002.tarea1.Plant.PlantPokemon;
import cc3002.tarea1.Psychic.PsychicPokemon;
import cc3002.tarea1.Water.WaterPokemon;

public class Entrenador {
    private String name;
    private List<ICard> hand;
    private List<IPokemon> pokemonBank;
    private IPokemon selectedPokemon;

    //Constructor del entrenador
    public Entrenador(String name){
        this.name=name;
        hand= new ArrayList<ICard>(6);
        pokemonBank=new ArrayList<IPokemon>(6);
        selectedPokemon= null;

    }

    public void addPokemontoBank(IPokemon pokemon){
        if(!hand.contains(pokemon)){
            System.out.println("The player does not have this pokemon in his or her hand");
        }
        else{
            if (this.pokemonBank.size()==0){
                selectedPokemon=pokemon;
                this.pokemonBank.add(pokemon);
            }
            else if (this.pokemonBank.size()<6){
                this.pokemonBank.add(pokemon);}
            else{
                System.out.println("Player already has 6 Pokemon in his Pokemon Bank");
            }
        }

    }

    public void selectPokemon(IPokemon aPokemon){
        if (this.pokemonBank.size()==0){
            addPokemontoBank(aPokemon);
        }
        else {
            int i= this.pokemonBank.indexOf(aPokemon);
            IPokemon temp= this.pokemonBank.get(0);
            this.pokemonBank.set(0,aPokemon);
            this.pokemonBank.set(i,temp);
            selectedPokemon=this.pokemonBank.get(0);


        }
    }

    public void drawCard(ICard card){
        if (this.hand.size()<6){
            this.hand.add(card);}
        else {
            System.out.println("Player already has 6 cards in his hand");
        }
    }
    public String getName(){
        return this.name;
    }
    public int getHandSize(){
        return this.hand.size();}



    public IPokemon getSelectedPokemon(){
        return this.selectedPokemon;
    }

    public List<IPokemon> getBank(){
        return this.pokemonBank;
    }

    public List<ICard> getHand(){
        return this.hand;
    }

    public void playCard(ICard aCard, Entrenador following){
        if(!hand.contains(aCard)){
            System.out.println("The player cannot play a card which is not in his hand");
        }
        aCard.beingPlayedBy(this, following);
    }

}
