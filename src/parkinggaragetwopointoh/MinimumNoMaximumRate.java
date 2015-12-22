/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkinggaragetwopointoh;

/**
 *
 * @author dvandenberge
 */
public class MinimumNoMaximumRate implements FeeStrategy{
    private double minCharge=1.5;
    private double maxCharge=0;
    private double hourlyRate=.75;
    
    /**
     *
     * @return the base amount ($) charged to the customer
     */
    @Override
    public double getMinCharge(){   
        return minCharge;
    }
    @Override
    public void setMinCharge(double minCharge){
        if(minCharge>maxCharge || minCharge<0){
            throw new IllegalArgumentException();
        }
        this.minCharge=minCharge;
    }
    /**
     *
     * @return the MAXIMUM total of any bill
     */
    @Override
    public double getMaxCharge(){
        return maxCharge;
    }
    @Override
    public void setMaxCharge(double maxCharge){
        this.maxCharge=0;
    }

    /**
     *
     * @return The amount of money charged per hour
     */
    @Override
    public double getHourlyRate(){
        return this.hourlyRate;
    }
    @Override
    public void setHourlyRate(double hourlyRate){
        if(hourlyRate<0){
            throw new IllegalArgumentException();
        }
        this.hourlyRate=hourlyRate;
    }
    
    /**
     *
     * @param time The number of hours spent in a parking garage
     * @return if the hourly rate and min charge is less than the max charge, the total cost is figured 
     * out with the formula, otherwise return the maxCharge
     */
    @Override
    public double getTotalCost(double time){
        return ((time*hourlyRate)+minCharge);
    }
}
