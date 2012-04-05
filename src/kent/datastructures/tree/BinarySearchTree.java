package kent.datastructures.tree;

/**
 * This class represents a binary search tree.
 * 
 * @author Quentin Loos
 */
public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T> {

  /*
   * Constructors
   */

  /**
   * Constructs an empty BinarySerachTree
   */
  public BinarySearchTree() {
    super();
  }

  /**
   * Constructs a BinarySerachTree with data
   * 
   * @param data
   *          the data of the node
   */
  public BinarySearchTree(T data) {
    super(data);
  }

  /**
   * Constructs a BinarySerachTree with data and the subtrees
   * 
   * @param data
   *          The data of the node
   * @param left
   *          The left subtree
   * @param right
   *          The right subtree
   */
  public BinarySearchTree(T data, BinarySearchTree<T> left,
      BinarySearchTree<T> right) {
    super(data, left, right);
  }

  /*
   * Getter & Setter
   */

  /*
   * (non-Javadoc)
   * 
   * @see kent.datastructures.BinaryTree#getLeft()
   */
  @Override
  public BinarySearchTree<T> getLeft() {
    return (BinarySearchTree<T>) super.getLeft();
  }

  /*
   * (non-Javadoc)
   * 
   * @see kent.datastructures.BinaryTree#getRight()
   */
  @Override
  public BinarySearchTree<T> getRight() {
    return (BinarySearchTree<T>) super.getRight();
  }

  /*
   * Class Methods
   */

  /**
   * Search the given data in the tree
   * 
   * @param data
   *          The data to search
   * @return True if the given data is in the tree
   */
  public boolean search(T data) {
    if (this.isEmpty())
      return false;
    if (this.getData().compareTo(data) == 0)
      return true;
    if (this.getData().compareTo(data) > 0) {
      if (this.getLeft() == null)
        return false;
      return this.getLeft().search(data);
    } else {
      if (this.getRight() == null)
        return false;
      return this.getRight().search(data);
    }
  }

  /**
   * Add data to the tree.
   * 
   * @param data
   *          the data to add
   */
  public void add(T data) {
    if (this.isEmpty())
      this.setData(data);
    else if (this.getData().compareTo(data) > 0) {
      if (this.getLeft() == null)
        this.setLeft(insertEmpty(data));
      else
        this.getLeft().add(data);
    } else if (this.getData().compareTo(data) < 0) {
      if (this.getRight() == null)
        this.setRight(insertEmpty(data));
      else
        this.getRight().add(data);
    }
    this.balancing();
  }

  /**
   * Insert a node in a empty tree
   * 
   * @param data
   *          the data to add
   */
  public BinarySearchTree<T> insertEmpty(T data) {
    return new BinarySearchTree<T>(data);
  }

  /**
   * Remove the specified data of the tree.
   * 
   * @param data
   *          The data to remove
   */
  public void remove(T data) {
    if (!this.isEmpty()) {
      if (this.getData().compareTo(data) < 0) {
        if (this.getRight() != null)
          this.getRight().remove(data);
      } else if (this.getData().compareTo(data) > 0) {
        if (this.getLeft() != null)
          this.getLeft().remove(data);
      } else
        removeRoot();
    }
    this.balancing();
  }

  /**
   * Remove the root of the tree
   */
  private void removeRoot() {
    if (this.isLeaf())
      this.setData(null);
    else if (this.getLeft() == null) {
      BinarySearchTree<T> t = this.getRight();
      this.setData(t.getData());
      this.setLeft(t.getLeft());
      this.setRight(t.getRight());
    } else if (this.getRight() == null) {
      BinarySearchTree<T> t = this.getLeft();
      this.setData(t.getData());
      this.setRight(t.getRight());
      this.setLeft(t.getLeft());
    } else
      this.setData(this.getRight().removeMin());
    this.balancing();
  }

  /**
   * Remove the minimum data in the tree, and return it.
   */
  public T removeMin() {
    if (this.isEmpty())
      return null;
    T min;
    if (this.getLeft() == null) {
      min = this.getData();
      if (this.isLeaf()) {
        setData(null);
        setRight(null);
      } else {
        setData(this.getRight().getData());
        setRight(this.getRight().getRight());
      }
    } else
      min = this.getLeft().removeMin();
    this.balancing();
    return min;
  }

  /**
   * Remove the maximum data in the tree, and return it.
   */
  public T removeMax() {
    if (this.isEmpty())
      return null;
    T max;
    if (this.getRight() == null) {
      max = this.getData();
      if (this.isLeaf()) {
        setData(null);
        setLeft(null);
      } else {
        setData(this.getLeft().getData());
        setLeft(this.getLeft().getLeft());
      }
    } else
      max = this.getRight().removeMax();
    this.balancing();
    return max;
  }

  /**
   * balance/equilibrate the tree
   */
  protected void balancing() {
    if (this.getLeft() != null && this.getLeft().getData() == null)
      this.setLeft(null);
    if (this.getRight() != null && this.getRight().getData() == null)
      this.setRight(null);
  }

  /**
   * Search the minimum data in the tree.
   * 
   * @return The minimum data in the tree
   */
  public T searchMin() {
    if (this.getLeft() == null)
      return this.getData();
    else
      return this.getLeft().searchMin();
  }

  /**
   * Search the maximum data in the tree.
   * 
   * @return The maximum data in the tree
   */
  public T searchMax() {
    if (this.getRight() == null)
      return this.getData();
    else
      return this.getRight().searchMax();
  }

  /**
   * Search the successor of a node and return it
   * 
   * @param data
   *          the node
   * @return The successor of the node
   */
  public T successor(T data) {
    if (this.isEmpty())
      return null;
    if (this.getData().compareTo(data) < 0) {
      if (this.getRight() == null)
        return null;
      return this.getRight().successor(data);
    }
    if (this.getData().compareTo(data) > 0) {
      if (this.getLeft() == null)
        return null;
      T tmp;
      if ((tmp = this.getLeft().successor(data)) == null)
        return this.getData();
      return tmp;
    }
    if (this.getRight() == null)
      return null;
    return this.getRight().searchMin();
  }

  /**
   * Search the predecessor of a node and return it
   * 
   * @param data
   *          the node
   * @return The predecessor of the node
   */
  public T predecessor(T data) {
    if (this.isEmpty())
      return null;
    if (this.getData().compareTo(data) < 0) {
      if (this.getRight() == null)
        return null;
      T tmp;
      if ((tmp = this.getRight().predecessor(data)) == null)
        return this.getData();
      return tmp;
    }
    if (this.getData().compareTo(data) > 0) {
      if (this.getLeft() == null)
        return null;
      return this.getLeft().predecessor(data);
    }
    if (this.getLeft() == null)
      return null;
    return this.getLeft().searchMax();
  }
}