package com.points.kdTree

import static org.junit.Assert.*
import org.junit.Test

class KDTreeFactoryTest {
	
	@Test
	public void testFactory() {
		def list = [[new BigDecimal(1), new BigDecimal(2)], [new BigDecimal(1), new BigDecimal(5)], 
					[new BigDecimal(3), new BigDecimal(2)], [new BigDecimal(5), new BigDecimal(6)], 
					[new BigDecimal(7), new BigDecimal(1)], [new BigDecimal(7), new BigDecimal(4)], 
					[new BigDecimal(8), new BigDecimal(8)]]
		def topNode = KDTreeFactory.createTreeFromBigDecimalList(list)
		
		// Validating tree structure
		assertEquals(new BigDecimal(5), topNode.getSplitValue())
		assertEquals("x", topNode.getSplitAxis())
		
		def leftChild = topNode.getLeftChild()
		assertEquals(new BigDecimal(2), leftChild.getSplitValue())
		assertEquals("y", leftChild.getSplitAxis())
		
		def leftLChild = leftChild.getLeftChild()
		assertEquals(new BigDecimal(1), leftLChild.getSplitValue())
		assertEquals("x", leftLChild.getSplitAxis())		
		assertEquals(new BigDecimal(1), leftLChild.getLeftChild().getX())
		assertEquals(new BigDecimal(2), leftLChild.getLeftChild().getY())
		assertEquals(new BigDecimal(3), leftLChild.getRightChild().getX())
		assertEquals(new BigDecimal(2), leftLChild.getRightChild().getY())
		
		def leftRChild = leftChild.getRightChild()
		assertEquals(new BigDecimal(1), leftRChild.getSplitValue())
		assertEquals("x", leftRChild.getSplitAxis())
		assertEquals(new BigDecimal(1), leftRChild.getLeftChild().getX())
		assertEquals(new BigDecimal(5), leftRChild.getLeftChild().getY())
		assertEquals(new BigDecimal(5), leftRChild.getRightChild().getX())
		assertEquals(new BigDecimal(6), leftRChild.getRightChild().getY())		
		
		def rightChild = topNode.getRightChild()
		assertEquals(new BigDecimal(4), rightChild.getSplitValue())
		assertEquals("y", rightChild.getSplitAxis())
		
		def rightLChild = rightChild.getLeftChild()
		assertEquals(new BigDecimal(7), rightLChild.getSplitValue())
		assertEquals("x", rightLChild.getSplitAxis())
		assertEquals(new BigDecimal(7), rightLChild.getLeftChild().getX())
		assertEquals(new BigDecimal(1), rightLChild.getLeftChild().getY())
		assertEquals(new BigDecimal(7), rightLChild.getRightChild().getX())
		assertEquals(new BigDecimal(4), rightLChild.getRightChild().getY())
		
		assertEquals(new BigDecimal(8), rightChild.getRightChild().getX())
		assertEquals(new BigDecimal(8), rightChild.getRightChild().getY())		
	}
}
