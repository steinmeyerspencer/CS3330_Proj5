package petAdoption.views;

import javax.swing.JFrame;
import javax.swing.JPanel;

import petAdoption.petModels.Pet;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class PetListView extends JFrame{
	
	private JPanel panel;
	private JList<Pet> list;
	private JButton addButton;
	private JButton adoptButton;
	private JButton removeButton;
	private JButton deleteButton;
	private DefaultListModel<Pet> modelList;

	
	
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
		
		removeButton = new JButton("Remove Selected");
		removeButton.setBounds(246, 300, 112, 21);
		panel.add(removeButton);
		
		deleteButton = new JButton("Delete Selected");
		deleteButton.setBounds(356, 300, 112, 21);
		panel.add(deleteButton);
		
		
	}
	public void addActionListenerToDeleteUserButton(ActionListener actionListener) {
		deleteButton.addActionListener(actionListener);
	}
	
	public DefaultListModel<Pet> getPetList(){
		return (DefaultListModel<Pet>)list.getModel();
	}
	
	public int getSelectedPet() {
		System.out.println("Selected user index: " + list.getSelectedIndex());
		return list.getSelectedIndex();
	}
}
