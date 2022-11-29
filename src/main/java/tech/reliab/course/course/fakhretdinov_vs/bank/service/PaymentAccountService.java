package tech.reliab.course.course.fakhretdinov_vs.bank.service;

import tech.reliab.course.course.fakhretdinov_vs.bank.entity.*;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.core.Service;

import java.util.ArrayList;

public interface PaymentAccountService extends Service<PaymentAccount> {
    PaymentAccount create(User user, Bank bank);
    PaymentAccount get(Long id);
    ArrayList<PaymentAccount> read();

}
