package wdsr.exercise1;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import wdsr.exercise1.logic.Calculator;

public class CalculatorUtilDivisionTest {
	private Calculator calculator;
	private CalculatorUtil calcUtil;

	@Before
	public void init() {
		calculator = Mockito.mock(Calculator.class);
		calcUtil = new CalculatorUtil(calculator);
	}
	
	@Test
	public void test16dividedBy4() {
		// given
		doReturn(4.0).when(calculator).divide(anyInt(), anyInt());

		// when
		String result = calcUtil.getDivisionText(16, 4);

		// then
		assertThat("16 / 4 = 4.0", is(equalTo(result)));
		verify(calculator).divide(anyInt(), anyInt());
	}	

	@Test
	public void test16dividedBy11() {
		// given
		doReturn(1.45).when(calculator).divide(anyInt(), anyInt());

		// when
		String result = calcUtil.getDivisionText(16, 11);

		// then
		assertThat("16 / 11 = 1.45", is(equalTo(result)));
		verify(calculator).divide(anyInt(), anyInt());
	}	

	@Test(expected=IllegalArgumentException.class)
	public void testDivisionByZero() {
		// given
		doThrow(new IllegalArgumentException()).when(calculator).divide(anyInt(), eq(0));

		// when
		calcUtil.getDivisionText(3, 0);
		
		// then
		// empty - exception expected
	}
}
