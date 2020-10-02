
public class TokenManager {
	private int fleetPool;
	private int tacticsPool;
	private int strategyPool;
	
	TokenManager(){
		fleetPool = 3;
		tacticsPool = 3;
		strategyPool = 2;
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
}
