package com.kitri.awt.design;

import java.awt.*;

public class ListTest extends Frame {

	Panel pE = new Panel();
	Panel pC = new Panel();
	Panel pW = new Panel();
	Panel pG = new Panel();
	
	TextField tfl = new TextField();
	TextField tfr = new TextField();
	
	List listl = new List();
	List listr = new List();
	
	Button btr = new Button("¢¹");
	Button btra = new Button("¢º");
	Button btl = new Button("¢·");
	Button btla = new Button("¢¸");

		
	public ListTest() {
	
		super("List Test !!!");
		
		
		
		pW.setLayout(new BorderLayout(0, 10));
		pW.add(tfl, "South");
		pW.add(listl, "Center");
		
		pC.setLayout(new GridLayout(6,1, 0, 20));
		pC.add(pG);
		pC.add(btr);
		pC.add(btra);
		pC.add(btl);
		pC.add(btla);
		
		pE.setLayout(new BorderLayout(0, 10));
		pE.add(tfr, "South");
		pE.add(listr, "Center");
	
		setLayout(new GridLayout(1, 3, 10, 0));
		add(pE);
		add(pC);
		add(pW);
		
		
		
		listr.add("Mercury");
		 listr.add("Venus");
		 listr.add("Earth");
		 listr.add("JavaSoft");
		 listl.add("Mars");
		 listl.add("Jupiter");
		 listl.add("Saturn");
		 listl.add("Uranus");
		 listr.add("Neptune");
		 listr.add("Pluto");
		
		
		
		
		
		setBounds(300, 200, 300, 500);
		setVisible(true);
		
	}
	
	
	public static void main(String[] args) {
		new ListTest();
	}

}
