package dsalgjava.ch10.progproj.pp1001;

import dsalgjava.ch10.lst1001.DataItem;
import dsalgjava.ch10.lst1001.Node;
import dsalgjava.ch10.lst1001.Tree234;

public class Tree234min extends Tree234 {
    public DataItem getMinimum() {
        Node n = root;
        DataItem item = n.getItem(0);
        while ((n = n.getChild(0)) != null) {
            item = n.getItem(0);
        }
        // PC: n == null
        return item;
    }
}
