package dsalgjava.ch07.progproj.pp0703;

public class TestArrayMedian {

    public static void main(String[] args) {
        String[] ss = { " 10  5 11  4 15 12  1 14 15 11  1  5  6 10 11 10",
                "1  2 12  6  1  4 14  4  0  5 13  2  6 15  2  6",
                "0  0  4  4  0 13 10 13  9  4  5 15 13  2 13 14" };
        
        for (int i = 0; i < ss.length; i++) {
            System.out.println("Test #" + (i+1));
            
            ArrayMedian arr = new ArrayMedian(ss[i]);
            arr.displayIndexed();

            int median = arr.partitionAndFindMedian();
            System.out.println("Median is at index " + median);
            arr.displayIndexed();
        }
    }

}
