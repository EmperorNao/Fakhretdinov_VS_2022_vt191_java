package tech.reliab.course.course.fakhretdinov_vs.bank.entity;

import tech.reliab.course.course.fakhretdinov_vs.bank.entity.core.Identifier;

import java.time.LocalDate;


public class Employee extends Identifier {

    private Long bankId;
    private String fullName;
    private LocalDate birthDate;
    private String position;
    private Boolean workingInOffice;
    private Long bankOfficeId;
    private Boolean creditCanBeIssued;
    private Long salary;

    public Employee(Long id,
                    Long bank,
                    String fullName,
                    LocalDate birthDate,
                    String position,
                    Boolean workingInOffice,
                    Long bankOffice,
                    Boolean creditCanBeIssued,
                    Long salary) {
        super(id);
        this.bankId = bankId;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.position = position;
        this.workingInOffice = workingInOffice;
        this.bankOfficeId = bankOfficeId;
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
        this.bankId = bankId;
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

    public Boolean getWorkingInOffice() {
        return workingInOffice;
    }

    public void setWorkingInOffice(Boolean workingInOffice) {
        this.workingInOffice = workingInOffice;
    }

    public Long getBankOfficeId() {
        return bankOfficeId;
    }

    public void setBankOfficeId(Long bankOfficeId) {
        this.bankOfficeId = bankOfficeId;
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
