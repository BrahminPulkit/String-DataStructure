package Stringses;

public class String_Question {
    public static void main(String[] args) {
        /*int[] freq = fre("aabbcc");
        for (int i = 0; i <freq.length ; i++) {
            if (freq[i] > 0){
                System.out.println((char) ('a'+i));
                System.out.println(freq[i]);
            }*
        }*/
        String str = "abccd";
        for (int s = 0; s < str.length(); s++) {
            System.out.println(str.charAt(s));
        }

    }
    public static void substring(String str){
        for (int i = 0; i <str.length() ; i++) {
            for (int j = i+1; j <str.length() ; j++) {
                System.out.println(str.substring(i , j));
            }
        }
    }
    public static StringBuilder removeDuplicates(String str){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i <str.length() ; i++) {
            char ch = str.charAt(i);
            // finding the ch after the current position
            int index = str.indexOf(ch, i+1);
            if (index == -1){
                builder.append((char) ch);
            }
        }
        return builder;
    }
    public static boolean palindrome(String str){
        int start = 0;
        int end = str.length()-1;
        while (start < end){
            if (str.charAt(start)!= str.charAt(end)){
                return false;
            }else {
                start ++ ;
                end -- ;
            }
        }
        return true;
    }
    public static StringBuilder toggle(String str){
        StringBuilder builder = new StringBuilder(str);
        for (int i = 0; i <str.length() ; i++) {
            char ch = str.charAt(i);
            if (ch >= 'a' && ch <='z'){
                ch = (char)(ch -32 );
            }else ch = (char) (ch + 32);
            builder.setCharAt(i,ch);
        }
        return builder;
    }
    public static StringBuilder assiDifference(String str){
        StringBuilder builder = new StringBuilder(str);
        builder.append(str.charAt(0));
        for (int i = 1; i <str.length() ; i++) {
            char ch1 =  str.charAt(i);
            char ch2 = str.charAt(i-1);
            int diff = Math.abs(ch1-1-ch2);
            builder.append(diff);
            builder.append(ch1);
        }
        return builder;
    }
    public static String oddEven(String str){
        StringBuilder builder = new StringBuilder(str);
        for (int i = 0; i <str.length(); i++) {
            if (i%2 == 0){
                builder.append((char)str.charAt(i));
            }else {
                builder.append((char)str.charAt(i)+1);
            }
        }
        return builder.toString();
    }
    public static void sumofString(int process , String unprocess){
        if (unprocess.isEmpty()){
            System.out.println(process);
            return;
        }
        char ch = unprocess.charAt(0);
        unprocess = unprocess.substring(1);
        if (ch >= 47 && ch <=57){
            sumofString(process + (ch-48) , unprocess);
        }else {
            sumofString(process , unprocess);
        }
    }
    public static void stringToInt(String str , int i){
        if (str.length() == 0){
            System.out.println(i);
            return;
        }
        char ch = str.charAt(0);
        str = str.substring(1);
        i = i * 10 + (ch - 48);
        stringToInt(str , i);
    }
    public static String reverse(String str){
        if (str.isEmpty()){
            return str;
        }
        return reverse(str.substring(1)) +str.charAt(0);
    }
    public static boolean checkReverse(String str1 , String str2 ){
        if (str1.length() != str2.length()){
            return false;
        }
        for (int i = 0; i < str1.length() ; i++) {
            if (str1.charAt(i) != str2.charAt(str2.length()-i-1));
            return false;
        }
        return true;
    }
    public static int[] fre(String str){
        int[] arr = new int[26];
        for (int i = 0; i <str.length() ; i++) {
            char ch = str.charAt(i);
            arr[ch - 'a']++;
        }
        return arr;
    }
    public static String addStar(String process, String str ,int i){
        String proc ;
        if (i == str.length()-1){
            return process + str.charAt(1);
        }
        if (str.charAt(i) == str.charAt(i+1)){
            proc =  process + str.charAt(i) + '*';
        }
        else {
            proc = process + str.charAt(i);
        }
       return addStar(proc , str , i+1);
    }
    public static String moveXToEnd(String str , int ind , int cnt){
        if (ind == str.length()){
            StringBuilder builder = new StringBuilder(str);
            for (int i = 0; i <cnt ; i++) {
                builder.append('x');
            }
            return builder.toString();
        }if (str.charAt(ind) == 'x'){
            cnt++;
            return moveXToEnd(str.substring(0,ind)+str.substring(ind+1),ind,cnt);
        }else {
            return moveXToEnd(str,ind+1,cnt);
        }
    }
    public static int countHI(String str){
        if (str.length() < 2){
            return 0;
        }
        int count = 0;
        String countHi = " " + str.charAt(0) + str.charAt(1);
        if (str.length() > 2){
            if (countHi.equals("hi")){
                count =  1+countHI(str.substring(2));
            }else {
                count =  countHI(str.substring(1));
            }
        }
        return count;
    }
    public static String removeHI(String str , int ind){
        if (ind + 1 >= str.length()){
            return str;
        }
        if (ind + 2 <= str.length() && str.substring(ind , ind+2).compareTo("hi")==0){
            return removeHI(str.substring(0,ind)+str.substring(ind+2),ind);
        }else {
            return removeHI(str , ind+1);
        }
    }
    //Dynamic problem
    public static int lengthOfLongestSubstring(String str ){
        int[] arr = new int[128];   //current index of character
        int ans = 0;
        int  count = 0;
        // try to extend the range
        for (int j = 0  ;j < str.length(); j++) {
            count = Math.max(arr[str.charAt(j)] , count);
            ans = Math.max(ans , j- count +1);
            arr[str.charAt(j)]++;
        }
        return ans;
    }
    public static int LCS(String s1 , String s2){
        
    }

}
