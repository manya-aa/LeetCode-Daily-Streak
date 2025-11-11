
class Solution {

    int sol(Pair<Integer, Integer>[] pair, int m, int n, int i) {
        if (i == pair.length || (m == 0 && n == 0)) return 0;

        int take = 0;
        if (pair[i].getKey() <= m && pair[i].getValue() <= n) {
            take = 1 + sol(pair, m - pair[i].getKey(), n - pair[i].getValue(), i + 1);
        }

        int simp = sol(pair, m, n, i + 1);
        return Math.max(take, simp);
    }

    public int findMaxForm(String[] strs, int m, int n) {
      
        Pair<Integer, Integer>[] pair = new Pair[strs.length];

        for (int i = 0; i < strs.length; i++) {
            int zero = 0, one = 0;
            for (int j = 0; j < strs[i].length(); j++) {
                if (strs[i].charAt(j) == '0') zero++;
                else one++;
            }
            pair[i] = new Pair<>(zero, one);
        }

        return sol(pair, m, n, 0);
    }
}
