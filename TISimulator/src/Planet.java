public class Planet {
	private String name;
	private int resources;
	private int influence;
	private Faction faction; //is this necessary?
	private Player controller; //is this necessary?
	private String trait;
	private String text;
	private int spaceDockCount;
	private int infantryCount; 
	private int pdsCount;
	
	Planet(String n, int res, int inf, Player cont, String tr, Faction fact, String txt){
		name = n;
		resources = res;
		influence = inf;
		faction = fact;
		trait = tr;
		text = txt;
	}
	
	public String getName() {
		return name;
	}
	public int getResources() {
		return resources;
	}
	
	public int getInfluence() {
		return influence;
	}
	
	public Player getController() {
		return controller;
	}
	
	public String getTrait() {
		return trait;
	}
	
	public Faction getFaction(){
		return faction;
	}
	
	public String getText() {
		return text;
	}
	
	public void setResources(int res) {
		resources = res;
	}
	public void setInfluence(int inf) {
		influence = inf;
	}
	
	public void setController(Player cont) {
		controller = cont;
	}

	public int getSpaceDockCount() {
		return spaceDockCount;
	}

	public void setSpaceDockCount(int spaceDockCount) {
		if (spaceDockCount>2) {
			this.spaceDockCount = 2;
		}
		else this.spaceDockCount = spaceDockCount;
	}

	public int getInfantryCount() {
		return infantryCount;
	}

	public void setInfantryCount(int infantryCount) {
		this.infantryCount = infantryCount;
	}

	public int getPdsCount() {
		return pdsCount;
	}

	public void setPdsCount(int pdsCount) {
		if (pdsCount>2) {
			this.pdsCount = 2;
		}
		else this.pdsCount = pdsCount;
	}
}
