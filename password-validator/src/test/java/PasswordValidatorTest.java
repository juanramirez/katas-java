import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class PasswordValidatorTest {

	@Test
	public void thatValidatorReturnsFalseWhenPasswordHas8Characters() {
		String password = "12345678";
		assertFalse(PasswordValidator.check(password));
	}

	@Test
	public void thatValidatorReturnsTrueWhenAValidPasswordIsGiven() {
		String password = "ab1Y_ph4T";
		assertTrue(PasswordValidator.check(password));
	}

	@Test
	public void thatValidatorReturnsFalseWhenAPasswordWithoutCapitalLetter() {
		String password = "ab1y_ph4t";
		assertFalse(PasswordValidator.check(password));
	}

    @Test
    public void thatValidatorReturnsFalseWhenAPasswordWithoutNumbers() {
        String password = "abcY_phlT";
        assertFalse(PasswordValidator.check(password));
    }

	@Test
	public void thatValidatorReturnsFalseWhenAPasswordWithoutLowercaseLetters() {
		String password = "AB1Y_PH4T";
		assertFalse(PasswordValidator.check(password));
	}
}
