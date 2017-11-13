import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
	public static int sum(int value1,int value2) {
		return (value1 + value2);
	}
	

	public static void testAll(Character [] tab, Integer[] values, int n, String []mots) {
		if(n == tab.length) {
			Integer [] resultat = new Integer[values.length];
			for(int i = 0; i< resultat.length; i++) {
				resultat[i]=0;
			}
			int compteur = tab.length-1;
			for(int i = mots[0].length()-1; i >= 0; i--) {
				int lettremotun = 0;
				int lettremotdeux = 0;
				for(int j = 0; j < tab.length; j++) {
					if(tab[j].equals(mots[0].charAt(i))) {
						lettremotun = values[i];
					}
					if(tab[j].equals(mots[0].charAt(i))) {
						lettremotdeux = values[i];
					}
				}
				resultat[compteur]=sum(lettremotun,lettremotdeux);
				compteur--;
			}
			System.out.println("Tab Resultat : "+ Arrays.asList(resultat));
			return;
		}
		outer: for(int i = 0; i < 10; i++) {
			for(int j = 0; j < n; j++) {
				if(values[j] == i)
					continue outer;
			}
			values[n] = i;
			testAll(tab,values,n+1,mots);
		}
	}
	
	public static Set<Character> lettreUnique(String [] tab) {
		Set<Character> lettre = new TreeSet<>();
		for(int cpt = 0; cpt < tab.length; cpt++) {
			for(int j = 0; j < tab[cpt].length(); j++) {
				lettre.add(tab[cpt].charAt(j));
			}
		} 
		return lettre;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try (Scanner sc = new Scanner(System.in)){
	    int nombre = sc.nextInt();
	    sc.nextLine();
	    String tabMots[] = new String[nombre];
	    
	    for(int cpt = 0; cpt < nombre; cpt++) {
	    		tabMots[cpt] = sc.nextLine();
	    } 
	    Character[] lettres = new Character[(lettreUnique(tabMots)).size()];
	    Set<Character> premier = new TreeSet<>();
	    
	    for(String word : tabMots) {
		    premier.add(word.charAt(0));
	    }
	    System.out.println(premier);
	    	    	
	    //Set des mots
	    	lettreUnique(tabMots).toArray(lettres);
	    	
	    	Integer [] values = new Integer[lettres.length];
	    	for(int cpt = 0; cpt < lettres.length; cpt++) {
	    		values[cpt] = 0;
	    	}
	    System.out.println(Arrays.asList(lettres));
	    System.out.println(Arrays.asList(values));
	    testAll(lettres,values,0,tabMots);

	    //System.out.println(lettreUnique(tabMots));
	    
	    //System.out.println(Arrays.asList(tabMots));
	  }
	}
}
