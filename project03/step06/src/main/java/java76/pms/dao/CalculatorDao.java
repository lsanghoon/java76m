package java76.pms.dao;

import org.springframework.stereotype.Component;

import java76.pms.domain.Calculator;

@Component
public class CalculatorDao {

	public CalculatorDao() {}


	public int add(Calculator calculator) {
		calculator.setResult(calculator.getV1() + calculator.getV2());
		return 0;
	}
	
	public int minus(Calculator calculator) {
		calculator.setResult(calculator.getV1() - calculator.getV2());
		return 0;

		}
	
	public int multi(Calculator calculator) {
		calculator.setResult(calculator.getV1() * calculator.getV2());
		return 0;

		}
	
	public int divide(Calculator calculator) {
		calculator.setResult(calculator.getV1() / calculator.getV2());
		return 0;

		}
	
	public int remainder(Calculator calculator) {
		calculator.setResult(calculator.getV1() % calculator.getV2());
		return 0;

		}
}