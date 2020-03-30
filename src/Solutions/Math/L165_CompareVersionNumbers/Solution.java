package Solutions.Math.L165_CompareVersionNumbers;

class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int len = Math.max(v1.length, v2.length);
        for (int i = 0; i < len; i++) {
            int a = 0, b = 0;
            if (i < v1.length) {
                a = new Integer(v1[i]);
            }
            if (i < v2.length) {
                b = new Integer(v2[i]);
            }
            if (a > b) {
                return 1;
            } else if (a < b) {
                return -1;
            } else {
                continue;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.compareVersion("07.5.6.4", "7.5.3");
    }
}
