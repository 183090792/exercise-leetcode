package com.lyz.exerciseleetcode.hot_100.December_14;

import java.util.*;

/**
 * @author LYZ
 * @date 2020/12/14 16:32
 *
 * 3. 无重复字符的最长子串
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 示例 4:
 * 输入: s = ""
 * 输出: 0
 *
 * 提示：
 *
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NonRepeatingString3 {
    public static int lengthOfLongestSubstring(String s) {
        if(s==""){
            return 0;
        }
        int max = 0;
        int temp = 0;
        int temp1 = 1;
        Queue<Character> queue = new LinkedList<>();

        char[] chars = s.toCharArray();
        for (char aChar : chars) {

            boolean result = queue.contains(aChar);
            if(result){
                max= Math.max(max,temp);
                while (!queue.peek().equals(aChar)){
                    queue.poll();
                    temp1++;
                }
                temp=Math.max(queue.size(),temp1);
                queue.poll();
                temp1=1;
            }else {
                temp++;
            }
            queue.add(aChar);
        }
        max= Math.max(max,queue.size());
        return max;
    }

    public static void main(String[] args) {
//        String s = "pwwkew";
        String s = "ohomm";
        int i = lengthOfLongestSubstring(s);
        System.out.println(i);
    }
}
