// 777. Swap Adjacent in LR String
/*
In a string composed of 'L', 'R', and 'X' characters,
like "RXXLRXRXL",

a move consists of
either replacing one occurrence of "XL" with "LX",
or replacing one occurrence of "RX" with "XR".

Given the starting string start and the ending string end,
return True if and only if there exists a sequence of moves to
transform one string to the other.

X can not right across R, left across L
R, L relative position the same

count RLX
RRRRRRRX -> XRRRRRRR
 */

def canTransform(start: String, end: String): Boolean = {
  val l = start.length
  if (end.length != l) return false

  val sx = start.filter(_ != 'X')
  val ex = end.filter(_ != 'X')
  if (sx != ex) return false

  var l1 = 0
  var x1 = 0
  var r1 = 0
  var l2 = 0
  var r2 = 0
  var x2 = 0

  for (i <- 0 until l) {
    start(i) match {
      case 'X' => x1 += 1
      case 'L' => l1 += 1
      case 'R' => r1 += 1
    }
    end(i) match {
      case 'X' => x2 += 1
      case 'L' => l2 += 1
      case 'R' => r2 += 1
    }

    if (x1 == x2 && l1 == l2 && r1 == r2) {
      x1 = 0
      x2 = 0
      l1 = 0
      l2 = 0
      r1 = 0
      r2 = 0
    } else if((l1>0 || l2>0) && (r1>0 || r2>0)) {
      return false
    }else if(l1>0 && l1>l2) {
      return false
    }else if(r2>0 && r2>r1) {
      return false
    }
  }

  true
}

val start = "XXRXXLXXXX"
val end =   "XXXXRXXLXX"
//"XXRXXLXXXX"
canTransform(start,end)

canTransform("RXXLRXRXL",  "XRLXXRRLX")

canTransform("XLXRRXXRXX" ,
             "LXXXXXXRRR")


/*


int dx[] = {-1, 0, 0, 1};
int dy[] = {0, -1, 1, 0};
class Solution {
public:
  bool go(const vector<vector<int>>& g, vector<vector<int>>& u, int x, int y, int t) {
    if (x<0||y<0||x>=g.size()||y>=g.size()||g[x][y]>t||u[x][y]) {
      return 0;
    }
    if (x==0&&y==0) return 1;
    u[x][y]=1;
    for (int z = 0; z < 4; ++z) {
      int nx = x + dx[z], ny = y + dy[z];
      if (go(g, u, nx, ny, t)) {
        return 1;
      }
    }
    return 0;
  }
  int swimInWater(vector<vector<int>>& g) {
    int n = g.size();
    for (int t = 0; t < n *n; ++t) {
      vector<vector<int>> u(n, vector<int>(n, 0));
      if (go(g, u, n - 1, n - 1, t)) {
        return t;
      }
    }
    throw;
  }
};

 */