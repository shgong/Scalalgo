

- Tree
    + Structure: Root, Edge, Node, Leaf
    + Relationship: Parent, Sibling, Children
    
- Heap / Priority Queue
    + support operation: insert value, get min value and delete
    + Heap is a binary tree that children has larger value than parents
    + whenever a new value comes
        * add to the end
        * swap triangles up until in order
    + complexity: O(logn) ~ tree depth
    + alternative representation: array, 2*i+1 / 2*i+2 for children
    
- Binary Search Tree
    + property: smaller left child & larger right child
    + operations: 
        * find value: follow the path
        * insert value
        * delete value: promote one branch when other is empty, or promote rightmost child of left branch
    + complexity: O(logn)
    + balance
        * insert by 1,2,3 order will generate unbalanced tree
        * use pivot rotate to keep balance
        * use std lib if possible, treemap/treeset use Red Black tree

- Std/Collection
    + Set
    + Map
    + TreeSet
    + TreeMap
    
- Union-Find Sets
    + operations
        * find if a,b belong to same group
        * merge the group that a and b in, use tree rank to decide how to merge
    + compress the path when following the path up, directly link to root
    + O(a(n)), a is inverse function of Ackermann function, faster than O(log(n))
    