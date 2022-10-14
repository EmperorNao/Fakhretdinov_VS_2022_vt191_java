package tech.reliab.course.course.fakhretdinov_vs.bank.service;

import tech.reliab.course.course.fakhretdinov_vs.bank.entity.*;

import java.util.Date;

public interface CreditAccountService {
    CreditAccount create(User user,
                         Bank bank,
                         Date creditStart,
                         Date creditEnd,
                         Integer numberOfMonths,
                         Long amountOfMoney,
                         Long monthlyPayment,
                         Employee creditEmployee,
                         PaymentAccount paymentAccount);
    CreditAccount read();
    void update(CreditAccount creditAccount);
    void delete(CreditAccount creditAccount);
}
