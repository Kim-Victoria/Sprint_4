import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import page.steps.MainPageSteps;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ImportantQuestionsTest extends BaseTest {
    private final int questionNumber;
    private final String question;
    private final String expectedAnswer;
    private static final String QUESTION_1 = "Сколько это стоит? И как оплатить?";
    private static final String ANSWER_1 = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    private static final String QUESTION_2 = "Хочу сразу несколько самокатов! Так можно?";
    private static final String ANSWER_2 = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    private static final String QUESTION_3 = "Как рассчитывается время аренды?";
    private static final String ANSWER_3 = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    private static final String QUESTION_4 = "Можно ли заказать самокат прямо на сегодня?";
    private static final String ANSWER_4 = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    private static final String QUESTION_5 = "Можно ли продлить заказ или вернуть самокат раньше?";
    private static final String ANSWER_5 = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    private static final String QUESTION_6 = "Вы привозите зарядку вместе с самокатом?";
    private static final String ANSWER_6 = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    private static final String QUESTION_7 = "Можно ли отменить заказ?";
    private static final String ANSWER_7 = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    private static final String QUESTION_8 = "Я жизу за МКАДом, привезёте?";
    private static final String ANSWER_8 = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";

    public ImportantQuestionsTest(int questionNumber, String question, String expectedAnswer) {
        this.questionNumber = questionNumber;
        this.question = question;
        this.expectedAnswer = expectedAnswer;
    }

    @Parameterized.Parameters
    public static Object[][] checkText() {
        return new Object[][] {
                {1, QUESTION_1, ANSWER_1},
                {2, QUESTION_2, ANSWER_2},
                {3, QUESTION_3, ANSWER_3},
                {4, QUESTION_4, ANSWER_4},
                {5, QUESTION_5, ANSWER_5},
                {6, QUESTION_6, ANSWER_6},
                {7, QUESTION_7, ANSWER_7},
                {8, QUESTION_8, ANSWER_8},
        };
    }

    @Test
    public void importantQuestionsTest() {
        MainPageSteps objImportantQuestions = new MainPageSteps(driver);
        objImportantQuestions.scrollToListOfImportantQuestions();
        objImportantQuestions.selectQuestionByIndex(questionNumber - 1);
        String actualAnswer = objImportantQuestions.getAnswerText(questionNumber - 1);
        assertEquals("Ответ не совпадает с вопросом", expectedAnswer, actualAnswer);
    }
    }

    
       
