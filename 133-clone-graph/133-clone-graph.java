/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        Queue<Node> oldQueue = new LinkedList<>();
        oldQueue.add(node);
        HashSet<Node> isVisited = new HashSet<>();
        isVisited.add(node);
        ArrayList<Node> list = new ArrayList<>();
        HashMap<Integer, Node> map = new HashMap<>();
        while (!oldQueue.isEmpty()) {
            Node oldPollNode = oldQueue.poll();
            if(oldPollNode == null){
                continue;
            }
            Node newNode;
            if (map.containsKey(oldPollNode.val)) {
                newNode = map.get(oldPollNode.val);
            } else {
                newNode = new Node(oldPollNode.val);
                map.put(newNode.val, newNode);
            }

            list.add(newNode);
            List<Node> neighbors = oldPollNode.neighbors;

            if (neighbors != null) {
                ArrayList<Node> newNeighbors = new ArrayList<>(neighbors.size());
                for (Node neighbor : neighbors) {
                    if (!isVisited.contains(neighbor)) {
                        oldQueue.add(neighbor);
                        isVisited.add(neighbor);
                    }
                    if (map.containsKey(neighbor.val)) {
                        newNeighbors.add(map.get(neighbor.val));
                    } else {
                        Node newNewNode = new Node(neighbor.val);
                        newNeighbors.add(newNewNode);
                        map.put(neighbor.val, newNewNode);
                    }
                }
                newNode.neighbors = newNeighbors;
            }
        }
        return list.size() == 0 ? null : list.get(0);
    }
}