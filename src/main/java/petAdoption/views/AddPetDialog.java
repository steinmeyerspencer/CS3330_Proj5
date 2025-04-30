package petAdoption.views;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AddPetDialog extends JDialog{
	private JTextField idField;
	private JTextField nameField;
    private JTextField typeField;
    private JTextField speciesField;
    private JTextField ageField;
    private JCheckBox adoptedCheckBox;
    private JButton submitButton;
    
    public AddPetDialog(JFrame petListView) {
    	super(petListView, "Add New Pet", true);
    	setSize(300, 200);
        setLocationRelativeTo(petListView);
        setLayout(new GridLayout(4, 2, 10, 10));
    	
    	add(new JLabel("ID:"));
        idField = new JTextField();
        add(idField);
    	
    	add(new JLabel("Name:"));
        nameField = new JTextField();
        add(nameField);
        
        add(new JLabel("Type:"));
        typeField = new JTextField();
        add(typeField);

        add(new JLabel("Species:"));
        speciesField = new JTextField();
        add(speciesField);
        
        add(new JLabel("Age:"));
        ageField = new JTextField();
        add(ageField);
        
        add(new JLabel("Adopted:"));
        adoptedCheckBox = new JCheckBox();
        add(adoptedCheckBox);

        submitButton = new JButton("Add Pet");
        add(new JLabel());
        add(submitButton);
        
        
	}
    
    public String getNameInput() {
        return nameField.getText().trim();
    }

    public String getSpeciesInput() {
        return speciesField.getText().trim();
    }

    public int getAgeInput() throws NumberFormatException {
        return Integer.parseInt(ageField.getText().trim());
    }
    
    public String getIDInput() throws NumberFormatException {
        return idField.getText();
    }
    
    public String getTypeInput() {
    	return typeField.getText();
    }
    
    public boolean getAdoptedInput() {
        return adoptedCheckBox.isSelected();
    }

    public void addSubmitListener(ActionListener listener) {
        submitButton.addActionListener(listener);
    }

    public void showDialog() {
        setVisible(true);
    }
}
    


