import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    public LoginPage open() {
        Selenide.open("https://ok.ru");
        return this;
    }

    public LoginPage login(final String login, final String password) {
        final SelenideElement loginField = $(By.name("st.email")).waitUntil(Condition.exist, 1000);
        final SelenideElement passwordField = $(By.name("st.password")).waitUntil(Condition.exist, 1000);

        loginField.setValue(login);
        passwordField
                .setValue(password)
                .pressEnter();

        return this;
    }

    public boolean isSuccess() {
        final SelenideElement searchField =
                $(new By.ByXPath(".//*[@id='toolbar_search']//input[@name='st.query']"))
                .waitUntil(Condition.exist, 1000);
        return searchField.exists();
    }

}
