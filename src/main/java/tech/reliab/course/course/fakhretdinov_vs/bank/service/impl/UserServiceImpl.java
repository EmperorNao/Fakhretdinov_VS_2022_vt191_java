package tech.reliab.course.course.fakhretdinov_vs.bank.service.impl;

import tech.reliab.course.course.fakhretdinov_vs.bank.entity.Bank;
import tech.reliab.course.course.fakhretdinov_vs.bank.entity.BankAtm;
import tech.reliab.course.course.fakhretdinov_vs.bank.entity.PaymentAccount;
import tech.reliab.course.course.fakhretdinov_vs.bank.entity.User;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.BankService;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.UserService;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.core.ServiceContainer;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.core.ServiceManager;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.impl.core.ServiceContainerImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.function.Function;

public class UserServiceImpl implements UserService {

    private static Long currentMaxId = 0L;
    private static Random randomGenerator = new Random();
    private User user;
    ServiceContainer<User> container;
    ServiceManager manager;
    public UserServiceImpl() {
        container = new ServiceContainerImpl<User>();
    }
    @Override
    public User create(String fullName, Date birthdate, String placeOfWork, Bank bank) {

        Long salary = randomGenerator.nextLong(1000);
        user = new User(
                ++currentMaxId,
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

    public void setServiceManager(ServiceManager manager) {
        this.manager = manager;
    }

    @Override
    public ArrayList<User> read() {
        Function<User, Boolean> always_true = obj -> Boolean.TRUE;
        return container.grep(always_true);
    }

    @Override
    public void update(User obj) {
        container.update(obj);
    }

    @Override
    public void delete(User obj) {
        container.delete(obj);
    }


}
