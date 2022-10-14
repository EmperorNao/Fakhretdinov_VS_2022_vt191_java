package tech.reliab.course.course.fakhretdinov_vs.bank.service.impl;

import tech.reliab.course.course.fakhretdinov_vs.bank.entity.Bank;
import tech.reliab.course.course.fakhretdinov_vs.bank.entity.PaymentAccount;
import tech.reliab.course.course.fakhretdinov_vs.bank.entity.User;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.BankService;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.UserService;

import java.util.Date;
import java.util.Random;

public class UserServiceImpl implements UserService {

    private static Long currentMaxId = 0L;
    private static Random randomGenerator = new Random();
    private User user;

    /**
     *
     * @param fullName - ФИО пользователя
     * @param birthdate - дата рождения пользователя
     * @param placeOfWork - место работы пользователя
     * @param bank - банк пользователя
     * @return возвращает созданный объект пользователя
     */
    @Override
    public User create(String fullName, Date birthdate, String placeOfWork, Bank bank) {

        Long salary = randomGenerator.nextLong(1000);
        user = new User(
                fullName,
                birthdate,
                placeOfWork,
                salary,
                bank,
                null,
                null,
                Math.toIntExact(salary / 10)
        );
        return user;
    }

    /**
     *
     * @return возвращает объект пользователя
     */
    @Override
    public User read() {
        return user;
    }

    /**
     *
     * @param user - новый пользователь
     */
    @Override
    public void update(User user) {
        this.user = user;
    }

    /**
     *
     * @param user - пользователь для удаления
     */
    @Override
    public void delete(User user) {
        if (this.user == user) {
            this.user = null;
        }
    }

}
