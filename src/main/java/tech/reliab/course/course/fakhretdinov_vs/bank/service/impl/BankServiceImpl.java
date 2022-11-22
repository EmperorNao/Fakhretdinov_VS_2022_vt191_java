package tech.reliab.course.course.fakhretdinov_vs.bank.service.impl;

import tech.reliab.course.course.fakhretdinov_vs.bank.entity.*;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.BankService;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.core.ServiceContainer;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.core.ServiceManager;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.impl.core.ServiceContainerImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.function.Function;

public class BankServiceImpl implements BankService {

    private static Long currentMaxId = 0L;
    private static Random randomGenerator = new Random();
    ServiceContainer<Bank> container;
    ServiceManager manager;

    public BankServiceImpl() {
        container = new ServiceContainerImpl<Bank>();
    }

    public void setServiceManager(ServiceManager manager) {
        this.manager = manager;
    }

    @Override
    public Bank create(String name) {

        Integer rating = randomGenerator.nextInt(100);
        Integer rate = 20 -  Math.toIntExact(Math.round(20 * (Math.min(1, rating) / 100.0)));
        Long money = randomGenerator.nextLong(1_000_000L);
        Bank bank = new Bank(
                ++currentMaxId,
                name,
                0,
                0,
                0,
                randomGenerator.nextInt(100),
                rating,
                money,
                rate
        );
        container.update(bank);

        return bank;

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
    public Boolean isClient(Bank bank, User user) {

        Function<PaymentAccount, Boolean> check_payment_acc = acc -> acc.getBankName().equals(bank.getName());
        Function<CreditAccount, Boolean> check_credit_acc = acc -> acc.getBankName().equals(bank.getName());

        ArrayList<PaymentAccount> payment_accounts = manager.paymentAccountService.grep(check_payment_acc);
        ArrayList<CreditAccount> credit_accounts = manager.creditAccountService.grep(check_credit_acc);

        HashSet<User> users = new HashSet<User>();

        for (PaymentAccount acc: payment_accounts) {
            if (acc.getUser().getId().equals(user.getId())) {
                return Boolean.TRUE;
            }
        }

        for (CreditAccount acc: credit_accounts) {
            if (acc.getUser().getId().equals(user.getId())) {
                return Boolean.TRUE;
            }
        }

        return Boolean.FALSE;

    }


}
