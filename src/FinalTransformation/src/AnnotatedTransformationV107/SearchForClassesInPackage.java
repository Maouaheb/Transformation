package AnnotatedTransformationV107;

import java.io.File;
import java.util.ArrayList;

public class SearchForClassesInPackage {
	 public static void search(final String pattern, final File folder, ArrayList<Class> result) throws ClassNotFoundException {
	        for (final File f : folder.listFiles()) {

	            if (f.isDirectory()) {
	                search(pattern, f, result);
	            }

	            if (f.isFile() ) {
	                if (f.getName().matches(pattern) && f.getName().endsWith(".java")) {
	                	//Class c=Class.forName( "Metamodel."+f.getName().substring(0, f.getName().length() - 5));
	                    result.add(Class.forName("AnnotatedMetamodel."+f.getName().substring(0, f.getName().length() - 5)));
	    	            //System.out.println(c.getName());

	                }
	            }
	        }//fin for
	    }// fin search
}
