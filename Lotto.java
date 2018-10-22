import java.util.*;
import java.io.Console;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

public class Lotto

{
	public static void main(String[]args )
	{
		System.out.println("Gra w Lotto! Podaj szesc ROZNYCH liczb i wygraj miliord monet! ");
	
	// wczytanie liczb
	
	int Numbers[]= new int[6];
	for(int i=0;i<Numbers.length;i++)
		{
		System.out.print("Podaj liczbe nr " );
		System.out.println(i+1);
		Scanner scanner=new Scanner(System.in);
		Numbers[i]=scanner.nextInt();
		}
	
	// sprawdzenie, czy wczytane liczby sa rozne
	
	for(int i=0;i<Numbers.length;i++)
		{
		for(int j=i+1;j<Numbers.length;j++)
			{			
			if(Numbers[i]==Numbers[j])
				{
				System.out.println("Przeciez mowilem, ze liczby nie moga sie powtarzac ");
				}
			}	
		}	
	
	//wylosowanie odpowiedzi: 6 roznych liczb
	
	ArrayList<Integer> list=new ArrayList<Integer>();
	ArrayList<Integer> Wynik=new ArrayList<Integer>();
		
	for(int i=1; i<50;i++)
		{
		list.add(new Integer(i));
		}
		Collections.shuffle(list);
				
	Integer[] Answer=new Integer[list.size()];
	Answer =list.toArray(Answer);
	
	//licznik trafionych liczb 
	
	int counter=0;
	for(int i=0;i<6;i++)
		{
		for(int j=0;j<6;j++)
			{
			if (Numbers[i]==Answer[j])
				{
				counter++;
				}
			}
		}
		
// Wyswietlanie wyniku + switch w zaleznosci od ilosci trafionych liczb
		
	System.out.print("Trafiles " + counter);
	
	switch (counter)
	{
		case 0:
		case 5:
		case 6:
		{
		System.out.print(" liczb");
		break;
		}
		case 1:
		{
		System.out.print(" liczbe");
		break;
		}
		case 2:
		case 3:
		case 4:
		{
		System.out.print(" liczby");
		break;
		}
	}		

	}
}