/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zgpdistribution.util.oops;

/**
 *
 * @author John
 */
public class ItemList {

    private String name, code, netUom, subUom, category, supplier, netWeightM, subWeightM;
    private int subUnitInclude;
    private Double netWeight, subWeight, netPrize, subPrize;

    public ItemList() {
    }

    public ItemList(String name, String code, String netUom, String subUom, String category, String supplier, String netWeightM, String subWeightM, int subUnitInclude, Double netWeight, Double subWeight, Double netPrize, Double subPrize) {
        this.name = name;
        this.code = code;
        this.netUom = netUom;
        this.subUom = subUom;
        this.category = category;
        this.supplier = supplier;
        this.netWeightM = netWeightM;
        this.subWeightM = subWeightM;
        this.subUnitInclude = subUnitInclude;
        this.netWeight = netWeight;
        this.subWeight = subWeight;
        this.netPrize = netPrize;
        this.subPrize = subPrize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNetUom() {
        return netUom;
    }

    public void setNetUom(String netUom) {
        this.netUom = netUom;
    }

    public String getSubUom() {
        return subUom;
    }

    public void setSubUom(String subUom) {
        this.subUom = subUom;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getNetWeightM() {
        return netWeightM;
    }

    public void setNetWeightM(String netWeightM) {
        this.netWeightM = netWeightM;
    }

    public String getSubWeightM() {
        return subWeightM;
    }

    public void setSubWeightM(String subWeightM) {
        this.subWeightM = subWeightM;
    }

    public int getSubUnitInclude() {
        return subUnitInclude;
    }

    public void setSubUnitInclude(int subUnitInclude) {
        this.subUnitInclude = subUnitInclude;
    }

    public Double getNetWeight() {
        return netWeight;
    }

    public void setNetWeight(Double netWeight) {
        this.netWeight = netWeight;
    }

    public Double getSubWeight() {
        return subWeight;
    }

    public void setSubWeight(Double subWeight) {
        this.subWeight = subWeight;
    }

    public Double getNetPrize() {
        return netPrize;
    }

    public void setNetPrize(Double netPrize) {
        this.netPrize = netPrize;
    }

    public Double getSubPrize() {
        return subPrize;
    }

    public void setSubPrize(Double subPrize) {
        this.subPrize = subPrize;
    }
}
