package package1;

import java.awt.*;
import java.awt.List;
import java.util.*;

import javax.swing.*;

/**
 * View Controller for the program.
 * 
 * @author Tuan
 *
 */
public class medicalForm {

	public static void main(String[] args) {
		new medicalForm();
	}

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

	public interface View {

		public void goHome();

		public void nextView();

		public void previousView();

		public void gotoView(String id);

	}

	public static class DefaultViewController implements View {

		public static final String START = "start";

		private Component current = null;
		private ArrayList<Component> views;
		private Map<Component, String> map;
		private Map<String, Component> rmap;
		private Container parent;
		private CardLayout cl;

		public DefaultViewController(Container parent, CardLayout cl) {

			this.parent = parent;
			this.cl = cl;
			views = new ArrayList<>(25);
			map = new HashMap<>(25);
			rmap = new HashMap<>(25);
		}

		public CardLayout getCardLayout() {
			return cl;
		}

		public Container getParent() {
			return parent;
		}

		public void addView(Component comp, String id) {

			// if not the initial card, add to views
			if (!START.equals(id)) {
				views.add(comp);
			}
			map.put(comp, id);
			rmap.put(id, comp);
			getParent().add(comp, id);
		}

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
