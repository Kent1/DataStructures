package kent.datastructures.tree;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Quentin Loos
 */
public class AVLTreeTest {
  private AVLTree<Integer> tree;
  private AVLTree<Integer> left;
  private AVLTree<Integer> right;

  /**
   * @throws java.lang.Exception
   */
  @Before
  public void setUp() throws Exception {
    setLeft(new AVLTree<Integer>(1));
    right = new AVLTree<Integer>(3);
    tree = new AVLTree<Integer>(2, getLeft(), right);
  }

  /**
   * Test method for {@link be.ac.umons.sdd.datastructures.AVLTree#AVLTree()}.
   */
  @Test
  public final void testAVLTree() {
    tree = new AVLTree<Integer>();
    assertNull(tree.getData());
    assertNull(tree.getLeft());
    assertNull(tree.getRight());
  }

  /**
   * Test method for
   * {@link be.ac.umons.sdd.datastructures.AVLTree#AVLTree(java.lang.Comparable)}
   * .
   */
  @Test
  public final void testAVLTreeT() {
    tree = new AVLTree<Integer>(10);
    assertEquals(tree.getData(), new Integer(10));
    assertNull(tree.getLeft());
    assertNull(tree.getRight());
  }

  /**
   * Test method for
   * {@link be.ac.umons.sdd.datastructures.AVLTree#AVLTree(java.lang.Comparable, be.ac.umons.sdd.datastructures.AVLTree, be.ac.umons.sdd.datastructures.AVLTree)}
   * .
   */
  @Test
  public final void testAVLTreeTAVLTreeOfTAVLTreeOfT() {
    assertEquals(tree.getData(), new Integer(2));
    assertEquals(tree.getLeft().getData(), new Integer(1));
    assertEquals(tree.getRight().getData(), new Integer(3));
  }

  /**
   * Test method for {@link be.ac.umons.sdd.datastructures.AVLTree#getHeight()}.
   */
  @Test
  public final void testGetHeight() {
    assertEquals(tree.getHeight(), 2);
    tree.remove(3);
    assertEquals(tree.getHeight(), 2);
    tree.remove(2);
    assertEquals(tree.getHeight(), 1);
    tree.remove(1);
    assertEquals(tree.getHeight(), 0);
  }

  /**
   * Test method for
   * {@link be.ac.umons.sdd.datastructures.AVLTree#add(java.lang.Comparable)}.
   */
  @Test
  public final void testAdd() {
    tree.add(1);
    assertTrue(tree.search(1));

    tree.add(0);
    assertTrue(tree.search(0));
    assertEquals(tree.getLeft().getLeft().getData(), new Integer(0));

    tree.add(42);
    assertTrue(tree.search(42));
    assertEquals(tree.getRight().getRight().getData(), new Integer(42));

    tree.add(43);
    assertTrue(tree.search(43));
    assertEquals(tree.getRight().getData(), new Integer(42));
    assertEquals(tree.getRight().getRight().getData(), new Integer(43));

    tree.add(45);
    assertTrue(tree.search(45));

    tree.add(44);
    assertTrue(tree.search(44));
    assertEquals(tree.getRight().getRight().getData(), new Integer(44));
    assertEquals(tree.getRight().getRight().getLeft().getData(),
        new Integer(43));
    assertEquals(tree.getRight().getRight().getRight().getData(), new Integer(
        45));

    tree.add(-43);
    assertTrue(tree.search(-43));
    assertEquals(tree.getLeft().getData(), new Integer(0));
    assertEquals(tree.getLeft().getLeft().getData(), new Integer(-43));

    tree.add(-44);
    assertTrue(tree.search(-44));
  }

  /**
   * Test method for {@link be.ac.umons.sdd.datastructures.AVLTree#getLeft()}.
   */
  @Test
  public final void testGetLeft() {
    assertEquals(tree.getLeft(), getLeft());
    assertEquals(tree.getLeft().getData(), new Integer(1));
  }

  /**
   * Test method for {@link be.ac.umons.sdd.datastructures.AVLTree#getRight()}.
   */
  @Test
  public final void testGetRight() {
    assertEquals(tree.getRight(), right);
    assertEquals(tree.getRight().getData(), new Integer(3));
  }

  /**
   * @return the left
   */
  public AVLTree<Integer> getLeft() {
    return left;
  }

  /**
   * @param left the left to set
   */
  public void setLeft(AVLTree<Integer> left) {
    this.left = left;
  }
}
