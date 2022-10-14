package tech.reliab.course.course.fakhretdinov_vs.bank.service.impl;

import tech.reliab.course.course.fakhretdinov_vs.bank.entity.*;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.CreditAccountService;

import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.Random;

public class CreditAccountServiceImpl implements CreditAccountService {


    private static Long currentMaxId = 0L;
    private static Random randomGenerator = new Random();
    private CreditAccount creditAccount;

    /**
     *
     * @param user - пользователь крединтого счета
     * @param bank - банк кредитного счёта
     * @param creditStart - дата старта кредита
     * @param creditEnd - дата окончания кредита
     * @param numberOfMonths - количество месяцев кредита
     * @param amountOfMoney - сумма кредита
     * @param monthlyPayment - оплата в месяц
     * @param creditEmployee - осблуживающий сотрудник
     * @param paymentAccount - платёжный счёт
     * @return возвращает созданный кредитный аккаунт
     */
    @Override
    public CreditAccount create(User user,
                                Bank bank,
                                Date creditStart,
                                Date creditEnd,
                                Integer numberOfMonths,
                                Long amountOfMoney,
                                Long monthlyPayment,
                                Employee creditEmployee,
                                PaymentAccount paymentAccount) {

        creditAccount = new CreditAccount(
                ++currentMaxId,
                user,
                bank.getName(),
                creditStart,
                creditEnd,
                Period.between(
                        creditStart.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
                        creditEnd.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
                ).getMonths(),
                amountOfMoney,
                monthlyPayment,
                bank.getInterestRate(),
                creditEmployee,
                paymentAccount
        );
        return creditAccount;

    }

    /**
     *
     * @return возвращает объект кредит аккаунта
     */
    @Override
    public CreditAccount read() {
        return creditAccount;
    }

    /**
     *
     * @param creditAccount - новый кредит аккаунта
     */
    @Override
    public void update(CreditAccount creditAccount) {
        this.creditAccount = creditAccount;
    }

    /**
     *
     * @param creditAccount - кредит аккаунта для удаления
     */
    @Override
    public void delete(CreditAccount creditAccount) {
        if (this.creditAccount == creditAccount) {
            this.creditAccount = null;
        }
    }

}
