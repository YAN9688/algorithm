import java.util.*;

public class Main {
	static Node[] list;
	static StringBuilder sb;

	static class Node {
		int upper;
		Node left;
		Node right;

		Node(int upper) {
			this.upper = upper;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		int n = sc.nextInt();
		sc.nextLine();
		list = new Node[n];
		for (int i = 0; i < n; i++) {
			list[i] = new Node(i);
		}
		for (int i = 0; i < n; i++) {
			String line = sc.nextLine();
			int dot = '.' - 'A';
			int upper = line.charAt(0) - 'A';
			int left = line.charAt(2) - 'A';
			int right = line.charAt(4) - 'A';
			if (left != dot) {
				list[upper].left = list[left];
			}
			if (right != dot) {
				list[upper].right = list[right];
			}
		}
		pre(list[0]);
		sb.append("\n");
		in(list[0]);
		sb.append("\n");
		post(list[0]);

		System.out.println(sb.toString());

	}

	static void pre(Node node) {
		sb.append((char) (node.upper + 'A'));
		if (node.left != null)
			pre(node.left);
		if (node.right != null)
			pre(node.right);
	}

	static void in(Node node) {
		if (node.left != null)
			in(node.left);
		sb.append((char) (node.upper + 'A'));
		if (node.right != null)
			in(node.right);
	}

	static void post(Node node) {
		if (node.left != null)
			post(node.left);
		if (node.right != null)
			post(node.right);
		sb.append((char) (node.upper + 'A'));
	}
}
