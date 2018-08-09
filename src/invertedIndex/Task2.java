
package invertedIndex;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task2 {

    
    public ArrayList<String> Tokens;
    public ArrayList<String> Tokens1Name ;
    public ArrayList<Integer> Tokens1Nmber;
    public ArrayList<ArrayList<Integer>> DocumentsIDs ;
    public ArrayList<String> Tokens1NameFinal;
    public ArrayList<Integer> Tokens1NmberFinal ;

    public Task2() {
    Tokens = new ArrayList<String>();
    Tokens1Name = new ArrayList<String>();
    Tokens1Nmber = new ArrayList<Integer>();
    DocumentsIDs = new ArrayList<ArrayList<Integer>>();
    Tokens1NameFinal = new ArrayList<String>();
    Tokens1NmberFinal = new ArrayList<Integer>();
    }
    
    
        static String[] stopWords ={"a", "about", "above", "above", "across", "after", "afterwards", "again", "against", "all", "almost", 
                "alone", "along", "already", "also","although","always","am","among", "amongst", "amoungst", "amount",  "an", "and", 
                "another", "any","anyhow","anyone","anything","anyway", "anywhere", "are", "around", "as",  "at", "back","be","became", 
                "because","become","becomes", "becoming", "been", "before", "beforehand", "behind", "being", "below", "beside", "besides", 
                "between", "beyond", "bill", "both", "bottom","but", "by", "call", "can", "cannot", "cant", "co", "con", "could", "couldnt",
                "cry", "de", "describe", "detail", "do", "done", "down", "due", "during", "each", "eg", "eight", "either", "eleven","else",
                "elsewhere", "empty", "enough", "etc", "even", "ever", "every", "everyone", "everything", "everywhere", "except", "few", 
                "fifteen", "fify", "fill", "find", "fire", "first", "five", "for", "former", "formerly", "forty", "found", "four", "from", 
                "front", "full", "further", "get", "give", "go", "had", "has", "hasnt",
                "have", "he", "hence", "her", "here", "hereafter", "hereby", "herein", "hereupon", "hers", "herself", 
                "him", "himself", "his", "how", "however", "hundred", "ie", "if", "in", "inc", "indeed", "interest", "into", 
                "is", "it", "its", "itself", "keep", "last", "latter", "latterly", "least", "less", "ltd", "made", "many", 
                "may", "me", "meanwhile", "might", "mill", "mine", "more", "moreover", "most", "mostly", "move", "much", "must", 
                "my", "myself", "name", "namely", "neither", "never", "nevertheless", "next", "nine", "no", "nobody", "none", 
                "noone", "nor", "not", "nothing", "now", "nowhere", "of", "off", "often", "on", "once", "one", "only", "onto", 
                "or", "other", "others", "otherwise", "our", "ours", "ourselves", "out", "over", "own","part", "per", "perhaps",
                "please", "put", "rather", "re", "same", "see", "seem", "seemed", "seeming", "seems", "serious", "several", "she",
                "should", "show", "side", "since", "sincere", "six", "sixty", "so", "some", "somehow", "someone", "something", 
                "sometime", "sometimes", "somewhere", "still", "such", "system", "take", "ten", "than", "that", "the", "their", 
                "them", "themselves", "then", "thence", "there", "thereafter", "thereby", "therefore", "therein", "thereupon", 
                "these", "they", "thickv", "thin", "third", "this", "those", "though", "three", "through", "throughout", "thru", 
                "thus", "to", "together", "too", "top", "toward", "towards", "twelve", "twenty", "two", "un", "under", "until", 
                "up", "upon", "us", "very", "via", "was", "we", "well", "were", "what", "whatever", "when", "whence", "whenever",
                "where", "whereafter", "whereas", "whereby", "wherein", "whereupon", "wherever", "whether", "which", "while", 
                "whither", "who", "whoever", "whole", "whom", "whose", "why", "will", "with", "within", "without", "would", "yet",
                "you", "your", "yours", "yourself", "yourselves","1","2","3","4","5","6","7","8","9","10","1.","2.","3.","4.","5.","6.","11",
                "7.","8.","9.","12","13","14","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z",
                "terms","CONDITIONS","conditions","values","interested.","care","sure",".","!","@","#","$","%","^","&","*","(",")","{","}","[","]",":",";",",","<",".",">","/","?","_","-","+","=",
                "a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z",
                "contact","grounds","buyers","tried","said,","plan","value","principle.","forces","sent:","is,","was","like",
                "discussion","tmus","diffrent.","layout","area.","thanks","thankyou","hello","bye","rise","fell","fall","psqft.","http://","km","miles"};

    
    public void ConverttoSmall() {
        for (int i = 0; i < Tokens1Name.size(); i++) {
            String s = Tokens1Name.get(i).toLowerCase();
            Tokens1Name.set(i, s);
        }
    }

    
     public  void RemoveStopsWords()
{
    
    for (int i = 0; i < Tokens1Name.size(); i++)
    {
        for(int j=0;j<stopWords.length;j++)
        if (stopWords[j].contains(Tokens1Name.get(i)))
        {
           Tokens1Name.remove(i);
           Tokens1Nmber.remove(i);
           break;
        }    
    }
}
    

    public void RemoveSpecialChracter() {
        Pattern pt = Pattern.compile("[^a-zA-Z0-9]");
        for (int i = 0; i < Tokens1Name.size(); i++) {
            String c = Tokens1Name.get(i);
            Matcher match = pt.matcher(c);
            while (match.find()) {
                String s = match.group();
                c = c.replaceAll("\\" + s, "");
            }
            Tokens1Name.set(i, c);

        }
    }

    public void TokenonSpace(String S, int id) {
        StringTokenizer st = new StringTokenizer(S);
        String temp = "";
        while (st.hasMoreTokens()) {
            temp = st.nextToken();
            Tokens1Name.add(temp);   
            Tokens1Nmber.add(id);
        }
    //    System.out.println(Tokens1Name);
    //    System.out.println(Tokens1Nmber);        
    }
    
    public void Sort() {
        String temp = "";
        int temp2;
        for (int i = 0; i < Tokens1Name.size(); i++) {
            for (int j = 1; j < (Tokens1Name.size() - i); j++) {
                if (Tokens1Name.get(j - 1).compareTo(Tokens1Name.get(j)) > 0) {
                    temp = Tokens1Name.get(j - 1);
                    Tokens1Name.set(j - 1, Tokens1Name.get(j));
                    Tokens1Name.set(j, temp);
                    /// Document number
                    temp2 = Tokens1Nmber.get(j - 1);
                    Tokens1Nmber.set(j - 1, Tokens1Nmber.get(j));
                    Tokens1Nmber.set(j, temp2);

                }

            }
        }
    }

    public void DocumentFrequency() {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < Tokens1Name.size(); i++) {
            
            if (i != 0) {
                
                if ((Tokens1Name.get(i).equals(Tokens1Name.get(i - 1))) ) {
                    set.add(Tokens1Nmber.get(i));// add Doc Id in Set
                    //DocumentsIDs.add(Tokens1Nmber.get(i));
                } else {
                    Tokens1NameFinal.add(Tokens1Name.get(i - 1)); // Save Name of Docum in List 
                    Tokens1NmberFinal.add(set.size()); // Set the Num of Diff Doc Contain Token ---> Document Frequency
                    ArrayList<Integer> temp = new ArrayList<Integer>();
                    Iterator<Integer> iterator = set.iterator();
                    while (iterator.hasNext()) {
                        Integer element = iterator.next();
                         temp.add(element);
                        iterator.remove();
                    }
                    // Tranafere Number from set to List to Save it ***Doc Id**
                    DocumentsIDs.add(temp);
                    set.clear();
                    set.add(Tokens1Nmber.get(i));// this item not equal the bervois

                }
                if ( i ==Tokens1Name.size()-1) // Last Element in The List to Save IT
                        {
                         
                    Tokens1NameFinal.add(Tokens1Name.get(i-1));
                    Tokens1NmberFinal.add(set.size());
                    ArrayList<Integer> temp = new ArrayList<Integer>();
                    Iterator<Integer> iterator = set.iterator();
                    while (iterator.hasNext()) {
                        Integer element = iterator.next();
                         temp.add(element);
                        iterator.remove();
                    }
                    DocumentsIDs.add(temp);
                    set.clear();
                    set.add(Tokens1Nmber.get(i));
        
                        }
               
            }
            else {
                set.add(Tokens1Nmber.get(i));// Frist Doc Id from the Frist Token
            }

        }

}
    public void ReadDoc(String Path , int Docid) throws IOException
    {
        File file1 = new File(Path);
    BufferedReader br1 = new BufferedReader(new FileReader(file1));
    String sttemp1,streal1="";
    while ((sttemp1 = br1.readLine()) != null){
        if(sttemp1!=null)
        streal1=streal1+sttemp1;
        //System.out.println(sttemp1);
        }
    TokenonSpace(streal1, Docid);
    RemoveSpecialChracter();
    RemoveStopsWords();
    ConverttoSmall();
     
    }
    
    public void AfterRead()
    {
        Sort();
         DocumentFrequency();
    }
    
}
