package dsalgjava.ch02.lst0201;

public class ArrayApp {

	public static void main(String[] args) {
		long[] arr = new long[10];
		
		arr[0] = 77;
		arr[1] = 99;
		arr[2] = 44;
		arr[3] = 55;
		arr[4] = 22;
		arr[5] = 88;
		arr[6] = 11;
		arr[7] = 0;
		arr[8] = 66;
		arr[9] = 33;
		int nElems = 10;
		
		int j;
		for (j = 0; j < nElems; j++) {
			System.out.print(arr[j] + " ");
		}
		System.out.println();
		
		long searchKey = 66;
		for (j = 0; j < nElems; j++) {
			if (arr[j] == searchKey) {
				break;
			}
		}
		if (j == nElems) {
			System.out.println("Can't find " + searchKey);
		} else {
			System.out.println("Found " + searchKey);
		}
		
		// Delete item with key 55
		searchKey = 55;
		for (j = 0; j < nElems; j++) {
			if (arr[j] == searchKey) {
				break;
			}
		}
		for (int k = j; k < nElems - 1; k++) { // Fixed Error: (was nElems, must be nElems - 1)
			arr[k] = arr[k + 1];
		}
		nElems--;
		
		for (j = 0; j < nElems; j++) {
			System.out.print(arr[j] + " ");
		}
		System.out.println();
	}

}
