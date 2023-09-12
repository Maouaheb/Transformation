package AnnotatedMetamodel;

import Annotations.Root;

@Root
public class Application{
////*** Déclaration des sous features *** ////
public  FeatureOffered feature;
public  Persona typepassenger;
public  Platform plateform;

public Application() {
feature=new FeatureOffered();
typepassenger = new Persona();
plateform=new Platform();
}
}