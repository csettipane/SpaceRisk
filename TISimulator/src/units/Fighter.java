package units;

public class Fighter extends Unit{
	static int count = 0;
	static int max = 1000;
	static int cost = 1;
	static int[] combat = new int[] {1,9};
	static int move = 0;
	static int capacity = 0;
	//boolean canFly;
	boolean canSustain;
	
	Fighter(){
	}
}
