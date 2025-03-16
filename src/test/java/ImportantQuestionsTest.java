import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pageSteps.ImportantQuestionsSteps;
import pageSteps.MainPageSteps;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ImportantQuestionsTest extends BaseTest {
    private final int questionNumber;
    private final String question;
    private final String expectedAnswer;

    public ImportantQuestionsTest(int questionNumber, String question, String expectedAnswer) {
        this.questionNumber = questionNumber;
        this.question = question;
        this.expectedAnswer = expectedAnswer;
    }

    @Parameterized.Parameters
    public static Object[][] checkText() {
        return new Object[][] {
                {1, "Сколько это стоит? И как оплатить?", "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {2, "Хочу сразу несколько самокатов! Так можно?", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {3, "Как рассчитывается время аренды?", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
        };
    }

    @Test
    public void importantQuestionsTest() {
        MainPageSteps objMainPageSteps = new MainPageSteps(driver);
        objMainPageSteps.openPage();
        objMainPageSteps.closeCookies();

        ImportantQuestionsSteps objImportantQuestions = new ImportantQuestionsSteps(driver);
        objImportantQuestions.scrollToListOfImportantQuestions();
        objImportantQuestions.selectQuestionByIndex(questionNumber - 1);
        String actualAnswer = objImportantQuestions.getAnswerText(questionNumber - 1);
        assertEquals("Ответ не совпадает с вопросом", expectedAnswer, actualAnswer);
    }
    }

    
       
