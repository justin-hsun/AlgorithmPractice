package Others;

// https://leetcode.com/problems/simplify-path/submissions/
// 71
// Straightforward
// edge cases matters

import java.util.*;

public class SimplifyPath {
    public String simplifyPath(String path) {
        String ret = "";
        Stack<String> stack = new Stack<>();
        var ps = path.split("/");
        for (var dir : ps) {
            if (dir.equals("") || dir.equals(".")) continue;
            if (dir.equals("..") && stack.isEmpty()) continue;
            if (dir.equals("..")) stack.pop();
            else stack.push(dir);
        }
        //System.out.println(stack.toString());
        while (!stack.isEmpty()) {
            if (ret.equals("")) ret = stack.pop();
            else ret = stack.pop() + "/" + ret;
        }

        return "/" + ret;
    }
}
