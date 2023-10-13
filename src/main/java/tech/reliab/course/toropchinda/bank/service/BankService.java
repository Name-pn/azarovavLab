package tech.reliab.course.toropchinda.bank.service;

import tech.reliab.course.toropchinda.bank.entity.*;

public interface BankService {
    /** Создание банка
     * @param bank - банк
     * @return возвращает созданный банк */
    Bank create(Bank bank);

    /**
     * Добавляет офис банку
     * @param bank
     * @param bankOffice
     * @return Возвращает значение Истина если офис успешно добавлен, иначе возвращает значение Ложь
     */
    Boolean addOffice(Bank bank, BankOffice bankOffice);

    /**
     * Удаляет офис банка bank соответствующий bankOffice
     * @param bank
     * @param bankOffice
     * @return Возвращает значение Истина, если bankOffice успешно удален из банка bank, иначе возвращает значение ложь
     */
    Boolean deleteOffice(Bank bank, BankOffice bankOffice);

    /**
     * Метод добавления банкомата
     * @param bank
     * @param bankAtm
     * @return Возвращает значение Истина если банкомат успешно добавлен, иначе возвращает Ложь
     */
    Boolean addAtm(Bank bank, BankAtm bankAtm);

    /**
     * Удаляет банкомат из банка
     * @param bank
     * @param bankAtm
     * @return Возвращает значение Истина при успешном завершении операции, иначе возвращает Ложь
     */
    Boolean deleteAtm(Bank bank, BankAtm bankAtm);

    /**
     * Добавляет работника в банк
     * @param bank
     * @param employee
     * @return Возвращает значение Истина при успешном завершении операции, иначе возвращает Ложь
     */
    Boolean addEmployee(Bank bank, Employee employee);

    /**
     * Удаляет работника из банка
     * @param bank
     * @param employee
     * @return Возвращает значение Истина при успешном завершении операции, иначе возвращает Ложь
     */
    Boolean deleteEmployee(Bank bank, Employee employee);

    /**
     * Добавляет клиента в банк
     * @param bank
     * @param user
     * @return Возвращает значение Истина при успешном завершении операции, иначе возвращает Ложь
     */
    Boolean addClient(Bank bank, User user);

    /**
     * Удаляет клиента из банка
     * @param bank
     * @param user
     * @return Возвращает значение Истина при успешном завершении операции, иначе возвращает Ложь
     */
    Boolean deleteClient(Bank bank, User user);

    /**
     * Добавляет деньги банку
     * @param bank
     * @param sum
     * @return Возвращает значение Истина при успешном завершении операции, иначе возвращает Ложь
     */
    Boolean putMoney(Bank bank, Integer sum);


}
