package com.points.neighbor

import static org.junit.Assert.*

import org.junit.Test

import com.points.kdTree.KDTreeFactory
import com.points.kdTree.Node

class NearestNeighborTest {
	
	@Test
	public void testNearestNeighborSimple() {
		def list = [[new BigDecimal(1), new BigDecimal(2)], [new BigDecimal(1), new BigDecimal(5)],
					[new BigDecimal(3), new BigDecimal(2)], [new BigDecimal(5), new BigDecimal(6)],
					[new BigDecimal(7), new BigDecimal(1)], [new BigDecimal(7), new BigDecimal(4)],
					[new BigDecimal(8), new BigDecimal(8)]]
		def topNode = KDTreeFactory.createTreeFromBigDecimalList(list)
		def neighbor = new NearestNeighbor(1)
		def point = new Node(new BigDecimal(1), new BigDecimal(6))
		def nearestNeighbors = neighbor.neighborSearch(point, topNode, topNode);
		def nearest = nearestNeighbors.poll()
		assertNotEquals(null, nearest)
		assertEquals(new BigDecimal(1), nearest.getX())
		assertEquals(new BigDecimal(5), nearest.getY())
	}
	
	@Test
	public void testNearestNeighborCrossTreeCenter() {
		def list = [[new BigDecimal(1), new BigDecimal(2)], [new BigDecimal(1), new BigDecimal(5)],
					[new BigDecimal(3), new BigDecimal(2)], [new BigDecimal(5), new BigDecimal(6)],
					[new BigDecimal(7), new BigDecimal(1)], [new BigDecimal(7), new BigDecimal(4)],
					[new BigDecimal(8), new BigDecimal(8)]]
		def topNode = KDTreeFactory.createTreeFromBigDecimalList(list)
		def neighbor = new NearestNeighbor(2)
		def point = new Node(new BigDecimal(6), new BigDecimal(7))
		def nearestNeighbors = neighbor.neighborSearch(point, topNode, topNode);
		assertEquals(2, nearestNeighbors.size)
		
		def nearest = nearestNeighbors.poll()
		assertEquals(new BigDecimal(8), nearest.getX())
		assertEquals(new BigDecimal(8), nearest.getY())
		nearest = nearestNeighbors.poll()
		assertEquals(new BigDecimal(5), nearest.getX())
		assertEquals(new BigDecimal(6), nearest.getY())
	}
	
	@Test
	public void testNearestNeighborQueuePop() {
		def list = [[new BigDecimal(1), new BigDecimal(2)], [new BigDecimal(1), new BigDecimal(5)],
					[new BigDecimal(3), new BigDecimal(2)], [new BigDecimal(5), new BigDecimal(6)],
					[new BigDecimal(7), new BigDecimal(1)], [new BigDecimal(7), new BigDecimal(4)],
					[new BigDecimal(8), new BigDecimal(8)]]
		def topNode = KDTreeFactory.createTreeFromBigDecimalList(list)
		def neighbor = new NearestNeighbor(1)
		def point = new Node(new BigDecimal(6), new BigDecimal(7))
		def nearestNeighbors = neighbor.neighborSearch(point, topNode, topNode);
		assertEquals(1, nearestNeighbors.size)
		
		def nearest = nearestNeighbors.poll()
		assertEquals(new BigDecimal(5), nearest.getX())
		assertEquals(new BigDecimal(6), nearest.getY())
	}
	
	@Test
	public void testNearestNeighborMultipleBest() {
		def list = [[new BigDecimal(1), new BigDecimal(2)], [new BigDecimal(1), new BigDecimal(5)],
					[new BigDecimal(3), new BigDecimal(2)], [new BigDecimal(5), new BigDecimal(6)],
					[new BigDecimal(7), new BigDecimal(1)], [new BigDecimal(7), new BigDecimal(4)],
					[new BigDecimal(8), new BigDecimal(8)]]
		def topNode = KDTreeFactory.createTreeFromBigDecimalList(list)
		def neighbor = new NearestNeighbor(3)
		def point = new Node(new BigDecimal(6), new BigDecimal(7))
		def nearestNeighbors = neighbor.neighborSearch(point, topNode, topNode);
		assertEquals(3, nearestNeighbors.size)
		
		def nearest = nearestNeighbors.poll()
		assertEquals(new BigDecimal(7), nearest.getX())
		assertEquals(new BigDecimal(4), nearest.getY())
		nearest = nearestNeighbors.poll()
		assertEquals(new BigDecimal(8), nearest.getX())
		assertEquals(new BigDecimal(8), nearest.getY())
		nearest = nearestNeighbors.poll()
		assertEquals(new BigDecimal(5), nearest.getX())
		assertEquals(new BigDecimal(6), nearest.getY())		
	}
}
