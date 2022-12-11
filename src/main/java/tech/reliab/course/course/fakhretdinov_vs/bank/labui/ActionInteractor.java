package tech.reliab.course.course.fakhretdinov_vs.bank.labui;

import tech.reliab.course.course.fakhretdinov_vs.bank.entity.*;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.core.ServiceManager;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.exceptions.CreditRatingException;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.exceptions.WrongIdentifierHandlingException;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.exceptions.WrongRequestException;
import tech.reliab.course.course.fakhretdinov_vs.bank.service.impl.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Function;

public class ActionInteractor {


    public void start() {

        Scanner input = new Scanner(System.in);

        String outputString = "Введите номер лабораторной работы для запуска [1 - 4], 0 для завершения";
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
                case 3:
                    this.lab3();
                    break;
                case 4:
                    this.lab4();
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

        try {
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
        catch (WrongIdentifierHandlingException e) {
            System.out.println("Не удалось создать объекты: " + e);
        }

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
                    try {
                        System.out.println("Информация о банке: ");
                        ServiceManager.getBankService().printBankInfo(ServiceManager.getBankService().get(objectId));
                    }
                    catch (WrongIdentifierHandlingException e) {
                        System.out.println("Не удалось посмотреть информацию, введите корректный объект: " + e);
                    }
                    break;

                case 4:
                    System.out.println("Введите id клиента для просмотра");
                    objectId = input.nextLong();
                    try {
                        System.out.println("Информация о клиенте");
                        ServiceManager.getUserService().printUserInfo(ServiceManager.getUserService().get(objectId));
                    }
                    catch (WrongIdentifierHandlingException e) {
                        System.out.println("Не удалось посмотреть информацию, введите корректный объект: " + e);
                    }
                    break;

                default:
                    System.out.println("Введён неверный номер");
            }

            System.out.println();
        }

    }

    public void lab3() {

        labPreparation();
        ObjectsCreator.createObjects(10, 5, 5, 5, 5, 2, 2);

        Scanner input = new Scanner(System.in);

        Long bankId;
        Long officeId;
        Long employeeId;
        Long atmId;
        int amountOfMoney;
        int numberOfMonths;
        Long userId;

        int actionIndex = -1;
        while (actionIndex != 0) {
            System.out.println(
                    """
                            Выберите одно из действий:
                            1 - Посмотреть список банков
                            2 - Посмотреть список всех клиентов
                            3 - Вывести информацию о банке по id
                            4 - Вывести информацию о клиенте по id
                            5 - Подобрать наилучший кредитный запрос для заданных условий
                            6 - Запросить кредит
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
                    try {
                        System.out.println("Информация о банке: ");
                        ServiceManager.getBankService().printBankInfo(ServiceManager.getBankService().get(objectId));
                    }
                    catch (WrongIdentifierHandlingException e) {
                        System.out.println("Не удалось посмотреть информацию, введите корректный объект: " + e);
                    }
                    break;

                case 4:
                    System.out.println("Введите id клиента для просмотра");
                    objectId = input.nextLong();
                    try {
                        System.out.println("Информация о клиенте");
                        ServiceManager.getUserService().printUserInfo(ServiceManager.getUserService().get(objectId));
                    }
                    catch (WrongIdentifierHandlingException e) {
                        System.out.println("Не удалось посмотреть информацию, введите корректный объект: " + e);
                    }
                    break;

                case 5:
                    System.out.println("Введите количество денег для кредита");
                    amountOfMoney = input.nextInt();

                    System.out.println("Введите количество месяцев для оплаты кредита");
                    numberOfMonths = input.nextInt();

                    System.out.println("Введите id клиента");
                    userId = input.nextLong();

                    try {

                        CreditRequest request = ServiceManager.getBankService().createOptimalCreditRequest(amountOfMoney,
                                numberOfMonths,
                                ServiceManager.getUserService().get(userId).getCreditRating()
                        );
                        if (request == null) {
                            System.out.println("Для данных условий не было найдено ни одного возможного запроса");
                        }
                        else {
                            System.out.println("Лучший запрос для вас:");
                            System.out.println(request);
                        }

                    }
                    catch (WrongIdentifierHandlingException e) {
                        System.out.println("Не удалось посмотреть информацию, введите корректный объект: " + e);
                    }
                    break;

                case 6:
                    System.out.println("Введите id банка");
                    bankId = input.nextLong();

                    System.out.println("Введите id офиса");
                    officeId = input.nextLong();

                    System.out.println("Введите id сотрудника");
                    employeeId = input.nextLong();

                    System.out.println("Введите id банкомата (опционально, -1 для отказа)");
                    atmId = input.nextLong();
                    if (atmId == -1) {
                        atmId = null;
                    }

                    System.out.println("Введите id клиента");
                    userId = input.nextLong();

                    System.out.println("Введите количество денег для кредита");
                    amountOfMoney = input.nextInt();

                    System.out.println("Введите количество месяцев для оплаты кредита");
                    numberOfMonths = input.nextInt();

                    try {

                        CreditRequest request = new CreditRequest(
                                bankId,
                                officeId,
                                atmId,
                                employeeId,
                                userId,
                                amountOfMoney,
                                numberOfMonths,
                                ServiceManager.getUserService().get(userId).getCreditRating()
                        );

                        try {
                            CreditAccount creditAccount = ServiceManager.getBankService().getCredit(request);
                            System.out.println("Вам успешно был выдан кредит, ваш кредитный счёт: " + creditAccount);
                        }
                        catch (CreditRatingException e) {
                            System.out.println(e);
                        } catch (WrongRequestException e) {
                            System.out.println("Попытка взять кредит закончилась ошибкой, попробуйте повторить ещё раз: " + e);
                        }

                    }
                    catch (WrongIdentifierHandlingException e) {
                        System.out.println("Не удалось посмотреть информацию, введите корректный объект: " + e);
                    }
                    break;

                default:
                    System.out.println("Введён неверный номер");
            }

        }

    }


    public void lab4() {

        labPreparation();
        ObjectsCreator.createObjects(10, 5, 5, 5, 5, 2, 2);

        Scanner input = new Scanner(System.in);

        Long bankId;
        Long paymentAccountId;
        Long userId;
        String fileName;
        ArrayList<PaymentAccount> paymentAccounts = new ArrayList<>();

        int actionIndex = -1;
        while (actionIndex != 0) {
            System.out.println(
                    """
                            Выберите одно из действий:
                            1 - Посмотреть список банков
                            2 - Посмотреть список всех клиентов
                            3 - Вывести информацию о банке по id
                            4 - Вывести информацию о клиенте по id
                            5 - Вывести платёжный счёт по id в файл
                            6 - Вывести все платёжные счета клиента по id в файл
                            7 - Перевести все платёжные счета из файла в другой банк по id
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
                    try {
                        System.out.println("Информация о банке: ");
                        ServiceManager.getBankService().printBankInfo(ServiceManager.getBankService().get(objectId));
                    }
                    catch (WrongIdentifierHandlingException e) {
                        System.out.println("Не удалось посмотреть информацию, введите корректный объект: " + e);
                    }
                    break;

                case 4:
                    System.out.println("Введите id клиента для просмотра");
                    objectId = input.nextLong();
                    try {
                        System.out.println("Информация о клиенте");
                        ServiceManager.getUserService().printUserInfo(ServiceManager.getUserService().get(objectId));
                    }
                    catch (WrongIdentifierHandlingException e) {
                        System.out.println("Не удалось посмотреть информацию, введите корректный объект: " + e);
                    }
                    break;

                case 5:
                    System.out.println("Введите id платёжного счёта для записи в файл");
                    paymentAccountId = input.nextLong();

                    System.out.println("Введите путь файла для записи");
                    fileName = input.next();

                    try {
                        paymentAccounts.add(ServiceManager.getPaymentAccountService().get(paymentAccountId));
                        ServiceManager.getPaymentAccountService().writeToFile(paymentAccounts, fileName);
                    }
                    catch (IOException e) {
                        System.out.println("Ошибка ввода: " + e);
                    } catch (WrongIdentifierHandlingException e) {
                        System.out.println("Платёжного аккаунта с введённым вами идентификатором не существует: " + e);
                    }
                    break;

                case 6:
                    System.out.println("Введите id клиента");
                    userId = input.nextLong();

                    System.out.println("Введите путь файла для записи");
                    fileName = input.next();

                    Long finalUserId = userId;
                    Function<PaymentAccount, Boolean> condition = paymentAccount -> paymentAccount.getUserId().equals(finalUserId);
                    paymentAccounts = ServiceManager.getPaymentAccountService().getByCondition(condition);

                    try {
                        ServiceManager.getPaymentAccountService().writeToFile(paymentAccounts, fileName);
                    }
                    catch (IOException e) {
                        System.out.println("Ошибка ввода: " + e);
                    } catch (WrongIdentifierHandlingException e) {
                        System.out.println("Платёжного аккаунта с введённым вами идентификатором не существует: " + e);
                    }
                    break;

                case 7:
                    System.out.println("Введите id банка");
                    bankId = input.nextLong();

                    System.out.println("Введите путь файла из которого брать аккаунты");
                    fileName = input.next();
                    try {
                        paymentAccounts = ServiceManager.getPaymentAccountService().readFromFile(fileName);
                    } catch (IOException e) {
                        System.out.println("Ошибка ввода: " + e);
                    } catch (ClassNotFoundException e) {
                        System.out.println("Введёный файл имеет некорректно содержимое: " + e);
                    }

                    try {
                        ServiceManager.getBankService().transferAccounts(paymentAccounts, bankId);
                    } catch (WrongIdentifierHandlingException e) {
                        System.out.println("Введёный файл имеет некорректно содержимое, несуществующий идентификатор: " + e);
                    }
                    break;

                default:
                    System.out.println("Введён неверный номер");
            }

        }

    }


}
