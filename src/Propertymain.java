import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

//Author : Redwan Hossain
/*Firstly this program is going to  open the file “Properties.txt” then its gonna read the data from the file
And then its gonna store the data in array list. The program is able to display the data on the screen and its
also going to print the data in "PropertyOut.txt" file. The program is also able to delete, add and update a 
property.*/
//This the main class. I'm excuting all the methods here
public class Propertymain {

	public static void main(String[] args) throws FileNotFoundException {

		// This code is going to read data from this file

		String inputFile = "C:\\QA Practice-AF\\Properties.txt";

		// This code is going to write data to this file

		String outFile = "C:\\QA Practice-AF\\PropertyOut.txt";

		// Initializing Property array of object

		ArrayList<Property> proArray = new ArrayList<>();

		// Read Property.txt file

		readFileInClassObject(inputFile);

		// read Property.txt and populate Property object

		readFileInClassObject(proArray, inputFile);

		// Will let user to delete, add and update

		upDdateProperty(proArray);

		// will let to write in the file and then print in the console

		printDataFromArray(proArray, outFile);

	}

	// Will read the "property.txt" and then will print that in console

	public static void readFileInClassObject(String inf) throws FileNotFoundException {

		System.out.println("\n\nOutput of file using the scanner object");

		File inputFile = new File(inf);

		Scanner sc = new Scanner(inputFile);

		while (sc.hasNextLine()) {

			String line = sc.nextLine();

			System.out.println(line);

		}

		sc.close();

		System.out.println();

	}

	// This method read data from files and set the Property object variable for
	// each object of the array

	public static void readFileInClassObject(ArrayList<Property> proArray, String inf) throws FileNotFoundException {

		File inputFile = new File(inf);

		// PrintWriter output = new PrintWriter(of);

		Scanner sc = new Scanner(inputFile);

		String line = sc.nextLine();

		// output.println(line);

		int count = 0;

		String tempNum;

		// Looping through the file by reading each line and populating array of
		// Property

		while (sc.hasNextLine()) {

			line = sc.nextLine();

			// Holding each line to String array which is split by a comma

			String[] words = line.trim().split("\t");

			int id = Integer.parseInt(words[0]);

			String address = words[1];

			tempNum = words[2].replace("$", "");

			double purchasePrice = Integer.parseInt(tempNum.replaceAll(",", ""));

			tempNum = words[3].replace("$", "");

			double rehabCost = Integer.parseInt(tempNum.replaceAll(",", ""));

			tempNum = words[4].replace("$", "");

			double priceSold = Integer.parseInt(tempNum.replaceAll(",", ""));

			proArray.add(new Property(id, address, purchasePrice, rehabCost, priceSold));

			count++;

		}

		sc.close();

	}

	// Will let user to update, delete and add property

	public static void upDdateProperty(ArrayList<Property> proArray) throws NoSuchElementException {

		int choice;

		do {
			// will let user to input a number
			Scanner inputChoice = new Scanner(System.in);

			// will print these options for user to chose

			System.out.println("1.Delete a property");

			System.out.println("2.Add a property");

			System.out.println("3. Update a property");

			System.out.println("4. Enter 4 to exit");

			System.out.print("Enter 1, 2 , 3 0r 4 : ");

			choice = inputChoice.nextInt();

			System.out.println();

			// Switch statements to execute user choice

			switch (choice) {

			case 1:

				// call deleteProperty method to delete a property

				System.out.println("You have choosed to delete a property");

				deleteProperty(proArray, inputChoice);

				break;

			case 2:

				// call addProperty to a property to the array

				System.out.println("You have choosed to add a propery");

				addProperty(proArray, inputChoice);

				break;

			case 3:

				// will update the property

				System.out.println("You have choosed to update a property");

				updateProperty(proArray);

				break;

			case 4:

				// end the loop

				System.out.println("Enter 4 to exit");

				break;

			default:

				System.out.println("Wrong entry! You entered " + choice);

			}

		} while (choice != 4);

	}

	// This method implement to update a property

	private static void updateProperty(ArrayList<Property> proArray) {

		Scanner input = new Scanner(System.in);

		Scanner inputAddress = new Scanner(System.in);

		System.out.println("You are about to update a propery,are you sure? If yes go ahead");

		System.out.print("\nEnter property id: ");

		int propertyID = input.nextInt();

		for (int i = 0; i < proArray.size(); i++) {

			if (proArray.get(i).getID() == propertyID) {

				System.out.print("\nEnter Updated Address: ");

				String updatedAddress = inputAddress.nextLine();

				System.out.print("Updated address " + proArray.get(i).getAddress());

				proArray.get(i).setAddress(updatedAddress);

				System.out.println(" to " + updatedAddress);

			}

		}

	}

	// Is going to update a property
	private static void addProperty(ArrayList<Property> proArray, Scanner inputPrice) {

		Scanner inputProperety = new Scanner(System.in);

		Scanner input = new Scanner(System.in);

		String newAdderss = "";

		System.out.println("Looks like you are trying to add a propery, If yes go ahead");

		System.out.print("Enter address: ");

		if (inputProperety.hasNextLine())

			newAdderss = inputProperety.nextLine();

		System.out.print("\nEnter Purchase price: ");

		double newPurchasePrice = inputProperety.nextDouble();

		System.out.print("\nEnter Rehab Price: ");

		double newRehabPrice = inputProperety.nextDouble();

		System.out.print("\n Enter Price Sold: ");

		double newPriceSold = inputProperety.nextDouble();

		proArray.add(new Property(proArray.size() + 1, newAdderss, newPurchasePrice, newRehabPrice, newPriceSold));

		System.out.println("\nNew Property added is: \naddress: " + newAdderss + "\nPurchase Price: $"
				+ newPurchasePrice + "\nRehab Price: $" + newRehabPrice

				+ "\nPrice Sold: $" + newPriceSold + "\n");

	}

	// This code is going to ask user to enter a id to delete a property

	private static void deleteProperty(ArrayList<Property> proArray, Scanner inputId) {

		System.out.print("Enter the Id of the the property to delete: ");

		int idNumber = inputId.nextInt();

		for (int i = 0; i < proArray.size(); i++) {

			if (proArray.get(i).getID() == idNumber) {

				System.out.println("You have deleted following property: \n" +

						"Address: " + proArray.get(i).getAddress() + "\nPurchase Price $"
						+ proArray.get(i).getPurchasePrice()

						+ "\nRehab Price $" + proArray.get(i).getRehabCost() + "\nPrice Sold $"
						+ proArray.get(i).getPriceSold() + "\n");

				proArray.set(i, new Property(0, "", 0, 0, 0));

			}

		}

	}

	// This code is going to write in "property.out" file and will print in console
	public static void printDataFromArray(ArrayList<Property> proArray, String of) throws FileNotFoundException {

		// Initializing Writer class with out file path

		PrintWriter output = new PrintWriter(of);

		// Printing header to Propertyout.txt and console

		System.out.println("This is what is being written on PropertyOut.txt file with total proprety details\n");

		System.out.format("%-15s%-15s%-20s%-22s%-10s%20s%21s%22s%15s%15s\n", "ID", "Address", "Purchase Price($)",
				"Rehab Price($)", "Price Sold($)", "Total Cost($)", "Net Income($)", "Taxes($)", "$(P&L)",
				"% Gain/Loss");

		output.format("%-6s%-25s%-20s%-22s%-10s%20s%21s%22s%20s%20s\n", "ID", "Address", "Purchase Price($)",
				"Rehab Price($)", "Price Sold($)", "Total Cost($)", "Net Income($)", "Taxes($)", "$(P&L)",
				"% Gain/Loss");

		output.println();

		for (int i = 0; i < proArray.size(); i++)

		{

			output.format("%-6s%-25s%-20s%-22s%-10s%20s%21s%22s%20s%20s\n",

					proArray.get(i).getID(), proArray.get(i).getAddress(), proArray.get(i).getPurchasePrice(),

					proArray.get(i).getRehabCost(), proArray.get(i).getPriceSold(), proArray.get(i).getTotalCost(),

					proArray.get(i).getNetIncome(), proArray.get(i).getTaxes(), proArray.get(i).getProfitLoss(),

					proArray.get(i).getPercentGainLoss());

			System.out.format("%-6s%-25s%-20s%-22s%-10s%20s%21s%22s%18s%15s\n",

					proArray.get(i).getID(), proArray.get(i).getAddress(), proArray.get(i).getPurchasePrice(),

					proArray.get(i).getRehabCost(), proArray.get(i).getPriceSold(), proArray.get(i).getTotalCost(),

					proArray.get(i).getNetIncome(), proArray.get(i).getTaxes(), proArray.get(i).getProfitLoss(),

					proArray.get(i).getPercentGainLoss());

			output.println();

		}

		TotalProperty(proArray, output);

		output.close();

	}

	// This code will calculate total property, prices,taxes,income, profit and
	// gain/loss

	public static void TotalProperty(ArrayList<Property> proArray, PrintWriter output) throws FileNotFoundException {

		int totalProperty = proArray.size();

		double totalPurchasePrice = 0;

		double totalRehabCost = 0;

		double totalPriceSold = 0;

		double totalPropertyCost = 0;

		double totalPropertyIncome = 0;

		double totalTaxes = 0;

		double totalProfitLoss = 0;

		double totalPercentGainLoss = 0;

		for (int i = 0; i < proArray.size(); i++) {

			if (proArray.get(i).getID() == 0) {

				totalProperty = totalProperty - 1;

			}

			totalPurchasePrice += proArray.get(i).getPurchasePrice();

			totalRehabCost = totalRehabCost + proArray.get(i).getRehabCost();

			totalPriceSold = totalPriceSold + proArray.get(i).getPriceSold();

			totalPropertyCost = totalPropertyCost + proArray.get(i).getTotalCost();

			totalPropertyIncome = totalPropertyIncome + proArray.get(i).getNetIncome();

			totalTaxes = totalTaxes + proArray.get(i).getTaxes();

			totalProfitLoss = totalProfitLoss + proArray.get(i).getProfitLoss();

			totalPercentGainLoss = totalPercentGainLoss + proArray.get(i).getPercentGainLoss();

		}

		System.out.format("Total houses sold%4s%19s%19s%22s%20s%23s%22s%18s%15s\n", totalProperty,
				"$" + totalPurchasePrice,

				"$" + totalRehabCost, "$" + totalPriceSold, "$" + totalPropertyCost, "$" + totalPropertyIncome,
				"$" + totalTaxes, "$" + totalProfitLoss, totalPercentGainLoss + "%");

		output.format("Total houses sold%4s%19S%19s%22s%20s%23s%22s%18s%20s\n", totalProperty, "$" + totalPurchasePrice,

				"$" + totalRehabCost, "$" + totalPriceSold, "$" + totalPropertyCost, "$" + totalPropertyIncome,
				"$" + totalTaxes, "$" + totalProfitLoss, totalPercentGainLoss + "%");

	}

}
/*Output of the project 3:
Output of file using the scanner object
ID	Address	Purchased Price ($)	Rehab Cost ($)	Price	Sold($)
1	1024 BROWN STREET	$33,000	$0	$18,300
2	112 Alvil Road	$80,000	$50,419	$133,061
3	113 CYPRESS DRIVE	$109,600	$30,266	$149,269
4	124 Bradley Circle	$133,302	$75,693	$196,807
5	135 WHITBURN PLACE	$69,700	$32,394	$117,581
6	138 BROOKSIDE  BLVD	$100,000	$48,462	$162,171
7	141 Cross Avenue	$90,000	$5,247	$117,004
8	1529 Seton	$157,000	$36,671	$155,743
9	16 MALVERN ROAD	$108,000	$53,589	$184,082
10	1642 COLEMAN STREET	$49,000	$30,398	$119,040
11	19 Mavista Circle	$19,106	$59,702	$46,062
12	200 BEAU TREE DRIVE	$300,000	$83,457	$362,000
13	21 CREEK LANE	$106,000	$0	$120,600

1.Delete a property
2.Add a property
3. Update a property
4. Enter 4 to exit
Enter 1, 2 , 3 0r 4 : 1

You have choosed to delete a property
Enter the Id of the the property to delete: 1
You have deleted following property: 
Address: 1024 BROWN STREET
Purchase Price $33000.0
Rehab Price $0.0
Price Sold $18300.0

1.Delete a property
2.Add a property
3. Update a property
4. Enter 4 to exit
Enter 1, 2 , 3 0r 4 : 2

You have choosed to add a propery
Looks like you are trying to add a propery, If yes go ahead
Enter address: concord pike

Enter Purchase price: 23100000

Enter Rehab Price: 2399

 Enter Price Sold: 29000000000

New Property added is: 
address: concord pike
Purchase Price: $2.31E7
Rehab Price: $2399.0
Price Sold: $2.9E10

1.Delete a property
2.Add a property
3. Update a property
4. Enter 4 to exit
Enter 1, 2 , 3 0r 4 : 3

You have choosed to update a property
You are about to update a propery,are you sure? If yes go ahead

Enter property id: 2

Enter Updated Address: naamans rd
Updated address 112 Alvil Road to naamans rd
1.Delete a property
2.Add a property
3. Update a property
4. Enter 4 to exit
Enter 1, 2 , 3 0r 4 : 4

Enter 4 to exit
This is what is being written on PropertyOut.txt file with total proprety details

ID             Address        Purchase Price($)   Rehab Price($)        Price Sold($)       Total Cost($)        Net Income($)              Taxes($)         $(P&L)    % Gain/Loss
0                              0.0                 0.0                   0.0                        0.0                  0.0                   0.0               0.0            0.0
2     naamans rd               80000.0             50419.0               133061.0              130419.0               2642.0                 793.0            1849.0          102.0
3     113 CYPRESS DRIVE        109600.0            30266.0               149269.0              139866.0               9403.0                2821.0            6582.0          107.0
4     124 Bradley Circle       133302.0            75693.0               196807.0              208995.0             -12188.0                   0.0          -12188.0          -94.0
5     135 WHITBURN PLACE       69700.0             32394.0               117581.0              102094.0              15487.0                4646.0           10841.0          115.0
6     138 BROOKSIDE  BLVD      100000.0            48462.0               162171.0              148462.0              13709.0                4113.0            9596.0          109.0
7     141 Cross Avenue         90000.0             5247.0                117004.0               95247.0              21757.0                6527.0           15230.0          123.0
8     1529 Seton               157000.0            36671.0               155743.0              193671.0             -37928.0                   0.0          -37928.0          -80.0
9     16 MALVERN ROAD          108000.0            53589.0               184082.0              161589.0              22493.0                6748.0           15745.0          114.0
10    1642 COLEMAN STREET      49000.0             30398.0               119040.0               79398.0              39642.0               11893.0           27749.0          150.0
11    19 Mavista Circle        19106.0             59702.0               46062.0                78808.0             -32746.0                   0.0          -32746.0          -58.0
12    200 BEAU TREE DRIVE      300000.0            83457.0               362000.0              383457.0             -21457.0                   0.0          -21457.0          -94.0
13    21 CREEK LANE            106000.0            0.0                   120600.0              106000.0              14600.0                4380.0           10220.0          114.0
14    concord pike             2.31E7              2399.0                2.9E10             2.3102399E7      2.8976897601E10          8.69306928E9   2.0283828321E10       125528.0
Total houses sold  13       $2.4421708E7          $508697.0       $2.900186342E10        $2.4930405E7       $2.8976933015E10        $8.693111201E9  $2.0283821814E10      126136.0%
*/