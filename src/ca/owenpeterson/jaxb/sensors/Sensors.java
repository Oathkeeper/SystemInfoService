package ca.owenpeterson.jaxb.sensors;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Sensors implements Serializable {

	private static final long serialVersionUID = -2313158679550959653L;
	
	private Date requestDate;
	private AdapterList adapters;
		
	public Sensors(AdapterList adapters) {
		this.adapters = adapters;
		this.requestDate = new Date();
	}
	
	public Sensors() {
		this.adapters = new AdapterList();
		this.requestDate = new Date();
	}
	
	public Date getRequestDate() {
		return requestDate;
	}

	public AdapterList getAdapters() {
		return adapters;
	}

	public void setAdapters(AdapterList adapters) {
		this.adapters = adapters;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}
	
	

}
