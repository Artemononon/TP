package org.example;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.Instant;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Orders.class)
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();

        Requests requests = new Requests(factory);

        Client client1 = new Client("Артём", "Михеев");
        requests.addClient(client1);
        Client client2 = new Client("Роман", "Чулков");
        requests.addClient(client2);
        Client client3 = new Client("Бамблби>", "Шершень");
        requests.addClient(client3);
        Client client4 = new Client("Борода", "Старость");
        requests.addClient(client4);

        Orders order1 = new Orders(Instant.parse("2023-01-01T15:00:00Z"), 500.0, client1);
        requests.addOrders(order1);
        Orders order2 = new Orders(Instant.parse("2023-02-01T18:00:00Z"), 1000.0, client2);
        requests.addOrders(order2);
        Orders order3 = new Orders(Instant.parse("2023-03-01T17:00:00Z"), 1500.0, client3);
        requests.addOrders(order3);
        Orders order4 = new Orders(Instant.parse("2023-04-01T16:00:00Z"), 2000.0, client1);
        requests.addOrders(order4);

        Product product1 = new Product("Solomon ASP Pro Advanced", "44", 15000.0, order2);
        requests.addProduct(product1);
        Product product2 = new Product("Arcteryx Beta LT", "XXL", 62100.0, order1);
        requests.addProduct(product2);
        Product product3 = new Product("La Routine", "XL", 5000.0, order4);
        requests.addProduct(product3);
        Product product4 = new Product("Anta SHOCK WAVE 5", "45", 13000.0, order3);
        requests.addProduct(product4);


        requests.printProductByClientName("Артём");
        System.out.println();
        requests.printClientByProductName("Arcteryx Beta LT");
        System.out.println();
        requests.deleteOrderAndProductByClientId(1L);
        System.out.println();
        requests.updateProductNameById(4L, "Anta KLAY THOMPSON RT 8");
        System.out.println();
        requests.addClient("Оптимус", "Прайм");
    }
}