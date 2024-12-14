class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        
        for (int num : nums1) {
            set1.add(num);
        }
        
        for (int num : nums2) {
            set2.add(num);
        }
        
        List<List<Integer>> answer = new ArrayList<>();
        
        List<Integer> result1 = new ArrayList<>(set1);
        result1.removeAll(set2); 
        List<Integer> result2 = new ArrayList<>(set2);
        result2.removeAll(set1);  
        
        answer.add(result1);
        answer.add(result2);
        
        return answer;
    }
}