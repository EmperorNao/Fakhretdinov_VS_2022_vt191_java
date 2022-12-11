package tech.reliab.course.course.fakhretdinov_vs.bank.service;

import tech.reliab.course.course.fakhretdinov_vs.bank.entity.*;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.core.Service;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.exceptions.WrongIdentifierHandlingException;

import java.io.IOException;
import java.util.ArrayList;

public interface PaymentAccountService extends Service<PaymentAccount> {
    PaymentAccount create(User user, Bank bank);
    PaymentAccount get(Long id) throws WrongIdentifierHandlingException;
    ArrayList<PaymentAccount> read();

    void writeToFile(ArrayList<PaymentAccount> paymentAccountIds, String fileName) throws WrongIdentifierHandlingException, IOException;
    ArrayList<PaymentAccount> readFromFile(String fileName) throws IOException, ClassNotFoundException;

}
