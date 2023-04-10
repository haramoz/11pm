package dr.sattlers.bar.springmongodocker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication
public class SpringmongodockerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringmongodockerApplication.class, args);
	}

}
