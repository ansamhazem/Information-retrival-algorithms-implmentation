package Boolean;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


/*
 * @author Fawzy
 */
public class BooleanTry1 {
    
  
    public static void main(String[] args) throws IOException  {
  //Files.S1 = Files.S1.RemoveStopsWords(Files.S1);
        Files f = new Files();
        for(String i : Files.S1)
        {
            System.out.println("iii");
            System.out.println(i);
        
        }
        for(String i : Files.S2)
        {
            System.out.println("llllllllllll");
            System.out.println(i);
        
        }
        for(String i : Files.S3)
            System.out.println(i);
        for(String i : Files.S4)
            System.out.println(i);
    System.out.println("++++++++++++++++");
     
    
    for( String i : Files.AllTockens ){
            System.out.println(i);
            
        }
        
        System.out.println("999999999999");
     //   for (String s : table2.AllTockens)
       //     System.out.println(s);
    table2 t = new table2();
    
    System.out.println("999999999999");
    System.out.println("999999999999");
//       for(int i=0;i<t.arrr1.length;i++)
//            System.out.println(t.arrr1[i]);
//       System.out.println("5lasna do   1 ");
//       for(int i=0;i<t.arrr1.length;i++)
//            System.out.println(table2.arrr2[i]);
//       System.out.println("5lasna do   2 ");
//       for(int i=0;i<t.arrr1.length;i++)
//            System.out.println(table2.arrr3[i]);
//       System.out.println("5lasna do   3 ");
//       for(int i=0;i<t.arrr1.length;i++)
//            System.out.println(t.arrr4[i]);
        Scanner ss =  new Scanner(System.in);
        String d = ss.nextLine();
        System.out.println(d);
        ArrayList<String> ff=new ArrayList<>();
        String[] termsCollection = d.split(" ");
        for(int i=0;i<termsCollection.length;i++)
        {    
            ff.add(termsCollection[i]);
        }
        System.out.println("tttttttttttttttttttttttttttt");
        Query2 q = new Query2();
        System.out.println("kkk    "+q.brackets(ff));

    }
    
        
    
    
    }
    
//NOT Ahmed AND ( NOT Fawzy OR ( NOT Ahmed OR Mohamed ) AND Ahmed ) OR Mohamed
//NOT information AND ( NOT course OR ( NOT information OR database ) AND information ) OR database
