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

public class CalculatorUtilModuloTest {
	private Calculator calculator;
	private CalculatorUtil calcUtil;

	@Before
	public void init() {
		calculator = Mockito.mock(Calculator.class);
		calcUtil = new CalculatorUtil(calculator);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testModuloByZero() {
		// given
		doThrow(new IllegalArgumentException()).when(calculator).modulo(anyInt(), eq(0));

		// when
		calcUtil.getModuloText(3, 0);
		
		// then
		// empty - exception expected
	}

	@Test
	public void test16moduloBy11() {
		// given
		doReturn(5).when(calculator).modulo(anyInt(), anyInt());

		// when
		String result = calcUtil.getModuloText(16, 11);

		// then
		assertThat("16 % 11 = 5", is(equalTo(result)));
		verify(calculator).modulo(anyInt(), anyInt()); // check if our calculator mock was really invoked.
	
	}	

	@Test
	public void test10moduloBy5() {
		// given
		doReturn(0).when(calculator).modulo(anyInt(), anyInt());

		// when
		String result = calcUtil.getModuloText(10, 5);

		// then
		assertThat("10 % 5 = 0", is(equalTo(result)));
		verify(calculator).modulo(anyInt(), anyInt()); // check if our calculator mock was really invoked.
	
	}
}
