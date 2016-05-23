package hr.ds;

public class MaxHeap {

	public static int MAX = 50;
	public static int currentSize = 0;

	private static int[] arr;

	private static int leftChild(int i) {
		return 2 * i;
	}

	private static int rightChild(int i) {
		return 2 * i + 1;
	}

	private static int parent(int i) {
		return (int) Math.floor(i / 2);
	}

	public boolean isLeaf(int pos) {
		return (pos >= currentSize / 2) && (pos < currentSize);
	}

	public static void main(String[] args) {

		arr = new int[MAX];

	}

	public void inserttoHeap(int data) {
		arr[currentSize] = data;

		int currentPos = currentSize - 1;

		while (currentPos != 0 && arr[currentPos] > arr[parent(currentPos)]) {
			int temp = arr[currentPos];
			arr[currentPos] = arr[parent(currentPos)];
			arr[parent(currentPos)] = temp;
		}
		currentSize++;
	}
	
	public void deletefromHeap(int pos) {
		
		if(pos == currentSize-1) {
			arr[pos] = 0;
			currentSize--;
			return;
		}
		
		
	}


}
