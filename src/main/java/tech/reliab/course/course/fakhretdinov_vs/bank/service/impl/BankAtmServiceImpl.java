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
import tech.reliab.course.course.fakhretdinov_vs.bank.service.core.ServiceManager;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.impl.core.ServiceContainerImpl;

import java.util.ArrayList;
import java.util.Random;
import java.util.function.Function;

public class BankAtmServiceImpl implements BankAtmService  {

    private static Long currentMaxId = 0L;
    private static Random randomGenerator = new Random();
    ServiceContainer<BankAtm> container;
    ServiceManager manager;

    public BankAtmServiceImpl() {
        container = new ServiceContainerImpl<BankAtm>();
    }

    public void setServiceManager(ServiceManager manager) {
        this.manager = manager;
    }

    @Override
    public BankAtm create(String name, Bank bank, BankOffice office, Employee employee) {

        if (!office.getAtmCanBePlaced()) {
            return null;
            //TODO throw exception
        }

        BankAtm bankAtm = new BankAtm(
                ++currentMaxId,
                bank.getId(),
                name,
                office.getAddress(),
                BankAtmStatus.getRandomStatus(randomGenerator.nextInt(3)),
                employee.getId(),
                randomGenerator.nextBoolean(),
                randomGenerator.nextBoolean(),
                bank.getAmountOfMoney(),
                randomGenerator.nextInt(6666)
        );
        container.update(bankAtm);

        bank.setNumberOfAtms(bank.getNumberOfAtms() + 1);
        manager.bankService.update(bank);

        office.setNumberOfAtms(office.getNumberOfAtms() + 1);
        manager.bankOfficeService.update(office);

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

    @Override
    public ArrayList<BankAtm> grep(Function<BankAtm, Boolean> func) {
        return container.grep(func);
    }

}
