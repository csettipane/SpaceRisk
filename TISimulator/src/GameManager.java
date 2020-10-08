import java.io.*;
import java.util.Vector;

public class GameManager 
{
	public int gamePhase; 		// Keep track of game phase 
	public Vector<String> playerNames = new Vector<String>();
	private Player[] thePlayers; // Array of players in game
	private int numPlayers;     // Number of players in game, not sure if we will need this but seems good
	public int[][] victoryTrack;
	
	// GameManage object, sets up game, controls play/flow of the game
	GameManager()
	{
//		gamePhase = One of strategy, action status, and agenda; Maybe a pregame phase;
//     maybe roundCount
		
		setupGame();
	}
	
	// Method to determine number of players and their names from the user
	public void whosPlaying() throws IOException{
		// For now this will work as though a single terminal is being used
		// Make sure number of players does not exceed cap for the game
		BufferedReader inputStream = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Who's playing? Enter player names one at a time. Enter 'done' when finished.");
				
		while (true) {
			String s = inputStream.readLine();
			if (s.equals("done")) {
				String output = String.format("The current players are %s \nIs this correct? Y/n", this.playerNames);
				System.out.println(output);
				continue;
			}
			else if (s.equals("Y")) {
				break;
			}
			else if (s.equals("n")) {
				System.out.println("Please add the remaining players:");
				continue;
			}
			else {
				this.playerNames.add(s); // Add the input line to player names
			}
		}
			
	}
	
	private void setupGame()
	{
/*		Perform necessary setup tasks
 * 		1. Determine Speaker
 * 		2. Assign Factions
 * 		3. Each player gathers faction specific components
 * 		4. Each player chooses a color and gets 59 plastic units, 1 command sheet, 25 tech cards
 * 		5. Each player gets home system planet cards
 * 		6. Create game board according to num player
 * 		7. Place custodian token on Mecatol Rex
 * 		8. Shuffle decks: action, agenda, stage I obj, stage II obj, and secret obj
 * 		9. Create supply iles: trade goods, infantry, fighter tokens
 * 	   10. Place each strategy card face-up within reach of speaker
 * 	   11. Each player takes starting technology and starting units listed on faction sheet. 
 * 		   Place starting units in home system.
 * 	   	   i. Each player: 3 command tokens in tactic pool, 3 in fleet pool (ship side up), and 2 in strategy pool
 * 	   12. Prepare objectives:
 * 		   i. Each player: draws 1 secret obj. keeps it hidden
 * 	      ii. Place victory point track and each player put control token on 0
 * 	     iii. Speaker: Draws 5 stage I obj cards, place them face DOWN abovec victory point track.
 * 			  Draw 5 stage II obj cards, place them face DOWN below victory point track
 * 		  iv. Speaker: Reveals first 2 stage I objs
 */
	}
}
