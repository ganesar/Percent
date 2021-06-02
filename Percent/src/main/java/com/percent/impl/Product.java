package com.percent.impl;

import com.percent.api.InvalidPriceException;
import com.percent.api.InvalidVolumeException;

public class Product {

	private String code;
	private double unitPrice=0;
	private long volume=0;
	private double discountedPrice=0;
	
	public Product (String code) {
		this.code = code;
	}
	public String getCode() {
		return code;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) throws InvalidPriceException{
		if (unitPrice<=0) throw new InvalidPriceException();
		this.unitPrice = unitPrice;
	}
	public long getVolume() {
		return volume;
	}
	public void setVolume(long volume) throws InvalidVolumeException{
		if (volume<=1) throw new InvalidVolumeException();
		this.volume = volume;
	}
	public double getDiscountedPrice() {
		return discountedPrice;
	}
	public void setDiscountedPrice(double discountedPrice) throws InvalidPriceException{
		if (discountedPrice <= unitPrice) throw new InvalidPriceException();
		this.discountedPrice = discountedPrice;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "["+ code + "," + unitPrice + "," + volume + "," +  discountedPrice +"]";
		
	}
}
