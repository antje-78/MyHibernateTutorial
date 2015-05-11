package org.hibernate.tutorial.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Person implements Serializable {

    private Long id;
    private int age;
    private String firstname;
    private String lastname;
    private Set minEventDatum;
    private Long eventCount;

    public Person() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }


    private Set<String> emailAddresses = new HashSet<String>();

    public Set<String> getEmailAddresses() {
        return emailAddresses;
    }

    public void setEmailAddresses(Set<String> emailAddresses) {
        this.emailAddresses = emailAddresses;
    }


    private Set<Event> events = new HashSet<Event>();

    // Defensive, convenience methods
    public Set<Event> getEvents() {
        return events;
    }

    protected void setEvents(Set<Event> events) {
        this.events = events;
    }

    public void addToEvent(Event event) {
        this.getEvents().add(event);
        event.getParticipants().add(this);
    }

    public void removeFromEvent(Event event) {
        this.getEvents().remove(event);
        event.getParticipants().remove(this);
    }

	/**
	 * @return the minEventDatum
	 */
	public Set getMinEventDatum() {
		return minEventDatum;
	}

	/**
	 * @param minEventDatum the minEventDatum to set
	 */
	public void setMinEventDatum(Set minEventDatum) {
		this.minEventDatum = minEventDatum;
	}

	/**
	 * @return the eventCount
	 */
	public Long getEventCount() {
		return eventCount;
	}

	/**
	 * @param eventCount the eventCount to set
	 */
	public void setEventCount(Long eventCount) {
		this.eventCount = eventCount;
	}

	public String getFullName() {
		StringBuilder out = new StringBuilder(this.getFirstname());
		if(this.getFirstname() != null && this.getFirstname().length() > 0)
			out.append(" ");
		out.append(this.getLastname());
		return out.toString();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Person [id=").append(id).append(", age=").append(age)
				.append(", firstname=").append(firstname).append(", lastname=")
				.append(lastname).append("]");
		return builder.toString();
	}


}