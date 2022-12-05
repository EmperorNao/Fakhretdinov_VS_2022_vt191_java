package tech.reliab.course.course.fakhretdinov_vs.bank.service;

import tech.reliab.course.course.fakhretdinov_vs.bank.entity.User;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.core.Service;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.exceptions.WrongIdentifierHandlingException;

import java.time.LocalDate;
import java.util.ArrayList;


public interface UserService extends Service<User> {
    User create(String fullName,
                LocalDate birthdate,
                String placeOfWork);
    User get(Long id) throws WrongIdentifierHandlingException;
    ArrayList<User> read();
    void printUserInfo(User user);


}
