package tech.reliab.course.course.fakhretdinov_vs.bank.service.core;

import tech.reliab.course.course.fakhretdinov_vs.bank.entity.core.Identifier;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.exceptions.WrongIdentifierHandlingException;

import java.util.ArrayList;
import java.util.function.Function;


public interface ServiceContainer<T extends Identifier> {

    T get(Long id) throws WrongIdentifierHandlingException;
    void update(T model);
    void delete(T model);
    ArrayList<T> getByCondition(Function<T, Boolean> condition);

}