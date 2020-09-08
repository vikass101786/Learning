package Array;

public class SquareRootDecomposition {
		
	static int blocks []= null;
	
	static void createBlock(int [] blocks , int [] arr , int rn) {
		int block_id = -1;
		for(int i = 0 ; i < arr.length ; i++) {
			if( i % 3 == 0) {
				block_id++;
			}
			blocks[block_id] += arr[i];
		}
	}
	
	
	static void printArray(int [] arr) {
		System.out.print("{");
		for(int i = 0 ; i < arr.length ; i++) {
			System.out.print(arr[i]);
			if(i != arr.length-1) {
				System.out.print(",");
			}
		}
		System.out.print("}");
	}
	
	static void updateQuery(int [] blocks , int [] arr , int rn , int index , int value) {
		int block_id = index / rn ;
		blocks[block_id] += (value - arr[index]);
		arr[index] = value;
	}
	
	public static void main(String[] args) {
		int arr [] = {1,3,5,2,7,6,3,1,4,8};
		int lenOfArr = arr.length -1;
		Double rnDouble = Math.sqrt(lenOfArr);
		int rn = rnDouble.intValue();
		blocks = new int [rn+1];
		createBlock(blocks, arr, rn);
		printArray(blocks);
		int startRange = 2 , endRange = 8;
		System.out.println(query(blocks , arr ,rn ,startRange ,endRange)); 
		int index = 2, value = 15;
		updateQuery(blocks ,arr ,rn , index ,value);
		System.out.println(query(blocks , arr ,rn ,startRange ,endRange));
		System.out.println(Math.floor(Math.log(3)));
	}


	private static int query(int[] blocks, int[] arr, int rn, int startRange, int endRange) {
		// TODO Auto-generated method stub
		
		// left Array
		int i = startRange;
		int sum = 0;
		while(startRange > 0 &&  (i % rn) != 0) {
			sum += arr[i];
			i++;
		}
		
		// middle Array (Block Array)
		
		for (int k = (i % rn)+1 ; k < (endRange % rn)+1; k++) {
			sum += blocks[k];
			i += rn;
		}
		
		// Right Array
		
		for (int j = i ; j < endRange ; j++) {
			sum += arr[j];
		}
		
		return sum;
	}
}
