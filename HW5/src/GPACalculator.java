/** Christian Kinzer
 * cfk5ax
 * CS 2110 HW5
 */

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;



public class GPACalculator extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** Assumptions:
	 * 1. 15 blank credits means 5 3 credit classes
	 * 2. Users will only enter doubles or ints into the target gpa field
	 * 3. Users know that not entering a grade enters the class as a future class
	 * 4. Users won't add a million classes
	 * 5. It is okay for java to throw errors as long as functionality still exists
	 */
	
	JPanel northPanel;
	JPanel southPanel;
	JLabel nameText;
	JTextField name;
	JLabel gradeText;
	JComboBox<String> grade;
	String[] grades;
	int[] creditOptions;
	JComboBox<Integer> credit;
	JLabel creditText;
	JButton add;
	Map<String, Double> gpaMap;
	ArrayList<String> names;
	ArrayList<String> gradeList;
	ArrayList<Double> values;
	ArrayList<Integer> credits;
	int creditTaken;
	JTable currentClasses;
	JButton calcGPA;
	JButton clearAll;
	JButton add15;
	JLabel removeLabel;
	JTextField removeText;
	JLabel GPAText;
	JButton deleteButton;
	JLabel target;
	JTextField targetText;
	JButton refreshTarget;
	JLabel message;
	DefaultTableModel model;
	String[] headers;
	double gpa;
	JLabel warning;
	
	public GPACalculator() {
		
		creditTaken = 0;
		
		headers = new String[] {"Class", "Grade", "Credits"};
		
		model = new DefaultTableModel(headers, 0);
		model.addRow(headers);
		currentClasses = new JTable(model);
		
		names = new ArrayList<String>();
		gradeList = new ArrayList<String>();
		values = new ArrayList<Double>();
		credits = new ArrayList<Integer>();
		
		gpaMap = new HashMap<String, Double>();
		
		gpaMap.put(" ", null);
		gpaMap.put("A+", 4.0);
		gpaMap.put("A", 4.0);
		gpaMap.put("A-", 3.7);
		gpaMap.put("B+", 3.3);
		gpaMap.put("B", 3.0);
		gpaMap.put("B-", 2.7);
		gpaMap.put("C+", 2.3);
		gpaMap.put("C", 2.0);
		gpaMap.put("C-", 1.7);
		gpaMap.put("D+", 1.3);
		gpaMap.put("D", 1.0);
		gpaMap.put("D-", 0.7);
		gpaMap.put("F", 0.0);
		
		String[] grades = {" ", "A+", "A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "D-", "F"};
		int[] creditOptions = {1, 2, 3, 4};
		northPanel = new JPanel();
		northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.Y_AXIS));
		southPanel = new JPanel();
		southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.Y_AXIS));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 600);
		setTitle("GPA Calculator");
		nameText = new JLabel("Class Name: (optional)");
		name = new JTextField(10);
		gradeText = new JLabel("Grade: (optional)");
		grade = new JComboBox<String>(grades);
		credit = new JComboBox<Integer>();
		for (int a : creditOptions) {
			credit.addItem(a);
		}
		creditText = new JLabel("Credits:");
		northPanel.add(nameText);
		northPanel.add(name);
		northPanel.add(gradeText);
		northPanel.add(grade);
		northPanel.add(creditText);
		northPanel.add(credit);
		calcGPA = new JButton("Calculate GPA");
		calcGPA.addActionListener(new gpaListener());
		clearAll = new JButton("Clear all classes");
		clearAll.addActionListener(new clearButtonListener());
		add15 = new JButton("Add 15 blank credit hours");
		add15.addActionListener(new add15Listener());
		removeLabel = new JLabel("Enter the row of the class you'd like to delete");
		removeText = new JTextField(2);
		add = new JButton("Add");
		add.addActionListener(new AddButtonListener());
		GPAText = new JLabel("GPA: ");
		deleteButton = new JButton("Delete");
		deleteButton.addActionListener(new removeButtonListener());
		target = new JLabel("Input your target GPA");
		targetText = new JTextField(5);
		refreshTarget = new JButton("Refresh target calculator");
		refreshTarget.addActionListener(new targetListener());
		message = new JLabel();
		warning = new JLabel();
		northPanel.add(add);
		northPanel.add(add15);
		northPanel.add(clearAll);
		northPanel.add(removeLabel);
		northPanel.add(removeText);
		northPanel.add(deleteButton);
		southPanel.add(calcGPA);
		southPanel.add(GPAText);
		southPanel.add(target);
		southPanel.add(targetText);
		southPanel.add(refreshTarget);
		southPanel.add(message);
		southPanel.add(warning);
		add(northPanel, BorderLayout.NORTH);
		add(southPanel, BorderLayout.SOUTH);
		add(currentClasses, BorderLayout.CENTER);
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private class AddButtonListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String className = name.getText();
			String classGrade = (String) grade.getSelectedItem();
			Integer classCredits = (Integer) credit.getSelectedItem();
			Double gradeNum = gpaMap.get(classGrade);
			names.add(className);
			gradeList.add(classGrade);
			if (!classGrade.equals(" ")) {
				creditTaken += classCredits;
				values.add(gradeNum * classCredits);
			}
			credits.add(classCredits);
			Object[] array = {className, classGrade, classCredits};
			model.addRow(array);
			currentClasses.setModel(model);
		}
	}
	
	private class removeButtonListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String s = removeText.getText();
			int fuck = Integer.parseInt(s);
			if (!gradeList.get(fuck).equals(" ")) {
				creditTaken -= credits.get(fuck);
			}
			model.removeRow(fuck);
			names.remove(fuck);
			gradeList.remove(fuck);
			credits.remove(fuck);
			values.remove(fuck);
			currentClasses.setModel(model);
		}
	}
	
	private class clearButtonListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			model = new DefaultTableModel(headers, 0);
			model.addRow(headers);
			names = new ArrayList<String>();
			gradeList = new ArrayList<String>();
			credits = new ArrayList<Integer>();
			values = new ArrayList<Double>();
			currentClasses.setModel(model);
		}
	}
	
	private class add15Listener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Object[] array = {"", " ", 3};
			for (int i = 0; i < 5; i++) {
				gradeList.add(" ");
				names.add("");
				credits.add(3);
				values.add(null);
				model.addRow(array);
			}
			currentClasses.setModel(model);
		}
	}
	
	private class gpaListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			double totalval = 0.0;
			for (double d : values) {
				totalval += d;
			}
			gpa = totalval / creditTaken;
			double num = gpa * 100;
			gpa = Math.round(num);
			gpa = gpa / 100;
			GPAText.setText("GPA: " + String.valueOf(gpa));
		}
	}
	
	private class targetListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			int totalcreds = 0;
			for (int i : credits) {
				totalcreds += i;
			}
			int emptycreds = totalcreds - creditTaken;
			double targetgpa = Double.parseDouble(targetText.getText());
			double req = (targetgpa * totalcreds - (gpa * creditTaken)) / emptycreds;
			req = req * 100;
			req = Math.round(req);
			req = req / 100;
			message.setText("In order to achieve your target GPA, you must have a GPA of " + req + " for your remaining classes.");
			if (req > 4.0) {
				warning.setText("Required GPA is above 4.0. Try adding more credits.");
			}
			if (req < 2.0) {
				warning.setText("Required GPA is low, you could take fewer credits.");
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GPACalculator();

	}
}
