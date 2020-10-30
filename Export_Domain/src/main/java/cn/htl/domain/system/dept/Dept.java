package cn.htl.domain.system.dept;

/**
 * @ClassName Dept
 * @Description TODO
 * @Author 胡靖
 * @Date 2020/10/29 20:52
 * @Version 1.0
 */
public class Dept {

    private String deptId;
    private String deptName;
    //private String parentId; //上级部门
    private Dept parent; //上级部门
    private Integer state;
    private String companyId;//企业id
    private String companyName;

    public Dept() {
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptId='" + deptId + '\'' +
                ", deptName='" + deptName + '\'' +
                ", parent=" + parent +
                ", state=" + state +
                ", companyId='" + companyId + '\'' +
                ", companyName='" + companyName + '\'' +
                '}';
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Dept getParent() {
        return parent;
    }

    public void setParent(Dept parent) {
        this.parent = parent;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Dept(String deptId, String deptName, Dept parent, Integer state, String companyId, String companyName) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.parent = parent;
        this.state = state;
        this.companyId = companyId;
        this.companyName = companyName;
    }
}
