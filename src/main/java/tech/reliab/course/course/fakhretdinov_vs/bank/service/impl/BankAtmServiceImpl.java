package tech.reliab.course.course.fakhretdinov_vs.bank.service.impl;

import tech.reliab.course.course.fakhretdinov_vs.bank.entity.Bank;
import tech.reliab.course.course.fakhretdinov_vs.bank.entity.BankAtm;
import tech.reliab.course.course.fakhretdinov_vs.bank.entity.BankOffice;
import tech.reliab.course.course.fakhretdinov_vs.bank.entity.Employee;
import tech.reliab.course.course.fakhretdinov_vs.bank.entity.enums.BankAtmStatus;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.BankAtmService;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.BankService;

import java.util.Random;

public class BankAtmServiceImpl implements BankAtmService {

    private static Long currentMaxId = 0L;
    private static Random randomGenerator = new Random();
    private BankAtm bankAtm;

    /**
     *
     * @param name - имя банкомата
     * @param bank - банк, которому принадлежит банкомат
     * @param office - офис, в котором находится банкомат
     * @param employee - обслуживающий сотруднике
     * @return возвращает созданный объект банкомата
     */
    @Override
    public BankAtm create(String name, Bank bank, BankOffice office, Employee employee) {

        bankAtm = new BankAtm(
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
        return bankAtm;

    }

    /**
     *
     * @return возвращает объект банкомат
     */
    @Override
    public BankAtm read() {
        return bankAtm;
    }

    /**
     *
     * @param bankAtm - новый банкомат
     */
    @Override
    public void update(BankAtm bankAtm) {
        this.bankAtm = bankAtm;
    }

    /**
     *
     * @param bankAtm - банкомат для удаления
     */
    @Override
    public void delete(BankAtm bankAtm) {
        if (this.bankAtm == bankAtm) {
            this.bankAtm = null;
        }
    }

}
