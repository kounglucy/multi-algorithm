package step06.interfaceex;

public class Calculator extends Testing implements Calculation, Connection {

	@Override
	public int add(int x, int y) {
		return x + y;
	}

	@Override
	public int sub(int x, int y) {
		return x - y;
	}

	@Override
	public void connect() {
		
	}

	@Override
	public void test() {
		System.out.println("test : Calculator");
	}

}
