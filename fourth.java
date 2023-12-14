class Solution {
    private final int M = (int)1e9 + 7;

    private int mPow(int x, int y) {
        int ans = 1;
        while (y > 0) {
            if ((y & 1) == 1)
                ans = (int)(((long)ans * x) % M);

            x = (int)(((long)x * x) % M);
            y >>= 1;
        }
        return ans;
    }
    
    public int numberOfGoodPartitions(int[] nums) {
        int n = nums.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            map.put(i, i);
        }
        Map<Integer, List<Integer>> mp = new HashMap<>();
        for(int i = 0; i < n; i++) {
            mp.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        for (Map.Entry<Integer, List<Integer>> entry : mp.entrySet()) {
            List<Integer> list = entry.getValue();
            if(list.get(0) < list.get(list.size() - 1)) {
                combine(list.get(0), list.get(list.size() - 1), map);
            }
        }
        return mPow(2, map.size() - 1);
    }
    
    private void combine(int l, int r, TreeMap<Integer, Integer> map) {
        Map.Entry<Integer, Integer> entry = map.floorEntry(l);
        int key = entry.getKey();
        int value = entry.getValue();
        List<Integer> list = new ArrayList<>();
        while (entry != null && entry.getKey() <= r) {
            value = Math.max(value, entry.getValue());
            list.add(entry.getKey());
            entry = map.higherEntry(entry.getKey());
        }
        for (Integer li : list) {
            map.remove(li);
        }
        map.put(key, value);
    }
}
