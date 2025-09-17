package com.neo.customdatatype;

import java.util.Map;

import com.neo.pojo.BillingAddress;

import io.cucumber.java.DataTableType;

public class CustomDataTableType {
	
	@DataTableType
	public BillingAddress billingAddress(Map<String, String> entry) {
	
		return new BillingAddress(
				
				entry.get("firstname"),
				entry.get("lastname"),
				entry.get("country"),
				entry.get("address_line1"),
				entry.get("city"),
				entry.get("state"),
				entry.get("zip"),
				entry.get("email")
				
				);
	}

}
 