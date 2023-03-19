//Pua Zhe Yong TP064865
//Wong Xin Ying TP064308

package apu.cafeteria;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.*;

public class Customer_Registration extends javax.swing.JFrame {
  
    public Customer_Registration() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCusRegis = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jUserID = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jAge = new javax.swing.JTextField();
        jDOB = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPassword = new javax.swing.JTextField();
        jCpassword = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jAddress = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPhone = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jEmail = new javax.swing.JTextField();
        jGender = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jCusRegis.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        jLabel3.setFont(new java.awt.Font("Luminari", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Customer Registration");

        jButton3.setFont(new java.awt.Font("Kannada MN", 0, 14)); // NOI18N
        jButton3.setText("HOME");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Kannada MN", 0, 14)); // NOI18N
        jButton4.setText("LOGOUT");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addGap(36, 36, 36)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel3)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jName.setFont(new java.awt.Font("Kannada MN", 0, 14)); // NOI18N
        jName.setToolTipText("");
        jName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNameActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Kannada MN", 0, 14)); // NOI18N
        jLabel1.setText("Name:");

        jUserID.setFont(new java.awt.Font("Kannada MN", 0, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Kannada MN", 0, 14)); // NOI18N
        jLabel9.setText("User ID:");

        jAge.setFont(new java.awt.Font("Kannada MN", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Kannada MN", 0, 14)); // NOI18N
        jLabel2.setText("Age:");

        jLabel4.setFont(new java.awt.Font("Kannada MN", 0, 14)); // NOI18N
        jLabel4.setText("DOB:");

        jLabel10.setFont(new java.awt.Font("Kannada MN", 0, 14)); // NOI18N
        jLabel10.setText("Password:");

        jPassword.setFont(new java.awt.Font("Kannada MN", 0, 14)); // NOI18N
        jPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordActionPerformed(evt);
            }
        });

        jCpassword.setFont(new java.awt.Font("Kannada MN", 0, 14)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Kannada MN", 0, 13)); // NOI18N
        jLabel11.setText("Confirm Password:");

        jLabel5.setFont(new java.awt.Font("Kannada MN", 0, 14)); // NOI18N
        jLabel5.setText("Gender:");

        jAddress.setFont(new java.awt.Font("Kannada MN", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Kannada MN", 0, 14)); // NOI18N
        jLabel6.setText("Address:");

        jPhone.setFont(new java.awt.Font("Kannada MN", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Kannada MN", 0, 14)); // NOI18N
        jLabel7.setText("Phone Number:");

        jLabel8.setFont(new java.awt.Font("Kannada MN", 0, 14)); // NOI18N
        jLabel8.setText("Email:");

        jGender.setFont(new java.awt.Font("Kannada MN", 0, 14)); // NOI18N
        jGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Female", "Male" }));

        jButton2.setBackground(new java.awt.Color(0, 204, 204));
        jButton2.setFont(new java.awt.Font("Kannada MN", 0, 14)); // NOI18N
        jButton2.setText("CLEAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 204, 204));
        jButton1.setFont(new java.awt.Font("Kannada MN", 0, 14)); // NOI18N
        jButton1.setText("REGISTER");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jCusRegisLayout = new javax.swing.GroupLayout(jCusRegis);
        jCusRegis.setLayout(jCusRegisLayout);
        jCusRegisLayout.setHorizontalGroup(
            jCusRegisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jCusRegisLayout.createSequentialGroup()
                .addGroup(jCusRegisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jCusRegisLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addGroup(jCusRegisLayout.createSequentialGroup()
                        .addGroup(jCusRegisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jCusRegisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jCusRegisLayout.createSequentialGroup()
                                    .addGap(71, 71, 71)
                                    .addComponent(jLabel8))
                                .addGroup(jCusRegisLayout.createSequentialGroup()
                                    .addGap(106, 106, 106)
                                    .addComponent(jLabel1)))
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jCusRegisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jGender, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jCusRegisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jAddress, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                                .addComponent(jAge)
                                .addComponent(jName)
                                .addComponent(jDOB)
                                .addComponent(jPhone, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                        .addGroup(jCusRegisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jCusRegisLayout.createSequentialGroup()
                                .addGroup(jCusRegisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(6, 6, 6))
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(12, 12, 12)
                        .addGroup(jCusRegisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jUserID, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(42, 42, 42))
        );
        jCusRegisLayout.setVerticalGroup(
            jCusRegisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jCusRegisLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jCusRegisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jCusRegisLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jCusRegisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jCusRegisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jCusRegisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jDOB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jCusRegisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jCusRegisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jCusRegisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jCusRegisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jButton1)
                            .addComponent(jButton2)))
                    .addGroup(jCusRegisLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(jCusRegisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jUserID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jCusRegisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jCusRegisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jCusRegis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jCusRegis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jNameActionPerformed

    private void jPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordActionPerformed

    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int age = 0, hp = 0;
        String name = jName.getText();
        Customer_Registration regis = new Customer_Registration();
        
        try{
        age = Integer.parseInt(jAge.getText());
        } catch (NumberFormatException e){
            System.out.println("Wrong Input. Please Try Again");
            jAge.setText("");
        }
        
        String dob = jDOB.getText();
        String gender = jGender.getSelectedItem().toString();
        String address = jAddress.getText();
        
        try{
        hp = Integer.parseInt(jPhone.getText());
        } catch(NumberFormatException e){
            System.out.println("Wrong Input. Please Try Again");
            jPhone.setText("");
        
        }

        String email = jEmail.getText();
        String userID = jUserID.getText();
        String password = jPassword.getText();
        String cpassword = jCpassword.getText();
        

        if (!(password.equals(cpassword))){
            JOptionPane.showMessageDialog(regis, "Confirmed Password not match with Password. Please try again.");
        } else if(age == 0){
            JOptionPane.showMessageDialog(regis, "Age not filled correctly. Please try again");
        } else if (hp == 0){
            JOptionPane.showMessageDialog(regis, "Phone number not filled correctly. Please try again");
        } else {      
            try{
            FileWriter register = new FileWriter("/Users/yongpua/Desktop/Java/Java Assignment/src/apu/cafeteria/Customer.txt",true);
            PrintWriter pw = new PrintWriter(register);
            String age2 = Integer.toString(age);
            String hp2 = Integer.toString(hp);

            pw.append(name+" , ");
            pw.append(age2+" , ");
            pw.append(dob+" , ");
            pw.append(gender+" , ");
            pw.append(address+" , ");
            pw.append(hp2+" , ");
            pw.append(email+" , ");
            pw.append(userID+" , ");
            pw.append(password+" , ");
            pw.println(cpassword);

            pw.close();
            register.close();
      
            JOptionPane.showMessageDialog(regis,"Registration Successful");

            } catch (IOException e){
            JOptionPane.showMessageDialog(regis,"Registration Unsucessful, Please Try Again.");
            }
            
        jName.setText("");
        jAge.setText("");
        jDOB.setText("");
        jAddress.setText("");
        jPhone.setText("");
        jEmail.setText("");
        jUserID.setText("");
        jPassword.setText("");
        jCpassword.setText("");
            
        }
              
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jName.setText("");
        jAge.setText("");
        jDOB.setText("");
        jAddress.setText("");
        jPhone.setText("");
        jEmail.setText("");
        jUserID.setText("");
        jPassword.setText("");
        jCpassword.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        ManagerHome mhome = new ManagerHome();
        mhome.setVisible(true);
        mhome.pack();
        mhome.setLocationRelativeTo(null);
        mhome.setDefaultCloseOperation(mhome.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        JFrame logout = new JFrame("Exit");
        if(JOptionPane.showConfirmDialog(logout,"Are you sure you want to exit?","Menu",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION){
            Login login = new Login();
            login.setVisible(true);
            login.pack();
            login.setLocationRelativeTo(null);
            login.setDefaultCloseOperation(Login.EXIT_ON_CLOSE);
            this.dispose();
            JOptionPane.showMessageDialog(login, "You Have been succesfully logout");
            
        }
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(Customer_Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Customer_Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Customer_Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Customer_Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Customer_Registration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField jAddress;
    private javax.swing.JTextField jAge;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JTextField jCpassword;
    private javax.swing.JPanel jCusRegis;
    private javax.swing.JTextField jDOB;
    private javax.swing.JTextField jEmail;
    private javax.swing.JComboBox<String> jGender;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jName;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jPassword;
    private javax.swing.JTextField jPhone;
    private javax.swing.JTextField jUserID;
    // End of variables declaration//GEN-END:variables
}
