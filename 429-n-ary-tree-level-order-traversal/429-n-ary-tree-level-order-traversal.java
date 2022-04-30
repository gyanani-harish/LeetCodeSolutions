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
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> answer = new LinkedList<>();
        if(root == null){
            return answer;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int count = q.size();
            List<Integer> subList = new LinkedList<>();
            for(int i =0;i<count;i++){
                Node curr = q.poll();
                subList.add(curr.val);
                if(curr.children!=null){
                    for(Node child : curr.children){
                        if(child!=null){
                            q.add(child);
                        }
                    }
                }
            }    
            answer.add(subList);
        }
        return answer;
    }
}