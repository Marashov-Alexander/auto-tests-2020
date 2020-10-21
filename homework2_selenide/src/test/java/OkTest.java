import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.startsWith;

public class OkTest {

    private final static String login = "";
    private final static String password = "";

    LoginPage loginPage = new LoginPage();
    MainPage mainPage;
    SearchPage searchPage;

    final String start = "Александр";
    final String end = "Марашов";

    @BeforeAll
    public static void setup() {
        Configuration.baseUrl = "https://ok.ru";
    }

    @Order(1)
    @Test
    public void userCanLogin() {
        Assertions.assertTrue(
                loginPage
                        .open()
                        .login(login, password)
                        .isSuccess()
        );
    }

    @Order(2)
    @Test
    public void userCanSearch() {
        mainPage = new MainPage();
        searchPage = mainPage.open().searchBy(start + " " + end);
        Assertions.assertTrue(searchPage != null);
    }

    @Order(3)
    @Test
    public void searchIsCorrect() {
        final String value = searchPage.firstValue();
        assertThat(value, anyOf(startsWith(start), endsWith(end)));
    }

}
