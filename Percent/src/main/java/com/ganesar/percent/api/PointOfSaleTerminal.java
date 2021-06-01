package com.ganesar.percent.api;

import java.math.BigDecimal;

public interface PointOfSaleTerminal {

	/**
	 * This method sets the unit price of a product. 
	 * The product is added along with its unit price if it doesn't exist.
	 * If the product already exists, the unit price will be replaced with the new value.  
	 * @param productCode The code that uniquely identifies the product 
	 * @param unitPrice  The price per unit for the product
	 */
	public void setPrice(String productCode, double unitPrice) throws InvalidPriceException;
	

	/**
	 * This method sets the volume discount for a product. 
	 * If the product doesn't exist a productNotFoundException is thrown.
	 * @param productCode
	 * @param volume
	 * @param discountedPrice
	 * @throws ProductNotFoundException
	 */
	public void setVolumeDiscount(String productCode, long volume, double discountedPrice) throws ProductNotFoundException, InvalidPriceException, InvalidVolumeException;
	/**
	 * @param productCode
	 * @param unitPrice
	 * @param volume
	 * @param volumePrice
	 */
	public void setUnitAndVolumePricing(String productCode, double unitPrice, long volume, double volumePrice) throws InvalidPriceException, InvalidVolumeException;
	public void scan (String productCode) throws ProductNotFoundException;
	public BigDecimal calculateTotal();
}
