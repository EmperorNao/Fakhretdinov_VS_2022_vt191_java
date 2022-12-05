package tech.reliab.course.course.fakhretdinov_vs.bank.service;

import tech.reliab.course.course.fakhretdinov_vs.bank.entity.Bank;
import tech.reliab.course.course.fakhretdinov_vs.bank.entity.CreditAccount;
import tech.reliab.course.course.fakhretdinov_vs.bank.entity.CreditRequest;
import tech.reliab.course.course.fakhretdinov_vs.bank.entity.User;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.core.Service;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.exceptions.CreditRatingException;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.exceptions.WrongIdentifierHandlingException;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.exceptions.WrongRequestException;

import java.util.ArrayList;


public interface BankService extends Service<Bank> {
    Bank create(String name);

    boolean isClient(Bank bank, User user);

    Bank get(Long id) throws WrongIdentifierHandlingException;

    ArrayList<Bank> read();

    void printBankInfo(Bank bank);

    CreditRequest createOptimalCreditRequest(long numberOfMoney, int numberOfMonths, int userCreditRating);
    CreditAccount getCredit(CreditRequest request) throws WrongRequestException, CreditRatingException, WrongIdentifierHandlingException;

}
