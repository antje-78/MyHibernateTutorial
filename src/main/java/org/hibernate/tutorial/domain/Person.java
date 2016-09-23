package org.hibernate.tutorial.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Person implements IPerson  {

    private Long id;
    private int age;
    private String firstname;
    private String lastname;
    private Date minEventDatum;
    private Long eventCount;

    public Person() {}

    /* (non-Javadoc)
	 * @see org.hibernate.tutorial.domain.IPerson2#getId()
	 */
    @Override
	public Long getId() {
        return id;
    }

    /* (non-Javadoc)
	 * @see org.hibernate.tutorial.domain.IPerson2#setId(java.lang.Long)
	 */
    @Override
	public void setId(Long id) {
        this.id = id;
    }

    /* (non-Javadoc)
	 * @see org.hibernate.tutorial.domain.IPerson2#getAge()
	 */
    @Override
	public int getAge() {
        return age;
    }

    /* (non-Javadoc)
	 * @see org.hibernate.tutorial.domain.IPerson2#setAge(int)
	 */
    @Override
	public void setAge(int age) {
        this.age = age;
    }

    /* (non-Javadoc)
	 * @see org.hibernate.tutorial.domain.IPerson2#getFirstname()
	 */
    @Override
	public String getFirstname() {
        return firstname;
    }

    /* (non-Javadoc)
	 * @see org.hibernate.tutorial.domain.IPerson2#setFirstname(java.lang.String)
	 */
    @Override
	public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /* (non-Javadoc)
	 * @see org.hibernate.tutorial.domain.IPerson2#getLastname()
	 */
    @Override
	public String getLastname() {
        return lastname;
    }

    /* (non-Javadoc)
	 * @see org.hibernate.tutorial.domain.IPerson2#setLastname(java.lang.String)
	 */
    @Override
	public void setLastname(String lastname) {
        this.lastname = lastname;
    }


    private Set<String> emailAddresses = new HashSet<String>();

    /* (non-Javadoc)
	 * @see org.hibernate.tutorial.domain.IPerson2#getEmailAddresses()
	 */
    @Override
	public Set<String> getEmailAddresses() {
        return emailAddresses;
    }

    /* (non-Javadoc)
	 * @see org.hibernate.tutorial.domain.IPerson2#setEmailAddresses(java.util.Set)
	 */
    @Override
	public void setEmailAddresses(Set<String> emailAddresses) {
        this.emailAddresses = emailAddresses;
    }


    private Set<Event> events = new HashSet<Event>();

    // Defensive, convenience methods
    /* (non-Javadoc)
	 * @see org.hibernate.tutorial.domain.IPerson2#getEvents()
	 */
    @Override
	public Set<Event> getEvents() {
        return events;
    }

    protected void setEvents(Set<Event> events) {
        this.events = events;
    }

    /* (non-Javadoc)
	 * @see org.hibernate.tutorial.domain.IPerson2#addToEvent(org.hibernate.tutorial.domain.Event)
	 */
    @Override
	public void addToEvent(Event event) {
        this.getEvents().add(event);
        event.getParticipants().add(this);
    }

    /* (non-Javadoc)
	 * @see org.hibernate.tutorial.domain.IPerson2#removeFromEvent(org.hibernate.tutorial.domain.Event)
	 */
    @Override
	public void removeFromEvent(Event event) {
        this.getEvents().remove(event);
        event.getParticipants().remove(this);
    }

	/* (non-Javadoc)
	 * @see org.hibernate.tutorial.domain.IPerson2#getMinEventDatum()
	 */
	@Override
	public Date getMinEventDatum() {
		return minEventDatum;
	}

	/* (non-Javadoc)
	 * @see org.hibernate.tutorial.domain.IPerson2#setMinEventDatum(java.util.Date)
	 */
	@Override
	public void setMinEventDatum(Date minEventDatum) {
		this.minEventDatum = minEventDatum;
	}

	/* (non-Javadoc)
	 * @see org.hibernate.tutorial.domain.IPerson2#getEventCount()
	 */
	@Override
	public Long getEventCount() {
		return eventCount;
	}

	/* (non-Javadoc)
	 * @see org.hibernate.tutorial.domain.IPerson2#setEventCount(java.lang.Long)
	 */
	@Override
	public void setEventCount(Long eventCount) {
		this.eventCount = eventCount;
	}

	/* (non-Javadoc)
	 * @see org.hibernate.tutorial.domain.IPerson2#getFullName()
	 */
	@Override
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
		builder.append("Person [id=").append(id)
			.append(", age=").append(age)
			.append(", firstname=").append(firstname)
			.append(", lastname=").append(lastname)
			.append(", eventCount=").append(eventCount)
			.append(", minEventDate=").append(minEventDatum)
		.append("]");
		return builder.toString();
	}


}