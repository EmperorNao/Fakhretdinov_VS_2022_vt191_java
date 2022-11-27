package tech.reliab.course.course.fakhretdinov_vs.bank.service.impl;

import tech.reliab.course.course.fakhretdinov_vs.bank.entity.*;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.UserService;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.core.ServiceContainer;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.core.ServiceManager;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.impl.core.ServiceContainerImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.function.Function;

public class UserServiceImpl implements UserService {

    private static Long currentMaxId = 0L;
    private static Random randomGenerator = new Random();
    ServiceContainer<User> container = new ServiceContainerImpl<>();
    ServiceManager manager;

    @Override
    public User create(String fullName,
                       LocalDate birthdate,
                       String placeOfWork) {

        long salary = randomGenerator.nextLong(1000);

        User user = new User(
                ++currentMaxId,
                fullName,
                birthdate,
                placeOfWork,
                salary,
                Math.toIntExact(salary / 10)
        );
        container.update(user);

        return user;
    }

    public void setServiceManager(ServiceManager manager) {
        this.manager = manager;
    }


    @Override
    public User get(Long id) {
        return container.get(id);
    }

    @Override
    public ArrayList<User> read() {
        Function<User, Boolean> always_true = obj -> Boolean.TRUE;
        return container.grep(always_true);
    }

    @Override
    public void update(User obj) {
        container.update(obj);
    }

    @Override
    public void delete(User obj) {
        container.delete(obj);
    }

    public ArrayList<User> grep(Function<User, Boolean> func) {
        return container.grep(func);
    }


}
