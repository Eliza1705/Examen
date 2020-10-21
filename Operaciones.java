package operaciones;
import static java.lang.Math.exp;
import java.util.Scanner;
public class Operaciones {
static Scanner leer= new Scanner (System.in);
static int opc=0;
    public static void main(String[] args) {
        boolean continuar=true;
      while(continuar){
       System.out.println("*********************************************");
       System.out.println("Eliga una opcion:");
       System.out.println("*********************************************");
       System.out.println("Menu: ");
       System.out.println("1 .- Aritmetico");
       System.out.println(" 2.- Logico");
       System.out.println("3. - Logico V2");
        System.out.println("4. - Salir");
       System.out.println("********************************************");
        opc=leer.nextInt();
        switch(opc){
           
            case 1:
                System.out.println("Bienvenido al caso de las Expresiones Aritmeticas");
                System.out.println("La expresion a resolver es (6+2)*3/2^2-4");
                System.out.println("***************************************************");
                ExpresionesAritmeticas inst=new ExpresionesAritmeticas();
                
            break;
            case 2:
                 System.out.println("Bienvenido al caso de las Expresiones Logicas");
                 System.out.println("La expresion a resolver es [(p->q)^p]->q");
                System.out.println("***************************************************");
                ExpresionesLogicas insta= new ExpresionesLogicas("[(p->q)^p]->q");
                insta.resolver();
                
             //   System.out.println("estas en el caso 2");
            break;
            case 3:
                 System.out.println("Bienvenido al caso de las Expresiones Logicas parte 2");
                System.out.println("***************************************************");
                NewClass instan=new NewClass();
            break;
            case 4:
                continuar=false;
            break;
            default:
                System.out.println("La opcion que elegiste no existe");
                break;
        }
       
    }
    
}}
