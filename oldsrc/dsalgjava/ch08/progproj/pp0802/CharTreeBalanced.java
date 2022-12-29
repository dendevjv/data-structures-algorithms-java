package dsalgjava.ch08.progproj.pp0802;

import dsalgjava.ch08.progproj.pp0801.CharNode;
import dsalgjava.ch08.progproj.pp0801.CharTree;

public class CharTreeBalanced extends CharTree {
    CharTreeBalanced() {
        super();
    }

    CharTreeBalanced(String charStr) {
        populateTree(charStr);
    }

    protected void populateTree(String charStr) {
        CharNode[] nodes = strToNodes(charStr);
        CharNodeQueue queue = new CharNodeQueue(nodes.length);
        int numNodes = nodes.length;
        int j;
        do {
            j = 0;
            while (j < numNodes) {
                CharNode n = new CharNode();
                n.left = nodes[j++];
                if (j < numNodes) {
                    n.right = nodes[j++];
                }
                queue.add(n);
            }
            numNodes = 0;
            while (!queue.isEmpty()) {
                nodes[numNodes++] = queue.remove();
            }
        } while (numNodes > 1);
        root = nodes[0];
    }
}
