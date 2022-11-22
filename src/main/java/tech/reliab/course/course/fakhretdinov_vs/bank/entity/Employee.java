package tech.reliab.course.course.fakhretdinov_vs.bank.entity;

import tech.reliab.course.course.fakhretdinov_vs.bank.entity.core.Identifier;

import java.util.Date;

public class Employee extends Identifier {

    private Bank bank;
    private String fullName;
    private Date birthDate;
    private String position;
    private Boolean workingInOffice;
    private BankOffice bankOffice;
    private Boolean creditCanBeIssued;
    private Long salary;

    public Employee(Long id,
                    Bank bank,
                    String fullName,
                    Date birthDate,
                    String position,
                    Boolean workingInOffice,
                    BankOffice bankOffice,
                    Boolean creditCanBeIssued,
                    Long salary) {
        super(id);
        this.bank = bank;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.position = position;
        this.workingInOffice = workingInOffice;
        this.bankOffice = bankOffice;
        this.creditCanBeIssued = creditCanBeIssued;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + getId() +
                ", bank='" + bank + '\'' +
                ", fullName=" + fullName +
                ", birthDate='" + birthDate + '\'' +
                ", position=" + position +
                ", workingInOffice=" + workingInOffice +
                ", bankOffice=" + bankOffice +
                ", creditCanBeIssued=" + creditCanBeIssued +
                ", salary=" + salary +
                '}';
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Boolean getWorkingInOffice() {
        return workingInOffice;
    }

    public void setWorkingInOffice(Boolean workingInOffice) {
        this.workingInOffice = workingInOffice;
    }

    public BankOffice getBankOffice() {
        return bankOffice;
    }

    public void setBankOffice(BankOffice bankOffice) {
        this.bankOffice = bankOffice;
    }

    public Boolean getCreditCanBeIssued() {
        return creditCanBeIssued;
    }

    public void setCreditCanBeIssued(Boolean creditCanBeIssued) {
        this.creditCanBeIssued = creditCanBeIssued;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

}
