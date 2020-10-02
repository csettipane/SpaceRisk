import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class TISimulator {
	
    @SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// instantiate systems
    	// instantiate players w/ units + faction stuff
    	// finish strategy card methods
		// GUI
    	// action phase
    	// cards: action cards, agenda cards, promissory notes

		//instantiate players
		//constant player count for now
		int playerCount = 6; //= input
		
		boolean orderIsRandom = false; // input;
		Player[] speakerOrder = createPlayers(orderIsRandom, playerCount);
		
		// instantiate map
        	// the creuss problem, (probably need to make them a special case... maybe generate them on an outer tile adjacent only to their delta wormhole
        	// coordinates???
		// ask for map input? -> mapString is best
        String mapString = null; //mapInput;
		Map map = new Map(mapString);
		
		
		//initialize game variables
		Player[] initiativeOrder = new Player[playerCount];
		boolean gameIsOver = false;
		boolean phaseIsOver = false;
		boolean agendaIsUnlocked = false;
		int passCount = 0;
		//randomly determine speaker (WILL HAVE TO REWORK)
		//Random rand = new Random();
		//Player speaker = speakerOrder[rand.nextInt(playerCount+1)];
		Player turnPlayer;//speaker;
		StrategyCard strat;
		int playerAction;
		//loop through all phases
		while(!gameIsOver){

			//loop through turns in strategy phase
			//note that this only works for 5+ player games
			//rework for other player counts
			for (int i=0; i<playerCount; ++i){
				turnPlayer = speakerOrder[i];
				// need input
				strat = null; //input;
				// turnPlayer.setStrategy(INPUT)
				initiativeOrder[strat.getInitiative()] = turnPlayer;
			}
			
			//loop through turns in action phase
			passCount = 0;
			while(!phaseIsOver) {
				if(passCount == playerCount){
					phaseIsOver = true;
				}
				else {
					for(int i=0; i<playerCount; ++i) {
						turnPlayer = initiativeOrder[i];
						// no no no we shouldn't loop through players who have passed
						// true but the cost is quite minimal

						if(!initiativeOrder[i].hasPassed())
							playerAction = 0; //input
							switch(playerAction) {
							case 1:
								
							case 2:
							case 3:
							}
					}
				}
				//prompt player for input
			}
			
			phaseIsOver = false;
			//check if agenda phase unlocked, then loop
			if(agendaIsUnlocked) {
				while(!phaseIsOver) {
				}
			}
			
			//status phase 
			for (int i=0; i<playerCount; ++i) {
				speakerOrder[i].score(input); //get input to pick an objective to score
				speakerOrder[i].refresh(); // need to refresh all exhausted planets, 
			}

		}
			
		
	}
  
    private static Player[] createPlayers(boolean orderIsRandom, int playerCount) {
		for(int i; i<playerCount; i++) {
			//GET INPUT FOR FACTIONS
			String factInput = null; // input
			//parse  dict for faction deets or pass in hashmap
			Player player = new Player(i, factInput);
			
		}
    }
  

}
