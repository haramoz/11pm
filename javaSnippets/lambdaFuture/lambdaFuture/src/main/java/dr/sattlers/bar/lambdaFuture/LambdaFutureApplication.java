package dr.sattlers.bar.lambdaFuture;


import dr.sattlers.bar.lambdaFuture.interfaces.StringFunction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.function.Consumer;

@SpringBootApplication
public class LambdaFutureApplication {

	public static void main(String[] args) {
		SpringApplication.run(LambdaFutureApplication.class, args);

		ArrayList<Integer> numbers = new ArrayList<Integer>();
		numbers.add(5);
		numbers.add(9);
		numbers.add(8);
		numbers.add(1);
		numbers.forEach( (n) -> { System.out.println(n); } );

		System.out.println("Second approach");

		Consumer<Integer> method = (n) -> {
			System.out.println(n + 1);
		};

		numbers.forEach(method);

		System.out.println("Third approach");

		StringFunction exclaim = (s) -> s + "!";
		StringFunction ask = (s) -> s + "?";
		printFormatted("Hello", exclaim);
		printFormatted("Arka", ask);
	}

	public static void printFormatted(String str, StringFunction stringFunction) {
		String result = stringFunction.run(str);
		System.out.println(result);
	}
}

