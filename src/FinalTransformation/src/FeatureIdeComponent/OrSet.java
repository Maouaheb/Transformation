package FeatureIdeComponent;

import java.util.HashSet;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class OrSet  {
	private List<Feature> feature;
	private String NameOfFeature;
	private HashSet<Sub> loopSub;
	private HashSet<OrSet> orSet;
	private String type;
	public String getType() {
		return type;
	}
	@XmlAttribute(name="mandatory")
	public void setType(String type) {
		this.type = type;
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
	public void addLoopSub(Sub s) {
		this.loopSub.add(s);
	}
	public HashSet<OrSet> getOrSet() {
		return orSet;
	}
	@XmlElement(name="or")
	public void setOrSet(HashSet<OrSet> orSet) {
		this.orSet = orSet;
	}
	public OrSet(String nameFeature, List<Feature> feature) {
		this.NameOfFeature=nameFeature;
		this.feature=feature;
	}
	public OrSet(String nameFeature) {
		this.NameOfFeature=nameFeature;
	}

	public void addToListOr(OrSet or) {
		orSet.add(or);
	}
}
