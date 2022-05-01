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
        public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0 || inorder.length != preorder.length) {
            return null;
        }
            Map <Integer, Integer> inMap = new HashMap <Integer, Integer> ();

    for (int i = 0; i < inorder.length; i++) {
      inMap.put(inorder[i], i);
    }
        return buildTreeYouTube(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, inMap);
    }
    
     TreeNode buildTreeYouTube(int[] preorder, int preStart, int preEnd, int[]
  inorder, int inStart, int inEnd, Map < Integer, Integer > inMap) {
    if (preStart > preEnd || inStart > inEnd) return null;

    TreeNode root = new TreeNode(preorder[preStart]);
    int inRoot = inMap.get(root.val);
    int numsLeft = inRoot - inStart;

    root.left = buildTreeYouTube(preorder, preStart + 1, preStart + numsLeft, inorder, 
    inStart, inRoot - 1, inMap);
    root.right = buildTreeYouTube(preorder, preStart + numsLeft + 1, preEnd, inorder, 
    inRoot + 1, inEnd, inMap);

    return root;
  }

    public TreeNode buildTreeUtil(int[] preorder, int[] inorder) {
        TreeNode root = null;
        
            root = new TreeNode(preorder[0]);
            Integer index = findIndex(inorder, preorder[0]);
            if (index == null) {
                throw new UnsupportedOperationException();
            }
            int[] leftArr = Arrays.copyOfRange(inorder, 0, index);
            int[] rightArr = Arrays.copyOfRange(inorder, index + 1, inorder.length);
            if (leftArr.length == 1) {
                root.left = new TreeNode(leftArr[0]);
            } else if (leftArr.length > 1) {
                root.left = buildTreeUtil(Arrays.copyOfRange(preorder, 1, preorder.length), leftArr);
            }
            if (rightArr.length == 1) {
                root.right = new TreeNode(rightArr[0]);
            } else if (rightArr.length > 1) {
                root.right = buildTreeUtil(Arrays.copyOfRange(preorder, 1, preorder.length), rightArr);
            }
        return root;
    }

    private boolean matchReverse(int[] preorder, int[] inorder){
        int[] rev = new int[inorder.length];
        for (int i = 0, k=rev.length-1; i < rev.length; i++, k--) {
            rev[i] = inorder[k];
        }
        return Arrays.equals(rev, preorder);
    }

    private Integer findIndex(int arr[], int element) {
        for (int i = 0; i < arr.length; i++) {
            if (element == arr[i]) {
                return i;
            }
        }
        return null;
    }
}