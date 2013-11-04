import java.util.ArrayList;

public class LTTest{
	public static void main(String[] args){
		LTTest l = new LTTest();
		System.out.println(l.letterCombinations("99").toString());
	}
	public ArrayList<String> letterCombinations(String digits) {
        String[] dict = {"abc","def","ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ArrayList<String> r =new ArrayList<String>();
        if(digits == null || digits.length() == 0)
            return r;
        int level = 0;
        int[] last = new int[digits.length()];
        char[] cs = new char[digits.length()];
        while(level >= 0) {
            if(level == digits.length()) {
                for(int i = 0 ;i< digits.length(); i++){
                    cs[i] = dict[digits.charAt(i) - '2'].charAt(last[i]);
                }
                r.add(String.valueOf(cs));
                level--;
                last[level]++;
                continue;
            }
            char c = digits.charAt(level);
            String com = dict[c - '2'];
            if(last[level] >= 0 && last[level] < com.length()) {
                level++;
            }
            else {
                last[level] = 0;
                level--;
            }
        }
        return r;
    }
}