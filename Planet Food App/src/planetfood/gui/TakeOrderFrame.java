/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planetfood.gui;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import planetfood.dao.CategoryDao;
import planetfood.dao.OrderDetailsDao;
import planetfood.dao.OrdersDao;
import planetfood.dao.ProductDao;
import planetfood.dbutil.DBConnection;
import planetfood.pojo.OrderDetails;
import planetfood.pojo.Orders;
import planetfood.pojo.Product;
import planetfood.pojo.UserProfile;

/**
 *
 * @author Shahnaz
 */
public class TakeOrderFrame extends javax.swing.JFrame {

    private HashMap<String,String>categories;
    private HashMap<String,Product>productList;
    private ArrayList<OrderDetails>orderList= new ArrayList<>();
    private Product p;
    private String catId;
    private String prodId;
    private String catName;
    private double subTotal;
    private double actualTotal;
    private double grandTotal;
    private double discountAmount;
    private double gstAmount;
    private double discountPer;
    private String ordId;
    private DefaultTableModel model;
    
    public TakeOrderFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
        lblUsername.setText("Welcome "+UserProfile.getUsername());
        loadProductDetails();
        model=(DefaultTableModel)jtProductDetails.getModel();
        clearAll();
  
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblLogout = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnAddToBasket = new javax.swing.JButton();
        jcCatName = new javax.swing.JComboBox();
        jcProdId = new javax.swing.JComboBox();
        txtProdName = new javax.swing.JTextField();
        txtProdPrice = new javax.swing.JTextField();
        txtQuantity = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtProductDetails = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        btnPayBill = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblDiscount = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtOrderId = new javax.swing.JTextField();
        txtSubTotal = new javax.swing.JTextField();
        txtDiscount = new javax.swing.JTextField();
        txtGstAmt = new javax.swing.JTextField();
        txtGrandAmt = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();
        btnCancle = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(8, 78, 78));

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("TAKE ORDER PANEL");

        lblLogout.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblLogout.setForeground(new java.awt.Color(255, 255, 255));
        lblLogout.setText("Logout");

        lblUsername.setFont(new java.awt.Font("Tw Cen MT", 3, 12)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(8, 78, 78));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Choose Product to Order", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tw Cen MT", 1, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tw Cen MT", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Product Category");

        jLabel5.setFont(new java.awt.Font("Tw Cen MT", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Product Id");

        jLabel6.setFont(new java.awt.Font("Tw Cen MT", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Product Name");

        jLabel7.setFont(new java.awt.Font("Tw Cen MT", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Product Price");

        jLabel8.setFont(new java.awt.Font("Tw Cen MT", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Quantity");

        btnAddToBasket.setBackground(new java.awt.Color(8, 78, 78));
        btnAddToBasket.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAddToBasket.setForeground(new java.awt.Color(255, 255, 255));
        btnAddToBasket.setText("Add To Basket");
        btnAddToBasket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddToBasketActionPerformed(evt);
            }
        });

        jcCatName.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcCatName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcCatNameActionPerformed(evt);
            }
        });

        jcProdId.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcProdId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcProdIdActionPerformed(evt);
            }
        });

        txtProdName.setEditable(false);

        txtProdPrice.setEditable(false);
        txtProdPrice.setFont(new java.awt.Font("Bell MT", 0, 14)); // NOI18N

        txtQuantity.setFont(new java.awt.Font("Bell MT", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jcCatName, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                    .addComponent(txtProdPrice))
                .addGap(70, 70, 70)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8)
                    .addComponent(jLabel5)
                    .addComponent(jcProdId, 0, 106, Short.MAX_VALUE)
                    .addComponent(txtQuantity))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jLabel6)
                        .addContainerGap(31, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtProdName, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAddToBasket))
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcCatName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcProdId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtProdName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtProdPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddToBasket))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(8, 78, 78));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Food Basket", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tw Cen MT", 1, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        jtProductDetails.setFont(new java.awt.Font("Bell MT", 0, 14)); // NOI18N
        jtProductDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PRODUCTID", "PRODUCTNAME", "PRICE", "QUANTITY", "AMOUNT"
            }
        ));
        jScrollPane1.setViewportView(jtProductDetails);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(8, 78, 78));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Basket Info", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tw Cen MT", 1, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        btnPayBill.setBackground(new java.awt.Color(8, 78, 78));
        btnPayBill.setFont(new java.awt.Font("Tw Cen MT", 1, 16)); // NOI18N
        btnPayBill.setForeground(new java.awt.Color(255, 255, 255));
        btnPayBill.setText("Pay Bill");
        btnPayBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPayBillActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tw Cen MT", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Order Id");

        jLabel10.setFont(new java.awt.Font("Tw Cen MT", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Sub Total");

        lblDiscount.setFont(new java.awt.Font("Tw Cen MT", 1, 16)); // NOI18N
        lblDiscount.setForeground(new java.awt.Color(255, 255, 255));
        lblDiscount.setText("Discount");

        jLabel12.setFont(new java.awt.Font("Tw Cen MT", 1, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Gst Amount");

        jLabel13.setFont(new java.awt.Font("Tw Cen MT", 1, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Grand Total");

        txtOrderId.setEditable(false);
        txtOrderId.setFont(new java.awt.Font("Bell MT", 0, 14)); // NOI18N

        txtSubTotal.setEditable(false);
        txtSubTotal.setFont(new java.awt.Font("Bell MT", 0, 14)); // NOI18N

        txtDiscount.setEditable(false);
        txtDiscount.setFont(new java.awt.Font("Bell MT", 0, 14)); // NOI18N

        txtGstAmt.setEditable(false);
        txtGstAmt.setFont(new java.awt.Font("Bell MT", 0, 14)); // NOI18N

        txtGrandAmt.setEditable(false);
        txtGrandAmt.setFont(new java.awt.Font("Bell MT", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lblDiscount)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSubTotal)
                            .addComponent(txtOrderId)
                            .addComponent(txtGstAmt)
                            .addComponent(txtGrandAmt, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(25, 25, 25))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnPayBill)
                .addGap(90, 90, 90))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtOrderId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDiscount)
                    .addComponent(txtDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtGstAmt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtGrandAmt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPayBill)
                .addGap(48, 48, 48))
        );

        btnBack.setBackground(new java.awt.Color(8, 78, 78));
        btnBack.setFont(new java.awt.Font("Tw Cen MT", 1, 16)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnCancle.setBackground(new java.awt.Color(8, 78, 78));
        btnCancle.setFont(new java.awt.Font("Tw Cen MT", 1, 16)); // NOI18N
        btnCancle.setForeground(new java.awt.Color(255, 255, 255));
        btnCancle.setText("Cancle Order");
        btnCancle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(218, 218, 218)
                        .addComponent(jLabel1)
                        .addGap(0, 74, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(255, 255, 255)
                                .addComponent(btnCancle))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(22, 22, 22)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(287, 287, 287)
                        .addComponent(lblLogout))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLogout)
                    .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(btnCancle))
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcCatNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcCatNameActionPerformed

        if(jcCatName.getSelectedItem()==null)
            return;
        try
        {
          catName=jcCatName.getSelectedItem().toString();
          catId=categories.get(catName).toString();
          productList=ProductDao.getProductByCategory(catId);
          jcProdId.removeAllItems();
          for(String ProdId:productList.keySet())
              jcProdId.addItem( ProdId);
        }
        catch(SQLException sq)
        {
            JOptionPane.showMessageDialog(null,"Problem In DataBase"+sq,"DataBase Error!",JOptionPane.ERROR_MESSAGE);
            sq.printStackTrace();
        }
        
    }//GEN-LAST:event_jcCatNameActionPerformed

    private void jcProdIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcProdIdActionPerformed

        if(jcProdId.getSelectedItem()==null)
            return;
        prodId=jcProdId.getSelectedItem().toString();
        Product p=productList.get(prodId);
        txtProdName.setText(p.getProdName());
        txtProdPrice.setText(String.valueOf(p.getProdPrice()));
        
    }//GEN-LAST:event_jcProdIdActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        
        this.dispose();
       CashierOptionFrame cashier=new CashierOptionFrame();
        cashier.setVisible(true);     
        
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnCancleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancleActionPerformed

         int ans;
        ans=JOptionPane.showConfirmDialog(null,"Are you Sure You Want To Cancle Order..??","Quitting",
                JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
        if(ans==JOptionPane.YES_NO_OPTION)
        {
            DBConnection.closeConnection();
            System.exit(0);
        }
    }//GEN-LAST:event_btnCancleActionPerformed

    private void btnAddToBasketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddToBasketActionPerformed

        String quantity=txtQuantity.getText();
        if(quantity==null)
        {
            JOptionPane.showMessageDialog(null, "Please set the quantity","Error!",JOptionPane.INFORMATION_MESSAGE);  
            return;
        }

      
            String price=txtProdPrice.getText();
            Object[] rows=new Object[5]; //no of colunm
        
            rows[0]=jcProdId.getSelectedItem().toString();
            rows[1]=txtProdName.getText();
            rows[2]=price;
            rows[3]=quantity;
            double amount=Double.parseDouble(price)*Double.parseDouble(quantity);
            rows[4]=amount;
            model.addRow(rows);
            actualTotal=actualTotal+amount;
            subTotal=actualTotal;
            System.out.println("subtotal before dis:"+subTotal);
            discountAmount=Math.round(discountPer*subTotal/100.0);
            txtDiscount.setText(String.valueOf(discountAmount));
            System.out.println("discount:"+discountAmount);
            subTotal=Math.round(subTotal-discountAmount);
            txtSubTotal.setText(String.valueOf(subTotal));
            System.out.println("subTotal after dis :"+subTotal);
            gstAmount=Math.round(5*subTotal/100.0);
            txtGstAmt.setText(String.valueOf(gstAmount));
            grandTotal=Math.round(subTotal+gstAmount);
            txtGrandAmt.setText(String.valueOf(grandTotal));
           
            OrderDetails obj=new OrderDetails();
            obj.setOrdId(ordId);
            obj.setProdId(prodId);
            obj.setQuantity(Double.parseDouble(quantity));
            obj.setCost(amount);
            orderList.add(obj);
            txtQuantity.setText("");
 
            
            
    }//GEN-LAST:event_btnAddToBasketActionPerformed

    private void btnPayBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPayBillActionPerformed

        Orders obj=new Orders();
        obj.setOrdId(ordId);
        java.util.Date today=new java.util.Date();
        SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yyyy");
        obj.setOrdDate(sdf.format(today));
        obj.setGst(gstAmount);
        obj.setOrdAmount(subTotal);
        obj.setGranTtotal(grandTotal);
        obj.setDiscount(discountAmount);
        obj.setUserId(UserProfile.getUserid());
        String message= "Your Bill Details: \nBill Amount: Rs "+actualTotal; 
        message+="\nDiscount: Rs "+discountAmount;
        message+="\nGST: Rs "+gstAmount;
        message+="\nAmount Payable:Rs "+grandTotal;
                JOptionPane.showMessageDialog(null, message);
        try
        {
            boolean status =OrderDetailsDao.addOrders(obj, orderList);
            if(status)
           {
                JOptionPane.showMessageDialog(null, "Order placed successfully ","Success!",JOptionPane.INFORMATION_MESSAGE);
                clearAll();
           }
           else
              JOptionPane.showMessageDialog(null, "Order not placed!","Order Denied!",JOptionPane.ERROR_MESSAGE);
            
        }
        catch(Exception ex)
        {
              JOptionPane.showMessageDialog(null, "Error while adding order! ","Exception!",JOptionPane.ERROR_MESSAGE); 
              ex.printStackTrace();
         } 

        
    }//GEN-LAST:event_btnPayBillActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TakeOrderFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TakeOrderFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TakeOrderFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TakeOrderFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TakeOrderFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddToBasket;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCancle;
    private javax.swing.JButton btnPayBill;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox jcCatName;
    private javax.swing.JComboBox jcProdId;
    private javax.swing.JTable jtProductDetails;
    private javax.swing.JLabel lblDiscount;
    private javax.swing.JLabel lblLogout;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JTextField txtDiscount;
    private javax.swing.JTextField txtGrandAmt;
    private javax.swing.JTextField txtGstAmt;
    private javax.swing.JTextField txtOrderId;
    private javax.swing.JTextField txtProdName;
    private javax.swing.JTextField txtProdPrice;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtSubTotal;
    // End of variables declaration//GEN-END:variables

    private void loadProductDetails() {
      
       try
        {
            jcCatName.removeAllItems();
            categories=CategoryDao.getAllCategoryId();
            for(String catName:categories.keySet())
                        jcCatName.addItem(catName);
                        ordId=OrderDetailsDao.getNewId();
                        txtOrderId.setText(ordId);
           do
           {
               String discountStr=JOptionPane.showInputDialog("How Much discount is offered ?");
           
               try
               {
                   discountPer=Double.parseDouble(discountStr);
                   lblDiscount.setText("Discount ("+discountPer+"%)");
                   break;
               }
               catch(Exception ex)
               {
                   JOptionPane.showMessageDialog(null,"Please Set numeric value for discount ","Error!",JOptionPane.ERROR_MESSAGE);
               }
              }
           while(true);
        }
       catch(SQLException sq)
       {
           JOptionPane.showMessageDialog(null,"Exception In DB ","Exception!",JOptionPane.ERROR_MESSAGE);
           sq.printStackTrace();
       }
    
    }
    public void clearAll()
    {
      //  txtProdPrice.setText("");
      //  txtProdName.setText("");
        txtQuantity.setText("");
        txtSubTotal.setText("");
        txtDiscount.setText("");
        txtGstAmt.setText("");
        txtGstAmt.setText("");
        txtGrandAmt.setText("");
    
    }
}