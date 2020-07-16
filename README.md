# Rock-Paper-Scissors-in-2-Langs
The classic game of Rock, Paper, Scissors in Java and Python.

Method used to compare RPS values:
-
- Rock, Paper, Scissors assigned values of [ 0, 1, -1 ] respectively.
- If the player choice * computer choice is < 0 , the user with lower numbers wins
> EX: Paper[1] vs Scissors[-1] -> 1 * -1 = -1 -> Scissors wins
- Likewise, if the player choice * computer choice is >= 0, the user with the higher number wins
> EX: Scissors[-1] vs Rock[0] -> -1 * 0 = 0 -> Rock wins

> EX2: Rock[0] vs Paper[1] -> 0 * 1 = 0 -> Paper wins

Other notes:
-
- Classes used to avoid making seperate player and computer variables
> Instead of int playerchoice, int computerchoice; -> player.choice, comp.choice;

- Makes things easier to manage.
