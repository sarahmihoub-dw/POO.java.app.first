/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package InterfaceGraphique;

/**
 *
 * @author ya22y
 */
public class InterfaceSaisitQuantité extends javax.swing.JDialog {

    /**
     * Creates new form DataInputGUI
     */
    public InterfaceSaisitQuantité(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator6 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        qteTextfield = new javax.swing.JTextField();
        ModifyButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 102, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        qteTextfield.setBackground(new java.awt.Color(0, 102, 153));
        qteTextfield.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        qteTextfield.setForeground(new java.awt.Color(255, 255, 255));
        qteTextfield.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Quantité", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Waree", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        qteTextfield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                qteTextfieldKeyTyped(evt);
            }
        });
        jPanel1.add(qteTextfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 170, 70));

        ModifyButton.setFont(new java.awt.Font("Waree", 1, 18)); // NOI18N
        ModifyButton.setForeground(new java.awt.Color(0, 102, 153));
        ModifyButton.setText("modifier");
        ModifyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModifyButtonActionPerformed(evt);
            }
        });
        jPanel1.add(ModifyButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, -1, -1));

        exitButton.setBackground(new java.awt.Color(0, 102, 102));
        exitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/x-mark(white).png"))); // NOI18N
        exitButton.setBorder(null);
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });
        jPanel1.add(exitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, -1, -1));

        jLabel1.setFont(new java.awt.Font("Ubuntu", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/paint(blanc).png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-140, -10, 230, 200));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 230));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void qteTextfieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_qteTextfieldKeyTyped
        checkIfNumber(evt);
    }//GEN-LAST:event_qteTextfieldKeyTyped

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
      this.setVisible(false);
    }//GEN-LAST:event_exitButtonActionPerformed

    private void ModifyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModifyButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ModifyButtonActionPerformed

   private void checkIfNumber(java.awt.event.KeyEvent evt){
        char c= evt.getKeyChar();
        if(!Character.isDigit(c)|| c==java.awt.event.KeyEvent.VK_BACK_SPACE || c== java.awt.event.KeyEvent.VK_DELETE){
           getToolkit().beep();
           evt.consume();}
    }
    
    private void checkIfString(java.awt.event.KeyEvent evt){
        char c= evt.getKeyChar();
        if(!Character.isAlphabetic(c)|| c==java.awt.event.KeyEvent.VK_BACK_SPACE || c== java.awt.event.KeyEvent.VK_DELETE){
           getToolkit().beep();
           evt.consume();
        }
    }
     
    public String getValue(){
        return qteTextfield.getText();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton ModifyButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JTextField qteTextfield;
    // End of variables declaration//GEN-END:variables
}
