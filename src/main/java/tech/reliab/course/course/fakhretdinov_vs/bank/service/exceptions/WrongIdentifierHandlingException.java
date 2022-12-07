package tech.reliab.course.course.fakhretdinov_vs.bank.service.exceptions;


public class WrongIdentifierHandlingException extends Exception {
    public WrongIdentifierHandlingException(Long id, Throwable err) {
        super("Не обнаружил идентификатор " + id + " в соответствующем сервисе", err);
    }
}
