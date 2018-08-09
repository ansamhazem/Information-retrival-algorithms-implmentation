/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postional;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class PositionVersion2 {

    public static ArrayList<Word> Doc = new ArrayList<>();
        public static ArrayList<Word> DocCopy = new ArrayList<>();

    public static ArrayList<Word> Result = new ArrayList<>();
    private static ArrayList<String> Query = new ArrayList<>();//each element content word of query 

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Enter Number of Doc");

        int x = 4;//Number of Doc
        for (int i = 0; i < 4; i++) {
            System.out.println("Enter Doc name");
            readDoc(in.nextLine() + ".txt");
        }

        System.out.println("enter your query");
        String quu;
        quu = in.nextLine();
        GetQuery(quu);
        DisplayResult();

    }

    public static void readDoc(String DocName) {
        Word w;
        int count = 0;
        StringTokenizer st = null;
        String line;
        try {
            FileReader fileReader = new FileReader(DocName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                st = new StringTokenizer(line);
                while (st.hasMoreTokens()) {
                    w = new Word();
                    w.token = st.nextToken();
                    w.doc.Docname = DocName;
                    w.doc.Index = count;
                    count++;
//                    System.out.println( w.token);
//                    System.out.println( count);
                    Doc.add(w);
                }
                System.out.println("--------------------------");
                st = null;
                line = null;
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file");
        } catch (IOException ex) {
            System.out.println("Error reading file ");
        }
    }

    public static void GetQuery(String InpQu) {

        StringTokenizer qu = new StringTokenizer(InpQu);
        while (qu.hasMoreTokens()) {
            Query.add(qu.nextToken());
        }
        Indexs();
    }

    public static void Indexs() {
        for (int q = 0; q < Query.size(); q++) {
            for (int d = 0; d < Doc.size(); d++) {
                if (Query.get(q).equals(Doc.get(d).token)) {
                    Doc.get(d).counter++;
                }
                if (q == Query.size() - 1 && Doc.get(d).counter == 0) {
                    Doc.remove(d);
                    d = d - 1;
                }
            }
        }
        DocCopy.addAll(Doc);
        //DisplayResult();
        System.out.println("matched docs");
        FindDoc();
    }

    public static void FindDoc() {
        int count = 1;
        for (int d = 0; d < Doc.size(); d++) {

//            if (Doc.get(d).Index == Doc.get(d+1).Index) {
//                    Doc.;//            }
//            }
//            int f1 = Doc.get(d).doc.Index;
//            int f2 = Doc.get(d+1).doc.Index+1;
            if (d < Doc.size() - 1 && Doc.get(d).doc.Docname.equals(Doc.get(d + 1).doc.Docname)) {
                if (Doc.get(d).doc.Index + 1 == Doc.get(d + 1).doc.Index) {
                    //System.out.println(Doc.get(d).doc.Docname + "{" + Doc.get(d).token + " " + Doc.get(d + 1).token + "}" + " in " + "{" + Doc.get(d).doc.Index + "," + Doc.get(d + 1).doc.Index + "}");
                    count++;
                } else {
                    if (count != Query.size()) {
//                        for (int i = d; i > count + 1; i--) {
//                            Doc.remove(i);
//                        }
                        Doc.remove(d);
                        d = d - 1;
                        count = 1;
                    } else {
                        count = 1;
                    }
                }

//                if(count != Query.size())
//                {
//                    for(int i = d ; i < count ; i--)
//                    {
//                        Doc.remove(i);
//                    }
//                    d = d - count;
//                    count = 0;
//                }
//                else
//                    count = 0;
//            if (Doc.get(d).doc.Index + 1 == Doc.get(d + 1).doc.Index) {
//                System.out.println(Doc.get(d).doc.Docname + "{" + Doc.get(d).token + " " + Doc.get(d + 1).token + "}" + " in " + "{" + Doc.get(d).doc.Index + "," + Doc.get(d + 1).doc.Index + "}");
//            }
            } else {
                if (count != Query.size()) {
//                    for (int i = d; i > count + 1; i--) {
//                        Doc.remove(i);
//                    }
                    Doc.remove(d);
                    d = d - 1;
                    count = 1;
                } else {
                    count = 1;
                }
            }
        }
    }

    public static void DisplayResult() {
        for (int i = 0; i < Doc.size(); i++) {
            System.out.println("Token = " + Doc.get(i).token);
            System.out.println("Doc Name = " + Doc.get(i).doc.Docname);
            System.out.println(" Index " + Doc.get(i).doc.Index);

            if (i < Doc.size() - 1 && !Doc.get(i).doc.Docname.equals(Doc.get(i + 1).doc.Docname)) {
                System.out.println("====================================");
            }
        }
    }
}
