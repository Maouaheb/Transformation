package FeatureIdeComponent;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class Structure {
	
private MainAnd and;


public MainAnd getAnd() {
	return and;
}
@XmlElement
public void setAnd(MainAnd and) {
	this.and = and;
}
}
