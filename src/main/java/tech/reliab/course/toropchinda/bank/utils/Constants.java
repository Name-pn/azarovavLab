package tech.reliab.course.toropchinda.bank.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

public class Constants {
    static public List<String> BANK_NAMES;

    static public List<String> ATM_NAMES;
    static public List<String> OFFICE_ADDRESS;
    static public List<String> FULLNAMES;

    static public List<String> POSITIONS;

    static public Integer RATING_PATTERN = 10000;

    static public Integer SALARY_PATTERN = 45000;
    static public Integer RENTAL_OFFICE_MAX_PRICE = 2000;
    static public Integer MAINTENANCE_COST_OF_ATM = 3000;

    static public Integer NUMBER_OFFICES = 3;
    static public Integer NUMBER_BANKS = 5;

    static public Integer NUMBER_USERS = 5;

    static public Integer NUMBER_ATMS = 3;

    static public Integer NUMBER_COUNTERS = 2;

    static public Integer PAYMENT_ACCOUNT_SUM_PATTERN = 100000;

    static public Integer CREDIT_PATTERN = 1000000;

    static public Integer NUMBER_EMPLOYEES_IN_OFFICE = 5;

    static public Integer NUMBER_FULLNAMES;

    static public Integer NUMBER_POSITIONS;

    public Constants() {
        BANK_NAMES = new ArrayList<String>();
        BANK_NAMES.add("Газпромбанк");
        BANK_NAMES.add("Тинькоф");
        BANK_NAMES.add("Сбербанк");
        BANK_NAMES.add("ВТБ");
        BANK_NAMES.add("Ozon банк");

        ATM_NAMES = new ArrayList<String>();
        ATM_NAMES.add("");

        OFFICE_ADDRESS = new ArrayList<String>();
        OFFICE_ADDRESS.add("г. Белгород, ул. Костюкова, д. 10");
        OFFICE_ADDRESS.add("г. Старый Оскол, ул. Ленина, д. 44");
        OFFICE_ADDRESS.add("г. Старый Оскол, мкр. Приборостроитель, д. 55");
        OFFICE_ADDRESS.add("г. Старый Оскол, ул. Комсомольская, д. 61");
        OFFICE_ADDRESS.add("г. Старый Оскол, бул. Дружбы, д. 2");
        OFFICE_ADDRESS.add("г. Старый Оскол, мкр. Солнечный, д. 3");
        OFFICE_ADDRESS.add("г. Старый Оскол, ул. Ленина, д. 74");
        OFFICE_ADDRESS.add("г. Старый Оскол, мкр. Макаренко, д. 38");
        OFFICE_ADDRESS.add("г. Старый Оскол, мкр. Звездный, д. 1");
        OFFICE_ADDRESS.add("г. Старый Оскол, мкр. Рудничный, д. 14");
        OFFICE_ADDRESS.add("г. Белгород, просп. Белгородский, д. 73");
        OFFICE_ADDRESS.add("г. Белгород, Магистральная улица, 12");
        OFFICE_ADDRESS.add("г. Белгород, просп. Гражданский, д. 36");
        OFFICE_ADDRESS.add("г. Белгород, просп. Хмельницкого, 133Г");
        OFFICE_ADDRESS.add("г. Белгород, ул. Победы, 124");
        OFFICE_ADDRESS.add("г. Белгород, просп. Белгородский, 54");

        FULLNAMES = new ArrayList<String>();
        FULLNAMES.add("James Smith");
        FULLNAMES.add("David Smith");
        FULLNAMES.add("Robert Smith");
        FULLNAMES.add("John Smith");
        FULLNAMES.add("Maria Garcia");

        FULLNAMES.add("Michael Smith");
        FULLNAMES.add("James Johnson");
        FULLNAMES.add("David Johnson");
        FULLNAMES.add("Maria Rodriguez");
        FULLNAMES.add("Mary Smith");

        FULLNAMES.add("Maria Hernandez");
        FULLNAMES.add("Charles Smith");
        FULLNAMES.add("Maria Martinez");
        FULLNAMES.add("Robert Johnson");
        FULLNAMES.add("James Williams");

        FULLNAMES.add("James Brown");
        FULLNAMES.add("Jose Garcia");
        FULLNAMES.add("Maria Gonzalez");
        FULLNAMES.add("Jose Rodriguez");
        FULLNAMES.add("David Brown");

        FULLNAMES.add("Carla Houston");
        FULLNAMES.add("Kaitlyn Kristy");
        FULLNAMES.add("Sally Selcen Stochliya");
        FULLNAMES.add("Abigail Akon Obro");
        FULLNAMES.add("Candice Cromwell");

        FULLNAMES.add("Иванов Матвей Иванович");
        FULLNAMES.add("Симонова Ника Марковна");
        FULLNAMES.add("Леонов Ибрагим Маркович");
        FULLNAMES.add("Аникина Мария Львовна");
        FULLNAMES.add("Михайлова Мария Марковна");

        FULLNAMES.add("Зверев Никита Эмирович");
        FULLNAMES.add("Колесников Андрей Кириллович");
        FULLNAMES.add("Морозов Илья Иванович");
        FULLNAMES.add("Цветков Али Захарович");
        FULLNAMES.add("Корнеев Максим Алексеевич");

        FULLNAMES.add("Захарова Ева Макаровна");
        FULLNAMES.add("Белов Адам Георгиевич");
        FULLNAMES.add("Лаптев Андрей Ярославович");
        FULLNAMES.add("Ефимов Александр Лукич ");
        FULLNAMES.add("Козлов Артём Константинович");

        FULLNAMES.add("Волкова Ева Артёмовна");
        FULLNAMES.add("Бирюков Артемий Тимофеевич");
        FULLNAMES.add("Федотов Глеб Дмитриевич");
        FULLNAMES.add("Полякова Анастасия Фёдоровна");
        FULLNAMES.add("Мартынова Софья Дмитриевна");

        FULLNAMES.add("Родионов Ярослав Даниилович");
        FULLNAMES.add("Киселев Мирон Сергеевич");
        FULLNAMES.add("Краснов Михаил Львович");
        FULLNAMES.add("Игнатов Александр Савельевич");
        FULLNAMES.add("Козырев Иван Петрович");

        NUMBER_FULLNAMES = FULLNAMES.size();

        POSITIONS = new ArrayList<String>();
        POSITIONS.add("Кассир");
        POSITIONS.add("Cпециалист по обслуживанию");
        POSITIONS.add("Cотрудник кредитного отдела");
        POSITIONS.add("Работник валютного подразделения");
        POSITIONS.add("Консультант");
        POSITIONS.add("Управляющий");
        POSITIONS.add("Бухгалтер банка");
        POSITIONS.add("Финансовый аналитик");
        POSITIONS.add("Аналитик фондового рынка");
        POSITIONS.add("Аудитор");
        POSITIONS.add("Банкир");

        NUMBER_POSITIONS = POSITIONS.size();
    }
}
