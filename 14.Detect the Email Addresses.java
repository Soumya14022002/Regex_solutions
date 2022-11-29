import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sn = new Scanner(System.in);
        int repeet = sn.nextInt();
        ArrayList<String> tags = new ArrayList<String>();
        for (int i = 0; i < repeet + 1; i++) {
            String tag = sn.nextLine();
            Pattern p = Pattern.compile("([^\\s]*?@.*?\\.(com|in|net|org))");
            Matcher m = p.matcher(tag);
            while(m.find()){
                if(!tags.contains(m.group(1))){
                    tags.add(m.group(1));
                }
            }
        }
        Collections.sort(tags);
        String output = "";
        for (String tag : tags){
            output += tag + ";";
        }
        System.out.println(output.substring(0, output.length()-1));
    }
}
