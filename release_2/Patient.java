package package1;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Comparator;
import java.util.GregorianCalendar;

/***********************************************************
 * Class base class for camping
 * 
 * @author Tuan Nguyen
 * @version Winter 2015
 ***********************************************************/
public class Patient implements Comparable<Patient>, Serializable {

	/** Serial */
	private static final long serialVersionUID = 1L;

	/** The name of the person who is occupying the Site */
	protected String name;

	/** The date of person checking in */
	protected GregorianCalendar birth;

	/** The gender of the person **/
	protected String gender;

	/** Medical Record Number **/
	protected int mrn;

	/**************************************************
	 * Empty default Constructor
	 *************************************************/
	public Patient() {
		super();
	}

	/*************************************************
	 * Constructor
	 * 
	 * @param name
	 *            is the name
	 * @param birth
	 *            is date of birth
	 * @param gender
	 *            is the gender of person
	 *
	 *************************************************/
	public Patient(String name, GregorianCalendar birth, String gender, GregorianCalendar dateReg) {

		super();
		this.name = name;
		this.birth = birth;
		this.gender = gender;
	
	}

	/***************************************************
	 * Overrides the method in comparable. sort by name
	 * 
	 * @param name
	 *            is the name being compared
	 * @return -1, 0, 1; lower, equal, greater
	 ***************************************************/
	@Override
	public int compareTo(Patient name) {
		return this.name.compareToIgnoreCase(name
			.getName());
	}

	/***************************************************
	 * Get NameReserving in Site
	 * 
	 * @return the name of the register
	 ***************************************************/
	public String getName() {
		return name;
	}

	/***************************************************
	 * Set the name of the reserver
	 * 
	 * @param nameReserving
	 *            is name of reserver
	 ***************************************************/
	public void setName(String name) {
		this.name = name;
	}

	/***************************************************
	 * Get birth date
	 * 
	 * @return GregorianCalendar
	 ***************************************************/
	public GregorianCalendar getBirth() {
		return birth;
	}

	/***************************************************
	 * Set birth date
	 * 
	 * @param birth
	 *            is date of birth
	 **************************************************/
	public void setBirth(GregorianCalendar birth) {
		this.birth = birth;
	}

	/**************************************************
	 * Get MRN
	 * 
	 * @return MRN
	 *************************************************/
	public int getMRN() {
		return mrn;
	}

	/*************************************************
	 * Set MRN
	 * 
	 * @param MRN
	 *            is the Medical Record Number
	 ************************************************/
	public void setMRN(int mrn) {
		this.mrn = mrn;
	}

	/*************************************
	 * Creates a sort of name descending
	 * 
	 * @author Tuan
	 *
	 ************************************/
	public static class NameComparator2 implements Comparator<Patient> {
		public int compare(Patient s1, Patient s2) {
			return s2.getName().compareToIgnoreCase(
				s1.getName());
		}
	}

	/************************************
	 * Creates a sort of date descend
	 * 
	 * @author Tuan
	 *
	 ***********************************/
	public static class DateComparator1 implements Comparator<Patient> {
		public int compare(Patient s1, Patient s2) {
			return s1.getBirth().compareTo(s2.getBirth());
		}
	}

	/**********************************
	 * Create a sort of date ascend
	 * 
	 * @author Tuan
	 *
	 *********************************/
	public static class DateComparator2 implements Comparator<Patient> {
		public int compare(Patient s1, Patient s2) {
			return s2.getBirth().compareTo(s1.getBirth());
		}
	}

	/***********************************
	 * Create a sort of MRN
	 * 
	 * @author Tuan
	 *
	 **********************************/
	public static class MRNComparator1 implements Comparator<Patient> {
		public int compare(Patient s1, Patient s2) {

			if (s1.getMRN() == s2.getMRN())
				return 0;
			else
				return s1.getMRN() > s2.getMRN() ? 1
					: -1;
		}
	}

	/**********************************
	 * Create a sort of MRN
	 * 
	 * @author Tuan
	 *
	 *********************************/
	public static class MRNComparator2 implements Comparator<Patient> {
		public int compare(Patient s1, Patient s2) {

			if (s1.getMRN() == s2.getMRN())
				return 0;
			else
				return s1.getMRN() < s2.getMRN() ? 1
					: -1;
		}
	}
}
