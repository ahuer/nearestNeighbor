package com.points.kdTree;

import java.math.BigDecimal;
import java.util.Comparator;

public class Node {
	private BigDecimal x;
	private BigDecimal y;
	private BigDecimal splitValue;
	private BigDecimal distance;
	
	private String splitAxis;
	
	private Node leftChild;
	private Node rightChild;
	
	private Node() {}

	public Node(BigDecimal x, BigDecimal y) {
		this.x = x;
		this.y = y;
	}
	
	public Node(BigDecimal x, BigDecimal y, BigDecimal distance) {
		this.x = x;
		this.y = y;
		this.distance = distance;
	}
	
	public Node(String splitAxis, BigDecimal splitValue) {
		this.splitAxis = splitAxis;
		this.splitValue = splitValue;
	}
	
	public BigDecimal getX() {
		return x;
	}
	public BigDecimal getY() {
		return y;
	}
	
	public BigDecimal getDistance() {
		return distance;
	}
	
	public String getSplitAxis() {
		return splitAxis;
	}
	
	public BigDecimal getSplitValue() {
		return splitValue;
	}
	
	public Node getLeftChild() {
		return leftChild;
	}
	
	public Node getRightChild() {
		return rightChild;
	}
	
	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}

	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}
	
	public boolean equals(Node other) {
		if (! ((this.getSplitAxis().compareTo(other.getSplitAxis()) == 0 &&
			this.getSplitValue().compareTo(other.getSplitValue()) == 0 ))) {
			return false;
		}
		
		boolean nullLeft = false;
		boolean nullRight = false;
		
		if (this.getLeftChild().getSplitValue() == null ) {
			if (! (other.getLeftChild().getSplitValue() == null) ) {
				return false;
			}
			nullLeft = true;
		}
		
		if (this.getRightChild().getSplitValue() == null ) {
			if (! (other.getRightChild().getSplitValue() == null) ) {
				return false;
			}
			nullRight = true;
		}
		
		if (!nullLeft ) {
			if (this.getLeftChild().getSplitValue().compareTo(other.getLeftChild().getSplitValue()) != 0 ) {
				return false;
			}
		}
		
		if (!nullRight ) {
			if (this.getRightChild().getSplitValue().compareTo(other.getRightChild().getSplitValue()) != 0 ) {
				return false;
			}
		}
		
		return true;
	}
	
	public int compareTo(Node other) throws ClassCastException {
		return this.compareTo(other);
	}
	
	public static Comparator xComparator = new Comparator<Object>() {
		@Override
		public int compare(Object node, Object other) {
			BigDecimal firstX = ((Node)node).getX();
			BigDecimal secondX = ((Node)other).getX();
			return firstX.compareTo(secondX);
		}		
	};
	
	public static Comparator yComparator = new Comparator<Object>() {
		@Override
		public int compare(Object node, Object other) {
			BigDecimal firstY = ((Node)node).getY();
			BigDecimal secondY = ((Node)other).getY();
			return firstY.compareTo(secondY);
		}		
	};
	
	public static Comparator distComparator = new Comparator<Object>() {
		@Override
		public int compare(Object node, Object other) {
			BigDecimal firstDist = ((Node)node).getDistance();
			BigDecimal secondDist = ((Node)other).getDistance();
			return secondDist.compareTo(firstDist);
		}
	};
	
}
