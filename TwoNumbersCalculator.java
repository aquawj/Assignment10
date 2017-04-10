package assignment10;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TwoNumbersCalculator {
	JFrame frame;
	JRadioButton add;
	JRadioButton minus;
	JRadioButton multiply;
	JRadioButton divide;
	JTextField one;
	JTextField two;
	JTextArea equalSign;
	JTextField outcome;
	JButton button;
	JLabel headline;
	JLabel number1;
	JLabel number2;
	Container con;


	public TwoNumbersCalculator() {
		createComponent();
		createLayout();
		addComponent();
		initial();
		addListener();
		display();

	}

	private void createComponent() {
		frame = new JFrame();
		con = frame.getContentPane();
		headline = new JLabel("Calculator", JLabel.CENTER);
		add = new JRadioButton("+");
		minus = new JRadioButton("-");
		multiply = new JRadioButton("*");
		divide = new JRadioButton("/");
		number1=new JLabel("number1",JLabel.CENTER);
		number2=new JLabel("number2",JLabel.CENTER);
		one = new JTextField(10);
		two = new JTextField(5);
		//equalSign = new JTextArea("=");
		outcome = new JTextField(5);
		button = new JButton("Calculate");
	}

	private void createLayout() {
		BoxLayout bl = new BoxLayout(con, BoxLayout.Y_AXIS);
		con.setLayout(bl);
	}

	private void addComponent() {

		con.add(headline);
		con.add(number1);
		con.add(one);
		con.add(add);
		con.add(minus);
		con.add(multiply);
		con.add(divide);
		con.add(number2);
		con.add(two);
		//con.add(equalSign);
		con.add(button);
		con.add(outcome);

	}

	private void initial() {
		frame.setSize(400, 600);
		Font f1 = new Font("sans_serif", Font.BOLD, 20);
		Font f2 = new Font("sans_serif", Font.BOLD, 30);
		changeFont(con, f1);
		headline.setForeground(Color.ORANGE);
		headline.setFont(f2);
		button.setBackground(Color.ORANGE);
		button.setForeground(Color.WHITE);
	

	}

	public void changeFont(Component component, Font font) {
		
		component.setFont(font);
		if (component instanceof Container) {
			for (Component child : ((Container) component).getComponents()) {
				changeFont(child, font);
			}
		}
	}

	private void addListener() {
		CalculateBehavior calculate = new CalculateBehavior();
		button.addActionListener(calculate);
	}

	class CalculateBehavior implements ActionListener {
		
		String si="",sd = "";

		public int addNumbers(int x, int y) {
			return x + y;
		}

		public double addNumbers(double x, double y) {
			return x + y;
		}

		public int minusNumbers(int x, int y) {
			return x - y;
		}

		public double minusNumbers(double x, double y) {
			return x - y;
		}

		public int multiplyNumbers(int x, int y) {
			return x * y;
		}

		public double multiplyNumbers(double x, double y) {
			return x * y;
		}

		public int divideNumbers(int x, int y) {
			return x / y;
		}

		public double divideNumbers(double x, double y) {
			return x / y;
		}
		
		public void outcomeSet() throws Exception{
			if((one.getText().contains("."))&&(two.getText().contains("."))){
				outcome.setText(sd);
			}
			else if(((one.getText().contains("."))&&!(two.getText().contains(".")))||(!(one.getText().contains("."))&&(two.getText().contains(".")))){
				outcome.setText("please input same types");
			}
			else outcome.setText(si);
		}

		@Override
		public void actionPerformed(ActionEvent e)  {
			int oneNumInt = Integer.parseInt(one.getText());
			int twoNumInt = Integer.parseInt(two.getText());
			double oneNumDb = Double.parseDouble(one.getText());
			double twoNumDb = Double.parseDouble(two.getText());
			
			if (add.isSelected()) {
				si = Integer.toString(addNumbers(oneNumInt, twoNumInt));
				sd=Double.toString(addNumbers(oneNumDb,twoNumDb));
			}
			if (minus.isSelected()) {
				si = Integer.toString(minusNumbers(oneNumInt, twoNumInt));
				sd=Double.toString(minusNumbers(oneNumDb,twoNumDb));
			}
			if (multiply.isSelected()) {
				si = Integer.toString(multiplyNumbers(oneNumInt, twoNumInt));
				sd=Double.toString(multiplyNumbers(oneNumDb,twoNumDb));
			}
			if (divide.isSelected()) {
				si = Integer.toString(divideNumbers(oneNumInt, twoNumInt));
				sd=Double.toString(divideNumbers(oneNumDb,twoNumDb));
			}

			try {
				outcomeSet();
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}

	}

	private void display() {
		frame.setVisible(true);
	}

	public static void main(String[] args) throws Exception {
		new TwoNumbersCalculator();
	}

}
