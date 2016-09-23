package org.hibernate.tutorial.web;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.tutorial.domain.Event;
import org.hibernate.tutorial.domain.IPerson;
import org.hibernate.tutorial.domain.Person;
import org.hibernate.tutorial.util.HibernateUtil;

public class EventManager {
	private static final Logger LOG = Logger.getLogger(EventManager.class);

	public static class MyTest extends EventManager
	{
		private static Long event1Id;
		private static Long event2Id;
		private static Long event3Id;
		private static Long personId1;
		private static Long personId2;
		private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.GERMANY);

		public MyTest() {
			super();
		}

		public static void main(String[] args) {
			MyTest mgr = new MyTest();
			mgr.deleteAll();
			Calendar calendar = Calendar.getInstance(Locale.GERMANY);
			calendar.set(2014, 11, 12);
			event1Id = mgr.createAndStoreEvent("My Event 1", calendar.getTime());
			calendar.set(2015, 11, 12);
			event2Id = mgr.createAndStoreEvent("My Event 2", calendar.getTime());
			calendar.set(2016, 11, 12);
			event3Id = mgr.createAndStoreEvent("My Event 3", calendar.getTime());

			List<Event> events = mgr.listEvents();
			for (int i = 0; i < events.size(); i++) {
				Event theEvent = events.get(i);
				LOG.info("Event: " + theEvent.getTitle() + " Time: " + DATE_FORMAT.format(theEvent.getDate()));
			}

			personId1 = mgr.createAndStorePerson("Foo", "Bar");
			mgr.addPersonToEvent(personId1, event1Id);
			LOG.info("Added person " + personId1 + " to event " + event1Id);
			mgr.addPersonToEvent(personId1, event2Id);
			LOG.info("Added person " + personId1 + " to event " + event2Id);
			mgr.addPersonToEvent(personId1, event3Id);
			LOG.info("Added person " + personId1 + " to event " + event3Id);

			personId2 = mgr.createAndStorePerson("Foozy", "Beary");
			mgr.addEmailToPerson(personId2, "foo@bar");
			mgr.addEmailToPerson(personId2, "bar@foo");
			LOG.info("Added two email addresses (value typed objects) to person entity : " + personId2);

			LOG.info("Load Person1:");
			IPerson person1 = mgr.loadPerson(personId1);
			LOG.info("Load Person2:");
			IPerson person2 = mgr.loadPerson(personId2);
			List<Person> persons = mgr.listPersons();
//			for (Person person : persons) {
//				LOG.info("Person: " + person2.getId() + " " + person2.getFullName() + ", " + person2.getEventCount() + ", " + person2.getMinEventDatum());
//				Set<Event> personEvents = person2.getEvents();
//				for (Event event : personEvents) {
//					LOG.info("\tEvent: " + event.getId() + ", " + DATE_FORMAT.format(event.getDate()) + ", " + event.getTitle());
//				}
//			}
//			mgr.customHqlQueryPerson();
			HibernateUtil.getSessionFactory().close();
		}

		private IPerson loadPerson(Long personId) {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();

			session.beginTransaction();
			//			StringBuilder query = new StringBuilder("select person from org.hibernate.tutorial.domain.PersonEventView person where person.personId = :id");
			IPerson person = (IPerson) session.load("org.hibernate.tutorial.domain.Person", personId);
			LOG.info("Person: " + person.getId() + " " + person.getFullName() + ", " + person.getEventCount() + ", " + person.getMinEventDatum());
			Set<Event> personEvents = person.getEvents();
			for (Event event : personEvents) {
				LOG.info("\tEvent: " + event.getId() + ", " + DATE_FORMAT.format(event.getDate()) + ", " + event.getTitle());
			}
			session.getTransaction().commit();
			return person;
		}
	}


    public static void main(String[] args) {
        EventManager mgr = new EventManager();
        args = new String[]{"addpersontoevent", "list", "store", "addemailtoperson"};

        if (args[0].equals("store")) {
            mgr.createAndStoreEvent("My Event", new Date());
        }
        else if (args[0].equals("list")) {
            List events = mgr.listEvents();
            for (int i = 0; i < events.size(); i++) {
                Event theEvent = (Event) events.get(i);
                LOG.info("Event: " + theEvent.getTitle() +
                                   " Time: " + theEvent.getDate());
            }
        }
        else if (args[0].equals("addpersontoevent")) {
            Long eventId = mgr.createAndStoreEvent("My Event", new Date());
            Long personId = mgr.createAndStorePerson("Foo", "Bar");
            mgr.addPersonToEvent(personId, eventId);
            LOG.info("Added person " + personId + " to event " + eventId);
        }
        else if (args[0].equals("addemailtoperson")) {
            Long personId = mgr.createAndStorePerson("Foozy", "Beary");
            mgr.addEmailToPerson(personId, "foo@bar");
            mgr.addEmailToPerson(personId, "bar@foo");
            LOG.info("Added two email addresses (value typed objects) to person entity : " + personId);
        }

        HibernateUtil.getSessionFactory().close();
    }

    protected Long createAndStoreEvent(String title, Date theDate) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Event theEvent = new Event();
        theEvent.setTitle(title);
        theEvent.setDate(theDate);

        session.save(theEvent);

        session.getTransaction().commit();

        return theEvent.getId();
    }

    protected Long createAndStorePerson(String firstname, String lastname) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        IPerson thePerson = new Person();
        thePerson.setFirstname(firstname);
        thePerson.setLastname(lastname);

        @SuppressWarnings("unused")
		Serializable save = session.save(thePerson);

        session.getTransaction().commit();

        return thePerson.getId();
    }


    protected List<Event> listEvents() {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        List<Event> result = session.createQuery("from Event").list();

        session.getTransaction().commit();

        return result;
    }

    protected List<Person> listPersons() {

    	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    	session.beginTransaction();

    	Query query = session.createQuery("from Person");
//    	query.setReadOnly(true);
		List<Person> result = query.list();
    	for (IPerson person : result) {
			person.getAge();
			person.getEmailAddresses().size();
			person.getEvents().size();
			person.getEventCount();
//			person.getMinEventDatum().size();
		}
    	session.getTransaction().commit();

    	return result;
    }

    protected void addPersonToEvent(Long personId, Long eventId) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        IPerson aPerson = (IPerson) session
                .createQuery("select p from Person p left join fetch p.events where p.id = :pid")
                .setParameter("pid", personId)
                .uniqueResult(); // Eager fetch the collection so we can use it detached

        Event anEvent = (Event) session.load(Event.class, eventId);
        // If we want to handle it bidirectional and detached, we also need to load this
        // collection with an eager outer-join fetch, this time with Criteria and not HQL:
        /*
        Event anEvent = (Event) session
                .createCriteria(Event.class).setFetchMode("participants", FetchMode.JOIN)
                .add( Expression.eq("id", eventId) )
                .uniqueResult(); // Eager fetch the colleciton so we can use it detached
        */


        // End of first unit of work

		aPerson.addToEvent( anEvent );
        // or bidirectional safety method, setting both sides: aPerson.addToEvent(anEvent);

		session.getTransaction().commit();
        // Begin second unit of work

        Session session2 = HibernateUtil.getSessionFactory().getCurrentSession();
        session2.beginTransaction();

        session2.update(aPerson); // Reattachment of aPerson

        session2.getTransaction().commit();
    }

    protected void addEmailToPerson(Long personId, String emailAddress) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        IPerson aPerson = ( IPerson ) session.load(Person.class, personId);

        // The getEmailAddresses() might trigger a lazy load of the collection
        aPerson.getEmailAddresses().add(emailAddress);

        session.getTransaction().commit();
    }

    protected void deleteAll() {
    	List<Person> persons = listPersons();
    	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    	session.beginTransaction();
    	for (IPerson person : persons) {
			session.delete(person);
		}
    	session.getTransaction().commit();

    	List<Event> events = listEvents();
    	session = HibernateUtil.getSessionFactory().getCurrentSession();
    	session.beginTransaction();
    	for (Event event : events) {
    		session.delete(event);
		}
    	session.getTransaction().commit();
    }
}