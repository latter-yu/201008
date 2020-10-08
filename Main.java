import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
public class Main {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        // 输入两棵二叉树 A，B，判断 B 是不是 A 的子结构。
        // ps：我们约定空树不是任意一个树的子结构

        boolean ret = false;
        if (root2 != null && root1 != null) {
            if (root1.val == root2.val) {
                // 判断根节点下有没有子结构
                ret = isSubtree(root1, root2);
            }
            if (ret == false) {
                // 根节点下没有，判断左子树下有没有子结构
                ret = HasSubtree(root1.left, root2);
            }
            if (ret == false) {
                // 根节点和左子树都没有，判断右子树下有没有子结构
                ret = HasSubtree(root1.right, root2);
            }
        }
        return ret;
    }
    public boolean isSubtree(TreeNode root1,TreeNode root2) {
        // 子树的意思是包含了一个节点，就得包含这个节点下的所有节点。
        // 子结构的意思是包含了一个节点，可以只取左子树或者右子树，或者都不取。
        if (root1 == null && root2 != null) {
            return false;
        }
        if (root2 == null) {
            // 已经有根节点相同的前提了
            return true;
        }
        if (root1.val != root2.val) {
            // 需先判空再确定值是否相等，否则会有空指针异常
            return false;
        }
        return isSubtree(root1.left, root2.left) && isSubtree(root1.right, root2.right);
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        // 输入两个链表，找出它们的第一个公共结点。
        // 注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的

        // 通过 map 的特性实现
        ListNode cur1 = pHead1;
        ListNode cur2 = pHead2;
        Map<ListNode, Integer> map = new HashMap<>();
        while (cur1 != null) {
            map.put(cur1, 1);
            cur1 = cur1.next;
        }
        while (cur2 != null) {
            if (map.containsKey(cur2)) {
                return cur2;
            }
            cur2 = cur2.next;
        }
        return null;
    }
}

class Test {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        // 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
        // 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
        // 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.

        ArrayList<Integer> list = new ArrayList<> ();
        if (matrix.length == 0) {
            return list;
        }
        int xStart = 0;
        int xEnd = matrix[0].length - 1;
        int yStart = 0;
        int yEnd = matrix.length - 1;
        while (xStart <= xEnd && yStart <= yEnd) {
            if (xStart <= xEnd) {
                for (int i = xStart; i <= xEnd; i++) {
                    list.add(matrix[yStart][i]);
                }
            }
            if (yStart < yEnd) {
                for (int j = yStart + 1; j <= yEnd; j++) {
                    list.add(matrix[j][xEnd]);
                }
            }
            if (xStart < xEnd && yStart < yEnd) {
                for (int i = xEnd - 1; i >= xStart; i--) {
                    list.add(matrix[yEnd][i]);
                }
            }
            if (xStart < xEnd && yStart < yEnd) {
                for (int j = yEnd - 1; j > yStart; j--) {
                    list.add(matrix[j][xStart]);
                }
            }
            xStart++;
            xEnd--;
            yStart++;
            yEnd--;
        }
        return list;
    }
}