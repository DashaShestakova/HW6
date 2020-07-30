

package HW6;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Загрузчик курса с сайта Нац. Банка
 */
public class BPS extends SiteLoader{

    /**
     * Метод для запуска загрузки курса валют
     * @param currencyName валюта которую мы ищем
     * @return курс который мы нашли
     */
    @Override
    public double load(Currency currencyName) {
        return load("https://www.bps-sberbank.by/page/currency-exchange-cards", currencyName);
    }

    /**
     * Обработка результата загрузки с сайта банка + currencyName.getId()
     * @param content то что получилось загрузить
     * @param currencyName валюта которую мы ищем
     * @return курс который мы нашли
     */
    @Override
    protected double handle(String content, SiteLoader.Currency currencyName) {
        String delimeter = "currency__icon\">,";
        String [] subStr = content.split(delimeter);
        subStr[0] = null;
        String strWithCurrency = null;
        for (int i = 1; i < subStr.length; i++){
            if (subStr[i].contains(currencyName.toString())) {
                strWithCurrency = subStr[i];
                break;
            }
        }
        int firstIndex = strWithCurrency.indexOf("\"currency\"") + 17;
        int lastIndex = strWithCurrency.indexOf("\"currency\"") + 23;
        String course = strWithCurrency.substring(firstIndex, lastIndex);
        return Double.parseDouble(course.replace("," , "."));
    }

}