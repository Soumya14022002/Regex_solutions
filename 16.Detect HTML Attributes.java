import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class regexjavahtmlattr {
    public static void main(String[] args) throws FileNotFoundException {
        String _strf;
 
        Scanner sc = new Scanner(System.in);
        String line, strlineout, tagname, strattr;
        Pattern p = Pattern.compile("<([a-z1-9]+)([^>]*)>");
        Pattern pa = Pattern.compile("(?<=\\s)(\\w+\\b)(?= *?\\=)");
        
        Map<String, String> mp = new HashMap<String, String>();
        Matcher m, m2;
        int i, j;
        int n = sc.nextInt();
        sc.nextLine();

        List<String> attrs = new ArrayList<String>();
        i = 0;

        while (sc.hasNext()) {
            line = sc.nextLine();
            
            m = p.matcher(line);
            i = 0;
            j = 0;
            while (m.find()) {
                attrs.clear();
                tagname = m.group(1);
                m2 = pa.matcher(m.group(2));
                attrs = new ArrayList<String>();
                i = 0;
                while (m2.find()) {
                    attrs.add(m2.group(1));
                    i++;
                }
                Collections.sort(attrs);
                strattr = String.join(",", attrs);
          

                if (mp.keySet().contains(tagname)) {
                    List<String> _lst = Arrays.asList(mp.get(tagname).split(","));

                    attrs.addAll(_lst);

                    Collections.sort(attrs);
                    strattr = String.join(",", attrs.stream().distinct().collect(Collectors.toList()));
                }
                mp.put(tagname, strattr);

                attrs.clear();
                j++;
            }

        }

        List<String> ks = new ArrayList<String>(mp.keySet());
        Collections.sort(ks);
        for (String s : ks) {
            System.out.println(s + ":" + mp.get(s));
        }

    }
}
