package Logica;

import java.util.Arrays;

import LectorTexto.LectorArchivos;
import lpsolve.LpSolve;
import lpsolve.LpSolveException;

public class SolucionModelo {

	public void solucionar(LectorArchivos archivo) {
		// TODO Auto-generated method stub
		for (int j = 0; j < archivo.getCiudades().size(); j++) {
            String[] ciudad = archivo.getCiudades().get(j);
            for(int i=0; i< ciudad.length; i++){
            	String val = ciudad[i].toString();
            	System.out.println("Element: " + val);
            }
            System.out.println("Element: " + Arrays.toString(ciudad));
        }
		int numeroVariables = (archivo.getNumeroCiudades() * 4)+2;
		System.out.println("Numero: " + numeroVariables);
		try {
			//creamos el problema con n*4+2 variables donde n= numero de ciudades
			LpSolve solver = LpSolve.makeLp(0, numeroVariables);
			//a�adimos las restricciones (4 por ciudad)
			for(int i=0; i<archivo.getCiudades().size();i++){
				//se deden de crear reetricciones as� por cada ciudad
				solver.strAddConstraint("1 -1 0 0 0 0 0 0 0 0 0 0 1 0", LpSolve.GE, 1);
				solver.strAddConstraint("1 -1 0 0 0 0 0 0 0 0 0 0 -1 0", LpSolve.GE, -1);
				solver.strAddConstraint("0 0 1 -1 0 0 0 0 0 0 0 0 0 1", LpSolve.GE, 9);
				solver.strAddConstraint("0 0 1 -1 0 0 0 0 0 0 0 0 0 -1", LpSolve.GE, -9);
			}
			
		} catch (LpSolveException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}