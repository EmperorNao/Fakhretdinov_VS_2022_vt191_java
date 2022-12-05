package tech.reliab.course.course.fakhretdinov_vs.bank.service;

import tech.reliab.course.course.fakhretdinov_vs.bank.entity.*;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.core.Service;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.exceptions.WrongIdentifierHandlingException;

import java.util.ArrayList;

public interface BankOfficeService extends Service<BankOffice> {
    BankOffice create(String name, Bank bank, String address, long rentPrice);
    BankOffice get(Long id) throws WrongIdentifierHandlingException;
    ArrayList<BankOffice> read();

}
