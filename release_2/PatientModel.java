package package1;

	import java.io.*;
import java.text.*;
import java.util.*;

	import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.table.AbstractTableModel;

	/*****************************************************************
	 * This class is used for maintaining the database of Patients (RV and
	 * Tent) and there status into an ArrayList<Patient>.
	 * 
	 * @author Tuan
	 *
	 *****************************************************************/
	@SuppressWarnings("serial")
	public class PatientModel extends AbstractTableModel {

		/** ArrayList holds list of Patients */
		private ArrayList<Patient> listPatients;

		/** String that displays the column name */
		private String[] columnNames = { };

		/****************************************************
		 * Default empty constructor
		 ***************************************************/
		public PatientModel() {
			super();
			listPatients = new ArrayList<Patient>();
		}

		/****************************************************
		 * Override the method in AbstractTabelModel
		 * 
		 * @param row
		 *            is location of element
		 * @param col
		 *            is location of element
		 * @return object is the value at selected
		 ***************************************************/
		@Override
		public Object getValueAt(int row, int col) {

			switch (col) {

			default:
				return null;
			}
		}

		/****************************************************
		 * get the column name
		 * 
		 * @param col
		 *            is location of the name
		 * @return String of the column name
		 ***************************************************/
		@Override
		public String getColumnName(int col) {
			return columnNames[col];
		}

		/****************************************************
		 * get the number of columns
		 * 
		 * @return the number of columns
		 ***************************************************/
		@Override
		public int getColumnCount() {
			return columnNames.length;
		}

		/****************************************************
		 * get the number of rows
		 * 
		 * @return the number of rows
		 ***************************************************/
		@Override
		public int getRowCount() {
			return listPatients.size();
		}

		/****************************************************
		 * Get the size of the list
		 * 
		 * @return the size of the list
		 ***************************************************/
		public int getSize() {
			return listPatients.size();
		}

		/****************************************************
		 * remove the Patient from the list
		 * 
		 * @param s
		 *            is the Patient being removed
		 ***************************************************/
		public void removePatient(Patient p) {
			listPatients.remove(p);
			fireTableRowsDeleted(0, listPatients.size());
		}

		/****************************************************
		 * add Patient to the list
		 * 
		 * @param s
		 *            is the Patient being added
		 ***************************************************/
		public void addPatient(Patient p) {
			listPatients.add(p);
			fireTableRowsInserted(0, listPatients.size());
		}

		/****************************************************
		 * update the display of the list
		 ***************************************************/
		public void updatePatient() {
			fireTableRowsUpdated(0, listPatients.size());
		}

		/****************************************************
		 * Get Patient at row
		 * 
		 * @param row
		 *            is location of Patient
		 * @return Patient
		 ***************************************************/
		public Patient getPatient(int row) {
			return listPatients.get(row);
		}

		/****************************************************
		 * Sort the listPatients
		 * 
		 * @param c
		 *            is a comparator to sort
		 ***************************************************/
		public void sort(Comparator<Patient> c) {
			if (c == null)
				Collections.sort(listPatients);
			else
				Collections.sort(listPatients, c);
		}

		/****************************************************
		 * Save serializable file
		 * 
		 * @param filename
		 *            is name of file
		 * @return true if able to save
		 ***************************************************/
		public boolean saveSerial(String filename) {
			if (filename.equals("")) {
				return false;
			}
			try {
				FileOutputStream fos = new FileOutputStream(filename);
				ObjectOutputStream os = new ObjectOutputStream(fos);
				os.writeObject(listPatients);
				os.close();

				return true;
			} catch (IOException ex) {
				JOptionPane.showMessageDialog(null, this,
					"Not a proper file", 0);
				return false;
			}
		}
		/****************************************************
		 * Load serializable file
		 * 
		 * @param filename
		 *            is name of file
		 ***************************************************/
		public void loadSerial(String filename) {
			try {
				FileInputStream fis = new FileInputStream(filename);
				ObjectInputStream is = new ObjectInputStream(fis);

				listPatients = (ArrayList<Patient>) is.readObject();
				fireTableRowsInserted(0, listPatients.size() - 1);
				is.close();

			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, this,
					"Not a proper file", 0);
			}
		}
}
