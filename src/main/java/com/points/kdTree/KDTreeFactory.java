package com.points.kdTree;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KDTreeFactory {
	
	private KDTreeFactory() {}
	
	public static Node createTreeFromBigDecimalList(List<List<BigDecimal>> treeList) {
		if (treeList == null ) {
			return null;
		}
		
		List<Node> nodeList = new ArrayList<>();
		
		for (List<BigDecimal> location : treeList ) {
			if (location.size() != 2 ) {
				continue;
			}
			BigDecimal x = location.get(0);
			BigDecimal y = location.get(1);
			Node node = new Node(x,y);
			nodeList.add(node);
		}
		
		if (nodeList.size() == 0 ) {
			return null;
		}
		
		return createTreeFromNodeList(nodeList, "x");
	}
	
	public static Node createTreeFromNodeList(List<Node> nodeList, String axis) {
		if (nodeList == null || nodeList.isEmpty() || axis == null) {
			return null;
		}
		
		if (nodeList.size() == 1 ) {
			return nodeList.get(0);
		}
		
		BigDecimal splitValue = new BigDecimal(2.0);
		String nextAxis = axis;
		int midPoint = nodeList.size() / 2;
		if (nodeList.size() % 2 == 0 ) { midPoint -= 1; }		
		
		if ("x".equals(axis) ) {
			Collections.sort(nodeList, Node.xComparator);
			splitValue = nodeList.get(midPoint).getX();
			nextAxis = "y";
		}
		if ("y".equals(axis) ) {
			Collections.sort(nodeList, Node.yComparator);
			splitValue = nodeList.get(midPoint).getY();
			nextAxis = "x";
		}
		
		Node nextNode = new Node(axis,splitValue);
		
		nextNode.setLeftChild(createTreeFromNodeList(nodeList.subList(0, midPoint + 1), nextAxis));
		nextNode.setRightChild(createTreeFromNodeList(nodeList.subList(midPoint + 1, nodeList.size()), nextAxis));			
		
		return nextNode;
	}	

}
