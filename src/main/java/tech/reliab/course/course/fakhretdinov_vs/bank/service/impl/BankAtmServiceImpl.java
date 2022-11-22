package tech.reliab.course.course.fakhretdinov_vs.bank.service.impl;

import tech.reliab.course.course.fakhretdinov_vs.bank.entity.Bank;
import tech.reliab.course.course.fakhretdinov_vs.bank.entity.BankAtm;
import tech.reliab.course.course.fakhretdinov_vs.bank.entity.BankOffice;
import tech.reliab.course.course.fakhretdinov_vs.bank.entity.Employee;
import tech.reliab.course.course.fakhretdinov_vs.bank.entity.core.Identifier;
import tech.reliab.course.course.fakhretdinov_vs.bank.entity.enums.BankAtmStatus;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.BankAtmService;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.BankService;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.core.ServiceContainer;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.impl.core.ServiceContainerImpl;

import java.util.ArrayList;
import java.util.Random;
import java.util.function.Function;

public class BankAtmServiceImpl implements BankAtmService  {

    private static Long currentMaxId = 0L;
    private static Random randomGenerator = new Random();
    ServiceContainer<BankAtm> container;

    public BankAtmServiceImpl() {
        container = new ServiceContainerImpl<BankAtm>();
    }

    @Override
    public BankAtm create(String name, Bank bank, BankOffice office, Employee employee) {

        BankAtm bankAtm = new BankAtm(
                ++currentMaxId,
                bank,
                name,
                office.getAddress(),
                BankAtmStatus.getRandomStatus(randomGenerator.nextInt(3)),
                employee,
                randomGenerator.nextBoolean(),
                randomGenerator.nextBoolean(),
                bank.getAmountOfMoney(),
                randomGenerator.nextInt(6666)
        );
        container.update(bankAtm);
        return bankAtm;

    }

    @Override
    public ArrayList<BankAtm> read() {
        Function<BankAtm, Boolean> always_true = obj -> Boolean.TRUE;
        return container.grep(always_true);
    }

    @Override
    public void update(BankAtm obj) {
        container.update(obj);
    }

    @Override
    public void delete(BankAtm obj) {
        container.delete(obj);
    }

}
