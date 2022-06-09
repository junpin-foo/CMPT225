package binarytree;

import java.util.Iterator;
import java.util.Stack;

public class BTIterator<T>  implements Iterator{
    private Stack<BTNode> stack;


    public BTIterator(BTNode<T> root) { //constructor
        this.stack = new Stack<BTNode>();
        this.leftMostNode(root);
    }

    public void leftMostNode(BTNode root){ // add all left subtree node
        while(root != null){
            this.stack.push(root);
            root = root.getLeftChild();
        }
    }

    public T next(){
        BTNode TopMostNode = this.stack.pop(); //1st node in stack
        if(TopMostNode.getRightChild() != null){ // does popped  have right child?
            this.leftMostNode(TopMostNode.getRightChild()); //if right exist, dive into it
        }
        T r = (T) TopMostNode.getData(); //found inorder next
        return r;
    }
    public boolean hasNext(){
        return !stack.isEmpty();
    }

    private void pushLeft(BTNode node){ //not needed i think
        if (node != null){
            stack.push(node);

            pushLeft(node.getLeftChild());
        }
    }

    boolean isEmpty() {
        return (stack.empty());
    }

}
