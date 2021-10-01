package com.degloba.domain.event;

import java.io.Serializable;
import java.util.Date;


public class DomainEventSub extends ADomainEvent implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String prop1;

    private String prop2;



    public DomainEventSub(Date occurredOn) {
        super(occurredOn);
    }

    public DomainEventSub(Date occurredOn, int version) {
        super(occurredOn, version);
    }


	@Override
    public void setId(String id) {
        super.setId(id);
    }

    public String getProp1() {
        return prop1;
    }

    public void setProp1(String prop1) {
        this.prop1 = prop1;
    }

    public String getProp2() {
        return prop2;
    }

    public void setProp2(String prop2) {
        this.prop2 = prop2;
    }

	public Object getId() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getVersion() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getOccurredOn() {
		// TODO Auto-generated method stub
		return null;
	}
}
