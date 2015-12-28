package com.points.kdTree;

import java.math.BigDecimal;
import java.util.Comparator;

public class Node {
	private BigDecimal x;
	private BigDecimal y;
	private BigDecimal splitValue;
	
	private String splitAxis;
	
	private Node leftChild;
	private Node rightChild;
	
	private Node() {}

	public Node(BigDecimal x, BigDecimal y) {
		this.x = x;
		this.y = y;
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
	
}
