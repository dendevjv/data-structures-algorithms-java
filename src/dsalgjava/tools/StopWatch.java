package dsalgjava.tools;

public class StopWatch {
    private long startMillis;
    
    public void start() {
        startMillis = System.currentTimeMillis();
    }
    
    public long stop() {
        return System.currentTimeMillis() - startMillis;
    }
}
