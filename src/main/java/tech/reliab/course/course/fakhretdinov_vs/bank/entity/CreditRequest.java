package tech.reliab.course.course.fakhretdinov_vs.bank.entity;

public class CreditRequest {

    private Long bankId;
    private Long officeId;
    private Long atmId;
    private Long employeeId;
    private Long userId;
    private long numberOfMoney;
    private int numberOfMonths;
    private int userCreditRating;

    public CreditRequest(Long bankId,
                         Long officeId,
                         Long atmId,
                         Long employeeId,
                         Long userId,
                         long numberOfMoney,
                         int numberOfMonths,
                         int userCreditRating) {
        this.bankId = bankId;
        this.officeId = officeId;
        this.atmId = atmId;
        this.employeeId = employeeId;
        this.userId = userId;
        this.numberOfMoney = numberOfMoney;
        this.numberOfMonths = numberOfMonths;
        this.userCreditRating = userCreditRating;
    }

    @Override
    public String toString() {
        return "CreditRequest{" +
                "bankId=" + bankId +
                ", officeId=" + officeId +
                ", atmId=" + atmId +
                ", employeeId=" + employeeId +
                ", userId=" + userId +
                ", numberOfMoney=" + numberOfMoney +
                ", numberOfMonths=" + numberOfMonths +
                ", userCreditRating=" + userCreditRating +
                '}';
    }

    public Long getBankId() {
        return bankId;
    }

    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }

    public Long getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Long officeId) {
        this.officeId = officeId;
    }

    public long getNumberOfMoney() {
        return numberOfMoney;
    }

    public void setNumberOfMoney(long numberOfMoney) {
        this.numberOfMoney = numberOfMoney;
    }

    public int getNumberOfMonths() {
        return numberOfMonths;
    }

    public void setNumberOfMonths(int numberOfMonths) {
        this.numberOfMonths = numberOfMonths;
    }

    public Long getAtmId() {
        return atmId;
    }

    public void setAtmId(Long atmId) {
        this.atmId = atmId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public int getUserCreditRating() {
        return userCreditRating;
    }

    public void setUserCreditRating(int userCreditRating) {
        this.userCreditRating = userCreditRating;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
