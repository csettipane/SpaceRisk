import java.util.HashMap;
import units.UnitManager;
import units;
public class Player{
	private final int playerID;
	private final Faction faction;
	private int vpCount;
	
	private GoodsManager goodsManager;
	//
	private int commodities;
	private int maxCommodities;
	private int tradeGoods;
	//
	
	private boolean hasPassed;
	
	private TokenManager tokenManager;
	//
	private int fleetPool;
	private int tacticsPool;
	private int strategyPool;
	//
	
	private UnitManager unitManager;
	
	private PlanetManager planetManager;
	//
	private HashMap<String, Planet> readyPlanets;
	private HashMap<String, Planet> exhaustedPlanets;
	//
	
	private Strategy strategy;
	//HashMap<String, Tech> Techs; techs can come later
	//HashMap<String, Secret> secrets; secret cards can come later
	//CardManager cardManager; Action cards can come later
	
	//Okay, this is ugly, but tell me a faster/easier way to load in
	//17 different preset options for factions
	
	// How about using a json and loading in all the data in the constructor as a dict?
	//how exactly to load in and format the json though hmmm...
	Player(int id, HashMap<String, Object> dict){ 
		playerID = id;
		vpCount = 0;
		faction = fact; // Is fact meant to be a parameter in the Player constructor?
		tokenManager = new TokenManager();
		readyPlanets = new HashMap<String, Planet>();
		exhaustedPlanets = new HashMap<String, Planet>();
		commodities = 0;
		tradeGoods = 0;
		unitManager = new UnitManager();
	}
	
	// Seems unnecessary, can't this be accomplished with dereferencing e.g. Player.playerID
	public int getPlayerID() {
		return playerID;
	}
	
	//these belong in the planet manager
	public void addReadyPlanet(Planet planet) {
		readyPlanets.put(planet.getName(), planet);
		if(exhaustedPlanets.containsKey(planet.getName())) {
			exhaustedPlanets.remove(planet.getName());
		}
	}
	
	public void addExhaustedPlanet(Planet planet) {
		exhaustedPlanets.put(planet.getName(), planet);
		if(readyPlanets.containsKey(planet.getName())) {
			readyPlanets.remove(planet.getName());
		}
	}
	
	public void removeReadyPlanet(Planet planet) {
		readyPlanets.remove(planet.getName());
	}
	
	public void removeExhaustedPlanet(Planet planet) {
		exhaustedPlanets.remove(planet.getName());
	}
	
	public void setStrategy(Strategy strat) {
		strategy = strat;
	}
	
	public Strategy getStrategy() {
		return strategy;
	}
	
	public int getVpCount() {
		return vpCount;
	}

	public void setVpCount(int vpCount) {
		this.vpCount = vpCount;
	}

	public Faction getFaction() {
		return faction;
	}

	public int getCommodities() {
		return commodities;
	}

	public void setCommodities(int commodities) {
		if(commodities>this.maxCommodities) {
			this.commodities = this.maxCommodities;
		}
		else this.commodities = commodities;
	}

	public int getTradeGoods() {
		return tradeGoods;
	}

	public void setTradeGoods(int tradeGoods) {
		this.tradeGoods = tradeGoods;
	}

	public int getFleetPool() {
		return fleetPool;
	}

	public void setFleetPool(int fleetPool) {
		this.fleetPool = fleetPool;
	}

	public int getTacticsPool() {
		return tacticsPool;
	}

	public void setTacticsPool(int tacticsPool) {
		this.tacticsPool = tacticsPool;
	}

	public int getStrategyPool() {
		return strategyPool;
	}

	public void setStrategyPool(int strategyPool) {
		this.strategyPool = strategyPool;
	}

	public boolean getHasPassed() {
		return hasPassed;
	}
	
	public void setHasPassed(boolean passed) {
		this.hasPassed = passed;
	}

	public int getMaxCommodities() {
		return maxCommodities;
	}

	public void setMaxCommodities(int maxCommodities) {
		this.maxCommodities = maxCommodities;
	}
	
	//this belongs in the unit manager?
	public void produce(Tile tile, String[] units, String[] planets) { //input for production is kind of weird
		//should i initially constrain inputs or should i try+catch somewhere 
		//to ensure units don't go over planet values/don't produce beyond reinforcements etc
		int totalRes = 0;
		for(String planet: planets) {
			totalRes += readyPlanets.get(planet).getResources();
			addExhaustedPlanet(readyPlanets.get(planet));
		}
		for(String unit : units) {
			this.unitManager.add(unit, tile); //implement a way to actually make units
		}
	}
}
