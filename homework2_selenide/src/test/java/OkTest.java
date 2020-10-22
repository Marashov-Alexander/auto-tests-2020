import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.startsWith;

public class OkTest {

    private final static String login = "technopolisBot206";
    private final static String password = "technopolis16";

    LoginPage loginPage = new LoginPage();
    MainPage mainPage;
    SearchPage searchPage;

    final String start = "Александр";
    final String end = "Марашов";

    @BeforeAll
    public static void setup() {
        Configuration.baseUrl = "https://ok.ru";
    }

    @Test
    public void A_userCanLogin() {
        Assertions.assertTrue(
                loginPage
                        .open()
                        .login(login, password)
                        .isSuccess()
        );
    }

    @Test
    public void B_userCanSearch() {
        mainPage = new MainPage();
        searchPage = mainPage.open().searchBy(start + " " + end);
        Assertions.assertNotNull(searchPage);
    }

    @Test
    public void C_searchIsCorrect() {
        searchPage = new SearchPage();
        final String value = searchPage.anySearchValue();
        final int resultsCount = searchPage.resultsCount();
        Assertions.assertTrue(resultsCount > 0);
        assertThat(value, allOf(containsString(start), containsString(end)));
    }

}
