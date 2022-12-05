package tech.reliab.course.course.fakhretdinov_vs.bank.labui;

import tech.reliab.course.course.fakhretdinov_vs.bank.entity.*;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.core.ServiceManager;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.impl.*;

import java.util.ArrayList;
import java.util.Scanner;

public class ActionInteractor {


    public void start() {

        Scanner input = new Scanner(System.in);

        String outputString = "Введите номер лабораторной работы для запуска [1 - 2], 0 для завершения";
        outputString = String.format(outputString);

        int labIndex = -1;
        while (labIndex != 0) {
            System.out.println(outputString);
            labIndex = input.nextInt();

            switch (labIndex) {
                case 0:
                    break;
                case 1:
                    this.lab1();
                    break;
                case 2:
                    this.lab2();
                    break;
                default:
                    System.out.println("Введён неверный номер");
            }
            System.out.println();
        }


    }

    public void labPreparation() {

        ServiceManager.initialize(
                new BankServiceImpl(),
                new BankAtmServiceImpl(),
                new BankOfficeServiceImpl(),
                new EmployeeServiceImpl(),
                new UserServiceImpl(),
                new CreditAccountServiceImpl(),
                new PaymentAccountServiceImpl()
        );

    }

    public void lab1() {

        labPreparation();
        ObjectsCreator.createObjects(1, 1, 1, 1, 1, 1, 1);

        Bank bank = ServiceManager.getBankService().get(0L);
        BankOffice bankOffice = ServiceManager.getBankOfficeService().get(0L);
        Employee employee = ServiceManager.getEmployeeService().get(0L);
        BankAtm atm = ServiceManager.getBankAtmService().get(0L);
        User user = ServiceManager.getUserService().get(0L);
        PaymentAccount paymentAccount = ServiceManager.getPaymentAccountService().get(0L);
        CreditAccount creditAccount = ServiceManager.getCreditAccountService().get(0L);

        System.out.println("Bank: " + bank);
        System.out.println("Office: " + bankOffice);
        System.out.println("Employee: " + employee);
        System.out.println("Atm: " + atm);
        System.out.println("User: " + user);
        System.out.println("CreditAccount: " + creditAccount);
        System.out.println("PaymentAccount: " + paymentAccount);

    }

    public void lab2() {

        labPreparation();
        ObjectsCreator.createObjects(5, 3, 1, 5, 5, 2, 2);

        Scanner input = new Scanner(System.in);

        int actionIndex = -1;
        while (actionIndex != 0) {
            System.out.println(
                    """
                            Выберите одно из действий:
                            1 - Посмотреть список банков
                            2 - Посмотреть список всех клиентов
                            3 - Вывести информацию о банке по id
                            4 - Вывести информацию о клиенте по id
                            0 - Выйти
                            """
            );
            actionIndex = input.nextInt();

            long objectId;
            switch (actionIndex) {

                case 0:
                    break;

                case 1:
                    System.out.println("Список банков: ");

                    ArrayList<Bank> banks = ServiceManager.getBankService().read();
                    for (Bank bank: banks) {
                        System.out.println(bank);
                    }
                    break;

                case 2:
                    System.out.println("Список клиентов: ");

                    ArrayList<User> users = ServiceManager.getUserService().read();
                    for (User user: users) {
                        System.out.println(user);
                    }
                    break;

                case 3:
                    System.out.println("Введите id банка для просмотра");
                    objectId = input.nextLong();
                    System.out.println("Информация о банке: ");
                    ServiceManager.getBankService().printBankInfo(ServiceManager.getBankService().get(objectId));
                    break;

                case 4:
                    System.out.println("Введите id клиента для просмотра");
                    objectId = input.nextLong();
                    System.out.println("Информация о клиенте");
                    ServiceManager.getUserService().printUserInfo(ServiceManager.getUserService().get(objectId));
                    break;

                default:
                    System.out.println("Введён неверный номер");
            }

            System.out.println();
        }


    }

}
