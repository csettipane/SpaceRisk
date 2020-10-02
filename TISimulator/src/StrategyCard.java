

public enum StrategyCard {
	LEADERSHIP (1),
	DIPLOMACY (2),
	POLITICS (3),
	CONSTRUCTION (4),
	TRADE (5),
	WARFARE (6),
	TECHNOLOGY (7),
	IMPERIAL (8);
	
	private final int initiative;
	
	StrategyCard(int initiative){
		this.initiative = initiative;
	}

	public int getInitiative() {
		return initiative;
	}
}
