package tech.reliab.course.course.fakhretdinov_vs.bank.service;

import tech.reliab.course.course.fakhretdinov_vs.bank.entity.*;

import java.util.Date;

public interface PaymentAccountService {
    PaymentAccount create(User user,
                         Bank bank);
    PaymentAccount read();
    void update(PaymentAccount paymentAccount);
    void delete(PaymentAccount paymentAccount);
}
