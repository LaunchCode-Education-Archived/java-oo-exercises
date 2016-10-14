package counter;

public class CounterChild extends Counter {

	public static void main(String[] args) {
		
		for (int i = 0; i < 10; i++) {
			CounterChild.incrementStatic();
		}
		
		System.out.println(CounterChild.getStaticCounter());
		System.out.println(Counter.getStaticCounter());
	}
	
}
