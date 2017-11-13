
## Recursion

```c++
int fact(int n) {
    if(n==0) return 1;
    return n*fact(n-1);
}

int fib(int n) {
    if(n <= 1) return n;
    if(memo[n] != 0) return memo[n];
    return memo[n] = fib(n-1) + fib(n-2);
}
```

## Stack

- LIFO Data structure that support push & pop
- Most recursion can be rewritten as stack
- Though it is a rare occasion when such rewriting is required

## Queue

- FIFO Data structure that support push & pop

## DFS

- Depth-First Search
- implicitly use queue to compute
- Question: Sum, LakeCount


## BFS
- Always search nearest first
- implicitly use queue to compute
- Compare to DFS
    + DFS can use recursion, easy to code and manage state, memory efficient
    + BFS add state into queue in order, need lots of memory
- Question: MazePaths


## Permutation for Special States

When state space is simple, can used permutation 

```c++
bool used[MAX_N]
int perm[MAX_N]
void permutation1(int pos, int n){
    if(pos==n) {
        // write current perm to somewhere
        return ;
    }
    for(int i=0;i<n;i++){
        if(!used[i]){
            perm[pos]=i
            used[i]=true
            permutation1(pos+1, n);
            used[i]=false
        }
    }
    return ;
}
```

## Prune

optimize exhaustive algorithm

e.g. stop further recursion when sum exceeds k