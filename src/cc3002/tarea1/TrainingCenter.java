package cc3002.tarea1;

import java.util.List;
/**
 * Class which implements Training Center State Card using a Visitor pattern to visit the player's Pokemons and the opponent's Pokemon according to their phase.
 * @author Adèle Bourgeix
 */
public class TrainingCenter extends AStateCard {

    private int x;

    /**
     * Constructor for the Training Center card
     * @param aName name for the card
     * @param aDescription description for the card
     * @param x hp given to Pokemons of phase 1 and 2
     */
    public TrainingCenter(String aName, String aDescription, int x){
        super(aName,aDescription);
        this.x=x;
    }

    public int getX(){
        return this.x;
    }

    @Override
    public void beingPlayedBy(Player player) {
        super.beingPlayedBy(player);
        List<IPokemon> playerlist= player.getBank();
        List<IPokemon> opponentlist;
        if(player.getController().getFirst().equals(player)){
            opponentlist=player.getController().getSecond().getBank();
        }
        else{
            opponentlist=player.getController().getFirst().getBank();
        }
        for (IPokemon pokemon: playerlist){
            pokemon.isBeingInspected(this);
        }
        for (IPokemon pokemon: opponentlist){
            pokemon.isBeingInspected(this);
        }

    }

    @Override
    public void inspectPhase1Pokemon(IPhase1Pokemon phase1){
        int hp= phase1.getHP()+x;
        phase1.setHP(hp);
    }

    @Override
    public void inspectPhase2Pokemon(IPhase2Pokemon phase2){
        int hp= phase2.getHP()+x;
        phase2.setHP(hp);
    }
}
