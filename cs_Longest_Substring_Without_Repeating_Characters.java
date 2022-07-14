class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int left = 0;
        int right = 0;
        int max = 0;
        Map<Character, Integer> charIndexMap = new HashMap<>();
        
        //abcabcbb
        //aaaa
        while (left >= 0 && left <= right && right < s.length()) {
            
            Character rightChar = s.charAt(right);
            
            if (!charIndexMap.containsKey(rightChar) || charIndexMap.get(rightChar) < left) {
                charIndexMap.put(rightChar, right);
                max = Math.max(right - left + 1, max);
                right += 1;
            }
            else {
                int match = charIndexMap.get(rightChar);
                left = match + 1;
            }
        }
        
        return max;
    }
}
