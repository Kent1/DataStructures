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
public class BinarySearchTreeTest {
  private BinarySearchTree<Integer> tree;
  private BinarySearchTree<Integer> left;
  private BinarySearchTree<Integer> right;

  /**
   * @throws java.lang.Exception
   */
  @Before
  public void setUp() throws Exception {
    left = new BinarySearchTree<Integer>(1);
    right = new BinarySearchTree<Integer>(3);
    tree = new BinarySearchTree<Integer>(2, left, right);
  }

  /**
   * Test method for
   * {@link be.ac.umons.sdd.datastructures.BinarySearchTree#BinarySearchTree()}.
   */
  @Test
  public final void testBinarySearchTree() {
    tree = new BinarySearchTree<Integer>();
    assertNull(tree.getData());
    assertNull(tree.getLeft());
    assertNull(tree.getRight());
  }

  /**
   * Test method for
   * {@link be.ac.umons.sdd.datastructures.BinarySearchTree#BinarySearchTree(java.lang.Comparable)}
   * .
   */
  @Test
  public final void testBinarySearchTreeT() {
    tree = new BinarySearchTree<Integer>(10);
    assertEquals(tree.getData(), new Integer(10));
    assertNull(tree.getLeft());
    assertNull(tree.getRight());
  }

  /**
   * Test method for
   * {@link be.ac.umons.sdd.datastructures.BinarySearchTree#BinarySearchTree(java.lang.Comparable, be.ac.umons.sdd.datastructures.BinarySearchTree, be.ac.umons.sdd.datastructures.BinarySearchTree)}
   * .
   */
  @Test
  public final void testBinarySearchTreeTBinarySearchTreeOfTBinarySearchTreeOfT() {
    assertEquals(tree.getData(), new Integer(2));
    assertEquals(tree.getLeft().getData(), new Integer(1));
    assertEquals(tree.getRight().getData(), new Integer(3));
  }

  /**
   * Test method for
   * {@link be.ac.umons.sdd.datastructures.BinarySearchTree#getLeft()}.
   */
  @Test
  public final void testGetLeft() {
    assertEquals(tree.getLeft(), left);
    assertEquals(tree.getLeft().getData(), new Integer(1));
  }

  /**
   * Test method for
   * {@link be.ac.umons.sdd.datastructures.BinarySearchTree#getRight()}.
   */
  @Test
  public final void testGetRight() {
    assertEquals(tree.getRight(), right);
    assertEquals(tree.getRight().getData(), new Integer(3));
  }

  /**
   * Test method for
   * {@link be.ac.umons.sdd.datastructures.BinarySearchTree#search(java.lang.Comparable)}
   * .
   */
  @Test
  public final void testSearch() {
    assertTrue(tree.search(1));
    assertTrue(tree.search(3));
    assertFalse(tree.search(42));
  }

  /**
   * Test method for
   * {@link be.ac.umons.sdd.datastructures.BinarySearchTree#add(java.lang.Comparable)}
   * .
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
  }

  /**
   * Test method for
   * {@link be.ac.umons.sdd.datastructures.BinarySearchTree#remove(java.lang.Comparable)}
   * .
   */
  @Test
  public final void testRemove() {
    tree.remove(2);
    assertFalse(tree.search(2));

    tree.remove(3);
    assertFalse(tree.search(3));
    assertEquals(tree.getHeight(), 1);

    tree.remove(1);
    assertTrue(tree.isEmpty());

    tree.add(9);
    tree.add(19);
    tree.add(2);
    tree.add(1);
    tree.add(11);

    tree.remove(11);
    tree.remove(1);
    tree.remove(2);
    tree.remove(9);
    tree.remove(19);
  }

  /**
   * Test method for
   * {@link be.ac.umons.sdd.datastructures.BinarySearchTree#removeMin()}.
   */
  @Test
  public final void testRemoveMin() {
    assertTrue(tree.search(1));
    assertEquals(tree.removeMin(), new Integer(1));
    assertFalse(tree.search(1));

    assertEquals(tree.removeMin(), new Integer(2));
    assertEquals(tree.removeMin(), new Integer(3));

    assertTrue(tree.isEmpty());
  }

  /**
   * Test method for
   * {@link be.ac.umons.sdd.datastructures.BinarySearchTree#removeMax()}.
   */
  @Test
  public final void testRemoveMax() {
    assertTrue(tree.search(3));
    assertEquals(tree.removeMax(), new Integer(3));
    assertFalse(tree.search(3));

    assertEquals(tree.removeMax(), new Integer(2));
    assertEquals(tree.removeMax(), new Integer(1));

    assertTrue(tree.isEmpty());
  }

  /**
   * Test method for
   * {@link be.ac.umons.sdd.datastructures.BinarySearchTree#balancing()}.
   */
  @Test
  public final void testBalancing() {
  }

  /**
   * Test method for
   * {@link be.ac.umons.sdd.datastructures.BinarySearchTree#searchMin()}.
   */
  @Test
  public final void testSearchMin() {
    assertEquals(tree.searchMin(), new Integer(1));
  }

  /**
   * Test method for
   * {@link be.ac.umons.sdd.datastructures.BinarySearchTree#searchMax()}.
   */
  @Test
  public final void testSearchMax() {
    assertEquals(tree.searchMax(), new Integer(3));
  }

  /**
   * Test method for
   * {@link be.ac.umons.sdd.datastructures.BinarySearchTree#successor(java.lang.Comparable)}
   * .
   */
  @Test
  public final void testSuccessor() {
    assertEquals(tree.successor(2), new Integer(3));
    assertEquals(tree.successor(1), new Integer(2));
    assertNull(tree.successor(3));
  }

  /**
   * Test method for
   * {@link be.ac.umons.sdd.datastructures.BinarySearchTree#predecessor(java.lang.Comparable)}
   * .
   */
  @Test
  public final void testPredecessor() {
    assertEquals(tree.predecessor(2), new Integer(1));
    assertEquals(tree.predecessor(3), new Integer(2));
    assertNull(tree.predecessor(1));
  }
}
