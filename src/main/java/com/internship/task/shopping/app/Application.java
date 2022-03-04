package com.internship.task.shopping.app;

import com.internship.task.shopping.app.basket.Basket;
import com.internship.task.shopping.app.basket.BasketController;
import com.internship.task.shopping.app.product.ProductDb;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
	}

}
