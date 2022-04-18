import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class AccountTest extends TestCase {
    private final String name;
    private final boolean expectedResult;

    public AccountTest(String name, boolean expectedResult) {
        this.name = name;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters(name = "Check the name: {0}")
    public static Object[][] dataForTest() {
        return new Object[][]{
                {"q qq", true}, //1. Корректное имя
                {"q q", true}, //2. Имя из 3 символов
                {"q qqqqqqqqqqqqqqqqq", true}, //3. Имя из 19 символов
                {"q qq", true}, //4. Имя из четырех символов
                {"q qqqqqqqqqqqqqqqq", true}, //5. Имя из восемнадцати символов
                {" q qq", false}, //6. Имя с пробелом в начале
                {"q qq ", false}, //7. Имя с пробелом в конце
                {"qq", false}, //8. Имя меньше трех символов
                {"q qqqqqqqqqqqqqqqqqq", false}, //9. Имя больше девятнадцати символов
                {"", false}, //10. Пустая строка
                {null, false}, //11. Имя = null
                {"q  qq", false}, //12. 2 пробела
                {"qqq", false} //13. без пробела
        };
    }

    @Test
    public void AccountTest() {
        Account account = new Account (name);
        boolean actual = account.checkNameToEmboss ();
        Assert.assertEquals ("Некорректное значение.", expectedResult, actual);

    }

}