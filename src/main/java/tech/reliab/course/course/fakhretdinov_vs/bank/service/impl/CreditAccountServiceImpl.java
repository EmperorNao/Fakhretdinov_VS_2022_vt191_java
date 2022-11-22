package tech.reliab.course.course.fakhretdinov_vs.bank.service.impl;

import tech.reliab.course.course.fakhretdinov_vs.bank.entity.*;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.CreditAccountService;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.core.ServiceContainer;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.core.ServiceManager;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.impl.core.ServiceContainerImpl;

import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.function.Function;

public class CreditAccountServiceImpl implements CreditAccountService {


    private static Long currentMaxId = 0L;
    private static Random randomGenerator = new Random();
    private CreditAccount creditAccount;
    ServiceContainer<CreditAccount> container;
    ServiceManager manager;

    public CreditAccountServiceImpl() {
        container = new ServiceContainerImpl<CreditAccount>();
    }

    public void setServiceManager(ServiceManager manager) {
        this.manager = manager;
    }

    @Override
    public CreditAccount create(User user,
                                Bank bank,
                                Date creditStart,
                                Date creditEnd,
                                Integer numberOfMonths,
                                Long amountOfMoney,
                                Long monthlyPayment,
                                Employee creditEmployee,
                                PaymentAccount paymentAccount) {

        creditAccount = new CreditAccount(
                ++currentMaxId,
                user,
                bank.getName(),
                creditStart,
                creditEnd,
                Period.between(
                        creditStart.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
                        creditEnd.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
                ).getMonths(),
                amountOfMoney,
                monthlyPayment,
                bank.getInterestRate(),
                creditEmployee,
                paymentAccount
        );

        // внести в юзера
        // внести в банк
        return creditAccount;

    }

    @Override
    public ArrayList<CreditAccount> read() {
        Function<CreditAccount, Boolean> always_true = obj -> Boolean.TRUE;
        return container.grep(always_true);
    }

    @Override
    public void update(CreditAccount obj) {
        container.update(obj);
    }

    @Override
    public void delete(CreditAccount obj) {
        container.delete(obj);
    }

    public ArrayList<CreditAccount> grep(Function<CreditAccount, Boolean> func) {
        return container.grep(func);
    }


}
