package tech.reliab.course.course.fakhretdinov_vs.bank.service;

import tech.reliab.course.course.fakhretdinov_vs.bank.entity.*;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.core.Service;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.exceptions.WrongIdentifierHandlingException;

import java.time.LocalDate;
import java.util.ArrayList;

public interface CreditAccountService extends Service<CreditAccount> {
    CreditAccount create(User user,
                         Bank bank,
                         LocalDate creditStart,
                         LocalDate creditEnd,
                         long numberOfMoney,
                         Employee creditEmployee,
                         PaymentAccount paymentAccount);
    CreditAccount get(Long id) throws WrongIdentifierHandlingException;
    ArrayList<CreditAccount> read();

}
