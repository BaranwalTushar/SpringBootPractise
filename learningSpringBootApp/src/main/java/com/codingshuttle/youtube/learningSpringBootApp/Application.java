package com.codingshuttle.youtube.learningSpringBootApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);


	}

//	@Autowired
//	private  RazorPayPaymentService razorPayPaymentService;

	//constructor dependency injection
	private final PaymentService paymentService;// dependency injection Application is dependent on PaymentService.

	public Application(PaymentService paymentService) {
		this.paymentService = paymentService;
	}

	@Override
	public void run(String... args) throws Exception {
		String payment = paymentService.pay();
		System.out.println("payment done " + payment);
	}
}
