package AnnotatedMetamodel2;

import Annotations.Root;

@Root
public class Application{

public  Train train;
public  typePassenger typepassenger;
public  Plateform plateform;

public Application() {
train=new Train();
typepassenger = new typePassenger();
}
}