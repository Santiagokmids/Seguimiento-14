package model;
import java.util.*;

public class MathApp{

	//Relationships
	private ArrayList <IntegerSet> sets;

	//Atributes
	private int amount;

	//Methods
	public MathApp(){
		amount = 0;
		sets = new ArrayList<IntegerSet>();
	}

	//Method for find the set 
	public IntegerSet find(String name){
		boolean exit = true;
		IntegerSet find = null;
		for(int i = 0;i<amount && exit;i++){
			if(sets.get(i) != null && sets.get(i).getName().equalsIgnoreCase(name)){
				find = sets.get(i);
				exit = false;
			}
		}
		return find;
	}

	public boolean verify(String name){
		boolean exit = true;
		for (int i = 0;i<amount;i++) {
			if(sets.get(i) != null && sets.get(i).getName().equalsIgnoreCase(name)){
				exit = false;
			}
		}
		return exit;
	}

	public void addSet(String name){
		
		IntegerSet newObj = new IntegerSet(name);
		sets.add(newObj);
		amount++;
	}

	public boolean messageAdd(IntegerSet obj, Integer element){
		boolean stop = true;
		for(int i = 0;i<obj.getCardinality();i++){
			if(obj.getElements().get(i) == element){
				stop = false;
			}
		}
		return stop;
	}

	public void addElementToSet(String setName, int element){
		IntegerSet obj = find(setName);
		if(obj != null){
			obj.addElement(element);
		}
	}


	public void removeSet(String name){
		IntegerSet obj = find(name);
		if(obj != null){
			for(int i = 0;i<amount;i++) {
				if(obj.getName().equalsIgnoreCase(sets.get(i).getName())){
					sets.remove(i);
					amount--;
				}
			}
		}
	}

	public String messageRemove(IntegerSet obj, Integer element){
		String message = "";
		boolean exit = true;
		if(obj != null){
			for(int i = 0;i<obj.getCardinality() && exit;i++){
				if(element == obj.getElements().get(i)){
					exit = false;
					message = "El elemento fue eliminado";
				}
				else
					message = "El elemento no existe";
			}
		}
		else{
			message = "El conjunto no existe";
		}
		return message;
	}

	public void removeElementFromSet(String setName, int element){
		IntegerSet obj = find(setName);
		if(obj != null){
			//int position = obj.changeElement(obj,element); 
			obj.removeElement(element);
		}
	}

	public boolean message(IntegerSet obj1, IntegerSet obj2){   
		boolean stop = true;
		if(obj1 == null || obj2 == null){
			stop = false;
		}
		return stop;
	}

	public void union(String name, String name2, String newName){
		IntegerSet obj1 = find(name);
		IntegerSet obj2 = find(name2);

		IntegerSet objNew = obj1.union(obj2, newName);
		sets.add(objNew);
		amount++;
	}

	public void difference(String name, String name2, String newName){
		IntegerSet obj1 = find(name);
		IntegerSet obj2 = find(name2);

		IntegerSet objNew = obj1.difference(obj2, newName);
		sets.add(objNew);
		amount++;
	}

	public void intersection(String name, String name2, String newName){
		IntegerSet obj1 = find(name);
		IntegerSet obj2 = find(name2);

		IntegerSet objNew = obj1.intersection(obj2, newName);
		sets.add(objNew);
		amount++;
	}

	public void symmetricDifference(String name, String name2, String newName){
		IntegerSet obj1 = find(name);
		IntegerSet obj2 = find(name2);

		IntegerSet objNew = obj1.symmetricDifference(obj2, newName);
		sets.add(objNew);
		amount++;
	}

	public String showInfoSet(String name){
		String message = "";
		IntegerSet obj = find(name);
		if(obj != null){
			message = obj.toString();
		}
		else
			message = "El conjunto no existe";
		return message;
	}

	public String showInfoSets(){
		String message = "";
		for(int i = 0;i<sets.size();i++){
			message += sets.get(i).toString(); 
		}
		if(message.equalsIgnoreCase("")){
			message = "No hay conjuntos creados";
		}
		return message;
	}
}