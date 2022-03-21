package com.javaexamples.operations;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SequenceWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.javaexamples.models.Customer;

public class JacksonParser {
	public static List<Customer> parseJsonToCustomer(File pathToJsonFile) throws StreamReadException, DatabindException, IOException {
		//Initialize Jackson.databind.ObjectMapper & Customer object
		ObjectMapper objectMapper = JsonMapper.builder().findAndAddModules().configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false).build();
		List<Customer> customerList = new ArrayList<Customer>();
		
		customerList = objectMapper.readValue(pathToJsonFile, new TypeReference<List<Customer>>(){});
		
		//assign values to customerList according to data gathered from JSON.
		return customerList;
	}
	
	public static List<String> parseCustomerToJson(FileWriter pathToJson, List<Customer> customerList) throws StreamWriteException, DatabindException, IOException {
		//Initialize ObjectMapper, SequenceWriter and List<String>. SequenceWriter is needed to use the WriteAll function.
		ObjectMapper jsonMapper = JsonMapper.builder().findAndAddModules().configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false).build();
		SequenceWriter seqWriter = jsonMapper.writerWithDefaultPrettyPrinter().writeValuesAsArray(pathToJson);
		List<String> returnJson = new ArrayList<String>();
		
		seqWriter.writeAll(customerList);
		
		for (Customer customer : customerList) {
			returnJson.add(jsonMapper.writeValueAsString(customer));
		}
		
		return returnJson;
	}
}