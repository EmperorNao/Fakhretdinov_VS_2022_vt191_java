package tech.reliab.course.course.fakhretdinov_vs.bank.entity;

import tech.reliab.course.course.fakhretdinov_vs.bank.entity.core.Identifier;

import java.time.LocalDate;


public class Employee extends Identifier {

    private Long bankId;
    private String fullName;
    private LocalDate birthDate;
    private String position;
    private boolean workingInOffice;
    private Long bankOfficeId;
    private boolean creditCanBeIssued;
    private Long salary;

    public Employee(Long id,
                    Long bank,
                    String fullName,
                    LocalDate birthDate,
                    String position,
                    boolean workingInOffice,
                    Long bankOffice,
                    boolean creditCanBeIssued,
                    Long salary) {
        super(id);
        this.bankId = bank;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.position = position;
        this.workingInOffice = workingInOffice;
        this.bankOfficeId = bankOffice;
        this.creditCanBeIssued = creditCanBeIssued;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + getId() +
                ", bankId='" + bankId + '\'' +
                ", fullName=" + fullName +
                ", birthDate='" + birthDate + '\'' +
                ", position=" + position +
                ", workingInOffice=" + workingInOffice +
                ", bankOfficeId=" + bankOfficeId +
                ", creditCanBeIssued=" + creditCanBeIssued +
                ", salary=" + salary +
                '}';
    }

    public Long getBankId() {
        return bankId;
    }

    public void setBankId(Long bank) {
        this.bankId = bank;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public boolean getWorkingInOffice() {
        return workingInOffice;
    }

    public void setWorkingInOffice(boolean workingInOffice) {
        this.workingInOffice = workingInOffice;
    }

    public Long getBankOfficeId() {
        return bankOfficeId;
    }

    public void setBankOfficeId(Long bankOfficeId) {
        this.bankOfficeId = bankOfficeId;
    }

    public boolean getCreditCanBeIssued() {
        return creditCanBeIssued;
    }

    public void setCreditCanBeIssued(boolean creditCanBeIssued) {
        this.creditCanBeIssued = creditCanBeIssued;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

}
