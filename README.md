# cs441clojure
CLojure project 
Brian Hare

For your final project, you will carry out timing studies to demonstrate the effects of concurrent 
execution as a way of enhancing performance. 
THE PROBLEM:
Consider a simple game consisting of a series of n coins (n is even) of various denominations laid in a
row. (For our purposes, the denominations do not have to match any actual real-world coins, but all
have a value greater than 0.) Two players take turns, alternately removing a coin from either end of the
row and keeping the coin so removed. Play continues until all coins are removed; the object is to end
with a higher total value than the opponent.
Note that a greedy strategy will not work in the general case. Consider the following arrangement of a
game in progress:
1 5 10 5 25 5
The current player can choose either the 1 coin at the left or the 5 coin on the right. But choosing the 5
coin on the right will make it possible for the opponent to select the 25 on their next turn, and probably
win the game.
Some thought will demonstrate the following points:
•
This is a 0-sum game; there is a certain amount of value to be distributed, and the strategy 
involves maximizing one’s share of that value.
•
The opponent will be trying to maximize their score, and therefore minimize ours.
•
Consider a row of coins from Ci to Cj. 
◦
Our score will increase by the value of one of the coins on the end (Ci or Cj) plus whatever 
we can expect to get from what remains (Ci+1 to Cj or Ci to Cj-1) when it’s the opponent’s 
turn to move.
◦
The opponent can take the coin from whatever remains when we have made our selection.
◦
And the opponent will be playing to minimize our score.
•
Therefore the value at this position (call it Vi,j) is the smaller of the positions that result after 
my choice, plus the value of the coin I take, and I am trying to maximize this value.
•
Putting it all together, Vi,j = max( {Ci + min(Vi+1,j-1, Vi+2,j)}, {Cj + min(Vi, j-2, Vi+1,j-1) } )
•
The first term is the result of my picking Ci, the second term picking Cj.
•
A brief animation walking through this can be found at 
https://people.cs.clemson.edu/~bcdean/dp_practice/dp_10.swf
From the above, there is an obvious recursive solution. The subproblems overlap, so a dynamic-
programming strategy would be optimal IF our code could have side effects (such as storing partial 
results). But since we’re interested in exploring functional programming, we’ll tolerate a less efficient 
algorithm in the interest of keeping our code simpler. 
YOUR PROGRAM should ask the user for the name of an input file. The file will contain nothing but
integers; the first integer will be the number of coins, followed by the values of each coin, in the order
they will be arranged for the game. All values are separated by whitespace. Once you have read the 
values, do the computations necessary to find the expected score for each player assuming best play by 
both sides.  Your program should also time how long it takes to reach the correct answer, excluding I/O 
time. You are given data files containing 10, 100, 500, 1000, 5000 and 10000 integers. Start with the 
smallest data file and keep using the larger file until you reach a file that takes more than 5 minutes to 
complete (or the largest file). 
Then modify your program to be multithreaded. Run the same data file using 2, 4, 8, 16, and 32 
threads, recording the time for each. Prepare a short report discussing your results, including a graph of 
the running time as a function of the number of threads. (This can be done in a spreadsheet, in Matlab, 
or Pylab... I don’t care what, really, but no hand-drawn charts.) 
