package NonStaticFD;

import java.util.ArrayList;
import java.util.HashMap;

public class NonStaticFeature {
	public  String featureName;
	public  HashMap<NonStaticFD.NonStaticFeature, NonStaticFD.Edge> parentfils=new HashMap<>();
	public   ArrayList<Edge>  SubFeatures;
	public  HashMap<NonStaticFD.Constraint, NonStaticFD.NonStaticFeature> constraint=new HashMap<>();
	public  HashMap<NonStaticFD.OperatorFeatureSet,NonStaticFD.Edge> SubFeatureSet=new HashMap<>();
	public  HashMap<NonStaticFD.NonStaticFeature,NonStaticFD.Edge> XorFeatureSet=new HashMap<>();
	public  HashMap<NonStaticFD.NonStaticFeature,NonStaticFD.Edge> OrFeatureSet=new HashMap<>();
	public  Annotations.Feature.Cardinality card;
	public Annotations.Feature.Type type;
	public  enum Type {
		Mandatory, Optional	}
	public  enum Cardinality {
		Onetomany ,Manytoone ,Manytomany
	}
	
	public NonStaticFeature(String fname, int a) {
		this.featureName=fname;
		SubFeatures=new ArrayList<Edge>();
	}
	public NonStaticFeature(String fname) {
		this.featureName=fname;
		//this.SubFeatures= new ArrayList<>();
	}
	public   void addEdge(Edge e) {
		SubFeatures.add(e);
		
	}
	public  void removeEdge (NonStaticFeature f,Edge e) {
		SubFeatures.remove(e);
	}
	public void addOrEdge(NonStaticFeature feature, Edge edge) {
		OrFeatureSet.put(feature, edge);
	}
	public void addXorEdge(NonStaticFeature feature, Edge edge) {
		XorFeatureSet.put(feature, edge);
	}
	public void addGEdge(OperatorFeatureSet operator, Edge edge) {
		SubFeatureSet.put(operator, edge);
	}
	public void addConstraint(Constraint constraintFeature, NonStaticFeature feature) {
		constraint.put(constraintFeature, feature);
		// TODO Auto-generated method stub
		
	}

	public void copieAll(ArrayList testforme) {
		SubFeatures=new ArrayList<Edge>();
		
		SubFeatures.addAll(testforme);
		
	}
	
}
