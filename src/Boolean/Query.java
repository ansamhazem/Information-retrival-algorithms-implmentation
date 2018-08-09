package Boolean;

import java.util.ArrayList;

/**
 *
 * @author Fawzy
 */
public class Query {
    
    public static ArrayList<Integer> ExcuteORAnd(int first[] , int Second[] , String Operator){
        ArrayList<Integer> res = new ArrayList<>();
        if (Operator.toUpperCase().equals("AND")) //bitwise AND operation
    {
        for (int a = 0; a < first.length ; a++)
        {
            if (first[a] == 1 && Second[a] == 1)
            {
                res.add(1);
            }
            else
            {
                res.add(0);
            }
        }
    }
        else if (Operator.toUpperCase().equals("OR")) //bitwise OR operation
    {
        for (int a = 0; a < first.length; a++)
        {
            if (first[a] == 0 && Second[a] == 0)
            {
                res.add(0);
            }
            else
            {
                res.add(1);
            }
        }
    }
        return res;
    }
    
    public static ArrayList<Integer> ExcuteNot(int first[] , String Operator){
        ArrayList<Integer> res = new ArrayList<>();
        if (Operator.toUpperCase().equals("NOT")) //bitwise AND operation
    {
        for (int a = 0; a < first.length ; a++)
        {
            if (first[a] == 1)
            {
                res.add(0);
            }
            else
            {
                res.add(1);
            }
        }
    }
        return res;
    }
    //public static  
    public static ArrayList<Integer> brackets(ArrayList<String> query){
        ArrayList<Integer> res = null ;
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        
        //System.out.println("ooooooo");
        
        ArrayList<String> qq ;
        ArrayList<String> w = new ArrayList<>() ;
        
        for(int i=0;i<query.size();i++){
            if(query.get(i).equals("("))
            {
                a.add(i);
            }
             if(query.get(i).equals(")"))
            {
                b.add(i);
                }     
        }
        ArrayList<Integer> p = new ArrayList<>();
        //System.out.println(w.size());
        for(int i = 0 , j =a.size()-1 ;i < a.size() ; i++,j--){
          //  System.out.println("dddddddddddd");
            for(int k = a.get(j)+1 ; k <= b.get(i)-1 ; k++ )    {
                    /*if(query.get(k).equals("(")){
                        
                        while (true) {  
                            k++;
                            if(query.get(k).equals(")")){
                                k++;
                                break;}
                        }
                    
                    }*/
                    //if(query.get(k).equals(")"))break;
                   
                   for(int oo=0;oo<query.size();oo++)
                       if(query.get(oo).equals("5ara"))continue;
                   
                    w.add(query.get(k));
                    query.add(k, "5ra");
                    //System.out.println("ww");
                    
                    //query.remove(k);
            //        System.out.println("pppppppppppppppp");
              //      System.out.println(k);
                //    System.out.println(query.size());
                    
            }
        
        
        }
        System.out.println("sssssssssssssssssssss");
            for(String t : w)
      {    
          //System.out.println("kkkkkk");
          System.out.println(t);}
        return res ;
    }
    //gg ( g g ( h h ) ) ll
    //ddd ddd ( f g ( h h ( u o ) p ) pp ) opo)
    
    
}
