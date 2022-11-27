package tech.reliab.course.course.fakhretdinov_vs.bank.service.impl;

import tech.reliab.course.course.fakhretdinov_vs.bank.entity.Bank;
import tech.reliab.course.course.fakhretdinov_vs.bank.entity.BankOffice;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.BankOfficeService;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.core.ServiceContainer;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.core.ServiceManager;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.impl.core.ServiceContainerImpl;

import java.util.ArrayList;
import java.util.Random;
import java.util.function.Function;

public class BankOfficeServiceImpl implements BankOfficeService {

    private static Long currentMaxId = 0L;
    private static final Random randomGenerator = new Random();
    ServiceContainer<BankOffice> container = new ServiceContainerImpl<>();
    ServiceManager manager;

    public void setServiceManager(ServiceManager manager) {
        this.manager = manager;
    }

    @Override
    public BankOffice create(String name, Bank bank, String address, Long rentPrice) {

        BankOffice bankOffice = new BankOffice(
                ++currentMaxId,
                bank.getId(),
                name,
                address,
                randomGenerator.nextBoolean(),
                randomGenerator.nextBoolean(),
                0,
                randomGenerator.nextBoolean(),
                randomGenerator.nextBoolean(),
                randomGenerator.nextBoolean(),
                bank.getAmountOfMoney(),
                rentPrice
        );
        container.update(bankOffice);

        bank.setNumberOfOffices(bank.getNumberOfOffices() + 1);
        manager.bankService.update(bank);

        return bankOffice;

    }

    @Override
    public BankOffice get(Long id) {
        return container.get(id);
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

        Bank bank = manager.bankService.get(obj.getBankId());
        bank.setNumberOfOffices(bank.getNumberOfOffices() - 1);
        manager.bankService.update(bank);

        container.delete(obj);

    }

    @Override
    public ArrayList<BankOffice> grep(Function<BankOffice, Boolean> func) {
        return container.grep(func);
    }


}
