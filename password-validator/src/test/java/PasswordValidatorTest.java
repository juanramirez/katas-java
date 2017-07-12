import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class PasswordValidatorTest {
	private void assertPasswordTrue(String password) {
		assertTrue(PasswordValidator.isValid(password));
	}

	private void assertPasswordFalse(String password) {
		assertFalse(PasswordValidator.isValid(password));
	}

	@Test
	public void thatPasswordIsValidWhenAllRequirementsAreFulfilled() {
		assertPasswordTrue("ab1Y_ph4T");
	}

	@Test
	public void thatPasswordIsNotValidWhenAllRequirementsButLengthGreaterThan8AreFulfilled() {
		assertPasswordFalse("a1Y_ph4T");
	}

	@Test
	public void thatPasswordIsNotValidWhenAllRequirementsButCapitalLettersAreFulfilled() {
		assertPasswordFalse("ab1y_ph4t");
	}

    @Test
    public void thatPasswordIsNotValidWhenAllRequirementsButNumbersAreFulfilled() {
		assertPasswordFalse("abcY_phlT");
    }

	@Test
	public void thatPasswordIsNotValidWhenAllRequirementsButLowercaseLettersAreFulfilled() {
		assertPasswordFalse("AB1Y_PH4T");
	}

	@Test
	public void thatPasswordIsNotValidWhenAllRequirementsButUnderscoresAreFulfilled() {
		assertPasswordFalse("ab1YJph4T");
	}
}
