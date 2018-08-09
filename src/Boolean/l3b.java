package Boolean;
/**
 *
 * @author Fawzy
 */

import java.util.ArrayList;

/**
 *
 * @author Fawzy
 */
public class l3b {

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
        ArrayList<String> res = new ArrayList<>();

        ArrayList<String> w = new ArrayList<>();
        for (int qq = 0; qq < query.size(); qq++) {
            w.add(query.get(qq));
        }

//
//        for (int i = 0; i < query.size(); i++) {
//            if (query.get(i).equals("(")) {
//                a.add(i);
//            }
//            if (query.get(i).equals(")")) {
//                b.add(i);
//            }
//        }
        ArrayList<Integer> first = new ArrayList<Integer>();
        ArrayList<Integer> second = new ArrayList<Integer>();
        ArrayList<Integer> re = new ArrayList<Integer>();
        String op;
        ArrayList<Integer> p = new ArrayList<>();
        for (int i = 0; i < query.size(); i++) {
            System.out.println(w.size());
            if (w.size() == 2) {
                //  System.out.println(w.get(1));

                first = matchToken(w.get(1));
                re = ExcuteNot(first);

                for (Integer bb : re) {
                    res.add(String.valueOf(bb));

                }
                return res;

            } else if (w.size() == 3) {
                System.out.println("bbbbbbbbbbb      " + w);
                //Ahmed AND Fawzy
                first = matchToken(w.get(0));
                System.out.println(first);
                op = w.get(1);
                System.out.println(op);
                second = matchToken(w.get(2));
                System.out.println(second);
//                    
                re = ExcuteORAnd(first, second, op);
                System.out.println(re);
                for (Integer bb : re) {
                    //   System.out.println("kkk");
                    System.out.println(String.valueOf(bb));
                    res.add(String.valueOf(bb));
                    //System.out.println(bb);

                }
                return res;

            } else {
                System.out.println("qqqqqqqqqqqqqqqqqqq");
                int zzz = 0;
                ArrayList<String> ns = new ArrayList();
                for (String ff : w) {
                    System.out.println(w);
                    if (!ff.toUpperCase().equals("AND") && !ff.toUpperCase().equals("OR") && !ff.toUpperCase().equals("NOT")) {
                        String gggg = "";
                        for (int jjj : matchToken(ff)) {
                            gggg += String.valueOf(jjj);
                        }
                        ns.add(gggg);

                    } else {
                        ns.add(ff);
                    }
                }
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
                            for (int ttt = 0; ttt < dd; i++) {
                                ns.add(w.get(ttt));
                            }
                        }
                        //       System.out.println(gggg+ "    nnnnnnn  "+ns);  
                        ns.add(gggg);

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

                for (int dd = 0; dd < w.size(); dd++) {
                    if (w.get(dd).toUpperCase().equals("AND")) {
                        for (int u = 0; u < w.get(dd - 1).length(); u++) {
                            first.add(Character.getNumericValue(w.get(dd - 1).charAt(u)));
                        }
                        System.out.println("first  " + first);
                        for (int u = 0; u < w.get(dd + 1).length(); u++) {
                            second.add(Character.getNumericValue(w.get(dd + 1).charAt(u)));
                        }
                        re = ExcuteORAnd(first, second, "AND");
                        System.out.println("bbbb " + re);
                        String gggg = "";
                        for (int jjj : re) {
                            gggg += String.valueOf(jjj);
                        }

                        if (dd > 1) {
                            for (int ttt = 0; ttt < dd; i++) {
                                ns.add(w.get(ttt));
                            }
                        }
                        System.out.println(gggg + "    nnnnnnn  " + ns);
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
                    }
                    System.out.println("qwqwqwqwqwq");
                    System.out.println(w);
                    first.clear();
                    second.clear();
                    re.clear();
                    ns.clear();
                }

            }
            if (w.size() == 1) {
                return w;
            }
        }
        res = null;
        return res;
    }

}
//NOT Ahmed OR Mohamed AND Fawzy
