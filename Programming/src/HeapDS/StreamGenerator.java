package HeapDS;

public class StreamGenerator {
	
	public static void main(String[] args) {
		SteamMedian st = new SteamMedian();
		for(int i = 0 ; i < 20 ; i++) {
			int num = (int)(Math.random() * 20);
			SteamMedian.findMedian(num);
		}
		
		
	}

}
