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
	
	public static boolean checkSquare(List<int[]> matrix) {
		//Retorna true si no existe un numero repetido en el cuadrado
		boolean[] check = {false,false,false,false,false,false,false,false,false};
		for(int i = 0; i < matrix.size(); i++)
			for(int j = 0; j < matrix.get(i).length; j++)
				if (matrix.get(i)[j] > 0)
					check[(matrix.get(i)[j])-1] = true;	
				else 
					return false;
		for(int i = 0; i < check.length; i++)
			if(!check[i])
				return false;
		return true;
	}
	
	public static boolean checkRowOrColumn(int[] array) {
		//Retorna true si no existe un numero repetido en la fila o columna
		boolean[] check = {false,false,false,false,false,false,false,false,false};
		for(int i=0; i < array.length; i++)
			if (array[i] > 0)
				check[array[i]-1] = true;
			else 
				return false;
		for(int i = 0; i < check.length; i++)
			if(!check[i])
				return false;
		return true;
	}
	
	public static boolean isSolution(List<int[]> matrix) {
		//chequeamos todas las columnas
		for(int i = 0; i < matrix.size(); i++)
			if(!checkRowOrColumn(getColumn(matrix, i)))
				return false;
		//chequeamos todas las filas
		for(int i = 0; i < matrix.size(); i++)
			if(!checkRowOrColumn(getRow(matrix, i)))
				return false;
		//chequeamos todos los cuadrados
		for(int i = 0; i < matrix.size(); i++) 
			for(int j = 0; j < matrix.get(i).length; j++) 
				if(!checkSquare(getSquare(matrix, i, j)))
					return false;
		return true;
	}
	
	public static void findSolution(List<int[]> matrix){
		if (isSolution(matrix)) // Si es solucion, imprimo la solucion
			for (int[] eachRow : matrix) {
	              System.out.println(Arrays.toString(eachRow));
			}
		else
		{
			for(int i=0; i < matrix.get(0).length; i++) //recorro las filas 
				for(int j=0; j < matrix.size(); j++) //recorro las columnas
					if(matrix.get(i)[j] == 0) //Si la posicion es cero, quiere decir que esta vacio.
						for(int number=1; number <= 9; number++) //Chequeo si el numero que voy a añadir no pertenece ya a la solucion, si no pertenece lo añado
							if (checkNumberInSquare(getSquare(matrix, i, j),number))
								if (checkNumberInRowOrColumn(getColumn(matrix,j), number))
									if (checkNumberInRowOrColumn(getRow(matrix, i),number)) {
										matrix.get(i)[j] = number;
										findSolution(matrix);
									}		
		}
	}
	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<int[]> matrix = new ArrayList<int[]>();
		matrix.add(new int[]{ 3, 1, 0, 5, 7, 8, 4, 9, 2 });
		matrix.add(new int[]{ 5, 2, 9, 1, 3, 4, 7, 0, 8 });
		matrix.add(new int[]{ 4, 8, 7, 6, 2, 9, 5, 3, 1 });
		matrix.add(new int[]{ 2, 6, 3, 4, 1, 5, 9, 8, 0 });
		matrix.add(new int[]{ 9, 0, 4, 8, 6, 3, 0, 2, 5 });
		matrix.add(new int[]{ 8, 5, 1, 7, 0, 2, 0, 4, 3 });
		matrix.add(new int[]{ 1, 0, 8, 9, 4, 7, 2, 5, 6 });
		matrix.add(new int[]{ 6, 9, 0, 3, 5, 1, 8, 0, 4 });
		matrix.add(new int[]{ 0, 4, 5, 2, 0, 6, 3, 1, 9 });
		findSolution(matrix);
		
		/*
		 *Solucion de la matriz
		matrix.add(new int[]{ 3, 1, 6, 5, 7, 8, 4, 9, 2 });
		matrix.add(new int[]{ 5, 2, 9, 1, 3, 4, 7, 6, 8 });
		matrix.add(new int[]{ 4, 8, 7, 6, 2, 9, 5, 3, 1 });
		matrix.add(new int[]{ 2, 6, 3, 4, 1, 5, 9, 8, 7 });
		matrix.add(new int[]{ 9, 7, 4, 8, 6, 3, 1, 2, 5 });
		matrix.add(new int[]{ 8, 5, 1, 7, 9, 2, 6, 4, 3 });
		matrix.add(new int[]{ 1, 3, 8, 9, 4, 7, 2, 5, 6 });
		matrix.add(new int[]{ 6, 9, 2, 3, 5, 1, 8, 7, 4 });
		matrix.add(new int[]{ 7, 4, 5, 2, 8, 6, 3, 1, 9 });
		*/
	}

}
