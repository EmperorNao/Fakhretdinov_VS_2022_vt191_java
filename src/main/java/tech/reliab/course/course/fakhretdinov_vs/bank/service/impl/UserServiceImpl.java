package tech.reliab.course.course.fakhretdinov_vs.bank.service.impl;

import tech.reliab.course.course.fakhretdinov_vs.bank.entity.*;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.UserService;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.core.ServiceContainer;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.core.ServiceManager;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.exceptions.WrongIdentifierHandlingException;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.impl.core.ServiceContainerImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.function.Function;

public class UserServiceImpl implements UserService {

    private Long currentMaxId = 0L;
    private static final Random randomGenerator = new Random();
    ServiceContainer<User> container = new ServiceContainerImpl<>();

    @Override
    public User create(String fullName,
                       LocalDate birthdate,
                       String placeOfWork) {

        long salary = randomGenerator.nextLong(1000);

        User user = new User(
                currentMaxId++,
                fullName,
                birthdate,
                placeOfWork,
                salary,
                Math.toIntExact(salary / 10)
        );
        container.update(user);

        return user;
    }

    @Override
    public User get(Long id) throws WrongIdentifierHandlingException {
        return container.get(id);
    }

    @Override
    public ArrayList<User> read() {
        Function<User, Boolean> trueCondition = obj -> Boolean.TRUE;
        return container.getByCondition(trueCondition);
    }

    @Override
    public void printUserInfo(User user) {

        Function<PaymentAccount, Boolean> checkPaymentAccount = paymentAccount -> paymentAccount.getUserId().equals(user.getId());
        ArrayList<PaymentAccount> paymentAccounts = ServiceManager.getPaymentAccountService().getByCondition(checkPaymentAccount);

        Function<CreditAccount, Boolean> checkCreditAccount = creditAccount -> creditAccount.getUserId().equals(user.getId());
        ArrayList<CreditAccount> creditAccounts = ServiceManager.getCreditAccountService().getByCondition(checkCreditAccount);

        System.out.println("User:");
        System.out.println(user);

        System.out.println();
        System.out.println("PaymentAccounts:");
        for (PaymentAccount paymentAccount: paymentAccounts) {
            System.out.println(paymentAccount);
        }

        System.out.println();
        System.out.println("CreditAccounts:");
        for (CreditAccount creditAccount: creditAccounts) {
            System.out.println(creditAccount);
        }

    }

    @Override
    public void update(User obj) {
        container.update(obj);
    }

    @Override
    public void delete(User obj) {
        container.delete(obj);
    }

    public ArrayList<User> getByCondition(Function<User, Boolean> condition) {
        return container.getByCondition(condition);
    }


}
