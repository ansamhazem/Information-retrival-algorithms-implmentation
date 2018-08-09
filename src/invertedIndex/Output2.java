package invertedIndex;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Ahmed.Taher
 */
public class Output2 {

    Task2 Temp;
    public ArrayList<Set<Integer>> Sets ;
    public ArrayList<String> FinalOutput;
    public Set<Integer> set ;

    public Output2(Task2 T) {
        Temp = T;
        Sets = new ArrayList<>();
        FinalOutput = new ArrayList<>();
        set = new HashSet<Integer>();
    }

    ArrayList<String> Query = new ArrayList<String>();

    public void QueryEdits(String S) {
        Pattern pt = Pattern.compile("[^a-zA-Z0-9]");

        StringTokenizer st = new StringTokenizer(S);
        String temp = "";
        while (st.hasMoreTokens()) {
            temp = st.nextToken();
            String x = temp.toLowerCase();

            Matcher match = pt.matcher(x);
            while (match.find()) {
                String s = match.group();
                x = x.replaceAll("\\" + s, "");
            }

            for (String stopWord : Task2.stopWords) {
                if (stopWord.contains(x)) {
                    continue;
                }
            }
            Query.add(x);
        }
        RunQuery();
    }

    public void RunQuery() {
        
        boolean Flage = false;
        for (int i = 0; i < Query.size(); i++) {
         Set<Integer>  settemp = new HashSet<Integer>();
            Flage = false;  
           
            if (Temp.Tokens1NameFinal.contains(Query.get(i))) {
                int index =Temp.Tokens1NameFinal.indexOf(Query.get(i));
                FinalOutput.add(Query.get(i));
                FinalOutput.add(Temp.Tokens1NmberFinal.get(index).toString());
                FinalOutput.add(Temp.DocumentsIDs.get(index).toString());

                for (int J=0;J<Temp.DocumentsIDs.get(index).size();J++)
                {
                    settemp.add(Temp.DocumentsIDs.get(index).get(J));
                }
                Sets.add(settemp);
                
                Flage = true;
            }
            else {
///////////////////// zwdt de !!!                
                FinalOutput.add(Query.get(i));
                FinalOutput.add("Not Found");
                FinalOutput.add("Not Found");

                settemp.add(0);
                Sets.add(settemp);
                
                
            }
            if (!Flage) {
                continue;
            }
        }
///////////////////// zwdt de !!!
        Set<Integer>  settemp = new HashSet<Integer>();
    Iterator<Set<Integer>> iterator = Sets.iterator();
    boolean bool = true;
        while(iterator.hasNext()) {
            if (bool)
            {
            set = iterator.next();
            set.retainAll(set);

            }
            else {
        settemp = iterator.next();        
        set.retainAll(settemp);
        
            }
        
            bool = false ;
    }

    }
}
