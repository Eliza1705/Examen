package operaciones;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author m_ang
 */
public class ExpresionesAritmeticas {
Stack pilaNumeros = new Stack();
    Stack pilaOperador = new Stack();

    ExpresionesAritmeticas() {
        String c = "(6+2)*3/2^2-4";
        String oper = "(?=[-+*/^()])|(?<=[-+*/^()])";
        String a[] = c.split(oper);
        InsertarEnPila(a);
    }

    private boolean isNumeric(String cadena) {
        try {
            double d = Double.parseDouble(cadena);

        } catch (NumberFormatException ex) {
            return false;
        }
        return true;
    }

    private void InsertarEnPila(String ar[]) {
        List cadena = new ArrayList();
        for (int i = 0; i < ar.length; i++) {
            if (isNumeric(ar[i])) {
                cadena.add(ar[i]);
                if (i == ar.length - 1) {
                    while (!pilaOperador.empty()) {
                        cadena.add(pilaOperador.peek());
                        pilaOperador.pop();
                    }
                }
            } else {
                int prioridad = prioridad(ar[i]);
                switch (prioridad) {
                    case 0:
                        if (!pilaOperador.empty()) {
                            int prioridadpila = prioridad((String) pilaOperador.peek());
                            if (prioridad == prioridadpila) {
                                cadena.add(pilaOperador.peek());
                                pilaOperador.pop();
                            } else if (prioridadpila >= prioridad) {
                                while (!pilaOperador.empty() && !pilaOperador.peek().equals("(")) {
                                    cadena.add(pilaOperador.peek());
                                    pilaOperador.pop();
                                }
                            }
                        }
                        pilaOperador.push(ar[i]);
                        break;

                    case 1:
                        if (!pilaOperador.empty()) {
                            int prioridadpila2 = prioridad((String) pilaOperador.peek());
                            if (prioridad == prioridadpila2) {
                                cadena.add(pilaOperador.peek());
                                pilaOperador.pop();
                            }
                        }
                        pilaOperador.push(ar[i]);
                        break;
                    case 2:
                        pilaOperador.push(ar[i]);
                        break;
                    case 3:
                        pilaOperador.push(ar[i]);
                        break;
                    case 4:
                        while (!pilaOperador.empty()) {
                            if (pilaOperador.peek().equals("(")) {
                                pilaOperador.pop();
                                break;
                            }
                            cadena.add(pilaOperador.peek());
                            pilaOperador.pop();
                        }
                        break;
                }
            }
        }
        realizarOperaciones(cadena);
    }

    private int prioridad(String s) {
        if (s.equals("+") || s.equals("-")) {
            return 0;
        } else if (s.equals("*") || s.equals("/") || s.equals("%")) {
            return 1;
        } else if (s.equals("^")) {
            return 2;
        } else if (s.equals("(")) {
            return 3;
        } else if (s.equals(")")) {
            return 4;
        }
        return -1;
    } //Fin de la funcion prioridad

    private void realizarOperaciones(List lista) {
        double operador1 = 0, operador2 = 0, resul=0;
        String operadores;
   

        for (int i = 0; i < lista.size(); i++) {
            if (isNumeric((String) lista.get(i))) {
                pilaNumeros.push(lista.get(i));
            } else {
                operadores = (String)lista.get(i);
        
                operador2 =Double.parseDouble(pilaNumeros.pop().toString());
                
                operador1 =Double.parseDouble(pilaNumeros.pop().toString());
           

                switch (operadores) {
                    case "+":
                        resul = operador1 + operador2;
                        pilaNumeros.push(resul);
                        break;
                    case "-":
                        resul = operador1 - operador2;
                        pilaNumeros.push(resul);
                        break;
                    case "*":
                        resul = operador1* operador2;
                        pilaNumeros.push(resul);
                        break;
                    case "/":
                        resul= operador1/ operador2;
                        pilaNumeros.push(resul);
                        break;
                    case "^":
                        resul = Math.pow(operador1, operador2);
                        pilaNumeros.push(resul);
                        break;                
                }
            }
        }
        System.out.println("El resultado final es:  "+resul);
    }
}

