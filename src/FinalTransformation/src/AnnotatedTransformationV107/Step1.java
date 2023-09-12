package AnnotatedTransformationV107;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Vector;

import FeatureIdeComponent.*;
import NonStaticFD.*;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
public class Step1 {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		   final File folder = new File("C:/Users/belarbim/Desktop/eclipse-workspace/FinalTransformation/src/AnnotatedMetamodel");
	       String rootName="";
		   ArrayList<Class> files = new ArrayList<>();
	       SearchForClassesInPackage.search(".*\\.java", folder, files);;
    	   NonStaticFD.FeatureModel fm=new FeatureModel();
    	   GetRoot.getRoot(files, fm);
      	   GetConstraints.getConstrainys(files, fm);
 	       GetSubFeatures.getSubFeatures(files,fm);
	       GetVariationPointsAndVariants.getVariationPointsAndVariants(files, fm); 
	   	   List<Feature> feature = new ArrayList<Feature>();
	   	   List<Sub> listeOfSub=new ArrayList<Sub>();
	   	   Structure struct= new Structure();
	   	   Boolean built=false;
	   	   List<Feature> feuilleRoot=new ArrayList<Feature>();
	   	   ArrayList<String> done=new ArrayList<String>();
	   	   ///////////////***********Construire niveau 0 et niveau 1***********///////////////
	   	   for(int i=0;i<fm.features.size();i++) {
	   		   if(fm.features.get(i).getClass().getName().equals("NonStaticFD.Root")) {
	    		  rootName=fm.features.get(i).featureName;
	    		  System.out.println("the root is "+rootName);
	    		  }
	   		   if(fm.features.get(i).featureName.equals(rootName) && fm.features.get(i).SubFeatures !=null) {
	   			   for(int j=0;j<fm.features.get(i).SubFeatures.size();j++) {
	   				   boolean groupSet=false;
	   				   for(int k=0; k<fm.features.size();k++) {
	   					   if(fm.features.get(i).SubFeatures.get(j).edgeName.equals(fm.features.get(k).featureName)&&fm.features.get(k).SubFeatureSet.size()>0)  {
	    				   	  System.out.println(fm.features.get(k).featureName);
	  	    				  feature.add(new Feature(fm.features.get(i).SubFeatures.get(j).edgeName,fm.features.get(k).SubFeatureSet)); 
	  	    				  groupSet=true;

	    					}
	   				   }
	    				  if(groupSet==false) {
    					  feature.add(new Feature(fm.features.get(i).SubFeatures.get(j).edgeName)); 
	    				  }
		    			}
	    		}
	   		
	   		   }
	   	   PlacementRécursif level=new PlacementRécursif();
	   	   HashSet<Sub> subelements=new HashSet();
	   	   MainAnd and= new MainAnd(feuilleRoot, "true", "true",rootName,subelements);
	   	   for(int j=0;j<fm.features.size();j++) {
	   		   HashMap<NonStaticFD.OperatorFeatureSet, NonStaticFD.Edge> subfeaturesSet=new HashMap<OperatorFeatureSet, Edge>();;
	   		   for(int i=0;i<feature.size();i++) {
	   			   ArrayList<Feature> feature2 = new ArrayList<>();
	   			   if(feature.get(i).getName().toString().equals(fm.features.get(j).featureName)) {
	   				   if(fm.features.get(j).SubFeatures != null) {
	   					   if(fm.features.get(j).SubFeatures == null || fm.features.get(j).SubFeatures.size() ==0) {
	   						feuilleRoot.add(new Feature(fm.features.get(j).featureName));	
	   					   }	
	   					   if(feature.get(i).getSubFeatureSet()!=null) { 
	   						   if(feature.get(i).getSubFeatureSet().size()>0) {
	   							   subfeaturesSet.putAll(feature.get(i).getSubFeatureSet());
	   						   }
	   					   }
	   							
   			  System.out.println("////////////// Fonction Main ////////////////   "+fm.features.get(j).featureName);
   			  	boolean level1=true;
					level.buildAllLevels(fm,fm.features.get(j) , fm.features.get(j).SubFeatures, null,subelements, subfeaturesSet,level1,and);


	   				}
	   				   }
	   			   }
	   		
	   	}
	   		   		
	   	
	   	
	   	   ///////////////***********  Marshalling  ***********///////////////
	   	 
	   
	       try {
	   	   	and.setLevel(subelements);
	   	   	and.setFeature(feuilleRoot);
	   		struct.setAnd(and);
	   		//Create struct object
	   		featureModel featureModel = new featureModel(struct);
	   	 
	   		//create JAXB context
	   		JAXBContext context = JAXBContext.newInstance(featureModel.class);
	   		//Create Marshaller using JAXB context
	   		Marshaller marshaller = context.createMarshaller();
	   		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	   	 
	   		//Do the marshal operation
	   		marshaller.marshal(featureModel, 
	   	                       new FileOutputStream("C:/Users/belarbim/Desktop/eclipse-workspace/FinalTransformation/src/fd.xml"));
	   		System.out.println("java object converted to xml successfully.");
	   	    } catch (Exception e) {
	   		e.printStackTrace();
	   	    }
	   	 
	
	}//fin main
	}//fin classe
	       

	       	
	 	 
	
	
	    

	    
	    

