package FeatureIdeComponent;

import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.bind.annotation.XmlAttribute;

import NonStaticFD.*;
public class Feature {
public HashMap<NonStaticFD.OperatorFeatureSet, NonStaticFD.Edge> getSubFeatureSet() {
		return SubFeatureSet;
	}

	public void setSubFeatureSet(HashMap<NonStaticFD.OperatorFeatureSet, NonStaticFD.Edge> subFeatureSet) {
		SubFeatureSet = subFeatureSet;
	}
private String name;
private String type;
private HashMap<NonStaticFD.OperatorFeatureSet,NonStaticFD.Edge> SubFeatureSet;



public String getType() {
	return type;
}
@XmlAttribute(name = "mandatory")
public void setType(String type) {
	this.type = type;
}

@XmlAttribute(name = "name")
public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public Feature(String name, String type) {
	this.name = name;
	this.type=type;
}
public Feature(String name, HashMap<OperatorFeatureSet,Edge> set) {
	this.name=name;
	this.SubFeatureSet=set;
}
public Feature(String name) {
	this.name=name;
}

}