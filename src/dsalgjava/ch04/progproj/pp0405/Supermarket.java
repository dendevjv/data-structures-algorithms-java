package dsalgjava.ch04.progproj.pp0405;

import java.util.Random;

public class Supermarket {
    private static final int SLEEP_DELAY = 1500;
    private static final int NUM_LINES = 4;
    private static final Random rnd = new Random();
    
    private Line[] lines;
    
    public Supermarket(int numLines) {
        lines = new Line[numLines];
        for (int i = 0; i < lines.length; i++) {
            lines[i] = new Line(i + 1);
        }
    }
    
    public void addClient(long id) {
        System.out.println("Adding client #" + id);
        int minLine = findMinLine();
        lines[minLine].add(id);
    }
    
    public void removeClient() {
        int rndLine = rnd.nextInt(lines.length);
        if (lines[rndLine].length() > 0) {
            long client = lines[rndLine].remove();
            System.out.println("Removed client #" + client);
        }
    }
    
    private int findMinLine() {
        int min = 0;
        for (int i = 1; i < lines.length; i++) {
            if (lines[i].length() < lines[min].length()) {
                min = i;
            }
        }
        return min;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Line n : lines) {
            sb.append(n.toString() + "\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Supermarket sm = new Supermarket(NUM_LINES);
        System.out.println(sm);
        
        for (int i = 1; i <= 20; i++) {
            sm.addClient(i);
            System.out.println(sm);
            delay();
            
            if (Math.random() > 0.55) {
                sm.removeClient();
                System.out.println(sm);
                delay();
            }
        }
    }

    private static void delay() {
        try {
            Thread.sleep(SLEEP_DELAY);
        } catch (InterruptedException e) {
        }
    }
}
