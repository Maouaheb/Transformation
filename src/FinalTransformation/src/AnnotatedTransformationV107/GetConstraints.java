package AnnotatedTransformationV107;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;
import java.util.Map.Entry;
import Annotations.Variant.FeatureSet2;
import NonStaticFD.*;
public class GetConstraints {

public static void getConstrainys(ArrayList<Class> files, NonStaticFD.FeatureModel fm) throws IllegalArgumentException, IllegalAccessException, ClassNotFoundException{
	 	
		HashMap<Class, Vector> listeOfClasses=new HashMap<>();
	 	ArrayList<Class> files2 = new ArrayList<>();
	    files2=files;
	    NonStaticFD.NonStaticFeature feature;
	    NonStaticFD.Edge edge;
	    for (Class classe : files) {
        	Field[] champs=classe.getDeclaredFields();
        	Annotation[] annotations= classe.getAnnotations();
            for(Annotation a:annotations) {
	
            	if(a.annotationType().getName().equals("Annotations.Constraint")) {
            		Annotations.Constraint constraint=(Annotations.Constraint) a;
            		feature	=new NonStaticFeature(classe.getName());
            		fm.addFeatureInModel(feature);
            		if(constraint.constraint().toString().equals("Mutex")) {
            			Constraint constraintFeature=new Constraint("Mutex");
            			NonStaticFeature mutexf=new NonStaticFeature(constraint.ConstrainedClass().getName());
            			feature.addConstraint(constraintFeature, mutexf);
            			//System.out.println(feature.featureName+" contrainte  "+constraint.constraint()+" avec  "+mutexf.featureName);

            		}
            		if(constraint.constraint().toString().equals("Require")) {
            			Constraint constraintFeature=new Constraint("Require");
            			NonStaticFeature reqf=new NonStaticFeature(constraint.ConstrainedClass().getName());
            			feature.addConstraint(constraintFeature, reqf);	
            			//System.out.println(feature.featureName+" contrainte  "+constraint.toString()+" avec  "+reqf.featureName);

            		}
            	}
            }
       }//end for classes
    	    
      }// end of function
        
	
}// end of class
