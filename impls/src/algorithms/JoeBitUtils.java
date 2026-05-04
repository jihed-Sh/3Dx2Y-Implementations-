package algorithms;

public class JoeBitUtils {

    public boolean isPowerOfTwo(int n) {
        return (n > 0) && ((n & (n - 1)) == 0);
    }

    // Kernighan’s Algorithm: O(number of set bits)
    public int countSetBits(int n) {
        int count = 0;
        while (n != 0) {
            n &= (n - 1); // Clears the least significant set bit
            count++;
        }
        return count;
    }

    public int getRightMostSetBit(int n) {
        return n & (-n);
    }

    public void xorSwap(int a, int b) {
        if (a == b) return;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
    }
}
