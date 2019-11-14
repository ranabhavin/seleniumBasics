package com.datadriven.test;

import java.util.ArrayList;
import java.util.List;

import Utility.Xls_Reader;

public class ParameterizeTest {

	public static void main(String args[]) {

		Xls_Reader reader = new Xls_Reader("./src/test/resources/testData/testData.xlsx");
		
		// Created a expected String list
				List<String> expected_List = new ArrayList<String>();

		int rowCount = reader.getRowCount("countryTestdata");

		for (int rowNum = 2; rowNum <= rowCount; rowNum++) {

			//System.out.println(reader.getCellData("countryTestdata", "countryName", rowNum));
			expected_List.add(reader.getCellData("countryTestdata", "countryName", rowNum));

		}
		
		for(String val : expected_List) {
			
			System.out.println(val);
		}

		
		
		

	}

}
