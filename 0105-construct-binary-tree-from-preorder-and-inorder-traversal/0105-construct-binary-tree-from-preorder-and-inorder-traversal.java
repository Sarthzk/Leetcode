/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int preIndex = 0;
    HashMap<Integer, Integer> inorderIndex = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int left = 0;
        int right = inorder.length - 1;

        for(int i = 0; i <= right; i++){
            inorderIndex.put(inorder[i], i);
        }

        return build(preorder, left, right);
        
    }

    private TreeNode build(int[] preorder, int left, int right){
        if(left > right) return null;

        int rootVal = preorder[preIndex];
        preIndex++;

        TreeNode node = new TreeNode(rootVal);

        int mid = inorderIndex.get(rootVal);

        node.left = build(preorder, left, mid - 1);
        node.right = build(preorder, mid + 1, right);

        return node;
    }
    
}