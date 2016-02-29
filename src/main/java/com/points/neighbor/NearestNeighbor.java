package com.points.neighbor;

import java.math.BigDecimal;
import java.util.PriorityQueue;

import com.points.kdTree.Node;

public class NearestNeighbor {
	private PriorityQueue<Node> nearestNeighbors;
	private final int MAX_NUM_NEIGHBORS;
	
	public NearestNeighbor(int maxNeighbors) {
		if (maxNeighbors == 0 ) {
			maxNeighbors = 1;
		}		
		MAX_NUM_NEIGHBORS = maxNeighbors;
		nearestNeighbors = new PriorityQueue<>(MAX_NUM_NEIGHBORS, Node.distComparator);
	}
	
	public int getMaxNumNeighbors() {
		return MAX_NUM_NEIGHBORS;
	}
	
	public PriorityQueue<Node> getNearestNeighbors() {
		return nearestNeighbors;
	}
	
	public PriorityQueue<Node> neighborSearch(Node user, Node currentNode, Node topNode ) {
		if (currentNode.getX() != null && currentNode.getY() != null ) {
			processLeafNode(user, currentNode);
			return nearestNeighbors;
		}
		
		boolean leftSearched = false;
		if ("x".equals(currentNode.getSplitAxis())) {
			if(user.getX().compareTo(currentNode.getSplitValue()) < 1  && currentNode.getLeftChild() != null ) {
				neighborSearch(user, currentNode.getLeftChild(), topNode);
				leftSearched = true;
			} 
			
			if(user.getX().compareTo(currentNode.getSplitValue()) > 0  && currentNode.getRightChild() != null ) {
				neighborSearch(user, currentNode.getRightChild(), topNode);
			} 
		} else {
			if(user.getY().compareTo(currentNode.getSplitValue()) < 1  && currentNode.getLeftChild() != null ) {
				neighborSearch(user, currentNode.getLeftChild(), topNode);
				leftSearched = true;
			} 
			
			if(user.getY().compareTo(currentNode.getSplitValue()) > 0  && currentNode.getRightChild() != null ) {
				neighborSearch(user, currentNode.getRightChild(), topNode);
			} 
		}
		
		traverseOtherChild(user, currentNode, leftSearched);
		
		return nearestNeighbors;
	}
	
	private void processLeafNode(Node user, Node currentNode ) {
		BigDecimal xDiff = user.getX().subtract(currentNode.getX()).abs();
		BigDecimal yDiff = user.getY().subtract(currentNode.getY()).abs();
		BigDecimal distance = xDiff.pow(2).add(yDiff.pow(2));
		
		if (nearestNeighbors.size() < MAX_NUM_NEIGHBORS ) {
			Node nextNearest = new Node(currentNode.getX(), currentNode.getY(), distance);
			nearestNeighbors.add(nextNearest);
			return;
		}
		
		if (distance.compareTo(nearestNeighbors.peek().getDistance()) < 0 ) {
			Node nextNearest = new Node(currentNode.getX(), currentNode.getY(), distance);
			nearestNeighbors.poll();
			nearestNeighbors.add(nextNearest);
		}
	}
	
	private void traverseOtherChild(Node user, Node topNode, boolean goRight) {
		if (nearestNeighbors.isEmpty() ) {
			return;
		}
		
		BigDecimal largestDistance = nearestNeighbors.peek().getDistance();
		BigDecimal centerDistance = topNode.getSplitValue().subtract(user.getX()).pow(2);
		
		if (centerDistance.compareTo(largestDistance) < 0 ) {
			if (goRight ) {
				neighborSearch(user, topNode.getRightChild(), topNode);
			} else {
				neighborSearch(user, topNode.getLeftChild(), topNode);
			}			
		}
	}

}
