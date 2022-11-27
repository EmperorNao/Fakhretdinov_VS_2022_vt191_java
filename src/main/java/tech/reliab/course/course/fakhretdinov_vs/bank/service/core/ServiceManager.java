package tech.reliab.course.course.fakhretdinov_vs.bank.service.core;

import tech.reliab.course.course.fakhretdinov_vs.bank.service.*;

public class ServiceManager {

    private static final ServiceManager instance = new ServiceManager( );

    private BankService bankService;
    private BankAtmService bankAtmService;
    private BankOfficeService bankOfficeService;
    private EmployeeService employeeService;
    private UserService userService;
    private CreditAccountService creditAccountService;
    private PaymentAccountService paymentAccountService;

    private ServiceManager() {}

    public static void initialize(BankService bankService,
                          BankAtmService bankAtmService,
                          BankOfficeService bankOfficeService,
                          EmployeeService employeeService,
                          UserService userService,
                          CreditAccountService creditAccountService,
                          PaymentAccountService paymentAccountService) {

        instance.bankService = bankService;
        instance.bankAtmService = bankAtmService;
        instance.bankOfficeService = bankOfficeService;
        instance.employeeService = employeeService;
        instance.userService = userService;
        instance.creditAccountService = creditAccountService;
        instance.paymentAccountService = paymentAccountService;

    }

    public static BankService getBankService() { return instance.bankService; }
    public static BankAtmService getBankAtmService() { return instance.bankAtmService; }
    public static BankOfficeService getBankOfficeService() { return instance.bankOfficeService; }
    public static EmployeeService getEmployeeService() { return instance.employeeService; }
    public static UserService getUserService() { return instance.userService; }
    public static CreditAccountService getCreditAccountService() { return instance.creditAccountService; }
    public static PaymentAccountService getPaymentAccountService() { return instance.paymentAccountService; }



}
