package tech.reliab.course.course.fakhretdinov_vs.bank.service;

import tech.reliab.course.course.fakhretdinov_vs.bank.entity.User;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.core.Service;

import java.time.LocalDate;


public interface UserService extends Service<User> {
    User create(String fullName,
                LocalDate birthdate,
                String placeOfWork);

    User get(Long id);

}
