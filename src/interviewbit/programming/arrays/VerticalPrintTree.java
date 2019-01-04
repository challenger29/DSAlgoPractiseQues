package interviewbit.programming.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Node{
	int data;
	Node left;
	Node right;
}
public class VerticalPrintTree {
	
	static Map<Integer , List<Node>> map = new HashMap<>();
	static void printVertical(Node root){
		printUtil(root , 0);
		map.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));	
		for(Map.Entry<Integer, List<Node>> entry : map.entrySet()){
			List<Node> nodes = entry.getValue();
			for(Node node :  nodes){
				System.out.print(node.data + " ");
			}
			
		}
	}
	static void printUtil(Node node , int side){
		if(node != null){
			if(map.containsKey(side)){
				List<Node> nodes = map.get(side);
				nodes.add(node);
				map.remove(side);
				map.put(side, nodes);
			}
			else{
				List<Node> nodes = new ArrayList<>();
				nodes.add(node);
				map.put(side, nodes);
			}
			printUtil(node.left , side -1);
			printUtil(node.right , side +1);
		}
	}

	
	public static void main(String[] args) {
		
		Node root = new Node();
		root.data = 1;
		Node left = new Node();
		left.data = 2;
		Node right = new Node();
		right.data = 3;
		Node rightL = new Node();
		rightL.data = 5;
		root.left = left;
		right.left = rightL;
		root.right = right;
		printVertical(root);
		
	}
}
