# Graph

Graph = Vertex + Edge

- Category
    + __Directed__: value, parent
        * vertex have in and out degree
        * acyclic map is called DAG
        * we can form a topological order for DAG
        * such problem can be solved by DP, called topological sort 
    + __Undirected__: relationship, routes
        * vertex can be adjacent
        * path connect sequence of vertex
        * path with same start & end forms a circle
        * edges for each vertex called degree
        * acyclic map is called tree or forest
        * a tree can be rooted, and become directed

- Representation
    + adjacent matrix
        * g[i][j] for vertex i & j
        * can find edge in O(1)
        * space complexity in O(V^2), bad when sparse
    + adjacent table
        * save list of edges in some data structure
        
- Graph search