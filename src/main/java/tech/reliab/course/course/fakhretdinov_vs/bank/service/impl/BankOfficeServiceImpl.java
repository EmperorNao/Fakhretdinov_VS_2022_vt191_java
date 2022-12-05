package tech.reliab.course.course.fakhretdinov_vs.bank.service.impl;

import tech.reliab.course.course.fakhretdinov_vs.bank.entity.Bank;
import tech.reliab.course.course.fakhretdinov_vs.bank.entity.BankOffice;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.BankOfficeService;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.core.ServiceContainer;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.core.ServiceManager;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.exceptions.WrongIdentifierHandlingException;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.impl.core.ServiceContainerImpl;

import java.util.ArrayList;
import java.util.Random;
import java.util.function.Function;

public class BankOfficeServiceImpl implements BankOfficeService {

    private Long currentMaxId = 0L;
    private static final Random randomGenerator = new Random();
    ServiceContainer<BankOffice> container = new ServiceContainerImpl<>();

    @Override
    public BankOffice create(String name, Bank bank, String address, long rentPrice) {

        BankOffice bankOffice = new BankOffice(
                currentMaxId++,
                bank.getId(),
                name,
                address,
                randomGenerator.nextBoolean(),
                randomGenerator.nextBoolean(),
                0,
                randomGenerator.nextBoolean(),
                randomGenerator.nextBoolean(),
                randomGenerator.nextBoolean(),
                bank.getNumberOfMoney(),
                rentPrice
        );
        container.update(bankOffice);

        bank.setNumberOfOffices(bank.getNumberOfOffices() + 1);
        ServiceManager.getBankService().update(bank);

        return bankOffice;

    }

    @Override
    public BankOffice get(Long id) throws WrongIdentifierHandlingException {
        return container.get(id);
    }

    @Override
    public ArrayList<BankOffice> read() {
        Function<BankOffice, Boolean> trueCondition = obj -> Boolean.TRUE;
        return container.getByCondition(trueCondition);
    }

    @Override
    public void update(BankOffice obj) {
        container.update(obj);
    }

    @Override
    public void delete(BankOffice obj) throws WrongIdentifierHandlingException {

        Bank bank = ServiceManager.getBankService().get(obj.getBankId());
        bank.setNumberOfOffices(bank.getNumberOfOffices() - 1);
        ServiceManager.getBankService().update(bank);

        container.delete(obj);

    }

    @Override
    public ArrayList<BankOffice> getByCondition(Function<BankOffice, Boolean> condition) {
        return container.getByCondition(condition);
    }


}
