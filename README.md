# CS-611-Legend-I
The "Legends-Heros-and-Monsters" Project for CS611 in BU

# CS611-Legends


Files
-------------------------------------------------------------------------------------------------
<Armory.java> -- The Armory for heroes in the game
<Board.java> -- The abstract class for the board of the game
<Cell.java> -- The cell of the board
<Champion.java> -- The list of heroes in this game
<Creature.java> -- The abstract class for creatures in games
<Enemy.java> -- The list of Monsters in this game
<Fight.java> -- The combat between heroes and monsters
<Game.java> -- The main process of the game
<Hero.java> -- In charge of heroes of the game
<Main.java> -- The game entrance
<Market.java> -- In charge of the market and trade in the game
<Monster.java> -- In charge of the monsters in the game
<Potion.java> -- The potions for heroes in the game
<Product.java> -- The abstract class for products in the market
<Spell.java> -- The spells for heroes in the game
<Weaponry.java> -- The weapons for heroes in the game
<World.java> -- In charge of the world of this game


Notes:
-------------------------------------------------------------------------------------------------
1. All the required parts of the game have been implemented. In consideration of extendability,
it has abstract class "creature" for other characters in the game and "product" for other sale
items in the market.

2. The submission has a few differences with the demo on the game rules. For example, the hero
will choose to attack the first monster that is alive, and the monster will attack back to whoever
attacked it. Besides, the parameter settings may also have something different.

3. To make things clear, unicode is used in some place to change the output color in the terminal.


How to run:
-------------------------------------------------------------------------------------------------
1. Navigate to the directory after downloading the project
2. Run the following instructions on command line:
	javac *.java
	java Main.java
