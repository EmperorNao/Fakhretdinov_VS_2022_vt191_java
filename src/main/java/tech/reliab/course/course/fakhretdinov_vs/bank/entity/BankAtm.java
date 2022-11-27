package tech.reliab.course.course.fakhretdinov_vs.bank.entity;

import tech.reliab.course.course.fakhretdinov_vs.bank.entity.core.Identifier;
import tech.reliab.course.course.fakhretdinov_vs.bank.entity.enums.BankAtmStatus;

public class BankAtm extends Identifier {

    private Long bankId;
    private String name;
    private String address;
    private BankAtmStatus status;

    private Long serviceEmployeeId;
    private boolean isPaymentingMoney;
    private boolean isDepositingMoney;
    private long numberOfMoney;
    private int maintenancePrice;

    public BankAtm(Long id,
                   Long bankId,
                   String name,
                   String address,
                   BankAtmStatus status,
                   Long serviceEmployeeId,
                   boolean isPaymentingMoney,
                   boolean isDepositingMoney,
                   long numberOfMoney,
                   int maintenancePrice) {
        super(id);
        this.bankId = bankId;
        this.name = name;
        this.address = address;
        this.status = status;
        this.serviceEmployeeId = serviceEmployeeId;
        this.isPaymentingMoney = isPaymentingMoney;
        this.isDepositingMoney = isDepositingMoney;
        this.numberOfMoney = numberOfMoney;
        this.maintenancePrice = maintenancePrice;
    }

    @Override
    public String toString() {
        return "BankAtm{" +
                "id=" + getId() +
                ", bankId='" + bankId + '\'' +
                ", name=" + name +
                ", address=" + address +
                ", status='" + status + '\'' +
                ", serviceEmployeeId=" + serviceEmployeeId +
                ", isPaymentingMoney=" + isPaymentingMoney +
                ", isDepositingMoney=" + isDepositingMoney +
                ", numberOfMoney=" + numberOfMoney +
                ", maintenancePrice=" + maintenancePrice +
                '}';
    }

    public Long getBankId() {
        return bankId;
    }

    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BankAtmStatus getStatus() {
        return status;
    }

    public void setStatus(BankAtmStatus status) {
        this.status = status;
    }

    public Long getServiceEmployeeId() {
        return serviceEmployeeId;
    }

    public void setServiceEmployeeId(Long serviceEmployeeId) {
        this.serviceEmployeeId = serviceEmployeeId;
    }

    public boolean getPaymentingMoney() {
        return isPaymentingMoney;
    }

    public void setPaymentingMoney(boolean paymentingMoney) {
        isPaymentingMoney = paymentingMoney;
    }

    public boolean getDepositingMoney() {
        return isDepositingMoney;
    }

    public void setDepositingMoney(boolean depositingMoney) {
        isDepositingMoney = depositingMoney;
    }

    public long getNumberOfMoney() {
        return numberOfMoney;
    }

    public void setNumberOfMoney(long numberOfMoney) {
        this.numberOfMoney = numberOfMoney;
    }

    public int getMaintenancePrice() {
        return maintenancePrice;
    }

    public void setMaintenancePrice(int maintenancePrice) {
        this.maintenancePrice = maintenancePrice;
    }

}
