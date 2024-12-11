class Solution {
    public int compress(char[] chars) {
        int write = 0;
        int start = 0;

        for (int read = 0; read < chars.length; read++) {
        
            if (read + 1 == chars.length || chars[read] != chars[read + 1]) {
         
                chars[write++] = chars[start];
                
            
                int groupLength = read - start + 1;
                
          
                if (groupLength > 1) {
                    for (char digit : String.valueOf(groupLength).toCharArray()) {
                        chars[write++] = digit;
                    }
                }
                
           
                start = read + 1;
            }
        }
        
        return write;
    }
}
