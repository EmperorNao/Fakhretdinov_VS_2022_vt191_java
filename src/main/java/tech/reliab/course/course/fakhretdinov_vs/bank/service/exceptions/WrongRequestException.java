package tech.reliab.course.course.fakhretdinov_vs.bank.service.exceptions;


public class WrongRequestException extends Exception {
    public WrongRequestException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
