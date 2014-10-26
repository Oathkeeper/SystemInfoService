package ca.owenpeterson.jaxb;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class TemperatureList {

	private List<Temperature> temperatures;
	
	public TemperatureList(List<Temperature> temperatures){
		this.temperatures = temperatures;
	}
	
	public TemperatureList(){
		this.temperatures = new ArrayList<Temperature>();
	}

	public List<Temperature> getTemperatures() {
		return temperatures;
	}

	public void setTemperatures(List<Temperature> temperatures) {
		this.temperatures = temperatures;
	}
	
	public void add(Temperature temperature) {
		this.temperatures.add(temperature);
	}
	
	public void remove(Temperature temperature) {
		this.temperatures.remove(temperature);
	}
}
