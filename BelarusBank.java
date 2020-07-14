

package HW6;

/**
 * Загрузчик курса с сайта Нац. Банка
 */
public class BelarusBank extends SiteLoader{

    /**
     * Метод для запуска загрузки курса валют
     * @param currencyName валюта которую мы ищем
     * @return курс который мы нашли
     */
    @Override
    public double load(Currency currencyName) {
        return load("https://belarusbank.by/api/kursExchange", currencyName);
    }

    /**
     * Обработка результата загрузки с сайта банка + currencyName.getId()
     * @param content то что получилось загрузить
     * @param currencyName валюта которую мы ищем
     * @return курс который мы нашли
     */
    @Override
    protected double handle(String content, Currency currencyName) {
        String delimeter = "},";
        String [] subStr = content.split(delimeter);
        String strWithCurrency = subStr [0];

        int firstIndex = strWithCurrency.indexOf(currencyName + "_in") +9;
        int lastIndex = strWithCurrency.indexOf(currencyName + "_out") - 3;
        String course = strWithCurrency.substring(firstIndex, lastIndex);
        return Double.parseDouble(course);
    }
}