package AnnotatedTransformationV107;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import FeatureIdeComponent.*;
import NonStaticFD.Edge;
import NonStaticFD.FeatureModel;
import NonStaticFD.NonStaticFeature;
import NonStaticFD.OperatorFeatureSet;
import Annotations.Feature.Cardinality;
import Annotations.Feature.Type;

public class PlacementRécursif {
	public void buildAllLevels(NonStaticFD.FeatureModel fm,NonStaticFeature feature, ArrayList<NonStaticFD.Edge> SubFeatures,  Sub sub, HashSet<Sub> subelements, HashMap<NonStaticFD.OperatorFeatureSet, NonStaticFD.Edge> SubFeatureSet,boolean level1, MainAnd and) {
		
		String opname=new String();
		sub=new Sub(feature.featureName);
		System.out.println(sub.getNameOfFeature()+""+feature.featureName);
		HashSet<OrSet>orsett=new HashSet<OrSet>();
		ArrayList<OrSet> orsett2=new ArrayList<OrSet>();
		HashSet<XorSet>xorsett=new HashSet<XorSet>();
		HashSet<Feature> feature2=new HashSet();
		HashSet<String> ComplicatedFeature=new HashSet<String>();
		if(SubFeatures.size()==0 && level1==true) {
			for(int m=0;m<fm.features.size();m++) {
			if(fm.features.get(m).featureName.equals(feature.featureName) && fm.features.get(m).SubFeatureSet.size()>0) {
			List<Feature> toclean =and.getFeature();
				for(Iterator <Feature> it=toclean.iterator(); it.hasNext();) {
					Feature f=new Feature(it.next().getName());
					if(f.getName().toString().equals(fm.features.get(m).featureName)) {
						it.remove();
						System.out.println("removed simple from main and"+fm.features.get(m).featureName);
					}
				}
			
			Set hash=new HashSet<>();
			for(Entry <OperatorFeatureSet, Edge> operator:fm.features.get(m).SubFeatureSet.entrySet()) {
				opname=operator.getKey().OpName;
				hash.add(opname);
			}
			if(opname =="Or" && hash.size()==1) {
				OrSet or=new OrSet(fm.features.get(m).featureName);
				if(feature.type.toString().equals("Mandatory")) {
				or.setType("true");	
				}
				and.addOrList(or);
				HashSet<Sub>  sub3=new HashSet();
				ArrayList<Feature> featureSet=new ArrayList<>();
				for(Entry<OperatorFeatureSet, Edge> entry:fm.features.get(m).SubFeatureSet.entrySet()) {
					featureSet.add(new Feature(entry.getValue().edgeName));
				}
				if(featureSet.size()>0) {
				for(int z=0;z < featureSet.size();z++) {
					for(int w=0;w<fm.features.size();w++) {
						if(featureSet.size()>0 )
							if(z< featureSet.size()) {
							if(featureSet.get(z).getName().equals(fm.features.get(w).featureName)) {
							if(fm.features.get(w).SubFeatures != null && fm.features.get(w).SubFeatures.size()>0) {
								for(Iterator <Feature> it=featureSet.iterator(); it.hasNext();) {
									Feature f=new Feature(it.next().getName());
									if(f.getName().equals(fm.features.get(w).featureName)) {
										it.remove();
										System.out.println(z+"feature to delete "+fm.features.get(w).featureName+"  "+featureSet.size());
									}}
								  or.setFeature(featureSet);
								  Sub sub2=new Sub(fm.features.get(w).featureName);
								  if(fm.features.get(w).SubFeatures == null && fm.features.get(w).SubFeatureSet.size()>0) {
									  fm.features.get(w).SubFeatures=new ArrayList<Edge>();
									  addVariants(fm,or,orsett,fm.features.get(w),fm.features.get(w).SubFeatureSet,and);
								  }
								  buildAllLevels(fm, fm.features.get(w), fm.features.get(w).SubFeatures,sub2, sub3,fm.features.get(w).SubFeatureSet,false,and);
								  or.setLoopSub(sub3);
						}  
							else {
								
								//System.out.println("****************  variant est vp"+fm.features.get(w).featureName+" taille vp"+fm.features.get(w).SubFeatureSet.size());
								
								  System.out.println("orset "+fm.features.get(w).featureName);
								 or.setFeature(featureSet);
								}
							
							}
					}}
				}
				
				}
				
			}
				if(opname =="Xor" && hash.size()==1) {
					XorSet or=new XorSet(fm.features.get(m).featureName);
					if(feature.type.toString().equals("Mandatory")) {
						or.setType("true");	
						}
					and.addXorList(or);
					HashSet<Sub>  sub3=new HashSet();
					ArrayList<Feature> featureSet=new ArrayList<>();
					for(Entry<OperatorFeatureSet, Edge> entry:fm.features.get(m).SubFeatureSet.entrySet()) {
						featureSet.add(new Feature(entry.getValue().edgeName));
					}
					
					if(featureSet.size()>0) {
					for(int z=0;z<featureSet.size();z++) {
						for(int w=0;w<fm.features.size();w++) {
							if(featureSet.size()>0)
							if(z< featureSet.size()) {
							if(featureSet.get(z).getName().equals(fm.features.get(w).featureName)) {
								if((fm.features.get(w).SubFeatures != null && fm.features.get(w).SubFeatures.size()>0) ||(fm.features.get(w).SubFeatureSet.size()>0)) {
									for(Iterator <Feature> it=featureSet.iterator(); it.hasNext();) {
										Feature f=new Feature(it.next().getName());
										if(f.getName().equals(fm.features.get(w).featureName)) {
											it.remove();
										}}
									
									  or.setFeature(featureSet);
									  Sub sub2=new Sub(fm.features.get(w).featureName);
									  if(fm.features.get(w).SubFeatures == null && fm.features.get(w).SubFeatureSet.size()>0) {
										  fm.features.get(w).SubFeatures=new ArrayList<Edge>();
										  addVariants(fm,or,orsett2,fm.features.get(w),fm.features.get(w).SubFeatureSet,and);
									  }
									  buildAllLevels(fm, fm.features.get(w), fm.features.get(w).SubFeatures,sub2, sub3,fm.features.get(w).SubFeatureSet,false,and);
									  
									  or.setLoopSub(sub3);
							}  
								else {
									 or.setFeature(featureSet);
									}
								
								}
						}}
					}
					
					}
					
				}

				if(hash.size()==2) {
					ArrayList<Feature> featureOrSet=new ArrayList<>();
					 ArrayList<Feature> featureXorSet=new ArrayList<>();
					 if(feature.type.toString().equals("Mandatory")) {
					System.out.println(feature.featureName+" **/*/**/*/*/* "+feature.type.toString());	
					 }
					for(Entry <OperatorFeatureSet, Edge> operator:fm.features.get(m).SubFeatureSet.entrySet()) {
						 opname=operator.getKey().OpName;
						 if(opname=="Or") {
							 featureOrSet.add(new Feature(operator.getValue().edgeName));
						 }
						 if(opname=="Xor") {
							 featureXorSet.add(new Feature(operator.getValue().edgeName));

						 }

					}
					if(featureOrSet.size()>0) {
						String aleatoire=""+Math.random();
						OrSet or=new OrSet(aleatoire);
						or.setType("true");
						HashSet<OrSet>orset=new HashSet<OrSet>();
						orset.add(or);
						sub.setOrSets(orset);
						subelements.add(sub);
						HashSet<Sub>  sub3=new HashSet<Sub>();
						if(featureOrSet.size()>0) {
							for(int z=0;z<featureOrSet.size();z++) {
								for(int w=0;w<fm.features.size();w++) {
									if(featureOrSet.size()>0)	
											if(featureOrSet.get(z).getName().equals(fm.features.get(w).featureName)) {
												if(fm.features.get(w).SubFeatures != null &&fm.features.get(w).SubFeatures.size()>0 ) {
														if(fm.features.get(w).SubFeatures.size()>0) {
														for(Iterator <Feature> it=featureOrSet.iterator(); it.hasNext();) {
															Feature f=new Feature(it.next().getName());
															if(f.getName().equals(fm.features.get(w).featureName)) {
																it.remove();

															}}
														  or.setFeature(featureOrSet);
														  Sub sub2=new Sub(fm.features.get(w).featureName);
														   buildAllLevels(fm, fm.features.get(w), fm.features.get(w).SubFeatures,sub2, sub3,fm.features.get(w).SubFeatureSet,false,and);
														   
														   or.setLoopSub(sub3);
												} } 
													else {
														 or.setFeature(featureOrSet);

														   
														
													}
													
													}
												
											}
										}
										
										}
									
									
						 }
					if(featureXorSet.size()>0) {
							 String aleatoire=""+Math.random();
									XorSet or=new XorSet(aleatoire);
									or.setType("true");
									HashSet<XorSet>orset=new HashSet<XorSet>();
									orset.add(or);
									sub.setXorSets(orset);
									subelements.add(sub);
									HashSet<Sub>  sub3=new HashSet<Sub>();
									if(featureXorSet.size()>0) {
										for(int z=0;z<featureXorSet.size();z++) {
											for(int w=0;w<fm.features.size();w++) {
												if(featureXorSet.size()>0)
													if(z<featureXorSet.size()) {
												if(featureXorSet.get(z).getName().equals(fm.features.get(w).featureName)) {
													if(fm.features.get(w).SubFeatures != null && fm.features.get(w).SubFeatures.size()>0) {
														for(Iterator <Feature> it=featureXorSet.iterator(); it.hasNext();) {
															Feature f=new Feature(it.next().getName());
															if(f.getName().equals(fm.features.get(w).featureName)) {
																it.remove();

															}}

														  or.setFeature(featureXorSet);
														  Sub sub2=new Sub(fm.features.get(w).featureName);
														   buildAllLevels(fm, fm.features.get(w), fm.features.get(w).SubFeatures,sub2, sub3,fm.features.get(w).SubFeatureSet,false,and);
														   
														   or.setLoopSub(sub3);
												}  
													else {
														 or.setFeature(featureXorSet);

														   
														
													}
													
													}
												
											}}
										}
										
										}
						 }
				
					
				} 
				
				
				
			}}
		}
		if(SubFeatureSet.size() >0 && SubFeatures.size()>0 && level1==true) {
			Set hash=new HashSet<>();
			HashMap<OperatorFeatureSet,Edge> FeatureOrSet=new HashMap();
			HashMap<OperatorFeatureSet,Edge> FeatureXorSet=new HashMap();
			for(Entry <OperatorFeatureSet, Edge> operator:SubFeatureSet.entrySet()) {
				opname=operator.getKey().OpName;
				hash.add(opname);	
				if(opname=="Or") {
					FeatureOrSet.put(operator.getKey(),operator.getValue());
				}
				if(opname=="Xor") {
					FeatureXorSet.put(operator.getKey(),operator.getValue());
				}
			
			}
			if(feature.type.toString().equals("Mandatory")) {
			System.out.println("**************"+feature.featureName);
			}
			if(opname =="Or" && hash.size() ==1) {
				String aleatoire=""+Math.random();
				NonStaticFeature decompoFeature=new NonStaticFeature(aleatoire);
				decompoFeature.card=Cardinality.Manytoone;
				decompoFeature.type=Type.Mandatory;
				decompoFeature.SubFeatureSet.putAll(SubFeatureSet);
				fm.features.add(decompoFeature);
				SubFeatureSet.clear();
				Edge e=new Edge(aleatoire);
				e.card=decompoFeature.card;
				e.type=	decompoFeature.type;
				SubFeatures.add(e);
				System.out.println(e.edgeName);
			}
			if(opname =="Xor" && hash.size() ==1) {
				String aleatoire=""+Math.random();
				NonStaticFeature decompoFeature=new NonStaticFeature(aleatoire);
				decompoFeature.card=Cardinality.Manytoone;
				decompoFeature.type=Type.Mandatory;
				decompoFeature.SubFeatureSet.putAll(SubFeatureSet);
				fm.features.add(decompoFeature);
				SubFeatureSet.clear();
				Edge e=new Edge(aleatoire);
				e.card=decompoFeature.card;
				e.type=	decompoFeature.type;
				SubFeatures.add(e);
				System.out.println(e.edgeName);
			}
			if(hash.size()==2) {
				String opname2="";
				for(Iterator  itt=hash.iterator(); itt.hasNext();) {
					if(itt.hasNext()) {
						opname2=itt.next().toString();
				if(opname2=="Or") {
					String aleatoire=""+Math.random();
					NonStaticFeature decompoFeature=new NonStaticFeature(aleatoire);
					decompoFeature.card=Cardinality.Manytoone;
					decompoFeature.type=Type.Mandatory;
					decompoFeature.SubFeatureSet.putAll(FeatureOrSet);
					fm.features.add(decompoFeature);
					Edge e=new Edge(aleatoire);
					e.card=decompoFeature.card;
					e.type=	decompoFeature.type;
					SubFeatures.add(e);
					
				}
				if(opname2=="Xor") {
					String aleatoire=""+Math.random();
					NonStaticFeature decompoFeature=new NonStaticFeature(aleatoire);
					decompoFeature.card=Cardinality.Manytoone;
					decompoFeature.type=Type.Mandatory;
					decompoFeature.SubFeatureSet.putAll(FeatureXorSet);
					fm.features.add(decompoFeature);
					Edge e=new Edge(aleatoire);
					e.card=decompoFeature.card;
					e.type=	decompoFeature.type;
					SubFeatures.add(e);
				}
				}
			}
				SubFeatureSet.clear();

			}
		}
		for(int  i=0;i<SubFeatures.size();i++) {
		for(int j=0;j<fm.features.size();j++) {
			if(fm.features.get(j).featureName.equals(SubFeatures.get(i).edgeName)) {
				if(fm.features.get(j).SubFeatures == null || fm.features.get(j).SubFeatures.size()==0) {
					if(! ComplicatedFeature.contains(fm.features.get(j).featureName) ){
						//feature2.add(new Feature(fm.features.get(j).featureName));
						if(SubFeatures.get(i).type.toString().equals("Mandatory")) {
						System.out.println(SubFeatures.get(i).type);
						Feature f=new Feature(fm.features.get(j).featureName,"true");
						f.setType("true");
						feature2.add(f);						
						}
						if(SubFeatures.get(i).type.toString().equals("Optional")) {
							feature2.add(new Feature(fm.features.get(j).featureName));
							}
						
						
					}
					if(sub !=null) {
					sub.setFeature(feature2);
					if(feature.type.toString().equals("Mandatory")) {
					sub.setMandatory("true");	
					}
					
					
				}   
					

				if(fm.features.get(j).SubFeatureSet.size()>0) {
					for(Iterator <Feature> it=feature2.iterator(); it.hasNext();) {
						Feature f=new Feature(it.next().getName());
						if(f.getName().toString().equals(fm.features.get(j).featureName)) {
							
							it.remove();
						}}
					
					Set hash=new HashSet<>();
					for(Entry <OperatorFeatureSet, Edge> operator:fm.features.get(j).SubFeatureSet.entrySet()) {
						opname=operator.getKey().OpName;
						hash.add(opname);
							}
					if(opname =="Or" && hash.size()==1) {
					
					OrSet or=new OrSet(fm.features.get(j).featureName);
					if(SubFeatures.get(i).type.toString().equals("Mandatory")) {
						or.setType("true");
					}
					orsett.add(or);
					sub.setOrSets(orsett);
					HashSet<Sub>  sub3=new HashSet();
					ArrayList<Feature> featureSet=new ArrayList<>();
					for(Entry<OperatorFeatureSet, Edge> entry:fm.features.get(j).SubFeatureSet.entrySet()) {
						featureSet.add(new Feature(entry.getValue().edgeName));
					}
					int z=0;
					if(featureSet.size()>0) {
					for( z=0;z<featureSet.size();z++) {
						for(int w=0;w<fm.features.size();w++) {
							if(featureSet.size()>0)
							if(featureSet.get(z).getName().equals(fm.features.get(w).featureName)) {
								if(fm.features.get(w).SubFeatures != null && fm.features.get(w).SubFeatures.size()>0) {
									for(Iterator <Feature> it=featureSet.iterator(); it.hasNext();) {
										Feature f=new Feature(it.next().getName());
										if(f.getName().equals(fm.features.get(w).featureName)) {
											it.remove();
										}}
									  or.setFeature(featureSet);
									  Sub sub2=new Sub(fm.features.get(w).featureName);
									  buildAllLevels(fm, fm.features.get(w), fm.features.get(w).SubFeatures,sub2, sub3,fm.features.get(w).SubFeatureSet,false,and);
									  or.setLoopSub(sub3);
							}  
								else {
									 or.setFeature(featureSet);
									}
								
								}}
						}
					
					
					}
					
				}
					if(opname=="Xor" && hash.size()==1) {
						XorSet xor=new XorSet(fm.features.get(j).featureName);
						if(SubFeatures.get(i).type.toString().equals("Mandatory")) {
							xor.setType("true");
						}
						HashSet<XorSet>xorset=new HashSet<XorSet>();
						xorset.add(xor);
						sub.setXorSets(xorset);
						HashSet<Sub>  sub3=new HashSet<Sub>();
						ArrayList<Feature> featureSet=new ArrayList<>();
						for(Entry<OperatorFeatureSet, Edge> entry:fm.features.get(j).SubFeatureSet.entrySet()) {
							Feature f=new Feature(entry.getValue().edgeName);
							featureSet.add(f);
							
						}
						if(featureSet.size()>0) {
						for(int z=0;z<featureSet.size();z++) {
							for(int w=0;w<fm.features.size();w++) {
								if(featureSet.size()>0)
									if(z<featureSet.size()) {
								if(featureSet.get(z).getName().equals(fm.features.get(w).featureName)) {
									if(fm.features.get(w).SubFeatures != null && fm.features.get(w).SubFeatures.size()>0) {
										for(Iterator <Feature> it=featureSet.iterator(); it.hasNext();) {
											Feature f=new Feature(it.next().getName());
											if(f.getName().equals(fm.features.get(w).featureName)) {
												it.remove();
											}}

										  xor.setFeature(featureSet);

										   Sub sub2=new Sub(fm.features.get(w).featureName);
										   buildAllLevels(fm, fm.features.get(w), fm.features.get(w).SubFeatures,sub2, sub3,fm.features.get(w).SubFeatureSet,false,and);
										   
										   xor.setLoopSub(sub3);
								}  
									else {
										 xor.setFeature(featureSet);

										   
										
									}
									
									}}
								
							}
						}
						
						}
						
					}
					if(hash.size()==2) {
						
						Sub subDecompo=new Sub(fm.features.get(j).featureName);
						sub.addLoopSub(subDecompo);
						ArrayList<Feature> featureOrSet=new ArrayList<>();
						 ArrayList<Feature> featureXorSet=new ArrayList<>();
						for(Entry <OperatorFeatureSet, Edge> operator:fm.features.get(j).SubFeatureSet.entrySet()) {
							 opname=operator.getKey().OpName;
							 if(opname=="Or") {
								 featureOrSet.add(new Feature(operator.getValue().edgeName));
							 }
							 if(opname=="Xor") {
								 featureXorSet.add(new Feature(operator.getValue().edgeName));
 
							 }

						}
						if(featureOrSet.size()>0) {
							String aleatoire=""+Math.random();
							OrSet or=new OrSet(aleatoire);
							or.setType("true");
							HashSet<OrSet>orset=new HashSet<OrSet>();
							orset.add(or);
							subDecompo.setOrSets(orset);
							HashSet<Sub>  sub3=new HashSet<Sub>();
							if(featureOrSet.size()>0) {
								for(int z=0;z<featureOrSet.size();z++) {
									for(int w=0;w<fm.features.size();w++) {
										if(featureOrSet.size()>0)
											
												if(featureOrSet.get(z).getName().equals(fm.features.get(w).featureName)) {

													if(fm.features.get(w).SubFeatures != null &&fm.features.get(w).SubFeatures.size()>0 ) {

															if(fm.features.get(w).SubFeatures.size()>0) {
															for(Iterator <Feature> it=featureOrSet.iterator(); it.hasNext();) {
																Feature f=new Feature(it.next().getName());
																if(f.getName().equals(fm.features.get(w).featureName)) {
																	it.remove();

																}}
															  or.setFeature(featureOrSet);
															  Sub sub2=new Sub(fm.features.get(w).featureName);
															  buildAllLevels(fm, fm.features.get(w), fm.features.get(w).SubFeatures,sub2, sub3,fm.features.get(w).SubFeatureSet,false,and);
															  or.setLoopSub(sub3);
													} } 
														else {
															or.setFeature(featureOrSet);

															   
															
														}
														
														}
													
												}
											}
											
											}
										
										
							 }
						if(featureXorSet.size()>0) {
									
								String aleatoire=""+Math.random();
								XorSet or=new XorSet(aleatoire);
								or.setType("true");
								HashSet<XorSet>orset=new HashSet<XorSet>();
								orset.add(or);
								subDecompo.setXorSets(orset);
								HashSet<Sub>  sub3=new HashSet<Sub>();
								if(featureXorSet.size()>0) {
									for(int z=0;z<featureXorSet.size();z++) {
										for(int w=0;w<fm.features.size();w++) {
											if(featureXorSet.size()>0)
												if(featureXorSet.get(z).getName().equals(fm.features.get(w).featureName)) {
													if(fm.features.get(w).SubFeatures != null && fm.features.get(w).SubFeatures.size()>0) {
														for(Iterator <Feature> it=featureXorSet.iterator(); it.hasNext();) {
															Feature f=new Feature(it.next().getName());
															System.out.println("<f  "+fm.features.get(w).featureName+"  />  as or variants");
															if(f.getName().equals(fm.features.get(w).featureName)) {
																it.remove();

																}}

															or.setFeature(featureXorSet);
															Sub sub2=new Sub(fm.features.get(w).featureName);
															buildAllLevels(fm, fm.features.get(w), fm.features.get(w).SubFeatures,sub2, sub3,fm.features.get(w).SubFeatureSet,false,and);
														    or.setLoopSub(sub3);
													}  
														  else {
															or.setFeature(featureXorSet);

														}
														
														}
													
												}
											}
											
											}
							 }
					
						
					}
					
				}
				
					
					}			
				subelements.add(sub);
				if(fm.features.get(j).SubFeatures != null && fm.features.get(j).SubFeatures.size()> 0) {
					for(int k=0;k<fm.features.size();k++) {
						if(fm.features.get(j).featureName.equals(fm.features.get(k).featureName) && fm.features.get(k).SubFeatureSet.size()>0) {
							Set hash=new HashSet<>();
							System.out.println(fm.features.get(j).featureName);
							HashMap<OperatorFeatureSet,Edge> FeatureOrSet=new HashMap();
							HashMap<OperatorFeatureSet,Edge> FeatureXorSet=new HashMap();
							for(Entry <OperatorFeatureSet, Edge> operator:fm.features.get(k).SubFeatureSet.entrySet()) {
								opname=operator.getKey().OpName;
								hash.add(opname);
								if(opname=="Or") {
									FeatureOrSet.put(operator.getKey(),operator.getValue());
								}
								if(opname=="Xor") {
									FeatureXorSet.put(operator.getKey(),operator.getValue());
								}
									}
							if(opname =="Or" && hash.size() ==1) {
								String aleatoire=""+Math.random();
								NonStaticFeature decompoFeature=new NonStaticFeature(aleatoire);
								decompoFeature.card=Cardinality.Manytoone;
								decompoFeature.type=Type.Mandatory;
								System.out.println("Après  fichier à la fois pere et vp  "+fm.features.get(j).featureName+" taille vp"+fm.features.get(k).SubFeatureSet.size());
								decompoFeature.SubFeatureSet.putAll(fm.features.get(k).SubFeatureSet);
								fm.features.add(decompoFeature);
								fm.features.get(k).SubFeatureSet.clear();
								fm.features.get(j).SubFeatureSet.clear();
								Edge e=new Edge(aleatoire);
								e.card=decompoFeature.card;
								e.type=	decompoFeature.type;
								fm.features.get(j).SubFeatures.add(e);
								}
							if(opname =="Xor" && hash.size() ==1) {
								String aleatoire=""+Math.random();
								NonStaticFeature decompoFeature=new NonStaticFeature(aleatoire);
								decompoFeature.card=Cardinality.Manytoone;
								decompoFeature.type=Type.Mandatory;
								decompoFeature.SubFeatureSet.putAll(fm.features.get(k).SubFeatureSet);
								fm.features.add(decompoFeature);
								fm.features.get(k).SubFeatureSet.clear();
								fm.features.get(j).SubFeatureSet.clear();
								Edge e=new Edge(aleatoire);
								e.card=decompoFeature.card;
								e.type=	decompoFeature.type;
								fm.features.get(j).SubFeatures.add(e);
							}
							if(hash.size()==2) {
								String opname2="";
								for(Iterator  itt=hash.iterator(); itt.hasNext();) {
									if(itt.hasNext()) {
										opname2=itt.next().toString();
								if(opname2=="Or") {
									String aleatoire=""+Math.random();
									NonStaticFeature decompoFeature=new NonStaticFeature(aleatoire);
									decompoFeature.card=Cardinality.Manytoone;
									decompoFeature.type=Type.Mandatory;
									decompoFeature.SubFeatureSet.putAll(FeatureOrSet);
									fm.features.add(decompoFeature);
									Edge e=new Edge(aleatoire);
									e.card=decompoFeature.card;
									e.type=	decompoFeature.type;
									fm.features.get(j).SubFeatures.add(e);
									
								}
								if(opname2=="Xor") {
									String aleatoire=""+Math.random();
									NonStaticFeature decompoFeature=new NonStaticFeature(aleatoire);
									decompoFeature.card=Cardinality.Manytoone;
									decompoFeature.type=Type.Mandatory;
									decompoFeature.SubFeatureSet.putAll(FeatureXorSet);
									fm.features.add(decompoFeature);
									Edge e=new Edge(aleatoire);
									e.card=decompoFeature.card;
									e.type=	decompoFeature.type;
									fm.features.get(j).SubFeatures.add(e);
								}
								}
							}
								fm.features.get(j).SubFeatureSet.clear();
								fm.features.get(k).SubFeatureSet.clear();

							}
						}
					}
					Sub sub2=new Sub(fm.features.get(j).featureName);

					if(SubFeatures.get(i).type.toString().equals("Mandatory")) {
						sub2.setMandatory("true");
					}
					HashSet<Sub> sub3=new HashSet();
					sub.setLoopSub(sub3);
					subelements.add(sub);
					ComplicatedFeature.add(fm.features.get(j).featureName);
					buildAllLevels(fm, fm.features.get(j), fm.features.get(j).SubFeatures,sub2, sub3,fm.features.get(j).SubFeatureSet,false,and);
					
				
				}
				
				
			}
		}
		}
	
		
	}

	private void addVariants(FeatureModel fm, OrSet or, HashSet<OrSet> orsett, NonStaticFeature nonStaticFeature, HashMap<OperatorFeatureSet, Edge> subFeatureSet, MainAnd and) {
		String opname="";
		Set hash=new HashSet();
		for(Entry <OperatorFeatureSet,Edge> operator:subFeatureSet.entrySet()) {
			opname=operator.getKey().OpName;
			hash.add(opname);
		}
		if(opname =="Or" && hash.size()==1) {
			OrSet orr=new OrSet(nonStaticFeature.featureName);
			orsett.add(orr);
			or.setOrSet(orsett);
			ArrayList<Feature> featureSet=new ArrayList<>();
			for(Entry<OperatorFeatureSet, Edge> entry:subFeatureSet.entrySet()) {
				Feature f=new Feature(entry.getValue().edgeName);
				featureSet.add(f);
				
			}
			if(featureSet.size()>0) {
			for(int z=0;z<featureSet.size();z++) {
				for(int w=0;w<fm.features.size();w++) {
					if(featureSet.size()>0)
						if(z<featureSet.size()) {
					if(featureSet.get(z).getName().equals(fm.features.get(w).featureName)) {
						if(fm.features.get(w).SubFeatures != null && fm.features.get(w).SubFeatures.size()>0) {
							for(Iterator <Feature> it=featureSet.iterator(); it.hasNext();) {
								Feature f=new Feature(it.next().getName());
								if(f.getName().equals(fm.features.get(w).featureName)) {
									it.remove();
								}}

							  orr.setFeature(featureSet);
							  HashSet<Sub> sub3=new HashSet<Sub>();
							   Sub sub2=new Sub(fm.features.get(w).featureName);
							   buildAllLevels(fm, fm.features.get(w), fm.features.get(w).SubFeatures,sub2, sub3,fm.features.get(w).SubFeatureSet,false,and);
							   
							   orr.setLoopSub(sub3);
					}  
						else {
							 orr.setFeature(featureSet);

							   
							
						}
						
						}}
					
				}
			}
			
			}
		}
	}

	private void addVariants(FeatureModel fm, XorSet orP,ArrayList<OrSet>orsett2,  NonStaticFeature nonStaticFeature,HashMap<OperatorFeatureSet, Edge> subFeatureSet, MainAnd and) {
		String opname=new String();
		HashSet<XorSet> xorsett=new HashSet<XorSet>();
		List<OrSet>orsett=new ArrayList<OrSet>();
		Set hash=new HashSet();
		for(Entry <OperatorFeatureSet,Edge> operator:subFeatureSet.entrySet()) {
			opname=operator.getKey().OpName;
			hash.add(opname);
		}
		if(opname =="Xor" && hash.size()==1) {
			XorSet xor=new XorSet(nonStaticFeature.featureName);
			System.out.println(nonStaticFeature.featureName);
			ArrayList<Feature> featureSet=new ArrayList<>();
			 xorsett.add(xor);
			 orP.setXorSet(xorsett);
			for(Entry<OperatorFeatureSet, Edge> entry:subFeatureSet.entrySet()) {
				Feature f=new Feature(entry.getValue().edgeName);
				featureSet.add(f);
				
			}
			if(featureSet.size()>0) {
			for(int z=0;z<featureSet.size();z++) {
				for(int w=0;w<fm.features.size();w++) {
					if(featureSet.size()>0)
						if(z<featureSet.size()) {
					if(featureSet.get(z).getName().equals(fm.features.get(w).featureName)) {
						if(fm.features.get(w).SubFeatures != null && fm.features.get(w).SubFeatures.size()>0) {
							for(Iterator <Feature> it=featureSet.iterator(); it.hasNext();) {
								Feature f=new Feature(it.next().getName());
								if(f.getName().equals(fm.features.get(w).featureName)) {
									it.remove();
								}}

							  xor.setFeature(featureSet);
							  HashSet<Sub> sub3=new HashSet<Sub>();
							   Sub sub2=new Sub(fm.features.get(w).featureName);
							   buildAllLevels(fm, fm.features.get(w), fm.features.get(w).SubFeatures,sub2, sub3,fm.features.get(w).SubFeatureSet,false,and);
							   
							   xor.setLoopSub(sub3);
					}  
						else {
							 xor.setFeature(featureSet);

							   
							
						}
						
						}}
					
				}
			}
			
			}
		}
		if(opname =="Or" && hash.size()==1) {
			System.out.println(nonStaticFeature.featureName);
			OrSet xor=new OrSet(nonStaticFeature.featureName);
			ArrayList<Feature> featureSet=new ArrayList<>();
			 orsett2.add(xor);
			 orP.setOrSet(orsett2);
			for(Entry<OperatorFeatureSet, Edge> entry:subFeatureSet.entrySet()) {
				Feature f=new Feature(entry.getValue().edgeName);
				featureSet.add(f);
				
			}
			if(featureSet.size()>0) {
			for(int z=0;z<featureSet.size();z++) {
				for(int w=0;w<fm.features.size();w++) {
					if(featureSet.size()>0)
						if(z<featureSet.size()) {
					if(featureSet.get(z).getName().equals(fm.features.get(w).featureName)) {
						if(fm.features.get(w).SubFeatures != null && fm.features.get(w).SubFeatures.size()>0) {
							for(Iterator <Feature> it=featureSet.iterator(); it.hasNext();) {
								Feature f=new Feature(it.next().getName());
								if(f.getName().equals(fm.features.get(w).featureName)) {
									it.remove();
								}}

							  xor.setFeature(featureSet);
							  HashSet<Sub> sub3=new HashSet<Sub>();
							   Sub sub2=new Sub(fm.features.get(w).featureName);
							   buildAllLevels(fm, fm.features.get(w), fm.features.get(w).SubFeatures,sub2, sub3,fm.features.get(w).SubFeatureSet,false,and);
							   
							   xor.setLoopSub(sub3);
					}  
						else {
							System.out.println("Or add variant"+fm.features.get(w).featureName);
							 xor.setFeature(featureSet);

							   
							
						}
						
						}}
					
				}
			}
			
			}
		}
		if(hash.size()==2) {
			ArrayList<Feature> featureOrSet=new ArrayList<>();
			ArrayList<Feature> featureXorSet=new ArrayList<>();
			HashSet<OrSet>orset=new HashSet<OrSet>();
			Sub sub=new Sub(nonStaticFeature.featureName);
			HashSet<Sub> subelements=new HashSet<Sub>();
			subelements.add(sub);
			orP.addLoopSub(sub);
			for(Entry <OperatorFeatureSet, Edge> operator:subFeatureSet.entrySet()) {
				 opname=operator.getKey().OpName;
				 if(opname=="Or") {
					 featureOrSet.add(new Feature(operator.getValue().edgeName));
				 }
				 if(opname=="Xor") {
					 featureXorSet.add(new Feature(operator.getValue().edgeName));

				 }
			}
			
			if(featureOrSet.size()>0) {
				String aleatoire=""+Math.random();
				OrSet or=new OrSet(aleatoire);
				or.setType("true");
				orset.add(or);
				sub.setOrSets(orset);	
				HashSet<Sub>  sub3=new HashSet<Sub>();
				if(featureOrSet.size()>0) {
					for(int z=0;z<featureOrSet.size();z++) {
						for(int w=0;w<fm.features.size();w++) {
							if(featureOrSet.size()>0)	
									if(featureOrSet.get(z).getName().equals(fm.features.get(w).featureName)) {
										if(fm.features.get(w).SubFeatures != null &&fm.features.get(w).SubFeatures.size()>0 ) {
												if(fm.features.get(w).SubFeatures.size()>0) {
												for(Iterator <Feature> it=featureOrSet.iterator(); it.hasNext();) {
													Feature f=new Feature(it.next().getName());
													if(f.getName().equals(fm.features.get(w).featureName)) {
														it.remove();

													}}
												  or.setFeature(featureOrSet);
												  Sub sub2=new Sub(fm.features.get(w).featureName);
												  System.out.println("feature   "+fm.features.get(w).featureName+"  sub "+fm.features.get(w).SubFeatures.size()+" groupset  "+fm.features.get(w).SubFeatureSet.size());
												  buildAllLevels(fm, fm.features.get(w), fm.features.get(w).SubFeatures,sub2, sub3,fm.features.get(w).SubFeatureSet,false,and);
												  or.setLoopSub(sub3);
										} } 
											else {
												 or.setFeature(featureOrSet);
												 System.out.println(sub.getNameOfFeature()+" **** taille features or"+or.getFeature().size()+" //// "+orP.getLoopSub().size());
												   
												
											}
											
											}
										
									}
								}
								
								}
							
							
				 }
				if(featureXorSet.size()>0) {
					String aleatoire=""+Math.random();
					XorSet or=new XorSet(aleatoire);
					or.setType("true");
					xorsett.add(or);
					sub.setXorSets(xorsett);
					HashSet<Sub>  sub3=new HashSet<Sub>();
				if(featureXorSet.size()>0) {
				for(int z=0;z<featureOrSet.size();z++) {
					for(int w=0;w<fm.features.size();w++) {
						if(featureOrSet.size()>0)	
								if(featureOrSet.get(z).getName().equals(fm.features.get(w).featureName)) {
									if(fm.features.get(w).SubFeatures != null &&fm.features.get(w).SubFeatures.size()>0 ) {
											if(fm.features.get(w).SubFeatures.size()>0) {
											for(Iterator <Feature> it=featureOrSet.iterator(); it.hasNext();) {
												Feature f=new Feature(it.next().getName());
												if(f.getName().equals(fm.features.get(w).featureName)) {
													it.remove();

												}}
											  or.setFeature(featureOrSet);
											  Sub sub2=new Sub(fm.features.get(w).featureName);
											  System.out.println("feature   "+fm.features.get(w).featureName+"  sub "+fm.features.get(w).SubFeatures.size()+" groupset  "+fm.features.get(w).SubFeatureSet.size());
											   buildAllLevels(fm, fm.features.get(w), fm.features.get(w).SubFeatures,sub2, sub3,fm.features.get(w).SubFeatureSet,false,and);
											   
											   or.setLoopSub(sub3);
									} } 
										else {
											 or.setFeature(featureOrSet);
											 System.out.println(sub.getNameOfFeature()+" **** taille features xor"+or.getFeature().size());

											   
											
										}
										
										}
									
								}
							}
							
							}}
						
						
			 }
			
			
			
		}
		
	
	

}
