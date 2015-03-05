package employeeservice;



import java.util.ArrayList;
import java.util.Date;

import java.util.List;
import java.util.Random;


public class Employee {
    private int empId;
    private String firstName;
    private String lastName;
    private String title;
    private String email;
    private String phone;
    private String mobile;
    private String address;
    private String city;
    private String state;
    private String country;
    private String postal;
    private String twitter;
    private String facebook;
    private String google;
    private String linkedIn;
    private Date hireDate;
    private int compRatio;
    private double salary;
    private double bonus;
    private double commission;
    private int rating;
    private int potential;
    private int deptId;
    private String deptName;
    private int mgrId;
    private String mgrFirstName;
    private String mgrLastName;
    private double teamAvgRating;
    private boolean active = false;
    private int empMeetings = 0;
    private int empEvents = 0;
    private int notifyApproved = 3;
    private int notifyWaiting = 4;
    private int notifyRejected = 1;
    private int groupSize = 0;
    private double groupAvgRating = 0;
    private double groupAvgPotential = 0;
    private int groupCompRatioAbove = 0;
    private int groupCompRatioIn = 0;
    private int groupCompRatioBelow = 0;
    private int groupMeetings = 0;
    private int groupEvents = 0;
    private int groupTrainings = 0;
    private int groupTimeOff = 0;
    private List comps = new ArrayList();
    private List perfs = new ArrayList();
    private List skills = new ArrayList();
    protected List events = new ArrayList();
    private List colleaguePerfs = new ArrayList();
    private List reports = new ArrayList();
    private static String[] skillList = {
        "Bookeeping", "Corporate Tax", "Excel", "Word", "Statistics", "Javascript", "Java", "Analytics", "Testing",
        "Acquistions", "Project Planning", "Risk Analysis", "Recruiting", "Management", "Financials", "CRM", "HCM",
        "Human Resources", "Engineering", "Outsourcing", "Procurement", "Strategy", "Estimation", "Staffing",
        "Budgeting"
    };
    private static String[][] eventlist = {
        { "Acme Ent", "Foo Ltd", "Bar Inc", "AAA Inc", "Oracle", "BBB Ltd", "CCC Enterprises", "ABC LLC", "DEF Inc",
          "XYZ Systems" },
        { "Trade Show", "Sales Convention", "Development Convention", "User Group Meetup", "Winner's Circle",
          "StockHolder's Meeting", "Design Awards", "Customer Advisory Board", "Business Meeting", "Feedback Session" },
        { "Mgr Essentials", "Sexual Harrassment", "Ethics", "Mobility", "Sales", "Java Development", "iOS Development",
          "Effective Mgmt", "Public Speaking", "Security" },
        { "Vacation", "Vacation", "Vacation", "Vacation", "Sick", "Sick", "Sick", "Sick", "Bereavement", "Bereavement" }
    };
    private static final long year = (long) (1000 * 60 * 60 * 24 * 365.25);
    private static final long day = (long) (1000 * 60 * 60 * 24);



    public Employee() {
    }

    public Employee(int empId, String firstName, String lastName, String title, int deptId, String deptName,
                    String phone, String mobile, String email, String linkedIn, String twitter, String facebook,
                    String google, String address, String city, String state, String country, String postal, int rating,
                    int potential, int compRatio, double salary, double bonus, double commission, int mgrId,
                    Date hireDate, String mgrFirstName, String mgrLastName) {
        this.empId = empId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.deptId = deptId;
        this.deptName = deptName;
        this.phone = phone;
        this.mobile = mobile;
        this.email = email;
        this.linkedIn = linkedIn;
        this.twitter = twitter;
        this.facebook = facebook;
        this.google = google;
        this.address = address;
        this.city = city;
        this.state = state;
        this.country = country;
        this.postal = postal;
        this.rating = rating;
        this.potential = potential;
        this.compRatio = compRatio;
        this.salary = salary * 10;
        this.bonus = bonus * 10;
        this.commission = commission * 10;
        this.mgrId = mgrId;
        this.hireDate = hireDate;
        this.mgrFirstName = mgrFirstName;
        this.mgrLastName = mgrLastName;
    }



    public int getEmpId() {
        return empId;
    }

    public void setFirstName(String firstName) {
        String oldFirstName = this.firstName;
        this.firstName = firstName;

    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        String oldLastName = this.lastName;
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setTitle(String title) {
        String oldTitle = this.title;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setEmail(String email) {
        String oldEmail = this.email;
        this.email = email;
    }

    public String getEmail() {
        return email.toLowerCase() + "@cableco.net";
    }

    public void setMobile(String mobile) {
        String oldMobile = this.mobile;
        this.mobile = mobile;
    }

    public String getMobile() {
        return mobile;
    }

    public void setPhone(String phone) {
        String oldPhone = this.phone;
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setAddress(String address) {
        String oldAddress = this.address;
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setCity(String city) {
        String oldCity = this.city;
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setState(String state) {
        String oldState = this.state;
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setCountry(String country) {
        String oldCountry = this.country;
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setPostal(String postal) {
        String oldPostal = this.postal;
        this.postal = postal;
    }

    public String getPostal() {
        return postal;
    }

    public void setTwitter(String twitter) {
        String oldTwitter = this.twitter;
        this.twitter = twitter;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setFacebook(String facebook) {
        String oldFacebook = this.facebook;
        this.facebook = facebook;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setGoogle(String google) {
        String oldGoogle = this.google;
        this.google = google;
    }

    public String getGoogle() {
        return google;
    }

    public void setLinkedIn(String linkedIn) {
        String oldLinkedIn = this.linkedIn;
        this.linkedIn = linkedIn;
    }

    public String getLinkedIn() {
        return linkedIn;
    }

    public void setHireDate(Date hireDate) {
        Date oldHireDate = this.hireDate;
        this.hireDate = hireDate;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setCompRatio(int compRatio) {
        int oldCompRatio = this.compRatio;
        this.compRatio = compRatio;
    }

    public int getCompRatio() {
        return compRatio;
    }

    public void setSalary(double salary) {
        double oldSalary = this.salary;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setBonus(double bonus) {
        double oldBonus = this.bonus;
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setCommission(double commission) {
        double oldCommission = this.commission;
        this.commission = commission;
    }

    public double getCommission() {
        return commission;
    }

    public void setRating(int rating) {
        int oldRating = this.rating;
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }

    public void setPotential(int potential) {
        int oldPotential = this.potential;
        this.potential = potential;
    }

    public int getPotential() {
        return potential;
    }

    public void setDeptId(int deptId) {
        int oldDeptId = this.deptId;
        this.deptId = deptId;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptName(String deptName) {
        String oldDeptName = this.deptName;
        this.deptName = deptName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setMgrId(int mgrId) {
        int oldMgrId = this.mgrId;
        this.mgrId = mgrId;
    }

    public int getMgrId() {
        return mgrId;
    }

    public void setMgrFirstName(String mgrFirstName) {
        String oldMgrFirstName = this.mgrFirstName;
        this.mgrFirstName = mgrFirstName;
    }

    public String getMgrFirstName() {
        return mgrFirstName;
    }

    public void setMgrLastName(String mgrLastName) {
        String oldMgrLastName = this.mgrLastName;
        this.mgrLastName = mgrLastName;
    }

    public String getMgrLastName() {
        return mgrLastName;
    }

    public String getMgrImage() {
        return getEmpImage(this.mgrId);
    }

    public String getImage() {
        return getEmpImage(this.empId);
    }

    protected String getEmpImage(int id) {
        String image = "nopic.png";
        Integer i = new Integer(id);
        if( i.intValue() < 188 ) {
            image = i.toString() + ".png";
        }
        return image;
    }

    public void setActive(boolean active) {
        boolean oldActive = this.active;
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }

    public int getTenure() {
        return (int) ((new Date().getTime() - getHireDate().getTime()) / year);
    }

    public String getNboxPotential() {
        return calcNboxString(potential);
    }

    public String getNboxRating() {
        return calcNboxString(rating);
    }


    public void setTeamAvgRating(double teamAvgRating) {
        double oldTeamAvgRating = this.teamAvgRating;
        this.teamAvgRating = teamAvgRating;
    }

    public double getTeamAvgRating() {
        return teamAvgRating;
    }

    private String calcNboxString(int value) {
        String ret = "low";
        if (value == 3 || value == 4) {
            ret = "med";
        } else if (value == 5) {
            ret = "high";
        }
        return ret;
    }


    public Employee[] getReports() {
        return (Employee[]) reports.toArray(new Employee[reports.size()]);
    }

    public int getReportCount() {
        return reports.size();
    }


    public void setEmpMeetings(int empMeetings) {
        int oldEmpMeetings = this.empMeetings;
        this.empMeetings = empMeetings;
    }

    public int getEmpMeetings() {
        return empMeetings;
    }

    public void setEmpEvents(int empEvents) {
        int oldEmpEvents = this.empEvents;
        this.empEvents = empEvents;
    }

    public int getEmpEvents() {
        return empEvents;
    }

    public void setGroupSize(int groupSize) {
        int oldGroupSize = this.groupSize;
        this.groupSize = groupSize;
    }

    public int getGroupSize() {
        return groupSize;
    }


    public double getGroupAvgRating() {
        return groupAvgRating;
    }

    public double getGroupAvgPotential() {
        return groupAvgPotential;
    }

    public int getGroupCompRatioAbove() {
        return groupCompRatioAbove;
    }

    public int getGroupCompRatioIn() {
        return groupCompRatioIn;
    }

    public int getGroupCompRatioBelow() {
        return groupCompRatioBelow;
    }

    public int getGroupMeetings() {
        return groupMeetings;
    }

    public int getGroupEvents() {
        return groupEvents;
    }

    public int getGroupTrainings() {
        return groupTrainings;
    }

    public int getGroupTimeOff() {
        return groupTimeOff;
    }

    public int getNotifyApproved() {
        return notifyApproved;
    }

    public int getNotifyWaiting() {
        return notifyWaiting;
    }

    public int getNotifyRejected() {
        return notifyRejected;
    }

    // This method populates the child collections with a random amount of data



    public String getRatingDesc() {
        return calcRatingDesc(this.rating);
    }

    public String getPotentialDesc() {
        return calcRatingDesc(this.potential);
    }

    public String calcRatingDesc(int value) {
        String desc = "";
        switch (value) {
        case 3:
            desc = "Average";
            break;
        case 4:
            desc = "Outstanding";
            break;
        case 5:
            desc = "Exceptional";
            break;
        default:
            desc = "Below";
            break;
        }
        return desc;
    }

    public int getSkillCount() {
        return skills.size();
    }
}


