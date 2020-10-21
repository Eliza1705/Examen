package operaciones;

import java.util.Scanner;

/**
 *
 * @author m_ang
 */
public class NewClass {
    

public  NewClass(){
log2();
}
public void log2(){
Scanner leer=new Scanner(System.in);
String cadena, letras="", numeros="";
System.out.println("Ingrese un caracter u numero");
cadena=leer.nextLine();
char []arreglo=cadena.toCharArray();
for(int i=0; i<arreglo.length; i++){
if(Character.isLetter(arreglo[i])){
letras+=arreglo[i];
System.out.println("Letra ingresada: " + arreglo[i]);
 }
else if(Character.isDigit(arreglo[i])){
 numeros+=arreglo[i];
 System.out.println("Numero ingresado: " + arreglo[i]);
    }
} 
}
}
