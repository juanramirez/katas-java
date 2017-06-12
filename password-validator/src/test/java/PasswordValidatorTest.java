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
}
