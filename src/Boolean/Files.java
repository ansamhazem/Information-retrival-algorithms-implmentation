package Boolean;
/**
 *
 * @author Fawzy
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Fawzy
 */     

public class Files {
    
    public static ArrayList<String> S1 = new ArrayList<>();
        public static ArrayList<String> S2 = new ArrayList<>();
        public static ArrayList<String> S3 = new ArrayList<>();
        public static ArrayList<String> S4 = new ArrayList<>(); 
        public static Set<String> AllTockens = new HashSet<>();
        Tockens t ;
        public Files() throws FileNotFoundException, IOException{
            t = new Tockens();
    File file = new File("C:\\Users\\Ansam\\Documents\\files Tes\\D1.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
    String st;
    while ((st = br.readLine()) != null){
        String[] termsCollection = st.split(" ");
        
        for(int i=0;i<termsCollection.length;i++)
        {    
            S1.add(termsCollection[i]);
        }
    }
    S1 = Tockens.RemoveStopsWords(S1);
    for(String g : S1){
        AllTockens.add(g);
    }
    
    File file1 = new File("C:\\Users\\Ansam\\Documents\\files Tes\\D2.txt");
        BufferedReader br1 = new BufferedReader(new FileReader(file1));
    String st1;
    while ((st1 = br1.readLine()) != null ){
        String[] termsCollection = st1.split(" ");
        
        for(int i=0;i<termsCollection.length;i++)
        {    
            S2.add(termsCollection[i]);
        
            System.out.println(termsCollection[i]);
            System.out.println("00000000");
        }
    }
    
    S2 = Tockens.RemoveStopsWords(S2);
     for(String g : S2){
        AllTockens.add(g);
    }
    File file2 = new File("C:\\Users\\Ansam\\Documents\\files Tes\\D3.txt");
        BufferedReader br2 = new BufferedReader(new FileReader(file2));
    String st2;
    while ((st2 = br2.readLine()) != null){
        String[] termsCollection = st2.split(" ");
        
        for(int i=0;i<termsCollection.length;i++)
        {    
            S3.add(termsCollection[i]);
        }
    }
    S3 = Tockens.RemoveStopsWords(S3);
     for(String g : S3){
        AllTockens.add(g);
    }
    File file3 = new File("C:\\Users\\Ansam\\Documents\\files Tes\\D4.txt");
        BufferedReader br3 = new BufferedReader(new FileReader(file3));
    String st3;
    while ((st3 = br3.readLine()) != null){
        String[] termsCollection = st3.split(" ");
        for(int i=0;i<termsCollection.length;i++)
        {    
            S4.add(termsCollection[i]);
        }
    }
    S4 = Tockens.RemoveStopsWords(S4);
     for(String g : S4){
        AllTockens.add(g);
    }
    
        
        
        
        
}}
