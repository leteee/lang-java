package com.example.backtrack;

import java.util.ArrayList;
import java.util.List;

public class _93 {

    static final int SEG_COUNT = 4;

    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        int[] segments = new int[SEG_COUNT];
        dfs(s, 0, 0, segments, ans);
        return ans;
    }

    public void dfs(String s, int segStart, int segId, int[] segments, List<String> ans) {
        if (segId == SEG_COUNT) {
            if (segStart == s.length()) {
                StringBuffer ipAddr = new StringBuffer();
                for (int i = 0; i < SEG_COUNT; i++) {
                    ipAddr.append(segments[i]);
                    if (i != SEG_COUNT - 1) {
                        ipAddr.append(".");
                    }
                }
                ans.add(ipAddr.toString());
            }
            return;
        }

        if (segStart == s.length()) {
            return;
        }

        if (s.charAt(segStart) == '0') {
            segments[segId] = 0;
            dfs(s, segStart + 1, segId + 1, segments, ans);
            return;
        }

        int addr = 0;
        for (int segEnd = segStart; segEnd < s.length(); segEnd++) {
            addr = addr * 10 + (s.charAt(segEnd) - '0');
            if (addr > 0 && addr <= 0xFF) {
                segments[segId] = addr;
                dfs(s, segEnd + 1, segId + 1, segments, ans);
            } else {
                break;
            }
        }
    }

    public void test() {
        String s = "25525511135";
        List<String> ans = restoreIpAddresses(s);
        ans.forEach(System.out::println);
    }


    public static void main(String[] args) {
        new _93().test();
    }
}
