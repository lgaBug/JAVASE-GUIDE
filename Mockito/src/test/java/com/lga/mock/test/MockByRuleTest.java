import com.lga.mock.dao.LoginDao;
import com.lga.mock.pojo.User;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class MockByRuleTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private LoginDao mockLogindao;

    @Test
    public void testMock() {
        User lga = mockLogindao.findAccountByUserNameAndPassword("lga", "123");
        System.out.println("lga = " + lga);

    }

}
