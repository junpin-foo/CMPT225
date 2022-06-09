package binarytree;

import java.util.*;

public class BinaryTree<T> {

	private BTNode<T> root;

	public BinaryTree(BTNode<T> root) {
		this.root = root;
	}

	public BTNode<T> getRoot() {
		return root;
	}

	/**
	 * reverse the tree so that the result
	 * is a mirror image of the original tree
	 */
	public BTNode<T> Swap(BTNode<T> root){ //inverse left sub tree with right subtree

		if (root == null) {
			return root;
		}

		BTNode<T> left = Swap(root.getLeftChild());
		BTNode<T> right = Swap(root.getRightChild());

		root.setLeftChild(right);
		root.setRightChild(left);

		return root;
	}

	public void mirrorInverse() {

		if (root == null) {
			return;
		}

		root = Swap(root);
	}

	/**
	 * 
	 * gets inOrder and preOrder of a binary tree and recovers the tree
	 * @param inOrder
	 * @param preOrder
	 * @return
	 */
	public static <T> BTNode <T> buildTree(T in[],T pre[], int start, int end, int preIndex)
	{
		//base case
		if(start > end){
			return null;
		}

		T current = pre[preIndex];
		BTNode<T> r = new BTNode(current); // root

		//leaf node
		if(start == end){
			return r;
		}

		int inIndex = start;

		while(pre[preIndex] != in[inIndex])
			inIndex++; // didn't consider repeats


		r.setLeftChild(buildTree(in, pre, start, inIndex -1, preIndex +1));
		r.setRightChild(buildTree(in, pre, inIndex +1, end, preIndex + inIndex - start + 1));

		return r;
	}

	public static <T> BinaryTree<T> createFromPreorderInorder(List<T> inOrder, List<T> preOrder) {

		if (inOrder.size() != preOrder.size()) {
			return null;
		}

		T[] ArrayIn = (T[]) inOrder.toArray();
		T[] ArrayPre = (T[]) preOrder.toArray();

		int preIndex = 0;
		BTNode<T> temp;

		temp = buildTree(ArrayIn, ArrayPre, 0, ArrayIn.length -1, 0);

		BinaryTree lol = new BinaryTree<T>(temp);
		return lol;

	}


	/**
	 * creates an inOrder iterator for this.
	 * the iterator is dynamic in the following sense:
	 * If after the iterator is created, and the tree changes in some part
	 * that has not been processed by the iterator, then the iterator will see these changes
	 * and output the values in the updated tree 
	 * @return
	 */
	public Iterator<T> inOrderIterator() {

		BTIterator<T> it = new BTIterator(root);

		return it;
	}
}

