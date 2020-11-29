import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Calculator extends Frame implements ActionListener, WindowListener {

	// I changed this file!	
	TextField tf, tf2;
	ArrayList<Button> buttons = new ArrayList<Button>(
				Arrays.asList(
						new Button("7"),
						new Button("8"),
						new Button("9"),
						new Button("+"),
						new Button("4"),
						new Button("5"),
						new Button("6"),
						new Button("-"),
						new Button("1"),
						new Button("2"),
						new Button("3"),
						new Button("*"),
						new Button("C"),
						new Button("0"),
						new Button("="),
						new Button("/")
					)
			);

	// Label value
	StringBuilder labelString = new StringBuilder("0");
	// Stored value
	StringBuilder memString = new StringBuilder("2.00000000000010101010");
	String opString = new String();
	
	Calculator() {
		int btnSize = 75;
		int textFieldHeight = 50;
		int appWidth = 300;
		
		setTitle("Calculator");
		setLayout(null);
		setSize(appWidth,500);
		
		// Define the text field
		tf = new TextField();
		tf.setBounds(0,textFieldHeight,appWidth,50);
		tf.setText(labelString.toString());
		tf.setEditable(false);
		add(tf);
		
		// The below for loop adds buttons at the correct positions
		for(int i = 0; i < buttons.size(); i++) {
			int xBound = btnSize*(i%4);
			int yBound = textFieldHeight + 50 + btnSize*(i/4);
			buttons.get(i).setBounds(xBound, yBound, btnSize, btnSize);
			add(buttons.get(i));
			buttons.get(i).addActionListener(this);
		}
		
		setVisible(true);
		addWindowListener(this);
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		dispose();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String val = e.getActionCommand();
		switch(val) {
			case "1": 
			case "2":
			case "3":
			case "4":
			case "5":
			case "6":
			case "7":
			case "8":
			case "9":
			case "0":
				this.enterCalcValue(val);
				break;
				
			case "+":
				this.addKeyPressed();
				break;
				
			case "-":
				this.subtractKeyPressed();
				break;
				
			case "*":
				this.multiplyKeyPressed();
				break;
				
			case "/":
				this.divideKeyPressed();
				break;
				
			case "=":
				this.equalKeyPressed();
				break;
			
			case "C":
				this.clearEverything();
				break;	
		}
	}
	
	private void equalKeyPressed() {
		this.calculate();
		
		if(opString.length() == 0 || opString.toString().charAt(0) != '=') {
			opString = new String("=");
		}
		
		tf.setText(memString.toString());
	}
	
	private void calculate() {
		boolean isStarted = memString.toString() == "2.00000000000010101010";
		
		if(isStarted) {
			memString = labelString;
			labelString = new StringBuilder("0");
			return;
		} 
		
		double a = Double.parseDouble(memString.toString());
		double b = Double.parseDouble(labelString.toString());
		double res;
		
		switch(opString.toString()) {
			case "+":
				res = a + b;
				break;
			case "-":
				res = a - b;
				break;
			case "*":
				res = a * b;
				break;
			case "/":
				res = a / b;
				break;
			case "=":
				res = a;
				break;
			default: 
				res = b;
		}
		
		memString = new StringBuilder(Double.toString(res));
		labelString = new StringBuilder("0");
		
	}
	
	private void divideKeyPressed() {
		this.calculate(); 
		
		if(opString.length() == 0 || opString.toString().charAt(0) != '/') {
			opString = new String("/");
		}

		tf.setText(memString.toString());
	}

	private void multiplyKeyPressed() {
		this.calculate();
		
		if(opString.length() == 0 || opString.toString().charAt(0) != '*'){			
			opString = new String("*");
		}
		
		// Set the memString value and show it
		tf.setText(memString.toString());	
	}

	private void subtractKeyPressed() {
		this.calculate();		
		
		if(opString.length() == 0 || opString.toString().charAt(0) != '-'){			
			opString = new String("-");	
		}
		
		// Set the memString value and show it
		tf.setText(memString.toString());
	}

	private void addKeyPressed() {
		this.calculate();
		
		if(opString.length() == 0 || opString.toString().charAt(0) != '+'){			
			opString = new String("+");
		}
		
		// Set the memString value and show it
		tf.setText(memString.toString());
	}

	public void enterCalcValue(String val) {
		
		// Append the label string 
		if(labelString.charAt(0) == '0' && labelString.length() == 1) {
			labelString = new StringBuilder(val);
		} else {					
			labelString.append(val);
		}
		
		// Set the labelString value and show it
		tf.setText(labelString.toString());
	}
	
	public void clearEverything() {
		// Clear the string
		memString = new StringBuilder("2.00000000000010101010");
		labelString = new StringBuilder("0");
		opString = new String();
		
		// Set the labelString value and show it
		tf.setText(labelString.toString());
	}
	
	public static void main(String[] args) {
		new Calculator();
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}
