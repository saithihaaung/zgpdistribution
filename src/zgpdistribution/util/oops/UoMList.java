/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zgpdistribution.util.oops;

/**
 *
 * @author John
 */
public class UoMList {

    private String uomLong, uomShort;

    public UoMList() {
    }

    public UoMList(String uomLong, String uomShort) {
        this.uomLong = uomLong;
        this.uomShort = uomShort;
    }

    public String getUomLong() {
        return uomLong;
    }

    public void setUomLong(String uomLong) {
        this.uomLong = uomLong;
    }

    public String getUomShort() {
        return uomShort;
    }

    public void setUomShort(String uomShort) {
        this.uomShort = uomShort;
    }
}
