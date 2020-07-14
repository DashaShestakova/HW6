

package HW6;

/**
 * Загрузчик курса с сайта Нац. Банка
 */
public class AlfaBank extends SiteLoader{

    /**
     * Метод для запуска загрузки курса валют
     * @param currencyName валюта которую мы ищем
     * @return курс который мы нашли
     */
    @Override
    public double load(SiteLoader.Currency currencyName) {
        return load("https://developerhub.alfabank.by:8273/partner/1.0.0/public/rates", currencyName);
    }

    /**
     * Обработка результата загрузки с сайта банка + currencyName.getId()
     * @param content то что получилось загрузить
     * @param currencyName валюта которую мы ищем
     * @return курс который мы нашли
     */
    @Override
    protected double handle(String content, SiteLoader.Currency currencyName) {
        String delimeter = "},";
        String [] subStr = content.split(delimeter);
        String strWithCurrency = null;
        for (int i = 0; i < subStr.length; i++){
            if (subStr[i].contains("sellIso\":\"" + currencyName)) {
                strWithCurrency = subStr[i];
                break;
            }
        }
        int firstIndex = strWithCurrency.indexOf("sellRate") +10;
        int lastIndex = strWithCurrency.indexOf("sellIso") - 4;
        String course = strWithCurrency.substring(firstIndex, lastIndex);
        return Double.parseDouble(course);
    }
}