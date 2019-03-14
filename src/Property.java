//Author: Redwan Hossain
//This is my property class. I have all the methods here. I also initialized all the variables here. 
public class Property {

	int id;

	String address;

	double purchasePrice;

	double rehabCost;

	double priceSold;

	double totalCost;

	double NetIncome;

	double taxes;

	double profitLoss;

	double percentGainLoss;

	

	Property(int iD, String address, double purchasePrice, double rehabCost, double priceSold){

		id = iD;

		this.address = address;

		this.purchasePrice = purchasePrice;

		this.priceSold = priceSold;

		this.rehabCost = rehabCost;

	}

	
//Get id method
	public int getID() {

		return id;

	}
//set id method
	public void setID(int id){

		this.id = id;

	}
//getaddress method
	public String getAddress() {

		return address;

	}
//setaddress method
	public void setAddress(String address){

		this.address = address;

	}
//getpurchaseprice method
	public double getPurchasePrice() {

		return purchasePrice;

	}
//setPurchasePrice method
	public void setPurchasePrice(double purchasePrice){

		this.purchasePrice = purchasePrice;

	}

	
//getRehabCost method
	public double getRehabCost() {

		return rehabCost;

	}
//setRehabCost method
	public void setRehabCost(double rehabCost){

		this.rehabCost = rehabCost;

	}

	
//getPriceSold method
	public double getPriceSold() {

		return priceSold;

	}
//setPriceSold method
	public void setPriceSold(double priceSold){

		this.priceSold = priceSold;

	}

//getTotalCost method

	public double getTotalCost(){

		return totalCost = purchasePrice+rehabCost;	

	}
	//getNetIncome method
	public double getNetIncome() {

		return NetIncome = priceSold -totalCost ;

	}


	//getTaxes method
	public double getTaxes() {

		if(NetIncome<=0){

			return 0;

		}

		taxes= NetIncome*0.3;

		return Math.round(taxes);

	}

//getProfitLoss mehod

	public double getProfitLoss() {

		 profitLoss = NetIncome - taxes;

		return Math.round(profitLoss);

	}


//getPercentGainLoss method
	public double getPercentGainLoss() {

		 percentGainLoss = (priceSold/totalCost)*100;

		 if(totalCost>priceSold){

			 percentGainLoss=-percentGainLoss;

		 }

		return Math.round(percentGainLoss);

	}

	

}