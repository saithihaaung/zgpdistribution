/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zgpdistribution.ui;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import zgpdistribution.util.CategoryDAO;
import zgpdistribution.util.CityDAO;
import zgpdistribution.util.CountryDAO;
import zgpdistribution.util.DepartmentDAO;
import zgpdistribution.util.EmployeeDAO;
import zgpdistribution.util.PositionDAO;
import zgpdistribution.util.StateDAO;
import zgpdistribution.util.SupplierDAO;
import zgpdistribution.util.TownshipDAO;
import zgpdistribution.util.oops.Category;
import zgpdistribution.util.oops.City;
import zgpdistribution.util.oops.Country;
import zgpdistribution.util.oops.Department;
import zgpdistribution.util.oops.Employee;
import zgpdistribution.util.oops.Position;
import zgpdistribution.util.oops.State;
import zgpdistribution.util.oops.Supplier;
import zgpdistribution.util.oops.Township;

/**
 *
 * @author John
 */
public class Base extends javax.swing.JFrame {

    /**
     * Creates new form Base
     */
    public Base() {
        initComponents();
        initFormData();
    }

    private void initFormData() {
        jComboBoxEmpRegTownship.addItem("-- Select One --");
        jComboBoxEmpRegCity.addItem("-- Select One --");
        jComboBoxEmpRegState.addItem("-- Select One --");
        jComboBoxEmpRegCountry.addItem("-- Select One --");
        jComboBoxEmpRegDepartment.addItem("-- Select One --");
        jComboBoxEmpRegManager.addItem("-- Select One --");
        jComboBoxEmpRegPosition.addItem("-- Select One --");
        jComboBoxCustRegTownship.addItem("-- Select One --");
        jComboBoxCustRegCity.addItem("-- Select One --");
        jComboBoxCustRegState.addItem("-- Select One --");
        jComboBoxCustRegCountry.addItem("-- Select One --");
        jComboBoxWhRegTownship.addItem("-- Select One --");
        jComboBoxWhRegCity.addItem("-- Select One --");
        jComboBoxWhRegState.addItem("-- Select One --");
        jComboBoxWhRegSupervisor.addItem("-- Select One --");
        jComboBoxItemRegCategory.addItem("-- Select One --");
        jComboBoxItemRegSupplier.addItem("-- Select One --");


        try {
            ArrayList<Township> tspList = new TownshipDAO().queryAll();
            for (Township township : tspList) {
                jComboBoxEmpRegTownship.addItem(township.getName());
                jComboBoxCustRegTownship.addItem(township.getName());
                jComboBoxWhRegTownship.addItem(township.getName());
            }
            ArrayList<City> cityList = new CityDAO().queryAll();
            for (City city : cityList) {
                jComboBoxEmpRegCity.addItem(city.getName());
                jComboBoxCustRegCity.addItem(city.getName());
                jComboBoxWhRegCity.addItem(city.getName());
            }
            ArrayList<State> stateList = new StateDAO().queryAll();
            for (State state : stateList) {
                jComboBoxEmpRegState.addItem(state.getName());
                jComboBoxCustRegState.addItem(state.getName());
                jComboBoxWhRegState.addItem(state.getName());
            }
            ArrayList<Country> countryList = new CountryDAO().queryAll();
            for (Country country : countryList) {
                jComboBoxEmpRegCountry.addItem(country.getName());
                jComboBoxCustRegCountry.addItem(country.getName());
            }
            ArrayList<Department> departmentList = new DepartmentDAO().queryAll();
            for (Department department : departmentList) {
                jComboBoxEmpRegDepartment.addItem(department.getName());
            }
            ArrayList<Employee> employeeList = new EmployeeDAO().queryMgr();
            for (Employee employee : employeeList) {
                jComboBoxEmpRegManager.addItem(employee.getName());
            }
            ArrayList<Employee> empList = new EmployeeDAO().querySupervisor();
            for (Employee employee : empList) {
                jComboBoxWhRegSupervisor.addItem(employee.getName());
            }
            ArrayList<Position> positionList = new PositionDAO().queryAll();
            for (Position position : positionList) {
                jComboBoxEmpRegPosition.addItem(position.getPosition());
            }
            ArrayList<Category> catList = new CategoryDAO().queryAll();
            for (Category category : catList) {
                jComboBoxItemRegCategory.addItem(category.getName());
            }
            ArrayList<Supplier> supplierList = new SupplierDAO().queryAll();
            for (Supplier supplier : supplierList) {
                jComboBoxItemRegSupplier.addItem(supplier.getName());
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private void resetEmpRegPannel() {
        jTextFieldEmpRegName.setText("");
        jTextFieldEmpRegNRCNo.setText("");
        jTextAreaEmpRegAddress.setText("");
        jTextFieldEmpRegMPhone.setText("");
        jTextFieldEmpRegEmail.setText("");
        jComboBoxEmpRegTownship.setSelectedIndex(0);
        jComboBoxEmpRegCity.setSelectedIndex(0);
        jComboBoxEmpRegState.setSelectedIndex(0);
        jComboBoxEmpRegCountry.setSelectedIndex(0);
        jComboBoxEmpRegDepartment.setSelectedIndex(0);
        jComboBoxEmpRegManager.setSelectedIndex(0);
        jComboBoxEmpRegPosition.setSelectedIndex(0);
        jTextFieldEmpRegWPhone.setText("");
    }

    private void resetCustRegPannel() {
        jTextFieldCustRegOutletName.setText("");
        jTextFieldCustRegCustomerName.setText("");
        jTextAreaCustRegAddress.setText("");
        jComboBoxCustRegTownship.setSelectedIndex(0);
        jComboBoxCustRegCity.setSelectedIndex(0);
        jComboBoxCustRegState.setSelectedIndex(0);
        jComboBoxCustRegCountry.setSelectedIndex(0);
        jTextFieldCustRegPhone.setText("");
        jTextFieldCustRegEmail.setText("");
        jTextFieldCustRegFax.setText("");
        jRadioButtonCustRegRetail.setSelected(true);
    }

    private void resetWarehouseRegPannel() {
        jTextFieldWhRegName.setText("");
        jTextAreaWhRegAddress.setText("");
        jComboBoxWhRegTownship.setSelectedIndex(0);
        jComboBoxWhRegCity.setSelectedIndex(0);
        jComboBoxWhRegState.setSelectedIndex(0);
        jComboBoxWhRegSupervisor.setSelectedIndex(0);
        jTextFieldWhRegPhone.setText("");
    }

    private void resetItemRegPannel() {
        jTextFieldItemRegName.setText("");
        jTextFieldItemRegCode.setText("");
        jTextFieldItemRegWeight.setText("");
        jComboBoxItemRegCategory.setSelectedIndex(0);
        jComboBoxItemRegSupplier.setSelectedIndex(0);
        jTextFieldItemRegPrize.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupCustRegCustomerType = new javax.swing.ButtonGroup();
        jTabbedPaneBase = new javax.swing.JTabbedPane();
        jPanelSetup = new javax.swing.JPanel();
        jTabbedPaneSetupBase = new javax.swing.JTabbedPane();
        jPanelCompanyReg = new javax.swing.JPanel();
        jPanelAccount = new javax.swing.JPanel();
        jPanelSRM = new javax.swing.JPanel();
        jTabbedPaneSRMBase = new javax.swing.JTabbedPane();
        jPanelSupplierREG = new javax.swing.JPanel();
        jPanelCRM = new javax.swing.JPanel();
        jTabbedPaneCRMBase = new javax.swing.JTabbedPane();
        jPanelCustReg = new javax.swing.JPanel();
        jButtonCustRegSave = new javax.swing.JButton();
        jButtonCustRegReset = new javax.swing.JButton();
        jLabelCustRegOutletName = new javax.swing.JLabel();
        jLabelCustRegCustomerName = new javax.swing.JLabel();
        jLabelCustRegAddress = new javax.swing.JLabel();
        jLabeCustReglTownship = new javax.swing.JLabel();
        jLabelCustRegCity = new javax.swing.JLabel();
        jLabelCustRegState = new javax.swing.JLabel();
        jLabelCustRegCountry = new javax.swing.JLabel();
        jLabelCustRegPhone = new javax.swing.JLabel();
        jLabelCustRegMail = new javax.swing.JLabel();
        jLabelCustRegFax = new javax.swing.JLabel();
        jTextFieldCustRegFax = new javax.swing.JTextField();
        jTextFieldCustRegEmail = new javax.swing.JTextField();
        jTextFieldCustRegPhone = new javax.swing.JTextField();
        jComboBoxCustRegCountry = new javax.swing.JComboBox();
        jComboBoxCustRegState = new javax.swing.JComboBox();
        jComboBoxCustRegCity = new javax.swing.JComboBox();
        jComboBoxCustRegTownship = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaCustRegAddress = new javax.swing.JTextArea();
        jTextFieldCustRegCustomerName = new javax.swing.JTextField();
        jTextFieldCustRegOutletName = new javax.swing.JTextField();
        jPanelCustomerType = new javax.swing.JPanel();
        jRadioButtonCustRegRetail = new javax.swing.JRadioButton();
        jRadioButtonCustRegPTR = new javax.swing.JRadioButton();
        jRadioButtonCustRegPTROutlet = new javax.swing.JRadioButton();
        jRadioButtonCustRegWholeslae = new javax.swing.JRadioButton();
        jRadioButtonCustRegMT = new javax.swing.JRadioButton();
        jRadioButtonCustRegDealer = new javax.swing.JRadioButton();
        jPanelSMGMT = new javax.swing.JPanel();
        jTabbedPaneSMGMTBase = new javax.swing.JTabbedPane();
        jPanelInvoicing = new javax.swing.JPanel();
        jPanelPos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanelDo = new javax.swing.JPanel();
        jPanelHRM = new javax.swing.JPanel();
        jTabbedPaneHRBase = new javax.swing.JTabbedPane();
        jPanelEmpReg = new javax.swing.JPanel();
        jPanelPersonal = new javax.swing.JPanel();
        jLabelEmpRegName = new javax.swing.JLabel();
        jLabelEmpRegNRCNo = new javax.swing.JLabel();
        jLabelEmpRegAddress = new javax.swing.JLabel();
        jLabelEmpRegTownship = new javax.swing.JLabel();
        jLabelEmpRegCity = new javax.swing.JLabel();
        jLabelEmpRegState = new javax.swing.JLabel();
        jLabelEmpRegCountry = new javax.swing.JLabel();
        jLabelEmpRegMPhone = new javax.swing.JLabel();
        jTextFieldEmpRegName = new javax.swing.JTextField();
        jTextFieldEmpRegNRCNo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaEmpRegAddress = new javax.swing.JTextArea();
        jLabelEmpRegEmail = new javax.swing.JLabel();
        jTextFieldEmpRegMPhone = new javax.swing.JTextField();
        jTextFieldEmpRegEmail = new javax.swing.JTextField();
        jComboBoxEmpRegCountry = new javax.swing.JComboBox();
        jComboBoxEmpRegTownship = new javax.swing.JComboBox();
        jComboBoxEmpRegCity = new javax.swing.JComboBox();
        jComboBoxEmpRegState = new javax.swing.JComboBox();
        jPanelWork = new javax.swing.JPanel();
        jLabelEmpRegDepartment = new javax.swing.JLabel();
        jLabelEmpRegManager = new javax.swing.JLabel();
        jLabelEmpRegPosition = new javax.swing.JLabel();
        jLabelEmpRegWPhone = new javax.swing.JLabel();
        jTextFieldEmpRegWPhone = new javax.swing.JTextField();
        jComboBoxEmpRegDepartment = new javax.swing.JComboBox();
        jComboBoxEmpRegPosition = new javax.swing.JComboBox();
        jComboBoxEmpRegManager = new javax.swing.JComboBox();
        jButtonEmpRegSave = new javax.swing.JButton();
        jButtonEmpRegReset = new javax.swing.JButton();
        jPanelWhManagement = new javax.swing.JPanel();
        jTabbedPaneWHMGMTBase = new javax.swing.JTabbedPane();
        jPanelWHREG = new javax.swing.JPanel();
        jLabelWhRegName = new javax.swing.JLabel();
        jLabelWhRegAddress = new javax.swing.JLabel();
        jLabelWhRegTownship = new javax.swing.JLabel();
        jLabelWhRegCity = new javax.swing.JLabel();
        jLabelState = new javax.swing.JLabel();
        jLabelWhRegPhone = new javax.swing.JLabel();
        jLabelWhRegSupervisor = new javax.swing.JLabel();
        jComboBoxWhRegSupervisor = new javax.swing.JComboBox();
        jTextFieldWhRegPhone = new javax.swing.JTextField();
        jComboBoxWhRegState = new javax.swing.JComboBox();
        jComboBoxWhRegCity = new javax.swing.JComboBox();
        jComboBoxWhRegTownship = new javax.swing.JComboBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaWhRegAddress = new javax.swing.JTextArea();
        jTextFieldWhRegName = new javax.swing.JTextField();
        jButtonWhRegSave = new javax.swing.JButton();
        jButtonWhRegResetl = new javax.swing.JButton();
        jPanelItemReg = new javax.swing.JPanel();
        jLabelItemRegName = new javax.swing.JLabel();
        jLabelItemRegCode = new javax.swing.JLabel();
        jLabelItemRegWeight = new javax.swing.JLabel();
        jLabelItemRegCategory = new javax.swing.JLabel();
        jLabelItemRegSupplier = new javax.swing.JLabel();
        jLabelItemRegPrize = new javax.swing.JLabel();
        jTextFieldItemRegPrize = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jComboBoxItemRegSupplier = new javax.swing.JComboBox();
        jComboBoxItemRegCategory = new javax.swing.JComboBox();
        jTextFieldItemRegWeight = new javax.swing.JTextField();
        jLabelGrams = new javax.swing.JLabel();
        jTextFieldItemRegCode = new javax.swing.JTextField();
        jTextFieldItemRegName = new javax.swing.JTextField();
        jButtonItemRegSave = new javax.swing.JButton();
        jButtonItemRegReset = new javax.swing.JButton();
        jPanelFleetMGMT = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jPanelReport = new javax.swing.JPanel();
        jTabbedPaneReportBase = new javax.swing.JTabbedPane();
        jPanelHelp = new javax.swing.JPanel();
        jTabbedPaneHelpBase = new javax.swing.JTabbedPane();
        jPanelContents = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanelAbout = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Zaw Gyi Premier Co., Ltd.  >> Distribution Management Software <<");
        setResizable(false);

        jTabbedPaneBase.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanelSetup.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTabbedPaneSetupBase.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanelCompanyReg.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Company Information Entry Form", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        javax.swing.GroupLayout jPanelCompanyRegLayout = new javax.swing.GroupLayout(jPanelCompanyReg);
        jPanelCompanyReg.setLayout(jPanelCompanyRegLayout);
        jPanelCompanyRegLayout.setHorizontalGroup(
            jPanelCompanyRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1197, Short.MAX_VALUE)
        );
        jPanelCompanyRegLayout.setVerticalGroup(
            jPanelCompanyRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 559, Short.MAX_VALUE)
        );

        jTabbedPaneSetupBase.addTab("COMPANY REG", jPanelCompanyReg);

        javax.swing.GroupLayout jPanelSetupLayout = new javax.swing.GroupLayout(jPanelSetup);
        jPanelSetup.setLayout(jPanelSetupLayout);
        jPanelSetupLayout.setHorizontalGroup(
            jPanelSetupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSetupLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPaneSetupBase)
                .addContainerGap())
        );
        jPanelSetupLayout.setVerticalGroup(
            jPanelSetupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSetupLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPaneSetupBase)
                .addContainerGap())
        );

        jTabbedPaneBase.addTab("SETUP", jPanelSetup);

        jPanelAccount.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanelAccountLayout = new javax.swing.GroupLayout(jPanelAccount);
        jPanelAccount.setLayout(jPanelAccountLayout);
        jPanelAccountLayout.setHorizontalGroup(
            jPanelAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1238, Short.MAX_VALUE)
        );
        jPanelAccountLayout.setVerticalGroup(
            jPanelAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 632, Short.MAX_VALUE)
        );

        jTabbedPaneBase.addTab("ACCOUNT", jPanelAccount);

        jPanelSRM.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTabbedPaneSRMBase.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanelSupplierREG.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Supplier Information Entry Form", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        javax.swing.GroupLayout jPanelSupplierREGLayout = new javax.swing.GroupLayout(jPanelSupplierREG);
        jPanelSupplierREG.setLayout(jPanelSupplierREGLayout);
        jPanelSupplierREGLayout.setHorizontalGroup(
            jPanelSupplierREGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1197, Short.MAX_VALUE)
        );
        jPanelSupplierREGLayout.setVerticalGroup(
            jPanelSupplierREGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 559, Short.MAX_VALUE)
        );

        jTabbedPaneSRMBase.addTab("SUPPLIER REG", jPanelSupplierREG);

        javax.swing.GroupLayout jPanelSRMLayout = new javax.swing.GroupLayout(jPanelSRM);
        jPanelSRM.setLayout(jPanelSRMLayout);
        jPanelSRMLayout.setHorizontalGroup(
            jPanelSRMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSRMLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPaneSRMBase)
                .addContainerGap())
        );
        jPanelSRMLayout.setVerticalGroup(
            jPanelSRMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSRMLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPaneSRMBase)
                .addContainerGap())
        );

        jTabbedPaneBase.addTab("SRM", jPanelSRM);

        jPanelCRM.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTabbedPaneCRMBase.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanelCustReg.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Coustomer Information Entry Form", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jButtonCustRegSave.setText("Save");
        jButtonCustRegSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCustRegSaveActionPerformed(evt);
            }
        });

        jButtonCustRegReset.setText("Reset");
        jButtonCustRegReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCustRegResetActionPerformed(evt);
            }
        });

        jLabelCustRegOutletName.setText("Outlet Name : ");

        jLabelCustRegCustomerName.setText("Customer Name : ");

        jLabelCustRegAddress.setText("Address : ");

        jLabeCustReglTownship.setText("Township : ");

        jLabelCustRegCity.setText("City : ");

        jLabelCustRegState.setText("State / Devision : ");

        jLabelCustRegCountry.setText("Country : ");

        jLabelCustRegPhone.setText("Phone : ");

        jLabelCustRegMail.setText("e-mail : ");

        jLabelCustRegFax.setText("Fax : ");

        jTextAreaCustRegAddress.setColumns(20);
        jTextAreaCustRegAddress.setRows(5);
        jScrollPane2.setViewportView(jTextAreaCustRegAddress);

        jPanelCustomerType.setBorder(javax.swing.BorderFactory.createTitledBorder("Customer Type"));

        buttonGroupCustRegCustomerType.add(jRadioButtonCustRegRetail);
        jRadioButtonCustRegRetail.setText("Retail");

        buttonGroupCustRegCustomerType.add(jRadioButtonCustRegPTR);
        jRadioButtonCustRegPTR.setText("PTR");

        buttonGroupCustRegCustomerType.add(jRadioButtonCustRegPTROutlet);
        jRadioButtonCustRegPTROutlet.setText("PTR Outlet");

        buttonGroupCustRegCustomerType.add(jRadioButtonCustRegWholeslae);
        jRadioButtonCustRegWholeslae.setText("Wholesale");
        jRadioButtonCustRegWholeslae.setToolTipText("");

        buttonGroupCustRegCustomerType.add(jRadioButtonCustRegMT);
        jRadioButtonCustRegMT.setText("MT");

        buttonGroupCustRegCustomerType.add(jRadioButtonCustRegDealer);
        jRadioButtonCustRegDealer.setText("Dealer");

        javax.swing.GroupLayout jPanelCustomerTypeLayout = new javax.swing.GroupLayout(jPanelCustomerType);
        jPanelCustomerType.setLayout(jPanelCustomerTypeLayout);
        jPanelCustomerTypeLayout.setHorizontalGroup(
            jPanelCustomerTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCustomerTypeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCustomerTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButtonCustRegRetail)
                    .addComponent(jRadioButtonCustRegPTR)
                    .addComponent(jRadioButtonCustRegPTROutlet))
                .addGap(40, 40, 40)
                .addGroup(jPanelCustomerTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButtonCustRegDealer)
                    .addComponent(jRadioButtonCustRegMT)
                    .addComponent(jRadioButtonCustRegWholeslae))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelCustomerTypeLayout.setVerticalGroup(
            jPanelCustomerTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCustomerTypeLayout.createSequentialGroup()
                .addGroup(jPanelCustomerTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonCustRegRetail)
                    .addComponent(jRadioButtonCustRegWholeslae))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelCustomerTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonCustRegPTR)
                    .addComponent(jRadioButtonCustRegMT))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelCustomerTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonCustRegPTROutlet)
                    .addComponent(jRadioButtonCustRegDealer)))
        );

        javax.swing.GroupLayout jPanelCustRegLayout = new javax.swing.GroupLayout(jPanelCustReg);
        jPanelCustReg.setLayout(jPanelCustRegLayout);
        jPanelCustRegLayout.setHorizontalGroup(
            jPanelCustRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCustRegLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCustRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanelCustomerType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelCustRegLayout.createSequentialGroup()
                        .addGroup(jPanelCustRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelCustRegLayout.createSequentialGroup()
                                .addGroup(jPanelCustRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelCustRegOutletName)
                                    .addComponent(jLabelCustRegCustomerName)
                                    .addComponent(jLabelCustRegAddress)
                                    .addComponent(jLabeCustReglTownship)
                                    .addComponent(jLabelCustRegState)
                                    .addComponent(jLabelCustRegCountry)
                                    .addComponent(jLabelCustRegPhone)
                                    .addComponent(jLabelCustRegMail)
                                    .addComponent(jLabelCustRegFax))
                                .addGap(21, 21, 21))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelCustRegLayout.createSequentialGroup()
                                .addComponent(jLabelCustRegCity)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanelCustRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2)
                            .addComponent(jTextFieldCustRegOutletName)
                            .addComponent(jTextFieldCustRegCustomerName)
                            .addComponent(jTextFieldCustRegPhone)
                            .addComponent(jTextFieldCustRegEmail)
                            .addComponent(jTextFieldCustRegFax)
                            .addComponent(jComboBoxCustRegCountry, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxCustRegState, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxCustRegTownship, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxCustRegCity, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addGroup(jPanelCustRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonCustRegReset, javax.swing.GroupLayout.DEFAULT_SIZE, 886, Short.MAX_VALUE)
                    .addComponent(jButtonCustRegSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelCustRegLayout.setVerticalGroup(
            jPanelCustRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCustRegLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCustRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCustRegLayout.createSequentialGroup()
                        .addGroup(jPanelCustRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelCustRegLayout.createSequentialGroup()
                                .addGroup(jPanelCustRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelCustRegOutletName)
                                    .addComponent(jTextFieldCustRegOutletName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelCustRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelCustRegCustomerName)
                                    .addComponent(jTextFieldCustRegCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelCustRegAddress)
                                .addGap(80, 80, 80))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(jPanelCustRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabeCustReglTownship)
                            .addComponent(jComboBoxCustRegTownship, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelCustRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxCustRegCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelCustRegCity))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelCustRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelCustRegState)
                            .addComponent(jComboBoxCustRegState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelCustRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelCustRegCountry)
                            .addComponent(jComboBoxCustRegCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelCustRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelCustRegPhone)
                            .addComponent(jTextFieldCustRegPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelCustRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelCustRegMail)
                            .addComponent(jTextFieldCustRegEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelCustRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelCustRegFax)
                            .addComponent(jTextFieldCustRegFax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addComponent(jPanelCustomerType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(92, Short.MAX_VALUE))
                    .addGroup(jPanelCustRegLayout.createSequentialGroup()
                        .addComponent(jButtonCustRegSave, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonCustRegReset, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jTabbedPaneCRMBase.addTab("CUSTOMER REGISTER", jPanelCustReg);

        javax.swing.GroupLayout jPanelCRMLayout = new javax.swing.GroupLayout(jPanelCRM);
        jPanelCRM.setLayout(jPanelCRMLayout);
        jPanelCRMLayout.setHorizontalGroup(
            jPanelCRMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCRMLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPaneCRMBase)
                .addContainerGap())
        );
        jPanelCRMLayout.setVerticalGroup(
            jPanelCRMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCRMLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPaneCRMBase)
                .addContainerGap())
        );

        jTabbedPaneBase.addTab("CRM", jPanelCRM);

        jPanelSMGMT.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTabbedPaneSMGMTBase.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanelInvoicing.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanelInvoicingLayout = new javax.swing.GroupLayout(jPanelInvoicing);
        jPanelInvoicing.setLayout(jPanelInvoicingLayout);
        jPanelInvoicingLayout.setHorizontalGroup(
            jPanelInvoicingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1205, Short.MAX_VALUE)
        );
        jPanelInvoicingLayout.setVerticalGroup(
            jPanelInvoicingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 577, Short.MAX_VALUE)
        );

        jTabbedPaneSMGMTBase.addTab("INVOICING", jPanelInvoicing);

        jPanelPos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Date : ");

        javax.swing.GroupLayout jPanelPosLayout = new javax.swing.GroupLayout(jPanelPos);
        jPanelPos.setLayout(jPanelPosLayout);
        jPanelPosLayout.setHorizontalGroup(
            jPanelPosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(1162, Short.MAX_VALUE))
        );
        jPanelPosLayout.setVerticalGroup(
            jPanelPosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(552, Short.MAX_VALUE))
        );

        jTabbedPaneSMGMTBase.addTab("POS", jPanelPos);

        jPanelDo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanelDoLayout = new javax.swing.GroupLayout(jPanelDo);
        jPanelDo.setLayout(jPanelDoLayout);
        jPanelDoLayout.setHorizontalGroup(
            jPanelDoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1205, Short.MAX_VALUE)
        );
        jPanelDoLayout.setVerticalGroup(
            jPanelDoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 577, Short.MAX_VALUE)
        );

        jTabbedPaneSMGMTBase.addTab("DO", jPanelDo);

        javax.swing.GroupLayout jPanelSMGMTLayout = new javax.swing.GroupLayout(jPanelSMGMT);
        jPanelSMGMT.setLayout(jPanelSMGMTLayout);
        jPanelSMGMTLayout.setHorizontalGroup(
            jPanelSMGMTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSMGMTLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPaneSMGMTBase)
                .addContainerGap())
        );
        jPanelSMGMTLayout.setVerticalGroup(
            jPanelSMGMTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSMGMTLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPaneSMGMTBase)
                .addContainerGap())
        );

        jTabbedPaneBase.addTab("SMGMT", jPanelSMGMT);

        jPanelHRM.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTabbedPaneHRBase.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanelEmpReg.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Employee Registration Form", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jPanelPersonal.setBorder(javax.swing.BorderFactory.createTitledBorder("Personal Information"));

        jLabelEmpRegName.setText("Name :");

        jLabelEmpRegNRCNo.setText("NRC No :");

        jLabelEmpRegAddress.setText("Address :");

        jLabelEmpRegTownship.setText("Township :");

        jLabelEmpRegCity.setText("City :");

        jLabelEmpRegState.setText("State :");

        jLabelEmpRegCountry.setText("Country :");

        jLabelEmpRegMPhone.setText("Mobile Phone :");

        jTextFieldEmpRegNRCNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldEmpRegNRCNoActionPerformed(evt);
            }
        });

        jTextAreaEmpRegAddress.setColumns(20);
        jTextAreaEmpRegAddress.setRows(5);
        jScrollPane1.setViewportView(jTextAreaEmpRegAddress);

        jLabelEmpRegEmail.setText("e-mail :");

        jComboBoxEmpRegCity.setToolTipText("");

        jComboBoxEmpRegState.setToolTipText("");

        javax.swing.GroupLayout jPanelPersonalLayout = new javax.swing.GroupLayout(jPanelPersonal);
        jPanelPersonal.setLayout(jPanelPersonalLayout);
        jPanelPersonalLayout.setHorizontalGroup(
            jPanelPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPersonalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelEmpRegTownship)
                    .addComponent(jLabelEmpRegCity)
                    .addComponent(jLabelEmpRegState)
                    .addComponent(jLabelEmpRegCountry)
                    .addComponent(jLabelEmpRegMPhone)
                    .addComponent(jLabelEmpRegEmail)
                    .addComponent(jLabelEmpRegName)
                    .addComponent(jLabelEmpRegNRCNo)
                    .addComponent(jLabelEmpRegAddress))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPersonalLayout.createSequentialGroup()
                        .addGroup(jPanelPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextFieldEmpRegNRCNo, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldEmpRegName, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 20, Short.MAX_VALUE))
                    .addGroup(jPanelPersonalLayout.createSequentialGroup()
                        .addGroup(jPanelPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextFieldEmpRegEmail, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldEmpRegMPhone, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxEmpRegCountry, 0, 166, Short.MAX_VALUE)
                            .addComponent(jComboBoxEmpRegTownship, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxEmpRegCity, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxEmpRegState, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanelPersonalLayout.setVerticalGroup(
            jPanelPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPersonalLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanelPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEmpRegName)
                    .addComponent(jTextFieldEmpRegName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEmpRegNRCNo)
                    .addComponent(jTextFieldEmpRegNRCNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanelPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelEmpRegAddress)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanelPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEmpRegTownship)
                    .addComponent(jComboBoxEmpRegTownship, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEmpRegCity)
                    .addComponent(jComboBoxEmpRegCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEmpRegState)
                    .addComponent(jComboBoxEmpRegState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEmpRegCountry)
                    .addComponent(jComboBoxEmpRegCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEmpRegMPhone)
                    .addComponent(jTextFieldEmpRegMPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEmpRegEmail)
                    .addComponent(jTextFieldEmpRegEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelWork.setBorder(javax.swing.BorderFactory.createTitledBorder("Work Information"));

        jLabelEmpRegDepartment.setText("Department :");

        jLabelEmpRegManager.setText("Manager :");

        jLabelEmpRegPosition.setText("Posistion :");

        jLabelEmpRegWPhone.setText("Work Phone :");

        jComboBoxEmpRegManager.setToolTipText("");

        javax.swing.GroupLayout jPanelWorkLayout = new javax.swing.GroupLayout(jPanelWork);
        jPanelWork.setLayout(jPanelWorkLayout);
        jPanelWorkLayout.setHorizontalGroup(
            jPanelWorkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelWorkLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelWorkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelWorkLayout.createSequentialGroup()
                        .addComponent(jLabelEmpRegDepartment)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxEmpRegDepartment, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelWorkLayout.createSequentialGroup()
                        .addGroup(jPanelWorkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelEmpRegWPhone)
                            .addComponent(jLabelEmpRegPosition)
                            .addComponent(jLabelEmpRegManager))
                        .addGroup(jPanelWorkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelWorkLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanelWorkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldEmpRegWPhone)
                                    .addComponent(jComboBoxEmpRegPosition, 0, 165, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanelWorkLayout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jComboBoxEmpRegManager, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanelWorkLayout.setVerticalGroup(
            jPanelWorkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelWorkLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelWorkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEmpRegDepartment)
                    .addComponent(jComboBoxEmpRegDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelWorkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEmpRegManager)
                    .addComponent(jComboBoxEmpRegManager, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelWorkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEmpRegPosition)
                    .addComponent(jComboBoxEmpRegPosition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelWorkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEmpRegWPhone)
                    .addComponent(jTextFieldEmpRegWPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButtonEmpRegSave.setText("Save");
        jButtonEmpRegSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEmpRegSaveActionPerformed(evt);
            }
        });

        jButtonEmpRegReset.setText("Reset");
        jButtonEmpRegReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEmpRegResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelEmpRegLayout = new javax.swing.GroupLayout(jPanelEmpReg);
        jPanelEmpReg.setLayout(jPanelEmpRegLayout);
        jPanelEmpRegLayout.setHorizontalGroup(
            jPanelEmpRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEmpRegLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanelWork, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelEmpRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonEmpRegReset, javax.swing.GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE)
                    .addComponent(jButtonEmpRegSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelEmpRegLayout.setVerticalGroup(
            jPanelEmpRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEmpRegLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelEmpRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelEmpRegLayout.createSequentialGroup()
                        .addGroup(jPanelEmpRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanelWork, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonEmpRegSave, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addComponent(jButtonEmpRegReset, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 41, Short.MAX_VALUE))
                    .addComponent(jPanelPersonal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPaneHRBase.addTab("EMP REG", jPanelEmpReg);

        javax.swing.GroupLayout jPanelHRMLayout = new javax.swing.GroupLayout(jPanelHRM);
        jPanelHRM.setLayout(jPanelHRMLayout);
        jPanelHRMLayout.setHorizontalGroup(
            jPanelHRMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHRMLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPaneHRBase)
                .addContainerGap())
        );
        jPanelHRMLayout.setVerticalGroup(
            jPanelHRMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHRMLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPaneHRBase)
                .addContainerGap())
        );

        jTabbedPaneBase.addTab("HRM", jPanelHRM);

        jPanelWhManagement.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTabbedPaneWHMGMTBase.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanelWHREG.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Warehouse Information Entry Form", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabelWhRegName.setText("Name :");

        jLabelWhRegAddress.setText("Address :");

        jLabelWhRegTownship.setText("Township :");

        jLabelWhRegCity.setText("City :");

        jLabelState.setText("State :");

        jLabelWhRegPhone.setText("Phone :");

        jLabelWhRegSupervisor.setText("Supervisor :");

        jComboBoxWhRegSupervisor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxWhRegSupervisorActionPerformed(evt);
            }
        });

        jComboBoxWhRegState.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxWhRegStateActionPerformed(evt);
            }
        });

        jComboBoxWhRegCity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxWhRegCityActionPerformed(evt);
            }
        });

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextAreaWhRegAddress.setColumns(20);
        jTextAreaWhRegAddress.setRows(5);
        jTextAreaWhRegAddress.setAutoscrolls(false);
        jScrollPane3.setViewportView(jTextAreaWhRegAddress);

        jButtonWhRegSave.setText("Save");
        jButtonWhRegSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonWhRegSaveActionPerformed(evt);
            }
        });

        jButtonWhRegResetl.setText("Reset");
        jButtonWhRegResetl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonWhRegResetlActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelWHREGLayout = new javax.swing.GroupLayout(jPanelWHREG);
        jPanelWHREG.setLayout(jPanelWHREGLayout);
        jPanelWHREGLayout.setHorizontalGroup(
            jPanelWHREGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelWHREGLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelWHREGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelWhRegAddress)
                    .addComponent(jLabelWhRegTownship)
                    .addComponent(jLabelWhRegCity)
                    .addComponent(jLabelWhRegName)
                    .addComponent(jLabelState)
                    .addComponent(jLabelWhRegPhone)
                    .addComponent(jLabelWhRegSupervisor))
                .addGap(30, 30, 30)
                .addGroup(jPanelWHREGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelWHREGLayout.createSequentialGroup()
                        .addGroup(jPanelWHREGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelWHREGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                                .addComponent(jTextFieldWhRegName))
                            .addComponent(jComboBoxWhRegState, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jButtonWhRegSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelWHREGLayout.createSequentialGroup()
                        .addGroup(jPanelWHREGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxWhRegSupervisor, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldWhRegPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxWhRegTownship, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxWhRegCity, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jButtonWhRegResetl, javax.swing.GroupLayout.DEFAULT_SIZE, 883, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelWHREGLayout.setVerticalGroup(
            jPanelWHREGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelWHREGLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanelWHREGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelWhRegName)
                    .addComponent(jTextFieldWhRegName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelWHREGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelWhRegAddress)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelWHREGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelWhRegTownship)
                    .addComponent(jComboBoxWhRegTownship, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelWHREGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelWhRegCity)
                    .addComponent(jComboBoxWhRegCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelWHREGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxWhRegState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelState))
                .addGap(18, 18, 18)
                .addGroup(jPanelWHREGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldWhRegPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelWhRegPhone))
                .addGap(18, 18, 18)
                .addGroup(jPanelWHREGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxWhRegSupervisor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelWhRegSupervisor))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelWHREGLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jButtonWhRegSave, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jButtonWhRegResetl, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPaneWHMGMTBase.addTab("WH REG", jPanelWHREG);

        jPanelItemReg.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Item Information Entry Form", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabelItemRegName.setText("Name :");

        jLabelItemRegCode.setText("Code :");

        jLabelItemRegWeight.setText("Unit Weight : ");

        jLabelItemRegCategory.setText("Category : ");

        jLabelItemRegSupplier.setText("Supplier : ");

        jLabelItemRegPrize.setText("Unit Prize : ");

        jTextFieldItemRegPrize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldItemRegPrizeActionPerformed(evt);
            }
        });

        jLabel17.setText("Kyats");

        jTextFieldItemRegWeight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldItemRegWeightActionPerformed(evt);
            }
        });

        jLabelGrams.setText("Grams");

        jTextFieldItemRegCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldItemRegCodeActionPerformed(evt);
            }
        });

        jTextFieldItemRegName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldItemRegNameActionPerformed(evt);
            }
        });

        jButtonItemRegSave.setText("Save");
        jButtonItemRegSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonItemRegSaveActionPerformed(evt);
            }
        });

        jButtonItemRegReset.setText("Reset");
        jButtonItemRegReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonItemRegResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelItemRegLayout = new javax.swing.GroupLayout(jPanelItemReg);
        jPanelItemReg.setLayout(jPanelItemRegLayout);
        jPanelItemRegLayout.setHorizontalGroup(
            jPanelItemRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelItemRegLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelItemRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelItemRegPrize)
                    .addComponent(jLabelItemRegWeight)
                    .addComponent(jLabelItemRegCategory)
                    .addComponent(jLabelItemRegSupplier)
                    .addComponent(jLabelItemRegName)
                    .addComponent(jLabelItemRegCode))
                .addGap(18, 18, 18)
                .addGroup(jPanelItemRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxItemRegSupplier, 0, 164, Short.MAX_VALUE)
                    .addComponent(jComboBoxItemRegCategory, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldItemRegCode, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                    .addComponent(jTextFieldItemRegName)
                    .addGroup(jPanelItemRegLayout.createSequentialGroup()
                        .addGroup(jPanelItemRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelItemRegLayout.createSequentialGroup()
                                .addComponent(jTextFieldItemRegPrize, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel17))
                            .addGroup(jPanelItemRegLayout.createSequentialGroup()
                                .addComponent(jTextFieldItemRegWeight, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelGrams)))
                        .addGap(0, 36, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPanelItemRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonItemRegReset, javax.swing.GroupLayout.DEFAULT_SIZE, 888, Short.MAX_VALUE)
                    .addComponent(jButtonItemRegSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelItemRegLayout.setVerticalGroup(
            jPanelItemRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelItemRegLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelItemRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelItemRegName)
                    .addComponent(jTextFieldItemRegName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelItemRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelItemRegCode)
                    .addComponent(jTextFieldItemRegCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelItemRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelItemRegWeight)
                    .addComponent(jTextFieldItemRegWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelGrams))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelItemRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelItemRegCategory)
                    .addComponent(jComboBoxItemRegCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelItemRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelItemRegSupplier)
                    .addComponent(jComboBoxItemRegSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelItemRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelItemRegPrize)
                    .addComponent(jTextFieldItemRegPrize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelItemRegLayout.createSequentialGroup()
                .addComponent(jButtonItemRegSave, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(jButtonItemRegReset, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPaneWHMGMTBase.addTab("ITEM REG", jPanelItemReg);

        javax.swing.GroupLayout jPanelWhManagementLayout = new javax.swing.GroupLayout(jPanelWhManagement);
        jPanelWhManagement.setLayout(jPanelWhManagementLayout);
        jPanelWhManagementLayout.setHorizontalGroup(
            jPanelWhManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelWhManagementLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPaneWHMGMTBase)
                .addContainerGap())
        );
        jPanelWhManagementLayout.setVerticalGroup(
            jPanelWhManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelWhManagementLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPaneWHMGMTBase)
                .addContainerGap())
        );

        jTabbedPaneBase.addTab("WHMGMT", jPanelWhManagement);

        jPanelFleetMGMT.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton2.setText("jButton2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelFleetMGMTLayout = new javax.swing.GroupLayout(jPanelFleetMGMT);
        jPanelFleetMGMT.setLayout(jPanelFleetMGMTLayout);
        jPanelFleetMGMTLayout.setHorizontalGroup(
            jPanelFleetMGMTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFleetMGMTLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(995, Short.MAX_VALUE))
        );
        jPanelFleetMGMTLayout.setVerticalGroup(
            jPanelFleetMGMTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFleetMGMTLayout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(371, Short.MAX_VALUE))
        );

        jTabbedPaneBase.addTab("FLEET MGMT", jPanelFleetMGMT);

        jPanelReport.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTabbedPaneReportBase.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanelReportLayout = new javax.swing.GroupLayout(jPanelReport);
        jPanelReport.setLayout(jPanelReportLayout);
        jPanelReportLayout.setHorizontalGroup(
            jPanelReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelReportLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPaneReportBase, javax.swing.GroupLayout.DEFAULT_SIZE, 1218, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelReportLayout.setVerticalGroup(
            jPanelReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelReportLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPaneReportBase, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPaneBase.addTab("REPORT", jPanelReport);

        jPanelHelp.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTabbedPaneHelpBase.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanelContents.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelContentsLayout = new javax.swing.GroupLayout(jPanelContents);
        jPanelContents.setLayout(jPanelContentsLayout);
        jPanelContentsLayout.setHorizontalGroup(
            jPanelContentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContentsLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(923, Short.MAX_VALUE))
        );
        jPanelContentsLayout.setVerticalGroup(
            jPanelContentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContentsLayout.createSequentialGroup()
                .addGap(157, 157, 157)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(301, Short.MAX_VALUE))
        );

        jTabbedPaneHelpBase.addTab("CONTENTS", jPanelContents);

        jPanelAbout.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("<html>\n<head><title></title></head>\n<body><h1>something</h1></body>\n</html>"); // NOI18N

        javax.swing.GroupLayout jPanelAboutLayout = new javax.swing.GroupLayout(jPanelAbout);
        jPanelAbout.setLayout(jPanelAboutLayout);
        jPanelAboutLayout.setHorizontalGroup(
            jPanelAboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAboutLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1185, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelAboutLayout.setVerticalGroup(
            jPanelAboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAboutLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPaneHelpBase.addTab("ABOUT", jPanelAbout);

        javax.swing.GroupLayout jPanelHelpLayout = new javax.swing.GroupLayout(jPanelHelp);
        jPanelHelp.setLayout(jPanelHelpLayout);
        jPanelHelpLayout.setHorizontalGroup(
            jPanelHelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHelpLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPaneHelpBase)
                .addContainerGap())
        );
        jPanelHelpLayout.setVerticalGroup(
            jPanelHelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHelpLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPaneHelpBase)
                .addContainerGap())
        );

        jTabbedPaneBase.addTab("Help", jPanelHelp);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPaneBase)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPaneBase)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldEmpRegNRCNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEmpRegNRCNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEmpRegNRCNoActionPerformed

    private void jButtonEmpRegResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEmpRegResetActionPerformed
        // TODO add your handling code here:
        resetEmpRegPannel();
    }//GEN-LAST:event_jButtonEmpRegResetActionPerformed

    private void jButtonCustRegResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCustRegResetActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "Distory Operation Successful");
        resetCustRegPannel();
        if (jRadioButtonCustRegRetail.isSelected()) {
            JOptionPane.showMessageDialog(rootPane, jRadioButtonCustRegRetail.getText());
        }
    }//GEN-LAST:event_jButtonCustRegResetActionPerformed

    private void jTextFieldItemRegNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldItemRegNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldItemRegNameActionPerformed

    private void jTextFieldItemRegCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldItemRegCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldItemRegCodeActionPerformed

    private void jTextFieldItemRegWeightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldItemRegWeightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldItemRegWeightActionPerformed

    private void jTextFieldItemRegPrizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldItemRegPrizeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldItemRegPrizeActionPerformed

    private void jComboBoxWhRegSupervisorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxWhRegSupervisorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxWhRegSupervisorActionPerformed

    private void jComboBoxWhRegStateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxWhRegStateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxWhRegStateActionPerformed

    private void jComboBoxWhRegCityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxWhRegCityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxWhRegCityActionPerformed

    private void jButtonWhRegSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonWhRegSaveActionPerformed
        // TODO add your handling code here:
        //Save Function
        JOptionPane.showMessageDialog(this, "Save Record Sucessful");
        resetWarehouseRegPannel();
    }//GEN-LAST:event_jButtonWhRegSaveActionPerformed

    private void jButtonWhRegResetlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonWhRegResetlActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "Record Distory Successful");
        resetWarehouseRegPannel();
    }//GEN-LAST:event_jButtonWhRegResetlActionPerformed

    private void jButtonItemRegSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonItemRegSaveActionPerformed
        // TODO add your handling code here:
        //Save method
        JOptionPane.showMessageDialog(this, "Save Record Successful");
        resetItemRegPannel();
    }//GEN-LAST:event_jButtonItemRegSaveActionPerformed

    private void jButtonItemRegResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonItemRegResetActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "Distory Operation Successful");
        resetItemRegPannel();
    }//GEN-LAST:event_jButtonItemRegResetActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(jPanelContents, "Hello");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(jPanelContents, "Hello World");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButtonEmpRegSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEmpRegSaveActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "Save Record Successful !");
        resetEmpRegPannel();
    }//GEN-LAST:event_jButtonEmpRegSaveActionPerformed

    private void jButtonCustRegSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCustRegSaveActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "Save Record Successful !");
        resetCustRegPannel();
    }//GEN-LAST:event_jButtonCustRegSaveActionPerformed

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
            java.util.logging.Logger.getLogger(Base.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Base.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Base.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Base.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Base().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupCustRegCustomerType;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonCustRegReset;
    private javax.swing.JButton jButtonCustRegSave;
    private javax.swing.JButton jButtonEmpRegReset;
    private javax.swing.JButton jButtonEmpRegSave;
    private javax.swing.JButton jButtonItemRegReset;
    private javax.swing.JButton jButtonItemRegSave;
    private javax.swing.JButton jButtonWhRegResetl;
    private javax.swing.JButton jButtonWhRegSave;
    private javax.swing.JComboBox jComboBoxCustRegCity;
    private javax.swing.JComboBox jComboBoxCustRegCountry;
    private javax.swing.JComboBox jComboBoxCustRegState;
    private javax.swing.JComboBox jComboBoxCustRegTownship;
    private javax.swing.JComboBox jComboBoxEmpRegCity;
    private javax.swing.JComboBox jComboBoxEmpRegCountry;
    private javax.swing.JComboBox jComboBoxEmpRegDepartment;
    private javax.swing.JComboBox jComboBoxEmpRegManager;
    private javax.swing.JComboBox jComboBoxEmpRegPosition;
    private javax.swing.JComboBox jComboBoxEmpRegState;
    private javax.swing.JComboBox jComboBoxEmpRegTownship;
    private javax.swing.JComboBox jComboBoxItemRegCategory;
    private javax.swing.JComboBox jComboBoxItemRegSupplier;
    private javax.swing.JComboBox jComboBoxWhRegCity;
    private javax.swing.JComboBox jComboBoxWhRegState;
    private javax.swing.JComboBox jComboBoxWhRegSupervisor;
    private javax.swing.JComboBox jComboBoxWhRegTownship;
    private javax.swing.JLabel jLabeCustReglTownship;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelCustRegAddress;
    private javax.swing.JLabel jLabelCustRegCity;
    private javax.swing.JLabel jLabelCustRegCountry;
    private javax.swing.JLabel jLabelCustRegCustomerName;
    private javax.swing.JLabel jLabelCustRegFax;
    private javax.swing.JLabel jLabelCustRegMail;
    private javax.swing.JLabel jLabelCustRegOutletName;
    private javax.swing.JLabel jLabelCustRegPhone;
    private javax.swing.JLabel jLabelCustRegState;
    private javax.swing.JLabel jLabelEmpRegAddress;
    private javax.swing.JLabel jLabelEmpRegCity;
    private javax.swing.JLabel jLabelEmpRegCountry;
    private javax.swing.JLabel jLabelEmpRegDepartment;
    private javax.swing.JLabel jLabelEmpRegEmail;
    private javax.swing.JLabel jLabelEmpRegMPhone;
    private javax.swing.JLabel jLabelEmpRegManager;
    private javax.swing.JLabel jLabelEmpRegNRCNo;
    private javax.swing.JLabel jLabelEmpRegName;
    private javax.swing.JLabel jLabelEmpRegPosition;
    private javax.swing.JLabel jLabelEmpRegState;
    private javax.swing.JLabel jLabelEmpRegTownship;
    private javax.swing.JLabel jLabelEmpRegWPhone;
    private javax.swing.JLabel jLabelGrams;
    private javax.swing.JLabel jLabelItemRegCategory;
    private javax.swing.JLabel jLabelItemRegCode;
    private javax.swing.JLabel jLabelItemRegName;
    private javax.swing.JLabel jLabelItemRegPrize;
    private javax.swing.JLabel jLabelItemRegSupplier;
    private javax.swing.JLabel jLabelItemRegWeight;
    private javax.swing.JLabel jLabelState;
    private javax.swing.JLabel jLabelWhRegAddress;
    private javax.swing.JLabel jLabelWhRegCity;
    private javax.swing.JLabel jLabelWhRegName;
    private javax.swing.JLabel jLabelWhRegPhone;
    private javax.swing.JLabel jLabelWhRegSupervisor;
    private javax.swing.JLabel jLabelWhRegTownship;
    private javax.swing.JPanel jPanelAbout;
    private javax.swing.JPanel jPanelAccount;
    private javax.swing.JPanel jPanelCRM;
    private javax.swing.JPanel jPanelCompanyReg;
    private javax.swing.JPanel jPanelContents;
    private javax.swing.JPanel jPanelCustReg;
    private javax.swing.JPanel jPanelCustomerType;
    private javax.swing.JPanel jPanelDo;
    private javax.swing.JPanel jPanelEmpReg;
    private javax.swing.JPanel jPanelFleetMGMT;
    private javax.swing.JPanel jPanelHRM;
    private javax.swing.JPanel jPanelHelp;
    private javax.swing.JPanel jPanelInvoicing;
    private javax.swing.JPanel jPanelItemReg;
    private javax.swing.JPanel jPanelPersonal;
    private javax.swing.JPanel jPanelPos;
    private javax.swing.JPanel jPanelReport;
    private javax.swing.JPanel jPanelSMGMT;
    private javax.swing.JPanel jPanelSRM;
    private javax.swing.JPanel jPanelSetup;
    private javax.swing.JPanel jPanelSupplierREG;
    private javax.swing.JPanel jPanelWHREG;
    private javax.swing.JPanel jPanelWhManagement;
    private javax.swing.JPanel jPanelWork;
    private javax.swing.JRadioButton jRadioButtonCustRegDealer;
    private javax.swing.JRadioButton jRadioButtonCustRegMT;
    private javax.swing.JRadioButton jRadioButtonCustRegPTR;
    private javax.swing.JRadioButton jRadioButtonCustRegPTROutlet;
    private javax.swing.JRadioButton jRadioButtonCustRegRetail;
    private javax.swing.JRadioButton jRadioButtonCustRegWholeslae;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPaneBase;
    private javax.swing.JTabbedPane jTabbedPaneCRMBase;
    private javax.swing.JTabbedPane jTabbedPaneHRBase;
    private javax.swing.JTabbedPane jTabbedPaneHelpBase;
    private javax.swing.JTabbedPane jTabbedPaneReportBase;
    private javax.swing.JTabbedPane jTabbedPaneSMGMTBase;
    private javax.swing.JTabbedPane jTabbedPaneSRMBase;
    private javax.swing.JTabbedPane jTabbedPaneSetupBase;
    private javax.swing.JTabbedPane jTabbedPaneWHMGMTBase;
    private javax.swing.JTextArea jTextAreaCustRegAddress;
    private javax.swing.JTextArea jTextAreaEmpRegAddress;
    private javax.swing.JTextArea jTextAreaWhRegAddress;
    private javax.swing.JTextField jTextFieldCustRegCustomerName;
    private javax.swing.JTextField jTextFieldCustRegEmail;
    private javax.swing.JTextField jTextFieldCustRegFax;
    private javax.swing.JTextField jTextFieldCustRegOutletName;
    private javax.swing.JTextField jTextFieldCustRegPhone;
    private javax.swing.JTextField jTextFieldEmpRegEmail;
    private javax.swing.JTextField jTextFieldEmpRegMPhone;
    private javax.swing.JTextField jTextFieldEmpRegNRCNo;
    private javax.swing.JTextField jTextFieldEmpRegName;
    private javax.swing.JTextField jTextFieldEmpRegWPhone;
    private javax.swing.JTextField jTextFieldItemRegCode;
    private javax.swing.JTextField jTextFieldItemRegName;
    private javax.swing.JTextField jTextFieldItemRegPrize;
    private javax.swing.JTextField jTextFieldItemRegWeight;
    private javax.swing.JTextField jTextFieldWhRegName;
    private javax.swing.JTextField jTextFieldWhRegPhone;
    // End of variables declaration//GEN-END:variables
}
