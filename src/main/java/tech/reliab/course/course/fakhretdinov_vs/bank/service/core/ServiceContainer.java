package tech.reliab.course.course.fakhretdinov_vs.bank.service.core;

import tech.reliab.course.course.fakhretdinov_vs.bank.entity.core.Identifier;

import java.util.ArrayList;
import java.util.function.Function;


public interface ServiceContainer<T extends Identifier> {

    T get(Long id);
    void update(T model);
    void delete(T model);
    ArrayList<T> grep(Function<T, Boolean> func);

}