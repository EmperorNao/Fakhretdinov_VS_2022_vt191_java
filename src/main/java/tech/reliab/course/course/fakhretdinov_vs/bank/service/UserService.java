package tech.reliab.course.course.fakhretdinov_vs.bank.service;

import tech.reliab.course.course.fakhretdinov_vs.bank.entity.Bank;
import tech.reliab.course.course.fakhretdinov_vs.bank.entity.BankAtm;
import tech.reliab.course.course.fakhretdinov_vs.bank.entity.User;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.core.Service;

import java.time.LocalDate;
import java.util.ArrayList;


public interface UserService extends Service<User> {
    User create(String fullName,
                LocalDate birthdate,
                String placeOfWork);
    User get(Long id);
    ArrayList<User> read();
    void printUserInfo(User user);


}
