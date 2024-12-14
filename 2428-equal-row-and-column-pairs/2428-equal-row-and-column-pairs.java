class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        
        Map<List<Integer>, Integer> rowCount = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(grid[i][j]);
            }
            rowCount.put(row, rowCount.getOrDefault(row, 0) + 1);
        }
        
        Map<List<Integer>, Integer> colCount = new HashMap<>();
        for (int j = 0; j < n; j++) {
            List<Integer> col = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                col.add(grid[i][j]);
            }
            colCount.put(col, colCount.getOrDefault(col, 0) + 1);
        }
        
        int result = 0;
        for (Map.Entry<List<Integer>, Integer> entry : rowCount.entrySet()) {
            List<Integer> row = entry.getKey();
            if (colCount.containsKey(row)) {
                result += entry.getValue() * colCount.get(row);
            }
        }
        
        return result;
    }
}
