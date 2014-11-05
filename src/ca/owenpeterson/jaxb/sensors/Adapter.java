package ca.owenpeterson.jaxb.sensors;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class Adapter implements Serializable {

	private static final long serialVersionUID = 928447747625593995L;

	private String name;
	private String type;
	private TemperatureList temperatures;
	
	public Adapter(String name, String type, TemperatureList temperatures) {
		this.name = name;
		this.type = type;
		this.temperatures = temperatures;
	}
	
	public Adapter(){}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public TemperatureList getTemperatures() {
		return temperatures;
	}
	public void setTemperatures(TemperatureList temperatures) {
		this.temperatures = temperatures;
	}
	
	

}
