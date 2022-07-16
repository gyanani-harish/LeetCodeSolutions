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
    public List<Integer> preorder(Node root) {
        List<Integer> ansList = new LinkedList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node polledNode = stack.pop();
            if(polledNode == null){
                continue;
            }
            ansList.add(polledNode.val);
            for(int i = polledNode.children.size()-1;i>-1;i--){
                Node child = polledNode.children.get(i);
                if(child!=null){
                    stack.push(child);
                }
            }
        }
        return ansList;
    }
}