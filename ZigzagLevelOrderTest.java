import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ZigzagLevelOrderTest {
	public static void main(String[] args) {
		//��������
		BinaryTree bt=new BinaryTree();
		//
		System.out.println(zigzagLevelOrder(bt.root));
		
	}
	public static List<List<Integer>> zigzagLevelOrder(TreeNode root){
		List<List<Integer>> ans=new ArrayList<List<Integer>>();
		Stack<TreeNode> stPre=new Stack<>();//����һ��ջ
		Stack<TreeNode> stCur=new Stack<>();//����һ��ջ
		int count=1;//����������ż
		if (root==null) {
			return ans;
		}
		stCur.push(root);
		while(!stCur.empty()) {
			List<Integer> subans=new ArrayList<>();
			Stack<TreeNode> temp = new Stack<>();
			
			while(!stCur.empty()) {
				temp.push(stCur.pop());
			}
			while(!temp.empty()) {
				stPre.push(temp.pop());
			}
			while(!stPre.empty()) {//�����б�
				//����һ��ѹ��ջ�У�����ż
				if (count%2==1) {//����ʱ
					if (stPre.peek().left!=null) {
						stCur.push(stPre.peek().left);
					}
					if (stPre.peek().right!=null) {
						stCur.push(stPre.peek().right);
					}
				} else {//ż��ʱ
					if (stPre.peek().right!=null) {
						stCur.push(stPre.peek().right);
					}
					if (stPre.peek().left!=null) {
						stCur.push(stPre.peek().left);
					}
				}
				subans.add(stPre.pop().val);
			}
			count++;
			ans.add(subans);
		}
		return ans;
	}
	
}
