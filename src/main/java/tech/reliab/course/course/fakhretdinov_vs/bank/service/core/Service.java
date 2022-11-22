package tech.reliab.course.course.fakhretdinov_vs.bank.service.core;

import tech.reliab.course.course.fakhretdinov_vs.bank.entity.Bank;
import tech.reliab.course.course.fakhretdinov_vs.bank.entity.BankOffice;
import tech.reliab.course.course.fakhretdinov_vs.bank.entity.core.Identifier;

import java.util.ArrayList;

public interface Service<T extends Identifier> {

    ArrayList<T> read();
    void update(T obj);
    void delete(T obj);
    public void setServiceManager(ServiceManager manager);

}
