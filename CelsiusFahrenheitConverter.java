package assignment10;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CelsiusFahrenheitConverter {

	JFrame frame;
	JButton button;
	JLabel Ce;
	JLabel Fa;
	JTextField CelsiusText;
	JTextField FahrenheitText;

	public CelsiusFahrenheitConverter() {
		createComponent();
		createLayout();
		addComponent();
		setSize();
		setLocation();
		addListener();
		display();
		
	}
	
	public void createLayout() {
		Container con = frame.getContentPane();
		FlowLayout fl = new FlowLayout();
		con.setLayout(fl);
	}

	public void setLocation() {
		Ce.setLocation(100, 10);
		Fa.setLocation(100, 30);
		CelsiusText.setLocation(200, 10);
		FahrenheitText.setLocation(200, 30);
	}

	public void createComponent() {
		frame = new JFrame();
		button = new JButton("Convert");
		Ce = new JLabel("Celsius");
		Fa = new JLabel("Fahrenheit");
		CelsiusText = new JTextField(10);
		FahrenheitText = new JTextField(10);
	}

	public void addComponent() {
		Container con = frame.getContentPane();
		con.add(Ce);
		
		con.add(CelsiusText);
		con.add(Fa);
		con.add(FahrenheitText);
		con.add(button);
	}

	public void setSize() {
		frame.setSize(500, 500);
		button.setSize(30, 10);
		Ce.setSize(100, 50);
		Fa.setSize(100, 50);
	}

	public void display() {

		frame.setVisible(true);
	}
	
	public void addListener() {
		convertBehavior behavior=new convertBehavior();
		button.addActionListener(behavior);
	}

	class convertBehavior implements ActionListener {

		public void fConvertToC(JTextField tf) {
			int temperature = Integer.parseInt(tf.getText());
			int i = Math.round((temperature - 32) * 5 / 9);
			String s = Integer.toString(i);
			CelsiusText.setText(s);
		}
		
		public void cConvertToF(JTextField tf){
			int temperature = Integer.parseInt(tf.getText());
			int i = Math.round(temperature * 9 / 5 + 32);
			String s = Integer.toString(i);
			FahrenheitText.setText(s);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (FahrenheitText.isFocusOwner()) {
				fConvertToC(FahrenheitText);
			} 
			if(CelsiusText.isFocusOwner()){
				cConvertToF(CelsiusText);
			}
		}

	}

	public static void main(String[] args) {

		new CelsiusFahrenheitConverter();

	}

}
