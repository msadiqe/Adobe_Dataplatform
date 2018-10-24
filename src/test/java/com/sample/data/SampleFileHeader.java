package com.sample.data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SampleFileHeader {

	public static List<String> Cosmos_Sephora_Cust_Purchase_Metrics() {

		List<String> header_Cust_Purchase_Metrics = new ArrayList<String>();
		header_Cust_Purchase_Metrics.add("RPTING_PRD"); // Numeric/25/Y
		header_Cust_Purchase_Metrics.add("RPTING_PRD"); // String/50/y
		header_Cust_Purchase_Metrics.add("SLS_CHNL"); // String/100/y
		header_Cust_Purchase_Metrics.add("FIRST_PURCHASE_TRAN_DT"); // date/02/n
		header_Cust_Purchase_Metrics.add("LAST_SECOND_PURCHASE_TRAN_DT"); // date/20/n
		header_Cust_Purchase_Metrics.add("LAST_PURCHASE_TRAN_DT"); // date/20/n
		header_Cust_Purchase_Metrics.add("PURCHASE_TRAN_CNT"); // numeric
		header_Cust_Purchase_Metrics.add("RPTING_DT"); // datetime/20
		return header_Cust_Purchase_Metrics;
	}

	public static List<String> Cosmos_Sephora_Cust_Classes_Metrics() {

		List<String> header_Cust_Classes = new ArrayList<String>();
		header_Cust_Classes.add("COSMOS_CUST_ID"); //Numeric/25/Y
		header_Cust_Classes.add("RPTING_PRD"); //string50Y
		header_Cust_Classes.add("SRV_TYPE");	//string100Y
		header_Cust_Classes.add("ATTENDANCE_CNT");	//numeric int64 19
		header_Cust_Classes.add("RPTING_DT");	// datetime/20
		return header_Cust_Classes;

	}

	public static List<String> Cosmos_Sephora_Cust_Campaign_Metrics() {

		List<String> header_Cust_Campaign_Metrics = new ArrayList<String>();
		header_Cust_Campaign_Metrics.add("COSMOS_CUST_ID"); // P/25/Numeric
		header_Cust_Campaign_Metrics.add("RPTING_PRD"); // P/50/String
		header_Cust_Campaign_Metrics.add("CMPGN_CHNL"); // p/100/String
		header_Cust_Campaign_Metrics.add("EVNT_TYPE"); // p/100/string
		header_Cust_Campaign_Metrics.add("EVNT_ACTVTY_CNT");// np/25/numeric
		header_Cust_Campaign_Metrics.add("RPTING_DT"); // np/TimeStamp/20
		return header_Cust_Campaign_Metrics;
	}
	
	public static List<String> Cosmos_Sephora_Cust_Community_Metrics(){
		
		List<String> header_Cust_Community_Metrics = new ArrayList<String>();
		header_Cust_Community_Metrics.add("COSMOS_CUST_ID"); //P/25/Numeric
		header_Cust_Community_Metrics.add("RPTING_PRD");	//P/50/string
		header_Cust_Community_Metrics.add("GRP_NM");	//P/100/string
		header_Cust_Community_Metrics.add("GRP_LAST_ACTN_TYPE");	//100/string
		header_Cust_Community_Metrics.add("GRP_LAST_ACTN_DT");	//20/date
		header_Cust_Community_Metrics.add("GRP_VISIT_CNT");	//numeric int64/19
		header_Cust_Community_Metrics.add("RPTING_DT");	//TimeStamp/20
		return header_Cust_Community_Metrics;
	}

}
