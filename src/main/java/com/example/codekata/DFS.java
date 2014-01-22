/**
 * 
 */
package com.example.codekata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author choesang
 * 
 */
public class DFS {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int pacman_r = in.nextInt();
		int pacman_c = in.nextInt();

		int food_r = in.nextInt();
		int food_c = in.nextInt();

		int r = in.nextInt();
		int c = in.nextInt();
		

		String grid[] = new String[r];

		for (int i = 0; i < r; i++) {
			grid[i] = in.next();
		}

		dfs(r, c, pacman_r, pacman_c, food_r, food_c, grid);
	}

	private static void dfs(int r, int c, int pacman_r, int pacman_c,
			int food_r, int food_c, String[] grid) {
		
//		Node[] adjacencyLists = new Node[r*c];
		Map<Position, Node> nodeMap = new HashMap<>();
		
		int currentNode = 0;
		for (int i = 0; i < grid.length; i++) {
			String currentRow = grid[i];
			for (int j = 0; j < grid[i].length(); j++) {
				char charValue = currentRow.charAt(j);
				if (charValue != '%') {
					Node node = new Node(i, j, charValue);
//					adjacencyLists[currentNode] = node;
					nodeMap.put(node.position, node);
					initializeNodesNeighbours(node, nodeMap, r, c);
					++currentNode;
					
				}
			}
		}
		
		Node root = nodeMap.get(new Position(pacman_r, pacman_c));
		Node food = nodeMap.get(new Position(food_r, food_c));
		
		findByDFS(root, food);
		findByBFS(root, food);
		
	}

	private static void initializeNodesNeighbours(Node n, Map<Position, Node> nodeMap, int r, int c) {
		List<Position> neighbourPositions = getNodesNeighbourPositions(n, r, c);
		Node neighbour;
		for(Position p : neighbourPositions) {
			neighbour = nodeMap.get(p);
			if(neighbour!= null) {
				n.addNeighbour(neighbour);
				neighbour.addNeighbour(n);
			}
		}
	}
	
	private static List<Position> getNodesNeighbourPositions(Node n, int r, int c) {
		Position above = new Position(n.position.r+1, n.position.c);
		Position below = new Position(n.position.r-1, n.position.c);
		Position right = new Position(n.position.r, n.position.c+1);
		Position left = new Position(n.position.r, n.position.c-1);
		
		List<Position> s = new ArrayList<>();
		
		if(isValidPosition(above, r, c)) s.add(above);
		if(isValidPosition(below, r, c)) s.add(below);
		if(isValidPosition(right, r, c)) s.add(right);
		if(isValidPosition(left, r, c)) s.add(left);
		
		return s;
	}
	
	private static boolean isValidPosition(Position p, int r, int c) {
		if(p.r < 0 || p.r > r) return false;
		if(p.c < 0 || p.c > c) return false;
		return true;
	}
	
	private static void findByDFS(Node root, Node food) {
		Stack stack = new Stack();
		stack.push(root);
		root.isVisited = true;
		while ( !stack.isEmpty() ) {
			Node node = (Node) stack.peek();
			Node child = node.getNextUnvisitedNeighbour();
			if ( child != null ) {
				child.isVisited = true;
				stack.push(child);
				if (child.value == '.') {
					break;
				}
			} else {
				stack.pop();
			}
		}
		
		System.out.println(stack);
		System.out.println(stack.size());
	}
	
	private static void findByBFS(Node root, Node food) {
		Queue queue = new LinkedList<>();
		queue.add(root);
		root.isVisited = true;
		while ( !queue.isEmpty() ) {
			Node node = (Node) queue.remove();
			Node child = null;
			
			while ( (child = node.getNextUnvisitedNeighbour()) != null ) {
				System.out.println(child);
				child.isVisited = true;
				queue.add(child);
				if (child.value == '.') {
					break;
				}
			}
		}
	}
}

class Node {
	Position position;
	Character value;
	boolean isVisited = false;
	Stack<Node> neighbours;
	
	public Node getNextUnvisitedNeighbour() {
		for(Node n : neighbours) {
			if(!n.isVisited) return n;
		}
		return null;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((position == null) ? 0 : position.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		return true;
	}

	public Node( int r, int c, Character charValue) {
		position = new Position(r, c);
		value = charValue;
		neighbours = new Stack<>();
	}

	public boolean hasNeighbour(Node neighbour) {
		return neighbours.contains(neighbour);
	}

	public void addNeighbour(Node node) {
		if(!hasNeighbour(node)) neighbours.add(node);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Node [position=" + position + ", value=" + value
				+ ", isVisited=" + isVisited + ", neighbours.size=" + neighbours.size() + "]";
	}
	
	
}

class Position {
	int r, c;
	
	public Position(int r, int c) {
		this.r = r;
		this.c = c;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + c;
		result = prime * result + r;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (c != other.c)
			return false;
		if (r != other.r)
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Position [r=" + r + ", c=" + c + "]";
	}
	
}