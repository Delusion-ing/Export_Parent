package cn.htl.domain.system.module;

/**
 * @ClassName Module
 * @Description TODO
 * @Author 虎太郎
 * @Date 2020/10/31 16:45
 * @Version 1.0
 */
public class Module {
    private String moduleId;
    private String parentId;
    private String parentName;
    private String name;
    private long   layerNum;
    private long   isLeaf;
    private String ico;
    private String cpermission;
    private String curl;
    private long   ctype;
    private long   state;
    private String belong;
    private String cwhich;
    private long   quoteNum;
    private String remark;
    private long   orderNo;

    public Module() {
    }

    public Module(String moduleId, String parentId, String parentName, String name, long layerNum, long isLeaf, String ico, String cpermission, String curl, long ctype, long state, String belong, String cwhich, long quoteNum, String remark, long orderNo) {
        this.moduleId = moduleId;
        this.parentId = parentId;
        this.parentName = parentName;
        this.name = name;
        this.layerNum = layerNum;
        this.isLeaf = isLeaf;
        this.ico = ico;
        this.cpermission = cpermission;
        this.curl = curl;
        this.ctype = ctype;
        this.state = state;
        this.belong = belong;
        this.cwhich = cwhich;
        this.quoteNum = quoteNum;
        this.remark = remark;
        this.orderNo = orderNo;
    }

    @Override
    public String toString() {
        return "Module{" +
                "moduleId='" + moduleId + '\'' +
                ", parentId='" + parentId + '\'' +
                ", parentName='" + parentName + '\'' +
                ", name='" + name + '\'' +
                ", layerNum=" + layerNum +
                ", isLeaf=" + isLeaf +
                ", ico='" + ico + '\'' +
                ", cpermission='" + cpermission + '\'' +
                ", curl='" + curl + '\'' +
                ", ctype=" + ctype +
                ", state=" + state +
                ", belong='" + belong + '\'' +
                ", cwhich='" + cwhich + '\'' +
                ", quoteNum=" + quoteNum +
                ", remark='" + remark + '\'' +
                ", orderNo=" + orderNo +
                '}';
    }

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getLayerNum() {
        return layerNum;
    }

    public void setLayerNum(long layerNum) {
        this.layerNum = layerNum;
    }

    public long getIsLeaf() {
        return isLeaf;
    }

    public void setIsLeaf(long isLeaf) {
        this.isLeaf = isLeaf;
    }

    public String getIco() {
        return ico;
    }

    public void setIco(String ico) {
        this.ico = ico;
    }

    public String getCpermission() {
        return cpermission;
    }

    public void setCpermission(String cpermission) {
        this.cpermission = cpermission;
    }

    public String getCurl() {
        return curl;
    }

    public void setCurl(String curl) {
        this.curl = curl;
    }

    public long getCtype() {
        return ctype;
    }

    public void setCtype(long ctype) {
        this.ctype = ctype;
    }

    public long getState() {
        return state;
    }

    public void setState(long state) {
        this.state = state;
    }

    public String getBelong() {
        return belong;
    }

    public void setBelong(String belong) {
        this.belong = belong;
    }

    public String getCwhich() {
        return cwhich;
    }

    public void setCwhich(String cwhich) {
        this.cwhich = cwhich;
    }

    public long getQuoteNum() {
        return quoteNum;
    }

    public void setQuoteNum(long quoteNum) {
        this.quoteNum = quoteNum;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public long getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(long orderNo) {
        this.orderNo = orderNo;
    }
}
