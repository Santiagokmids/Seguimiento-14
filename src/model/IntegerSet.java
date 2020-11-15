package model;
import java.util.*;

public class IntegerSet{

	//Atributes
	private String name;
	private int cardinality;
	private ArrayList <Integer> elements;

	//Methods
	public IntegerSet(String name){
		this.name = name;
		cardinality = 0;
		elements = new ArrayList<Integer>();
	}

	public String getName(){
		return name;
	}

	public int getCardinality(){
		return cardinality;
	}	

	public void setCardinality(int size){
		this.cardinality = cardinality;
	}	

	public ArrayList <Integer> getElements(){
		return elements;
	}

	public void addElement(Integer element){
		elements.add(element); 
		cardinality++;
	}

	public void removeElement(Integer element){
		elements.remove(element);
		cardinality--;
	}

	public IntegerSet union(IntegerSet set, String newName){
		IntegerSet objNew = new IntegerSet(newName);
		boolean exit = true;
		if(set != null){
			for(int i = 0;i<cardinality;i++){
				objNew.addElement(elements.get(i));
			}
			int count = 0;
			for(int k = 0;k<set.getElements().size() && exit;k++){
				count++;
				findUni(objNew,set.getElements().get(k));			
				setCardinality(objNew.getElements().size());
				if(count == (objNew.getElements().size() - 1)){
					exit = false;
				}	
			}
		}
		return objNew;
	}

	public void findUni(IntegerSet objNew,int element){
		int count = 0,counter = 1;
		for(int i = 0;i<objNew.getElements().size();i++){
			if(objNew.getElements().get(i) != element){
				count++;
				counter = i+1;
			}
			else{
				counter = i-1;
			}
		}
		if(count == counter){
			objNew.addElement(element);
		}
	}

	public IntegerSet difference(IntegerSet set, String newName){
		IntegerSet objNew = new IntegerSet(newName);
		boolean exit = true;
		if(set != null){
			for(int i = 0;i<cardinality;i++){
				objNew.addElement(elements.get(i));
			}
			int count = 0;
			for(int k = 0;k<set.getElements().size() && exit;k++){
				count++;
				findDiff(set,objNew,set.getElements().get(k));			
				setCardinality(objNew.getElements().size());
				if(count == (objNew.getElements().size() - 1)){
					exit = false;
				}	
			}
		}
		return objNew;
	}

	public void findDiff(IntegerSet set,IntegerSet objNew,int element){
		for(int i = 0;i<objNew.getElements().size();i++){
			if(objNew.getElements().get(i) == element){
				objNew.removeElement(objNew.getElements().get(i));
			}
		}
	}

	public IntegerSet intersection(IntegerSet set, String newName){
		IntegerSet objNew = new IntegerSet(newName);
		boolean exit = true;
		if(set != null){
			for(int i = 0;i<cardinality;i++){
				objNew.addElement(elements.get(i));
			}
			int count = 0;
			for(int k = 0;k<objNew.getElements().size() && exit;k++){
				count = k;
				findInt(set,objNew);			
				setCardinality(objNew.getElements().size());
				if(count == (objNew.getElements().size() - 1)){
					exit = false;
				}
			}	
		}
		return objNew;
	}

	public void findInt(IntegerSet set,IntegerSet objNew){
		int count = 0;
		Integer element = 0;
		boolean exit = true;
		for(int i = 0;i<objNew.getCardinality() && exit;i++){
			for(int k = 0;k<set.getCardinality();k++){
				if(element != set.getElements().get(k)){
					count = k+1;	
				}
			}
			if(count == (set.getElements().size())){
				objNew.removeElement(element);
				exit = false;	
			}
		}
	}
		

	public IntegerSet symmetricDifference(IntegerSet set, String newName){
		IntegerSet objNew = new IntegerSet(newName);
		boolean exit = true;
		if(set != null){
			for(int i = 0;i<cardinality;i++){
				objNew.addElement(elements.get(i));
			}
			int count = 0;
			for(int k = 0;k<set.getElements().size() && exit;k++){
				count++;
				findSymm(set,objNew,set.getElements().get(k));			
				setCardinality(objNew.getElements().size());
				if(count == (objNew.getElements().size() - 1)){
					exit = false;
				}	
			}
		}	
		return objNew;
	}

	public void findSymm(IntegerSet set,IntegerSet objNew,int element){
		int count = 0;
		for(int i = 0;i<objNew.getElements().size();i++){
			if(objNew.getElements().get(i) == element){
				count = i+1;
			}
		}
		if(count >= 1){
			objNew.removeElement(element);
		}
		else if(count == 0){
			objNew.addElement(element);	
		}
	}

	public String toString(){
		String message = "", element = "";
		for(int k = 0;k<getCardinality();k++){
				element += "["+getElements().get(k)+"]";
			}
			if(element.equals("")){
				element = "El conjunto es vacio";
			}
			message += "\n ***  CONJUNTO ***"+
			           "\n   Nombre: "+getName()+
			           "\n   Elementos: "+element+
			           "\n************************\n";
		return message;
	}

}