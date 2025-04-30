package petAdoption.views;

import javax.swing.JFrame;
import javax.swing.JPanel;

import petAdoption.petModels.Pet;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class PetListView extends JFrame{
	
	private JPanel panel;
	private JList<Pet> list;
	private JButton addButton;
	private JButton adoptButton;
	private JButton deleteButton;
	private JButton viewButton;
	private DefaultListModel<Pet> modelList;
	private JComboBox comboBox;
	

	
	
	public PetListView(DefaultListModel<Pet> model) {
		setTitle("Pet List Page");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(300, 100, 500, 400);
		
		panel = new JPanel();
		setContentPane(panel);
		getContentPane().setLayout(null);
		
		this.modelList = model;
		list = new JList<>(model);
		list.setBounds(26, 39, 435, 237);
		panel.add(list);
		
		addButton = new JButton("Add a Pet");
		addButton.setBounds(26, 300, 112, 21);
		panel.add(addButton);

		adoptButton = new JButton("Adopt Selected");
		adoptButton.setBounds(136, 300, 112, 21);
		panel.add(adoptButton);
		
		deleteButton = new JButton("Remove Selected");
		deleteButton.setBounds(246, 300, 112, 21);
		panel.add(deleteButton);
		
		viewButton = new JButton("View Selected");
		viewButton.setBounds(356, 300, 112, 21);
		panel.add(viewButton);
		
		comboBox = new JComboBox();
		comboBox.setBounds(232, 332, 29, 21);
		panel.add(comboBox);
		
		
	}
	
	/**
	 * adds action listener to delete button
	 * @param actionListener
	 */
	public void addActionListenerToDeleteUserButton(ActionListener actionListener) {
		deleteButton.addActionListener(actionListener);
	}
	
	/**
	 * adds action listener to view button
	 * @param actionListener
	 */
	public void addActionListenerToViewPetButton(ActionListener actionListener) {
		viewButton.addActionListener(actionListener);
	}
	
	/**
	 * adds action listener to addPet button
	 * @param actionListener
	 */
	public void addActionListenerToAddPetButton(ActionListener actionListener) {
		addButton.addActionListener(actionListener);
	}
	
	/**
	 * returns petList
	 * @return
	 */
	public DefaultListModel<Pet> getPetList(){
		return (DefaultListModel<Pet>)list.getModel();
	}
	
	/**
	 * returns selected index
	 * @return
	 */
	public int getSelectedPetIndex() {
		System.out.println("Selected user index: " + list.getSelectedIndex());
		return list.getSelectedIndex();
	}
	
	/**
	 * returns actual object that is selected
	 * @return
	 */
	public Pet getSelectedPet() {
	    return list.getSelectedValue();
	}
}
