package ca.owenpeterson.jaxb.sensors;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Sensors implements Serializable {

	private static final long serialVersionUID = -2313158679550959653L;
	
	private AdapterList adapters;
	
	public Sensors(AdapterList adapters) {
		this.adapters = adapters;
	}
	
	public Sensors() {
		this.adapters = new AdapterList();		
	}

	public AdapterList getAdapters() {
		return adapters;
	}

	public void setAdapters(AdapterList adapters) {
		this.adapters = adapters;
	}

}
