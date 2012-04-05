package kent.datastructures.tree;

/**
 * This class represents a binary tree.
 *
 * @param <T>
 * @author Quentin Loos
 */
public class BinaryTree<T> {
  /**
   * Node data
   */
  private T data;
  /**
   * Subtree left & right
   */
  private BinaryTree<T> left;
  private BinaryTree<T> right;

  /*
   * Constructeurs
   */

  /**
   * Constructs an empty Binarytree
   */
  public BinaryTree() {
    this.data = null;
    this.left = this.right = null;
  }

  /**
   * Constructs a Binarytree that contains the specified data
   *
   * @param data
   *          The data of the node
   */
  public BinaryTree(T data) {
    this.data = data;
    this.left = this.right = null;
  }

  /**
   * Constructs a Binarytree containing the specified data and the subtrees
   *
   * @param data
   *          the data of the node
   * @param left
   *          the left subtree
   * @param right
   *          the right subtree
   */
  public BinaryTree(T data, BinaryTree<T> left, BinaryTree<T> right) {
    this.data = data;
    this.left = left;
    this.right = right;
  }

  /*
   * Setters & Getters
   */

  /**
   * @return the data
   */
  public T getData() {
    return data;
  }

  /**
   * @param data
   *          the data to set
   */
  public void setData(T data) {
    this.data = data;
  }

  /**
   * @return the left
   */
  public BinaryTree<T> getLeft() {
    return left;
  }

  /**
   * @param left
   *          the left to set
   */
  public void setLeft(BinaryTree<T> left) {
    this.left = left;
  }

  /**
   * @return the right
   */
  public BinaryTree<T> getRight() {
    return right;
  }

  /**
   * @param right
   *          the right to set
   */
  public void setRight(BinaryTree<T> right) {
    this.right = right;
  }

  /*
   * Class Methods
   */

  /**
   * Return true is the tree is empty
   *
   * @return true if the tree is empty
   */
  public boolean isEmpty() {
    return (this.data == null && this.left == null && this.right == null);
  }

  /**
   * Return true if the node is a leaf.
   *
   * @return true if the node is a leaf.
   */
  public boolean isLeaf() {
    return (this.left == null && this.right == null);
  }

  /**
   * Compute the height of the tree
   *
   * @return the height of the tree
   */
  public int getHeight() {
    if (this.isEmpty())
      return 0;
    if (this.isLeaf())
      return 1;
    if (this.left == null)
      return 1 + this.right.getHeight();
    if (this.right == null)
      return 1 + this.left.getHeight();
    return 1 + Math.max(this.left.getHeight(), this.right.getHeight());
  }

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "BinaryTree [data=" + data + "," + "left=" + left + ", right="
        + right + "]";
  }
}