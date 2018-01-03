// C++
/*
class Solution {
  public:
    int hammingWeight (uint32_t n) {
      int k = 0;
      while (n != 0) {
        k += n & 1;
        n >>= 1;
      }
      return k;
    }
}