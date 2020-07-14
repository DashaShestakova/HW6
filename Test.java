package HW6;

public class Test {
    public static void main(String[] args) {
        AlfaBank loader = new AlfaBank();
        System.out.println(loader.load(SiteLoader.Currency.EUR));
        System.out.println(loader.load(SiteLoader.Currency.RUB));
        System.out.println(loader.load(SiteLoader.Currency.USD));

        BelarusBank loader1 = new BelarusBank();
        System.out.println(loader1.load(SiteLoader.Currency.EUR));
        System.out.println(loader1.load(SiteLoader.Currency.RUB));
        System.out.println(loader1.load(SiteLoader.Currency.USD));

        BelapbBank loader2 = new BelapbBank();
        System.out.println(loader2.load(SiteLoader.Currency.EUR));
        System.out.println(loader2.load(SiteLoader.Currency.USD));

    }
}
