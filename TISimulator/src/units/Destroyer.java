package units;

public class Destroyer extends Unit{
	static int count = 0;
	static int max = 8;
	static int cost = 1;
	static int[] combat = new int[] {1,9};
	static int[] antiFighter = new int[] {9,2};
	static int move = 1;
	static int capacity = 1;
	boolean canSustain;
	System system;
	
	Destroyer(System sys){
		count+=1;
		canSustain = false;
		system = sys;
	}
}
