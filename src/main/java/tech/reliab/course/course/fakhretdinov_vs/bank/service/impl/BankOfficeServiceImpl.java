package tech.reliab.course.course.fakhretdinov_vs.bank.service.impl;

import tech.reliab.course.course.fakhretdinov_vs.bank.entity.Bank;
import tech.reliab.course.course.fakhretdinov_vs.bank.entity.BankAtm;
import tech.reliab.course.course.fakhretdinov_vs.bank.entity.BankOffice;
import tech.reliab.course.course.fakhretdinov_vs.bank.entity.BankOffice;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.BankOfficeService;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.BankService;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.core.ServiceContainer;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.impl.core.ServiceContainerImpl;

import java.util.ArrayList;
import java.util.Random;
import java.util.function.Function;

public class BankOfficeServiceImpl implements BankOfficeService {

    private static Long currentMaxId = 0L;
    private static Random randomGenerator = new Random();
    ServiceContainer<BankOffice> container;
    public BankOfficeServiceImpl() {
        container = new ServiceContainerImpl<BankOffice>();
    }


    @Override
    public BankOffice create(String name, Bank bank, String address, Long rentPrice) {

        BankOffice bankOffice = new BankOffice(
                ++currentMaxId,
                bank,
                name,
                address,
                randomGenerator.nextBoolean(),
                randomGenerator.nextBoolean(),
                bank.getNumberOfAtms(),
                randomGenerator.nextBoolean(),
                randomGenerator.nextBoolean(),
                randomGenerator.nextBoolean(),
                bank.getAmountOfMoney(),
                rentPrice
        );
        return bankOffice;

    }

    @Override
    public ArrayList<BankOffice> read() {
        Function<BankOffice, Boolean> always_true = obj -> Boolean.TRUE;
        return container.grep(always_true);
    }

    @Override
    public void update(BankOffice obj) {
        container.update(obj);
    }

    @Override
    public void delete(BankOffice obj) {
        container.delete(obj);
    }



}
