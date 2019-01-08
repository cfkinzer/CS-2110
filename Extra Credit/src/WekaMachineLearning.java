/** Christian Kinzer
 * cfk5ax
 * CS 2110 Extra Credit
 */



import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;
import java.util.Scanner;

import weka.classifiers.Evaluation;
import weka.classifiers.rules.JRip;
import weka.classifiers.rules.PART;
import weka.classifiers.trees.J48;
import weka.core.Instances;

public class WekaMachineLearning {
	
	public static void main(String[] args) throws Exception {
		
		Scanner scan = new Scanner(System.in); // create a scanner to read from the console
		System.out.println("Which dataset would you like to use?"); // prompt for the dataset
		String set = scan.nextLine(); // sets the input dataset as a string
		System.out.println("Which algorithm would you like to use? (J48, JRip, PART)"); // prompt for the algorithm
		String algo = scan.nextLine(); // sets the input algorithm as a string
		System.out.println("Enter the number of folds (k) split cross validations."); // prompt for the number of folds
		System.out.println("(Entering '5' will give you 80% Training and 20% Testing.)"); // ^^^
		System.out.println("(Entering '10' will give you 90% Training and 10% Testing.)"); // ^^^
		int k = Integer.parseInt(scan.nextLine()); // sets the input folds as an int
		while (k < 2) { // as long as k is less than 2
			System.out.println("ERROR: Please enter an integer greater than 2"); // prompt the user to input an int greater than 2
			k = Integer.parseInt(scan.nextLine()); // reset k as the input
		}
		scan.close(); // close the scanner
		
		BufferedReader breader = null; // create a new BufferedReader
		breader = new BufferedReader(new FileReader(set)); // construct the BufferedReader from a FileReader where the param is the input dataset
		
		Instances train = new Instances(breader); // make a new Instances object from the BufferedReader
		train.setClassIndex(train.numAttributes() - 1); // sets the class index to the location in the arff file
		
		breader.close(); // close the BufferedReader
		
		if (algo.equals("J48")) { // if the user said J48
			J48 j = new J48(); // instantiate the J48 object
			j.buildClassifier(train); // set the classifier to the Instances object
			Evaluation eval = new Evaluation(train); // make an Evaluation object that evaluates the J48
			eval.crossValidateModel(j, train, k, new Random(1)); // cross validate the model with k folds
			System.out.println(eval.toSummaryString("\nResults\n------\n", true)); // print the evaluation with the header "Results"
			System.out.println(j.toString()); // print out the rules
		}
		
		if (algo.equals("JRip")) { // if the user said JRip
			JRip j = new JRip(); // instantiate the JRip object
			j.buildClassifier(train); // set the classifier to the Instances object
			Evaluation eval = new Evaluation(train); // same as J48
			eval.crossValidateModel(j, train, k, new Random(1)); // same as J48
			System.out.println(eval.toSummaryString("\nResults\n------\n", true)); // same as J48
			System.out.println(j.toString()); // same as J48
		}
		
		if (algo.equals("PART")) { // if the user said PART
			PART j = new PART(); // instantiate the PART object
			j.buildClassifier(train); // set the classifier to the Instances object
			Evaluation eval = new Evaluation(train); // same as for J48
			eval.crossValidateModel(j, train, k, new Random(1)); // same as for J48
			System.out.println(eval.toSummaryString("\nResults\n------\n", true)); // same as for J48
			System.out.println(j.toString()); // same as J48
		}
	}
}
