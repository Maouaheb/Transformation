package AnnotatedTransformationV107;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import java.util.Map.Entry;

import Annotations.Feature.Cardinality;
import Annotations.Feature.Type;
import Annotations.Variant.FeatureSet2;
import NonStaticFD.*;
import Annotations.Vp;
public class GetVariationPointsAndVariants {
	 
	public static void getVariationPointsAndVariants(ArrayList<Class> files, NonStaticFD.FeatureModel fm) throws IllegalArgumentException, IllegalAccessException, ClassNotFoundException{
	 	
		HashMap<Class, Vector> listeOfClasses=new HashMap<>();
	 	ArrayList<Class> files2 = new ArrayList<>();
	    files2=files;
	    NonStaticFD.NonStaticFeature feature;
	    NonStaticFD.Edge edge;
	    ArrayList testforme ;
	    for (Class classe : files) {
	    	testforme=new ArrayList<Edge>();
        	Field[] champs=classe.getDeclaredFields();
        	Vector variable=new Vector();
        	Annotation[] annotations= classe.getAnnotations();
            for(Annotation a:annotations) {
            	if(a.annotationType().getName().equals("Annotations.VariationPoint")) {
            		feature	=new NonStaticFeature(classe.getName());
    				fm.addFeatureInModel(feature);
            		Annotations.VariationPoint vp=(Annotations.VariationPoint) a;
            		if(vp.vp().toString().equals("Or")) {
            		for(int i=0;i<vp.variants().length;i++) {
            			edge=new Edge(vp.variants()[i].getName());
            			feature.addOrEdge(feature, edge);
            			OperatorFeatureSet op=new OperatorFeatureSet("Or");
            			feature.addGEdge(op, edge);


            		}
            	}
            		if(vp.vp().toString().equals("Xor")) {
                		for(int i=0;i<vp.variants().length;i++) {
                			edge=new Edge(vp.variants()[i].getName());
                			feature.addXorEdge(feature, edge);
                			OperatorFeatureSet op=new OperatorFeatureSet("Xor");
                			feature.addGEdge(op, edge);


                		}
            		}
            	}
            	if(a.annotationType().getName().equals("Annotations.Vp")) {
            		Annotations.Vp vp= (Annotations.Vp) a;
            		feature	=new NonStaticFeature(classe.getName());
    				fm.addFeatureInModel(feature);
            		for(int i=0;i<vp.value().length;i++) {
            			if(vp.value()[i].vp().toString().equals("Or")) {
                    		for(int j=0;j<vp.value()[i].variants().length;j++) {
                    			edge=new Edge(vp.value()[i].variants()[j].getName());
                    			feature.addOrEdge(feature, edge);
                    			OperatorFeatureSet op=new OperatorFeatureSet("Or");
                    			feature.addGEdge(op, edge);


                    		}

            			}
            			if(vp.value()[i].vp().toString().equals("Xor")) {
            				for(int j=0;j<vp.value()[i].variants().length;j++) {
                    			edge=new Edge(vp.value()[i].variants()[j].getName());
                    			feature.addOrEdge(feature, edge);
                    			OperatorFeatureSet op=new OperatorFeatureSet("Xor");
                    			feature.addGEdge(op, edge);


                    		}
            			}
            		}
            	}
            		
           
            }
        }
	    
  }// end of function
    
}
