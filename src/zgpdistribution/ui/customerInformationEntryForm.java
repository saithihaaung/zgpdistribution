/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zgpdistribution.ui;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import zgpdistribution.util.CityDAO;
import zgpdistribution.util.CountryDAO;
import zgpdistribution.util.StateDAO;
import zgpdistribution.util.TownshipDAO;
import zgpdistribution.util.oops.City;
import zgpdistribution.util.oops.Country;
import zgpdistribution.util.oops.State;
import zgpdistribution.util.oops.Township;

/**
 *
 * @author John
 */
public class customerInformationEntryForm extends javax.swing.JFrame {

    /**
     * Creates new form customerInformationEntryForm
     */
    public customerInformationEntryForm() {
        initComponents();
        initFormData();
    }

    private void initFormData() {
        jComboBoxTownship.addItem("-- Select One --");
        jComboBoxCity.addItem("-- Select One --");
        jComboBoxState.addItem("-- Select One --");
        jComboBoxCountry.addItem("-- Select One --");
        try {
            ArrayList<Township> tspList = new TownshipDAO().queryAll();
            for (Township township : tspList) {
                jComboBoxTownship.addItem(township.getName());
            }
            ArrayList<City> cityList = new CityDAO().queryAll();
            for (City city : cityList) {
                jComboBoxCity.addItem(city.getName());
            }
            ArrayList<State> stateList = new StateDAO().queryAll();
            for (State state : stateList) {
                jComboBoxState.addItem(state.getName());
            }
            ArrayList<Country> countryList = new CountryDAO().queryAll();
            for (Country country : countryList) {
                jComboBoxCountry.addItem(country.getName());
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanelBase = new javax.swing.JPanel();
        jLabelOutletName = new javax.swing.JLabel();
        jLabelCustomerName = new javax.swing.JLabel();
        jLabelAddress = new javax.swing.JLabel();
        jLabelTsp = new javax.swing.JLabel();
        jLabelCity = new javax.swing.JLabel();
        jLabelState = new javax.swing.JLabel();
        jLabelCountry = new javax.swing.JLabel();
        jLabelPhone = new javax.swing.JLabel();
        jLabelMail = new javax.swing.JLabel();
        jTextFieldOutletName = new javax.swing.JTextField();
        jTextFieldCustomerName = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaAddress = new javax.swing.JTextArea();
        jTextFieldPhone = new javax.swing.JTextField();
        jTextFieldEmail = new javax.swing.JTextField();
        jPanelCustomerType = new javax.swing.JPanel();
        jRadioButtonRetail = new javax.swing.JRadioButton();
        jRadioButtonPTR = new javax.swing.JRadioButton();
        jRadioButtonPTROutlet = new javax.swing.JRadioButton();
        jRadioButtonWholeslae = new javax.swing.JRadioButton();
        jRadioButtonMT = new javax.swing.JRadioButton();
        jRadioButtonDealer = new javax.swing.JRadioButton();
        jLabelFax = new javax.swing.JLabel();
        jTextFieldFax = new javax.swing.JTextField();
        jButtonSave = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        jComboBoxCountry = new javax.swing.JComboBox();
        jComboBoxState = new javax.swing.JComboBox();
        jComboBoxTownship = new javax.swing.JComboBox();
        jComboBoxCity = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Customer Information Entry");

        jPanelBase.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Customer Information Entry", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 1, 14))); // NOI18N

        jLabelOutletName.setText("Outlet Name : ");

        jLabelCustomerName.setText("Customer Name : ");

        jLabelAddress.setText("Address : ");

        jLabelTsp.setText("Township : ");

        jLabelCity.setText("City : ");

        jLabelState.setText("State / Devision : ");

        jLabelCountry.setText("Country : ");

        jLabelPhone.setText("Phone : ");

        jLabelMail.setText("e-mail : ");

        jTextAreaAddress.setColumns(20);
        jTextAreaAddress.setRows(5);
        jScrollPane1.setViewportView(jTextAreaAddress);

        jPanelCustomerType.setBorder(javax.swing.BorderFactory.createTitledBorder("Customer Type"));

        buttonGroup2.add(jRadioButtonRetail);
        jRadioButtonRetail.setText("Retail");

        buttonGroup2.add(jRadioButtonPTR);
        jRadioButtonPTR.setText("PTR");

        buttonGroup2.add(jRadioButtonPTROutlet);
        jRadioButtonPTROutlet.setText("PTR Outlet");

        buttonGroup2.add(jRadioButtonWholeslae);
        jRadioButtonWholeslae.setText("Wholesale");
        jRadioButtonWholeslae.setToolTipText("");

        buttonGroup2.add(jRadioButtonMT);
        jRadioButtonMT.setText("MT");

        buttonGroup2.add(jRadioButtonDealer);
        jRadioButtonDealer.setText("Dealer");

        javax.swing.GroupLayout jPanelCustomerTypeLayout = new javax.swing.GroupLayout(jPanelCustomerType);
        jPanelCustomerType.setLayout(jPanelCustomerTypeLayout);
        jPanelCustomerTypeLayout.setHorizontalGroup(
            jPanelCustomerTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCustomerTypeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCustomerTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButtonRetail)
                    .addComponent(jRadioButtonPTR)
                    .addComponent(jRadioButtonPTROutlet))
                .addGap(40, 40, 40)
                .addGroup(jPanelCustomerTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButtonDealer)
                    .addComponent(jRadioButtonMT)
                    .addComponent(jRadioButtonWholeslae))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelCustomerTypeLayout.setVerticalGroup(
            jPanelCustomerTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCustomerTypeLayout.createSequentialGroup()
                .addGroup(jPanelCustomerTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonRetail)
                    .addComponent(jRadioButtonWholeslae))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelCustomerTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonPTR)
                    .addComponent(jRadioButtonMT))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelCustomerTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonPTROutlet)
                    .addComponent(jRadioButtonDealer)))
        );

        jLabelFax.setText("Fax : ");

        jButtonSave.setText("Save");

        jButtonCancel.setText("Cancel");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBaseLayout = new javax.swing.GroupLayout(jPanelBase);
        jPanelBase.setLayout(jPanelBaseLayout);
        jPanelBaseLayout.setHorizontalGroup(
            jPanelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBaseLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanelCustomerType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelBaseLayout.createSequentialGroup()
                        .addGroup(jPanelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelBaseLayout.createSequentialGroup()
                                .addGroup(jPanelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelOutletName)
                                    .addComponent(jLabelCustomerName)
                                    .addComponent(jLabelAddress)
                                    .addComponent(jLabelTsp)
                                    .addComponent(jLabelState)
                                    .addComponent(jLabelCountry)
                                    .addComponent(jLabelPhone)
                                    .addComponent(jLabelMail)
                                    .addComponent(jLabelFax))
                                .addGap(21, 21, 21))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelBaseLayout.createSequentialGroup()
                                .addComponent(jLabelCity)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(jTextFieldOutletName)
                            .addComponent(jTextFieldCustomerName)
                            .addComponent(jTextFieldPhone)
                            .addComponent(jTextFieldEmail)
                            .addComponent(jTextFieldFax)
                            .addComponent(jComboBoxCountry, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxState, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxTownship, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxCity, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addGroup(jPanelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonCancel, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))
                .addGap(22, 22, 22))
        );
        jPanelBaseLayout.setVerticalGroup(
            jPanelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBaseLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelBaseLayout.createSequentialGroup()
                        .addGroup(jPanelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelBaseLayout.createSequentialGroup()
                                .addGroup(jPanelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelOutletName)
                                    .addComponent(jTextFieldOutletName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelCustomerName)
                                    .addComponent(jTextFieldCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelAddress)
                                .addGap(80, 80, 80))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(jPanelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelTsp)
                            .addComponent(jComboBoxTownship, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelCity))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelBaseLayout.createSequentialGroup()
                        .addGroup(jPanelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelState)
                            .addComponent(jComboBoxState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelCountry)
                            .addComponent(jComboBoxCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelPhone)
                            .addComponent(jTextFieldPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelMail)
                            .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelFax)
                            .addComponent(jTextFieldFax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addComponent(jPanelCustomerType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButtonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelBase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelBase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        // TODO add your handling code here:
        if (jRadioButtonRetail.isSelected()) {
            JOptionPane.showMessageDialog(rootPane, jRadioButtonRetail.getText());
        }

        this.dispose();

    }//GEN-LAST:event_jButtonCancelActionPerformed

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
            java.util.logging.Logger.getLogger(customerInformationEntryForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(customerInformationEntryForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(customerInformationEntryForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(customerInformationEntryForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new customerInformationEntryForm().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JComboBox jComboBoxCity;
    private javax.swing.JComboBox jComboBoxCountry;
    private javax.swing.JComboBox jComboBoxState;
    private javax.swing.JComboBox jComboBoxTownship;
    private javax.swing.JLabel jLabelAddress;
    private javax.swing.JLabel jLabelCity;
    private javax.swing.JLabel jLabelCountry;
    private javax.swing.JLabel jLabelCustomerName;
    private javax.swing.JLabel jLabelFax;
    private javax.swing.JLabel jLabelMail;
    private javax.swing.JLabel jLabelOutletName;
    private javax.swing.JLabel jLabelPhone;
    private javax.swing.JLabel jLabelState;
    private javax.swing.JLabel jLabelTsp;
    private javax.swing.JPanel jPanelBase;
    private javax.swing.JPanel jPanelCustomerType;
    private javax.swing.JRadioButton jRadioButtonDealer;
    private javax.swing.JRadioButton jRadioButtonMT;
    private javax.swing.JRadioButton jRadioButtonPTR;
    private javax.swing.JRadioButton jRadioButtonPTROutlet;
    private javax.swing.JRadioButton jRadioButtonRetail;
    private javax.swing.JRadioButton jRadioButtonWholeslae;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaAddress;
    private javax.swing.JTextField jTextFieldCustomerName;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldFax;
    private javax.swing.JTextField jTextFieldOutletName;
    private javax.swing.JTextField jTextFieldPhone;
    // End of variables declaration//GEN-END:variables
}
