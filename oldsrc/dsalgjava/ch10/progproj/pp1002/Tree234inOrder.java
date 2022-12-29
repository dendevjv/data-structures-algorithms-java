package dsalgjava.ch10.progproj.pp1002;

import dsalgjava.ch10.lst1001.DataItem;
import dsalgjava.ch10.lst1001.Tree234;
import dsalgjava.ch10.lst1001.Node;

public class Tree234inOrder  extends Tree234  {
    
    public void displayInOrder() {
        inOrder(root);
        System.out.println();
    }
    
    private void inOrder(Node n) {
        Node nj = null;
        int j = 0;
        for (; j < Node.MAX_NUM_ITEMS; j++) {
            nj = n.getChild(j);
            if (nj != null) {
                inOrder(nj);
            }
            DataItem dj = n.getItem(j);
            if (dj != null) {
                dj.display();
            }
        }
        nj = n.getChild(j);
        if (nj != null) {
            inOrder(nj);
        }
    }
    
}
