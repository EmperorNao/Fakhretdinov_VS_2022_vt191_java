package tech.reliab.course.course.fakhretdinov_vs.bank.service.impl;

import tech.reliab.course.course.fakhretdinov_vs.bank.entity.*;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.BankService;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.PaymentAccountService;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.core.ServiceContainer;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.core.ServiceManager;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.impl.core.ServiceContainerImpl;

import java.util.ArrayList;
import java.util.Random;
import java.util.function.Function;

public class PaymentAccountServiceImpl implements PaymentAccountService {

    private static Long currentMaxId = 0L;
    private static Random randomGenerator = new Random();
    private PaymentAccount paymentAccount;
    ServiceContainer<PaymentAccount> container;
    ServiceManager manager;

    public PaymentAccountServiceImpl() {
        container = new ServiceContainerImpl<PaymentAccount>();
    }

    public void setServiceManager(ServiceManager manager) {
        this.manager = manager;
    }

    @Override
    public PaymentAccount create(User user, Bank bank) {
        paymentAccount = new PaymentAccount(
                ++currentMaxId,
                user,
                bank.getName(),
                0L
        );
        container.update(paymentAccount);

        if (manager.bankService.isClient(bank, user)) {
            bank.setNumberOfClients(bank.getNumberOfClients());
            manager.bankService.update(bank);
        }

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

    public ArrayList<PaymentAccount> grep(Function<PaymentAccount, Boolean> func) {
        return container.grep(func);
    }


}
