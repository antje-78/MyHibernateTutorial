package org.hibernate.tutorial.web;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.tutorial.domain.*;
import org.hibernate.tutorial.util.HibernateUtil;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;

public class OrderManager {
	private static final Logger LOG = Logger.getLogger(OrderManager.class);


    public static void main(String[] args) {
        OrderManager mgr = new OrderManager();

        if (args[0].equals("store")) {
            mgr.createAndStore();
        }
        else if (args[0].equals("list")) {
            List events = mgr.list();
            for (int i = 0; i < events.size(); i++) {
                Event theEvent = (Event) events.get(i);
                LOG.info("Event: " + theEvent.getTitle() +
                                   " Time: " + theEvent.getDate());
            }
        }

        HibernateUtil.getSessionFactory().close();
    }

    protected Order.Id createAndStore() {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

		Product product = new Product();
		product.setProductId(100);
		product.setPrice(12.50);
		product.setDescription("Product 1");
		product.setNumberAvailable(100);
		product.setNumberOrdered(50);
		session.save(product);
		session.flush();

		Customer customer = new Customer();
		customer.setCustomerId(200);
		customer.setName("Herr Lehmann");
		customer.setAddress("Franz-List-Straße 21");



		List<Order> orders = new ArrayList<Order>();
		customer.setOrders(orders);
		Order order = new Order();
		order.setId(new Order.Id(customer.getCustomerId(), 300));
		order.setCustomer(customer);
		order.setOrderDate(Calendar.getInstance(Locale.GERMANY));
		orders.add(order);

		session.save(customer);
		session.flush();

		List<LineItem> lineItems = new ArrayList<>();
		order.setLineItems(lineItems);
		LineItem lineItem = new LineItem();
		lineItem.setId(new LineItem.Id(customer.getCustomerId(), order.getId().getOrderNumber(), product.getProductId()));
//		lineItem.setOrder(order);
		lineItem.setQuantity(10);
		lineItems.add(lineItem);
//		lineItem.setProduct(product);

		session.save(customer);

        session.getTransaction().commit();

        return order.getId();
    }

    protected List<Event> list() {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        List<Event> result = session.createQuery("from Customer ").list();

        session.getTransaction().commit();

        return result;
    }


    protected void deleteAll() {
//    	List<Person> persons = listPersons();
//    	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//    	session.beginTransaction();
//    	for (IPerson person : persons) {
//			session.delete(person);
//		}
//    	session.getTransaction().commit();
//
//    	List<Event> events = listEvents();
//    	session = HibernateUtil.getSessionFactory().getCurrentSession();
//    	session.beginTransaction();
//    	for (Event event : events) {
//    		session.delete(event);
//		}
//    	session.getTransaction().commit();
    }
}