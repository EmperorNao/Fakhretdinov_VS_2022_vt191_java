package tech.reliab.course.course.fakhretdinov_vs.bank.service;

import tech.reliab.course.course.fakhretdinov_vs.bank.entity.Bank;
import tech.reliab.course.course.fakhretdinov_vs.bank.entity.BankAtm;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.core.Service;

import java.util.Random;

public interface BankService extends Service<Bank> {
    Bank create(String name);

}
