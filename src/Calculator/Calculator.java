package Calculator;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener{

	JFrame frame;
	JTextField textfield;
	JTextField textfield2;
	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[9];
	JButton addButton,subButton,multButton,divButton;
	JButton decButton,equButton,delButton,clrButton,negButton;
	JPanel panel,panel2;
	
	Font myFont = new Font("Comic Sans MS",Font.BOLD,20);
	Font myFont2 = new Font("Comic Sans MS",Font.PLAIN,15);
	
	double num1=0,num2=0,result=0;
	String val1="",val2="";
	char operator;
	
	Calculator(){
		
		frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(450,600);
		frame.setLayout(null);
		
		textfield = new JTextField();
		textfield.setBounds(70,75,300,50);
		textfield.setFont(myFont);
		textfield.setEditable(false);
		textfield.setBorder(null);
		
		textfield2 = new JTextField();
		textfield2.setBounds(70,25,300,50);
		textfield2.setFont(myFont2);
		textfield2.setEditable(false);
		textfield2.setBorder(null);
		
		
		addButton = new JButton("+");
		subButton = new JButton("-");
		multButton = new JButton("*");
		divButton = new JButton("/");
		decButton = new JButton(".");
		equButton = new JButton("=");
		delButton = new JButton("DEL");
		clrButton = new JButton("CLR");
		negButton = new JButton("+/-");
		
		functionButtons[0]=addButton;
		functionButtons[1]=subButton;
		functionButtons[2]=divButton;
		functionButtons[3]=decButton;
		functionButtons[4]=multButton;
		functionButtons[5]=equButton;
		functionButtons[6]=delButton;
		functionButtons[7]=clrButton;
		functionButtons[8]=negButton;
		
		for(JButton button : functionButtons)
		{
			button.addActionListener(this);
			button.setFont(myFont);
			button.setFocusable(false);
		}
		
		for(int i=0;i<10;i++)
		{
			numberButtons[i]=new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(myFont);
			numberButtons[i].setFocusable(false);
		}
		
		delButton.setBounds(145,450,110,50);
		clrButton.setBounds(260,450,110,50);
		negButton.setBounds(70,450,70,50);
		
		panel = new JPanel();
		panel.setBounds(70,145,300,300);
		panel.setLayout(new GridLayout(4,4,10,10));
		
		panel2 = new JPanel();
		panel2.setBounds(69,24,302,102);
		panel2.add(textfield2);
		panel2.add(textfield);
		//panel2.setBackground(Color.cyan);
		
		//panel.setBackground(Color.GRAY);
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(addButton);
		Border border = BorderFactory.createLineBorder(Color.BLACK,1);
		panel2.setBorder(border);
		
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subButton);
		
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(multButton);
		
		panel.add(decButton);
		panel.add(numberButtons[0]);
		panel.add(equButton);
		panel.add(divButton);
		
		frame.add(panel);
		frame.add(panel2);
		frame.add(negButton);
		frame.add(delButton);
		frame.add(clrButton);
		frame.add(textfield);
		frame.add(textfield2);
		frame.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		Calculator calc = new Calculator();

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=0;i<10;i++)
		{
			if(e.getSource()==numberButtons[i]) {
				
				String temp = textfield2.getText();
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
				//textfield2.setText(temp+String.valueOf(i));
			}
		}
		if(e.getSource()==decButton) {
			textfield.setText(textfield.getText().concat("."));
			//textfield2.setText(textfield.getText());
		}
		if(e.getSource()==addButton) {
			num1=Double.parseDouble(textfield.getText());
			val1=textfield.getText();
			operator='+';
			textfield2.setText(textfield.getText()+"+");
			textfield.setText("");
			
		}
		if(e.getSource()==subButton) {
			num1=Double.parseDouble(textfield.getText());
			val1=textfield.getText();
			operator='-';
			textfield2.setText(textfield.getText()+"-");
			textfield.setText("");
			
		}
		if(e.getSource()==multButton) {
			num1=Double.parseDouble(textfield.getText());
			val1=textfield.getText();
			operator='*';
			textfield2.setText(textfield.getText()+"*");
			textfield.setText("");
			
		}
		if(e.getSource()==divButton) {
			num1=Double.parseDouble(textfield.getText());
			val1=textfield.getText();
			operator='/';
			textfield2.setText(textfield.getText()+"/");
			textfield.setText("");
			
		}
		if(e.getSource()==equButton) {
			num2=Double.parseDouble(textfield.getText());
			if(val2.length()==0)val2=textfield.getText();
			switch(operator) {
			case '+' :
				result=num1+num2;
				break;
			case '-' :
				result=num1-num2;
				break;
			case '*' :
				result=num1*num2;
				break;
			case '/' :
				result=num1/num2;
				break;
			}
			String temp=textfield2.getText();
			
			textfield2.setText(String.format("%s%c%s=",val1,operator,val2));
			textfield.setText(String.format("%.2f",result));
			num1=result;
			val1=String.valueOf(result);
			val2="";
		}
		if(e.getSource()==negButton) {
			Double temp = Double.parseDouble(textfield.getText());
			temp*=-1;
			val1=String.valueOf(temp);
			textfield.setText(val1);
		}
		
		if(e.getSource()==clrButton) {
			textfield.setText(null);
			textfield2.setText("");
			num1=0;
			num2=0;
		}
		if(e.getSource()==delButton) {
			String temp = textfield.getText();
			textfield.setText("");
			for(int i=0;i<temp.length()-1;i++) {
				textfield.setText(textfield.getText()+temp.charAt(i));
			}
			
		}
		
		
	}

}
