package cc3002.tarea1;

import cc3002.tarea1.Attack;

/**
 * Class which represents the basic attacks of tarea1. Purpose is to show the way attacks work and make tests.
 * @author Adèle Bourgeix
 */
public class BasicAttack extends Attack {

    /**
     * Constructor for the attacks
     * @param aName name for the attack
     * @param baseDamage base damage for the attack
     * @param aDescription description for the attack
     */
    public BasicAttack(String aName, int baseDamage,String aDescription){super(aName, baseDamage, aDescription);}


}
