package ca.owenpeterson.jaxb.sensors;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Temperature implements Serializable {

	private static final long serialVersionUID = -4502147118772744355L;

	private String name;
	private String value;
	
	public Temperature(String name, String value) {
		this.name = name;
		this.value = value;
	}
	
	public Temperature(){}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
