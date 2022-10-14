package tech.reliab.course.course.fakhretdinov_vs.bank.service.impl;

import tech.reliab.course.course.fakhretdinov_vs.bank.entity.Bank;
import tech.reliab.course.course.fakhretdinov_vs.bank.entity.BankAtm;
import tech.reliab.course.course.fakhretdinov_vs.bank.entity.BankOffice;
import tech.reliab.course.course.fakhretdinov_vs.bank.entity.BankOffice;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.BankOfficeService;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.BankService;

import java.util.Random;

public class BankOfficeServiceImpl implements BankOfficeService {

    private static Long currentMaxId = 0L;
    private static Random randomGenerator = new Random();
    private BankOffice bankOffice;

    /**
     *
     * @param name - имя офиса
     * @param bank - банк офиса
     * @param address - адресс офиса
     * @param rentPrice - стоимость аренды офиса
     * @return возвращает созданный объект офиса
     */
    @Override
    public BankOffice create(String name, Bank bank, String address, Long rentPrice) {

        bankOffice = new BankOffice(
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

    /**
     *
     * @return возвращает объект офис
     */
    @Override
    public BankOffice read() {
        return bankOffice;
    }

    /**
     *
     * @param bankOffice - новый офис
     */
    @Override
    public void update(BankOffice bankOffice) {
        this.bankOffice = bankOffice;
    }

    /**
     *
     * @param bankOffice - офис для удаления
     */
    @Override
    public void delete(BankOffice bankOffice) {
        if (this.bankOffice == bankOffice) {
            this.bankOffice = null;
        }
    }

}
