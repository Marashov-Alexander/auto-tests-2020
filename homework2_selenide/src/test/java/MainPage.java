import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    public MainPage open() {
        Selenide.open("https://ok.ru");
        return this;
    }

    public SearchPage searchBy(final String string) {
        final SelenideElement searchField =
                $(new By.ByXPath(".//*[@id='toolbar_search']//input[@name='st.query']"))
                        .waitUntil(Condition.exist, 1000);
        searchField.setValue(string);
        searchField.pressEnter();
        return new SearchPage();
    }



}
