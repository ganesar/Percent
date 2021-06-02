package com.percent.api;

import java.math.BigDecimal;

public interface PointOfSaleTerminal {

	/**
	 * This method sets the unit price of a product. 
	 * If the product doesn't exist it is added along with its unit price.
	 * If the product already exists, the unit price will be replaced with the new value.  
	 * The unit price must be greater than zero.
	 * @param productCode The code that uniquely identifies the product 
	 * @param unitPrice  The price per unit for the product
	 * @throws InvalidPriceException if the unitPrice is zero or negative
	 */
	public void setPrice(String productCode, double unitPrice) throws InvalidPriceException;
	

	/**
	 * This method sets the volume discount for a product. 
	 * If the product doesn't exist a productNotFoundException is thrown.
	 * The volume must be greater than or equal to 1. If it is 1, it is assumed that the product is on sale with the discounted price. If it is more than 1, the discount will be applied only for the volume purchased.   
	 * The discounted Price must be greater than zero and more than the per unit price
	 * *
	 * @param productCode  The code that uniquely identifies the product
	 * @param volume The volume of sale for which the discounted price will be applied
	 * @param discountedPrice The discounted price for the volume specified
	 * @throws ProductNotFoundException if the product doesn't exist
	 * @throws InvalidPriceException if the discounted is zero, negative or less than or equal to the per unit price 
	 */
	public void setPrice(String productCode, long volume, double discountedPrice) throws ProductNotFoundException, InvalidPriceException, InvalidVolumeException;
	
	/**
	 * This method is a convenience method that is the equivalent of calling setPrice method to set unit price followed by setPrice method for setting the volume discount.
	 * This method is also provided to avoid multiple calls to the server. 
	 * @param productCode
	 * @param unitPrice
	 * @param volume
	 * @param discountedPrice
	 */
	public void setPrice(String productCode, double unitPrice, long volume, double discountedPrice) throws InvalidPriceException, InvalidVolumeException;
	
	
	/**
	 * This method scans the product being purchased at the point of sale.
	 * @param productCode  The code that uniquely identifies the product
	 * @throws ProductNotFoundException if the product doesn't exist
	 */
	public void scan (String productCode) throws ProductNotFoundException;
	
	/**
	 * This method returns the total value of purchase after applying all the volume discounts. 
	 * @return
	 */
	public BigDecimal calculateTotal();
}
