/*
839. Similar String Groups

Two strings X and Y are similar
if we can swap two letters of X, so that it equals Y.

"tars" and "rats" are similar
"rats" and "arts" are similar,
but "star" is not similar to "tars", "rats", or "arts".

two connected groups by similarity:
{"tars", "rats", "arts"} and {"star"}.
Notice that "tars" and "arts" are in the same group
even though they are not similar.

Formally, each group is such that a word is in the group
if and only if it is similar to at least one other word in the group.

We are given a list A of unique strings.
Every string in A is an anagram of every other string in A.
How many groups are there?

A.length <= 2000
A[i].length <= 1000
A.length * A[i].length <= 20000
 */


// typical Union Find
def numSimilarGroups(A: Array[String]): Int = {

}


/*
class Solution {
public:

    vector<int> parent;

    void unite(int a, int b){
        int aa = find(a);
        int bb = find(b);

        parent[aa] = parent[bb];
    }

    int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);

        return parent[x];
    }

    bool good(const string &a, const string &b)
    {
        int count = 0;

        for (int i = 0; i < a.size(); ++i) {
            count +=  (a[i] != b[i]);
        }

        return count == 2;
    }

    int numSimilarGroups(vector<string>& A) {
        parent.resize(A.size());
        for (int i = 0; i < A.size(); ++i) {
            parent[i] = i;
        }


        for (int i = 0; i < A.size();++i) {
            for (int j = i+1; j < A.size(); ++j) {
                if (find(i) == find(j)) {
                    continue;
                }

                if (good(A[i], A[j])) {
                    unite(i, j);
                }
            }
        }

        set<int> s;

        for (int i = 0; i < A.size(); ++i) {
            s.insert(find(i));
        }

        return s.size();
    }
};
 */