package tech.reliab.course.course.fakhretdinov_vs.bank.service.impl;

import tech.reliab.course.course.fakhretdinov_vs.bank.entity.*;
import tech.reliab.course.course.fakhretdinov_vs.bank.entity.enums.BankAtmStatus;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.BankAtmService;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.core.ServiceContainer;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.core.ServiceManager;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.impl.core.ServiceContainerImpl;

import java.util.ArrayList;
import java.util.Random;
import java.util.function.Function;

public class BankAtmServiceImpl implements BankAtmService  {

    private static Long currentMaxId = 0L;
    private static final Random randomGenerator = new Random();
    ServiceContainer<BankAtm> container = new ServiceContainerImpl<>();
    ServiceManager manager;

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
    public BankAtm get(Long id) {
        return container.get(id);
    }

    @Override
    public ArrayList<BankAtm> read() {
        Function<BankAtm, Boolean> always_true = obj -> Boolean.TRUE;
        return container.getByCondition(always_true);
    }

    @Override
    public void update(BankAtm obj) {
        container.update(obj);
    }

    @Override
    public void delete(BankAtm obj) {

        Bank bank = manager.bankService.get(obj.getBankId());
        bank.setNumberOfAtms(bank.getNumberOfAtms() - 1);
        manager.bankService.update(bank);

        Function<BankOffice, Boolean> find_office = office -> office.getAddress().equals(obj.getAddress());
        BankOffice office = manager.bankOfficeService.getByCondition(find_office).get(0);
        office.setNumberOfAtms(office.getNumberOfAtms() - 1);
        manager.bankOfficeService.update(office);

        container.delete(obj);

    }

    @Override
    public ArrayList<BankAtm> getByCondition(Function<BankAtm, Boolean> condition) {
        return container.getByCondition(condition);
    }

}
