//Combine What Number and How many.



import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


import java.awt.Color;
import javax.swing.JLabel;


import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;


@SuppressWarnings("serial")
public class Task_Switch extends JFrame implements KeyListener

{



	int i=0;
	int j=0;

	String[] arr1 = new String[5];
	String[] arr2 = new String[5];
	String[] arr3 = new String[5];


	int array_count1=0;

	private JPanel contentPane;
	blankFrame b1=new blankFrame();
	JLabel label2;
	JLabel label1;
	String[] labels1 = new String[] { "111", "1", "333", "3" };
	String[] labels = new String[] { "How Many  ?", "What Number ? " };
	String randomTitle;
	String randomTitle1;
	final Random rand = new Random();

	String typed;


	public static void main(String[] args)
	{

		EventQueue.invokeLater(new Runnable() 
		{

			public void run() 
			{
				try {
					Task_Switch frame = new Task_Switch();
					frame.setVisible(true);
				} 
				catch(Exception e) 
				{ e.printStackTrace(); 
				}
			}

		});
	}

	public Task_Switch()
	{

		setBackground(Color.BLACK);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		final Random rand = new Random();
		int index = rand.nextInt(labels.length);
		randomTitle = labels[index];
		label1 = new JLabel(randomTitle, JLabel.CENTER);
		label1.setFont(new Font("Dialog", Font.PLAIN, 28));
		label1.setForeground(Color.WHITE);
		label1.setBounds(533, 270, 246, 42);
		contentPane.add(label1);

		final Random rand1 = new Random();
		int index1 = rand1.nextInt(labels1.length);
		randomTitle1 = labels1[index1];
		label2 = new JLabel(randomTitle1, JLabel.CENTER);
		label2.setFont(new Font("Dialog", Font.PLAIN, 28));
		label2.setForeground(Color.WHITE);
		label2.setFont(new Font("Dialog", Font.PLAIN, 28));
		label2.setBounds(606, 335, 105, 42);
		contentPane.add(label2);

		System.out.print(randomTitle + " " + randomTitle1);
		writeInArray();
		array_count1++;

		JTextField tf;
		tf = new JTextField(15);
		tf.addKeyListener(this);
		contentPane.add(tf);

		b1.setVisible(true);



	}

	@Override
	public void keyReleased(KeyEvent e1)
	{


	}

	@Override
	public void keyTyped(KeyEvent e1)
	{

	}

	@Override
	public void keyPressed(KeyEvent e) 
	{

		if(array_count1<5)
		{

			if (e.getKeyChar() == KeyEvent.VK_3 || e.getKeyChar() == KeyEvent.VK_1) 
			{

				System.out.print("  You have typed " + e.getKeyChar() + "\n");
				char number = e.getKeyChar();
				typed=Character.toString(number);


				System.out.print(randomTitle + "  " + randomTitle1);

				writeInArray();
				array_count1++;


				b1.setVisible(true);	


				int index = rand.nextInt(labels.length);
				randomTitle = labels[index];
				label1.setText(randomTitle);

				final Random rand1 = new Random();
				int index1 = rand1.nextInt(labels1.length);
				randomTitle1 = labels1[index1];
				label2.setText(randomTitle1);


			}

			else {
				label1.setText(randomTitle);
				label2.setText(randomTitle1);
			}
		}
		else
		{
			label1.setText("Done.....");
			label2.setText("Press Space to exist");
			
			
			try {
				writeInExcel();
			} catch (IOException e1) {

				e1.printStackTrace();
			}
		}




	}

	public void writeInArray()
	{
		arr1[array_count1]=randomTitle;
		arr2[array_count1]=randomTitle1;
		arr3[array_count1]=typed;


	}


	public void writeInExcel() throws IOException 
	{
		BufferedWriter br = new BufferedWriter(new FileWriter("C:\\Users\\Shabista\\Desktop\\Task_Switch.csv"));
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		StringBuilder sb3 = new StringBuilder();

		// Append strings from array
		for (String element : arr1 ) 
		{
			sb1.append(element);
			sb1.append(",");
		}

		sb1.append("\n");

		for (String element2 : arr2) 
		{
			sb2.append(element2);
			sb2.append(",");
		}

		sb2.append("\n");


		for (String element3 : arr3) 
		{
			sb3.append(element3);
			sb3.append(",");
		}

		sb1.append("\n");

		br.write(sb1.toString());
		br.write(sb2.toString());
		br.write(sb3.toString());

		br.close();
	}

}
