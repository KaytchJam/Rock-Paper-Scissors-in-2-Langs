#Rock Paper Scissors Game!
import random

class rps_set:
    moveset = ("rock", "paper", "scissors")
    rock = 0; paper = 1; scissors = -1
    move = (rock, paper, scissors)
    decision = 0
    wins = False
    selection = "N/A"
    user = "Who?"
    score = 0

text1 = "\nLet's play Rock, Paper, Scissors!"
text2 = "\nPick your choice!"
text3 = "\nThe Player picked {}, the Computer picked {}."
victory_txt = "\n- {} wins! -"
score_text = "\nPlayer score: {}\nComputer score: {}"
options = "\na) Rock \nb) Paper \nc) Scissors"

player = rps_set(); computer = rps_set() # Initializing objects
player.user = "Player"; computer.user = "Computer"

def cpu_selection(): # Randomize computer choice
    cpu_index = random.randint(0, 2)
    computer.decision = computer.move[cpu_index]
    computer.selection = computer.moveset[cpu_index]

def ans_converter(): # Convert user choice
    convertable = input("\nEnter: ")
    if convertable in ["a", "A", "1", "r", "R", "rock", "Rock"]: return 0
    elif convertable in ["b", "B", "2", "p", "P", "paper", "Paper"]: return 1
    elif convertable in ["c", "C", "3", "s", "S", "scissors", "Scissors"]: return 2
    else: print("\nRandomized choice: ON ");  return random.randint(0, 2)

def compare_move(p_move, cpu_move): # Compares moves picked
    m_product = p_move*cpu_move
    if m_product < 0:
        if p_move < cpu_move: player.wins = True
        elif cpu_move < p_move: computer.wins = True
    elif m_product >= 0:
        if p_move > cpu_move: player.wins = True
        elif cpu_move > p_move: computer.wins = True

while True:
    print(text1, text2, options)
    user_choice = ans_converter() # Convert input
    player.decision = player.move[user_choice]
    player.selection = player.moveset[player.decision]
    cpu_selection()
    print(text3.format(player.selection, computer.selection))
    compare_move(player.decision, computer.decision)

    if player.wins is True: 
        print(victory_txt.format(player.user))
        player.score += 1
        player.wins = False
    elif computer.wins is True:
        print(victory_txt.format(computer.user))
        computer.score += 1
        computer.wins = False
    else: print("\n- It's a tie! -")
    
    print(score_text.format(player.score, computer.score))
    try_again = input("\nWould you like to play again? (y/n): ")
    if try_again in ["y", "Y", "yes", "Yes"]: pass
    elif try_again in ["n", "N", "no", "No"]: break
    else: break