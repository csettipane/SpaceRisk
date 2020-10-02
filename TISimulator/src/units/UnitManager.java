package units;
import java.util.HashMap;
import java.util.ArrayList;
public class UnitManager {
	private int flagshipCount;
	private int warsunCount;
	private int destroyerCount;
	private int dreadnoughtCount;
	private int cruiserCount;
	private int carrierCount;
	private int pdsCount;
	private int spaceDockCount;
	private ArrayList<Unit> UnitList; //hmmmm
	
	// map unit name to dictionary of stats (ex. "warsun" -> ["cost"->12, "combatVal" -> 3, ....])
	private HashMap<String, HashMap<String, Integer>> unitStats;
	
	UnitManager(HashMap<String, HashMap<String, Integer>> unitStats){
		this.unitStats = new HashMap<String, HashMap<String, Integer>>(unitStats);
	}

	public int getUnitStat(String unit, String stat) { // should
		return unitStats.get(unit).get(stat);
	}
	//add method or change this method for upgrading unit??? when do we ever just set stats without upgrading?
	public void setUnitStats(String unit, HashMap<String, HashMap<String, Integer>> newUnitStats) { 
		this.unitStats.putAll(newUnitStats);
	}
	
}
