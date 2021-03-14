import java.util.ArrayList;
import java.util.List;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

	@Override
	public String toString() {
		return "TreeNode [val=" + val + ", left=" + left + ", right=" + right + "]";
	}

}

public class AllPossibleFullBinaryTree {

	public static List<TreeNode> allPossibleFBT(int N) {
		List<TreeNode> res = new ArrayList<>();
		if (N == 1) {
			res.add(new TreeNode(0));
			return res;
		}
		N = N - 1;
		for (int i = 1; i < N; i += 2) {
			List<TreeNode> left = allPossibleFBT(i);
			List<TreeNode> right = allPossibleFBT(N - i);
			for (TreeNode nl : left) {
				for (TreeNode nr : right) {
					TreeNode cur = new TreeNode(0);
					cur.left = nl;
					cur.right = nr;
					res.add(cur);
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(allPossibleFBT(5));
	}
}
