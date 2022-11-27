package tech.reliab.course.course.fakhretdinov_vs.bank.service.impl;

import tech.reliab.course.course.fakhretdinov_vs.bank.entity.*;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.BankService;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.core.ServiceContainer;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.core.ServiceManager;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.impl.core.ServiceContainerImpl;

import java.util.ArrayList;
import java.util.Random;
import java.util.function.Function;

public class BankServiceImpl implements BankService {

    private static Long currentMaxId = 0L;
    private static final Random randomGenerator = new Random();
    ServiceContainer<Bank> container = new ServiceContainerImpl<>();
    ServiceManager manager;

    public void setServiceManager(ServiceManager manager) {
        this.manager = manager;
    }

    @Override
    public Bank create(String name) {

        int rating = randomGenerator.nextInt(100);
        int rate = 20 -  Math.toIntExact(Math.round(20 * (Math.min(1, rating) / 100.0)));
        Long money = randomGenerator.nextLong(1_000_000L);
        Bank bank = new Bank(
                ++currentMaxId,
                name,
                0,
                0,
                0,
                0,
                rating,
                money,
                rate
        );
        container.update(bank);

        return bank;

    }

    @Override
    public Bank get(Long id) {
        return container.get(id);
    }

    @Override
    public ArrayList<Bank> read() {
        Function<Bank, Boolean> always_true = obj -> Boolean.TRUE;
        return container.grep(always_true);
    }

    @Override
    public void update(Bank obj) {
        container.update(obj);
    }

    @Override
    public void delete(Bank obj) {
        container.delete(obj);
    }

    @Override
    public ArrayList<Bank> grep(Function<Bank, Boolean> func) {
        return container.grep(func);
    }

    @Override
    public boolean isClient(Bank bank, User user) {

        Function<PaymentAccount, Boolean> check_payment_acc = acc -> acc.getBankName().equals(bank.getName());
        Function<CreditAccount, Boolean> check_credit_acc = acc -> acc.getBankName().equals(bank.getName());

        ArrayList<PaymentAccount> payment_accounts = manager.paymentAccountService.grep(check_payment_acc);
        ArrayList<CreditAccount> credit_accounts = manager.creditAccountService.grep(check_credit_acc);

        for (PaymentAccount acc: payment_accounts) {
            if (acc.getUserId().equals(user.getId())) {
                return Boolean.TRUE;
            }
        }

        for (CreditAccount acc: credit_accounts) {
            if (acc.getUserId().equals(user.getId())) {
                return Boolean.TRUE;
            }
        }

        return Boolean.FALSE;

    }


}
