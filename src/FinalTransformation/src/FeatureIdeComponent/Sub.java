package FeatureIdeComponent;

import java.util.HashSet;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Sub {
private HashSet<Feature> feature;
private String NameOfFeature;
private String mandatory;
private HashSet<Sub> loopSub;
private HashSet<OrSet> orSets;
private HashSet<XorSet> xorSets;
public HashSet<XorSet> getXorSets() {
	return xorSets;
}
@XmlElement(name="alt")
public void setXorSets(HashSet<XorSet> xorSets) {
	this.xorSets = xorSets;
}
public HashSet<OrSet> getOrSets() {
	return orSets;
}
@XmlElement(name="or")
public void setOrSets(HashSet<OrSet> orSets) {
	this.orSets = orSets;
}
public void addXOrSets(XorSet xor) {
	this.xorSets.add(xor);
}
public HashSet<Sub> getLoopSub() {
	return loopSub;
}
@XmlElement(name="and")
public void setLoopSub(HashSet<Sub> loopSub) {
	this.loopSub = loopSub;
}
public void addLoopSub(Sub s) {
	loopSub.add(s);
}

public HashSet<Feature> getFeature() {
	return feature;
}
@XmlElement(name="feature")
public void setFeature(HashSet<Feature> feature2) {
	this.feature = feature2;
}
@XmlAttribute(name = "name")
public String getNameOfFeature() {
	return NameOfFeature;
}

public void setNameOfFeature(String nameOfFeature) {
	NameOfFeature = nameOfFeature;
}
public String getMandatory() {
	return mandatory;
}
@XmlAttribute(name = "mandatory")
public void setMandatory(String mandatory) {
	this.mandatory = mandatory;
}

public Sub(HashSet<Feature> feature, String nameOfFeature, String mandatory) {
	super();
	this.feature = feature;
	NameOfFeature = nameOfFeature;
	this.mandatory = mandatory;
}

public Sub(HashSet<Feature> feature, String nameOfFeature) {
	super();
	this.feature = feature;
	NameOfFeature = nameOfFeature;
}

public Sub(HashSet<Feature> feature, String nameOfFeature, String mandatory, HashSet<Sub>loopSub) {
	super();
	this.feature = feature;
	NameOfFeature = nameOfFeature;
	this.mandatory = mandatory;
	this.loopSub=loopSub;
}
public Sub(String name) {
	this.NameOfFeature=name;
}
public Sub(String name, String mandatory) {
	this.NameOfFeature=name;
	this.mandatory=mandatory;
}
public Sub() {
	
}
}
