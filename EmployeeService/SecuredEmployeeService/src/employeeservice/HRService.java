package employeeservice;


import java.beans.PropertyChangeSupport;


import java.io.File;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

import org.apache.catalina.realm.GenericPrincipal;

@Path("/employees")
public class HRService {
    private String empFilter = "";
    private String deptFilter = "";
    protected List s_employees = new ArrayList();
    protected List s_departments = new ArrayList();
    private List filtered_employees = new ArrayList();
    private List filtered_departments = new ArrayList();


    public HRService() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
        try {
            s_employees.add(new Employee(174, "Ernest", "Abel", "Sales Representative", 80, "Sales",
                                         "011.44.1644.429267", "011.44.1644.429267", "EABEL", "Ernest", "Ernest", "Ernest",
                                         "Ernest", "Magdalen Centre, The Oxford Science Park", "Oxford", "Oxford", "UK",
                                         "OX9 9ZB", 4, 4, 105, 11000, 2750, 3000, 149, sdf.parse("01-01-2010"), "Eleni",
                                         "Zlotkey"));
            s_employees.add(new Employee(166, "Sundar", "Ande", "Sales Representative", 80, "Sales",
                                         "011.44.1346.629268", "011.44.1346.629268", "SANDE", "Sundar", "Sundar",
                                         "Sundar", "Sundar", "Magdalen Centre, The Oxford Science Park", "Oxford",
                                         "Oxford", "UK", "OX9 9ZB", 5, 4, 85, 8200, 1200, 1000, 147,
                                         sdf.parse("09-14-2004"), "Allison", "Errazuriz"));
            s_employees.add(new Employee(130, "Mary", "Atkinson", "Stock Clerk", 50, "Shipping", "650.124.6234",
                                         "650.124.6234", "MATKINSO", "Mary", "Mary", "Mary", "Mary",
                                         "2011 Main Street", "South San Francisco", "California", "US", "94105", 2, 3,
                                         95, 2800, 700, 0, 121, sdf.parse("03-01-2009"), "Adam", "Fripp"));
            s_employees.add(new Employee(105, "David", "Austin", "Programmer", 60, "IT", "590.423.4569", "590.423.4569",
                                         "DAUSTIN", "David", "David", "David", "David", "2014 Main St", "Southlake",
                                         "Texas", "US", "76034", 3, 4, 100, 4800, 1200, 0, 103, sdf.parse("02-14-2008"),
                                         "Alexander", "Hunold"));
            s_employees.add(new Employee(204, "Hermann", "Baer", "Public Relations Representative", 70,
                                         "Public Relations", "515.123.8888", "515.123.8888", "HBAER", "Hermann",
                                         "Hermann", "Hermann", "Hermann", "Schwanthalerstr. 7031", "Munich", "Bavaria",
                                         "DE", "80925", 5, 4, 105, 10000, 2500, 0, 101, sdf.parse("07-14-2006"),
                                         "Neena", "Kochhar"));
            s_employees.add(new Employee(116, "Shelli", "Baida", "Purchasing Clerk", 30, "Purchasing", "515.127.4563",
                                         "515.127.4563", "SBAIDA", "Shelli", "Shelli", "Shelli", "Shelli",
                                         "2004 Bellevue Ct", "Seattle", "Washington", "US", "98102", 4, 5, 110, 2900,
                                         725, 0, 114, sdf.parse("01-01-2010"), "Deb", "Raphaely"));
            s_employees.add(new Employee(167, "Amit", "Banda", "Sales Representative", 80, "Sales",
                                         "011.44.1346.729268", "011.44.1346.729268", "ABANDA", "Amit", "Amit", "Amit",
                                         "Amit", "Magdalen Centre, The Oxford Science Park", "Oxford", "Oxford", "UK",
                                         "OX9 9ZB", 3, 4, 115, 12200, 3550, 1000, 147, sdf.parse("03-01-2009"),
                                         "Allison", "Errazuriz"));
            s_employees.add(new Employee(172, "Elizabeth", "Bates", "Sales Representative", 80, "Sales",
                                         "011.44.1343.529268", "011.44.1343.529268", "EBATES", "Elizabeth", "Elizabeth",
                                         "Elizabeth", "Elizabeth", "Magdalen Centre, The Oxford Science Park", "Oxford",
                                         "Oxford", "UK", "OX9 9ZB", 4, 5, 110, 13300, 3825, 2500, 148,
                                         sdf.parse("07-14-2006"), "Gerald", "Cambrault"));
            s_employees.add(new Employee(192, "Sarah", "Bell", "Shipping Clerk", 50, "Shipping", "650.501.1876",
                                         "650.501.1876", "SBELL", "Sarah", "Sarah", "Sarah", "Sarah",
                                         "2011 Main Street", "South San Francisco", "California", "US", "94105", 4, 5,
                                         105, 4000, 1000, 0, 123, sdf.parse("02-14-2008"), "Shanta", "Vollman"));
            s_employees.add(new Employee(151, "Dannica", "Bernstein", "Sales Representative", 80, "Sales",
                                         "011.44.1344.345268", "011.44.1344.345268", "DBERNSTE", "Dannica", "Dannica",
                                         "Dannica", "Dannica", "Magdalen Centre, The Oxford Science Park", "Oxford",
                                         "Oxford", "UK", "OX9 9ZB", 3, 4, 100, 10500, 3275, 2500, 145,
                                         sdf.parse("01-01-2010"), "Joanne", "Russell"));
            s_employees.add(new Employee(129, "Laura", "Bissot", "Stock Clerk", 50, "Shipping", "650.124.5234",
                                         "650.124.5234", "LBISSOT", "Laura", "Laura", "Laura", "Laura",
                                         "2011 Main Street", "South San Francisco", "California", "US", "94105", 3, 4,
                                         95, 3300, 825, 0, 121, sdf.parse("03-01-2009"), "Adam", "Fripp"));
            s_employees.add(new Employee(169, "Harrison", "Bloom", "Sales Representative", 80, "Sales",
                                         "011.44.1343.829268", "011.44.1343.829268", "HBLOOM", "Harrison", "Harrison",
                                         "Harrison", "Harrison", "Magdalen Centre, The Oxford Science Park", "Oxford",
                                         "Oxford", "UK", "OX9 9ZB", 3, 4, 90, 10000, 2500, 2000, 148,
                                         sdf.parse("07-14-2006"), "Gerald", "Cambrault"));
            s_employees.add(new Employee(185, "Alex", "Bull", "Shipping Clerk", 50, "Shipping", "650.509.2876",
                                         "650.509.2876", "ABULL", "Alex", "Alex", "Alex", "Alex",
                                         "2011 Main Street", "South San Francisco", "California", "US", "94105", 3, 4,
                                         85, 4100, 1025, 0, 121, sdf.parse("09-14-2004"), "Adam", "Fripp"));
            s_employees.add(new Employee(187, "Anthony", "Cabrio", "Shipping Clerk", 50, "Shipping", "650.509.4876",
                                         "650.509.4876", "ACABRIO", "Anthony", "Anthony", "Anthony", "Anthony",
                                         "2011 Main Street", "South San Francisco", "California", "US", "94105", 3, 4,
                                         90, 3000, 750, 0, 121, sdf.parse("01-01-2010"), "Adam", "Fripp"));
            s_employees.add(new Employee(148, "Gerald", "Cambrault", "Sales Manager", 80, "Sales", "011.44.1344.619268",
                                         "011.44.1344.619268", "GCAMBRAU", "Gerald", "Gerald", "Gerald", "Gerald",
                                         "Magdalen Centre, The Oxford Science Park", "Oxford", "Oxford", "UK",
                                         "OX9 9ZB", 4, 5, 95, 11000, 2750, 3000, 100, sdf.parse("03-01-2009"), "Steven",
                                         "King"));
            s_employees.add(new Employee(154, "Nina", "Cambrault", "Sales Representative", 80, "Sales",
                                         "011.44.1344.987668", "011.44.1344.987668", "NCAMBRAU", "Nina", "Nina",
                                         "Nina", "Nina", "Magdalen Centre, The Oxford Science Park", "Oxford",
                                         "Oxford", "UK", "OX9 9ZB", 5, 4, 100, 9500, 2875, 2000, 145,
                                         sdf.parse("02-14-2008"), "Joanne", "Russell"));
            s_employees.add(new Employee(110, "John", "Chen", "Accountant", 100, "Finance", "515.124.4269",
                                         "515.124.4269", "JCHEN", "John", "John", "John", "John", "2004 Bellevue Ct",
                                         "Seattle", "Washington", "US", "98102", 4, 4, 110, 8200, 1950, 0, 108,
                                         sdf.parse("07-14-2006"), "Nancy", "Greenberg"));
            s_employees.add(new Employee(188, "Kelly", "Chung", "Shipping Clerk", 50, "Shipping", "650.505.1876",
                                         "650.505.1876", "KCHUNG", "Kelly", "Kelly", "Kelly", "Kelly",
                                         "2011 Main Street", "South San Francisco", "California", "US", "94105", 4, 5,
                                         115, 3800, 950, 0, 122, sdf.parse("01-01-2010"), "Payam", "Kaufling"));
            s_employees.add(new Employee(119, "Karen", "Colmenares", "Purchasing Clerk", 30, "Purchasing",
                                         "515.127.4566", "515.127.4566", "KCOLMENA", "Karen", "Karen", "Karen", "Karen",
                                         "2004 Bellevue Ct", "Seattle", "Washington", "US", "98102", 3, 4, 110, 2500,
                                         325, 0, 114, sdf.parse("03-01-2009"), "Deb", "Raphaely"));
            s_employees.add(new Employee(142, "Curtis", "Davies", "Stock Clerk", 50, "Shipping", "650.121.2994",
                                         "650.121.2994", "CDAVIES", "Curtis", "Curtis", "Curtis", "Curtis",
                                         "2011 Main Street", "South San Francisco", "California", "US", "94105", 4, 4,
                                         105, 3100, 775, 0, 124, sdf.parse("07-14-2006"), "Kevin", "Mourgos"));
            s_employees.add(new Employee(102, "Lex", "De Haan", "Administration Vice President", 90, "Executive",
                                         "515.123.4569", "515.123.4569", "LDEHAAN", "Lex", "Lex", "Lex", "Lex",
                                         "2004 Bellevue Ct", "Seattle", "Washington", "US", "98102", 4, 5, 100, 17000,
                                         4250, 0, 100, sdf.parse("02-14-2008"), "Steven", "King"));
            s_employees.add(new Employee(186, "Julia", "Dellinger", "Shipping Clerk", 50, "Shipping", "650.509.3876",
                                         "650.509.3876", "JDELLING", "Julia", "Julia", "Julia", "Julia",
                                         "2011 Main Street", "South San Francisco", "California", "US", "94105", 4, 4,
                                         95, 3400, 850, 0, 121, sdf.parse("01-01-2010"), "Adam", "Fripp"));
            s_employees.add(new Employee(189, "Jennifer", "Dilly", "Shipping Clerk", 50, "Shipping", "650.505.2876",
                                         "650.505.2876", "JDILLY", "Jennifer", "Jennifer", "Jennifer", "Jennifer",
                                         "2011 Main Street", "South San Francisco", "California", "US", "94105", 3, 4,
                                         90, 3600, 900, 0, 122, sdf.parse("03-01-2009"), "Payam", "Kaufling"));
            s_employees.add(new Employee(160, "Louise", "Doran", "Sales Representative", 80, "Sales",
                                         "011.44.1345.629268", "011.44.1345.629268", "LDORAN", "Louise", "Louise",
                                         "Louise", "Louise", "Magdalen Centre, The Oxford Science Park", "Oxford",
                                         "Oxford", "UK", "OX9 9ZB", 4, 5, 90, 7500, 1875, 3000, 146,
                                         sdf.parse("09-14-2004"), "Karen", "Partners"));
            s_employees.add(new Employee(104, "Bruce", "Ernst", "Programmer", 60, "IT", "590.423.4568", "590.423.4568",
                                         "BERNST", "Bruce", "Bruce", "Bruce", "Bruce", "2014 Main St", "Southlake",
                                         "Texas", "US", "76034", 4, 5, 85, 6000, 900, 0, 103, sdf.parse("07-14-2006"),
                                         "Alexander", "Hunold"));
            s_employees.add(new Employee(147, "Allison", "Errazuriz", "Sales Manager", 80, "Sales",
                                         "011.44.1344.429278", "011.44.1344.429278", "AERRAZUR", "Allison", "Allison",
                                         "Allison", "Allison", "Magdalen Centre, The Oxford Science Park", "Oxford",
                                         "Oxford", "UK", "OX9 9ZB", 3, 4, 90, 12000, 3000, 3000, 100,
                                         sdf.parse("01-01-2010"), "Steven", "King"));
            s_employees.add(new Employee(193, "Britney", "Everett", "Shipping Clerk", 50, "Shipping", "650.501.2876",
                                         "650.501.2876", "BEVERETT", "Britney", "Britney", "Britney", "Britney",
                                         "2011 Main Street", "South San Francisco", "California", "US", "94105", 3, 4,
                                         95, 3900, 975, 0, 123, sdf.parse("03-01-2009"), "Shanta", "Vollman"));
            s_employees.add(new Employee(109, "Daniel", "Faviet", "Accountant", 100, "Finance", "515.124.4169",
                                         "515.124.4169", "DFAVIET", "Daniel", "Daniel", "Daniel", "Daniel",
                                         "2004 Bellevue Ct", "Seattle", "Washington", "US", "98102", 3, 4, 100, 9000,
                                         2550, 0, 108, sdf.parse("02-14-2008"), "Nancy", "Greenberg"));
            s_employees.add(new Employee(202, "Pat", "Fay", "Marketing Representative", 20, "Marketing", "603.123.6666",
                                         "603.123.6666", "PFAY", "Pat", "Pat", "Pat", "Pat", "147 Spadina Ave",
                                         "Toronto", "Ontario", "CA", "M5V 2L7", 4, 4, 105, 6000, 1500, 0, 201,
                                         sdf.parse("07-14-2006"), "Michael", "Hartstein"));
            s_employees.add(new Employee(197, "Kevin", "Feeney", "Shipping Clerk", 50, "Shipping", "650.507.9822",
                                         "650.507.9822", "KFEENEY", "Kevin", "Kevin", "Kevin", "Kevin",
                                         "2011 Main Street", "South San Francisco", "California", "US", "94105", 3, 4,
                                         110, 3000, 750, 0, 124, sdf.parse("01-01-2010"), "Kevin", "Mourgos"));
            s_employees.add(new Employee(170, "Tayler", "Fox", "Sales Representative", 80, "Sales",
                                         "011.44.1343.729268", "011.44.1343.729268", "TFOX", "Tayler", "Tayler",
                                         "Tayler", "Tayler", "Magdalen Centre, The Oxford Science Park", "Oxford",
                                         "Oxford", "UK", "OX9 9ZB", 5, 4, 115, 9600, 2400, 2000, 148,
                                         sdf.parse("03-01-2009"), "Gerald", "Cambrault"));
            s_employees.add(new Employee(121, "Adam", "Fripp", "Stock Manager", 50, "Shipping", "650.123.2234",
                                         "650.123.2234", "AFRIPP", "Adam", "Adam", "Adam", "Adam", "2011 Main Street",
                                         "South San Francisco", "California", "US", "94105", 3, 4, 110, 8200, 2050, 0,
                                         100, sdf.parse("09-14-2004"), "Steven", "King"));
            s_employees.add(new Employee(190, "Timothy", "Gates", "Shipping Clerk", 50, "Shipping", "650.505.3876",
                                         "650.505.3876", "TGATES", "Timothy", "Timothy", "Timothy", "Timothy",
                                         "2011 Main Street", "South San Francisco", "California", "US", "94105", 5, 4,
                                         105, 2900, 725, 0, 122, sdf.parse("02-14-2008"), "Payam", "Kaufling"));
            s_employees.add(new Employee(135, "Ki", "Gee", "Stock Clerk", 50, "Shipping", "650.127.1734",
                                         "650.127.1734", "KGEE", "Ki", "Ki", "Ki", "Ki", "2011 Main Street",
                                         "South San Francisco", "California", "US", "94105", 3, 4, 100, 2400, 600, 0,
                                         122, sdf.parse("01-01-2010"), "Payam", "Kaufling"));
            s_employees.add(new Employee(183, "Girard", "Geoni", "Shipping Clerk", 50, "Shipping", "650.507.9879",
                                         "650.507.9879", "GGEONI", "Girard", "Girard", "Girard", "Girard",
                                         "2011 Main Street", "South San Francisco", "California", "US", "94105", 3, 4,
                                         95, 2800, 700, 0, 120, sdf.parse("03-01-2009"), "Matthew", "Weiss"));
            s_employees.add(new Employee(206, "William", "Gietz", "Public Accountant", 110, "Accounting",
                                         "515.123.8181", "515.123.8181", "WGIETZ", "William", "William", "William",
                                         "William", "2004 Bellevue Ct", "Seattle", "Washington", "US", "98102", 3, 4,
                                         90, 8300, 2075, 0, 205, sdf.parse("07-14-2006"), "Shelley", "Higgins"));
            s_employees.add(new Employee(199, "Douglas", "Grant", "Shipping Clerk", 50, "Shipping", "650.507.9844",
                                         "650.507.9844", "DGRANT", "Douglas", "Douglas", "Douglas", "Douglas",
                                         "2011 Main Street", "South San Francisco", "California", "US", "94105", 3, 4,
                                         85, 2600, 650, 0, 124, sdf.parse("07-14-2006"), "Kevin", "Mourgos"));
            s_employees.add(new Employee(108, "Nancy", "Greenberg", "Finance Manager", 100, "Finance", "515.124.4569",
                                         "515.124.4569", "NGREENBE", "Nancy", "Nancy", "Nancy", "Nancy",
                                         "2004 Bellevue Ct", "Seattle", "Washington", "US", "98102", 4, 5, 90, 12000,
                                         4100, 0, 101, sdf.parse("01-01-2010"), "Neena", "Kochhar"));
            s_employees.add(new Employee(163, "Daniel", "Greene", "Sales Representative", 80, "Sales",
                                         "011.44.1346.229268", "011.44.1346.229268", "DGREENE", "Daniel", "Daniel",
                                         "Daniel", "Daniel", "Magdalen Centre, The Oxford Science Park", "Oxford",
                                         "Oxford", "UK", "OX9 9ZB", 3, 4, 95, 9500, 2375, 1500, 147,
                                         sdf.parse("03-01-2009"), "Allison", "Errazuriz"));
            s_employees.add(new Employee(152, "Patricia", "Hall", "Sales Representative", 80, "Sales",
                                         "011.44.1344.478968", "011.44.1344.478968", "PHALL", "Patricia", "Patricia", "Patricia",
                                         "Patricia", "Magdalen Centre, The Oxford Science Park", "Oxford", "Oxford", "UK",
                                         "OX9 9ZB", 4, 5, 100, 9000, 2250, 2500, 145, sdf.parse("02-14-2008"), "Joanne",
                                         "Russell"));
            s_employees.add(new Employee(201, "Michael", "Hartstein", "Marketing Manager", 20, "Marketing",
                                         "515.123.5555", "515.123.5555", "MHARTSTE", "Michael", "Michael", "Michael",
                                         "Michael", "147 Spadina Ave", "Toronto", "Ontario", "CA", "M5V 2L7", 3, 4, 110,
                                         13000, 2250, 0, 100, sdf.parse("09-14-2004"), "Steven", "King"));
            s_employees.add(new Employee(205, "Shelley", "Higgins", "Accounting Manager", 110, "Accounting",
                                         "515.123.8080", "515.123.8080", "SHIGGINS", "Shelley", "Shelley", "Shelley",
                                         "Shelley", "2004 Bellevue Ct", "Seattle", "Washington", "US", "98102", 4, 5,
                                         115, 12000, 4000, 0, 101, sdf.parse("01-01-2010"), "Neena", "Kochhar"));
            s_employees.add(new Employee(118, "Guy", "Himuro", "Purchasing Clerk", 30, "Purchasing", "515.127.4565",
                                         "515.127.4565", "GHIMURO", "Guy", "Guy", "Guy", "Guy", "2004 Bellevue Ct",
                                         "Seattle", "Washington", "US", "98102", 4, 4, 110, 2600, 390, 0, 114,
                                         sdf.parse("03-01-2009"), "Deb", "Raphaely"));
            s_employees.add(new Employee(103, "Alexander", "Hunold", "Programmer", 60, "IT", "590.423.4567",
                                         "590.423.4567", "AHUNOLD", "Alexander", "Alexander", "Alexander", "Alexander",
                                         "2014 Main St", "Southlake", "Texas", "US", "76034", 3, 4, 105, 9000, 3250, 0,
                                         102, sdf.parse("07-14-2006"), "Lex", "De Haan"));
            s_employees.add(new Employee(175, "Arthur", "Hutton", "Sales Representative", 80, "Sales",
                                         "011.44.1644.429266", "011.44.1644.429266", "AHUTTON", "Arthur", "Arthur",
                                         "Arthur", "Arthur", "Magdalen Centre, The Oxford Science Park", "Oxford",
                                         "Oxford", "UK", "OX9 9ZB", 3, 4, 100, 8800, 2200, 2500, 149,
                                         sdf.parse("02-14-2008"), "Eleni", "Zlotkey"));
            s_employees.add(new Employee(179, "Charles", "Johnson", "Sales Representative", 80, "Sales",
                                         "011.44.1644.429262", "011.44.1644.429262", "CJOHNSON", "Charles", "Charles",
                                         "Charles", "Charles", "Magdalen Centre, The Oxford Science Park", "Oxford",
                                         "Oxford", "UK", "OX9 9ZB", 3, 2, 95, 9200, 2550, 1000, 149,
                                         sdf.parse("01-01-2010"), "Eleni", "Zlotkey"));
            s_employees.add(new Employee(195, "Vance", "Jones", "Shipping Clerk", 50, "Shipping", "650.501.4876",
                                         "650.501.4876", "VJONES", "Vance", "Vance", "Vance", "Vance",
                                         "2011 Main Street", "South San Francisco", "California", "US", "94105", 3, 4,
                                         90, 2800, 700, 0, 123, sdf.parse("03-01-2009"), "Shanta", "Vollman"));
            s_employees.add(new Employee(122, "Payam", "Kaufling", "Stock Manager", 50, "Shipping", "650.123.3234",
                                         "650.123.3234", "PKAUFLIN", "Payam", "Payam", "Payam", "Payam",
                                         "2011 Main Street", "South San Francisco", "California", "US", "94105", 3, 5,
                                         85, 7900, 1975, 0, 100, sdf.parse("07-14-2006"), "Steven", "King"));
            s_employees.add(new Employee(115, "Alexander", "Khoo", "Purchasing Clerk", 30, "Purchasing", "515.127.4562",
                                         "515.127.4562", "AKHOO", "Alexander", "Alexander", "Alexander", "Alexander",
                                         "2004 Bellevue Ct", "Seattle", "Washington", "US", "98102", 3, 4, 90, 4500,
                                         775, 0, 114, sdf.parse("09-14-2004"), "Deb", "Raphaely"));
            s_employees.add(new Employee(156, "Janette", "King", "Sales Representative", 80, "Sales",
                                         "011.44.1345.429268", "011.44.1345.429268", "JKING", "Janette", "Janette",
                                         "Janette", "Janette", "Magdalen Centre, The Oxford Science Park", "Oxford",
                                         "Oxford", "UK", "OX9 9ZB", 4, 5, 95, 10000, 2500, 3500, 146,
                                         sdf.parse("01-01-2010"), "Karen", "Partners"));
            s_employees.add(new Employee(100, "Steven", "King", "President", 90, "Executive", "515.123.4567",
                                         "515.123.4567", "SKING", "Steven", "Steven", "Steven", "Steven",
                                         "2004 Bellevue Ct", "Seattle", "Washington", "US", "98102", 4, 4, 100, 24000,
                                         6000, 10000, 0, sdf.parse("03-01-2009"), "", ""));
            s_employees.add(new Employee(101, "Neena", "Kochhar", "Administration Vice President", 90, "Executive",
                                         "515.123.4568", "515.123.4568", "NKOCHHAR", "Neena", "Neena", "Neena", "Neena",
                                         "2004 Bellevue Ct", "Seattle", "Washington", "US", "98102", 3, 4, 105, 17000,
                                         6250, 0, 100, sdf.parse("02-14-2008"), "Steven", "King"));
            s_employees.add(new Employee(173, "Sandra", "Kain", "Sales Representative", 80, "Sales",
                                         "011.44.1343.329268", "011.44.1343.329268", "SKAIN", "Sandra", "Sandra",
                                         "Sandra", "Sandra", "Magdalen Centre, The Oxford Science Park", "Oxford",
                                         "Oxford", "UK", "OX9 9ZB", 3, 4, 110, 6100, 1525, 1000, 148,
                                         sdf.parse("07-14-2006"), "Gerald", "Cambrault"));
            s_employees.add(new Employee(137, "Renske", "Ladwig", "Stock Clerk", 50, "Shipping", "650.121.1234",
                                         "650.121.1234", "RLADWIG", "Renske", "Renske", "Renske", "Renske",
                                         "2011 Main Street", "South San Francisco", "California", "US", "94105", 3, 4,
                                         115, 3600, 900, 0, 123, sdf.parse("01-01-2010"), "Shanta", "Vollman"));
            s_employees.add(new Employee(127, "James", "Landry", "Stock Clerk", 50, "Shipping", "650.124.1334",
                                         "650.124.1334", "JLANDRY", "James", "James", "James", "James",
                                         "2011 Main Street", "South San Francisco", "California", "US", "94105", 3, 4,
                                         110, 2400, 600, 0, 120, sdf.parse("03-01-2009"), "Matthew", "Weiss"));
            s_employees.add(new Employee(165, "Daria", "Lee", "Sales Representative", 80, "Sales", "011.44.1346.529268",
                                         "011.44.1346.529268", "DLEE", "Daria", "Daria", "Daria", "Daria",
                                         "Magdalen Centre, The Oxford Science Park", "Oxford", "Oxford", "UK",
                                         "OX9 9ZB", 3, 4, 105, 6800, 1700, 1000, 147, sdf.parse("07-14-2006"),
                                         "Allison", "Errazuriz"));
            s_employees.add(new Employee(177, "Jack", "Livingston", "Sales Representative", 80, "Sales",
                                         "011.44.1644.429264", "011.44.1644.429264", "JLIVINGS", "Jack", "Jack", "Jack",
                                         "Jack", "Magdalen Centre, The Oxford Science Park", "Oxford", "Oxford", "UK",
                                         "OX9 9ZB", 3, 4, 100, 8400, 2100, 2000, 149, sdf.parse("02-14-2008"), "Eleni",
                                         "Zlotkey"));
            s_employees.add(new Employee(107, "Diana", "Lorentz", "Programmer", 60, "IT", "590.423.5567",
                                         "590.423.5567", "DLORENTZ", "Diana", "Diana", "Diana", "Diana", "2014 Main St",
                                         "Southlake", "Texas", "US", "76034", 3, 4, 95, 4200, 850, 0, 103,
                                         sdf.parse("01-01-2010"), "Alexander", "Hunold"));
            s_employees.add(new Employee(133, "Jason", "Mallin", "Stock Clerk", 50, "Shipping", "650.127.1934",
                                         "650.127.1934", "JMALLIN", "Jason", "Jason", "Jason", "Jason",
                                         "2011 Main Street", "South San Francisco", "California", "US", "94105", 3, 4,
                                         90, 3300, 825, 0, 122, sdf.parse("03-01-2009"), "Payam", "Kaufling"));
            s_employees.add(new Employee(128, "Steven", "Markle", "Stock Clerk", 50, "Shipping", "650.124.1434",
                                         "650.124.1434", "SMARKLE", "Steven", "Steven", "Steven", "Steven",
                                         "2011 Main Street", "South San Francisco", "California", "US", "94105", 4, 5,
                                         85, 2200, 550, 0, 120, sdf.parse("09-14-2004"), "Matthew", "Weiss"));
            s_employees.add(new Employee(131, "James", "Marlow", "Stock Clerk", 50, "Shipping", "650.124.7234",
                                         "650.124.7234", "JAMRLOW", "James", "James", "James", "James",
                                         "2011 Main Street", "South San Francisco", "California", "US", "94105", 3, 4,
                                         90, 2500, 625, 0, 121, sdf.parse("07-14-2006"), "Adam", "Fripp"));
            s_employees.add(new Employee(164, "Mattea", "Marvins", "Sales Representative", 80, "Sales",
                                         "011.44.1346.329268", "011.44.1346.329268", "MMARVINS", "Mattea", "Mattea",
                                         "Mattea", "Mattea", "Magdalen Centre, The Oxford Science Park", "Oxford",
                                         "Oxford", "UK", "OX9 9ZB", 4, 5, 95, 7200, 1800, 1000, 147,
                                         sdf.parse("01-01-2010"), "Allison", "Errazuriz"));
            s_employees.add(new Employee(143, "Randall", "Matos", "Stock Clerk", 50, "Shipping", "650.121.2874",
                                         "650.121.2874", "RMATOS", "Randall", "Randall", "Randall", "Randall",
                                         "2011 Main Street", "South San Francisco", "California", "US", "94105", 3, 4,
                                         100, 2600, 650, 0, 124, sdf.parse("03-01-2009"), "Kevin", "Mourgos"));
            s_employees.add(new Employee(203, "Susan", "Mavris", "Human Resources Representative", 40,
                                         "Human Resources", "515.123.7777", "515.123.7777", "SMAVRIS", "Susan", "Susan",
                                         "Susan", "Susan", "8204 Arthur St", "London", "UK", "", "", 3, 4, 110, 6500,
                                         1625, 0, 101, sdf.parse("02-14-2008"), "Neena", "Kochhar"));
            s_employees.add(new Employee(194, "Samuel", "McCain", "Shipping Clerk", 50, "Shipping", "650.501.3876",
                                         "650.501.3876", "SMCCAIN", "Samuel", "Samuel", "Samuel", "Samuel",
                                         "2011 Main Street", "South San Francisco", "California", "US", "94105", 4, 4,
                                         115, 3200, 800, 0, 123, sdf.parse("07-14-2006"), "Shanta", "Vollman"));
            s_employees.add(new Employee(158, "Allysa", "McEwen", "Sales Representative", 80, "Sales",
                                         "011.44.1345.829268", "011.44.1345.829268", "AMCEWEN", "Allysa", "Allysa",
                                         "Allysa", "Allysa", "Magdalen Centre, The Oxford Science Park", "Oxford",
                                         "Oxford", "UK", "OX9 9ZB", 4, 4, 110, 9000, 2250, 3500, 146,
                                         sdf.parse("01-01-2010"), "Karen", "Partners"));
            s_employees.add(new Employee(126, "Irene", "Mikkilineni", "Stock Clerk", 50, "Shipping", "650.124.1224",
                                         "650.124.1224", "IMIKKILI", "Irene", "Irene", "Irene", "Irene",
                                         "2011 Main Street", "South San Francisco", "California", "US", "94105", 4, 4,
                                         105, 2700, 675, 0, 120, sdf.parse("03-01-2009"), "Matthew", "Weiss"));
            s_employees.add(new Employee(124, "Kevin", "Mourgos", "Stock Manager", 50, "Shipping", "650.123.5234",
                                         "650.123.5234", "KMOURGOS", "Kevin", "Kevin", "Kevin", "Kevin",
                                         "2011 Main Street", "South San Francisco", "California", "US", "94105", 4, 5,
                                         100, 5800, 1450, 0, 100, sdf.parse("09-14-2004"), "Steven", "King"));
            s_employees.add(new Employee(125, "Julia", "Nayer", "Stock Clerk", 50, "Shipping", "650.124.1214",
                                         "650.124.1214", "JNAYER", "Julia", "Julia", "Julia", "Julia",
                                         "2011 Main Street", "South San Francisco", "California", "US", "94105", 3, 4,
                                         95, 3200, 800, 0, 120, sdf.parse("02-14-2008"), "Matthew", "Weiss"));
            s_employees.add(new Employee(198, "Donald", "OConnell", "Shipping Clerk", 50, "Shipping", "650.507.9833",
                                         "650.507.9833", "DOCONNEL", "Donald", "Donald", "Donald", "Donald",
                                         "2011 Main Street", "South San Francisco", "California", "US", "94105", 3, 5,
                                         90, 2600, 650, 0, 124, sdf.parse("01-01-2010"), "Kevin", "Mourgos"));
            s_employees.add(new Employee(153, "Christine", "Olsen", "Sales Representative", 80, "Sales",
                                         "011.44.1344.498718", "011.44.1344.498718", "COLSEN", "Christine",
                                         "Christine", "Christine", "Christine",
                                         "Magdalen Centre, The Oxford Science Park", "Oxford", "Oxford", "UK",
                                         "OX9 9ZB", 3, 4, 85, 8000, 2000, 2000, 145, sdf.parse("03-01-2009"), "Joanne",
                                         "Russell"));
            s_employees.add(new Employee(132, "TJ", "Olson", "Stock Clerk", 50, "Shipping", "650.124.8234",
                                         "650.124.8234", "TJOLSON", "TJ", "TJ", "TJ", "TJ", "2011 Main Street",
                                         "South San Francisco", "California", "US", "94105", 4, 5, 90, 2100, 525, 0,
                                         121, sdf.parse("07-14-2006"), "Adam", "Fripp"));
            s_employees.add(new Employee(168, "Lenny", "Ozer", "Sales Representative", 80, "Sales", "011.44.1343.929268",
                                         "011.44.1343.929268", "LOZER", "Lenny", "Lenny", "Lenny", "Lenny",
                                         "Magdalen Centre, The Oxford Science Park", "Oxford", "Oxford", "UK",
                                         "OX9 9ZB", 4, 5, 95, 11500, 2875, 2500, 148, sdf.parse("07-14-2006"), "Gerald",
                                         "Cambrault"));
            s_employees.add(new Employee(146, "Karen", "Partners", "Sales Manager", 80, "Sales", "011.44.1344.467268",
                                         "011.44.1344.467268", "KPARTNER", "Karen", "Karen", "Karen", "Karen",
                                         "Magdalen Centre, The Oxford Science Park", "Oxford", "Oxford", "UK",
                                         "OX9 9ZB", 4, 5, 100, 13500, 3375, 3000, 100, sdf.parse("01-01-2010"), "",
                                         "King"));
            s_employees.add(new Employee(106, "Valli", "Pataballa", "Programmer", 60, "IT", "590.423.4560",
                                         "590.423.4560", "VPATABAL", "Valli", "Valli", "Valli", "Valli", "2014 Main St",
                                         "Southlake", "Texas", "US", "76034", 4, 3, 105, 4800, 1200, 0, 103,
                                         sdf.parse("03-01-2009"), "Alexander", "Hunold"));
            s_employees.add(new Employee(140, "Joshua", "Patel", "Stock Clerk", 50, "Shipping", "650.121.1834",
                                         "650.121.1834", "JPATEL", "Joshua", "Joshua", "Joshua", "Joshua",
                                         "2011 Main Street", "South San Francisco", "California", "US", "94105", 4, 5,
                                         110, 2500, 625, 0, 123, sdf.parse("02-14-2008"), "Shanta", "Vollman"));
            s_employees.add(new Employee(191, "Randall", "Perkins", "Shipping Clerk", 50, "Shipping", "650.505.4876",
                                         "650.505.4876", "RPERKINS", "Randall", "Randall", "Randall", "Randall",
                                         "2011 Main Street", "South San Francisco", "California", "US", "94105", 3, 4,
                                         115, 2500, 625, 0, 122, sdf.parse("09-14-2004"), "Payam", "Kaufling"));
            s_employees.add(new Employee(136, "Hazel", "Philtanker", "Stock Clerk", 50, "Shipping", "650.127.1634",
                                         "650.127.1634", "HPHILTAN", "Hazel", "Hazel", "Hazel", "Hazel",
                                         "2011 Main Street", "South San Francisco", "California", "US", "94105", 4, 5,
                                         110, 2200, 550, 0, 122, sdf.parse("01-01-2010"), "Payam", "Kaufling"));
            s_employees.add(new Employee(113, "Luis", "Popp", "Accountant", 100, "Finance", "515.124.4567",
                                         "515.124.4567", "LPOPP", "Luis", "Luis", "Luis", "Luis", "2004 Bellevue Ct",
                                         "Seattle", "Washington", "US", "98102", 3, 4, 105, 6900, 1625, 0, 108,
                                         sdf.parse("03-01-2009"), "Nancy", "Greenberg"));
            s_employees.add(new Employee(141, "Trenna", "Rajs", "Stock Clerk", 50, "Shipping", "650.121.8009",
                                         "650.121.8009", "TRAJS", "Trenna", "Trenna", "Trenna", "Trenna",
                                         "2011 Main Street", "South San Francisco", "California", "US", "94105", 3, 4,
                                         100, 3500, 875, 0, 124, sdf.parse("07-14-2006"), "Kevin", "Mourgos"));
            s_employees.add(new Employee(114, "Deb", "Raphaely", "Purchasing Manager", 30, "Purchasing", "515.127.4561",
                                         "515.127.4561", "DRAPHEAL", "Deb", "Deb", "Deb", "Deb", "2004 Bellevue Ct",
                                         "Seattle", "Washington", "US", "98102", 5, 4, 95, 12000, 3750, 0, 100,
                                         sdf.parse("02-14-2008"), "Steven", "King"));
            s_employees.add(new Employee(134, "Michael", "Rogers", "Stock Clerk", 50, "Shipping", "650.127.1834",
                                         "650.127.1834", "MROGERS", "Michael", "Michael", "Michael", "Michael",
                                         "2011 Main Street", "South San Francisco", "California", "US", "94105", 4, 4,
                                         90, 2900, 725, 0, 122, sdf.parse("01-01-2010"), "Payam", "Kaufling"));
            s_employees.add(new Employee(145, "Joanne", "Russell", "Sales Manager", 80, "Sales", "011.44.1344.429268",
                                         "011.44.1344.429268", "JRUSSEL", "Joanne", "Joanne", "Joanne", "Joanne",
                                         "Magdalen Centre, The Oxford Science Park", "Oxford", "Oxford", "UK",
                                         "OX9 9ZB", 4, 3, 85, 14000, 3500, 4000, 100, sdf.parse("03-01-2009"), "Steven",
                                         "King"));
            s_employees.add(new Employee(184, "Norm", "Sarchand", "Shipping Clerk", 50, "Shipping", "650.509.1876",
                                         "650.509.1876", "NSARCHAN", "Norm", "Norm", "Norm", "Norm",
                                         "2011 Main Street", "South San Francisco", "California", "US", "94105", 4, 5,
                                         90, 4200, 1050, 0, 121, sdf.parse("07-14-2006"), "Adam", "Fripp"));
            s_employees.add(new Employee(111, "Ismael", "Sciarra", "Accountant", 100, "Finance", "515.124.4369",
                                         "515.124.4369", "ISCIARRA", "Ismael", "Ismael", "Ismael", "Ismael",
                                         "2004 Bellevue Ct", "Seattle", "Washington", "US", "98102", 3, 4, 95, 7900,
                                         1925, 0, 108, sdf.parse("09-14-2004"), "Nancy", "Greenberg"));
            s_employees.add(new Employee(139, "John", "Seo", "Stock Clerk", 50, "Shipping", "650.121.2019",
                                         "650.121.2019", "JSEO", "John", "John", "John", "John", "2011 Main Street",
                                         "South San Francisco", "California", "US", "94105", 3, 4, 100, 2700, 675, 0,
                                         123, sdf.parse("01-01-2010"), "Shanta", "Vollman"));
            s_employees.add(new Employee(161, "Sarath", "Sewall", "Sales Representative", 80, "Sales",
                                         "011.44.1345.529268", "011.44.1345.529268", "SSEWALL", "Sarath", "Sarath",
                                         "Sarath", "Sarath", "Magdalen Centre, The Oxford Science Park", "Oxford",
                                         "Oxford", "UK", "OX9 9ZB", 3, 4, 105, 7000, 1750, 2500, 146,
                                         sdf.parse("03-01-2009"), "Karen", "Partners"));
            s_employees.add(new Employee(159, "Lindsey", "Smith", "Sales Representative", 80, "Sales",
                                         "011.44.1345.729268", "011.44.1345.729268", "LSMITH", "Lindsey", "Lindsey",
                                         "Lindsey", "Lindsey", "Magdalen Centre, The Oxford Science Park", "Oxford",
                                         "Oxford", "UK", "OX9 9ZB", 3, 4, 110, 8000, 2000, 3000, 146,
                                         sdf.parse("02-14-2008"), "Karen", "Partners"));
            s_employees.add(new Employee(171, "William", "Smith", "Sales Representative", 80, "Sales",
                                         "011.44.1343.629268", "011.44.1343.629268", "WSMITH", "William", "William",
                                         "William", "William", "Magdalen Centre, The Oxford Science Park", "Oxford",
                                         "Oxford", "UK", "OX9 9ZB", 3, 4, 115, 7400, 1850, 1500, 148,
                                         sdf.parse("07-14-2006"), "Gerald", "Cambrault"));
            s_employees.add(new Employee(138, "Stephen", "Stiles", "Stock Clerk", 50, "Shipping", "650.121.2034",
                                         "650.121.2034", "SSTILES", "Stephen", "Stephen", "Stephen", "Stephen",
                                         "2011 Main Street", "South San Francisco", "California", "US", "94105", 3, 5,
                                         110, 3200, 800, 0, 123, sdf.parse("01-01-2010"), "Shanta", "Vollman"));
            s_employees.add(new Employee(182, "Martha", "Sullivan", "Shipping Clerk", 50, "Shipping", "650.507.9878",
                                         "650.507.9878", "MSULLIVA", "Martha", "Martha", "Martha", "Martha",
                                         "2011 Main Street", "South San Francisco", "California", "US", "94105", 4, 3,
                                         105, 2500, 625, 0, 120, sdf.parse("03-01-2009"), "Matthew", "Weiss"));
            s_employees.add(new Employee(157, "Patrice", "Sully", "Sales Representative", 80, "Sales",
                                         "011.44.1345.929268", "011.44.1345.929268", "PSULLY", "Patrice", "Patrice",
                                         "Patrice", "Patrice", "Magdalen Centre, The Oxford Science Park", "Oxford",
                                         "Oxford", "UK", "OX9 9ZB", 3, 4, 100, 9500, 2375, 3500, 146,
                                         sdf.parse("07-14-2006"), "Karen", "Partners"));
            s_employees.add(new Employee(176, "Judy", "Taylor", "Sales Representative", 80, "Sales",
                                         "011.44.1644.429265", "011.44.1644.429265", "JTAYLOR", "Judy", "Judy",
                                         "Judy", "Judy", "Magdalen Centre, The Oxford Science Park", "Oxford",
                                         "Oxford", "UK", "OX9 9ZB", 4, 5, 105, 8600, 2150, 2000, 149,
                                         sdf.parse("02-14-2008"), "Eleni", "Zlotkey"));
            s_employees.add(new Employee(180, "Winston", "Taylor", "Shipping Clerk", 50, "Shipping", "650.507.9876",
                                         "650.507.9876", "WTAYLOR", "Winston", "Winston", "Winston", "Winston",
                                         "2011 Main Street", "South San Francisco", "California", "US", "94105", 2, 3,
                                         100, 3200, 800, 0, 120, sdf.parse("01-01-2010"), "Matthew", "Weiss"));
            s_employees.add(new Employee(117, "Sigal", "Tobias", "Purchasing Clerk", 30, "Purchasing", "515.127.4564",
                                         "515.127.4564", "STOBIAS", "Sigal", "Sigal", "Sigal", "Sigal",
                                         "2004 Bellevue Ct", "Seattle", "Washington", "US", "98102", 3, 4, 95, 2800,
                                         550, 0, 114, sdf.parse("03-01-2009"), "Deb", "Raphaely"));
            s_employees.add(new Employee(150, "Polly", "Tucker", "Sales Representative", 80, "Sales",
                                         "011.44.1344.129268", "011.44.1344.129268", "PTUCKER", "Polly", "Polly",
                                         "Polly", "Polly", "Magdalen Centre, The Oxford Science Park", "Oxford",
                                         "Oxford", "UK", "OX9 9ZB", 4, 4, 90, 10000, 2500, 3000, 145,
                                         sdf.parse("09-14-2004"), "Joanne", "Russell"));
            s_employees.add(new Employee(155, "Ophelia", "Tuvault", "Sales Representative", 80, "Sales",
                                         "011.44.1344.486508", "011.44.1344.486508", "OTUVAULT", "Ophelia", "Ophelia",
                                         "Ophelia", "Ophelia", "Magdalen Centre, The Oxford Science Park", "Oxford",
                                         "Oxford", "UK", "OX9 9ZB", 3, 4, 85, 7000, 1750, 1500, 145,
                                         sdf.parse("07-14-2006"), "Joanne", "Russell"));
            s_employees.add(new Employee(112, "Jose Manuel", "Urman", "Accountant", 100, "Finance", "515.124.4469",
                                         "515.124.4469", "JMURMAN", "Jose Manuel", "Jose Manuel", "Jose Manuel",
                                         "Jose Manuel", "2004 Bellevue Ct", "Seattle", "Washington", "US", "98102", 4,
                                         5, 90, 8800, 1950, 0, 108, sdf.parse("01-01-2010"), "Nancy", "Greenberg"));
            s_employees.add(new Employee(144, "Perly", "Vargas", "Stock Clerk", 50, "Shipping", "650.121.2004",
                                         "650.121.2004", "PVARGAS", "Perly", "Perly", "Perly", "Perly",
                                         "2011 Main Street", "South San Francisco", "California", "US", "94105", 3, 4,
                                         95, 2500, 625, 0, 124, sdf.parse("03-01-2009"), "Kevin", "Mourgos"));
            s_employees.add(new Employee(162, "Clarence", "Vishney", "Sales Representative", 80, "Sales",
                                         "011.44.1346.129268", "011.44.1346.129268", "CVISHNEY", "Clarence", "Clarence",
                                         "Clarence", "Clarence", "Magdalen Centre, The Oxford Science Park", "Oxford",
                                         "Oxford", "UK", "OX9 9ZB", 3, 5, 100, 10500, 2625, 2500, 147,
                                         sdf.parse("02-14-2008"), "Allison", "Errazuriz"));
            s_employees.add(new Employee(123, "Shanta", "Vollman", "Stock Manager", 50, "Shipping", "650.123.4234",
                                         "650.123.4234", "SVOLLMAN", "Shanta", "Shanta", "Shanta", "Shanta",
                                         "2011 Main Street", "South San Francisco", "California", "US", "94105", 3, 4,
                                         105, 6500, 1625, 0, 100, sdf.parse("07-14-2006"), "Steven", "King"));
            s_employees.add(new Employee(196, "Alana", "Walsh", "Shipping Clerk", 50, "Shipping", "650.507.9811",
                                         "650.507.9811", "AWALSH", "Alana", "Alana", "Alana", "Alana",
                                         "2011 Main Street", "South San Francisco", "California", "US", "94105", 4, 5,
                                         110, 3100, 775, 0, 124, sdf.parse("01-01-2010"), "Kevin", "Mourgos"));
            s_employees.add(new Employee(120, "Matthew", "Weiss", "Stock Manager", 50, "Shipping", "650.123.1234",
                                         "650.123.1234", "MWEISS", "Matthew", "Matthew", "Matthew", "Matthew",
                                         "2011 Main Street", "South San Francisco", "California", "US", "94105", 4, 5,
                                         115, 8000, 2000, 0, 100, sdf.parse("03-01-2009"), "Steven", "King"));
            s_employees.add(new Employee(200, "Jennifer", "Whalen", "Administration Assistant", 10, "Administrative",
                                         "515.123.4444", "515.123.4444", "JWHALEN", "Jennifer", "Jennifer", "Jennifer",
                                         "Jennifer", "2004 Bellevue Ct", "Seattle", "Washington", "US", "98102", 4, 5,
                                         110, 4400, 1100, 0, 101, sdf.parse("09-14-2004"), "Neena", "Kochhar"));
            s_employees.add(new Employee(149, "Eleni", "Zlotkey", "Sales Manager", 80, "Sales", "011.44.1344.429018",
                                         "011.44.1344.429018", "EZLOTKEY", "Eleni", "Eleni", "Eleni", "Eleni",
                                         "Magdalen Centre, The Oxford Science Park", "Oxford", "Oxford", "UK",
                                         "OX9 9ZB", 3, 4, 105, 10500, 2625, 2000, 100, sdf.parse("02-14-2008"),
                                         "Steven", "King"));
            
            // Now that all employees are created, create all the child collections
            /*
            int count = s_employees.size();
            for (int x = 0; x < count; x++) {
                Employee e = (Employee) s_employees.get(x);
                e.createChildren(this);
            }
*/
            // Now that all child collections are created, calculate the group info for all employees
            /*
            for (int x = 0; x < count; x++) {
                Employee e = (Employee) s_employees.get(x);
                e.createGroupInfo();
            }

            s_departments.add(new Department(110, "Accounting", "2004 Bellevue Ct", "Seattle", "Washington", "US",
                                             "98102", 205, "Shelley", "Higgins", "47.627132", "-122.326576", "#13b6cf"));
            s_departments.add(new Department(10, "Administrative", "2004 Bellevue Ct", "Seattle", "Washington", "US",
                                             "98102", 200, "Jennifer", "Whalen", "47.627132", "-122.326576", "#854e9b"));
            s_departments.add(new Department(90, "Executive", "2004 Bellevue Ct", "Seattle", "Washington", "US",
                                             "98102", 100, "Steven", "King", "47.627132", "-122.326576", "#989fa8"));
            s_departments.add(new Department(100, "Finance", "2004 Bellevue Ct", "Seattle", "Washington", "US", "98102",
                                             108, "Nancy", "Greenberg", "47.627132", "-122.326576", "#f4aa46"));
            s_departments.add(new Department(40, "Human Resources", "8204 Arthur St", "London", "UK", "UK", "", 203,
                                             "Susan", "Mavris", "51.510371", "-0.087445", "#ed813e"));
            s_departments.add(new Department(60, "IT", "2014 Main St", "Southlake", "Texas", "US", "76034", 103,
                                             "Alexander", "Hunold", "32.9425812", "-97.1270981", "#5a68ad"));
            s_departments.add(new Department(20, "Marketing", "147 Spadina Ave", "Toronto", "Ontario", "CA", "M5V 2L7",
                                             201, "Michael", "Hartstein", "43.6480789", "-79.3955612", "#2ebfbc"));
            s_departments.add(new Department(70, "Public Relations", "Schwanthalerstr. 7031", "Munich", "Bavaria", "DE",
                                             "", 204, "Hermann", "Baer", "48.137538", "11.552816", "#ca589d"));
            s_departments.add(new Department(30, "Purchasing", "2004 Bellevue Ct", "Seattle", "Washington", "US",
                                             "98102", 114, "Deb", "Raphaely", "47.627132", "-122.326576", "#e85d88"));
            s_departments.add(new Department(80, "Sales", "Magdalen Centre, The Oxford Science Park", "Oxford",
                                             "Oxford", "UK", "OX9 9ZB", 148, "Gerald", "Cambrault", "54.5608864", "-2.2125118", "#81bb5f"));
            s_departments.add(new Department(50, "Shipping", "2011 Main Street", "South San Francisco", "California",
                                             "US", "94105", 122, "Payam", "Kaufling", "37.7003212", "-122.4089584", "#e95b54"));

            count = s_departments.size();
            for (int x = 0; x < count; x++) {
                Department d = (Department) s_departments.get(x);
                d.createChildren(this);
            }
*/
            filterEmployees();
            /*
            filterDepartments();
            
            dash = new Dashboard(this);
            */
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
    }


    public void setEmpFilter(String empFilter) {
        String oldEmpFilter = this.empFilter;
        this.empFilter = empFilter;
//        propertyChangeSupport.firePropertyChange("empFilter", oldEmpFilter, empFilter);
    }

    public String getEmpFilter() {
        return empFilter;
    }

    public void setDeptFilter(String deptFilter) {
        String oldDeptFilter = this.deptFilter;
        this.deptFilter = deptFilter;
//        propertyChangeSupport.firePropertyChange("deptFilter", oldDeptFilter, deptFilter);
    }

    public String getDeptFilter() {
        return deptFilter;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getEmployees() throws Exception {
        //return (Employee[]) filtered_employees.toArray(new Employee[filtered_employees.size()]);
     Employee employees[]=  (Employee[]) filtered_employees.toArray(new Employee[filtered_employees.size()]);
     
     String json=convertToJSON(employees);
     return json;
    }
    
    
    private String convertToJSON(Employee[] employees)throws Exception{
      /*
      JSONObject jsonObject = new JSONObject();
      
    GenericPrincipal principal=(GenericPrincipal)request.getUserPrincipal();
     String username=   principal.getName();
     String password=   principal.getPassword();
     String roles[]=principal.getRoles();
     
        
      jsonObject.put("Username", username);
      jsonObject.put("Password", password);

      */
        
      JSONArray jsonArray = new JSONArray();
      
      for(int i=0;i<employees.length;i++){
      JSONObject employee = new JSONObject();
      employee.put("empId", employees[i].getEmpId());          
      employee.put("email", employees[i].getEmail());
      employee.put("firstName", employees[i].getFirstName());    
      employee.put("lastName", employees[i].getLastName());    
      employee.put("title", employees[i].getTitle());    
      employee.put("phone", employees[i].getPhone());    
      employee.put("mobile", employees[i].getMobile());    
      employee.put("address", employees[i].getAddress());    
      employee.put("city", employees[i].getCity());    
      employee.put("state", employees[i].getState());    
      employee.put("country", employees[i].getCountry());    
      employee.put("postal", employees[i].getPostal()); 
      int empId=employees[i].getEmpId();    
      employee.put("image",  employees[i].getEmpImage(empId));    
       
     jsonArray.put(employee);
                
 }
   return jsonArray.toString();
    }

 /*
    public Department[] getDepartments() {
        return (Department[]) filtered_departments.toArray(new Department[filtered_departments.size()]);
    }

    
    public Dashboard getDashboard() {
        return dash;
    }
 */
    public int getEmployeeCount() {
        return s_employees.size();
    }
    
    public int getDepartmentCount() {
        return s_departments.size();
    }

    public void filterEmployees() {
        filtered_employees.clear();
        boolean nofilter = (getEmpFilter().length() == 0);
        for (int x = 0; x < s_employees.size(); x++) {
            Employee e = (Employee) s_employees.get(x);
            if (nofilter) {
                filtered_employees.add(e);
            } else {
                String first = e.getFirstName();
                String last = e.getLastName();
                if (first.indexOf(getEmpFilter()) != -1 || last.indexOf(getEmpFilter()) != -1) {
                    filtered_employees.add(e);
                }
            }
        }
 
    }

/*
    public void filterDepartments() {
        filtered_departments.clear();
        boolean nofilter = (getDeptFilter().length() == 0);
        for (int x = 0; x < s_departments.size(); x++) {
            Department d = (Department) s_departments.get(x);
            if (nofilter) {
                filtered_departments.add(d);
            } else {
                String name = d.getDeptName();
                if (name.indexOf(getDeptFilter()) != -1) {
                    filtered_departments.add(d);
                }
            }
        }
        providerChangeSupport.fireProviderRefresh("departments");
    }
*/
    public void applyActiveEmpRow(int id) {
        Employee e = null;
        int count = filtered_employees.size();
        for (int x = 0; x < count; x++) {
            e = (Employee) filtered_employees.get(x);
            if (id > 0 && e.getEmpId() == id) {
                e.setActive(!(e.isActive()));
            } else {
                if (e.isActive()) {
                    e.setActive(false);
                }
            }
        }

    }
    
    
    private static final String FILE_PATH = "c:\\mkyong-logo.png";
     
            @GET
            @Path("/get")
            @Produces("image/png")
            public Response getFile(@Context HttpServletRequest request) {
                
              //  request.get
     
                    File file = new File(FILE_PATH);
                    
     
                    ResponseBuilder response = Response.ok((Object) file);
                    response.header("Content-Disposition",
                            "attachment; filename=image_from_server.png");
                    return response.build();
     
            }
     
}
