package AnnotatedTransformationV107;

import java.lang.annotation.Annotation;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;
import java.util.Map.Entry;
import Annotations.Variant.FeatureSet2;
import NonStaticFD.*;
public class GetSubFeatures {	 
	public static void getSubFeatures(ArrayList<Class> files, NonStaticFD.FeatureModel fm) throws IllegalArgumentException, IllegalAccessException, ClassNotFoundException{
	 	
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

	if(a.annotationType().getName().equals("Annotations.Feature") || a.annotationType().getName().equals("Annotations.Root") ) {
		feature	=new NonStaticFeature(classe.getName(),1);
		if(a.annotationType().getName().equals("Annotations.Feature")) {
			Annotations.Feature featureannotation=(Annotations.Feature)a;
			//System.out.println("******************************   le feature "+feature.featureName+" cardinalité"+featureannotation.cardinality().toString());
			feature.card=featureannotation.cardinality();
			feature.type=featureannotation.typeFeature();
		}
		fm.addFeatureInModel(feature);
		for(int i=0;i<champs.length ;i++) {
        	if(champs[i].getType().getName() != classe.getName() && files2.contains(champs[i].getType())){
        		Annotation[] annota=champs[i].getType().getAnnotations();
        		for(Annotation aa:annota) {
                	if(aa.annotationType().getName().equals("Annotations.Feature")) {
                		Annotations.Feature f=(Annotations.Feature) aa;
                		edge=new Edge(champs[i].getType().getName());
                		edge.card=f.cardinality();
                    	edge.type=f.typeFeature();
                    	testforme.add(edge);
                		feature.addEdge(edge);
            			feature.parentfils.put(feature, edge);
               
                	}
        		}
        		
        	}
        }	
		
	}
            }
    	    
	    }// end of function
	      
	  }}
	
	

