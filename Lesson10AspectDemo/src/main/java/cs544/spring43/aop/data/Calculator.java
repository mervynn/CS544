package cs544.spring43.aop.data;

import org.springframework.stereotype.Component;

@Component
public class Calculator implements ICalculator {
	public int add(int x, int y) {
		System.out.println("Calculator.add receiving: x= " + x + " and y= " + y);
		return x + y;
	}
}
