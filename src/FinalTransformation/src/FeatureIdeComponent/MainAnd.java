package FeatureIdeComponent;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class MainAnd {
private List<Feature> feature;
private String abs;
private String Root;
private String mandatory;
private HashSet<Sub> level;
private List<OrSet> orSets;
private List<XorSet> xorSets;
@XmlElement(name="or")
public void setOrSets(List<OrSet> orSets) {
	this.orSets = orSets;
}
@XmlElement(name="alt")
public void setXorSets(List<XorSet> xorSets) {
	this.xorSets = xorSets;
}
public List<XorSet> getXorSets() {
	return xorSets;
}
public List<OrSet> getOrSets() {
	return orSets;
}
public MainAnd() {
	
}
public MainAnd(List<Feature> feature, String abs,String mandatory, String Root, HashSet<Sub> liste) {
	this.abs=abs;
	this.feature=feature;
	this.mandatory=mandatory;
	this.Root=Root;
	this.level=liste;
	

}
public List<Feature> getFeature() {
	return feature;
}
public void addOrList(OrSet or) {
	if(orSets == null) {
		orSets=new ArrayList<OrSet>();
	}
	this.orSets.add(or);
}
public void addXorList(XorSet xor) {
	if(xorSets == null) {
		xorSets=new ArrayList<XorSet>();
	}
	this.xorSets.add(xor);
}
@XmlElement
public void setFeature(List<Feature> feature) {
	this.feature = feature;
}
@XmlAttribute(name = "abstract")
public String getAbs() {
	return abs;
}
public void setAbs(String abs) {
	this.abs = abs;
}
@XmlAttribute(name = "name")
public String getRoot() {
	return Root;
}
public void setRoot(String Root) {
	this.Root = Root;
}
@XmlAttribute(name = "mandatory")
public String getMandatory() {
	return mandatory;
}
public void setMandatory(String mandatory) {
	this.mandatory = mandatory;
}

public HashSet<Sub> getLevel() {
	return level;
}
@XmlElement(name="and")
public void setLevel(HashSet<Sub> level) {
	this.level = level;
}

}
