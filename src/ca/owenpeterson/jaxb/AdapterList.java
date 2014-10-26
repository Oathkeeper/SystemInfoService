package ca.owenpeterson.jaxb;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class AdapterList {
	
	private List<Adapter> adapterList;
	
	public AdapterList(List<Adapter> adapters) {
		this.adapterList = adapters;
		
	}
	
	public AdapterList(){
		this.adapterList = new ArrayList<Adapter>();
	}

	public List<Adapter> getAdapters() {
		return adapterList;
	}

	public void setAdapters(List<Adapter> adapters) {
		this.adapterList = adapters;
	}
	
	public void add(Adapter adapter) {
		this.adapterList.add(adapter);
	}
	
	

}
