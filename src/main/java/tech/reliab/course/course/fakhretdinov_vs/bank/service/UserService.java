package tech.reliab.course.course.fakhretdinov_vs.bank.service;

import tech.reliab.course.course.fakhretdinov_vs.bank.entity.Bank;
import tech.reliab.course.course.fakhretdinov_vs.bank.entity.User;

import java.util.Date;

public interface UserService {
    User create(String fullName, Date birthdate, String placeOfWork, Bank bank);
    User read();
    void update(User user);
    void delete(User user);
}
