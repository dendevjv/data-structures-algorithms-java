package dsalgjava.ch06.lst0606;

public class DArray {
    private long[] arr;
    private int nElems;
    
    public DArray(int maxSize) {
        arr = new long[maxSize];
        nElems = 0;
    }
    
    public void insert(long v) {
        arr[nElems++] = v;
    }
    
    public void display() {
        for (int j = 0; j < nElems; j++) {
            System.out.print(arr[j] + " ");
        }
        System.out.println();
    }
    
    public void mergeSort() {
        long[] workSpace = new long[nElems];
        recMergeSort(workSpace, 0, nElems - 1);
    }

    private void recMergeSort(long[] workSpace, int lowerBound, int upperBound) {
        if (lowerBound == upperBound) {
            return;
        }
        int mid = (lowerBound + upperBound) / 2;
        recMergeSort(workSpace, lowerBound, mid);
        recMergeSort(workSpace, mid + 1, upperBound);
        merge(workSpace, lowerBound, mid + 1, upperBound);
    }

    private void merge(long[] workSpace, int lowPtr, int highPtr, int upperBound) {
        int j = 0;              // workSpace index
        int lowerBound = lowPtr;
        int mid = highPtr - 1;
        int numItems = upperBound - lowerBound + 1;
        
        while (lowPtr <= mid && highPtr <= upperBound) {
            if (arr[lowPtr] < arr[highPtr]) {
                workSpace[j++] = arr[lowPtr++];
            } else {
                workSpace[j++] = arr[highPtr++];
            }
        }
        while (lowPtr <= mid) {
            workSpace[j++] = arr[lowPtr++];
        }
        while (highPtr <= upperBound) {
            workSpace[j++] = arr[highPtr++];
        }
        for (j = 0; j < numItems; j++) {
            arr[lowerBound + j] = workSpace[j];
        }
    }
}
