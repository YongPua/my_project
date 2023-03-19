//Pua Zhe Yong TP064865
//Wong Xin Ying TP064308

package apu.cafeteria;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import javax.swing.JOptionPane;

import java.io.IOException;

public class Login extends javax.swing.JFrame {   
    String ID;
    
    public Login() {
        initComponents();
        this.setLocationRelativeTo(null); // set form to center
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jLoginFrame = new javax.swing.JPanel();
        jID = new javax.swing.JTextField();
        jPass = new javax.swing.JPasswordField();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLoginFrame.setBackground(new java.awt.Color(255, 255, 255));

        jID.setFont(new java.awt.Font("Elephant", 0, 24)); // NOI18N
        jID.setForeground(new java.awt.Color(0, 204, 204));
        jID.setName("jID"); // NOI18N
        jID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jIDActionPerformed(evt);
            }
        });

        jPass.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jPass.setForeground(new java.awt.Color(0, 204, 204));
        jPass.setName("LoginPs"); // NOI18N
        jPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPassActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Elephant", 0, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 204, 204));
        jButton3.setText("Close");
        jButton3.setName("CloseBtn"); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Elephant", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 204));
        jLabel1.setText("ID :");
        jLabel1.setToolTipText("");

        jLabel3.setFont(new java.awt.Font("Elephant", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 204, 204));
        jLabel3.setText("Password :");
        jLabel3.setToolTipText("");

        jButton4.setFont(new java.awt.Font("Elephant", 0, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 204, 204));
        jButton4.setText("Sign In");
        jButton4.setName("SignInBtn"); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Luminari", 0, 24)); // NOI18N
        jLabel2.setText("Login");

        javax.swing.GroupLayout jLoginFrameLayout = new javax.swing.GroupLayout(jLoginFrame);
        jLoginFrame.setLayout(jLoginFrameLayout);
        jLoginFrameLayout.setHorizontalGroup(
            jLoginFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLoginFrameLayout.createSequentialGroup()
                .addGroup(jLoginFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLoginFrameLayout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(jButton4)
                        .addGap(41, 41, 41)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jLoginFrameLayout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addGroup(jLoginFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addGap(27, 27, 27)
                        .addGroup(jLoginFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPass, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jID, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jLoginFrameLayout.createSequentialGroup()
                        .addGap(206, 206, 206)
                        .addComponent(jLabel2)))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jLoginFrameLayout.setVerticalGroup(
            jLoginFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLoginFrameLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addGroup(jLoginFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jID, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jLoginFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jLoginFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLoginFrame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLoginFrame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jIDActionPerformed

    private void jPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPassActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        LoginCredentials log = new LoginCredentials();
        
        log.setUserID(jID.getText());
        log.setPass(jPass.getText());
        
        ID = jID.getText();
        String pass = jPass.getText();
        String str;
        int y = 0;
        
        if(log.getUserID().contains("Manager"))
        {
            ManagerHome home = new ManagerHome();
            try{
                FileReader manager = new FileReader("/Users/yongpua/Desktop/Java/Java Assignment/src/apu/cafeteria/Manager.txt");
                BufferedReader read = new BufferedReader(manager);

                try{
                while((str = read.readLine()) != null){
                    String[] split = str.split(" , ");
                    
                    if (log.getUserID().equals(split[0]) && pass.equals(split[1])){
                        y = 1;
                        home.setVisible(true);
                        home.pack();
                        home.setLocationRelativeTo(null);
                        home.setDefaultCloseOperation(Login.EXIT_ON_CLOSE);
                        this.dispose();
                        break;
                    } 
                    
                }
                if(y == 0){
                    JOptionPane.showMessageDialog(home, "Wrong ID and Password. Please Try Again.");
                }
                }catch(IOException e){
                    JOptionPane.showMessageDialog(home, "No input detected. Please Try Again.");
                }
                
            } catch (FileNotFoundException e){
               JOptionPane.showMessageDialog(home, "File not found");
            }     
        }
        else 
        {
            CusMenu passid = new CusMenu(ID);
            try{
                FileReader customer = new FileReader("/Users/yongpua/Desktop/Java/Java Assignment/src/apu/cafeteria/Customer.txt");
                BufferedReader read2 = new BufferedReader(customer);
                
                try{
                while((str = read2.readLine()) != null){
                    String[] split = str.split(" , ");
                    
                    if (ID.equals(split[7]) && pass.equals(split[8])){
                        y = 1;
                        passid.setVisible(true);
                        passid.pack();
                        passid.setLocationRelativeTo(null);
                        passid.setDefaultCloseOperation(Login.EXIT_ON_CLOSE);
                        this.dispose(); 
                        break;
                    }
                }
                if(y == 0){
                    JOptionPane.showMessageDialog(passid, "Wrong ID and Password. Please Try Again.");
                }
                }catch(IOException e){
                     JOptionPane.showMessageDialog(passid, "No input detected. Please Try Again.");
                }
                
            } catch (FileNotFoundException e){
               JOptionPane.showMessageDialog(passid, "File not found");
            }  
            
           
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JTextField jID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jLoginFrame;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPasswordField jPass;
    // End of variables declaration//GEN-END:variables
}
