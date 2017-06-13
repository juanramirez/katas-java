import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class PasswordValidatorTest {
	@Test
	public void thatPasswordIsValidWhenAllRequirementsAreFulfilled() {
		String password = "ab1Y_ph4T";
		assertTrue(PasswordValidator.isValid(password));
	}

	@Test
	public void thatPasswordIsNotValidWhenAllRequirementsButLengthGreaterThan8AreFulfilled() {
		String password = "a1Y_ph4T";
		assertFalse(PasswordValidator.isValid(password));
	}

	@Test
	public void thatPasswordIsNotValidWhenAllRequirementsButCapitalLettersAreFulfilled() {
		String password = "ab1y_ph4t";
		assertFalse(PasswordValidator.isValid(password));
	}

    @Test
    public void thatPasswordIsNotValidWhenAllRequirementsButNumbersAreFulfilled() {
        String password = "abcY_phlT";
        assertFalse(PasswordValidator.isValid(password));
    }

	@Test
	public void thatPasswordIsNotValidWhenAllRequirementsButLowercaseLettersAreFulfilled() {
		String password = "AB1Y_PH4T";
		assertFalse(PasswordValidator.isValid(password));
	}

	@Test
	public void thatPasswordIsNotValidWhenAllRequirementsButUnderscoresAreFulfilled() {
		String password = "ab1YJph4T";
		assertFalse(PasswordValidator.isValid(password));
	}
}
