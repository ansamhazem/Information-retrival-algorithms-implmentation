package Boolean;
import java.util.ArrayList;


/**
 *
 * @author Fawzy
 */
public class Query2 {

    public static ArrayList<Integer> matchToken(String u) {
        int i = 0;
        for (String gg : Files.AllTockens) {
            if (gg.equals(u)) {
                if (i == 0) {
                    return table2.arrr1;
                } else if (i == 1) {
                    return table2.arrr2;
                } else if (i == 2) {
                    return table2.arrr3;
                } else if (i == 3) {
                    return table2.arrr4;
                }

            }
            i++;

        }
        return null;
    }

    public static ArrayList<Integer> ExcuteORAnd(ArrayList<Integer> first, ArrayList<Integer> Second, String Operator) {
        ArrayList<Integer> res = new ArrayList<>();
        if (Operator.toUpperCase().equals("AND")) //bitwise AND operation
        {
            for (int a = 0; a < first.size(); a++) {
                if (first.get(a) == 1 && Second.get(a) == 1) {
                    res.add(1);
                } else {
                    res.add(0);
                }
            }
        } else if (Operator.toUpperCase().equals("OR")) //bitwise OR operation
        {
            for (int a = 0; a < first.size(); a++) {
                if (first.get(a) == 0 && Second.get(a) == 0) {
                    res.add(0);
                } else {
                    res.add(1);
                }
            }
        }
        return res;
    }

    public static ArrayList<Integer> ExcuteNot(ArrayList<Integer> first) {
        ArrayList<Integer> res = new ArrayList<>();
        //System.out.println("fff  + " + first);
        for (int a = 0; a < first.size(); a++) {
            if (first.get(a) == 1) {
                //System.out.println("kkkk "+first.get(a));
                res.add(0);
            } else {
                res.add(1);
            }
        }
        //System.out.println(res);
        return res;
    }

    //public static  
    public static ArrayList<String> brackets(ArrayList<String> query) {
        ArrayList<String> res = null;
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        ArrayList<String> qq;
        ArrayList<String> w = new ArrayList<>();

        for (int i = 0; i < query.size(); i++) {
            if (query.get(i).equals("(")) {
                a.add(i);
            }
            if (query.get(i).equals(")")) {
                b.add(i);
            }
        }
        ArrayList<Integer> first = new ArrayList<Integer>();
        ArrayList<Integer> second = new ArrayList<Integer>();
        ArrayList<Integer> re = new ArrayList<Integer>();
        ArrayList<String> temp = new ArrayList<>();
        String op;
        ArrayList<Integer> p = new ArrayList<>();
        int ffff, dddd;
        //NOT Ahmed AND ( NOT Fawzy OR ( NOT Ahmed OR Mohamed ) AND Ahmed ) OR Mohamed
        //NOT Ahmed AND ( NOT Fawzy OR 0000 AND Ahmed ) OR Mohamed
        for (int i = 0, j = a.size() - 1; i < a.size(); i++, j--) {

            System.out.println("hello   " + i);
            System.out.println("w   " + w);
            for (int k = a.get(j) + 1; k < b.get(i); k++) {
                //System.out.println("kkk   " + k + "   " + j + "       " + a.get(j));
                //System.out.println("ww  " + w);
                w.add(query.get(k));
            }
            System.out.println("System");
            System.out.println(query);
            temp.clear();
            System.out.println(b.get(i));
            System.out.println("wwwwww" + w);
              System.out.println(a.get(j));//NOT Ahmed AND ( NOT Fawzy OR ( NOT Ahmed OR Mohamed ) AND Ahmed ) OR Mohamed
            if (a.get(j) > 0) {
                for (int aa = 0; aa < a.get(j); aa++) {
                    temp.add(query.get(aa));
            //        System.out.println(query.get(aa));
              //      System.out.println("tr  "+temp);
                }
            }
            //System.out.println("bb  "+b.get(i));
            System.out.println("br  "+temp+"  "+b.get(i));
            temp.add("bracket");
            if (b.get(i) != query.size()) {
                for (int aa = b.get(i) + 1; aa < query.size(); aa++) {
                    temp.add(query.get(aa));
                }
            }
            System.out.println(temp);
            query.clear();
            for (int ww = 0; ww < temp.size(); ww++) {
                query.add(temp.get(ww));
            }
            temp.clear();
            System.out.println(query);
            System.out.println(w.size());

            if (w.size() == 2) {
                //  System.out.println(w.get(1));
                first = matchToken(w.get(1));

            } else if (w.size() == 3) {
//                    System.out.println("bbbbbbbbbbb");
                first = matchToken(w.get(0));
//                  
                op = w.get(1);
                second = matchToken(w.get(2));
//                    
                re = ExcuteORAnd(first, second, op);
//                    

            } else {
                int zzz = 0;
                ArrayList<String> ns = new ArrayList();
                for (String ff : w) {
            //        System.out.println("aaaaa  "+ff);
                    if (!ff.toUpperCase().equals("AND") && !ff.toUpperCase().equals("OR") && !ff.toUpperCase().equals("NOT")) {
              //             System.out.println("vvvvvvvvvv   "+ff);
                        String gggg = "";
                        if(matchToken(ff)!=null)
                        for (int jjj : matchToken(ff)) {
                            gggg += String.valueOf(jjj);
                        }//NOT Ahmed AND ( NOT Fawzy OR ( NOT Ahmed OR Mohamed ) AND Ahmed ) OR Mohamed
                        else gggg=ff;
                    //    System.out.println("gggg   "+gggg);
                        ns.add(gggg);
                        System.out.println("ns  "+ns);
                    } else {
                        ns.add(ff);
                        System.out.println("ns "+ns);
                    }
                }
                System.out.println("fffffffff");
                w.clear();
                for (int o = 0; o < ns.size(); o++) {
                    w.add(ns.get(o));
                }
                ns.clear();
                
                System.out.println("me4 naaaa");
//////////////////////////////////////////////////////////////////////
                for (int dd = 0; dd < w.size(); dd++) {
                    if (w.get(dd).toUpperCase().equals("NOT")) {
                        for (int u = 0; u < w.get(dd + 1).length(); u++) {
                            first.add(Character.getNumericValue(w.get(dd + 1).charAt(u)));
                        }
                        System.out.println(first);
                        re = ExcuteNot(first);
                        System.out.println(re);
                        String gggg = "";
                        for (int jjj : re) {
                            gggg += String.valueOf(jjj);
                        }

                        if (dd > 0) {
                            for (int ttt = 0; ttt < dd; i++) {
                                ns.add(w.get(ttt));
                            }
                        }
                        ns.add(gggg);
                        if (dd + 2 != w.size()) {
                            for (int yy = dd + 2; yy < w.size(); yy++) {
                                ns.add(w.get(yy));
                            }
                        }
                        System.out.println(ns);
                        w.clear();
                        for (int o = 0; o < ns.size(); o++) {
                            w.add(ns.get(o));
                        }
                        System.out.println(w);
                    }

                    first.clear();
                    re.clear();
                    ns.clear();
                }
                System.out.println(w);

                for (int dd = 0; dd < w.size(); dd++) {
                    if (w.get(dd).toUpperCase().equals("AND")) {
                        System.out.println("AAAAAAAAAAnd ");
                        for (int u = 0; u < w.get(dd - 1).length(); u++) {
                            first.add(Character.getNumericValue(w.get(dd - 1).charAt(u)));
                        }
                        System.out.println("first  " + first);
                        for (int u = 0; u < w.get(dd + 1).length(); u++) {
                            second.add(Character.getNumericValue(w.get(dd + 1).charAt(u)));
                        }
                        System.out.println("Second   " + second);
                        re = ExcuteORAnd(first, second, "AND");
                        System.out.println("reault " + re);
                        String gggg = "";//NOT Ahmed OR Mohamed AND Fawzy
                        for (int jjj : re) {
                            gggg += String.valueOf(jjj);
                        }
                        System.out.println("gggg  " + dd + "  " + gggg + "    " + w);
                        if (dd > 1) {
                            for (int ttt = 0; ttt < dd - 1; ttt++) {
                                ns.add(w.get(ttt));
                            }
                        }
                        ns.add(gggg);
                        System.out.println(gggg + "    nnnnnnn  " + ns);

                        if (dd + 2 != w.size()) {
                            for (int yy = dd + 2; yy < w.size(); yy++) {
                                ns.add(w.get(yy));
                            }
                        }
                        System.out.println(ns);
                        w.clear();
                        for (int o = 0; o < ns.size(); o++) {
                            w.add(ns.get(o));
                        }
                    }
                    System.out.println("qwqwqwqwqwq");
                    System.out.println(w);
                    first.clear();
                    second.clear();
                    re.clear();
                    ns.clear();
                }
//NOT Ahmed AND ( NOT Fawzy OR ( NOT Ahmed OR Mohamed ) AND Ahmed ) OR Mohamed
                for (int dd = 0; dd < w.size(); dd++) {
                    if (w.get(dd).toUpperCase().equals("OR")) {
                        for (int u = 0; u < w.get(dd - 1).length(); u++) {
                            first.add(Character.getNumericValue(w.get(dd - 1).charAt(u)));
                        }
                        System.out.println("first  " + first);

                        for (int u = 0; u < w.get(dd + 1).length(); u++) {
                            second.add(Character.getNumericValue(w.get(dd + 1).charAt(u)));
                        }
                        re = ExcuteORAnd(first, second, "OR");
                        System.out.println("bbbb " + re);
                        String gggg = "";
                        for (int jjj : re) {
                            gggg += String.valueOf(jjj);
                        }
                        if (dd > 1) {
                            for (int ttt = 0; ttt < dd - 1; ttt++) {
                                ns.add(w.get(ttt));
                            }
                        }
                        ns.add(gggg);
                        System.out.println(gggg + "    nnnnnnn  " + ns);

                        if (dd + 2 != w.size()) {
                            for (int yy = dd + 2; yy < w.size(); yy++) {
                                ns.add(w.get(yy));
                            }
                        }
                        //     System.out.println(ns);
                        w.clear();
                        for (int o = 0; o < ns.size(); o++) {
                            w.add(ns.get(o));
                        }
                    }
                    System.out.println("qwqwqwqwqwq");
                    System.out.println(w);
                    first.clear();
                    second.clear();
                    re.clear();
                    ns.clear();
                }

            }
            System.out.println("mara " + i);
            System.out.println(query);
            if (w.size() == 1) {
                System.out.println("000000");
                System.out.println("ttt "+temp+"  "+query);
                for (int ww = 0; ww < query.size(); ww++) {
                    if (query.get(ww).equals("bracket")) {
                        temp.add(w.get(0));
                        continue;
                    }
                    
                    temp.add(query.get(ww));

                }//NOT Ahmed AND ( NOT Fawzy OR ( NOT Ahmed OR Mohamed ) AND Ahmed ) OR Mohamed
                query.clear();
                for (String zz : temp) {
                    query.add(zz);
                }

                System.out.println("temp " + temp);
                System.out.println(query);
                
                w.clear();
                ArrayList<Integer> po1 = new ArrayList<>();
                ArrayList<Integer> po2 = new ArrayList<>();
                if (i == 0) {
                    po2.add(0);
                } else {
                    for (int yt = 0; yt < i; yt++) {
                        po2.add(0);
                    }
                }
                System.out.println("po "+po2);
                for (int iii = 0; iii < query.size(); iii++) {
                    //int k = a.get(j) + 1; k < b.get(i); k++
                    //int i = 0, j = a.size() - 1; i < a.size(); i++, j--
                    if (query.get(iii).equals("(")) {
                        po1.add(iii);
                    }
                    if (query.get(iii).equals(")")) {

                        po2.add(iii);
                    }
                }
                System.out.println(po1+"  " + po2);
                if(po2.size()==1){
                    SimpleQuery q = new SimpleQuery();
                    System.out.println("sssssssssssssssssssssssssssssss");
                    return q.brackets(query);
                }
                for (int yt = po1.size(); yt < a.size(); yt++) {
                    po1.add(0);
                }
                
                System.out.println("jjjjjjjjjjj");
                a.clear();
                b.clear();
                System.out.println(po1.size());
                for (int ooo = 0; ooo < po1.size(); ooo++) {
                    System.out.println("22222   " + ooo);
                    a.add(po1.get(ooo));
                    System.out.println("ooo   " + a.get(ooo));
                    b.add(po2.get(ooo));
                    System.out.println(b.get(ooo));
                }
            }

            System.out.println("bbbbbbbbbbbbbbbbbbbbb  " + i);
            System.out.println(i + "           " + a.size());

        }
        res = null;
        return res;
    }
}

//gg ( g g ( Ahmed AND Adel ) ) ll
//ddd ddd ( f g ( h h ( NOT Ahmed AND Mohamed ) p ) pp ) opo)
//NOT Ahmed AND ( NOT Fawzy OR ( NOT Ahmed OR Mohamed ) AND Ahmed ) OR Mohamed
//NOT Ahmed AND ( NOT Fawzy OR 11111 AND Ahmed ) OR Mohamed
//gg ( g g ( NOT Adel ) ) ll
//NOT information AND ( NOT course OR ( NOT information OR database ) AND information ) OR database
//