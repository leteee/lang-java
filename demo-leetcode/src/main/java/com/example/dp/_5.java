package com.example.dp;

public class _5 {

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        // dp[i][j]表示s[i...j]是否回文字符串
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();

        // 在状态转移方程中，我们是从长度较短的字符串向长度较长的字符串进行转移的
        for (int L = 2; L <= len; L++) {
            for (int i = 0; i < len; i++) {
                // 由L确定右边界，j-i+1=L
                int j = L + i - 1;
                if (j >= len) {
                    break;
                }
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }

        return s.substring(begin, begin + maxLen);
    }

    public static void main(String[] args) {
        String s = "babad";
        String ans = new _5().longestPalindrome(s);
        System.out.println("bab".equalsIgnoreCase(ans));
    }
}
