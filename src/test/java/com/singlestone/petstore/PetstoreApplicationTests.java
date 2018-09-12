package com.singlestone.petstore;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PetstoreApplicationTests {

	@Test
	public void testTotalOrderPriceCalc() {
		Order order = new Order();

		OrderItem[] items = {new OrderItem("123abc",4,"product1",2.50), //10
		new OrderItem("234abc",2,"product2",1.50), //3
		new OrderItem("345abc",3,"product3",3.00)}; //9

		order.setItems(items);

		assertThat("Total price calculated by getOrderPrice fn", order.getOrderPrice(),is(22.0));
	}

}
