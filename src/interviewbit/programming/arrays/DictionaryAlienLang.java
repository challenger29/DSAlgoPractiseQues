package interviewbit.programming.arrays;

import java.util.LinkedList;
import java.util.Stack;

class Graph{
	private LinkedList<Integer>[] adjacencyList;
	
	Graph(int n){
		adjacencyList = new LinkedList[n];
		for(int i = 0 ; i < n ; i++) {
			adjacencyList[i] = new LinkedList<>();
		}
	}
	public void addEdge(int startVertex , int endVertex) {
		adjacencyList[startVertex].add(endVertex);
	}
	public int getNoOfVertices() {
		return adjacencyList.length;
	}
	
	public void topologicalSort() {
		Stack<Integer> stack = new Stack<>();
		boolean[] visited = new boolean[adjacencyList.length];
		for(int i = 0 ; i < getNoOfVertices() ; i++) {
			if(!visited[i]) {
				topologicalSortUtil(i , visited, stack);
			}
		}
		while(!stack.isEmpty()) {
			System.out.print((char)('a' + stack.pop()) + " "); 
		}
	}
	private void topologicalSortUtil(int currentVertex, boolean[] visited, Stack<Integer> stack) {
		visited[currentVertex] = true;
		for(Integer vertex : adjacencyList[currentVertex]) {
			if(!visited[vertex.intValue()]) {
				topologicalSortUtil(vertex.intValue(),visited , stack);
			}
		}
		stack.push(currentVertex);
		
	}
}
public class DictionaryAlienLang {

	public static void main(String[] args) {
	   String[] words = {"caa", "aaa", "aab"}; 
	   printOrder(words, 3); 
	}

	private static void printOrder(String[] words, int n) {
		Graph g = new Graph(n);
		
		for(int i = 0 ; i < words.length-1 ; i++) {
			String word1 = words[i];
			String word2 = words[i+1];
			for(int j = 0 ; j <Math.min(word1.length(), word2.length()) ; j++) {
				if(word1.charAt(j) != word2.charAt(j)) {
					g.addEdge(word1.charAt(j) -'a', word2.charAt(j) -'a');
					break;
				}
			}
		}
		g.topologicalSort();
		
	}
}
