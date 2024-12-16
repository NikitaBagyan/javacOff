package src.main.SkillFactory.Pizzeria;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

class Pizzeria {

    LinkedBlockingDeque<Order> orders = new LinkedBlockingDeque<>();
    final long START_TIME;

    class Order {
        String orderName;
        long orderStart;

        public Order(String orderName, long orderStart) {
            this.orderName = orderName;
            this.orderStart = orderStart;
        }
    }

    Pizzeria() {
        START_TIME = System.currentTimeMillis();
        new PizzaCar().start();
        new PizzaCar().start();
    }

    class PizzaCar extends Thread {
        @Override
        public void run() {
            while (System.currentTimeMillis() - START_TIME < 5000) {
                Order order = null;
                try {
                    order = orders.poll(10, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e) {
                    break;
                }
                if (order != null) {
                    if (System.currentTimeMillis() + 500 - order.orderStart <= 750) {
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            break;
                        }
                        System.out.println(order.orderName + " is delivered");
                    } else {
                        System.out.println(order.orderName + " is NOT delivered");
                    }
                }
            }
        }
    }

    void order(String pizzaname) {
        try {
            orders.put(new Order(pizzaname, System.currentTimeMillis()));
        } catch (InterruptedException e) {
            return;
        }
    }
}