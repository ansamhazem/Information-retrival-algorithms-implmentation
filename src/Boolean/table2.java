package Boolean;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Fawzy
 */
public class table2 {
    
    
    public static ArrayList<Integer> arrr1 = new ArrayList<Integer>();
    public static ArrayList<Integer> arrr2 = new ArrayList<Integer>();
    public static ArrayList<Integer> arrr3 = new ArrayList<Integer>();
    public static ArrayList<Integer> arrr4 = new ArrayList<Integer>();
    public static Set<String> AllTockens;
    public table2() {
        this.AllTockens = new HashSet<>();
        System.out.println("kkkkkkkk");
        int i=0;
        
    int[] arr1 = new int[4];
    int[] arr2 = new int[4];
     int[] arr3 = new int[4];
     int[] arr4 = new int[4];
        
        
        for(String gg : Files.AllTockens){
            
            if(Search(gg, Files.S1)==true)
            { 
               // System.out.println("2bl     "+arr1[i]);
                arr1[i]=1;
          
            }else
                arr1[i]=0;
            i++;
        }
        System.out.println("5lasna do   1 ");
        ///////////////////////////////////////
        i=0;
        for(String gg : Files.AllTockens){
            if(Search(gg, Files.S2)==true)
                arr2[i]=1;
        else
                arr2[i]=0;
            i++;
        }
        System.out.println("5lasna do  2 ");
        /////////////////////////////
        i=0;
        for(String gg : Files.AllTockens){
            if(Search(gg, Files.S3)==true)
                arr3[i]=1;
        else
                arr3[i]=0;
            i++;
        }
        System.out.println("5lasna do    3 ");
        ///////////////////////////////
        i=0;
        for(String gg : Files.AllTockens){
            
            System.out.println("ghghghggh   "+i +"    "+gg);
            System.out.println("ghghghggh   "+i +"    "+Files.S1.get(0));
            if(Search(gg, Files.S4)==true)
            {System.out.println("yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");
                arr4[i]=1;}
        else
                arr4[i]=0;
            i++;
        }
        
            arrr1.add(0,arr1[0]);
            arrr1.add(1,arr2[0]);
            arrr1.add(2,arr3[0]);
            arrr1.add(3,arr4[0]);
            
            /////////////////////
            arrr2.add(0,arr1[1]);
            arrr2.add(1,arr2[1]);
            arrr2.add(2,arr3[1]);
            arrr2.add(3,arr4[1]);
            ////////////////////////////////
            arrr3.add(0,arr1[2]);
            arrr3.add(1,arr2[2]);
            arrr3.add(2,arr3[2]);
            arrr3.add(3,arr4[2]);
            /////////////////////
            arrr4.add(0,arr1[3]);
            arrr4.add(1,arr2[3]);
            arrr4.add(2,arr3[3]);
            arrr4.add(3,arr4[3]);
            
        }
               
        
 
    public static boolean Search( String s , ArrayList<String> ss  ){
       // System.out.println("uuuuuuuuuuuuuuuuuuuuuuu");
        //System.out.println(s);
        for(String gg : ss ) 
        {
            if(gg.contains(s)){    
            return true;
            }
        }
        System.out.println("bbbbbbbbbbbbbbbbbbbbbb");
        return false;
        //return ss.contains(s);
    }
    
    public ArrayList<ArrayList<Integer>> termVectorList(Set<String> ff)
    {
        ArrayList<ArrayList<Integer>> termVectors=new ArrayList<ArrayList<Integer>>() ;
        
         for (String token : ff){
            if(token.toUpperCase().equals("AND")||token.toUpperCase().equals("NOT")||token.toUpperCase().equals("OR")||token.equals("(")|| token.equals(")"))
                continue;
            else
            {
                SimpleQuery q = new SimpleQuery();
                termVectors.add(q.matchToken(token));
            
            }
        }
        return termVectors;
    }
    public ArrayList<ArrayList<Integer>> termVectorListComplex(Set<String> ff)
    {
        ArrayList<ArrayList<Integer>> termVectors=new ArrayList<ArrayList<Integer>>() ;
        
         for (String token : ff){
            if(token.toUpperCase().equals("AND")||token.toUpperCase().equals("NOT")||token.toUpperCase().equals("OR")||token.equals("(")|| token.equals(")"))
                continue;
            else
            {
                Query2 q = new Query2();
                termVectors.add(q.matchToken(token));
            
            }
        }
        return termVectors;
    }
    
    
    
    
}
