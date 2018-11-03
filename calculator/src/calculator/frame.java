package calculator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
public class frame extends JFrame {
	
	public void jframe()
	{	
		JFrame frame = new JFrame("demo calculator");
		/*button sector*/
		JPanel pan=new JPanel();
		Container grc=getContentPane();
	pan.setLayout(new GridLayout(4,4,5,5));

	JButton jbt0=new JButton("0");
	JButton jbt1=new JButton("1");
	JButton jbt2=new JButton("2");
	JButton jbt3=new JButton("3");
	JButton jbt4=new JButton("4");
	JButton jbt5=new JButton("5");
	JButton jbt6=new JButton("6");
	JButton jbt7=new JButton("7");
	JButton jbt8=new JButton("8");
	JButton jbt9=new JButton("9");
	JButton jbtac=new JButton("AC");
	JButton jbtbs=new JButton("←");
	JButton jbtadd=new JButton("+");
	JButton jbtdec=new JButton("-");
	JButton jbtmul=new JButton("*");
	JButton jbtdiv=new JButton("/");
	JButton jbtequ=new JButton("=");

	pan.add(jbt1);
	pan.add(jbt2);
	pan.add(jbt3);
	pan.add(jbtadd);
	pan.add(jbt4);
	pan.add(jbt5);
	pan.add(jbt6);
	pan.add(jbtdec);
	pan.add(jbt7);
	pan.add(jbt8);
	pan.add(jbt9);
	pan.add(jbtmul);
	pan.add(jbtac);
	pan.add(jbt0);
	pan.add(jbtbs);
	pan.add(jbtdiv);
	pan.add(jbtequ);
	
	pan.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
	setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	
	



	/*text sector*/
	JPanel textsec=new JPanel();
	Container tx=getContentPane();
	JTextArea txt=new JTextArea();
	txt.setColumns(20);
	txt.setFont(new Font("宋体",Font.PLAIN,20));
	txt.setEditable(false);
    
	/*combination sector*/
	
	Container bas=frame.getContentPane();
	bas.add(pan,BorderLayout.CENTER);
	bas.add(txt,BorderLayout.NORTH);
	frame.pack();
	frame.setVisible(true);
	
/*event dealer*/
	
	jbt0.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			txt.append(jbt0.getText());
		}
	});
	pan.add(jbt0);
	jbt1.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			txt.append(jbt1.getText());
		}
	});
	pan.add(jbt1);
	jbt2.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			txt.append(jbt2.getText());
		}
	});
	pan.add(jbt2);
	jbt3.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			txt.append(jbt3.getText());
		}
	});
	pan.add(jbt3);
	jbt4.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			txt.append(jbt4.getText());
		}
	});
	pan.add(jbt4);
	jbt5.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			txt.append(jbt0.getText());
		}
	});
	pan.add(jbt5);
	jbt6.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			txt.append(jbt0.getText());
		}
	});
	pan.add(jbt6);
	jbt7.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			txt.append(jbt0.getText());
		}
	});
	pan.add(jbt7);
	jbt8.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			txt.append(jbt0.getText());
		}
	});
	pan.add(jbt8);
	jbt9.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			txt.append(jbt0.getText());
		}
	});
	pan.add(jbt9);
	//backspace
	jbtbs.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (null == txt.getText() || txt.getText().equals("")) {
				return;
			}
			String newStr = txt.getText().substring(0, txt.getText().length() - 1);
			txt.setText(newStr);
		}
	});
	pan.add(jbtbs);
	//operand 
	jbtadd.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			txt.append(jbtadd.getText());
		}
	});
	pan.add(jbtdec);
	jbtdec.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			txt.append(jbtdec.getText());
		}
	});
	pan.add(jbtmul);
	jbtmul.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			txt.append(jbtmul.getText());
		}
	});
	pan.add(jbtmul);
	jbtdiv.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			txt.append(jbtdiv.getText());
		}
	});
	pan.add(jbtdiv);
	//equal
	jbtequ.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			String te = txt.getText().replaceAll("\r|\n", "");
			if (null == te || te.matches("^[+,[-],*,/].*") || te.replaceAll("\r|\n", "").length() == 0
					|| te.matches(".*[+,[-],*,/]$")) {
				JOptionPane.showMessageDialog(frame, "输入有误，请检查");
				return;
			}
			String s = te;
			if (te.contains("=")) {
				te.lastIndexOf("=");
				s = te.substring(te.lastIndexOf("=") + 1, te.length());
			}
			Calculator cal= new Calculator();
			BigDecimal count = cal.calculte(s);
			txt.append(jbtequ.getText() + "\r\n");
			txt.append(String.valueOf(count));
		}
	});
	pan.add(jbtequ);
	
	}
}
