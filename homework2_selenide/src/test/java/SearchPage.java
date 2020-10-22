import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SearchPage {

    public int resultsCount() {
        final SelenideElement searchResult =
                $(new By.ByXPath(".//*[@class='results-content__m3nyy']//*[@class='heading__unijc __h2__unijc']"))
                        .waitUntil(Condition.exist, 1000);
        final int count;
        try {
            count = Integer.parseInt(searchResult.getText().split(" ")[1]);
        } catch (final NumberFormatException e) {
            return 0;
        }
        return count;
    }

    public String anySearchValue() {
        final SelenideElement searchResult =
                $(new By.ByXPath(".//*[@class='results-content__m3nyy']//a[@data-l]"))
                        .waitUntil(Condition.exist, 1000);
        return searchResult.getAttribute("data-l");
    }
}
