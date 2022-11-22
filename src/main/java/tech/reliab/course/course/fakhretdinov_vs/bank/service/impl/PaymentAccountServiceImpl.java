package tech.reliab.course.course.fakhretdinov_vs.bank.service.impl;

import tech.reliab.course.course.fakhretdinov_vs.bank.entity.*;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.BankService;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.PaymentAccountService;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.core.ServiceContainer;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.impl.core.ServiceContainerImpl;

import java.util.ArrayList;
import java.util.Random;
import java.util.function.Function;

public class PaymentAccountServiceImpl implements PaymentAccountService {

    private static Long currentMaxId = 0L;
    private static Random randomGenerator = new Random();
    private PaymentAccount paymentAccount;
    ServiceContainer<PaymentAccount> container;
    public PaymentAccountServiceImpl() {
        container = new ServiceContainerImpl<PaymentAccount>();
    }

    @Override
    public PaymentAccount create(User user, Bank bank) {
        paymentAccount = new PaymentAccount(
                ++currentMaxId,
                user,
                bank.getName(),
                0L
        );

        return paymentAccount;
    }

    @Override
    public ArrayList<PaymentAccount> read() {
        Function<PaymentAccount, Boolean> always_true = obj -> Boolean.TRUE;
        return container.grep(always_true);
    }

    @Override
    public void update(PaymentAccount obj) {
        container.update(obj);
    }

    @Override
    public void delete(PaymentAccount obj) {
        container.delete(obj);
    }


}
