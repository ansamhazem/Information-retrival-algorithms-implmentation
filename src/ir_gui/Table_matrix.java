/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir_gui;
import Boolean.Files;
import Boolean.table2;
import invertedIndex.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Set;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import postional.PositionVersion2;

/**
 *
 * @author Ansam
 */
public class Table_matrix extends javax.swing.JFrame {

    /**
     * Creates new form Table_matrix
     */
    Task2 T;
    int taskno;
    ArrayList<ArrayList<Integer>> termVectors=new ArrayList<ArrayList<Integer>>() ;
    ArrayList<String> res;
    ArrayList<File> files;
    table2 t;
    PositionVersion2 pos;
    int tabel;

    public Table_matrix(Task2 T,int taskno,table2 t, Set<String> Tokens,ArrayList<String> res,ArrayList<File> files,PositionVersion2 pos,int simpleComplex) {
        initComponents();
        this.T=T;
        this.taskno=taskno;
        this.res=res;
        this.files=files;
        this.t=t;
        this.pos=pos;
        this.tabel=simpleComplex;
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        if(taskno==2)
        {
            
            ArrayList<String> tokens=T.Tokens1NameFinal;
            ArrayList<Integer> freq=T.Tokens1NmberFinal;
            ArrayList<ArrayList<Integer>> DocID=T.DocumentsIDs;

            model.addColumn("Token");
            model.addColumn("Frequency");
            model.addColumn("Documents ID");
            for (int i = 0; i < tokens.size(); i++) {
                Vector<Object> data = new Vector<Object>();
                data.add(tokens.get(i));
                data.add(freq.get(i));
                data.add(DocID.get(i));

                model.addRow(data);

            }
        }
        if(taskno==1)
            {
                if(simpleComplex!=0){
                    if(simpleComplex==1)
                    termVectors=t.termVectorList(Tokens);
                    else
                    termVectors=t.termVectorListComplex(Tokens);
                    model.addColumn("Terms");
                    model.addColumn("Documents");
                    int j=0;
                    int i=0;
                    for (String token : Tokens){
    //                for (int i = 0; i < termVectors.size(); i++) {
                        i++;
                        Vector<Object> data = new Vector<Object>();
                        if(token.toUpperCase().equals("AND")||token.toUpperCase().equals("NOT")||token.toUpperCase().equals("OR")||token.equals("(")|| token.equals(")"))
                        {
                            j++;
                            i--;
                            continue;
                        }
                        else
                        {
                            data.add(token);
                            data.add(termVectors.get(i-1));
                            j++;

                        }
                            model.addRow(data);

                        }
                   
            }
                else if(tabel==0)
                {
                    model.addColumn("Terms");
                    model.addColumn("Documents");
                    model.addColumn("Document 2");
                    model.addColumn("Document 3");
                    model.addColumn("Document 4");
                    for ( String token : Files.AllTockens)
                    {
                        Vector<Object> data = new Vector<Object>();
                        data.add(token);
                        data.add(table2.arrr1);
                        data.add(table2.arrr2);
                        data.add(table2.arrr3);
                        data.add(table2.arrr4);
                        model.addRow(data);

                    }

                    
                }
                
                
            }
        
        if(taskno==3)
        {
            model.addColumn("tokens");
            model.addColumn("Document");
            model.addColumn("index");


               for (int i = 0; i < pos.DocCopy.size(); i++) {
                    ArrayList<String> tokens=new ArrayList<String>();
                    String tokenname= pos.DocCopy.get(i).token;
                    Vector<Object> data = new Vector<Object>();
                        data.add(tokenname);
                        for(File f: files )
                        {
                            if(f.getPath().equals(pos.DocCopy.get(i).doc.Docname))
                            {
                                data.add(f.getName());

                            break;
                            }
                        }
                        data.add(pos.DocCopy.get(i).doc.Index);
                        model.addRow(data);
               }
                        
//                for (int j = 0; j < pos.DocCopy.size(); j++)
//                {
//                    Vector<Object> data = new Vector<Object>();
//                    data.add(tokenname);
//                    
//                    if(pos.DocCopy.get(j).token.equals(tokenname))
//                    {
//                       for(File f: files )
//                    {
//                        if(f.getPath().equals(pos.DocCopy.get(j).doc.Docname))
//                        {
//                            data.add(f.getName());
//                        
//                        break;
//                        }
//                    }
//                       data.add(pos.DocCopy.get(j).doc.Index);
//                      model.addRow(data); 
//                      tokens.add(tokenname);
//                      
//                      
//                    }
//                }
  
               
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("NEXT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 834, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(taskno==2){
        new query(T,2,null,files,null).setVisible(true);
        
        }
        if(taskno==1){
          if(tabel!=0)  
          new Matched_Doc(null,1,res,files,null,null,t).setVisible(true);
          if(tabel==0)
          {new query(null,1,t,null,null).setVisible(true);
                this.setVisible(false);}
          

        }
        if(taskno==3)
        {
            new Matched_Doc(null, taskno, null, files, null,pos,null).setVisible(true);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
