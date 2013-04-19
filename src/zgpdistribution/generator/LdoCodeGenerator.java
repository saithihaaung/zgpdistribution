/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zgpdistribution.generator;

import zgpdistribution.util.LdoNoDAO;

/**
 *
 * @author HWT
 */
public class LdoCodeGenerator {

    public LdoCodeGenerator() {
    }
    
    public void generateCode(String cityCode, String customerType) {
        StringBuilder sb = new StringBuilder();
        int no = new LdoNoDAO().getLatestNo();
        no++;
        sb.append("LDO-");
        sb.append(cityCode);
        sb.append("-");
        sb.append(customerType);
        sb.append("-");
        sb.append(no);
        System.out.println(sb.toString());
    }
    
    public static void main(String[] arg) {
        new LdoCodeGenerator().generateCode("YGN", "MT");
    }
}
