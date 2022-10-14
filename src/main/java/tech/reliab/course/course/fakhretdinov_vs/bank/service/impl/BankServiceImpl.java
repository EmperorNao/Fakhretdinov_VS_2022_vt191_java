package tech.reliab.course.course.fakhretdinov_vs.bank.service.impl;

import tech.reliab.course.course.fakhretdinov_vs.bank.entity.Bank;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.BankService;
import java.util.Random;

public class BankServiceImpl implements BankService {

    private static Long currentMaxId = 0L;
    private static Random randomGenerator = new Random();
    private Bank bank;


    /**
     *
     * @param name - имя банка
     * @return возвращает созданный объект банк
     */
    @Override
    public Bank create(String name) {

        Integer rating = randomGenerator.nextInt(100);
        Integer rate = 20 -  Math.toIntExact(Math.round(20 * (Math.min(1, rating) / 100.0)));
        Long money = randomGenerator.nextLong(1_000_000L);
        bank = new Bank(
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

    /**
     *
     * @return возвращает объект банка
     */
    @Override
    public Bank read() {
        return bank;
    }

    /**
     *
     * @param bank - новый банк
     */
    @Override
    public void update(Bank bank) {
        this.bank = bank;
    }

    /**
     *
     * @param bank - банк для удаления
     */
    @Override
    public void delete(Bank bank) {
        if (this.bank == bank) {
            this.bank = null;
        }
    }


}
