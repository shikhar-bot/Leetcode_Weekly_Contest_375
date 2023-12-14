class Solution {
    public List<Integer> getGoodIndices(int[][] variables, int target) {
        List<Integer> list = new ArrayList<>();
        int k = 0;
        for (int[] x : variables) {
            int a = x[0], b = x[1], c = x[2], d = x[3];
            int n1 = 1;
            for (int i = 0; i < b; ++i) {
                n1 = (n1 * a) % 10;
            }
            int n2 = 1;
            for (int i = 0; i < c; ++i) {
                n2 = (n2 * n1) % d;
            }
            if (n2 == target) {
                list.add(k);
            }
            k++;
        }
        return list;
    }
}
