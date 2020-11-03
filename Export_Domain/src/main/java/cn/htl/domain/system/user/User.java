package cn.htl.domain.system.user;

import java.util.Date;

/**
 * @ClassName User
 * @Description TODO
 * @Author 虎太郎
 * @Date 2020/11/2 10:37
 * @Version 1.0
 */
public class User {
    private	String 	userId        ;
    private	String 	deptId        ;
    private	String 	email         ;
    private	String 	userName      ;
    private	String 	station       ;
    private	String 	password      ;
    private	long 	state         ;
    private	String 	companyId     ;
    private	String 	companyName   ;
    private	String 	deptName      ;
    private	String 	managerId     ;
    private	String 	gender        ;
    private	String 	telephone     ;
    private	String 	birthday      ;
    private	int 	degree        ;
    private	double 	salary        ;
    private	String 	joinDate      ;
    private	long 	orderNo       ;
    private	String 	createBy      ;
    private	String 	createDempt   ;
    private Date    createTime    ;
    private	String 	updateBy      ;
    private	Date 	updateTime    ;
    private	String 	remark        ;

    public User() {
    }

    public User(String userId, String deptId, String email, String userName, String station, String password,
                long state, String companyId, String companyName,
                String deptName, String managerId, String gender,
                String telephone, String birthday, int degree, double salary,
                String joinDate, long orderNo, String createBy, String createDempt,
                Date createTime, String updateBy, Date updateTime, String remark) {

        this.userId = userId;
        this.deptId = deptId;
        this.email = email;
        this.userName = userName;
        this.station = station;
        this.password = password;
        this.state = state;
        this.companyId = companyId;
        this.companyName = companyName;
        this.deptName = deptName;
        this.managerId = managerId;
        this.gender = gender;
        this.telephone = telephone;
        this.birthday = birthday;
        this.degree = degree;
        this.salary = salary;
        this.joinDate = joinDate;
        this.orderNo = orderNo;
        this.createBy = createBy;
        this.createDempt = createDempt;
        this.createTime = createTime;
        this.updateBy = updateBy;
        this.updateTime = updateTime;
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", deptId='" + deptId + '\'' +
                ", email='" + email + '\'' +
                ", userName='" + userName + '\'' +
                ", station='" + station + '\'' +
                ", password='" + password + '\'' +
                ", state=" + state +
                ", companyId='" + companyId + '\'' +
                ", companyName='" + companyName + '\'' +
                ", deptName='" + deptName + '\'' +
                ", managerId='" + managerId + '\'' +
                ", gender='" + gender + '\'' +
                ", telephone='" + telephone + '\'' +
                ", birthday='" + birthday + '\'' +
                ", degree=" + degree +
                ", salary=" + salary +
                ", joinDate='" + joinDate + '\'' +
                ", orderNo=" + orderNo +
                ", createBy='" + createBy + '\'' +
                ", createDempt='" + createDempt + '\'' +
                ", createTime=" + createTime +
                ", updateBy='" + updateBy + '\'' +
                ", updateTime=" + updateTime +
                ", remark='" + remark + '\'' +
                '}';
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getState() {
        return state;
    }

    public void setState(long state) {
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

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public long getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(long orderNo) {
        this.orderNo = orderNo;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getCreateDempt() {
        return createDempt;
    }

    public void setCreateDempt(String createDempt) {
        this.createDempt = createDempt;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
