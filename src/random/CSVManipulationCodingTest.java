package random;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class CSVManipulationCodingTest {
    public static void main(String[] args) {
	Path filePath = Paths.get("C:\\Users\\ghar\\Desktop\\data.csv");
	CSVManipulationCodingTest s = new CSVManipulationCodingTest();

	List<String> lines = s.readFile(filePath);
	List<Customer> customers = s.convertToCustomers(lines);
	System.out.println("Total customers:\n" + customers.size());
	Map<String, Integer> byCity = s.getCustomersByCity(customers);
	System.out.println("Customers by city:");
	byCity.forEach((key, val) -> {
	    System.out.println(key + ": " + val);
	});
	
	Map<String, Integer> byCountry = s.getCustomersByCountry(customers);
	System.out.println("Customers by country:");
	byCountry.forEach((key, val) -> {
	    System.out.println(key + ": " + val);
	});
	
	Map<String, Long> byContract = s.getCustomersByContract(customers);
	System.out.println("Country with the largest number of customers' contracts:");
	byContract.forEach((key, val) -> {
	    System.out.println(key + ": " + val);
	});
    }

    private Map<String, Long> getCustomersByContract(List<Customer> customers) {
	Map<String, List<Customer>> map = new TreeMap<>();
	for (Customer customer : customers) {
	    String country = customer.getCountry();
	    if(map.containsKey(country)) {
		List<Customer> custs = map.get(country);
		custs.add(customer);
		map.put(country, custs);
	    } else {
		List<Customer> list = new ArrayList<>();
		list.add(customer);
		map.put(country, list);
	    }
	}
	Map<String, Long> map2 = new TreeMap<>();
	map.forEach((country, customerss) -> {
	    long count = 0;
	    for (Customer customer : customerss) {
		count += Long.valueOf(customer.getContrcnt());
	    }
	    map2.put(country, count);
	});
	return map2;
    }

    private Map<String, Integer> getCustomersByCountry(List<Customer> customers) {
	Map<String, Integer> map = new LinkedHashMap<>();
	List<Customer> sortedCustomers = customers.stream().sorted(Comparator.comparing(Customer::getCountry))
		.collect(Collectors.toList());
	for (Customer customer : sortedCustomers) {
	    String country = customer.getCountry();
	    if (map.containsKey(country)) {
		int count = map.get(country);
		count++;
		map.put(country, count);
	    } else {
		map.put(country, 1);
	    }
	}
	return map;
    }

    private Map<String, Integer> getCustomersByCity(List<Customer> custs) {

	Map<String, Integer> map = new LinkedHashMap<>();
	List<Customer> sortedCustomers = custs.stream().sorted(Comparator.comparing(Customer::getCity))
		.collect(Collectors.toList());
	for (Customer customer : sortedCustomers) {
	    String city = customer.getCity();
	    if (map.containsKey(city)) {
		int count = map.get(city);
		count++;
		map.put(city, count);
	    } else {
		map.put(city, 1);
	    }
	}
//	sortedCustomers.forEach(System.out::println);
	return map;
    }

    private List<Customer> convertToCustomers(List<String> lines) {
	return lines.stream().skip(1).map(line -> {
	    String[] tokens = line.split(",");
	    return new Customer(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4], tokens[5], tokens[6], tokens[7]);
	}).collect(Collectors.toList());
    }

    private List<String> readFile(Path filePath) {
	List<String> lines = new ArrayList<>();
	try {
	    lines = Files.readAllLines(filePath);
	} catch (IOException ex) {
	    System.out.format("I/O Exception", ex);
	}
	return lines;
    }

    private class Customer {
	private String id;
	private String name;
	private String city;
	private String country;
	private String cPerson;
	private String emplcnt;
	private String contrcnt;
	private String contrcost;

	public Customer(String id, String name, String city, String country, String cPerson, String emplcnt,
		String contrcnt, String contrcost) {
	    this.id = id;
	    this.name = name;
	    this.city = city;
	    this.country = country;
	    this.cPerson = cPerson;
	    this.emplcnt = emplcnt;
	    this.contrcnt = contrcnt;
	    this.contrcost = contrcost;
	}

	public String getId() {
	    return id;
	}

	public void setId(String id) {
	    this.id = id;
	}

	public String getName() {
	    return name;
	}

	public void setName(String name) {
	    this.name = name;
	}

	public String getCity() {
	    return city;
	}

	public void setCity(String city) {
	    this.city = city;
	}

	public String getCountry() {
	    return country;
	}

	public void setCountry(String country) {
	    this.country = country;
	}

	public String getcPerson() {
	    return cPerson;
	}

	public void setcPerson(String cPerson) {
	    this.cPerson = cPerson;
	}

	public String getEmplcnt() {
	    return emplcnt;
	}

	public void setEmplcnt(String emplcnt) {
	    this.emplcnt = emplcnt;
	}

	public String getContrcnt() {
	    return contrcnt;
	}

	public void setContrcnt(String contrcnt) {
	    this.contrcnt = contrcnt;
	}

	public String getContrcost() {
	    return contrcost;
	}

	public void setContrcost(String contrcost) {
	    this.contrcost = contrcost;
	}

	@Override
	public String toString() {
	    return "Customer [id=" + id + ", name=" + name + ", city=" + city + ", country=" + country + ", cPerson="
		    + cPerson + ", emplcnt=" + emplcnt + ", contrcnt=" + contrcnt + ", contrcost=" + contrcost + "]";
	}

    }
}
