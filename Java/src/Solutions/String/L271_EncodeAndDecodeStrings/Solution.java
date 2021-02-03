package Solutions.String.L271_EncodeAndDecodeStrings;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String encode(List<String> strs) {
        if (strs == null || strs.size() == 0) return null;
        StringBuilder header = new StringBuilder();
        StringBuilder body = new StringBuilder();
        for (int i = 0; i < strs.size(); i++) {
            header.append(strs.get(i).length());
            if (i != strs.size() - 1) {
                header.append(",");
            }
            body.append(strs.get(i));
        }

        StringBuilder sb = new StringBuilder();
        sb.append(header);
        sb.append(" ");
        sb.append(body);
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        int i = 0;
        while (s.charAt(i++) != ' ');
        String lens = s.substring(0, i - 1);
        String[] lensArr = lens.split(",");
        for (String len: lensArr) {
            Integer l = Integer.valueOf(len);
            String str = i < s.length() ? s.substring(i, i + l) : "";
            i = i + l;
            res.add(str);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> input = new ArrayList<>();
        input.add("");
        input.add("");
        String encode = s.encode(input);
        List<String> list = s.decode(encode);
    }
}
