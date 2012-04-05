package kent.datastructures.tree;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Quentin Loos
 */
public class BinaryTreeTest {
  private BinaryTree<Integer> tree;
  private BinaryTree<Integer> left;
  private BinaryTree<Integer> right;

  /**
   * @throws java.lang.Exception
   */
  @Before
  public void setUp() throws Exception {
    left = new BinaryTree<Integer>(2);
    right = new BinaryTree<Integer>(3);
    tree = new BinaryTree<Integer>(1, left, right);
  }

  /**
   * Test method for
   * {@link be.ac.umons.sdd.datastructures.BinaryTree#BinaryTree()}.
   */
  @Test
  public final void testBinaryTree() {
    tree = new BinaryTree<Integer>();
    assertNull(tree.getData());
    assertNull(tree.getLeft());
    assertNull(tree.getRight());
  }

  /**
   * Test method for
   * {@link be.ac.umons.sdd.datastructures.BinaryTree#BinaryTree(java.lang.Object)}
   * .
   */
  @Test
  public final void testBinaryTreeT() {
    tree = new BinaryTree<Integer>(10);
    assertEquals(tree.getData(), new Integer(10));
    assertNull(tree.getLeft());
    assertNull(tree.getRight());
  }

  /**
   * Test method for
   * {@link be.ac.umons.sdd.datastructures.BinaryTree#BinaryTree(java.lang.Object, be.ac.umons.sdd.datastructures.BinaryTree, be.ac.umons.sdd.datastructures.BinaryTree)}
   * .
   */
  @Test
  public final void testBinaryTreeTBinaryTreeOfTBinaryTreeOfT() {
    assertEquals(tree.getData(), new Integer(1));
    assertEquals(tree.getLeft().getData(), new Integer(2));
    assertEquals(tree.getRight().getData(), new Integer(3));
  }

  /**
   * Test method for {@link be.ac.umons.sdd.datastructures.BinaryTree#getData()}
   * .
   */
  @Test
  public final void testGetData() {
    assertEquals(tree.getData(), new Integer(1));
  }

  /**
   * Test method for
   * {@link be.ac.umons.sdd.datastructures.BinaryTree#setData(java.lang.Object)}
   * .
   */
  @Test
  public final void testSetData() {
    tree.setData(15);
    assertEquals(tree.getData(), new Integer(15));
  }

  /**
   * Test method for {@link be.ac.umons.sdd.datastructures.BinaryTree#getLeft()}
   * .
   */
  @Test
  public final void testGetLeft() {
    assertEquals(tree.getLeft(), left);
    assertEquals(tree.getLeft().getData(), new Integer(2));
  }

  /**
   * Test method for
   * {@link be.ac.umons.sdd.datastructures.BinaryTree#setLeft(be.ac.umons.sdd.datastructures.BinaryTree)}
   * .
   */
  @Test
  public final void testSetLeft() {
    left = new BinaryTree<Integer>(16);
    tree.setLeft(left);
    assertEquals(tree.getLeft(), left);
    assertEquals(tree.getLeft().getData(), new Integer(16));
  }

  /**
   * Test method for
   * {@link be.ac.umons.sdd.datastructures.BinaryTree#getRight()}.
   */
  @Test
  public final void testGetRight() {
    assertEquals(tree.getRight(), right);
    assertEquals(tree.getRight().getData(), new Integer(3));
  }

  /**
   * Test method for
   * {@link be.ac.umons.sdd.datastructures.BinaryTree#setRight(be.ac.umons.sdd.datastructures.BinaryTree)}
   * .
   */
  @Test
  public final void testSetRight() {
    right = new BinaryTree<Integer>(11);
    tree.setRight(right);
    assertEquals(tree.getRight(), right);
    assertEquals(tree.getRight().getData(), new Integer(11));
  }

  /**
   * Test method for {@link be.ac.umons.sdd.datastructures.BinaryTree#isEmpty()}
   * .
   */
  @Test
  public final void testIsEmpty() {
    tree = new BinaryTree<Integer>();
    assertTrue(tree.isEmpty());
    tree.setData(11);
    assertFalse(tree.isEmpty());
  }

  /**
   * Test method for {@link be.ac.umons.sdd.datastructures.BinaryTree#isLeaf()}.
   */
  @Test
  public final void testIsLeaf() {
    tree = new BinaryTree<Integer>();
    assertTrue(tree.isLeaf());
    tree.setRight(right);
    assertFalse(tree.isLeaf());
    tree.setLeft(left);
    assertFalse(tree.isLeaf());
    tree.setRight(null);
    assertFalse(tree.isLeaf());
  }

  /**
   * Test method for
   * {@link be.ac.umons.sdd.datastructures.BinaryTree#getHeight()}.
   */
  @Test
  public final void testGetHeight() {
    tree = new BinaryTree<Integer>();
    assertEquals(tree.getHeight(), 0);
    tree.setData(10);
    assertEquals(tree.getHeight(), 1);
    tree.setRight(right);
    assertEquals(tree.getHeight(), 2);
    tree.setRight(null);
    tree.setLeft(left);
    assertEquals(tree.getHeight(), 2);
    tree.setRight(right);
    tree.setLeft(left);
    assertEquals(tree.getHeight(), 2);
  }

  /**
   * Test method for
   * {@link be.ac.umons.sdd.datastructures.BinaryTree#toString()}.
   */
  @Test
  public final void testToString() {

  }

}
