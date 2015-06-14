package ca.owenpeterson.jaxb.sensors;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import ca.owenpeterson.utils.DateUtils;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Sensors implements Serializable {

	private static final long serialVersionUID = -2313158679550959653L;
	
	private String requestDate;
	private AdapterList adapters;
		
	public Sensors(AdapterList adapters) {
		this.adapters = adapters;
		this.requestDate = DateUtils.formatDateToString(new Date());
	}
	
	public Sensors() {
		this.adapters = new AdapterList();
		this.requestDate = DateUtils.formatDateToString(new Date());
	}
	
	public String getRequestDate() {
		return requestDate;
	}

	public AdapterList getAdapters() {
		return adapters;
	}

	public void setAdapters(AdapterList adapters) {
		this.adapters = adapters;
	}

	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}
}
