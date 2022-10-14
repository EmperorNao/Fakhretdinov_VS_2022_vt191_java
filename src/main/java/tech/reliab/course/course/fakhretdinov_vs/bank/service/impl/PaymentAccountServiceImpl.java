package tech.reliab.course.course.fakhretdinov_vs.bank.service.impl;

import tech.reliab.course.course.fakhretdinov_vs.bank.entity.Bank;
import tech.reliab.course.course.fakhretdinov_vs.bank.entity.BankOffice;
import tech.reliab.course.course.fakhretdinov_vs.bank.entity.PaymentAccount;
import tech.reliab.course.course.fakhretdinov_vs.bank.entity.User;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.BankService;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.PaymentAccountService;

import java.util.Random;

public class PaymentAccountServiceImpl implements PaymentAccountService {

    private static Long currentMaxId = 0L;
    private static Random randomGenerator = new Random();
    private PaymentAccount paymentAccount;

    /**
     *
     * @param user - пользователь счёта
     * @param bank - банк счёта
     * @return возвращает созданный объект счёта
     */
    @Override
    public PaymentAccount create(User user, Bank bank) {
        paymentAccount = new PaymentAccount(
                ++currentMaxId,
                user,
                bank.getName(),
                0L
        );

        return paymentAccount;
    }

    /**
     *
     * @return возвращает объект платёжного аккаунта
     */
    @Override
    public PaymentAccount read() {
        return paymentAccount;
    }

    /**
     *
     * @param paymentAccount - новый платёжный аккаунт
     */
    @Override
    public void update(PaymentAccount paymentAccount) {
        this.paymentAccount = paymentAccount;
    }

    /**
     *
     * @param paymentAccount - платёжный аккаунт для удаления
     */
    @Override
    public void delete(PaymentAccount paymentAccount) {
        if (this.paymentAccount == paymentAccount) {
            this.paymentAccount = null;
        }
    }

}
