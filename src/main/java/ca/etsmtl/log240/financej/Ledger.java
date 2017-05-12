package ca.etsmtl.log240.financej;
/*
 * Ledger.java
 *
 * Created on March 9, 2008, 11:40 PM
 */

import java.sql.*;
import javax.swing.table.*;
import javax.swing.*;
import java.text.SimpleDateFormat;
import java.awt.Color;

/**
 *
 * @author  rovitotv
 */
public class Ledger extends javax.swing.JDialog {

    private Connection conn = null;
    private LedgerListTableModel dataModel = null;
    private TableColumn CategoryColumn;
    private JComboBox CategoryColumnComboBox;

    /** Creates new form Ledger */
    public Ledger(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        LedgerTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    public void SetDBConnection(Connection DBConn) {
        conn = DBConn;
        BuildAccountsComboBox();
        dataModel = new LedgerListTableModel(conn);
        LedgerTable.setModel(dataModel);
        dataModel.SetTotalLabel(TotalLabel);

        // add custom cell editor for category column
        CategoryColumn = LedgerTable.getColumnModel().getColumn(5);
        CategoryColumnComboBox = new JComboBox();
        CategoryColumn.setCellEditor(new DefaultCellEditor(CategoryColumnComboBox));
    }

    public void BuildAccountsComboBox() {
        ResultSet AccountResult;
        Statement s;

        AccountsComboBox.removeAllItems();
        if (conn != null) {
            try {
                s = conn.createStatement();
                AccountResult = s.executeQuery("select * from account order by name");
                while (AccountResult.next()) {
                    AccountsComboBox.addItem(new String(AccountResult.getString(1)));
                }
            } catch (Throwable e) {
                System.out.println(" . . . exception thrown: in AccountsComboBox");
                e.printStackTrace();
            }
        }
    }

    public void BuildCategoryComboBox() {
        ResultSet CategoryResult;
        Statement s;

        CategoryComboBox.removeAllItems();
        CategoryColumnComboBox.removeAllItems();
        if (conn != null) {
            try {
                s = conn.createStatement();
                CategoryResult = s.executeQuery("select * from category order by name");
                while (CategoryResult.next()) {
                    CategoryComboBox.addItem(new String(CategoryResult.getString(1)));
                    CategoryColumnComboBox.addItem(new String(CategoryResult.getString(1)));
                }
            } catch (Throwable e) {
                System.out.println(" . . . exception thrown: in BuildCategoryComboBox");
                e.printStackTrace();
            }
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CloseButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        LedgerTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        AddTransactionButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        DateTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        DescriptionTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        AmountTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        PayeeTextField = new javax.swing.JTextField();
        RecCheckBox = new javax.swing.JCheckBox();
        CategoryComboBox = new javax.swing.JComboBox();
        DeleteTransactionButton = new javax.swing.JButton();
        AccountsComboBox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        TotalLabel = new javax.swing.JLabel();

        setTitle("Ledger");
        setMinimumSize(new java.awt.Dimension(785, 465));

        CloseButton.setText("Close");
        CloseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseButtonActionPerformed(evt);
            }
        });

        LedgerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Rec", "Date", "Payee", "Description", "Category", "Amount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Boolean.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(LedgerTable);
        LedgerTable.getColumnModel().getColumn(0).setPreferredWidth(10);
        LedgerTable.getColumnModel().getColumn(1).setPreferredWidth(5);

        AddTransactionButton.setText("Add Transaction");
        AddTransactionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddTransactionButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Date:");

        jLabel3.setText("Description:");

        jLabel4.setText("Category:");

        jLabel5.setText("Amount:");

        jLabel6.setText("Payee:");

        RecCheckBox.setText("Rec");
        RecCheckBox.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(3, 3, 3)
                        .addComponent(DateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PayeeTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(RecCheckBox)
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AddTransactionButton, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(CategoryComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel5)
                                        .addGap(4, 4, 4)
                                        .addComponent(AmountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(DescriptionTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(DateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PayeeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(DescriptionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addComponent(RecCheckBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(AmountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AddTransactionButton))
                    .addComponent(jLabel5)
                    .addComponent(CategoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap())
        );

        DeleteTransactionButton.setText("Delete Transaction");
        DeleteTransactionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteTransactionButtonActionPerformed(evt);
            }
        });

        AccountsComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        AccountsComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AccountsComboBoxActionPerformed(evt);
            }
        });

        jLabel1.setText("Account:");

        TotalLabel.setText("Total:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TotalLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AccountsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(DeleteTransactionButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CloseButton)
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 725, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CloseButton)
                    .addComponent(DeleteTransactionButton)
                    .addComponent(AccountsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(TotalLabel))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void CloseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseButtonActionPerformed
        setVisible(false);
    }//GEN-LAST:event_CloseButtonActionPerformed

    private void AddTransactionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddTransactionButtonActionPerformed
        int ReturnCode;
        String AmountValue;
        float Amount;
        int RecValue;
        java.util.Date TDate;
        SimpleDateFormat DateFormatTdate;
        String TdateString;
        String TCat;

        // get the amount field and format it properly
        AmountValue = AmountTextField.getText();
        Amount = Float.valueOf(AmountValue.trim()).floatValue();

        // get the rec field and format it properly
        boolean RecBool = RecCheckBox.isSelected();
        if (RecBool) {
            RecValue = 1;
        } else {
            RecValue = 0;
        }

        // get the date field and format it properly
        TdateString = DateTextField.getText();
        DateFormatTdate = new SimpleDateFormat("yyyy-MM-dd");
        TDate = new java.util.Date();

        try {
            TDate = DateFormatTdate.parse(TdateString);
        } catch (Throwable e) {
            System.out.println("...exception thrown: in AddTransactionButtonActionPerformed");
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,
                    "Error parsing date. Format must be in yyyy-MM-dd form.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        
        
        
        	if (CategoryComboBox.getSelectedItem() == null){
           System.out.println("...exception thrown: in AddTransactionButtonActionPerformed");
            JOptionPane.showMessageDialog(this,
                    "Error. Category must be created first.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;}
        	
        	if (AccountsComboBox.getSelectedItem() == null){
                System.out.println("...exception thrown: in AddTransactionButtonActionPerformed");
                 JOptionPane.showMessageDialog(this,
                         "Error. Account must be created first.",
                         "Error", JOptionPane.ERROR_MESSAGE);
                 return;}
        

        ReturnCode = dataModel.AddLedger(RecValue, TDate, PayeeTextField.getText(),
                DescriptionTextField.getText(), (String) CategoryComboBox.getSelectedItem(),
                Amount, (String) AccountsComboBox.getSelectedItem());

        if (ReturnCode == 0) {
            DateTextField.setText("");
            PayeeTextField.setText("");
            DescriptionTextField.setText("");
            AmountTextField.setText("");
            RecCheckBox.setSelected(false);
        } else {
            JOptionPane.showMessageDialog(this,
                    "Error Adding transaction to database.  Make sure the transaction you specified does not already exist.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }//GEN-LAST:event_AddTransactionButtonActionPerformed

    private void DeleteTransactionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteTransactionButtonActionPerformed
        if (LedgerTable.getSelectionModel().getLeadSelectionIndex() >= 0) {
            System.out.println("delete row:" + LedgerTable.getSelectionModel().getLeadSelectionIndex());
            dataModel.DeleteLedger(LedgerTable.getSelectionModel().getLeadSelectionIndex());
        } else { //nothing selected give error messge
            JOptionPane.showMessageDialog(this,
                    "No transaction selected to delete, please select a transaction then click the delete button.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_DeleteTransactionButtonActionPerformed

    private void AccountsComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AccountsComboBoxActionPerformed
        System.out.println("Accounts Combo Box Performed:" + (String) AccountsComboBox.getSelectedItem());
        if ((AccountsComboBox.getSelectedItem() != null) && (dataModel != null)) {
            dataModel.SetAccountSelected((String) AccountsComboBox.getSelectedItem());
            dataModel.UpdateTotalLabel();
            dataModel.fireTableDataChanged();
        }
    }//GEN-LAST:event_AccountsComboBoxActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                Ledger dialog = new Ledger(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox AccountsComboBox;
    private javax.swing.JButton AddTransactionButton;
    private javax.swing.JTextField AmountTextField;
    private javax.swing.JComboBox CategoryComboBox;
    private javax.swing.JButton CloseButton;
    private javax.swing.JTextField DateTextField;
    private javax.swing.JButton DeleteTransactionButton;
    private javax.swing.JTextField DescriptionTextField;
    private javax.swing.JTable LedgerTable;
    private javax.swing.JTextField PayeeTextField;
    private javax.swing.JCheckBox RecCheckBox;
    private javax.swing.JLabel TotalLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

class LedgerListTableModel extends AbstractTableModel {

    private String[] columnNames = {"id", "Rec", "Date", "Payee", "Description", "Category", "Amount"};
    private Connection conn = null;
    private String AccountSelected;
    private JLabel TotalLabel;

    public LedgerListTableModel(Connection DBConn) {
        conn = DBConn;
        AccountSelected = "NotAnAccountToday";
    }

    public void SetTotalLabel(JLabel Label) {
        TotalLabel = Label;
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public void SetAccountSelected(String Account) {
        AccountSelected = Account;
    }

    public int getRowCount() {
        ResultSet LedgerResult;
        Statement s;

        if (conn != null) {
            try {
                s = conn.createStatement();
                LedgerResult = s.executeQuery("select count(id) from ledger where account = '" + AccountSelected + "'");
                while (LedgerResult.next()) {
                    return LedgerResult.getInt(1);
                }
            } catch (Throwable e) {
                System.out.println(" . . . exception thrown: in LedgerListTableModel getRowCount");
                e.printStackTrace();
            }
        }

        return 0;
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        ResultSet LedgerResult;
        Statement s;
        int CurrentRow = 0;

        if (conn != null) {
            try {
                s = conn.createStatement();
                LedgerResult = s.executeQuery("select id,rec,tdate,payee,description,category,amount from ledger where account = '" + AccountSelected + "' order by id");
                while (LedgerResult.next()) {
                    if (CurrentRow == row) {
                        if (col == 0) {
                            return LedgerResult.getInt(1);
                        } else if (col == 1) {
                            int TempRecValue;
                            Boolean Rec;

                            TempRecValue = LedgerResult.getInt(2);
                            if (TempRecValue == 0) {
                                Rec = false;
                            } else {
                                Rec = true;
                            }
                            return Rec;
                        } else if (col == 2) {
                            java.sql.Date TDate;

                            TDate = LedgerResult.getDate(3);
                            return TDate.toString();
                        } else if (col == 3) {
                            return LedgerResult.getString(4);
                        } else if (col == 4) {
                            return LedgerResult.getString(5);
                        } else if (col == 5) {
                            return LedgerResult.getString(6);
                        } else if (col == 6) {
                            return LedgerResult.getFloat(7);
                        }
                    }
                    CurrentRow++;
                }
            } catch (Throwable e) {
                System.out.println(" . . . exception thrown: in LedgerListTableModel getValueAt");
                e.printStackTrace();
            }
        }
        return "";
    }

    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    /*
     * Don't need to implement this method unless your table's
     * editable.
     */
    public boolean isCellEditable(int row, int col) {
        //Note that the data/cell address is constant,
        //no matter where the cell appears onscreen.


        if (col == 0) {
            return false;
        } else if (col == 2) {
            return true;
        } else {
            return true;
        }
    }

    public void setValueAt(Object value, int row, int col) {
        String SQLString = "";

        Integer LedgerId;

        try {
            LedgerId = (Integer) getValueAt(row, 0);

            Statement s = conn.createStatement();
            if (col == 1) {
                Boolean Rec;
                Integer RecValue;

                Rec = (Boolean) value;
                if (Rec) {
                    RecValue = 1;
                } else {
                    RecValue = 0;
                }
                SQLString = "update Ledger set rec =" + RecValue.toString() + " where id = " + LedgerId.toString() + "";
            } else if (col == 2) {
                String DateValue = (String) value;
                SimpleDateFormat DateFormatTdate = new SimpleDateFormat("yyyy-MM-dd");
                java.util.Date TDate = new java.util.Date();

                // TDate = DateFormatTdate.parse(DateValue);

                try {
                    TDate = DateFormatTdate.parse(DateValue);
                    System.out.println("Date:" + TDate.toString());
                } catch (Throwable e) {
                    System.out.println("...exception thrown: in AddTransactionButtonActionPerformed");
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null,
                            "Error parsing date. Format must be in yyyy-MM-dd form.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }



                java.sql.Date SQLTDate = new java.sql.Date(TDate.getTime());

                SQLString = "update Ledger set tdate = '" + SQLTDate.toString() + "' where id = " + LedgerId.toString() + "";
            } else if (col == 3) {
                SQLString = "update Ledger set payee ='" + (String) value + "' where id = " + LedgerId.toString() + "";
            } else if (col == 4) {
                SQLString = "update Ledger set description ='" + (String) value + "' where id = " + LedgerId.toString() + "";
            } else if (col == 5) {
                SQLString = "update Ledger set category ='" + (String) value + "' where id = " + LedgerId.toString() + "";
            } else if (col == 6) {
                String StrValue;

                StrValue = value.toString();
                SQLString = "update Ledger set amount = " + StrValue + " where id = " + LedgerId.toString() + "";
            }

            System.out.println(SQLString);
            s.execute(SQLString);

            fireTableCellUpdated(row, col);
            UpdateTotalLabel();
        } catch (Throwable e) {
            System.out.println(" . . . exception thrown: in setValueAt in Ledger.java");
            e.printStackTrace();
        }
    }

    public void DeleteLedger(int row) {
        Statement s;
        Integer LedgerId;
        String SQLString;

        if (conn != null) {
            try {
                LedgerId = (Integer) getValueAt(row, 0);

                s = conn.createStatement();
                SQLString = "DELETE FROM Ledger WHERE id = " + LedgerId.toString() + "";
                System.out.println(SQLString);
                s.executeUpdate(SQLString);
                fireTableDataChanged();
                UpdateTotalLabel();
            } catch (Throwable e) {
                System.out.println(" . . . exception thrown: in LedgerTableModel DeleteAccount");
                e.printStackTrace();
            }
        }
    }

//     private String[] columnNames = {"id", "Rec", "Date", "Payee", "Description", "Category", "Amount"};
    public int AddLedger(int Rec, java.util.Date TDate, String Payee, String Description, String Category, float amount, String account) {
        int ErrorCode = 0;
        PreparedStatement psInsert;
        java.sql.Date SQLDate;

        try {
            SQLDate = new java.sql.Date(TDate.getTime());
            psInsert = conn.prepareStatement("insert into Ledger(rec, tdate, payee, description, category, amount, account) values(?,?,?,?,?,?,?)");
            psInsert.setInt(1, Rec);
            psInsert.setDate(2, SQLDate);
            psInsert.setString(3, Payee);
            psInsert.setString(4, Description);
            psInsert.setString(5, Category);
            psInsert.setFloat(6, amount);
            psInsert.setString(7, account);

            psInsert.executeUpdate();
            fireTableRowsInserted(getRowCount() + 1, getRowCount() + 1);
            UpdateTotalLabel();
        } catch (Throwable e) {
            System.out.println(" . . . exception thrown: AddLedger");
            e.printStackTrace();
            ErrorCode = 1;
        }

        return ErrorCode;
    }

    public void UpdateTotalLabel() {
        ResultSet LedgerResult;
        Statement s;
        String TotalStr;

        TotalStr = "$0.00";
        if (conn != null) {
            try {
                s = conn.createStatement();
                LedgerResult = s.executeQuery("select sum(amount) from ledger where account = '" + AccountSelected + "'");
                while (LedgerResult.next()) {
                    if (LedgerResult.getFloat(1) <= 0) {
                        Color fg = new Color(255, 51, 50);
                        TotalLabel.setForeground(fg);
                    } else {
                        Color fg = new Color(0, 0, 0);
                        TotalLabel.setForeground(fg);
                    }
                    TotalStr = String.format("Total: $%12.2f", LedgerResult.getFloat(1));
                    TotalLabel.setText(TotalStr);
                }
            } catch (Throwable e) {
                System.out.println(" . . . exception thrown: in AccountListTableModel getValueAt");
                e.printStackTrace();
            }
        }

    }
}

