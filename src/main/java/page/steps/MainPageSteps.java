package page.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MainPageSteps {
    private WebDriver driver;
    private By questionsSection = By.className("accordion__item"); // локатор для поиска раздела с вопросами
    private By answerSection = By.className("accordion__panel"); // локатор для поиска ответа

    public MainPageSteps(WebDriver driver) {
        this.driver = driver;
    }

    // получить список всех вопросов
    public List<WebElement> getAllQuestions() {
        return driver.findElements(questionsSection);
    }

    // прокрутка до раздела Вопросы о важном
    public void scrollToListOfImportantQuestions() {
        WebElement element = driver.findElement(questionsSection);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", element);
    }

    // выбрать вопрос по индексу
    public void selectQuestionByIndex(int index) {
        List<WebElement> questions = getAllQuestions();
        questions.get(index).click();
    }
// получить текст ответа
    public String getAnswerText(int index) {
        List<WebElement> questions = getAllQuestions();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(questionsSection));
        return questions.get(index).findElement(answerSection).getText();
    }
}
