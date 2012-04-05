package kent.datastructures.tree;

/**
 * @param <T>
 * @author Quentin Loos
 */
public class AVLTree<T extends Comparable<T>> extends BinarySearchTree<T> {
  /**
   * height of the tree.
   */
  private int height;

  /*
   * Constructeurs
   */

  /**
   * Construct an empty AVLTree
   */
  public AVLTree() {
    height = 0;
  }

  /**
   * Construct an AVLTree with data.
   *
   * @param data
   *          The data of the node
   */
  public AVLTree(T data) {
    super(data);
    height = 1;
  }

  /**
   * Construct an AVLTree with data and subtrees.
   *
   * @param data
   *          The data of the node
   * @param left
   *          The left subtree
   * @param right
   *          The right subtree
   */
  public AVLTree(T data, AVLTree<T> left, AVLTree<T> right) {
    super(data, left, right);
    this.height();
  }

  /*
   * Getter & Setter
   */

  /*
   * (non-Javadoc)
   *
   * @see kent.datastructures.BinarySearchTree#getLeft()
   */
  @Override
  public AVLTree<T> getLeft() {
    return (AVLTree<T>) super.getLeft();
  }

  /*
   * (non-Javadoc)
   *
   * @see kent.datastructures.BinarySearchTree#getRight()
   */
  @Override
  public AVLTree<T> getRight() {
    return (AVLTree<T>) super.getRight();
  }

  /*
   * (non-Javadoc)
   *
   * @see kent.datastructures.BinaryTree#getHeight()
   */
  @Override
  public int getHeight() {
    return height;
  }

  /*
   * Class Methods
   */

  @Override
  public AVLTree<T> insertEmpty(T data) {
    return new AVLTree<T>(data);
  }

  /**
   * Computes the height of the node, recursively.
   */
  private void height() {
    if (this.isEmpty())
      this.height = 0;
    else if (this.isLeaf())
      this.height = 1;
    else if (this.getLeft() == null)
      this.height = 1 + this.getRight().height;
    else if (this.getRight() == null)
      this.height = 1 + this.getLeft().height;
    else
      this.height = 1 + Math.max(this.getLeft().height, this.getRight().height);
  }

  /**
   * Computes the balance of the tree.
   *
   * @return the balance of the tree
   */
  private int balance() {
    if (this.isEmpty() || this.isLeaf())
      return 0;
    if (this.getLeft() == null)
      return this.getRight().height;
    if (this.getRight() == null)
      return -(this.getLeft().height);
    return (this.getRight().height - this.getLeft().height);
  }

  /**
   * Left rotation.
   */
  private void leftRotation() {
    T data = this.getData();
    AVLTree<T> temp = this.getRight();
    setData(temp.getData());
    setRight(temp.getRight());
    temp.setData(data);
    temp.setRight(temp.getLeft());
    temp.setLeft(getLeft());
    setLeft(temp);
    temp.height();
    height();
  }

  /**
   * Right rotation.
   */
  private void rightRotation() {
    T data = this.getData();
    AVLTree<T> temp = getLeft();
    setData(temp.getData());
    setLeft(temp.getLeft());
    temp.setData(data);
    temp.setLeft(temp.getRight());
    temp.setRight(getRight());
    setRight(temp);
    temp.height();
    this.height();
  }

  /*
   * (non-Javadoc)
   *
   * @see kent.datastructures.BinarySearchTree#balancing()
   */
  @Override
  protected void balancing() {
    super.balancing();
    if (this.balance() == 2) {
      if (this.getRight().balance() >= 0)
        this.leftRotation();
      else {
        this.getRight().rightRotation();
        this.leftRotation();
      }
    } else if (this.balance() == -2) {
      if (this.getLeft().balance() <= 0)
        this.rightRotation();
      else {
        this.getLeft().leftRotation();
        this.rightRotation();
      }
    } else
      this.height();
  }
}
