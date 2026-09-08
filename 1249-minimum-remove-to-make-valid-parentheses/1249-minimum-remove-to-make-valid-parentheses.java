class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder result = new StringBuilder();
        int balance = 0;

        // First pass: remove invalid ')'
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                balance++;
            } else if (ch == ')') {
                if (balance == 0) {
                    continue; // Skip invalid ')'
                }
                balance--;
            }

            result.append(ch);
        }

        // Second pass: remove extra '(' from right to left
        StringBuilder answer = new StringBuilder();

        for (int i = result.length() - 1; i >= 0; i--) {
            char ch = result.charAt(i);

            if (ch == '(' && balance > 0) {
                balance--;
                continue; // Skip unmatched '('
            }

            answer.append(ch);
        }

        return answer.reverse().toString();
    }
}
