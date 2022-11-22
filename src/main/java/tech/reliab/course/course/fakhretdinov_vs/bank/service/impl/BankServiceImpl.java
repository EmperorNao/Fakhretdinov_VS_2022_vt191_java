package tech.reliab.course.course.fakhretdinov_vs.bank.service.impl;

import tech.reliab.course.course.fakhretdinov_vs.bank.entity.Bank;
import tech.reliab.course.course.fakhretdinov_vs.bank.entity.BankAtm;
import tech.reliab.course.course.fakhretdinov_vs.bank.entity.BankOffice;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.BankService;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.core.ServiceContainer;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.core.ServiceManager;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.impl.core.ServiceContainerImpl;

import java.util.ArrayList;
import java.util.Random;
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


}
