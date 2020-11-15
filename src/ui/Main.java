package ui;
import model.MathApp;
import java.util.Scanner;
public class Main{

	//Atributes
	public static MathApp mathApp;
	//Globals variable
	public Scanner lector;

	public Main(){
		lector = new Scanner(System.in);
		startApp();
	}

	public static void main(String []args){
		Main objMain = new Main();
		objMain.Menu();
	}

	public void startApp(){
		System.out.println("-------------------------------------");
		System.out.println("||          BIENVENIDOS            ||");
		System.out.println("-------------------------------------");
		mathApp = new MathApp(); 
	}

	public void Menu(){
		 boolean stop = false;
	   	 for(int l = 0;!stop;l++){
	   	 	 System.out.println("");
	   	     System.out.println("------------------------------------------------------");
             System.out.println("      * QUE DESEA HACER? *");	   	
             System.out.println("------------------------------------------------------");
	         System.out.println("");
	         System.out.println("************************************************************************");
	         System.out.println(" (1.) Agregar un conjunto                                               |");
	         System.out.println(" (2.) Eliminar un conjunto                                              |");
	         System.out.println(" (3.) Agregar elemento a un conjunto                                    |");
	         System.out.println(" (4.) Eliminar un elemento de un conjunto                               |");
	         System.out.println(" (5.) Realizar operaciones entre 2 conjuntos                            |");
	         System.out.println(" (6.) Mostrar un conjunto elegido                                       |");
	         System.out.println(" (7.) Mostrar todos los conjuntos                                       |");
	         System.out.println(" (0.) Salir de la aplicacion                                            |");
	         System.out.println("************************************************************************");
	         int option = lector.nextInt();
	         System.out.println("");
	         lector.nextLine();
         
         switch(option){
         	case 0:
         	     System.out.println("** Gracias por usar la Aplicacion :D **");
         	     stop = true;
         	    break;

         	case 1: 
         	   System.out.println("** Agregar un conjunto **\n");
         	   addSet();
         	   break;

         	case 2:
         		System.out.println("**  Eliminar un conjunto **\n");
         	    removeSet();
         	    break;

         	case 3:
         	     System.out.println("** Agregar elemento a un conjunto **\n");
         	     addElementToSet();
         	    break;

         	case 4:
         	     System.out.println("** Eliminar un elemento de un conjunto  **\n");
         	     removeElement();
         	    break;

         	case 5:
         	     System.out.println("** Realizar operaciones entre 2 conjuntos **\n");
         	     menuOps();
         	    break;

         	case 6:
         	     System.out.println("** Mostrar un conjunto elegido **\n");
         	     showASet();
         	    break;
         	    
         	case 7:
         	     System.out.println("** Mostrar todos los conjuntos **");
         	     showSets();
         	    break;                    
    
            default: 
                System.out.println("Ingreso un numero NO valido");
            }
	    }
	}

	public void addSet(){
		boolean exit = true;
		boolean stop = true;
		for(int i = 0;exit;i++){
			System.out.println("Ingrese el nombre del conjunto que va a Agregar");
			String name = lector.nextLine();
			stop = mathApp.verify(name);
			if(stop){
				mathApp.addSet(name);
				System.out.println("El conjunto fue agregado correctamente");
				exit = false;
			}
			else{
				System.out.println("El conjunto ya existe, intente nuevamente");
			}
		}
	}

	public void removeSet(){
		boolean exit = true;
		for(int i = 0;exit;i++){
			System.out.println("Ingrese el nombre del conjunto que va a Eliminar");
			String name = lector.nextLine();
			if(mathApp.find(name) != null){
				mathApp.removeSet(name);
				System.out.println("El conjunto fue eliminado correctamente");
				exit = false;
			}
			else{
				System.out.println("El conjunto no existe, intente nuevamente");
			}
		}
	}

	public void addElementToSet(){
		boolean exit = true;
		for(int i = 0;exit;i++){
			System.out.println("Ingrese el nombre del conjunto al que va a Agregar un elemento");
			String name = lector.nextLine();
			if(mathApp.find(name) != null){
				System.out.println("Ingrese el elemento que va a Agregar a "+name);
				int element = lector.nextInt();
				lector.nextLine();
				boolean wait = mathApp.messageAdd(mathApp.find(name),element);
				if(wait){
					mathApp.addElementToSet(name,element);
					exit = false;
					System.out.println("Elemento agregado correctamente");
				}
				else
					System.out.println("El elemento ya existe, intente nuevamente");
			}
			else{
				System.out.println("El conjunto no existe, intente nuevamente");
			}
		}
	}

	public void removeElement(){
		boolean exit = true;
		for(int i = 0;exit;i++){
			System.out.println("Ingrese el nombre del conjunto al que va a Eliminar un elemento");
			String name = lector.nextLine();
			if(mathApp.find(name) != null){
				System.out.println("Ingrese el elemento que va a Eliminar de "+name);
				int element = lector.nextInt();
				lector.nextLine();
				String message = mathApp.messageRemove(mathApp.find(name),element);
				mathApp.removeElementFromSet(name,element);
				System.out.println(message);
				exit = false;
			}
			else{
				System.out.println("El conjunto no existe, intente nuevamente");
			}
		}	
	}

	public void menuOps(){
		 boolean stop = false;
	   	 for(int l = 0;!stop;l++){
	   	 	 System.out.println("");
	   	     System.out.println("------------------------------------------------------");
             System.out.println("      * QUE DESEA HACER? *");	   	
             System.out.println("------------------------------------------------------");
	         System.out.println("");
	         System.out.println("************************************************************************");
	         System.out.println(" (1.) Realizar union entre 2 conjuntos                                  |");
	         System.out.println(" (2.) Realizar diferencia entre 2 conjuntos                             |");
	         System.out.println(" (3.) Realizar Interseccion entre 2 conjuntos                           |");
	         System.out.println(" (4.) Realizar diferencia Simetrica entre 2 conjuntos                   |");
	         System.out.println("************************************************************************");
	         int option = lector.nextInt();
	         System.out.println("");
	         lector.nextLine();
         
        switch(option){
        	case 1:
         	     System.out.println("** Realizar union entre 2 conjuntos  **");
         	     union();
         	     stop = true;
         	    break;

            case 2:
         	     System.out.println("** Realizar diferencia entre 2 conjuntos  **");
         	     difference();
         	     stop = true;
         	    break;

         	case 3:
         	     System.out.println("** Realizar Interseccion entre 2 conjuntos  **");
         	     intersection();
         	     stop = true;
         	    break;

         	case 4:
         	     System.out.println("** Realizar diferencia Simetrica entre 2 conjuntos **");
         	     symmetricDifference();
         	     stop = true;
         	    break;   
    
            default: 
                System.out.println("Ingreso un numero NO valido");
            }
	    }
	}

	public void union(){
		boolean exit = true;
		for(int i = 0;exit;i++){
			System.out.println("Ingrese el nombre del conjunto A que va a Realizar la union con B");
			System.out.println("Conjunto A:");
			String name1 = lector.nextLine();
			if(mathApp.find(name1) != null){
				System.out.println("Conjunto B:");
				String name2 = lector.nextLine();
				if(mathApp.find(name2) != null){		
					System.out.println("Ingrese el nombre del conjunto que se creara de la union");
					String newName = lector.nextLine();
					mathApp.union(name1,name2,newName);
					System.out.println("");
					System.out.println("La union fue realizada correctamente");
					System.out.println("Al Realizar la union:");
					String message = mathApp.showInfoSet(newName);
					System.out.println(message);
					exit = false;	
				}
				else
					System.out.println("El conjunto B no existe, ingrese nuevamente un nombre");	
			}
			else 
				System.out.println("El conjunto A no existe, ingrese nuevamente un nombre");
		}
	}

	public void difference(){
		System.out.println("Ingrese el nombre del conjunto A que va a Realizar la diferencia con B");
		boolean exit = true;
		for(int i = 0;exit;i++){
			System.out.println("Conjunto A:");
			String name1 = lector.nextLine();
			if(mathApp.find(name1) != null){
				System.out.println("Conjunto B:");
				String name2 = lector.nextLine();
				if(mathApp.find(name2) != null){			
					System.out.println("Ingrese el nombre del conjunto que se creara de la diferencia");
					String newName = lector.nextLine();
					mathApp.difference(name1,name2,newName);
					System.out.println("La diferencia fue realizada correctamente");
					String message = mathApp.showInfoSet(newName);
					System.out.println("Al Realizar la Diferencia de "+name1+"/"+name2+" se da: ");
					System.out.println(message);
					exit = false;
				}
				else
					System.out.println("El conjunto B no existe, ingrese nuevamente un nombre");	
			}
			else 
				System.out.println("El conjunto A no existe, ingrese nuevamente un nombre");
		}
	}

	public void intersection(){
		System.out.println("Ingrese el nombre del conjunto A que va a Realizar la Interseccion con B");
		boolean exit = true;
		for(int i = 0;exit;i++){
			System.out.println("Conjunto A:");
			String name1 = lector.nextLine();
			if(mathApp.find(name1) != null){
				System.out.println("Conjunto B:");
				String name2 = lector.nextLine();
				if(mathApp.find(name2) != null){			
					System.out.println("Ingrese el nombre del conjunto que se creara de la Interseccion");
					String newName = lector.nextLine();
					mathApp.intersection(name1,name2,newName);
					System.out.println("La Interseccion fue realizada correctamente");
					String message = mathApp.showInfoSet(newName);
					System.out.println("Al Realizar la Interseccion:");
					System.out.println(message);
					exit = false;
				}
				else
					System.out.println("El conjunto B no existe, ingrese nuevamente un nombre");	
			}
			else 
				System.out.println("El conjunto A no existe, ingrese nuevamente un nombre");
		}
	}	

	public void symmetricDifference(){
		System.out.println("Ingrese el nombre del conjunto A que va a Realizar la diferencia Simetrica con B");
		boolean exit = true;
		for(int i = 0;exit;i++){
			System.out.println("Conjunto A:");
			String name1 = lector.nextLine();
			if(mathApp.find(name1) != null){
				System.out.println("Conjunto B:");
				String name2 = lector.nextLine();
				if(mathApp.find(name2) != null){			
					System.out.println("Ingrese el nombre del conjunto que se creara de la diferencia Simetrica");
					String newName = lector.nextLine();
					mathApp.symmetricDifference(name1,name2,newName);
					System.out.println("La diferencia Simetrica fue realizada correctamente");
					String message = mathApp.showInfoSet(newName);
					System.out.println("Al Realizar la Diferencia Simetrica:");
					System.out.println(message);
					exit = false;
				}
				else
					System.out.println("El conjunto B no existe, ingrese nuevamente un nombre");	
			}
			else 
				System.out.println("El conjunto A no existe, ingrese nuevamente un nombre");
		}
	}

	public void showASet(){
		System.out.println("Ingrese el nombre del conjunto que desea ver");
		String name = lector.nextLine();
		String message = mathApp.showInfoSet(name);
		System.out.println(message);
	}

	public void showSets(){
		String message = mathApp.showInfoSets();
		System.out.println(message);
	}


}