package tech.reliab.course.course.fakhretdinov_vs.bank.service.core;

import tech.reliab.course.course.fakhretdinov_vs.bank.entity.Bank;
import tech.reliab.course.course.fakhretdinov_vs.bank.entity.BankOffice;
import tech.reliab.course.course.fakhretdinov_vs.bank.entity.core.Identifier;

import java.util.ArrayList;
import java.util.function.Function;

public interface Service<T extends Identifier> {

    T get(Long id);
    ArrayList<T> read();
    void update(T obj);
    void delete(T obj);
    public ArrayList<T> grep(Function<T, Boolean> func);
    public void setServiceManager(ServiceManager manager);

}
