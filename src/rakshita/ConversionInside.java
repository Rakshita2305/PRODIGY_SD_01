package rakshita;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;

public class ConversionInside extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel lblinfo;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JTextField txtTemp;
	private JTextField txtcon1;
	private JTextField txtcon2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConversionInside frame = new ConversionInside();
					frame.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ConversionInside() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		lblinfo = new JPanel();
		lblinfo.setBackground(new Color(128, 255, 255));
		lblinfo.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(lblinfo);
		lblinfo.setLayout(null);
		
		String[] Measures = {" ","Celsius","Fahrenheit","Kelvin"};
		JComboBox comboBox = new JComboBox(Measures);
		comboBox.setBackground(new Color(255, 255, 128));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setBounds(247, 76, 117, 28);
		lblinfo.add(comboBox);
		
		btnNewButton = new JButton("Convert");
		btnNewButton.setBackground(new Color(255, 128, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedItem = (String) comboBox.getSelectedItem();
				double temp = Double.parseDouble(txtTemp.getText());
				if(selectedItem=="Celsius")
				{
					double r1 = (double) temp + 273.15;
					txtcon1.setText(r1 + " °K");
					double r2 = (double) temp*9/5 + 32;
					txtcon2.setText(r2 + " °F");
				}
				else if(selectedItem=="Fahrenheit")
				{
					double r1 = (double) (temp-32)*5/9 + 273.15;
					txtcon1.setText(r1 + " °K");
					double r2 = (double) (temp-32)*5/9;
					txtcon2.setText(r2 + " °C");
				}
				else
				{
					double r1 = (double) (temp - 273.15)*9/5 +32;
					txtcon1.setText(r1 + " °F");
					double r2 = (double) temp - 273.15;
					txtcon2.setText(r2 + " °C");
				}
				
			}
		});
		btnNewButton.setBounds(82, 115, 96, 28);
		lblinfo.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Clear");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox.setSelectedIndex(-1);
				txtTemp.setText("");
				txtcon1.setText("");
				txtcon2.setText("");
			}
		});
		btnNewButton_1.setBackground(new Color(255, 128, 255));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(237, 115, 96, 28);
		lblinfo.add(btnNewButton_1);
		
		txtTemp = new JTextField();
		txtTemp.setHorizontalAlignment(SwingConstants.CENTER);
		txtTemp.setBackground(new Color(255, 255, 128));
		txtTemp.setBounds(54, 78, 112, 26);
		lblinfo.add(txtTemp);
		txtTemp.setColumns(10);
		
		txtcon1 = new JTextField();
		txtcon1.setHorizontalAlignment(SwingConstants.CENTER);
		txtcon1.setBackground(new Color(255, 255, 128));
		txtcon1.setBounds(124, 154, 174, 28);
		lblinfo.add(txtcon1);
		txtcon1.setColumns(10);
		
		txtcon2 = new JTextField();
		txtcon2.setHorizontalAlignment(SwingConstants.CENTER);
		txtcon2.setBackground(new Color(255, 255, 128));
		txtcon2.setBounds(124, 193, 174, 28);
		lblinfo.add(txtcon2);
		txtcon2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Tempearture Conversion");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel.setBounds(115, 0, 191, 34);
		lblinfo.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Temp.");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(54, 56, 112, 22);
		lblinfo.add(lblNewLabel_1);
	}
}
