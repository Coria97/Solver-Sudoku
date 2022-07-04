package Solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Main {

	public static List<int[]> getSquare(List<int[]> matrix, int row, int column){
		//Retorna el cuadrante a evaluar
		List<int[]> square = new ArrayList<int[]>();
		int rowStart = 0;
		int columnStart= 0;
		//Busca desde que fila hasta que fila hacer el get y desde que columna a que columna hacer el get
		if (row <= 2) {
			if (column > 2 && column <=5) 
				columnStart = 3;
			else
				if (column > 5) 
					columnStart = 6;
		}
		else
			if (row > 2 && row <=5) {
				rowStart = 3;
				if (column > 2 && column <=5) 
					columnStart = 3;
				else
					if (column > 5) 
						columnStart = 6;
			}
			else
			{	
				rowStart = 6;
				if (column > 2 && column <=5) 
					columnStart = 3;
				else
					if (column > 5) 
						columnStart = 6;
			}
		square.add(new int[]{matrix.get(rowStart)[columnStart],matrix.get(rowStart)[columnStart +1],matrix.get(rowStart)[columnStart +2]});
		square.add(new int[]{matrix.get(rowStart + 1)[columnStart],matrix.get(rowStart + 1)[columnStart +1],matrix.get(rowStart + 1)[columnStart +2]});
		square.add(new int[]{matrix.get(rowStart + 2)[columnStart],matrix.get(rowStart + 2)[columnStart +1],matrix.get(rowStart + 2)[columnStart +2]});
		return square;
	}
	
	public static int[] getRow(List<int[]> matrix, int row) {
		//retorna la fila a evaluar
		int[] rowSol = {0,0,0,0,0,0,0,0,0};
		for(int i=0; i < matrix.get(row).length; i++)
			rowSol[i] = matrix.get(row)[i];
		return rowSol;
	}
	
	public static int[] getColumn(List<int[]> matrix, int column) {
		//retorna la columna a evaluar
		int[] columnSol = {0,0,0,0,0,0,0,0,0};
		for(int i=0; i < matrix.size(); i++)
			columnSol[i] = matrix.get(i)[column];
		return columnSol;
	}
	
	public static boolean checkNumberInSquare(List<int[]> matrix, int number) {
		//Si ya existe el numero en el cuadrante retorna false, caso contrario retorna true
		for(int i = 0; i < matrix.size(); i++)
			for(int j = 0; j < matrix.get(i).length; j++)
				if(matrix.get(i)[j] == number)
					return false;
		return true;
	}
	
	public static boolean checkNumberInRowOrColumn(int[] array, int number) {
		//Si ya existe el numero en la fila o columna retorna false, caso contrario retorna true
		for(int i = 0; i < array.length; i++)
			if(array[i] == number)
				return false;
		return true;
	}
	
	public static boolean checkSquare(List<int[]> matrix) {//falta probar
		//Retorna true si no existe un numero repetido en el cuadrado
		boolean[] check = {false,false,false,false,false,false,false,false,false};
		for(int i = 0; i < matrix.size(); i++)
			for(int j = 0; j < matrix.get(i).length; j++)
				check[(matrix.get(i)[j])-1] = true;	
		for(int i = 0; i < check.length; i++)
			if(!check[i])
				return false;
		return true;
	}
	
	public static boolean checkRowOrColumn(int[] array) {//falta probar
		//Retorna true si no existe un numero repetido en la fila o columna
		boolean[] check = {false,false,false,false,false,false,false,false,false};
		for(int i=0; i < array.length; i++)
			check[array[i]-1] = true;
		for(int i = 0; i < check.length; i++)
			if(!check[i])
				return false;
		return true;
	}
	
	public boolean isSolution(List<int[]> matrix) {
		
		return false;
	}
	
	public void findSolution(List<int[]> matrix){
		if (isSolution(matrix)) // Si es solucion, imprimo la solucion
			for (int[] eachRow : matrix) {
	              System.out.println(Arrays.toString(eachRow));
			}
		else
		{
			for(int i=0; i < matrix.get(0).length; i++) //recorro las filas 
				for(int j=0; j < matrix.size(); j++) //recorro las columnas
					if(matrix.get(i)[j] == 0) //Si la posicion es cero, quiere decir que esta vacio.
						for(int number=1; number <= 9; number++) {
							
						}
							
							
				
		}
	}
	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<int[]> matrix = new ArrayList<int[]>();
		matrix.add(new int[]{0,0,0,0,0,0,0,0,1});
		matrix.add(new int[]{0,1,0,0,2,0,0,3,0});
		matrix.add(new int[]{0,0,0,0,0,0,0,0,0});
		matrix.add(new int[]{0,0,0,0,0,0,0,0,0});
		matrix.add(new int[]{0,4,0,0,5,0,0,6,0});
		matrix.add(new int[]{0,0,0,0,0,0,0,0,0});
		matrix.add(new int[]{0,0,0,0,0,0,0,0,0});
		matrix.add(new int[]{0,7,0,0,8,0,0,9,0});
		matrix.add(new int[]{0,0,0,0,0,0,0,0,0});
		
		//for(int i=0; i < matrix.get(0).length; i++)
		//	System.out.println(matrix.get(0)[i]);
		/*for (int[] eachRow : matrix) {
              System.out.println(Arrays.toString(eachRow));
		}*/
	}

}
