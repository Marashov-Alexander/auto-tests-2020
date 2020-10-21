import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SearchPage {

    public String firstValue() {
        final SelenideElement searchResult =
                $(new By.ByXPath(".//*[@class='sm__79ad9 __ellipted__79ad9']"))
                        .waitUntil(Condition.exist, 1000);
        return searchResult.getText();
    }
}
