package guru.qa;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class GithubTests extends TestBase{

    @Test
    void gitHubJUnit5Test(){

        step("Открываем страницу GitHub", () ->{
            open("https://github.com/");});

        step("Ищем Selenide", () ->{
            $(".header-search-input").click();
            $(".header-search-input").sendKeys("selenide");
            $(".header-search-input").submit();});

        step("Нажимаем на ссылку репозитория", () ->{
            $(linkText("selenide/selenide")).click();});

        step("Переходим в раздел Wiki", () ->{
            $("#wiki-tab").shouldBe(visible).click();});

        step("Ищем SoftAssertions и кликаем на него", () ->{
            $x("//a[contains(text(),'Soft assertions')]").click();});

        step("Проверяем наличие текста", () ->{
            $("#user-content-3-using-junit5-extend-test-class")
                    .shouldBe(visible);
            $("div.markdown-body")
                    .$$("h4")
                    .findBy(text("Using JUnit5 extend test class"))
                    .shouldBe(visible);
        });

    }
}