import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class PasswordValidatorTest {

	@Test
	public void thatValidatorReturnsTrueWhenAValidPasswordIsGiven() {
		String password = "ab1Y_ph4T";
		assertTrue(PasswordValidator.check(password));
	}

	@Test
	public void thatValidatorReturnsFalseWhenPasswordHas8Characters() {
		String password = "a1Y_ph4T";
		assertFalse(PasswordValidator.check(password));
	}

	@Test
	public void thatValidatorReturnsFalseWithAPasswordWithoutCapitalLetters() {
		String password = "ab1y_ph4t";
		assertFalse(PasswordValidator.check(password));
	}

    @Test
    public void thatValidatorReturnsFalseWithAPasswordWithoutNumbers() {
        String password = "abcY_phlT";
        assertFalse(PasswordValidator.check(password));
    }

	@Test
	public void thatValidatorReturnsFalseWithAPasswordWithoutLowercaseLetters() {
		String password = "AB1Y_PH4T";
		assertFalse(PasswordValidator.check(password));
	}

	@Test
	public void thatValidatorReturnsFalseWithAPasswordWithoutUnderscores() {
		String password = "ab1YJph4T";
		assertFalse(PasswordValidator.check(password));
	}
}
