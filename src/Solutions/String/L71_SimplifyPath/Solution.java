package Solutions.String.L71_SimplifyPath;

import java.util.Stack;

public class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] paths = path.split("/");
        for (String s: paths) {
            if (!stack.isEmpty() && s.equals("..")) {
                stack.pop();
            } else if (s.length() > 0 && !s.equals("..") && !s.equals(".")) {
                stack.push(s);
            }
        }
        if (stack.isEmpty()) {
            stack.push("");
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stack.size(); i++) {
            sb.append("/").append(stack.get(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.simplifyPath("/../");
    }
}
