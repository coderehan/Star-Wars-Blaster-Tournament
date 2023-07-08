<h2> Flipkart Machine Coding Round</h2>

<b>Problem Statement:</b>
A long time ago, in a galaxy far, far away…
All the mighty heroes take a break from the long war and are enjoying an off-season. Jabba the Hutt, one of the galaxy's most powerful gangsters, had in the meantime organized a Blasters duel for the galaxy's greatest.

The rules of the tournament were simple:
Each of the players has a match with each other in a round-robin fashion.
The players need to shoot on a target with their blasters and are awarded a score out of 100 based on that.
At the end of the match, the scores of both the players are compared to identify the winner
The player with a higher score (winner) is awarded 3 points
The player with a lower score (loser) is awarded 0 points
In case of a draw/tie (scores level), both the players are awarded 1 point each.

The tournament was a huge hit and Darth Vader emerged as the ultimate winner. He will be awarded the trophy on the Star Wars Day (4th of May), but there are a lot of rumors going around that Vader has used Dark Forces on Jabba the Hutt and has declared himself a winner.

Now,  The Republic has chosen you to curate all the results of the tournament into an app that can be used by all and put an end to the dark forces rumor.

The app will consist of the following screens:

Points Table
This screen will show the points table calculated by the results of all the matches played.
The points table will be sorted in descending order by points scored by a player
In case of a tie (same points scored by multiple players), sort the players in descending order of the total score of all the matches played by the player

Matches Screen
User can click on a player from the Points Screen and land on a detail screen, where the details of all the matches played by the player will be present
This screen should show the most recent match played at the top and the oldest match at the bottom. 
This screen shows the actual score for both the players for the matches where the selected player was participating (the screenshot attached shows all the matches played by Princess Leia)
Use proper colors to identify whether the match was won/lost/drawn by the player. Colors to be used:
Win - Green
Loss - Red
Draw - White

All the data needed to create the app can be downloaded from the links below. (Please note that you can download the JSON file and bundle with the app, no need to write a network layer for same)

Player List - bit.ly/StarWarsPlayers
Match List - bit.ly/StarWarsMatches

<b>About App:</b>

This app is built in <b>Kotlin</b> with <b>MVVM</b> architecture design pattern along with Coroutines & Dependency Injection.

<b>Libraries used:</b>
1. ViewModel
2. LiveData
3. DaggerHilt
4. Retrofit
5. GSON
6. Coroutines
7. Data Binding
8. Google Material Design
9. Loading Animation

<b>Extra Features:</b>
1. Splash Screen Added
2. Internet Connectivity Handling Added
   
<b>UI Screenshots:</b>
