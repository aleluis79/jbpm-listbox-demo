package org.jbpm;

import java.util.ArrayList;


public class mahin {

	public static void main(String[] args) {
		
		Clientes clientes = new Clientes();
		ArrayList<String> clinetes = (ArrayList<String>) clientes.select();
		
		
		for(int i = 0; i<clinetes.size(); i++) {
			System.out.println(clinetes.get(i));
		}
	}
}
