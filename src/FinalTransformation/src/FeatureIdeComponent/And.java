package FeatureIdeComponent;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class And {
	private List<Feature> feature;
	private String NameOfFeature;
	private String mandatory;
	private List<And> and;
	public List<And> getAnd() {
		return and;
	}
	@XmlElement(name="and")
	public void setAnd(List<And> and) {
		this.and = and;
	}
	public List<Feature> getFeature() {
		return feature;
	}
	@XmlElement(name="feature")
	public void setFeature(List<Feature> feature) {
		this.feature = feature;
	}
	@XmlAttribute(name = "name")
	public String getNameOfFeature() {
		return NameOfFeature;
	}
	public void setNameOfFeature(String nameOfFeature) {
		NameOfFeature = nameOfFeature;
	}
	@XmlAttribute(name = "mandatory")
	public String getMandatory() {
		return mandatory;
	}
	public void setMandatory(String mandatory) {
		this.mandatory = mandatory;
	}
	public And(String NameOfFeature, String mandatory, List<Feature> feature) {
		this.NameOfFeature=NameOfFeature;
		this.mandatory=mandatory;
		this.feature=feature;
	}
	public And(String NameOfFeature, String mandatory, List<Feature> feature, List<And> and) {
		this.NameOfFeature=NameOfFeature;
		this.mandatory=mandatory;
		this.feature=feature;
		this.and=and;
	}
	
}
