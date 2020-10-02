import java.util.ArrayList;
public class Strategy {
	StrategyCard strategyCard;
	
	public Strategy(StrategyCard strategyCard) {
		this.strategyCard = strategyCard;
	}
	
    public void useAction(int playerPos, Player[] speakerOrder) {
    	int playerCount = speakerOrder.length;
    	Player turnPlayer = speakerOrder[playerPos];
    	boolean secondaryInput;
        switch (strategyCard) {
            case LEADERSHIP:
                int sum = 0;
                int numTokens = 0;
                //ASK FOR INPUT, THEN 
            	int[] input = new int[3];
                turnPlayer.setTacticsPool(turnPlayer.getTacticsPool() + input[0]);
                turnPlayer.setFleetPool(turnPlayer.getFleetPool() + input[1]);
                turnPlayer.setTacticsPool(turnPlayer.getTacticsPool() + input[2]);
                for(int i= 0; i<playerCount; ++i) {
                	//ask input
                	boolean isUsingPlanets = true;//REPLACE WITH INPUT
                	while(isUsingPlanets){
                		turnPlayer = speakerOrder[(i+playerPos)%playerCount];
                		//USE an interrupt here?
                		//prompt player to exhaust planets
                		Planet planetInput = null; //replace null with input planet here
                		sum += planetInput.getInfluence();
                		speakerOrder[(i+playerPos)%playerCount].addExhaustedPlanet(planetInput);
                	}
                	// I can probably optimize this
                	numTokens = sum/3;
                	for (int j=0; j<numTokens; ++j) {
                		secondaryInput = false; //REPLACE WITH INPUT
                		if (secondaryInput) {
                			speakerOrder[i].setTacticsPool(speakerOrder[i].getTacticsPool() + input[0]);
                			speakerOrder[i].setFleetPool(speakerOrder[i].getFleetPool() + input[1]);
                			speakerOrder[i].setTacticsPool(speakerOrder[i].getTacticsPool() + input[2]);
                		}
                	}
                	
                }
                break;
                    
            case DIPLOMACY:
            	//SHOW USER THEIR EXHAUSTED PLANETS
                //ASK FOR TILE
            	Tile tile = null; //tileInput;
            	//ASK FOR INPUT, VALIDATE, THEN
            	Planet[] planets = null; //planetsInput;
                turnPlayer.addReadyPlanet(planets[0]);
                turnPlayer.addReadyPlanet(planets[1]);
                for(int i= 0; i<playerCount; ++i) {
                	turnPlayer = speakerOrder[(i+playerPos)%playerCount];
                	if(i!=0) {
                		tile.setHasPlayerToken(speakerOrder[i].getPlayerID(), true);
                	}
                	//PROMPT FOR INPUT
                	secondaryInput = false;
                	if (turnPlayer.getStrategyPool()>1 && secondaryInput) {
                		turnPlayer.setStrategyPool(turnPlayer.getStrategyPool()-1);
                		planets = null; //planetsInput
                        turnPlayer.addReadyPlanet(planets[0]);
                        turnPlayer.addReadyPlanet(planets[1]);
                	}
                }
                break;
                         
            case POLITICS: 
            	
            	//IMPLEMENT ACTION CARDS LATER
            	// turnplayer.drawCard()
            	//INPUT  ID for new speaker
            	int newSpeaker = 0; //input;
            	leftRotate(speakerOrder, newSpeaker-speakerOrder[0].getPlayerID(), speakerOrder.length);
            	// agenda cards too
                for(int i = 0; i<playerCount; ++i) {
                	turnPlayer = speakerOrder[(i+playerPos)%playerCount];
                	//PROMPT FOR INPUT
                	secondaryInput = false;
                	if (turnPlayer.getStrategyPool()>1 && secondaryInput) {
                		turnPlayer.setStrategyPool(turnPlayer.getStrategyPool()-1);
                		//turnPlayer.drawCard X2;
                	}
                }
                break;
                
            case CONSTRUCTION:
            	Planet planetInput = null; //input
            	boolean isSpaceDock = false; //input
            	// Need to sanitize inputs i.e. ensure enough spacedocks/pds left in reinforcements
              	planetInput.setPdsCount(planetInput.getPdsCount()+1); //could cause a weird edge case with only one planet left and no space
                for(int i= 0; i<playerCount; ++i) {
                	turnPlayer = speakerOrder[(i+playerPos)%playerCount];
                	secondaryInput = false;
                	if (turnPlayer.getStrategyPool()>1 && secondaryInput) {
                		//PROMPT FOR INPUT
                    	isSpaceDock = false;  //input
                    	planetInput = null; //input
                    	if(isSpaceDock) {
                    	planetInput.setSpaceDockCount(planetInput.getSpaceDockCount()+1);
                    	}
                    	else planetInput.setPdsCount(planetInput.getPdsCount()+1);
                    	planetInput.setPdsCount(planetInput.getPdsCount()+1);
                    	secondaryInput = false;
                	}
                }
                break;
                        
            case TRADE:
            	turnPlayer.setCommodities(turnPlayer.getMaxCommodities());
            	turnPlayer.setTradeGoods(turnPlayer.getTradeGoods()+3);
            	boolean[] playersCanRefresh = new boolean[playerCount]; //input
            	int pos;
                for(int i= 0; i<playerCount; ++i) {
                	pos = (i+playerPos)%playerCount;
                	turnPlayer = speakerOrder[pos];
                	//PROMPT FOR INPUT
                	secondaryInput = false;
                	if ((turnPlayer.getStrategyPool()>1 | playersCanRefresh[pos] | turnPlayer.getFaction() ==  Faction.HACAN) && secondaryInput) {
                		turnPlayer.setCommodities(turnPlayer.getMaxCommodities());
                	}
                }
                break;
                
            case WARFARE:
            	Tile inputTile = null; //input here
            	inputTile.setHasPlayerToken(turnPlayer.getPlayerID(), false);
            	boolean isRedistributing = false;
            	if(isRedistributing) {
            		redistribute(turnPlayer);
            	}
            	else{
            		//pool input here
            		int poolInput = 0;
	            	if (poolInput==0) {
	            		turnPlayer.setTacticsPool(turnPlayer.getTacticsPool()+1);
	            	}
	            	else if(poolInput ==1) {
	            		turnPlayer.setFleetPool(turnPlayer.getFleetPool()+1);
	            	}
	            	else turnPlayer.setStrategyPool(turnPlayer.getStrategyPool()+1);
            	}
                for(int i= 0; i<playerCount; ++i) {
                	turnPlayer = speakerOrder[(i+playerPos)%playerCount];
                	//PROMPT FOR INPUT
                	secondaryInput = false;
                	if (turnPlayer.getStrategyPool()>1 && secondaryInput) {
                		turnPlayer.setStrategyPool(turnPlayer.getStrategyPool()-1);
                		Tile tileInput = null;
                		turnPlayer.produce(tileInput, false);
                		/*maybe something like:
                		 * idk
                		 * 
                		 * 		
                		 * 
                		 */
                	}
                }
                break;
                
            case TECHNOLOGY:
            	String techInput = null; //technology input
            	turnPlayer.addTechnology(techInput);
            	secondaryInput = false; // get input
            	if(secondaryInput) {
            		techInput = null;
            		turnPlayer.spendRes(4); //this makes more sense than what I do in leadership I think, but also adds more stuff to player :(
            		turnPlayer.addTechnology(techInput);
            	}
                for(int i= 0; i<playerCount; ++i) {
                	turnPlayer = speakerOrder[(i+playerPos)%playerCount];
                	//PROMPT FOR INPUT
                	secondaryInput = false; //getinput
                	if (turnPlayer.getStrategyPool()>1 && secondaryInput) {
                		turnPlayer.setStrategyPool(turnPlayer.getStrategyPool()-1);
                		turnPlayer.spendRes(6); //try catch?
                		techInput = null;//input
                		turnPlayer.addTechnology(techInput);
                	}
                }
                break;
                
            case IMPERIAL:
            	publicObjective publicObjectiveInput = null;// input, probably need an objective object with secret+public subclasses
            	turnPlayer.score(publicObjectiveInput);
            	if(turnPlayer.getReadyPlanets().containsKey("mecatol")){
            		turnPlayer.setVpCount(turnPlayer.getVpCount()+1);
            	}
            	else turnPlayer.drawSecret();
            	for(int i= 0; i<playerCount; ++i) { 
                	turnPlayer = speakerOrder[(i+playerPos)%playerCount];
                	//PROMPT FOR INPUT
                	secondaryInput = false;
                	if (turnPlayer.getStrategyPool()>1 && secondaryInput) {
                		turnPlayer.setStrategyPool(turnPlayer.getStrategyPool()+1);
                	}
                }
                break;
        }
    } 	
    
    private static void leftRotate(Player arr[], int d, int n) { 
        d = d % n; 
        int i, j, k;
        Player temp;
        int g_c_d = gcd(d, n); 
        for (i = 0; i < g_c_d; i++) { 
            temp = arr[i]; 
            j = i; 
            while (true) { 
                k = j + d; 
                if (k >= n) 
                    k = k - n; 
                if (k == i) 
                    break; 
                arr[j] = arr[k]; 
                j = k; 
            } 
            arr[j] = temp; 
        } 
    } 
 
    private static int gcd(int a, int b) 
    { 
        if (b == 0) 
            return a; 
        else
            return gcd(b, a % b); 
    } 
    
    private static void redistribute(Player player) {
    	int total = player.getFleetPool()+player.getStrategyPool()+player.getTacticsPool();
    	boolean inputIsValid = false;
    	int[] poolInput = null; //input here
    	int sum = 0;
    	while(!inputIsValid)
    		poolInput = null;//
    		sum = 0 ;
    		for (int i : poolInput)
    			sum += i;
    		if(sum==total) {
    			inputIsValid = true;
    		}
    	player.setFleetPool(poolInput[0]);
    	player.setStrategyPool(poolInput[1]);
    	player.setTacticsPool(poolInput[2]);
    }
    
}
