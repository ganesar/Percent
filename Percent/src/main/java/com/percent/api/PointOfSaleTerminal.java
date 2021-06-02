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
	 * This method sets the unit price, volume and discounted price. 
	 * If the product doesn't exist it is added along with its unit price, volume and discounted price.
	 * If the product already exists, the unit price, volume and discounted price will be replaced with the new values.  
	 * @param productCode The code that uniquely identifies the product
	 * @param unitPrice  The price per unit for the product
	 * @param volume The size for the discounted price
	 * @param discountedPrice The discounted volume purchase price
	 * @throws InvalidPriceException 
	 * 		- if the unitPrice is zero or negative
	 * 		- if the discounted price is zero or negative
	 *      - if the discounted price less than the unit price
	 * @throws InvalidVolumeException if the volume is less than or equal to 1
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
