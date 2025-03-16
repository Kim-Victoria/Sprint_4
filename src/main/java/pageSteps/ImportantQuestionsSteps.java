package pageSteps;
import org.openqa.selenium.*;
import pages.ImportantQuestions;
import java.util.List;


public class ImportantQuestionsSteps {
    private WebDriver driver;
    private ImportantQuestions importantQuestions;
    private By questionsSection = By.className("accordion__item"); // локатор для поиска раздела с вопросами

    public ImportantQuestionsSteps(WebDriver driver) {
        this.driver = driver;
        importantQuestions = new ImportantQuestions(driver);
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

    // Получить текст ответа
    public String getAnswerText(int index) {
        WebElement answerElement = driver.findElement(By.xpath("//*[@id='accordion__panel-" + index + "']"));
        return answerElement.getText();
    }
}