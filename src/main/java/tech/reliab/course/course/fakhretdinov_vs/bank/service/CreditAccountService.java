package tech.reliab.course.course.fakhretdinov_vs.bank.service;

import tech.reliab.course.course.fakhretdinov_vs.bank.entity.*;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.core.Service;

import java.util.Date;

public interface CreditAccountService extends Service<CreditAccount> {
    CreditAccount create(User user,
                         Bank bank,
                         Date creditStart,
                         Date creditEnd,
                         Integer numberOfMonths,
                         Long amountOfMoney,
                         Long monthlyPayment,
                         Employee creditEmployee,
                         PaymentAccount paymentAccount);
}
