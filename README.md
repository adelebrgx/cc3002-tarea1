# cc3002-tarea1/tarea2
Homework 1 and 2: CC3002 Metodologias y Diseño de programación

## Project's goal
This project was implemented as part of a homework of the course CC3002.
It implements the Pokemon Trading Card Game (TCG), "a collectible card game, based on Nintendo's Pokémon franchise of video games and anime, first published in October 1996 by Media Factory". The ultimate goal of the project is to obtain a programm which portrays the game, its logic and rules. 

## Entities
Main entities of the game are represented in the project by different classes. 

A Card is represented by an interface ICard which an abstract class ACard extends. 

As a Card may be an Energy Card or a Pokemon Card, both are implemented by a an Interface IEnergy and IPokemon from which derive both abstract classes (AEnergy and APokemon.

On the one hand, he logic of evolutions was implemented in the second iteration: a phase 1  Pokemon can be played if a basic pokemon is on the battlefield and a phase 2 Pokemon can be played if a phase 1 pokemon is on the battlefield. This is why subclasses basic plant pokemon, phase 1 plant pokemon, phase2 plant pokemon, basic water pokemon, phase 1 water pokemon, phase 2 water Pokemon.... were implemented (PlantEnergy, PlantPokemon, FireEnergy, FirePokemon...). Each class implements an interface of its phase (IBasicPokemon, IPhase1Pokemon or IPhase2Pokemon) and extends an abstract class of its type (APlantPokemon, AFirePokemon, AWaterPokemon, AElectricPokemon, APsychicPokemon or AFightingPokemon). 

On the other hand, energies are implemented according to its type in subclasses FireEnergy, WaterEnergy, PlantEnergy,PsychicEnergy, ElectricEnergy or FightingEnergy.

As part of the second homework, trainers cards were added to the game. They can be object, support or state card. Each subtype support, state and object are implemented by an interface from which derives an abstract class. Each subtype's interface extends another interface ITrainerCard from which derives an abstract class ATrainerCard. 

3 examples of Trainer's cards were implemented: 
* Object card SuperScoop Up which extends the abstract class AObjectCard
* State card Training Center which extends the abstract class AStateCard 
* Support card Professor Cozmos Discrovery which extends the abstract class ASupport Card

Pokemon's abilities are also implemented in the final product by the Interface IAbility from which derives an abstract class AAbility. As Attacks are particular abilities, an interface IAttack extends the IAbility interface and the abstract class Attack extends AAbility. 
One example of ability and one example of attack were implemented: 
* Ability Energy Burn which extends the abstract class Ability
* Attack Electric Shock which extends the abstract class AAttack

2 classes: BasicAttack and BasicAbility were implemented to be able to show the differences between a simple attack/ability and the ones implemented.

The Pokemon's trainer or player is represented by a class named Player, which sets all the basic functionnalities of a player: like drawing a card to his/her hand, putting a Pokemon to his Pokemon Bank, selecting a Pokemon, playing a card, attack his/her opponent's selected Pokemon...

Finally a Controller was added in the last iteration of the project. It sets the structure of a turn for a player and gives turn to the player's opponent once the player's done playing. Thereby, different states were implemented to represent the state of the player during a turn and control his/her actions. These different states: IntitialState, FirstState and Second State inherits from the Player State class. 

### Card Entity
#### Attributes:
```String title ```

The Card interface ICard is implemented by an abstract class ACard. A card can only be played and this action will be described within the entities Pokemon, Energy, Object Cards, Trainer Cards, State Cards. 

### Pokemon Entity

#### Attributes:
```String title, String name, int pokedexID, int hp, HashMap<String, Integer> EnergiesAssociated, ArrayList<IAbility> abilitiesList, IObjectCard objectCardAssociated; ```

A Pokemon is implemented within the Abstract class APokemon which implements IPokemon. Basically a Pokemon is described with its name, its hp, its Pokedex ID, a list of abilities assigned to it and a list of energies is been given by its player. 

A Pokemon is also refered to by his phase (basic, phase1, phase2) and type (fire, plant, water, electric, psychic, fighting).
Amongst the functionnalites which describe a pokemon, performing attacks and receiving attacks are implemented within the class. A Pokemon can also be assigned energies or attacks or being played by a player on the battlefield. 

Each abstract class AFirePokemon, AWaterPokemon, APlantPokemon, AElectricPokemon, APsychicPokemon and AFighting Pokemon implements the functionnalities specific to the type of a Pokemon. For example, the methods receive_Attack shows the effects of an attack of type _ on a Pokemon's HP given he's either resistant, weak or none of both to another type.

When playing a pokemon card, if the Pokemon is Phase1 or Phase2, it is checked its subevolution is on the battlefield to be replaced. The energies of the subphase Pokemon are passed to the Pokemon which comes to replace it. 

Finally one object card can be assigned to the Pokemon by the player. If another object card is played by the player it comes to replace the one already assigned to the selected pokemon.

### Energy Entity

#### Attributes: 
```String title```

An energy is implemented within the Abstract class AEnergy which implements IEnergy. Basically an energy is described with its name and a type _  returned by each class Energy_ in a method. 

An energy can be played by the player and attributed to one of his Pokemons on the battlefield according to the index chosen by the trainer.

### Trainer Cards Entity
##### Attributes 
```String title, String Description ```

A Trainer Card is a type of card which has 3 subtypes. It has a name and a description. 

#### Object Cards 
##### Attributes 
```String title, String Description ```

An object Card is implemented within the abstract class AObjectCard implementing the interface IObjectCard.
An Object Card has a name and a description. An object card can be associated to a Pokemon or have an instant effect. Once an object card is played it comes to replace the player's selected pokemon object card associated. 

##### Super Scoop Up Card

Action: Throw a coin. If it's head, put one of your Pokémon in play and all the cards associated with it in your hand.


### Support Cards
##### Attributes 
```String title, String Description ```

A Support Card is implemented within the abstract class ASupportCard implementing the interface ISupportCard.
A Support Card has a name and a description. A Support Card has a name and a description. A support card performs its actions and is put away. Only one support card can be played during a turn. 

##### Professor Cozmos Discovery Card 

Action: Throw a coin, if it's head draw 3 cards from your deck, if it's tails draw 2.

### State Cards 
##### Attributes 
```String title, String Description ```
A State Card is implemented within the abstract class AStateCard implementing the interface IStateCard. A State Card changes the state of the game. Only one can be in the game. 

##### Training Center

###### Attributes 
```int x ```

Action: Each Pokemon of phase 1 or 2 receives +x HP. 
Implements a visitor pattern to visit the Player's Pokemons according to their phase. 

### Abilities entity
#### Attributes 
```private String name, String description, HashMap<String, Integer> cost```

An ability is a property of a Pokemon. it has a name, a description and a cost to be executed. Abilities are implemented in the IAbility interface from which derives an abstract class Ability. 

A Basic Ability was implemented to demonstrate the properties of a basic ability; 

##### Energy Burn 
###### Attributes 
```private String name, String description, HashMap<String, Integer> cost```

Action: All the energies of the Pokemon turn into energies of the Pokemon's type. 
Implements a visitor pattern to visit the player's pokemon according to its type. 

#### Attack entity 
##### Attributes
```private String name, String description, HashMap<String, Integer> cost, int baseDamage```

An attack is a special ability which has a base damage. They're implemented by the interface IAttack which extends the IAbility interface, from wich derives an abtract class AAttack. 

A Basic Attack was implemented to demonstrate the properties of a basic attack. 

##### Electric Shock
###### Attributes 
```private String name, String description, HashMap<String, Integer> cost, int baseDamage, int x```

Action: Throw a coin. If it's tails, the opponent's pokemon receives x of damage. 

### Player entity

#### Attributes : 
``` private String name, List<ICard> hand, List<IPokemon> pokemonBank, IPokemon selectedPokemon, List<ICard> lostCards, List<ICard> cardStack, List<ICard> primeCards, IPokemon selectedPokemon;, PlayerState state, boolean isPlaying, boolean hasEndedTurn, boolean EnergyPlayed, boolean AbilityUsed, boolean hasPlayedSupport, Controller controller ```
  
A player in implemented within the class Player. A player is described by his/her name, a list of cards he has in hand, a list of Pokemons he/she has in his/her bank, the Pokemon he/she has selected to fight on the battlefield, a deck of cards, 6 prime cards, a list of cards that were put aside for some reason and one Pokemon selected by the player to be the one receiveing the effects of a card (energies for example). 

When a player is playing, the controller also verifies he/she can be playing through isPlaying, that his/ger turn has or hasn't ended through hasEndedTurn, that he/she cannot play more than one Energy during a turn through Energy played, cannot play more than one support card during one turn and use more than one ability during a turn through AbilityUsed. 

All the functionnalities a player can perform are implemented in the class and will allow us to implement the game further on. 
Amongst all the actions the player can perform, he/she can draw a card from the deck, put a Pokemon in his bank, send a Pokemon to a battlefield,and play a Card : that's to say put a new Pokemon in his Pokemon bank or assign an energy to the Pokemon he/she sent to the battlefield. 
The player can also assign one ability to his/her selected Pokemon and choose which Pokemon's he wants to assign an energy too. 
As part of playing, the trainer also needs to notify he's done performing actions such as see his cards, his pokemon's or the other player's pokemons to be able to attack the opponent's selected Pokemon. 
He then ends his turn. 

### Controller Entity and player's states 

#### Controller 
##### Attributes 
```  Player first, Player second,Player isPlaying, IStateCard stateCard; ```

The controller implemented by the Controller class controls the state of the game. It has two players which it initiates at the beginning of the game, a isPlaying Player and a state card. 

It 'observes' the changes in the player's state and once the player's atribute hasEndedTurn is set to True and the player's back to his/her initial state, it switches turn to the other player and reinitialize the first player's atributes.

A Null Controller class, which implements the Null Object Pattern, was created to assign a Null Controller to a Player to perform tests more easily. 

The controller doesn't contain the logic of the game itself as the MVC model hadn't been studied in class yet. However, it is set in the model but the controller allows to delegate to entities the logic of a game. 
As such, the cards and abilities are implemented as visitors. 



#### Player's states 
##### Attributes 

The PlayerState implements the states in which can be a player. 

The player begins in Initial State in which he/she has to draw a card to get to First State. 

Once he/she is in state 1, he can see his cards, see the opponent's pokemons and his/her Pokemons. He can use an ability of his/ her selected pokemon and play cards (one energy and one object card). Once then, he/she needs to declare he's done performing actions. 

Once in state2 he/she can perform one attack or end his/her turn. He goes back to initial state and has ended his/her turn.

The controller assigned to him/her switches turn to his/her opponent.


## Tests

Each class method is tested in the method of a test file. Each method of the test file tests different scenarios and considers different border cases.  The coverage of the project's lines may vary a little as some functionnalities depend on hazard and not the same number of lines are tested each time. 

## Built with 

* **JDK Version 8** project built with Java
* **JUnit4** testing framework used to run the tests


## Getting started 

All the informations needed to run the program properly 

### Prerequisites

To be able to run the program on your computer, you'll need to have JDK Version 8 installed on your computer and in that sense, need to have downloaded Java SE 8uXXX. 

The program needs to be run on an IDE(Integrated Development Environment): Intellij IDEA CE is strongly recommended to use the project. The IDE can be dowloaded on JetBrains' shop website. To use all the functionnalities, the ultimate version needs to be downloaded.

### Running the tests

Open the project with Intellij. To run all the tests, do a right click on the tests folder and click on Run with coverage. 

## Versioning

The first version of the project deployed on April 27th, 2019 implements the entities of the project, their basic functionnalities and the interactions among them. 

The second version of the project was deployed on June 12th, 2019, it adds more functionnalities to the base product: trainers cards, the logic of evolution, concrete examples of entities, rules for the game (such as the structure of a turn). 

More versions will be deployed during the following months. 

## Author 
* **Adèle Bourgeix**
