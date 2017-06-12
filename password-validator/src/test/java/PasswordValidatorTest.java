import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class PasswordValidatorTest {

	@Test
	public void thatValidatorReturnsFalseWhenPasswordHas8Characters() {
		String password = "12345678";
		assertFalse(PasswordValidator.check(password));
	}

}
