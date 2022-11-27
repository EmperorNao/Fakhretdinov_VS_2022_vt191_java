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
    private long salary;

    public Employee(Long id,
                    Long bankId,
                    String fullName,
                    LocalDate birthDate,
                    String position,
                    boolean workingInOffice,
                    Long bankOfficeId,
                    boolean creditCanBeIssued,
                    long salary) {
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

    public void setBankId(Long bankId) {
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

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

}
