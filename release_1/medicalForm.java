package package1;

import java.awt.*;
import java.awt.List;
import java.util.*;

import javax.swing.*;

/**********************************************************************
 * View Controller for the program.
 * 
 * @author Tuan
 *
 *********************************************************************/
public class medicalForm {

	/******************************************************************
	 * Run the main
	 * 
	 * @param args
	 *****************************************************************/
	public static void main(String[] args) {
		new medicalForm();
	}

	/******************************************************************
	 * Constructor. Overides runnable
	 * 
	 * 
	 *****************************************************************/
	public medicalForm() {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				try {

					UIManager.setLookAndFeel(UIManager
						.getSystemLookAndFeelClassName());
				} catch (ClassNotFoundException
					| InstantiationException | IllegalAccessException
					| UnsupportedLookAndFeelException ex) {
				}

				JFrame frame = new JFrame("GUI");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setLayout(new BorderLayout());
				frame.add(new GUIMedicalForm());
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
	}

	/******************************************************************
	 * Interface Class
	 * 
	 * @author Tuan
	 *
	 *****************************************************************/
	public interface View {

		/**************************************************************
		 * Go to home card
		 *************************************************************/
		public void goHome();

		/**************************************************************
		 * Go to next view in cardlayout
		 *************************************************************/
		public void nextView();

		/*************************************************************
		 * Go to previous view in cardlayout
		 *************************************************************/
		public void previousView();

		/**************************************************************
		 * go to desired view in cardlayout
		 * 
		 * @param id
		 *            is the string identifier of the card
		 *************************************************************/
		public void gotoView(String id);

	}

	/******************************************************************
	 * View Controller manipulates card layout
	 * 
	 * @author Tuan
	 *
	 *****************************************************************/
	public static class DefaultViewController implements View {

		public static final String START = "start";

		private Component current = null;
		private ArrayList<Component> views;
		private Map<Component, String> map;
		private Map<String, Component> rmap;
		private Container parent;
		private CardLayout cl;

		/**************************************************************
		 * Constructor
		 * 
		 * @param parent
		 *            is the panel that will hold the card layout
		 * @param cl
		 *            is the card layout
		 *************************************************************/
		public DefaultViewController(Container parent, CardLayout cl) {

			this.parent = parent;
			this.cl = cl;
			views = new ArrayList<>(25);
			map = new HashMap<>(25);
			rmap = new HashMap<>(25);
		}

		/**************************************************************
		 * Getter class
		 * 
		 * @return card Layout
		 *************************************************************/
		public CardLayout getCardLayout() {
			return cl;
		}

		/**************************************************************
		 * Getter class
		 * 
		 * @return the parent container
		 *************************************************************/
		public Container getParent() {
			return parent;
		}

		/**************************************************************
		 * Add card to the cardlayout view
		 * 
		 * @param comp
		 *            is the component to be added
		 * @param id
		 *            is the string identifer of the card
		 *************************************************************/
		public void addView(Component comp, String id) {

			// if not the initial card, add to views
			if (!START.equals(id)) {
				views.add(comp);
			}
			map.put(comp, id);
			rmap.put(id, comp);
			getParent().add(comp, id);
		}

		/**************************************************************
		 * Remove card from the cardlayout view
		 * 
		 * @param comp
		 *            is the component to be added
		 * @param id
		 *            is the string identifer of the card
		 *************************************************************/
		public void removeView(Component comp, String id) {
			views.remove(comp);
			map.remove(comp);
			rmap.remove(id);
			getParent().remove(comp);
		}

		@Override
		public void goHome() {
			current = null;
			getCardLayout().show(getParent(), START);
		}

		@Override
		public void nextView() {
			if (views.size() > 0) {
				String id = null;
				if (current == null) {
					current = views.get(0);
					id = map.get(current);
				} else {
					int index = views.indexOf(current);
					index++;
					if (index >= views.size()) {
						index = 0;
					}
					current = views.get(index);
					id = map.get(current);
				}
				getCardLayout().show(getParent(), id);
			}
		}

		@Override
		public void previousView() {
			if (views.size() > 0) {
				String id = null;
				if (current == null) {
					current = views.get(views.size() - 1);
					id = map.get(current);
				} else {
					int index = views.indexOf(current);
					index--;
					if (index < 0) {
						index = views.size() - 1;
					}
					current = views.get(index);
					id = map.get(current);
				}
				getCardLayout().show(getParent(), id);
			}
		}

		@Override
		public void gotoView(String id) {

			// go home if current is null
			if (current == null) {
				current = views.get(0);
				id = map.get(current);

				// if p exist set current as p and get id
				if (rmap.get(id) != null)
					current = rmap.get(id);
			}

			// show the desired panel
			getCardLayout().show(getParent(), id);
		}
	}
}
