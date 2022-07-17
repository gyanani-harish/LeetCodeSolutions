/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> postorder(Node root) {
        //1st child, 2nd and so on
        return withForLoop(root);
    }
    private List<Integer> withForLoop(Node root){
        List<Integer> ansList = new ArrayList<>();
        if(root == null){
            return ansList;
        }
        Stack<Node> stack = new Stack<>();
        Set<Node> isVisited = new HashSet<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node topNode = stack.peek();
            if(isLeafNode(topNode) || isAllChildrenVisited(isVisited, topNode)){
                //if leaf node or all children printed then print it
                ansList.add(topNode.val);
                isVisited.add(topNode);
                stack.pop();
            } else {
                for(int i = topNode.children.size()-1;i>-1;i--){
                    Node child = topNode.children.get(i);
                    if(child!=null){
                        stack.push(child);
                    }
                }
            }
        }
        return ansList;
    }
    private boolean isLeafNode(Node root){
        return root.children == null || root.children.size() == 0;
    }
    private boolean isAllChildrenVisited(Set<Node> isVisited, Node node){
        //if(node == null){
        //    return new NullPointerExcception("node is null");
        //}
        
        for(int i = node.children.size()-1;i>-1;i--){
            Node child = node.children.get(i);
            if(!isVisited.contains(child)){
                return false;
            }
        }
        return true;
    }
}