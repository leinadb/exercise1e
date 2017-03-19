package wdsr.exercise1;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import wdsr.exercise1.logic.Calculator;

public class CalculatorUtilSubtractionTest {
	private Calculator calculator;
	private CalculatorUtil calcUtil;

	@Before
	public void init() {
		calculator = Mockito.mock(Calculator.class);
		calcUtil = new CalculatorUtil(calculator);
	}

	@Test
	public void test3minus1() {
		// given
		doReturn(2).when(calculator).subtract(anyInt(), anyInt());

		// when
		String result = calcUtil.getSubstractionText(3, 1);

		// then
		assertThat("3 - 1 = 2", is(equalTo(result)));
		verify(calculator).subtract(anyInt(), anyInt());
	}

	@Test
	public void test13minus13() {
		// given
		doReturn(0).when(calculator).subtract(anyInt(), anyInt());

		// when
		String result = calcUtil.getSubstractionText(13, 13);

		// then
		assertThat("13 - 13 = 0", is(equalTo(result)));
		verify(calculator).subtract(anyInt(), anyInt());
	}

	@Test
	public void test13minus19() {
		// given
		doReturn(-6).when(calculator).subtract(anyInt(), anyInt());

		// when
		String result = calcUtil.getSubstractionText(13, 19);

		// then
		assertThat("13 - 19 = -6", is(equalTo(result)));
		verify(calculator).subtract(anyInt(), anyInt());
	}
}
