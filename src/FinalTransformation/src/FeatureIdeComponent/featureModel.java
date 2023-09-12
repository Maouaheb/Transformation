package FeatureIdeComponent;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class featureModel {
private Structure struct;

public Structure getStruct() {
	return struct;
}
@XmlElement
public void setStruct(Structure struct) {
	this.struct = struct;
}
public featureModel() {
	
}


public featureModel(Structure struct) {
	super();
	this.struct = struct;
}
}
