package com.percent.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.percent.api.InvalidPriceException;
import com.percent.api.InvalidVolumeException;
import com.percent.api.PointOfSaleTerminal;
import com.percent.api.ProductNotFoundException;

public class DefaultPosTerminalImpl implements PointOfSaleTerminal {

	Map<String, Product> products = new HashMap<String, Product>();
	Map<Product, Long> purchases = new HashMap<Product, Long>();
	
	public void setPrice(String productCode, double unitPrice) throws InvalidPriceException {
		
		if (!products.containsKey(productCode)) {
			products.put(productCode, new Product(productCode));
		}
		Product product = products.get(productCode);
		product.setUnitPrice(unitPrice);
	}

	public void setPrice(String productCode, long volume, double discountedPrice)
			throws ProductNotFoundException, InvalidPriceException, InvalidVolumeException {
		if (!products.containsKey(productCode)) 
			throw new ProductNotFoundException();
		
		Product product = products.get(productCode);
		product.setVolume(volume);
		product.setDiscountedPrice(discountedPrice);
	}

	public void setPrice(String productCode, double unitPrice, long volume, double discountedPrice)
			throws InvalidPriceException, InvalidVolumeException {
		
		setPrice(productCode, unitPrice);
		try {
			setPrice(productCode, volume, discountedPrice);
		}catch (ProductNotFoundException e) {
			throw new RuntimeException("Programming Error. This cannot happen.");
		}

	}

	public void scan(String productCode) throws ProductNotFoundException {
		if (!products.containsKey(productCode)) 
			throw new ProductNotFoundException();
		
		Product product = products.get(productCode);
		long qty=0;
		if (purchases.containsKey(product))
			qty = purchases.get(product);
		
		purchases.put(product, ++qty);

	}

	public BigDecimal calculateTotal() {

		BigDecimal purchaseValue = BigDecimal.ZERO;
		for (Map.Entry<Product,Long> purchase : purchases.entrySet()) {
			
			long qty = purchase.getValue(); 
			Product product = purchase.getKey();
			
			//Apply the volume discount
			if (product.getVolume()==0)
				//There is no volume discount. The product priced fully.
				purchaseValue = purchaseValue.add(new BigDecimal(qty*product.getUnitPrice()));
			else {
				purchaseValue = purchaseValue.add(new BigDecimal(qty/product.getVolume()*product.getDiscountedPrice() //Volume discount 
										+ qty%product.getVolume()*product.getUnitPrice())); //remaining quantity at full price
			}
		}
		return purchaseValue;
	}

}
