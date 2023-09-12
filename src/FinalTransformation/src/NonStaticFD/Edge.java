package NonStaticFD;

public class Edge {
public String edgeName;
public NonStaticFeature parentfeature;
public Annotations.Feature.Cardinality card;
public Annotations.Feature.Type type;
public enum Type {
	Mandatory, Optional
}
public  enum Cardinality {
	Onetomany ,Manytoone ,Manytomany
}
public Edge(String edge) {
	this.edgeName=edge;
}



}
