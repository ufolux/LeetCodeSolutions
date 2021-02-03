package Solutions.String.L482_LicenseKeyFormatting;

public class Solution {
    public String licenseKeyFormatting(String S, int K) {
        StringBuffer sb = new StringBuffer();
        int cnt = 0;
        for (int i = S.length() - 1; i >= 0; i--) {
            char c = S.charAt(i);
            if (cnt == K && c != '-') {
                sb.append('-');
                cnt = 0;
            }
            if (c >= 'a' && c <= 'z') {
                sb.append((char)(c - 32));
                cnt++;
            } else if ( (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9') ) {
                sb.append(c);
                cnt++;
            }
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.licenseKeyFormatting("2-5g-3-J", 2);
    }
}
