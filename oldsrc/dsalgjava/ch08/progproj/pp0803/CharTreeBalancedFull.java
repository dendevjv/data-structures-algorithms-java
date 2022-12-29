package dsalgjava.ch08.progproj.pp0803;

import dsalgjava.ch08.progproj.pp0801.CharNode;
import dsalgjava.ch08.progproj.pp0801.CharTree;

public class CharTreeBalancedFull extends CharTree {
    public CharTreeBalancedFull(String charStr) {
        populateTree(charStr);
    }
    
    @Override
    protected void populateTree(String charStr) {
        char[] charArray = charStr.toCharArray();
        int idx = 0;
        root = new CharNode(charArray[idx]);
        populate(root, idx, charArray);
    }

    private void populate(CharNode node, int idx, char[] charArray) {
        int idxLeft = 2 * idx + 1;
        if (idxLeft < charArray.length) {
            CharNode leftNode = new CharNode(charArray[idxLeft]);
            node.left = leftNode;
            populate(leftNode, idxLeft, charArray);
        }
        int idxRight = 2 * idx + 2;
        if (idxRight < charArray.length) {
            CharNode rightNode = new CharNode(charArray[idxRight]);
            node.right = rightNode;
            populate(rightNode, idxRight, charArray);
        }
    }
}
