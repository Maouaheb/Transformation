package NonStaticFD;

import java.util.ArrayList;
public class FeatureModel {
public  String nameModel;
public  ArrayList<NonStaticFD.NonStaticFeature> features;
private   boolean exists=true;
public FeatureModel() {
	features=new ArrayList();
}
public  void addFeatureInModel(NonStaticFeature feature) {
	String fname=feature.featureName;
 
	if(features.size() == 0) {
	features.add(feature);
	}
      
		int i=0;
		while(i< features.size())
		 {
			if(! (features.get(i).featureName.equals(fname)) ) {
			exists= false;			
			}
			else{
				exists = true;
						}
			i++;
		 }
			if(!exists) {
				features.add(feature);
			}
}


public  void removeFeatureInModel(NonStaticFeature feature) {
	features.remove(feature);
}


}
