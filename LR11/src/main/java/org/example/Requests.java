package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
//import jakarta.persistence.*;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.time.Instant;
import java.util.*;

public class Requests {
    private final SessionFactory sessionFactory;

    public Requests(SessionFactory sessionFactory) {

        this.sessionFactory = sessionFactory;
    }

    public void addProduct(Product product) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(product);
            session.getTransaction().commit();
            session.close();
        }
    }

    public void addClient(Client client) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(client);
            session.getTransaction().commit();
            session.close();
        }
    }

    public void addOrders(Orders orders) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(orders);
            session.getTransaction().commit();
            session.close();
        }
    }

    //У клиента беру
    public void printProductByClientName(String client_name) {
        try (Session session = sessionFactory.openSession()) {
            List<Client> clients = session.createQuery("FROM Client WHERE client_name = :name", Client.class).setParameter("name", client_name).list();
            if (!clients.isEmpty()) {
                for (Client client : clients) {
                    System.out.println(client.getOrders());

                }
            } else {
                System.out.println("Не существует клиента с именем: " + client_name);
            }
        }
    }


    public void printClientByProductName(String product_name) {
        try (Session session = sessionFactory.openSession()) {
            List<Product> product = session.createQuery("FROM Product p WHERE p.product_name = :product_name").setParameter("product_name", product_name).list();
            for (Product prod : product) {
                if (prod.getOrders() != null) {
                    System.out.println(prod.getOrders().getclient());
                }
            }
        }
    }


    public void deleteOrderAndProductByClientId(Long client_id) {
        System.out.println("Удалено:");
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Client client = session.get(Client.class, client_id);
            if (client != null) {
                for (Orders orders : client.getOrders()) {
                    for (Product product : orders.getProduct()) {
                        System.out.println(product);
                        session.delete(product);
                    }
                }
                for (Orders orders : client.getOrders()) {
                    System.out.println(orders);
                    session.delete(orders);
                }
                System.out.println(client);
                session.delete(client);
                transaction.commit();
            } else {
                System.out.println("Не существует клиента с ID: " + client_id);
            }
        }
    }


    public void updateProductNameById(Long Product_id, String product_name) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            Product product = session.get(Product.class, Product_id);

            if (product != null) {
                System.out.println("Изменено " + product);

                product.setProductName(product_name);

                session.update(product);

                transaction.commit();
            } else {
                System.out.println("Не существует блюда с ID: " + Product_id);
            }
        }
    }


    public void addClient(String client_name, String client_fam) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            Client client = new Client(client_name, client_fam);

            System.out.println("Добавлено: " + client);

            session.persist(client);

            transaction.commit();
        }
    }

}