/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zgpdistribution.ui;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import zgpdistribution.util.CategoryDAO;
import zgpdistribution.util.CityDAO;
import zgpdistribution.util.CountryDAO;
import zgpdistribution.util.ChannelListDAO;
import zgpdistribution.util.CustomerDAO;
import zgpdistribution.util.DepartmentDAO;
import zgpdistribution.util.EmployeeDAO;
import zgpdistribution.util.ItemListDAO;
import zgpdistribution.util.PositionDAO;
import zgpdistribution.util.StateDAO;
import zgpdistribution.util.SupplierDAO;
import zgpdistribution.util.TeamListDAO;
import zgpdistribution.util.TownshipDAO;
import zgpdistribution.util.UoMListDAO;
import zgpdistribution.util.WarehouseDAO;
import zgpdistribution.util.oops.Category;
import zgpdistribution.util.oops.City;
import zgpdistribution.util.oops.Country;
import zgpdistribution.util.oops.ChannelList;
import zgpdistribution.util.oops.Customer;
import zgpdistribution.util.oops.Department;
import zgpdistribution.util.oops.Employee;
import zgpdistribution.util.oops.ItemList;
import zgpdistribution.util.oops.Position;
import zgpdistribution.util.oops.State;
import zgpdistribution.util.oops.Supplier;
import zgpdistribution.util.oops.TeamList;
import zgpdistribution.util.oops.Township;
import zgpdistribution.util.oops.UoMList;
import zgpdistribution.util.oops.Warehouse;

/**
 *
 * @author John
 */
public class Base extends javax.swing.JFrame {

    private Double smgmtInvTPrizeShow;
    private Map<String, City> mCity = null;
    private Map<String, ItemList> mItems = null;

    /**
     * Creates new form Base
     */
    public Base() {
        initComponents();
        initFormData();
        fillCombo();
    }

    private void fillCombo() {
        mCity = new HashMap<>();
        mItems = new HashMap<>();
        for (City city : new CityDAO().queryAll()) {
            mCity.put(city.getCode(), city);
            jComboBoxSmgmtInvIncLo.addItem(city.getCode());
        }
        for (ItemList items : new ItemListDAO().queryAll()) {
            mItems.put(items.getCode(), items);
            jComboBoxSmgmtInvIncSCode.addItem(items.getCode());
        }
    }

    private void initFormData() {
        jComboBoxEmpRegTownship.addItem("-- Select One --");
        jComboBoxEmpRegTownship.setEnabled(false);
        jComboBoxEmpRegCity.addItem("-- Select One --");
        jComboBoxEmpRegState.addItem("-- Select One --");
        jComboBoxEmpRegCountry.addItem("-- Select One --");
        jComboBoxEmpRegDepartment.addItem("-- Select One --");
        jComboBoxEmpRegManager.addItem("-- Select One --");
        jComboBoxEmpRegPosition.addItem("-- Select One --");
        jComboBoxEmpRegWTeam.addItem("-- Select One --");

        jComboBoxCustRegTownship.addItem("-- Select One --");
        jComboBoxCustRegTownship.setEnabled(false);
        jComboBoxCustRegCity.addItem("-- Select One --");
        jComboBoxCustRegState.addItem("-- Select One --");
        jComboBoxCustRegCountry.addItem("-- Select One --");
        jComboBoxCustRegChannel.addItem("-- Select One --");

        jComboBoxWhRegTownship.addItem("-- Select One --");
        jComboBoxWhRegTownship.setEnabled(false);
        jComboBoxWhRegCity.addItem("-- Select One --");
        jComboBoxWhRegState.addItem("-- Select One --");
        jComboBoxWhRegSupervisor.addItem("-- Select One --");

        jComboBoxSmgmtInvIncLo.addItem("-- Select One --");
        jComboBoxSmgmtInvIncSCode.addItem("-- Select One --");
        jComboBoxSmgmtInvCustType.addItem("-- Select One --");
        jComboBoxSmgmtInvSaleby.addItem("-- Select One --");
        jLabelSmgmtInvIncLoLong.setText("Unknow Location Selected");
        jLabelSmgmtInvIncSCodeLong.setText("Unknown Stock Selected");
        jLabelSmgmtInvIncQtyPkg.setText("0 Package");
        jLabelSmgmtInvPrizeShow.setText("0.00 Kyats");
        jLabelSmgmtInvTPrizeShow.setText("0.00 Kyats");

        jComboBoxItemRegUM.addItem("-- Select One --");
        jComboBoxItemRegUW.addItem("-- Select One --");
        jComboBoxItemRegUP.addItem("-- Select One --");
        jComboBoxItemRegSUM.addItem("-- Select One --");
        jComboBoxItemRegSUW.addItem("-- Select One --");
        jComboBoxItemRegSUInclude.addItem("-- Select One --");
        jComboBoxItemRegSUP.addItem("-- Select One --");
        jComboBoxItemRegCategory.addItem("-- Select One --");
        jComboBoxItemRegSupplier.addItem("-- Select One --");

        try {
            ArrayList<ItemList> ItemList = new ItemListDAO().queryAll();
            for (ItemList items : ItemList) {
                jComboBoxSmgmtInvIncSCode.addItem(items.getCode());
            }

            ArrayList<UoMList> uomList = new UoMListDAO().queryAll();
            for (UoMList uoMList : uomList) {
                jComboBoxItemRegUM.addItem(uoMList.getUomLong());
                jComboBoxItemRegUW.addItem(uoMList.getUomShort());
                jComboBoxItemRegUP.addItem(uoMList.getUomShort());
                jComboBoxItemRegSUM.addItem(uoMList.getUomShort());
                jComboBoxItemRegSUW.addItem(uoMList.getUomShort());
                jComboBoxItemRegSUInclude.addItem(uoMList.getUomShort());
                jComboBoxItemRegSUP.addItem(uoMList.getUomShort());
            }

            ArrayList<TeamList> teamList = new TeamListDAO().queryAll();
            for (TeamList team : teamList) {
                jComboBoxEmpRegWTeam.addItem(team.getName());
                jComboBoxSmgmtInvSaleby.addItem(team.getName());
            }
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
                jComboBoxSmgmtInvIncLo.addItem(city.getCode());
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
            ArrayList<ChannelList> custTList = new ChannelListDAO().queryAll();
            for (ChannelList custType : custTList) {
                jComboBoxCustRegChannel.addItem(custType.getName());
                jComboBoxSmgmtInvCustType.addItem(custType.getName());
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
        jComboBoxEmpRegWTeam.setSelectedIndex(0);
    }

    private boolean saveEmpReg() {
        Employee emp = new Employee();
        emp.setName(jTextFieldEmpRegName.getText().toUpperCase().trim());
        emp.setNrc(jTextFieldEmpRegNRCNo.getText().trim());
        emp.setAddress(jTextAreaEmpRegAddress.getText().trim());
        emp.setTsp(jComboBoxEmpRegTownship.getSelectedItem().toString());
        emp.setState(jComboBoxEmpRegState.getSelectedItem().toString());
        emp.setCity(jComboBoxEmpRegCity.getSelectedItem().toString());
        emp.setCountry(jComboBoxEmpRegCountry.getSelectedItem().toString().toUpperCase());
        emp.setMphone(jTextFieldEmpRegMPhone.getText().trim());
        emp.setEmail(jTextFieldEmpRegEmail.getText().toLowerCase().trim());
        emp.setDept(jComboBoxEmpRegDepartment.getSelectedItem().toString());
        emp.setDeptMgr(jComboBoxEmpRegManager.getSelectedItem().toString());
        emp.setWphone(jTextFieldEmpRegWPhone.getText().trim());
        emp.setJobPosition(jComboBoxEmpRegPosition.getSelectedItem().toString());
        emp.setTeam(jComboBoxEmpRegWTeam.getSelectedItem().toString());
        return new EmployeeDAO().save(emp);
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
        jComboBoxCustRegChannel.setSelectedIndex(0);
    }

    private boolean saveCustReg() {
        Customer cust = new Customer();
        cust.setOutletName(jTextFieldCustRegOutletName.getText().trim());
        cust.setCustomerName(jTextFieldCustRegCustomerName.getText().toUpperCase().trim());
        cust.setAddress(jTextAreaCustRegAddress.getText().trim());
        cust.setTownship(jComboBoxCustRegTownship.getSelectedItem().toString());
        cust.setCity(jComboBoxCustRegState.getSelectedItem().toString());
        cust.setState(jComboBoxCustRegState.getSelectedItem().toString());
        cust.setCountry(jComboBoxCustRegCountry.getSelectedItem().toString());
        cust.setPhone(jTextFieldCustRegPhone.getText().trim());
        cust.setEmail(jTextFieldCustRegEmail.getText().trim());
        cust.setFax(jTextFieldCustRegFax.getText().trim());
        cust.setCustomerType(jComboBoxCustRegChannel.getSelectedItem().toString());
        return new CustomerDAO().save(cust);
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

    private boolean saveWhReg() {
        Warehouse wh = new Warehouse();
        wh.setName(jTextFieldWhRegName.getText().trim());
        wh.setAddress(jTextAreaWhRegAddress.getText().trim());
        wh.setTownship(jComboBoxWhRegTownship.getSelectedItem().toString());
        wh.setCity(jComboBoxWhRegCity.getSelectedItem().toString());
        wh.setState(jComboBoxWhRegState.getSelectedItem().toString());
        wh.setPhone(jTextFieldWhRegPhone.getText().trim());
        wh.setWhsvr(jComboBoxWhRegSupervisor.getSelectedItem().toString());
        return new WarehouseDAO().save(wh);
    }

    private void resetItemRegPannel() {
        jTextFieldItemRegName.setText("");
        jTextFieldItemRegCode.setText("");
        jComboBoxItemRegUM.setSelectedIndex(0);
        jTextFieldItemRegUW.setText("");
        jComboBoxItemRegUW.setSelectedIndex(0);
        jTextFieldItemRegUW.setText("");
        jComboBoxItemRegUW.setSelectedIndex(0);
        jTextFieldItemRegUP.setText("");
        jComboBoxItemRegUP.setSelectedIndex(0);
        jComboBoxItemRegSUM.setSelectedIndex(0);
        jTextFieldItemRegSUW.setText("");
        jComboBoxItemRegSUW.setSelectedIndex(0);
        jTextFieldItemRegSUInclude.setText("");
        jComboBoxItemRegSUInclude.setSelectedIndex(0);
        jTextFieldItemRegSUP.setText("");
        jComboBoxItemRegSUP.setSelectedIndex(0);
        jComboBoxItemRegCategory.setSelectedIndex(0);
        jComboBoxItemRegSupplier.setSelectedIndex(0);
    }

    private boolean saveItemReg() {
        ItemList item = new ItemList();
        item.setName(jTextFieldItemRegName.getText().trim());
        item.setCode(jTextFieldItemRegCode.getText().trim());
        item.setNetUom(jComboBoxItemRegUM.getSelectedItem().toString());
        item.setCategory(jComboBoxItemRegCategory.getSelectedItem().toString());
        item.setSupplier(jComboBoxItemRegSupplier.getSelectedItem().toString());
        //item.setStdPrices(Double.parseDouble(jTextFieldItemRegPrize.getText().trim()));
        return new ItemListDAO().save(item);
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
        buttonGroupEmpRegTeam = new javax.swing.ButtonGroup();
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
        jLabelCustRegChannel = new javax.swing.JLabel();
        jComboBoxCustRegChannel = new javax.swing.JComboBox();
        jLabelCustType = new javax.swing.JLabel();
        jComboBoxCustType = new javax.swing.JComboBox();
        jPanelSMGMT = new javax.swing.JPanel();
        jTabbedPaneSMGMTBase = new javax.swing.JTabbedPane();
        jPanelInvoicing = new javax.swing.JPanel();
        jLabelSmgmtInvIncLo = new javax.swing.JLabel();
        jLabelSmgmtInvCustType = new javax.swing.JLabel();
        jLabelSmgmtInvSaleby = new javax.swing.JLabel();
        jLabelSmgmtInvIncSCode = new javax.swing.JLabel();
        jLabelSmgmtInvSQty = new javax.swing.JLabel();
        jLabelSmgmtInvPrize = new javax.swing.JLabel();
        jLabelSmgmtInvTPrize = new javax.swing.JLabel();
        jComboBoxSmgmtInvIncLo = new javax.swing.JComboBox();
        jComboBoxSmgmtInvCustType = new javax.swing.JComboBox();
        jComboBoxSmgmtInvSaleby = new javax.swing.JComboBox();
        jComboBoxSmgmtInvIncSCode = new javax.swing.JComboBox();
        jTextFieldSmgmtInvIncQty = new javax.swing.JTextField();
        jLabelSmgmtInvPrizeShow = new javax.swing.JLabel();
        jLabelSmgmtInvTPrizeShow = new javax.swing.JLabel();
        jLabelSmgmtInvIncLoLong = new javax.swing.JLabel();
        jLabelSmgmtInvIncSCodeLong = new javax.swing.JLabel();
        jLabelSmgmtInvIncQtyPkg = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableSmgmtInvTable = new javax.swing.JTable();
        jButtonSmgmtInvAdd = new javax.swing.JButton();
        jButtonSmgmtInvReset = new javax.swing.JButton();
        jButtonSmgmtInvSV = new javax.swing.JButton();
        jPanelPos = new javax.swing.JPanel();
        jButtonSmgmtPosAdd = new javax.swing.JButton();
        jButtonSmgmtPosReset = new javax.swing.JButton();
        jButtonSmgmtPosSave = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableSmgmtPosTable = new javax.swing.JTable();
        jLabelSmgmtInvIncSCodeLong1 = new javax.swing.JLabel();
        jLabelSmgmtInvIncQtyPkg1 = new javax.swing.JLabel();
        jTextFieldSmgmtPosIncQty = new javax.swing.JTextField();
        jComboBoxSmgmtPosIncSCode = new javax.swing.JComboBox();
        jComboBoxSmgmtPosSaleby = new javax.swing.JComboBox();
        jLabelSmgmtPosVCNo = new javax.swing.JLabel();
        jLabelSmgmtPosCustName = new javax.swing.JLabel();
        jLabelSmgmtPosSaleby = new javax.swing.JLabel();
        jLabelSmgmtPosIncSCode = new javax.swing.JLabel();
        jLabelSmgmtPosSQty = new javax.swing.JLabel();
        jLabelSmgmtPosPrize = new javax.swing.JLabel();
        jLabelSmgmtPosTPrize = new javax.swing.JLabel();
        jLabelSmgmtPosTPrizeShow = new javax.swing.JLabel();
        jLabelSmgmtPosPrizeShow = new javax.swing.JLabel();
        jLabelDiscountItem = new javax.swing.JLabel();
        jCheckBoxjLabelDiscountItem = new javax.swing.JCheckBox();
        jXDatePickerSmgmtPosDate = new org.jdesktop.swingx.JXDatePicker();
        jTextFieldSmgmtPosVCNo = new javax.swing.JTextField();
        jLabelSmgmtPosDate = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
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
        jLabelEmpRegWTeam = new javax.swing.JLabel();
        jComboBoxEmpRegWTeam = new javax.swing.JComboBox();
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
        jLabelItemRegUW = new javax.swing.JLabel();
        jLabelItemRegCategory = new javax.swing.JLabel();
        jLabelItemRegSupplier = new javax.swing.JLabel();
        jLabelItemRegUP = new javax.swing.JLabel();
        jTextFieldItemRegUP = new javax.swing.JTextField();
        jComboBoxItemRegSupplier = new javax.swing.JComboBox();
        jComboBoxItemRegCategory = new javax.swing.JComboBox();
        jTextFieldItemRegUW = new javax.swing.JTextField();
        jTextFieldItemRegCode = new javax.swing.JTextField();
        jTextFieldItemRegName = new javax.swing.JTextField();
        jButtonItemRegSave = new javax.swing.JButton();
        jButtonItemRegReset = new javax.swing.JButton();
        jLabelItemRegUM = new javax.swing.JLabel();
        jLabelItemRegSUM = new javax.swing.JLabel();
        jComboBoxItemRegUM = new javax.swing.JComboBox();
        jComboBoxItemRegUW = new javax.swing.JComboBox();
        jLabelItemRegSUW = new javax.swing.JLabel();
        jLabelItemRegSUInclude = new javax.swing.JLabel();
        jComboBoxItemRegSUM = new javax.swing.JComboBox();
        jTextFieldItemRegSUW = new javax.swing.JTextField();
        jComboBoxItemRegSUW = new javax.swing.JComboBox();
        jTextFieldItemRegSUInclude = new javax.swing.JTextField();
        jComboBoxItemRegSUInclude = new javax.swing.JComboBox();
        jComboBoxItemRegUP = new javax.swing.JComboBox();
        jLabelItemRegSUP = new javax.swing.JLabel();
        jTextFieldItemRegSUP = new javax.swing.JTextField();
        jComboBoxItemRegSUP = new javax.swing.JComboBox();
        jPanelFleetMGMT = new javax.swing.JPanel();
        jPanelReport = new javax.swing.JPanel();
        jTabbedPaneReportBase = new javax.swing.JTabbedPane();
        jPanelHelp = new javax.swing.JPanel();
        jTabbedPaneHelpBase = new javax.swing.JTabbedPane();
        jPanelContents = new javax.swing.JPanel();
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
            .addGap(0, 1332, Short.MAX_VALUE)
        );
        jPanelCompanyRegLayout.setVerticalGroup(
            jPanelCompanyRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 589, Short.MAX_VALUE)
        );

        jTabbedPaneSetupBase.addTab("COMPANY REG", jPanelCompanyReg);

        javax.swing.GroupLayout jPanelSetupLayout = new javax.swing.GroupLayout(jPanelSetup);
        jPanelSetup.setLayout(jPanelSetupLayout);
        jPanelSetupLayout.setHorizontalGroup(
            jPanelSetupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPaneSetupBase)
        );
        jPanelSetupLayout.setVerticalGroup(
            jPanelSetupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPaneSetupBase)
        );

        jTabbedPaneBase.addTab("SETUP", jPanelSetup);

        jPanelAccount.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanelAccountLayout = new javax.swing.GroupLayout(jPanelAccount);
        jPanelAccount.setLayout(jPanelAccountLayout);
        jPanelAccountLayout.setHorizontalGroup(
            jPanelAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1353, Short.MAX_VALUE)
        );
        jPanelAccountLayout.setVerticalGroup(
            jPanelAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );

        jTabbedPaneBase.addTab("ACCOUNT", jPanelAccount);

        jPanelSRM.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTabbedPaneSRMBase.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanelSupplierREG.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Supplier Information Entry Form", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        javax.swing.GroupLayout jPanelSupplierREGLayout = new javax.swing.GroupLayout(jPanelSupplierREG);
        jPanelSupplierREG.setLayout(jPanelSupplierREGLayout);
        jPanelSupplierREGLayout.setHorizontalGroup(
            jPanelSupplierREGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1332, Short.MAX_VALUE)
        );
        jPanelSupplierREGLayout.setVerticalGroup(
            jPanelSupplierREGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 589, Short.MAX_VALUE)
        );

        jTabbedPaneSRMBase.addTab("SUPPLIER REG", jPanelSupplierREG);

        javax.swing.GroupLayout jPanelSRMLayout = new javax.swing.GroupLayout(jPanelSRM);
        jPanelSRM.setLayout(jPanelSRMLayout);
        jPanelSRMLayout.setHorizontalGroup(
            jPanelSRMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPaneSRMBase)
        );
        jPanelSRMLayout.setVerticalGroup(
            jPanelSRMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPaneSRMBase)
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

        jComboBoxCustRegCity.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxCustRegCityItemStateChanged(evt);
            }
        });

        jTextAreaCustRegAddress.setColumns(20);
        jTextAreaCustRegAddress.setRows(5);
        jScrollPane2.setViewportView(jTextAreaCustRegAddress);

        jLabelCustRegChannel.setText("Channel : ");

        jLabelCustType.setText("Customer Type : ");

        javax.swing.GroupLayout jPanelCustRegLayout = new javax.swing.GroupLayout(jPanelCustReg);
        jPanelCustReg.setLayout(jPanelCustRegLayout);
        jPanelCustRegLayout.setHorizontalGroup(
            jPanelCustRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCustRegLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCustRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCustRegChannel)
                    .addComponent(jLabelCustRegCustomerName)
                    .addComponent(jLabelCustRegOutletName)
                    .addComponent(jLabelCustRegCity)
                    .addComponent(jLabelCustRegState)
                    .addComponent(jLabelCustRegCountry)
                    .addComponent(jLabelCustRegPhone)
                    .addComponent(jLabelCustRegMail)
                    .addComponent(jLabelCustRegFax)
                    .addComponent(jLabeCustReglTownship)
                    .addComponent(jLabelCustRegAddress)
                    .addComponent(jLabelCustType))
                .addGap(18, 18, 18)
                .addGroup(jPanelCustRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldCustRegOutletName, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(jTextFieldCustRegCustomerName, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addComponent(jComboBoxCustRegTownship, 0, 250, Short.MAX_VALUE)
                    .addComponent(jComboBoxCustRegCity, 0, 250, Short.MAX_VALUE)
                    .addComponent(jComboBoxCustRegState, 0, 250, Short.MAX_VALUE)
                    .addComponent(jComboBoxCustRegCountry, 0, 250, Short.MAX_VALUE)
                    .addComponent(jTextFieldCustRegPhone, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(jTextFieldCustRegEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(jTextFieldCustRegFax, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(jComboBoxCustRegChannel, 0, 250, Short.MAX_VALUE)
                    .addComponent(jComboBoxCustType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanelCustRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonCustRegSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonCustRegReset, javax.swing.GroupLayout.DEFAULT_SIZE, 940, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanelCustRegLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jComboBoxCustRegChannel, jComboBoxCustRegCity, jComboBoxCustRegCountry, jComboBoxCustRegState, jComboBoxCustRegTownship, jScrollPane2, jTextFieldCustRegCustomerName, jTextFieldCustRegEmail, jTextFieldCustRegFax, jTextFieldCustRegOutletName, jTextFieldCustRegPhone});

        jPanelCustRegLayout.setVerticalGroup(
            jPanelCustRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCustRegLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanelCustRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCustRegOutletName)
                    .addComponent(jTextFieldCustRegOutletName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelCustRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCustRegCustomerName)
                    .addComponent(jTextFieldCustRegCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelCustRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCustRegAddress)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelCustRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxCustRegTownship, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabeCustReglTownship))
                .addGap(18, 18, 18)
                .addGroup(jPanelCustRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCustRegCity)
                    .addComponent(jComboBoxCustRegCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelCustRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxCustRegState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCustRegState))
                .addGap(18, 18, 18)
                .addGroup(jPanelCustRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxCustRegCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCustRegCountry))
                .addGap(18, 18, 18)
                .addGroup(jPanelCustRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCustRegPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCustRegPhone))
                .addGap(18, 18, 18)
                .addGroup(jPanelCustRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCustRegEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCustRegMail))
                .addGap(18, 18, 18)
                .addGroup(jPanelCustRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCustRegFax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCustRegFax))
                .addGap(18, 18, 18)
                .addGroup(jPanelCustRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCustRegChannel)
                    .addComponent(jComboBoxCustRegChannel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelCustRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxCustType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCustType))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelCustRegLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonCustRegSave, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonCustRegReset, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 37, Short.MAX_VALUE))
        );

        jTabbedPaneCRMBase.addTab("CUSTOMER REGISTER", jPanelCustReg);

        javax.swing.GroupLayout jPanelCRMLayout = new javax.swing.GroupLayout(jPanelCRM);
        jPanelCRM.setLayout(jPanelCRMLayout);
        jPanelCRMLayout.setHorizontalGroup(
            jPanelCRMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPaneCRMBase)
        );
        jPanelCRMLayout.setVerticalGroup(
            jPanelCRMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPaneCRMBase)
        );

        jTabbedPaneBase.addTab("CRM", jPanelCRM);

        jPanelSMGMT.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTabbedPaneSMGMTBase.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanelInvoicing.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelSmgmtInvIncLo.setText("Invoicing Location : ");

        jLabelSmgmtInvCustType.setText("Customer Type :");

        jLabelSmgmtInvSaleby.setText("Sale by : ");

        jLabelSmgmtInvIncSCode.setText("Invoicing Stock Code : ");

        jLabelSmgmtInvSQty.setText("Stock Quantity : ");

        jLabelSmgmtInvPrize.setText("Unit Prize : ");

        jLabelSmgmtInvTPrize.setText("Total Prize :");

        jComboBoxSmgmtInvIncLo.setToolTipText("");
        jComboBoxSmgmtInvIncLo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxSmgmtInvIncLoItemStateChanged(evt);
            }
        });

        jComboBoxSmgmtInvIncSCode.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxSmgmtInvIncSCodeItemStateChanged(evt);
            }
        });

        jTextFieldSmgmtInvIncQty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldSmgmtInvIncQtyKeyReleased(evt);
            }
        });

        jLabelSmgmtInvPrizeShow.setText("jLabel10");

        jLabelSmgmtInvTPrizeShow.setText("jLabel11");

        jLabelSmgmtInvIncLoLong.setText("jLabel12");

        jLabelSmgmtInvIncSCodeLong.setText("jLabel13");

        jLabelSmgmtInvIncQtyPkg.setText("jLabel14");

        jTableSmgmtInvTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "Stock Code", "Description", "Quantity", "Unit Prize", "Tax", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jTableSmgmtInvTable);
        jTableSmgmtInvTable.getColumnModel().getColumn(0).setResizable(false);
        jTableSmgmtInvTable.getColumnModel().getColumn(1).setResizable(false);
        jTableSmgmtInvTable.getColumnModel().getColumn(2).setResizable(false);
        jTableSmgmtInvTable.getColumnModel().getColumn(3).setResizable(false);
        jTableSmgmtInvTable.getColumnModel().getColumn(4).setResizable(false);
        jTableSmgmtInvTable.getColumnModel().getColumn(5).setResizable(false);
        jTableSmgmtInvTable.getColumnModel().getColumn(6).setResizable(false);

        jButtonSmgmtInvAdd.setText("Add");

        jButtonSmgmtInvReset.setText("Reset");
        jButtonSmgmtInvReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSmgmtInvResetActionPerformed(evt);
            }
        });

        jButtonSmgmtInvSV.setText("Save & View");

        javax.swing.GroupLayout jPanelInvoicingLayout = new javax.swing.GroupLayout(jPanelInvoicing);
        jPanelInvoicing.setLayout(jPanelInvoicingLayout);
        jPanelInvoicingLayout.setHorizontalGroup(
            jPanelInvoicingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInvoicingLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelInvoicingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelInvoicingLayout.createSequentialGroup()
                        .addGroup(jPanelInvoicingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelSmgmtInvIncLo)
                            .addComponent(jLabelSmgmtInvCustType)
                            .addComponent(jLabelSmgmtInvSaleby)
                            .addComponent(jLabelSmgmtInvIncSCode)
                            .addComponent(jLabelSmgmtInvSQty)
                            .addComponent(jLabelSmgmtInvPrize)
                            .addComponent(jLabelSmgmtInvTPrize))
                        .addGap(23, 23, 23)
                        .addGroup(jPanelInvoicingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelSmgmtInvTPrizeShow)
                            .addComponent(jLabelSmgmtInvPrizeShow)
                            .addComponent(jComboBoxSmgmtInvSaleby, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxSmgmtInvCustType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxSmgmtInvIncLo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxSmgmtInvIncSCode, 0, 130, Short.MAX_VALUE)
                            .addComponent(jTextFieldSmgmtInvIncQty))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelInvoicingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelSmgmtInvIncSCodeLong)
                            .addComponent(jLabelSmgmtInvIncLoLong)
                            .addComponent(jLabelSmgmtInvIncQtyPkg))
                        .addGap(133, 133, 133)
                        .addComponent(jScrollPane4))
                    .addGroup(jPanelInvoicingLayout.createSequentialGroup()
                        .addComponent(jButtonSmgmtInvAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonSmgmtInvSV, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonSmgmtInvReset, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanelInvoicingLayout.setVerticalGroup(
            jPanelInvoicingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInvoicingLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelInvoicingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelInvoicingLayout.createSequentialGroup()
                        .addGroup(jPanelInvoicingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelSmgmtInvIncLo)
                            .addComponent(jComboBoxSmgmtInvIncLo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelSmgmtInvIncLoLong))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelInvoicingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelSmgmtInvCustType)
                            .addComponent(jComboBoxSmgmtInvCustType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelInvoicingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelSmgmtInvSaleby)
                            .addComponent(jComboBoxSmgmtInvSaleby, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelInvoicingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelSmgmtInvIncSCode)
                            .addComponent(jComboBoxSmgmtInvIncSCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelSmgmtInvIncSCodeLong))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelInvoicingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelSmgmtInvSQty)
                            .addComponent(jTextFieldSmgmtInvIncQty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelSmgmtInvIncQtyPkg))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelInvoicingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelSmgmtInvPrize)
                            .addComponent(jLabelSmgmtInvPrizeShow))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelInvoicingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelSmgmtInvTPrize)
                            .addComponent(jLabelSmgmtInvTPrizeShow))
                        .addGap(0, 65, Short.MAX_VALUE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanelInvoicingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSmgmtInvAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSmgmtInvReset, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSmgmtInvSV, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanelInvoicingLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButtonSmgmtInvAdd, jButtonSmgmtInvReset});

        jTabbedPaneSMGMTBase.addTab("INVOICING", jPanelInvoicing);

        jPanelPos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButtonSmgmtPosAdd.setText("Add");

        jButtonSmgmtPosReset.setText("Reset");
        jButtonSmgmtPosReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSmgmtPosResetActionPerformed(evt);
            }
        });

        jButtonSmgmtPosSave.setText("Save");

        jTableSmgmtPosTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "Stock Code", "Description", "Quantity", "Unit Prize", "Tax", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(jTableSmgmtPosTable);
        jTableSmgmtPosTable.getColumnModel().getColumn(0).setResizable(false);
        jTableSmgmtPosTable.getColumnModel().getColumn(1).setResizable(false);
        jTableSmgmtPosTable.getColumnModel().getColumn(2).setResizable(false);
        jTableSmgmtPosTable.getColumnModel().getColumn(3).setResizable(false);
        jTableSmgmtPosTable.getColumnModel().getColumn(4).setResizable(false);
        jTableSmgmtPosTable.getColumnModel().getColumn(5).setResizable(false);
        jTableSmgmtPosTable.getColumnModel().getColumn(6).setResizable(false);

        jLabelSmgmtInvIncSCodeLong1.setText("jLabel13");

        jLabelSmgmtInvIncQtyPkg1.setText("jLabel14");

        jLabelSmgmtPosVCNo.setText("Voucher No : ");

        jLabelSmgmtPosCustName.setText("Customer Name :");

        jLabelSmgmtPosSaleby.setText("Sold by : ");

        jLabelSmgmtPosIncSCode.setText("Stock Code : ");

        jLabelSmgmtPosSQty.setText("Stock Quantity : ");

        jLabelSmgmtPosPrize.setText("Unit Prize : ");

        jLabelSmgmtPosTPrize.setText("Total Prize :");

        jLabelSmgmtPosTPrizeShow.setText("jLabel11");

        jLabelSmgmtPosPrizeShow.setText("jLabel10");

        jLabelDiscountItem.setText("Discount Items : ");

        jCheckBoxjLabelDiscountItem.setText("YES");

        jXDatePickerSmgmtPosDate.setName(""); // NOI18N

        jLabelSmgmtPosDate.setText("Date : ");

        javax.swing.GroupLayout jPanelPosLayout = new javax.swing.GroupLayout(jPanelPos);
        jPanelPos.setLayout(jPanelPosLayout);
        jPanelPosLayout.setHorizontalGroup(
            jPanelPosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelPosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonSmgmtPosAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelPosLayout.createSequentialGroup()
                        .addGroup(jPanelPosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelSmgmtPosCustName)
                            .addComponent(jLabelSmgmtPosSaleby)
                            .addComponent(jLabelSmgmtPosIncSCode)
                            .addComponent(jLabelSmgmtPosSQty)
                            .addComponent(jLabelSmgmtPosPrize)
                            .addComponent(jLabelSmgmtPosVCNo)
                            .addComponent(jLabelSmgmtPosDate)
                            .addComponent(jLabelDiscountItem))
                        .addGap(20, 20, 20)
                        .addGroup(jPanelPosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBoxjLabelDiscountItem)
                            .addGroup(jPanelPosLayout.createSequentialGroup()
                                .addGroup(jPanelPosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanelPosLayout.createSequentialGroup()
                                        .addComponent(jLabelSmgmtPosPrizeShow)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabelSmgmtPosTPrize))
                                    .addGroup(jPanelPosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextFieldSmgmtPosVCNo, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jXDatePickerSmgmtPosDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextField1)
                                        .addComponent(jComboBoxSmgmtPosSaleby, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jComboBoxSmgmtPosIncSCode, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextFieldSmgmtPosIncQty)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanelPosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelSmgmtInvIncSCodeLong1)
                                    .addComponent(jLabelSmgmtInvIncQtyPkg1)
                                    .addComponent(jLabelSmgmtPosTPrizeShow))))
                        .addGap(0, 207, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelPosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelPosLayout.createSequentialGroup()
                        .addComponent(jButtonSmgmtPosSave, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonSmgmtPosReset, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane5))
                .addContainerGap())
        );

        jPanelPosLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jComboBoxSmgmtPosIncSCode, jComboBoxSmgmtPosSaleby, jTextField1, jTextFieldSmgmtPosIncQty, jTextFieldSmgmtPosVCNo, jXDatePickerSmgmtPosDate});

        jPanelPosLayout.setVerticalGroup(
            jPanelPosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelPosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPosLayout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanelPosLayout.createSequentialGroup()
                        .addGroup(jPanelPosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelSmgmtPosVCNo)
                            .addComponent(jTextFieldSmgmtPosVCNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelPosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jXDatePickerSmgmtPosDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelSmgmtPosDate))
                        .addGap(9, 9, 9)
                        .addGroup(jPanelPosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelSmgmtPosCustName)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelPosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelSmgmtPosSaleby)
                            .addComponent(jComboBoxSmgmtPosSaleby, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelPosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelSmgmtPosIncSCode)
                            .addComponent(jComboBoxSmgmtPosIncSCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelSmgmtInvIncSCodeLong1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelPosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelSmgmtPosSQty)
                            .addComponent(jTextFieldSmgmtPosIncQty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelSmgmtInvIncQtyPkg1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelPosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelSmgmtPosPrizeShow)
                            .addComponent(jLabelSmgmtPosTPrizeShow)
                            .addComponent(jLabelSmgmtPosPrize)
                            .addComponent(jLabelSmgmtPosTPrize))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelPosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelDiscountItem)
                            .addComponent(jCheckBoxjLabelDiscountItem))
                        .addGap(32, 50, Short.MAX_VALUE)))
                .addGroup(jPanelPosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSmgmtPosAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSmgmtPosReset, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSmgmtPosSave, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanelPosLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jComboBoxSmgmtPosIncSCode, jComboBoxSmgmtPosSaleby, jTextField1, jTextFieldSmgmtPosIncQty, jTextFieldSmgmtPosVCNo, jXDatePickerSmgmtPosDate});

        jTabbedPaneSMGMTBase.addTab("POS", jPanelPos);

        jPanelDo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanelDoLayout = new javax.swing.GroupLayout(jPanelDo);
        jPanelDo.setLayout(jPanelDoLayout);
        jPanelDoLayout.setHorizontalGroup(
            jPanelDoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1340, Short.MAX_VALUE)
        );
        jPanelDoLayout.setVerticalGroup(
            jPanelDoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 607, Short.MAX_VALUE)
        );

        jTabbedPaneSMGMTBase.addTab("DO", jPanelDo);

        javax.swing.GroupLayout jPanelSMGMTLayout = new javax.swing.GroupLayout(jPanelSMGMT);
        jPanelSMGMT.setLayout(jPanelSMGMTLayout);
        jPanelSMGMTLayout.setHorizontalGroup(
            jPanelSMGMTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPaneSMGMTBase)
        );
        jPanelSMGMTLayout.setVerticalGroup(
            jPanelSMGMTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPaneSMGMTBase)
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

        jTextAreaEmpRegAddress.setColumns(20);
        jTextAreaEmpRegAddress.setRows(5);
        jScrollPane1.setViewportView(jTextAreaEmpRegAddress);

        jLabelEmpRegEmail.setText("e-mail :");

        jComboBoxEmpRegCity.setToolTipText("");
        jComboBoxEmpRegCity.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxEmpRegCityItemStateChanged(evt);
            }
        });

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

        jPanelPersonalLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jComboBoxEmpRegCity, jComboBoxEmpRegCountry, jComboBoxEmpRegState, jComboBoxEmpRegTownship, jScrollPane1, jTextFieldEmpRegEmail, jTextFieldEmpRegMPhone, jTextFieldEmpRegNRCNo, jTextFieldEmpRegName});

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
                .addContainerGap(175, Short.MAX_VALUE))
        );

        jPanelWork.setBorder(javax.swing.BorderFactory.createTitledBorder("Work Information"));

        jLabelEmpRegDepartment.setText("Department :");

        jLabelEmpRegManager.setText("Manager :");

        jLabelEmpRegPosition.setText("Posistion :");

        jLabelEmpRegWPhone.setText("Work Phone :");

        jComboBoxEmpRegManager.setToolTipText("");

        jLabelEmpRegWTeam.setText("Work Team : ");

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
                                .addComponent(jComboBoxEmpRegManager, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanelWorkLayout.createSequentialGroup()
                        .addComponent(jLabelEmpRegWTeam)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxEmpRegWTeam, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelWorkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEmpRegWTeam)
                    .addComponent(jComboBoxEmpRegWTeam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(94, Short.MAX_VALUE))
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
                .addGroup(jPanelEmpRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelEmpRegLayout.createSequentialGroup()
                        .addComponent(jPanelWork, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonEmpRegSave, javax.swing.GroupLayout.DEFAULT_SIZE, 722, Short.MAX_VALUE))
                    .addComponent(jButtonEmpRegReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelEmpRegLayout.setVerticalGroup(
            jPanelEmpRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEmpRegLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelEmpRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelPersonal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelEmpRegLayout.createSequentialGroup()
                        .addGroup(jPanelEmpRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonEmpRegSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanelWork, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jButtonEmpRegReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPaneHRBase.addTab("EMP REG", jPanelEmpReg);

        javax.swing.GroupLayout jPanelHRMLayout = new javax.swing.GroupLayout(jPanelHRM);
        jPanelHRM.setLayout(jPanelHRMLayout);
        jPanelHRMLayout.setHorizontalGroup(
            jPanelHRMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPaneHRBase)
        );
        jPanelHRMLayout.setVerticalGroup(
            jPanelHRMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPaneHRBase)
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
                        .addComponent(jButtonWhRegResetl, javax.swing.GroupLayout.DEFAULT_SIZE, 1018, Short.MAX_VALUE)))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(jButtonWhRegResetl, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPaneWHMGMTBase.addTab("WH REG", jPanelWHREG);

        jPanelItemReg.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Item Information Entry Form", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabelItemRegName.setText("Name :");

        jLabelItemRegCode.setText("Code :");

        jLabelItemRegUW.setText("Unit Weight : ");

        jLabelItemRegCategory.setText("Category : ");

        jLabelItemRegSupplier.setText("Supplier : ");

        jLabelItemRegUP.setText("Unit Prize : ");

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

        jLabelItemRegUM.setText("Unit Measurement : ");

        jLabelItemRegSUM.setText("Sub Unit Measurement : ");

        jLabelItemRegSUW.setText("Sub Unit Weight : ");

        jLabelItemRegSUInclude.setText("Sub Unit Include : ");

        jLabelItemRegSUP.setText("Sub Unit Prize : ");

        javax.swing.GroupLayout jPanelItemRegLayout = new javax.swing.GroupLayout(jPanelItemReg);
        jPanelItemReg.setLayout(jPanelItemRegLayout);
        jPanelItemRegLayout.setHorizontalGroup(
            jPanelItemRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelItemRegLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelItemRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelItemRegName)
                    .addComponent(jLabelItemRegCode)
                    .addComponent(jLabelItemRegUM)
                    .addComponent(jLabelItemRegUP)
                    .addComponent(jLabelItemRegUW)
                    .addComponent(jLabelItemRegSUM)
                    .addComponent(jLabelItemRegSUW)
                    .addComponent(jLabelItemRegSUInclude)
                    .addComponent(jLabelItemRegSUP)
                    .addComponent(jLabelItemRegCategory)
                    .addComponent(jLabelItemRegSupplier))
                .addGap(18, 18, 18)
                .addGroup(jPanelItemRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelItemRegLayout.createSequentialGroup()
                        .addGroup(jPanelItemRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldItemRegSUInclude, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldItemRegSUP, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelItemRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxItemRegSUInclude, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxItemRegSUP, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelItemRegLayout.createSequentialGroup()
                        .addComponent(jTextFieldItemRegSUW, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBoxItemRegSUW, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jComboBoxItemRegCategory, 0, 250, Short.MAX_VALUE)
                    .addComponent(jComboBoxItemRegSUM, 0, 250, Short.MAX_VALUE)
                    .addGroup(jPanelItemRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelItemRegLayout.createSequentialGroup()
                            .addComponent(jTextFieldItemRegUP, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jComboBoxItemRegUP, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelItemRegLayout.createSequentialGroup()
                            .addComponent(jTextFieldItemRegUW, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jComboBoxItemRegUW, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelItemRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldItemRegCode)
                            .addComponent(jTextFieldItemRegName, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxItemRegUM, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jComboBoxItemRegSupplier, 0, 250, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanelItemRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonItemRegSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonItemRegReset, javax.swing.GroupLayout.DEFAULT_SIZE, 908, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanelItemRegLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jComboBoxItemRegCategory, jComboBoxItemRegSUM, jComboBoxItemRegSupplier, jTextFieldItemRegCode});

        jPanelItemRegLayout.setVerticalGroup(
            jPanelItemRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelItemRegLayout.createSequentialGroup()
                .addGroup(jPanelItemRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelItemRegLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonItemRegSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelItemRegLayout.createSequentialGroup()
                        .addGroup(jPanelItemRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelItemRegLayout.createSequentialGroup()
                                .addGroup(jPanelItemRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelItemRegName)
                                    .addComponent(jTextFieldItemRegName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldItemRegCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabelItemRegCode))
                        .addGap(14, 14, 14)
                        .addGroup(jPanelItemRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxItemRegUM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelItemRegUM))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelItemRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldItemRegUW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelItemRegUW)
                            .addComponent(jComboBoxItemRegUW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelItemRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelItemRegUP)
                            .addComponent(jTextFieldItemRegUP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxItemRegUP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelItemRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxItemRegSUM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelItemRegSUM))
                        .addGap(11, 11, 11)
                        .addGroup(jPanelItemRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldItemRegSUW)
                            .addComponent(jComboBoxItemRegSUW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelItemRegSUW))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelItemRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldItemRegSUInclude)
                            .addComponent(jComboBoxItemRegSUInclude, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelItemRegSUInclude))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelItemRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelItemRegLayout.createSequentialGroup()
                        .addGroup(jPanelItemRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxItemRegSUP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldItemRegSUP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelItemRegSUP))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelItemRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxItemRegCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelItemRegCategory))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelItemRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jComboBoxItemRegSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelItemRegSupplier)))
                    .addComponent(jButtonItemRegReset, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanelItemRegLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jComboBoxItemRegCategory, jComboBoxItemRegSUInclude, jComboBoxItemRegSUP, jComboBoxItemRegSUW, jComboBoxItemRegSupplier, jComboBoxItemRegUM, jComboBoxItemRegUP, jComboBoxItemRegUW, jTextFieldItemRegCode, jTextFieldItemRegName, jTextFieldItemRegSUP, jTextFieldItemRegUP, jTextFieldItemRegUW});

        jTabbedPaneWHMGMTBase.addTab("ITEM REG", jPanelItemReg);

        javax.swing.GroupLayout jPanelWhManagementLayout = new javax.swing.GroupLayout(jPanelWhManagement);
        jPanelWhManagement.setLayout(jPanelWhManagementLayout);
        jPanelWhManagementLayout.setHorizontalGroup(
            jPanelWhManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPaneWHMGMTBase)
        );
        jPanelWhManagementLayout.setVerticalGroup(
            jPanelWhManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPaneWHMGMTBase)
        );

        jTabbedPaneBase.addTab("WHMGMT", jPanelWhManagement);

        jPanelFleetMGMT.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanelFleetMGMTLayout = new javax.swing.GroupLayout(jPanelFleetMGMT);
        jPanelFleetMGMT.setLayout(jPanelFleetMGMTLayout);
        jPanelFleetMGMTLayout.setHorizontalGroup(
            jPanelFleetMGMTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1353, Short.MAX_VALUE)
        );
        jPanelFleetMGMTLayout.setVerticalGroup(
            jPanelFleetMGMTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );

        jTabbedPaneBase.addTab("FLEET MGMT", jPanelFleetMGMT);

        jPanelReport.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTabbedPaneReportBase.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanelReportLayout = new javax.swing.GroupLayout(jPanelReport);
        jPanelReport.setLayout(jPanelReportLayout);
        jPanelReportLayout.setHorizontalGroup(
            jPanelReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPaneReportBase, javax.swing.GroupLayout.DEFAULT_SIZE, 1353, Short.MAX_VALUE)
        );
        jPanelReportLayout.setVerticalGroup(
            jPanelReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPaneReportBase, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
        );

        jTabbedPaneBase.addTab("REPORT", jPanelReport);

        jPanelHelp.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTabbedPaneHelpBase.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanelContents.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanelContentsLayout = new javax.swing.GroupLayout(jPanelContents);
        jPanelContents.setLayout(jPanelContentsLayout);
        jPanelContentsLayout.setHorizontalGroup(
            jPanelContentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1340, Short.MAX_VALUE)
        );
        jPanelContentsLayout.setVerticalGroup(
            jPanelContentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 607, Short.MAX_VALUE)
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
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1320, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelAboutLayout.setVerticalGroup(
            jPanelAboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAboutLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPaneHelpBase.addTab("ABOUT", jPanelAbout);

        javax.swing.GroupLayout jPanelHelpLayout = new javax.swing.GroupLayout(jPanelHelp);
        jPanelHelp.setLayout(jPanelHelpLayout);
        jPanelHelpLayout.setHorizontalGroup(
            jPanelHelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPaneHelpBase)
        );
        jPanelHelpLayout.setVerticalGroup(
            jPanelHelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPaneHelpBase)
        );

        jTabbedPaneBase.addTab("Help", jPanelHelp);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPaneBase)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPaneBase)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEmpRegResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEmpRegResetActionPerformed
        // TODO add your handling code here:
        resetEmpRegPannel();
    }//GEN-LAST:event_jButtonEmpRegResetActionPerformed

    private void jButtonCustRegResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCustRegResetActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "Distory Operation Successful");
        resetCustRegPannel();
    }//GEN-LAST:event_jButtonCustRegResetActionPerformed

    private void jButtonWhRegSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonWhRegSaveActionPerformed
        // TODO add your handling code here:
        if (saveWhReg()) {
            JOptionPane.showMessageDialog(this, "Save Record Successful");
            resetWarehouseRegPannel();
        } else {
            JOptionPane.showMessageDialog(this, "Save Record Fail");
        }
    }//GEN-LAST:event_jButtonWhRegSaveActionPerformed

    private void jButtonWhRegResetlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonWhRegResetlActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "Record Distory Successful");
        resetWarehouseRegPannel();
    }//GEN-LAST:event_jButtonWhRegResetlActionPerformed

    private void jButtonItemRegSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonItemRegSaveActionPerformed
        // TODO add your handling code here:
        if (saveItemReg()) {
            JOptionPane.showMessageDialog(this, "Save Record Successful");
            resetItemRegPannel();
        } else {
            JOptionPane.showMessageDialog(this, "Save Record Fail");
        }
    }//GEN-LAST:event_jButtonItemRegSaveActionPerformed

    private void jButtonItemRegResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonItemRegResetActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "Distory Operation Successful");
        resetItemRegPannel();
    }//GEN-LAST:event_jButtonItemRegResetActionPerformed

    private void jButtonEmpRegSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEmpRegSaveActionPerformed
        // TODO add your handling code here:
        if (saveEmpReg()) {
            JOptionPane.showMessageDialog(this, "Save Record Successful");
            resetEmpRegPannel();
        } else {
            JOptionPane.showMessageDialog(this, "Save Record Fail");
        }
    }//GEN-LAST:event_jButtonEmpRegSaveActionPerformed

    private void jButtonCustRegSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCustRegSaveActionPerformed
        // TODO add your handling code here:
        if (saveCustReg()) {
            JOptionPane.showMessageDialog(this, "Save Record Successful");
            resetCustRegPannel();
        } else {
            JOptionPane.showMessageDialog(this, "Save Record Fail");
        }
    }//GEN-LAST:event_jButtonCustRegSaveActionPerformed

    private void jButtonSmgmtInvResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSmgmtInvResetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonSmgmtInvResetActionPerformed

    private void jButtonSmgmtPosResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSmgmtPosResetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonSmgmtPosResetActionPerformed

    private void jComboBoxCustRegCityItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxCustRegCityItemStateChanged
        // TODO add your handling code here:
        if (jComboBoxCustRegCity.getSelectedItem().toString().equals("YANGON")) {
            jComboBoxCustRegTownship.setEnabled(true);
        } else {
            jComboBoxCustRegTownship.setSelectedIndex(0);
            jComboBoxCustRegTownship.setEnabled(false);
        }
    }//GEN-LAST:event_jComboBoxCustRegCityItemStateChanged

    private void jComboBoxEmpRegCityItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxEmpRegCityItemStateChanged
        // TODO add your handling code here:
        if (jComboBoxEmpRegCity.getSelectedItem().toString().equals("YANGON")) {
            jComboBoxEmpRegTownship.setEnabled(true);
        } else {
            jComboBoxEmpRegTownship.setSelectedIndex(0);
            jComboBoxEmpRegTownship.setEnabled(false);
        }
    }//GEN-LAST:event_jComboBoxEmpRegCityItemStateChanged

    private void jComboBoxSmgmtInvIncLoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxSmgmtInvIncLoItemStateChanged
        // TODO add your handling code here:
        if (mCity != null && !evt.getItem().toString().equalsIgnoreCase("-- Select One --")) {
            jLabelSmgmtInvIncLoLong.setText(mCity.get(evt.getItem().toString()).getName());
        }
    }//GEN-LAST:event_jComboBoxSmgmtInvIncLoItemStateChanged

    private void jComboBoxSmgmtInvIncSCodeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxSmgmtInvIncSCodeItemStateChanged
        // TODO add your handling code here:
        String tempDisp;
        if (mItems != null && !evt.getItem().toString().equalsIgnoreCase("-- Select One --")) {
            jLabelSmgmtInvIncSCodeLong.setText(mItems.get(evt.getItem().toString()).getName());
            //tempDisp = mItems.get(evt.getItem().toString()).getStdPrices().toString();
            //smgmtInvTPrizeShow = Double.parseDouble(tempDisp);
            //jLabelSmgmtInvPrizeShow.setText(tempDisp);
        }
    }//GEN-LAST:event_jComboBoxSmgmtInvIncSCodeItemStateChanged

    private void jTextFieldSmgmtInvIncQtyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSmgmtInvIncQtyKeyReleased
        // TODO add your handling code here:
        //jComboBoxSmgmtInvIncLo.setSelectedItem("YGN");
        NumberFormat nf = new DecimalFormat("###,###,###,###,###,###,###,###.###");
        if (smgmtInvTPrizeShow == 700) {
            int total = (Integer.parseInt(jTextFieldSmgmtInvIncQty.getText()));
            int ctn = (Integer.parseInt(jTextFieldSmgmtInvIncQty.getText()) / 24);
            int pkg = total - (ctn * 24);

            if (pkg == 0) {
                jLabelSmgmtInvIncQtyPkg.setText(ctn + " Carton");
                jLabelSmgmtInvTPrizeShow.setText(nf.format(total * smgmtInvTPrizeShow));
            } else {
                jLabelSmgmtInvIncQtyPkg.setText(ctn + " Carton  " + pkg + " Package");
                jLabelSmgmtInvTPrizeShow.setText(nf.format(total * smgmtInvTPrizeShow));
            }
        } else {
            int total = (Integer.parseInt(jTextFieldSmgmtInvIncQty.getText()));
            int ctn = (Integer.parseInt(jTextFieldSmgmtInvIncQty.getText()) / 24);
            int pkg = total - (ctn * 24);

            if (pkg == 0) {
                jLabelSmgmtInvIncQtyPkg.setText(ctn + " Carton");
                jLabelSmgmtInvTPrizeShow.setText(nf.format(total * smgmtInvTPrizeShow));
            } else {
                jLabelSmgmtInvIncQtyPkg.setText(ctn + " Carton  " + pkg + " Package");
                jLabelSmgmtInvTPrizeShow.setText(nf.format(total * smgmtInvTPrizeShow));
            }
        }
    }//GEN-LAST:event_jTextFieldSmgmtInvIncQtyKeyReleased

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
    private javax.swing.ButtonGroup buttonGroupEmpRegTeam;
    private javax.swing.JButton jButtonCustRegReset;
    private javax.swing.JButton jButtonCustRegSave;
    private javax.swing.JButton jButtonEmpRegReset;
    private javax.swing.JButton jButtonEmpRegSave;
    private javax.swing.JButton jButtonItemRegReset;
    private javax.swing.JButton jButtonItemRegSave;
    private javax.swing.JButton jButtonSmgmtInvAdd;
    private javax.swing.JButton jButtonSmgmtInvReset;
    private javax.swing.JButton jButtonSmgmtInvSV;
    private javax.swing.JButton jButtonSmgmtPosAdd;
    private javax.swing.JButton jButtonSmgmtPosReset;
    private javax.swing.JButton jButtonSmgmtPosSave;
    private javax.swing.JButton jButtonWhRegResetl;
    private javax.swing.JButton jButtonWhRegSave;
    private javax.swing.JCheckBox jCheckBoxjLabelDiscountItem;
    private javax.swing.JComboBox jComboBoxCustRegChannel;
    private javax.swing.JComboBox jComboBoxCustRegCity;
    private javax.swing.JComboBox jComboBoxCustRegCountry;
    private javax.swing.JComboBox jComboBoxCustRegState;
    private javax.swing.JComboBox jComboBoxCustRegTownship;
    private javax.swing.JComboBox jComboBoxCustType;
    private javax.swing.JComboBox jComboBoxEmpRegCity;
    private javax.swing.JComboBox jComboBoxEmpRegCountry;
    private javax.swing.JComboBox jComboBoxEmpRegDepartment;
    private javax.swing.JComboBox jComboBoxEmpRegManager;
    private javax.swing.JComboBox jComboBoxEmpRegPosition;
    private javax.swing.JComboBox jComboBoxEmpRegState;
    private javax.swing.JComboBox jComboBoxEmpRegTownship;
    private javax.swing.JComboBox jComboBoxEmpRegWTeam;
    private javax.swing.JComboBox jComboBoxItemRegCategory;
    private javax.swing.JComboBox jComboBoxItemRegSUInclude;
    private javax.swing.JComboBox jComboBoxItemRegSUM;
    private javax.swing.JComboBox jComboBoxItemRegSUP;
    private javax.swing.JComboBox jComboBoxItemRegSUW;
    private javax.swing.JComboBox jComboBoxItemRegSupplier;
    private javax.swing.JComboBox jComboBoxItemRegUM;
    private javax.swing.JComboBox jComboBoxItemRegUP;
    private javax.swing.JComboBox jComboBoxItemRegUW;
    private javax.swing.JComboBox jComboBoxSmgmtInvCustType;
    private javax.swing.JComboBox jComboBoxSmgmtInvIncLo;
    private javax.swing.JComboBox jComboBoxSmgmtInvIncSCode;
    private javax.swing.JComboBox jComboBoxSmgmtInvSaleby;
    private javax.swing.JComboBox jComboBoxSmgmtPosIncSCode;
    private javax.swing.JComboBox jComboBoxSmgmtPosSaleby;
    private javax.swing.JComboBox jComboBoxWhRegCity;
    private javax.swing.JComboBox jComboBoxWhRegState;
    private javax.swing.JComboBox jComboBoxWhRegSupervisor;
    private javax.swing.JComboBox jComboBoxWhRegTownship;
    private javax.swing.JLabel jLabeCustReglTownship;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelCustRegAddress;
    private javax.swing.JLabel jLabelCustRegChannel;
    private javax.swing.JLabel jLabelCustRegCity;
    private javax.swing.JLabel jLabelCustRegCountry;
    private javax.swing.JLabel jLabelCustRegCustomerName;
    private javax.swing.JLabel jLabelCustRegFax;
    private javax.swing.JLabel jLabelCustRegMail;
    private javax.swing.JLabel jLabelCustRegOutletName;
    private javax.swing.JLabel jLabelCustRegPhone;
    private javax.swing.JLabel jLabelCustRegState;
    private javax.swing.JLabel jLabelCustType;
    private javax.swing.JLabel jLabelDiscountItem;
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
    private javax.swing.JLabel jLabelEmpRegWTeam;
    private javax.swing.JLabel jLabelItemRegCategory;
    private javax.swing.JLabel jLabelItemRegCode;
    private javax.swing.JLabel jLabelItemRegName;
    private javax.swing.JLabel jLabelItemRegSUInclude;
    private javax.swing.JLabel jLabelItemRegSUM;
    private javax.swing.JLabel jLabelItemRegSUP;
    private javax.swing.JLabel jLabelItemRegSUW;
    private javax.swing.JLabel jLabelItemRegSupplier;
    private javax.swing.JLabel jLabelItemRegUM;
    private javax.swing.JLabel jLabelItemRegUP;
    private javax.swing.JLabel jLabelItemRegUW;
    private javax.swing.JLabel jLabelSmgmtInvCustType;
    private javax.swing.JLabel jLabelSmgmtInvIncLo;
    private javax.swing.JLabel jLabelSmgmtInvIncLoLong;
    private javax.swing.JLabel jLabelSmgmtInvIncQtyPkg;
    private javax.swing.JLabel jLabelSmgmtInvIncQtyPkg1;
    private javax.swing.JLabel jLabelSmgmtInvIncSCode;
    private javax.swing.JLabel jLabelSmgmtInvIncSCodeLong;
    private javax.swing.JLabel jLabelSmgmtInvIncSCodeLong1;
    private javax.swing.JLabel jLabelSmgmtInvPrize;
    private javax.swing.JLabel jLabelSmgmtInvPrizeShow;
    private javax.swing.JLabel jLabelSmgmtInvSQty;
    private javax.swing.JLabel jLabelSmgmtInvSaleby;
    private javax.swing.JLabel jLabelSmgmtInvTPrize;
    private javax.swing.JLabel jLabelSmgmtInvTPrizeShow;
    private javax.swing.JLabel jLabelSmgmtPosCustName;
    private javax.swing.JLabel jLabelSmgmtPosDate;
    private javax.swing.JLabel jLabelSmgmtPosIncSCode;
    private javax.swing.JLabel jLabelSmgmtPosPrize;
    private javax.swing.JLabel jLabelSmgmtPosPrizeShow;
    private javax.swing.JLabel jLabelSmgmtPosSQty;
    private javax.swing.JLabel jLabelSmgmtPosSaleby;
    private javax.swing.JLabel jLabelSmgmtPosTPrize;
    private javax.swing.JLabel jLabelSmgmtPosTPrizeShow;
    private javax.swing.JLabel jLabelSmgmtPosVCNo;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPaneBase;
    private javax.swing.JTabbedPane jTabbedPaneCRMBase;
    private javax.swing.JTabbedPane jTabbedPaneHRBase;
    private javax.swing.JTabbedPane jTabbedPaneHelpBase;
    private javax.swing.JTabbedPane jTabbedPaneReportBase;
    private javax.swing.JTabbedPane jTabbedPaneSMGMTBase;
    private javax.swing.JTabbedPane jTabbedPaneSRMBase;
    private javax.swing.JTabbedPane jTabbedPaneSetupBase;
    private javax.swing.JTabbedPane jTabbedPaneWHMGMTBase;
    private javax.swing.JTable jTableSmgmtInvTable;
    private javax.swing.JTable jTableSmgmtPosTable;
    private javax.swing.JTextArea jTextAreaCustRegAddress;
    private javax.swing.JTextArea jTextAreaEmpRegAddress;
    private javax.swing.JTextArea jTextAreaWhRegAddress;
    private javax.swing.JTextField jTextField1;
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
    private javax.swing.JTextField jTextFieldItemRegSUInclude;
    private javax.swing.JTextField jTextFieldItemRegSUP;
    private javax.swing.JTextField jTextFieldItemRegSUW;
    private javax.swing.JTextField jTextFieldItemRegUP;
    private javax.swing.JTextField jTextFieldItemRegUW;
    private javax.swing.JTextField jTextFieldSmgmtInvIncQty;
    private javax.swing.JTextField jTextFieldSmgmtPosIncQty;
    private javax.swing.JTextField jTextFieldSmgmtPosVCNo;
    private javax.swing.JTextField jTextFieldWhRegName;
    private javax.swing.JTextField jTextFieldWhRegPhone;
    private org.jdesktop.swingx.JXDatePicker jXDatePickerSmgmtPosDate;
    // End of variables declaration//GEN-END:variables
}
