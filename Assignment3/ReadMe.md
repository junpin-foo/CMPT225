# assignment3
Part 1 [60 points] - Binary Trees
a) [20 points] In the class BinaryTree write the method
public void mirrorInverse()
It transforms the tree as in a mirror image. For example:

b) [20 points] In the class BinaryTree write the method
public <T> BinaryTree<T> createFromPreorderInorder(List<T> preorder,
List<T>inorder)
It gets two lists representing preorder and inorder of a binary tree, and reconstructs the
tree. For example: if preorder is [V,A,X,Y,B,Z,Q] and inorder is [X,A,Y,V,Z,Q,B], then the
function returns the following tree:
  
c) [20 points] Write an iterator for the class BinaryTree that performs inorder traversal on the
tree. The iterator is called using the method
public Iterator<T> inOrderIterator()
The iterator must be dynamic in the following sense: if after the iterator is created, and the
tree changes in some part that has not been processed by the iterator, then the iterator will
see these changes and output the values in the updated tree. However, if you change the
nodes that have already been processed, then it will have no effect on the iterator.
** Be careful, do not changed the nodes that are currently being processed, as this may
have unexpected effects
  
 constructor of the iterator, then it will not work in the dynamic sense.
Part 2 [40 points] - Evaluating arithmetic expressions
a) In the class ArithmeticExpressions write the method
public static String infix2Prefix(String infixExpression)
The method gets an arithmetic expression in the infix notation, and returns it in prefix
notation. All tokens must be separated by a single space.
See examples in the test files.
  
b) In the class ArithmeticExpressions write the method
public static BTNode<Double> postfix2BinaryTree(String postfixExpression)
The method gets an arithmetic expression in the postfix notation, and returns a binary tree
representing the expression. All tokens are separated by a single space.
See examples in the test files. 
