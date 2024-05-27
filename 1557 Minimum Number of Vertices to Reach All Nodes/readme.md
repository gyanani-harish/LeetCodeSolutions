Understanding the Problem
Given a directed acyclic graph (DAG) with n vertices and a list of directed edges, we need to find the smallest set of vertices from which all nodes in the graph are reachable. The problem guarantees that there is a unique solution.

Key Insight
In a DAG, nodes with no incoming edges (in-degree 0) are critical starting points. These nodes cannot be reached from any other nodes, meaning that if we don't start from these nodes, we won't be able to reach them at all. Thus, to ensure that all nodes are reachable, we must include all nodes with no incoming edges in our set.

Why This Works
Reachability:

If a node has no incoming edges, it means no other node points to it. Therefore, it must be one of the starting points to reach other nodes.
Including all nodes with no incoming edges ensures that we have starting points that can potentially reach all other nodes through directed paths.
Minimal Set:

Including any node with incoming edges would be redundant because there is already a path from one of the zero in-degree nodes to this node.
Therefore, the minimal set of vertices from which all nodes are reachable is precisely the set of nodes with zero in-degree.
Correct Approach:
Identify all nodes with zero in-degree and include them in the result set.
