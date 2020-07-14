

package HW6;

/**
 * Загрузчик курса с сайта Нац. Банка
 */
public class BelapbBank extends SiteLoader{

    /**
     * Метод для запуска загрузки курса валют
     * @param currencyName валюта которую мы ищем
     * @return курс который мы нашли
     */
    @Override
    public double load(Currency currencyName) {
        return load("https://belapb.by/ExCardsDaily.php?ondate=11/22/2013", currencyName);
    }

    /**
     * Обработка результата загрузки с сайта банка + currencyName.getId()
     * @param content то что получилось загрузить
     * @param currencyName валюта которую мы ищем
     * @return курс который мы нашли
     */
    @Override
    protected double handle(String content, Currency currencyName) {
        String delimeter = "</Currency>";
        String [] subStr = content.split(delimeter);
        String strWithCurrency = null;
        for (int i = 0; i < subStr.length; i++){
            if (subStr[i].contains("<CharCode>" + currencyName + "</CharCode>")) {
                strWithCurrency = subStr[i];
                break;
            }
        }
        int firstIndex = strWithCurrency.indexOf("<RateBuy>") +9;
        int lastIndex = strWithCurrency.indexOf("</RateBuy>") - 1;
        String course = strWithCurrency.substring(firstIndex, lastIndex);
        return Double.parseDouble(course);
    }
}