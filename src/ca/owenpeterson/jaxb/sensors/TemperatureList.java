package ca.owenpeterson.jaxb.sensors;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class TemperatureList implements Serializable{

	private static final long serialVersionUID = 8568401739323702145L;

	@XmlElement(name="temperature")
	private List<Temperature> temperatureList;
	
	public TemperatureList(List<Temperature> temperatureList){
		this.temperatureList = temperatureList;
	}
	
	public TemperatureList(){
		this.temperatureList = new ArrayList<Temperature>();
	}

	public List<Temperature> getTemperatures() {
		return temperatureList;
	}

	public void setTemperatures(List<Temperature> temperatureList) {
		this.temperatureList = temperatureList;
	}
	
	public void add(Temperature temperature) {
		this.temperatureList.add(temperature);
	}
	
	public void remove(Temperature temperature) {
		this.temperatureList.remove(temperature);
	}
}
