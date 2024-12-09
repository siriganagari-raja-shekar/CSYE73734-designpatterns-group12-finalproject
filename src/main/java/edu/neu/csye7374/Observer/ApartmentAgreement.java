package edu.neu.csye7374.Observer;

import java.util.ArrayList;
import java.util.List;

import edu.neu.csye7374.ApartmentAPI;
import edu.neu.csye7374.Facade.ApartmentHandoverMethod;
import edu.neu.csye7374.Strategy.PromotionalStrategy;
import edu.neu.csye7374.Strategy.RentBonusStrategy;
import edu.neu.csye7374.Strategy.SalesBonusStrategy;
import edu.neu.csye7374.Strategy.BonusStrategy;
import edu.neu.csye7374.Strategy.BonusStrategyAPI;
import edu.neu.csye7374.Strategy.FamilyOfferStrategy;
import edu.neu.csye7374.Strategy.NewMemberOfferStrategy;
import edu.neu.csye7374.Strategy.OfferStrategy;
import edu.neu.csye7374.Strategy.OfferStrategyAPI;
import edu.neu.csye7374.Strategy.StudentOfferStrategy;
import edu.neu.csye7374.state_DP.ApartmentAgreementConfirmed;
import edu.neu.csye7374.state_DP.ApartmentHandovered;
import edu.neu.csye7374.state_DP.ApartmentHandover;
import edu.neu.csye7374.state_DP.ApartmentHandoverStateAPI;
import java.util.HashMap;
import java.util.Map;

public class ApartmentAgreement implements ApartmentHandoverStateAPI {
	private int apartmentId;
	private double apartmentAgreementCost = 0;
	private int apartmentCount = 0;
	private double offerDiscount = 0;
	private double handOverCost;
	private String saleType;
	private ApartmentHandoverMethod handoverMethod;
	private static int counter = 0;
	private List<CheckoutObserverAPI> observers = new ArrayList<>();
	private List<ApartmentAPI> apartmentList = new ArrayList<>();
	private List<String> offersApplied = new ArrayList<>();
	private OfferStrategy usingStrategy = OfferStrategy.NONE;
	private BonusStrategy bonusStrategy = BonusStrategy.RentBonusStrategy;

	{
		observers.add(new ApartmentPriceObserver());
		observers.add(new InventoryObserver());
	}

	private ApartmentHandoverStateAPI agreementConfirmed = new ApartmentAgreementConfirmed(this);
	private ApartmentHandoverStateAPI agreementDispatched = new ApartmentHandover(this);
	private ApartmentHandoverStateAPI agreementHandovered = new ApartmentHandovered(this);
	private ApartmentHandoverStateAPI state;
        
	private static Map<OfferStrategy, OfferStrategyAPI> strategyMap = new HashMap<>();
	{
		strategyMap.put(OfferStrategy.StudentOfferStrategy, new StudentOfferStrategy());
		strategyMap.put(OfferStrategy.PromotionalStrategy, new PromotionalStrategy());
		strategyMap.put(OfferStrategy.FamilyOfferStrategy, new FamilyOfferStrategy());
		strategyMap.put(OfferStrategy.NewMemberOfferStrategy, new NewMemberOfferStrategy());
	}

	private static Map<BonusStrategy, BonusStrategyAPI> bonusStrategyMap = new HashMap<>();
	{
		bonusStrategyMap.put(BonusStrategy.RentBonusStrategy, new RentBonusStrategy());
		bonusStrategyMap.put(BonusStrategy.SalesBonusStrategy, new SalesBonusStrategy());
	}

	public ApartmentAgreement() {
		super();
		this.apartmentId = ++counter;
		this.handoverMethod = ApartmentHandoverMethod.Digital;
	}

	public ApartmentAgreement(double agreementCost, int apartmentCount, double handOverCost, ApartmentHandoverMethod handoverMethod) {
		super();
		this.apartmentId = ++counter;
		this.apartmentAgreementCost = agreementCost;
		this.apartmentCount = apartmentCount;
		this.handoverMethod = handoverMethod;

		if (handoverMethod == ApartmentHandoverMethod.In_Person) {
			this.handOverCost = 0;
		} else {
			this.handOverCost = handOverCost;
		}
	}

	public void addApartment(ApartmentAPI Apartment) {
		apartmentList.add(Apartment);
		apartmentAgreementCost += Apartment.getApartmentPrice();
		apartmentCount++;
		observers.forEach(o -> o.update(this));
	}

	public boolean removeApartment(ApartmentAPI Apartment) {
		if (apartmentList.remove(Apartment)) {
                    return true;
		}
		return false;
	}
        
	public void setUsingStrategy(OfferStrategy usingStrategy) {
			this.usingStrategy = usingStrategy;
	}
	
	public OfferStrategy getUsingStrategy() {
			return usingStrategy;
	}

	public void setBonusStrategy(BonusStrategy bonusStrategy){
		this.bonusStrategy = bonusStrategy;
	}

	public BonusStrategy getBonusStrategy(){
		return this.bonusStrategy;
	}

	public ApartmentHandoverStateAPI getApartmentAgreementConfirmed() {
		return agreementConfirmed;
	}
        
        public void confirmAgreement(){
            this.state = this.agreementConfirmed;
        }

	public void setApartmentAgreementConfirmed(ApartmentHandoverStateAPI agreementConfirmed) {
		this.agreementConfirmed = agreementConfirmed;
	}

	public ApartmentHandoverStateAPI getApartmentAgreementHandovered() {
		return agreementHandovered;
	}

	public void setApartmentAgreementHandovered(ApartmentHandoverStateAPI agreementHandovered) {
		this.agreementHandovered = agreementHandovered;
	}

	public ApartmentHandoverStateAPI getApartmentAgreementDispatched() {
		return agreementDispatched;
	}

	public void setApartmentAgreementDispatched(ApartmentHandoverStateAPI agreementDispatched) {
		this.agreementDispatched = agreementDispatched;
	}

	public ApartmentHandoverStateAPI getState() {
		return state;
	}

	public void setState(ApartmentHandoverStateAPI state) {
		this.state = state;
	}

	public List<ApartmentAPI> getApartmentList() {
		return apartmentList;
	}

	public void setApartmentList(List<ApartmentAPI> ApartmentList) {
		this.apartmentList = ApartmentList;
	}

	public String getApartmentListString() {
		StringBuilder sb = new StringBuilder();
		for (ApartmentAPI b : apartmentList) {
			sb.append(b);
			sb.append("; ");
		}
		return sb.toString();
	}

	public ApartmentHandoverMethod getApartmentHandoverMethod() {
		return handoverMethod;
	}

	public void setApartmentHandoverMethod(ApartmentHandoverMethod handoverMethod) {
		this.handoverMethod = handoverMethod;
		if (handoverMethod == ApartmentHandoverMethod.In_Person) {
			this.handOverCost = 0;
		}
	}

	public static int getCounter() {
		return counter;
	}

	public static void setCounter(int counter) {
		ApartmentAgreement.counter = counter;
	}

	public List<CheckoutObserverAPI> getObservers() {
		return observers;
	}

	public void setObservers(List<CheckoutObserverAPI> observers) {
		this.observers = observers;
	}

	public void setApartmentCount(int apartmentCount) {
		this.apartmentCount = apartmentCount;
	}

	public double getApartmentAgreementCost() {
		return apartmentAgreementCost;
	}

	public void attach(CheckoutObserverAPI observer) {
		observers.add(observer);
	}

	public void detach(CheckoutObserverAPI observer) {
		observers.remove(observer);
	}

	public ApartmentAgreement(int id) {
		this.apartmentId = id;
	}

	public int getApartmentId() {
		return apartmentId;
	}

	public void setApartmentId(int id) {
		this.apartmentId = id;
	}

	public double getTotal() {
		System.out.println("Apartment agreement cost: " + apartmentAgreementCost);
		System.out.println("Offer discount: " + offerDiscount);
		System.out.println("Handover cost: " + handOverCost);

		return apartmentAgreementCost - offerDiscount + handOverCost;
	}

	public void setApartmentAgreementCost(double agreementCost) {
		this.apartmentAgreementCost = agreementCost;
	}

	public int getApartmentCount() {
		return apartmentList.size();
	}

	public double getOfferDiscount() {
		return offerDiscount;
	}

	public void setOfferDiscount(double offerDiscount) {
		this.offerDiscount = offerDiscount;
	}

	public double getHandoverCost() {
		return handOverCost;
	}

	public void setHandoverCost(double handOverCost) {
		this.handOverCost = handOverCost;
	}
        
	public static Map<OfferStrategy, OfferStrategyAPI> getstrategyMap() {
		return strategyMap;
	}

	public List<String> getOffersApplied(){
		return offersApplied;
	}

	public void setOffersApplied(List<String> offersApplied){
		this.offersApplied = offersApplied;
	}

	public String getSaleType(){
		return saleType;
	}

	public void setSaleType(String saleType){
		this.saleType = saleType;
	}
	
	public double runStrategy() {
		double value = 0;
		System.out.println("Using strat: "+ this.usingStrategy);
		this.setOffersApplied(new ArrayList<String>());
		switch (this.usingStrategy) {
			case StudentOfferStrategy:
				value = ApartmentAgreement.getstrategyMap().get(OfferStrategy.StudentOfferStrategy).discountAmt(this);
				break;
			case PromotionalStrategy:
				value = ApartmentAgreement.getstrategyMap().get(OfferStrategy.PromotionalStrategy).discountAmt(this);
				break;
			case FamilyOfferStrategy:
				value = ApartmentAgreement.getstrategyMap().get(OfferStrategy.FamilyOfferStrategy).discountAmt(this);
				break;
			case NewMemberOfferStrategy:
				value = ApartmentAgreement.getstrategyMap().get(OfferStrategy.NewMemberOfferStrategy).discountAmt(this);
				break;
			default:
				value = this.getApartmentAgreementCost();
				this.setOfferDiscount(0);
				break;
		}
		observers.forEach(o -> o.update(this));
		return value;
	}

	public double runBonusStrategy(){

		double value = 0;
		
		switch (this.bonusStrategy) {
			case RentBonusStrategy:
				value = ApartmentAgreement.bonusStrategyMap.get(BonusStrategy.RentBonusStrategy).calculateBonus(this.getApartmentAgreementCost());
				break;
			case SalesBonusStrategy:
				value = ApartmentAgreement.bonusStrategyMap.get(BonusStrategy.SalesBonusStrategy).calculateBonus(this.getApartmentAgreementCost());
				break;
			default:
				value = ApartmentAgreement.bonusStrategyMap.get(BonusStrategy.RentBonusStrategy).calculateBonus(this.getApartmentAgreementCost());
				break;
		}

		return value;

	}

	@Override
	public String toString() {
		return "ApartmentAgreement [id=" + apartmentId + ", AgreementCost=" + apartmentAgreementCost + ", count=" + apartmentCount + ", discount="
				+ offerDiscount
				+ ", handOverCost=" + handOverCost + "]";
	}

	@Override
	public void apartmentConfirmed_state() {
		this.state.apartmentConfirmed_state();
	}

	@Override
	public void apartmentHandoverStatus_state() {
		this.state.apartmentHandoverStatus_state();
	}

	@Override
	public void apartmentHandovered_state() {
		this.state.apartmentHandovered_state();
	}
}
