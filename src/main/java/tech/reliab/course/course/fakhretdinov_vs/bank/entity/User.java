package tech.reliab.course.course.fakhretdinov_vs.bank.entity;

import tech.reliab.course.course.fakhretdinov_vs.bank.entity.core.Identifier;

import java.time.LocalDate;
import java.util.ArrayList;

public class User extends Identifier {

    private String fullName;
    private LocalDate birthDate;
    private String placeOfWork;
    private Long monthlySalary;
    private int creditRating;

    public User(Long id,
                String fullName,
                LocalDate birthDate,
                String placeOfWork,
                Long monthlySalary,
                int creditRating) {
        super(id);
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.placeOfWork = placeOfWork;
        this.monthlySalary = monthlySalary;
        this.creditRating = creditRating;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + getId() +
                ", fullName=" + fullName +
                ", birthDate='" + birthDate + '\'' +
                ", placeOfWork=" + placeOfWork +
                ", monthlySalary='" + monthlySalary + '\'' +
                ", creditRating=" + creditRating +
                '}';
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

    public String getPlaceOfWork() {
        return placeOfWork;
    }

    public void setPlaceOfWork(String placeOfWork) {
        this.placeOfWork = placeOfWork;
    }

    public Long getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(Long monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public int getCreditRating() {
        return creditRating;
    }

    public void setCreditRating(int creditRating) {
        this.creditRating = creditRating;
    }

}
