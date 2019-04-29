package com.kitri.awt.event;

import java.awt.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

public class ColorSelector extends Frame implements AdjustmentListener{
	
	Panel colorP = new Panel();
	Panel colorS = new Panel();
	Panel RGB = new Panel();
	Panel A = new Panel();
	Panel B = new Panel();
	Panel C = new Panel();
		
	
	Label tf = new Label();
	Panel tC = new Panel();
	
	Button ok = new Button("¼±ÅÃ");
	
	Label R1 = new Label("»¡°­", Label.CENTER);	
	Label G1 = new Label("ÃÊ·Ï", Label.CENTER);	
	Label B1 = new Label("ÆÄ¶û", Label.CENTER);
	
	Scrollbar Rr = new Scrollbar(Scrollbar.HORIZONTAL, 127, 10, 0, 265);
	Scrollbar Rr2 = new Scrollbar(Scrollbar.HORIZONTAL, 127, 10, 0, 265);
	Scrollbar Rr3 = new Scrollbar(Scrollbar.HORIZONTAL, 127, 10, 0, 265);
	
	public ColorSelector() {
		super("ColorSelector Test !!!");
		
		A.setLayout(new BorderLayout());
		R1.setBackground(Color.red);
		A.add(R1,"West");
		A.add(Rr,"Center");
		
		B.setLayout(new BorderLayout());
		G1.setBackground(Color.green);
		B.add(G1,"West");
		B.add(Rr2,"Center");
		
		C.setLayout(new BorderLayout());
		B1.setBackground(Color.blue);
		C.add(B1,"West");
		C.add(Rr3,"Center");
		
		RGB.setLayout(new GridLayout(3,1));
		RGB.add(A);
		RGB.add(B);
		RGB.add(C);
				
		colorP.setLayout(new GridLayout(5,1));
		colorP.add(new Label(""));
		colorP.add(new Label(""));
		colorP.add(RGB, "Center");

	
		tC.setLayout(new BorderLayout());
		tC.add(tf, "Center");
		tC.add(ok,"East");
		
		colorS.setLayout(new BorderLayout());
		colorS.add(tC, "South");
		
	
	
		
		setLayout(new GridLayout(1,2));
		add(colorP);
		add(colorS);
		
		setBounds(300, 200, 500, 500);
		setVisible(true);
		
		
		
		changeColor();
		
		
	}
	public static void main(String[] args) {
		new ColorSelector();

		
		
	}
	
	@Override
	public void adjustmentValueChanged(AdjustmentEvent e) {
		
		changeColor();
	}

	private void changeColor() {
		int r = Rr.getValue();
		int g = Rr2.getValue();
		int b = Rr3.getValue();
		colorS.setBackground(new Color(r, g, b));
		tf.setText("r = " + r + " g = " + g + " b = " + b);
	}
	
	


	

}
