package co.com.sofka.selenium.utils;

public enum UrlPages {
    URL_INDEX("https://parabank.parasoft.com/parabank/index.htm"),
    URL_REGISTER("https://parabank.parasoft.com/parabank/register.htm"),
    URL_CONTACT_US("https://parabank.parasoft.com/parabank/contact.htm");

    private final String value;

    UrlPages(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
