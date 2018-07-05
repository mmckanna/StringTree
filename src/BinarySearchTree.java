import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class BinarySearchTree {

	public static Node root;

	public BinarySearchTree() {
		BinarySearchTree.root = null;
	}

	public boolean find(String id) {
		Node current = root;
		while (current != null) {
			if (current.equals(id)) {
				return true;
			} else if (current.data.compareTo(id) > 0) {
				current = current.left;
			} else {
				current = current.right;
			}
		}
		return false;
	}

	public void insert(String id) {
		Node newNode = new Node(id);
		if (root == null) {
			root = newNode;
			return;
		}

		Node current = root;
		Node parent = null;
		while (true) {
			parent = current;
			if (0 < current.data.compareTo(id)) {
				current = current.left;
				if (current == null) {
					parent.left = newNode;
					return;
				}
			} else {
				current = current.right;
				if (current == null) {
					parent.right = newNode;
					return;
				}
			}
		}
	}

	public void display(Node root) {
		if (root != null) {
			display(root.left);
			System.out.print(" " + root.data + "\n");
			display(root.right);
		}
	}

	public static void main(String arg[]) throws IOException {
		// setup bufferedReader to grab text from fruit.txt

		BufferedReader bufferedReader = new BufferedReader(new FileReader("FruitsAndVegetables.txt"));
		String lineText = null;

		ArrayList<String> fruitAndVeggies = new ArrayList<String>();

		while ((lineText = bufferedReader.readLine()) != null) {
			fruitAndVeggies.add(lineText);
		}

		// create a Binary Search Tree and populate with temp values to make sure it's
		// working.
		BinarySearchTree binaryTree = new BinarySearchTree();
		for (int i = 0; i < fruitAndVeggies.size(); i++) {
			binaryTree.insert(fruitAndVeggies.get(i));
		}
		
		binaryTree.display(root);

		System.out.println("");

		bufferedReader.close();
	}
}

class Node {
	String data;
	Node left;
	Node right;

	public Node(String id) {
		this.data = id;
		left = null;
		right = null;
	}
}