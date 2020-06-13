package person;

public class Plan {
	private int     id;
	private String  plan_name;
	private int     datenum_consuming;
	private int     datenum_interval;
	private String  lastdate_review;
	private String  nextdate_review;
	private String  date_calculate;
	private String  byy;
	private int     importance;
	private int     emergency;
	private int     count_review;
	private int     complete_flag;
	private int     flag_del_an_plan;

	public int getid() {
		return id;
	}

	public void setid(int iid) {
		this.id = iid;
	}

	public String getplan_name() {
		return plan_name;
	}

	public void setplan_name(String splan_name) {
		this.plan_name = splan_name;
	}

	public int getdatenum_consuming() {
		return datenum_consuming;
	}

	public void setdatenum_consuming(int idatenum_consuming) {
		this.datenum_consuming = idatenum_consuming;
	}

	public int getdatenum_interval() {
		return datenum_interval;
	}

	public void setdatenum_interval(int idatenum_interval) {
		this.datenum_interval = idatenum_interval;
	}
	
	public String getlastdate_review() {
		return lastdate_review;
	}

	public void setlastdate_review(String slastdate_review) {
		this.lastdate_review = slastdate_review;
	}
	
	public String getnextdate_review() {
		return nextdate_review;
	}

	public void setnextdate_review(String snextdate_review) {
		this.nextdate_review = snextdate_review;
	}
	
	public String getdate_calculate() {
		return date_calculate;
	}

	public void setdate_calculate(String sdate_calculate) {
		this.date_calculate = sdate_calculate;
	}
	
	public String getbyy() {
		return byy;
	}

	public void setbyy(String sbyy) {
		this.byy = sbyy;
	}
	
	public int getimportance() {
		return importance;
	}

	public void setimportance(int iimportance) {
		this.importance = iimportance;
	}
	
	
	public int getemergency() {
		return emergency;
	}

	public void setemergency(int iemergency) {
		this.emergency = iemergency;
	}
	
	public int getcount_review() {
		return count_review;
	}

	public void setcount_review(int icount_review) {
		this.count_review = icount_review;
	}
	
	public int getcomplete_flag() {
		return complete_flag;
	}

	public void setcomplete_flag(int icomplete_flag) {
		this.complete_flag = icomplete_flag;
	}
	
	public int getflag_del_an_plan() {
		return flag_del_an_plan;
	}

	public void setflag_del_an_plan(int iflag_del_an_plan) {
		this.flag_del_an_plan = iflag_del_an_plan;
	}
	
}
