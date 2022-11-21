package tech.reliab.course.course.fakhretdinov_vs.bank.entity;

import tech.reliab.course.course.fakhretdinov_vs.bank.entity.core.Identifier;
import tech.reliab.course.course.fakhretdinov_vs.bank.entity.enums.BankAtmStatus;

public class BankAtm extends Identifier {

    private Bank bank;
    private String name;
    private String address;
    private BankAtmStatus status;
    private Employee serviceEmployee;
    private Boolean isPaymentingMoney;
    private Boolean isDepositingMoney;
    private Long numberOfMoney;
    private Integer maintenancePrice;

    public BankAtm(Long id,
                   Bank bank,
                   String name,
                   String address,
                   BankAtmStatus status,
                   Employee serviceEmployee,
                   Boolean isPaymentingMoney,
                   Boolean isDepositingMoney,
                   Long numberOfMoney,
                   Integer maintenancePrice) {
        super(id);
        this.bank = bank;
        this.name = name;
        this.address = address;
        this.status = status;
        this.serviceEmployee = serviceEmployee;
        this.isPaymentingMoney = isPaymentingMoney;
        this.isDepositingMoney = isDepositingMoney;
        this.numberOfMoney = numberOfMoney;
        this.maintenancePrice = maintenancePrice;
    }

    @Override
    public String toString() {
        return "BankAtm{" +
                "id=" + this.getId() +
                ", bank='" + bank + '\'' +
                ", name=" + name +
                ", address=" + address +
                ", status='" + status + '\'' +
                ", serviceEmployee=" + serviceEmployee +
                ", isPaymentingMoney=" + isPaymentingMoney +
                ", isDepositingMoney=" + isDepositingMoney +
                ", numberOfMoney=" + numberOfMoney +
                ", maintenancePrice=" + maintenancePrice +
                '}';
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
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

    public Employee getServiceEmployee() {
        return serviceEmployee;
    }

    public void setServiceEmployee(Employee serviceEmployee) {
        this.serviceEmployee = serviceEmployee;
    }

    public Boolean getPaymentingMoney() {
        return isPaymentingMoney;
    }

    public void setPaymentingMoney(Boolean paymentingMoney) {
        isPaymentingMoney = paymentingMoney;
    }

    public Boolean getDepositingMoney() {
        return isDepositingMoney;
    }

    public void setDepositingMoney(Boolean depositingMoney) {
        isDepositingMoney = depositingMoney;
    }

    public Long getNumberOfMoney() {
        return numberOfMoney;
    }

    public void setNumberOfMoney(Long numberOfMoney) {
        this.numberOfMoney = numberOfMoney;
    }

    public Integer getMaintenancePrice() {
        return maintenancePrice;
    }

    public void setMaintenancePrice(Integer maintenancePrice) {
        this.maintenancePrice = maintenancePrice;
    }

}
