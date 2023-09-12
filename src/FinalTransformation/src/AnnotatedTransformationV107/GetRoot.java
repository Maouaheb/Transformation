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

public class GetRoot {
	public static void getRoot(ArrayList<Class> files, NonStaticFD.FeatureModel fm) throws IllegalArgumentException, IllegalAccessException, ClassNotFoundException{
	 	
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
        	if(a.annotationType().getName().equals("Annotations.Root")) {
        		NonStaticFD.Root rt=new Root(classe.getName());
    			fm.addFeatureInModel(rt);
        		System.out.println("le root "+rt.featureName);

        	}
        }
        }
	    
  }// end of function
    
}
