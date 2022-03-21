package com.javaexamples.widgets;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.javaexamples.models.Customer;
import com.javaexamples.operations.JacksonParser;

public class JacksonParserExample {
	public static void RunJacksonParserExamples() {
		//Initialize needed objects, could be parsed through args as well. Added here for ease-of-use.
		Scanner inputStream = new Scanner(System.in);
		File pathToJson = new File("src/main/resources/customers.json");
		File pathToJsonTwo = new File("src/main/resources/customersWrite.json");
		List<String> result = new ArrayList<String>();

		/*
		 * The Customer list we will be passing around.
		 * Reference type allows us to pass it around instead of assigning it to the return types.
		 */
		List<Customer> customerList = new ArrayList<Customer>();
		
		/*
		 * Due to this being an example project, we will delete the CustomersWrite.json file, 
		 * before running the rest, as we don't want to append to the file.
		 */
		if (pathToJsonTwo.length() > 0) {
			pathToJsonTwo.delete();
		}

		// \n uses the escape sequence "\" combined with the command newline "n". This results in the following text going to the next line.
		System.out.println("Hello World! \nClick anything to begin Parsing JSON to object..");
		inputStream.nextLine();

		try {
			customerList = JacksonParser.parseJsonToCustomer(pathToJson);
			System.out.println("Completed! \nclick anything to continue and list all names..");
			inputStream.nextLine();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		//Print the values.
		customerList.forEach(customer -> {
			System.out.println(customer.getName());
		});

		System.out.println("click anything to begin parsing Object to JSON...");
		inputStream.nextLine();

		try {
			FileWriter fileWriter = new FileWriter(pathToJsonTwo, true);
			result = JacksonParser.parseCustomerToJson(fileWriter, customerList);
			System.out.println("Completed! \nClick anything to print JSON lines..");
			inputStream.nextLine();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		result.forEach(row -> {
			System.out.println(row);
		});

		System.out.println("Click anything to exit...");
		inputStream.nextLine();

		//Always remember to close Scanner's.
		inputStream.close();
	}
}
