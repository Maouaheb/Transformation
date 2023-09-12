package FeatureIdeComponent;

import java.util.HashSet;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class XorSet {
	private List<Feature> feature;
	private String NameOfFeature;
	private HashSet<Sub> loopSub;
	private List<OrSet> orSet;
	private HashSet<XorSet> xorSet;
	private String type;
	public String getType() {
		return type;
	}
	@XmlAttribute(name="mandatory")
	public void setType(String type) {
		this.type = type;
	}
	public HashSet<XorSet> getXorSet() {
		return xorSet;
	}
	@XmlElement(name="alt")
	public void setXorSet(HashSet<XorSet> xorsett) {
		this.xorSet = xorsett;
	}
	public void addLoopSub(Sub s) {
		this.loopSub.add(s);
	}
	public List<Feature> getFeature() {
		return feature;
	}
	@XmlElement(name="feature")
	public void setFeature(List<Feature> feature) {
		this.feature = feature;
	}
	@XmlAttribute(name="name")
	public String getNameOfFeature() {
		return NameOfFeature;
	}
	public void setNameOfFeature(String nameOfFeature) {
		NameOfFeature = nameOfFeature;
	}
	public HashSet<Sub> getLoopSub() {
		return loopSub;
	}
	@XmlElement(name="and")
	public void setLoopSub(HashSet<Sub> loopSub) {
		this.loopSub = loopSub;
	}
	public List<OrSet> getOrSet() {
		return orSet;
	}
	@XmlElement(name="or")
	public void setOrSet(List<OrSet> orsett2) {
		this.orSet = orsett2;
	}
	public XorSet(String nameFeature, List<Feature> feature) {
		this.NameOfFeature=nameFeature;
		this.feature=feature;
	}
	public XorSet(String nameFeature) {
		this.NameOfFeature=nameFeature;
	}
	
}
